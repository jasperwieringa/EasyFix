package com.main.easyFix.parts;

import com.main.easyFix.security.PermissionValidator;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PartService {
  private final static String PART_NOT_FOUND_MSG = "Part with %s: %s, not found";
  private final PartRepository partRepository;

  public Part loadPartById(int id) throws NotFoundException {
    return partRepository.findById(id).orElseThrow(() ->
      new NotFoundException(String.format(PART_NOT_FOUND_MSG, "id", id)));
  }

  public List<Part> listAllParts() {
    return partRepository.findAll();
  }

  public void save(Authentication authentication, Part part) throws IllegalAccessException {
    if (!PermissionValidator.isBackoffice(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }
    partRepository.save(part);
  }

  public void update(Authentication authentication, Part part) throws IllegalAccessException {
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
