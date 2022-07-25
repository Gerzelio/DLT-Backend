package dlt.dltbackendmaster.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dlt.dltbackendmaster.domain.Beneficiaries;
import dlt.dltbackendmaster.domain.NumericSequence;
import dlt.dltbackendmaster.domain.References;
import dlt.dltbackendmaster.domain.ReferencesServices;
import dlt.dltbackendmaster.domain.ReferencesServicesId;
import dlt.dltbackendmaster.domain.Services;
import dlt.dltbackendmaster.service.DAOService;

@RestController
@RequestMapping("/api/references")
public class ReferencesController
{
    private final DAOService service;

    @Autowired
    public ReferencesController(DAOService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<References>> getall() {
        try {
            List<References> references = service.getAll(References.class);
            return new ResponseEntity<>(references, HttpStatus.OK);
        } catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{Id}", produces = "application/json")
    public ResponseEntity<References> get(@PathVariable Integer Id) {

        if (Id == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
        	References references = service.find(References.class, Id);
            return new ResponseEntity<>(references, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(consumes = "application/json")
    public ResponseEntity<References> save(@RequestBody References reference) {

        if (reference == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
        	reference.setDateCreated(new Date());
            
            service.Save(reference);
            
            List<ReferencesServices> registeredServices = new ArrayList<ReferencesServices>();
            
            for(ReferencesServices services: reference.getReferencesServiceses()) {
            	services.setId(new ReferencesServicesId());
            	services.getId().setReferenceId(reference.getId());
            	services.getId().setServiceId(services.getServices().getId());
            	services.setDateCreated(new Date());
            	service.Save(services);
            	registeredServices.add(services);
            }
            
            reference.setReferencesServiceses(Set.copyOf(registeredServices));
           
            return new ResponseEntity<>(reference, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(consumes = "application/json")
    public ResponseEntity<References> update(@RequestBody References reference) {

        if (reference == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
        	reference.setDateUpdated(new Date());
            
            service.update(reference);
            
            //remove all previous entries 
            service.UpdateEntitiesByNamedQuery("ReferencesServices.removeByReferenceId", reference.getId());
            
            //save new ones
            List<ReferencesServices> registeredServices = new ArrayList<ReferencesServices>();
            
            for(ReferencesServices services: reference.getReferencesServiceses()) {
            	services.setId(new ReferencesServicesId());
            	services.getId().setReferenceId(reference.getId());
            	services.getId().setServiceId(services.getServices().getId());
            	services.setDateCreated(new Date());
            	service.Save(services);
            	registeredServices.add(services);
            }
            
            reference.setReferencesServiceses(Set.copyOf(registeredServices));
           
            return new ResponseEntity<>(reference, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
}
