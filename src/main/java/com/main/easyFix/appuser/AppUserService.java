package com.main.easyFix.appuser;

import com.main.easyFix.utils.EmailValidator;
import com.main.easyFix.security.PermissionValidator;
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

  public void register(Authentication authentication, AppUser appUser) throws IllegalAccessException {
    if (!PermissionValidator.isAdmin(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    if (!emailValidator.test(appUser.getEmail())) {
      throw new IllegalStateException("Invalid email address");
    }

    boolean emailInUse = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
    if (emailInUse) {
      throw new IllegalStateException("A customer with this email already exists");
    }

    String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
    appUser.setPassword(encodedPassword);

    appUserRepository.save(appUser);
    appUserRepository.enableAppUser(appUser.getEmail());
  }

  public void remove(Authentication authentication, Long id) throws IllegalAccessException {
    if (!PermissionValidator.isAdmin(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }
    appUserRepository.delete(loadUserById(id));
  }
}
