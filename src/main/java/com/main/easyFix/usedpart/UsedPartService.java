package com.main.easyFix.usedpart;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.security.PermissionValidator;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsedPartService {
  private final static String REL_NOT_FOUND_MSG = "Relation with %s: %s, not found";
  private final UsedPartRepository usedPartRepository;

  public UsedPart loadUsedPartById(int id) throws NotFoundException {
    return usedPartRepository.findById(id).orElseThrow(() ->
      new NotFoundException(String.format(REL_NOT_FOUND_MSG, "id", id)));
  }

  public List<UsedPart> loadUsedPartsByAppointment(Appointment appointment) {
    return usedPartRepository.findByAppointment(appointment);
  }

  public void removeAll(Authentication authentication, Appointment appointment) throws IllegalAccessException, NotFoundException {
    if (!PermissionValidator.isAdmin(authentication)) {
      throw new IllegalAccessException("Permission denied");
    }

    // Remove the associated used parts
    List<UsedPart> usedParts = loadUsedPartsByAppointment(appointment);
    for (UsedPart usedPart : usedParts) {
      usedPartRepository.delete(loadUsedPartById(usedPart.getId()));
    }
  }
}
