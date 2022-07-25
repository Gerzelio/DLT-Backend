package dlt.dltbackendmaster.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dlt.dltbackendmaster.domain.Users;
import dlt.dltbackendmaster.security.EmailSender;
import dlt.dltbackendmaster.security.utils.Utility;
import dlt.dltbackendmaster.service.DAOService;
import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("/users")
public class PasswordUpdateController
{
    private final DAOService service;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    private EmailSender emailSender;

    @Autowired
    public PasswordUpdateController(DAOService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @PutMapping(path = "/update-password", produces = "application/json")
    public ResponseEntity<Users> updatePassword(HttpServletRequest request, @RequestBody Users users) {

        Users user = service.GetUniqueEntityByNamedQuery("Users.findByUsername", users.getUsername());

        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            user.setRecoverPassword(passwordEncoder.encode(users.getRecoverPassword()));
            user.setNewPassword(0);
            user.setIsEnabled(Byte.valueOf("0"));
            String token = RandomString.make(45);
            user.setRecoverPasswordToken(token);
            Users updatedUser = service.update(user);
            // Generate reset confirmation Link
            String confirmUpdatePasswordLink = Utility.getSiteURL(request) + "/users/confirm-update?token=" + token;
            // Send E-mail
            emailSender.sendEmail(user.getName() + " " + user.getSurname(),
                                  null,
                                  user.getEmail(),
                                  confirmUpdatePasswordLink,
                                  false);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/confirm-update")
    public ResponseEntity<String> confirmPasswordUpdate(HttpServletRequest request, @Param(value = "token") String token) {
        Users user = service.GetUniqueEntityByNamedQuery("Users.findByResetPasswordToken", token);

        if (token == null || user == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            user.setPassword(user.getRecoverPassword());
            user.setIsEnabled(Byte.valueOf("1"));
            user.setRecoverPassword(null);
            user.setRecoverPasswordToken(null);
            Users updatedUser = service.update(user);
            return new ResponseEntity<>("Confirmada a alteração da password do Utilizador " + updatedUser.getName()
                                        + " " + user.getSurname() + "!",
                                        HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
