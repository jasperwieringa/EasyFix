package com.main.easyFix.appuser;

import com.main.easyFix.utils.EmailValidator;
import com.main.easyFix.utils.PermissionValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
  private final static String USER_NOT_FOUND_MSG = "Employee with %s: %s, not found";
  private final AppUserRepository appUserRepository;
  private final EmailValidator emailValidator;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return appUserRepository.findByEmail(email).orElseThrow(() ->
      new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, "email", email)));
  }

  public AppUser loadUserById(Long id) throws UsernameNotFoundException {
    return appUserRepository.findById(id).orElseThrow(() ->
      new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, "id", id)));
  }

  public Object listAllEmployees() {
    return appUserRepository.findAll();
  }

  public String register(Authentication authentication, AppUser appUser) {
    if (!PermissionValidator.isAdmin(authentication)) {
      return "Permission denied";
    }

    if (!emailValidator.test(appUser.getEmail())) {
      return "Invalid email address";
    }

    boolean emailInUse = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
    if (emailInUse) {
      return "This email address is already taken";
    }

    String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
    appUser.setPassword(encodedPassword);

    appUserRepository.save(appUser);
    appUserRepository.enableAppUser(appUser.getEmail());
    return "OK";
  }

  public String remove(Authentication authentication, Long id) {
    if (!PermissionValidator.isAdmin(authentication)) {
      return "Permission denied";
    }

    appUserRepository.delete(loadUserById(id));
    return "OK";
  }
}
