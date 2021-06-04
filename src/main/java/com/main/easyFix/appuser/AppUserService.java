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

  public String register(AppUserRequest request) {
    String firstName = request.getFirstName();
    String lastName = request.getLastName();
    String email = request.getEmail();
    String password = request.getPassword();
    AppUserDepartment appUserDepartment = request.getAppUserDepartment();
    boolean isValidEmail = emailValidator.test(email);

    if (!isValidEmail) {
      throw new IllegalStateException("Incorrect e-mail");
    }

    return signUpUser(
      new AppUser(firstName, lastName, email, password, appUserDepartment)
    );
  }

  public String signUpUser(AppUser appUser) {
    boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

    if (userExists) {
      throw new IllegalStateException("This email address is already taken");
    }

    String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
    appUser.setPassword(encodedPassword);

    appUserRepository.save(appUser);
    appUserRepository.enableAppUser(appUser.getEmail());
    return "Success";
  }
}
