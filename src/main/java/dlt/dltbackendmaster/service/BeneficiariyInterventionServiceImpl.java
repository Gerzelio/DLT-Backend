package dlt.dltbackendmaster.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dlt.dltbackendmaster.domain.Beneficiaries;
import dlt.dltbackendmaster.domain.BeneficiariesInterventions;
import dlt.dltbackendmaster.domain.ICountIntervention;
import dlt.dltbackendmaster.domain.References;
import dlt.dltbackendmaster.domain.ReferencesServices;
import dlt.dltbackendmaster.domain.ReferencesServicesObject;
import dlt.dltbackendmaster.domain.SubServices;
import dlt.dltbackendmaster.security.utils.ServiceCompletionRules;

/**
 * This class implements the Service interface
 * 
 * @author Francisco da Conceição Alberto Macuácua
 *
 */
@Service
public class BeneficiariyInterventionServiceImpl implements BeneficiariyInterventionService {
	@Autowired
	public DAOService daoService;

	@Override
	public <T> ReferencesServicesObject registerServiceCompletionStatus(BeneficiariesInterventions intervention) {

		SubServices subService = daoService.find(SubServices.class, intervention.getId().getSubServiceId());
		intervention.setSubServices(subService);

		// Actualizar o status dos serviços solicitados
		Beneficiaries beneficiary = daoService.find(Beneficiaries.class, intervention.getBeneficiaries().getId());
		Integer serviceId = subService.getServices().getId();
		List<ReferencesServices> referencesServices = daoService.GetAllEntityByNamedQuery(
				"ReferencesServices.findByBeneficiaryAndService", beneficiary.getId(), serviceId);

		List<References> updatedReferences = new ArrayList<>();

		for (ReferencesServices referenceServices : referencesServices) {

			Integer referenceServiceStatus = ServiceCompletionRules.getReferenceServiceStatus(beneficiary, serviceId);

			if (referenceServiceStatus.intValue() != (referenceServices.getStatus())) {
				referenceServices.setStatus(referenceServiceStatus);
				referenceServices.setDateUpdated(new Date());
				referenceServices.setUpdatedBy(subService.getCreatedBy());
				referenceServices = daoService.update(referenceServices);

				// Actualizar o status da referências
				References reference = referenceServices.getReferences();
				Integer referenceStatus = ServiceCompletionRules.getReferenceStatus(reference);

				if (referenceStatus.intValue() != reference.getStatus()) {
					reference.setStatus(referenceStatus);
					reference.setDateUpdated(new Date());
					reference.setUpdatedBy(subService.getCreatedBy());
					reference = daoService.update(reference);
				}
				updatedReferences.add(reference);
			}
		}
		ReferencesServicesObject referenceServiceObject = new ReferencesServicesObject(intervention, updatedReferences);

		return referenceServiceObject;

	}

	@Override
	public List<BeneficiariesInterventions> findByBeneficiaryId(Integer beneficiaryId) {

		List<BeneficiariesInterventions> beneficiariesInterventions = daoService
				.GetAllEntityByNamedQuery("BeneficiaryIntervention.findByBeneficiaryId", beneficiaryId);

		return beneficiariesInterventions;
	}
	
	@Override
	public List<ICountIntervention> findInterventionsPerBeneficiary() {

		List<ICountIntervention> beneficiariesInterventions = daoService
				.GetAllEntityByNamedQuery("BeneficiaryIntervention.findInterventionsPerBeneficiary");
		
		return beneficiariesInterventions;
	}
}
