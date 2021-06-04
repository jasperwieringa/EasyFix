package com.main.easyFix.registration;

import com.main.easyFix.appuser.AppUser;
import com.main.easyFix.appuser.AppUserDepartment;
import com.main.easyFix.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
  private final AppUserService appUserService;
  private final EmailValidator emailValidator;

  public String register(RegistrationRequest request) {
    String firstName = request.getFirstName();
    String lastName = request.getLastName();
    String email = request.getEmail();
    String password = request.getPassword();
    AppUserDepartment appUserDepartment = request.getAppUserDepartment();
    boolean isValidEmail = emailValidator.test(email);

    if (!isValidEmail) {
      throw new IllegalStateException("email not valid");
    }

    return appUserService.signUpUser(
      new AppUser(firstName, lastName, email, password, appUserDepartment)
    );
  }
}
