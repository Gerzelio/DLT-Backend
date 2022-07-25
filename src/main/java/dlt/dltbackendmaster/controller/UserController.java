package dlt.dltbackendmaster.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dlt.dltbackendmaster.domain.Users;
import dlt.dltbackendmaster.security.EmailSender;
import dlt.dltbackendmaster.security.utils.PasswordGenerator;
import dlt.dltbackendmaster.service.DAOService;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    private final DAOService service;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private EmailSender emailSender;

    @Autowired
    public UserController(DAOService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Users>> getall() {

        try {
            List<Users> users = service.getAll(Users.class);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{Id}", produces = "application/json")
    public ResponseEntity<Users> get(@PathVariable Integer Id) {

        if (Id == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            Users user = service.find(Users.class, Id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Users> save(@RequestBody Users user) {
    	
        if (user == null || user.getPartners() == null || user.getProfiles() == null || user.getUs() == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            String password = PasswordGenerator.generateStrongPassword();
            user.setPassword(passwordEncoder.encode(password));
            user.setDateCreated(new Date());
            user.setIsCredentialsExpired(Byte.valueOf("0"));
            user.setIsExpired(Byte.valueOf("0"));
            user.setIsLocked(Byte.valueOf("0"));
            user.setIsEnabled(Byte.valueOf("1"));
            user.setNewPassword(1);
            Integer userId = (Integer) service.Save(user);
            Users createdUser = service.find(Users.class, userId);

            if(user.getEmail() != null) {
            	String email = user.getEmail();
            	emailSender.sendEmail(user.getUsername(), password, email, null, true);
            }
            
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        } catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Users> update(@RequestBody Users user) {

        if (user == null || user.getPartners() == null || user.getProfiles() == null || user.getUs() == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            user.setDateUpdated(new Date());
            Users updatedUser = service.update(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/change-password", produces = "application/json")
    public ResponseEntity<Users> changePassword(HttpServletRequest request, @RequestBody Users users) {
  
        Users user = service.GetUniqueEntityByNamedQuery("Users.findByUsername", users.getUsername());

        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            user.setNewPassword(0);
            user.setPassword(passwordEncoder.encode(users.getRecoverPassword()));
            Users updatedUser = service.update(user);
            
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
