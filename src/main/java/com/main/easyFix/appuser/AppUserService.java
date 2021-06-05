package com.main.easyFix.appuser;

import com.main.easyFix.utils.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
  private final static String USER_NOT_FOUND_MSG = "Employee with email: %s, not found";
  private final AppUserRepository appUserRepository;
  private final EmailValidator emailValidator;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return appUserRepository.findByEmail(email).orElseThrow(() ->
      new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
  }

  public Object listAllEmployees() {
    return appUserRepository.findAll();
  }

  public AppUser register(AppUser appUser) {
    String firstName = appUser.getFirstName();
    String lastName = appUser.getLastName();
    String email = appUser.getEmail();
    String password = appUser.getPassword();
    AppUserDepartment appUserDepartment = appUser.getAppUserDepartment();

    return signUpUser(
      new AppUser(firstName, lastName, email, password, appUserDepartment)
    );
  }

  public AppUser signUpUser(AppUser appUser) {
    String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
    appUser.setPassword(encodedPassword);

    appUserRepository.save(appUser);
    appUserRepository.enableAppUser(appUser.getEmail());
    return appUser;
  }

  public String validateRegistration(AppUser appUser) {
    String message = "";

    boolean isValidEmail = emailValidator.test(appUser.getEmail());
    boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

    if (!isValidEmail) {
      message = "Invalid email address";
    }

    if (userExists) {
      message = "This email address is already taken";
    }

    return message;
  }
}
