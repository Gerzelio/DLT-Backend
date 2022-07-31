package dlt.dltbackendmaster.security.utils;

import java.util.List;
import java.util.stream.Collectors;

import dlt.dltbackendmaster.domain.Beneficiaries;
import dlt.dltbackendmaster.domain.BeneficiariesInterventions;
import dlt.dltbackendmaster.domain.SubServices;

/**
 * Rules for Packages Completion
 * 
 * @author Hamilton Mutaquiha
 */
public class PackageCompletionRules
{
    public static boolean startedService(Beneficiaries beneficiary) {

        String ageBand = Utility.determineAgeBand(beneficiary);
        List<Integer> subServices = beneficiary.getBeneficiariesInterventionses()
                                               .stream()
                                               .map(BeneficiariesInterventions::getSubServices)
                                               .collect(Collectors.toList())
                                               .stream()
                                               .map(SubServices::getId)
                                               .collect(Collectors.toList());

        if (ageBand.equals("9-14")) {

            if (beneficiary.getVbltIsStudent() == 1) {
                return ServiceCompletionRules.startedAvanteEstudante(subServices)
                       || ServiceCompletionRules.startedSAAJEducationSessions(subServices)
                       || ServiceCompletionRules.startedPostViolenceCare_US(subServices)
                       || ServiceCompletionRules.startedPostViolenceCare_CM(subServices);
            } else {
                return ServiceCompletionRules.startedAvanteRapariga(subServices)
                       || ServiceCompletionRules.startedSAAJEducationSessions(subServices)
                       || ServiceCompletionRules.startedPostViolenceCare_US(subServices)
                       || ServiceCompletionRules.startedPostViolenceCare_CM(subServices);

            }

        } else {

        }
        return false;
    }

    public static boolean completedPrimaryService(Beneficiaries beneficiary) {

        String ageBand = Utility.determineAgeBand(beneficiary);
        List<Integer> subServices = beneficiary.getBeneficiariesInterventionses()
                                               .stream()
                                               .map(BeneficiariesInterventions::getSubServices)
                                               .collect(Collectors.toList())
                                               .stream()
                                               .map(SubServices::getId)
                                               .collect(Collectors.toList());

        if (ageBand.equals("9-14")) {

            if (beneficiary.getVbltIsStudent() == 1) { // AVANTE ESTUDANTE
                return ServiceCompletionRules.completedAvanteEstudante(subServices)
                       || ServiceCompletionRules.completedSAAJEducationSessions(subServices)
                       || ServiceCompletionRules.completedFinancialLiteracy(subServices)
                       || (beneficiary.getVbltSexuallyActive() == 1
                           && (ServiceCompletionRules.completedHIVTestingServices(subServices)
                               || ServiceCompletionRules.completedCondomsPromotionOrProvision(subServices)));
            } else { // AVANTE RAPARIGA
                return ServiceCompletionRules.completedAvanteRapariga(subServices)
                       || ServiceCompletionRules.completedSAAJEducationSessions(subServices)
                       || ServiceCompletionRules.completedFinancialLiteracy(subServices)
                       || (beneficiary.getVbltSexuallyActive() == 1
                           && (ServiceCompletionRules.completedHIVTestingServices(subServices)
                               || ServiceCompletionRules.completedCondomsPromotionOrProvision(subServices)));
            }

        } else { // 15-24 Years
            return ServiceCompletionRules.completedCondomsPromotionOrProvision(subServices)
                   || ServiceCompletionRules.completedGuiaFacilitacao(subServices)
                   || ServiceCompletionRules.completedHIVTestingServices(subServices)
                   || ServiceCompletionRules.completedFinancialLiteracy(subServices);
        }
    }

    public static boolean completedPrimaryPackage(Beneficiaries beneficiary) {

        String ageBand = Utility.determineAgeBand(beneficiary);
        List<Integer> subServices = beneficiary.getBeneficiariesInterventionses()
                                               .stream()
                                               .map(BeneficiariesInterventions::getSubServices)
                                               .collect(Collectors.toList())
                                               .stream()
                                               .map(SubServices::getId)
                                               .collect(Collectors.toList());

        if (ageBand.equals("9-14")) {

            if (beneficiary.getVbltIsStudent() == 1) { // AVANTE ESTUDANTE
                return ServiceCompletionRules.completedAvanteEstudante(subServices)
                       && ServiceCompletionRules.completedSAAJEducationSessions(subServices)
                       && ServiceCompletionRules.completedFinancialLiteracy(subServices)
                       && (beneficiary.getVbltSexuallyActive() == 0
                           || beneficiary.getVbltSexuallyActive() == 1
                              && (ServiceCompletionRules.completedHIVTestingServices(subServices)
                                  && ServiceCompletionRules.completedCondomsPromotionOrProvision(subServices)));
            } else { // AVANTE RAPARIGA
                return ServiceCompletionRules.completedAvanteRapariga(subServices)
                       && ServiceCompletionRules.completedSAAJEducationSessions(subServices)
                       && ServiceCompletionRules.completedFinancialLiteracy(subServices)
                       && (beneficiary.getVbltSexuallyActive() == 0
                           || beneficiary.getVbltSexuallyActive() == 1
                              && (ServiceCompletionRules.completedHIVTestingServices(subServices)
                                  && ServiceCompletionRules.completedCondomsPromotionOrProvision(subServices)));
            }

        } else { // 15-24 Years
            return ServiceCompletionRules.completedCondomsPromotionOrProvision(subServices)
                   && ServiceCompletionRules.completedGuiaFacilitacao(subServices)
                   && ServiceCompletionRules.completedHIVTestingServices(subServices)
                   && ServiceCompletionRules.completedFinancialLiteracy(subServices);
        }
    }

    public static boolean startedServiceButDidNotComplete(Beneficiaries beneficiary) {
        return startedService(beneficiary) && !completedPrimaryService(beneficiary);
    }

    public static boolean completedServiceButNotPrimaryPackage(Beneficiaries beneficiary) {
        return completedPrimaryService(beneficiary) && !completedPrimaryPackage(beneficiary);
    }

    public static boolean completedSecondaryService(Beneficiaries beneficiary) {

        String ageBand = Utility.determineAgeBand(beneficiary);
        List<Integer> subServices = beneficiary.getBeneficiariesInterventionses()
                                               .stream()
                                               .map(BeneficiariesInterventions::getSubServices)
                                               .collect(Collectors.toList())
                                               .stream()
                                               .map(SubServices::getId)
                                               .collect(Collectors.toList());

        boolean satisfiesCommonServices = ServiceCompletionRules.completedContraceptionsPromotionOrProvision(subServices)
                                          || ServiceCompletionRules.completedPostViolenceCare_US(subServices)
                                          || ServiceCompletionRules.completedPostViolenceCare_CM(subServices)
                                          || ServiceCompletionRules.completedOtherSAAJServices(subServices);

        if (ageBand.equals("9-14")) {
            return ServiceCompletionRules.hadScoolAllowance(subServices) || satisfiesCommonServices
                   || (beneficiary.getVbltSexuallyActive() == 0
                       && (ServiceCompletionRules.completedHIVTestingServices(subServices)
                           || ServiceCompletionRules.completedCondomsPromotionOrProvision(subServices)));
        } else { // 15-24 Year
            return (ageBand.equals("15-19") && ServiceCompletionRules.hadScoolAllowance(subServices))
                   || satisfiesCommonServices || ServiceCompletionRules.completedPrep(subServices);
        }
    }
}
