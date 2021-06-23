package com.main.easyFix.parts;

import com.main.easyFix.security.PermissionValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PartService {
  private final PartRepository partRepository;

  public List<Part> listAllParts() {
    return partRepository.findAll();
  }

  public void add(Authentication authentication, Part part) throws IllegalAccessException {
    if (!PermissionValidator.isBackoffice(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }
    partRepository.save(part);
  }

  public void remove(Authentication authentication, Part part) throws IllegalAccessException {
    if (!PermissionValidator.isBackoffice(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }
    partRepository.delete(part);
  }
}
