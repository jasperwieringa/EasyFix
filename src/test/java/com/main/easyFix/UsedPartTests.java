package com.main.easyFix;

import com.main.easyFix.appointment.Appointment;
import com.main.easyFix.parts.Part;
import com.main.easyFix.usedpart.UsedPart;
import com.main.easyFix.usedpart.UsedPartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UsedPartTests {
  @Autowired
  private UsedPartRepository usedPartRepository;

  @Autowired
  private TestEntityManager entityManager;

  @Test
  public void testAddOneUsedPart() {
    Part part = entityManager.find(Part.class, 101);
    Appointment appointment = entityManager.find(Appointment.class, 1);

    UsedPart usedPart = new UsedPart();
    usedPart.setAppointment(appointment);
    usedPart.setPart(part);
    usedPart.setQuantity(1);

    UsedPart savedUsedPart = usedPartRepository.save(usedPart);

    assertTrue(savedUsedPart.getId() > 0);
  }

  @Test
  public void testAddMultipleUsedPart() {
    Part part = entityManager.find(Part.class, 10);
    Appointment appointment = entityManager.find(Appointment.class, 1);

    UsedPart usedPart = new UsedPart();
    usedPart.setAppointment(appointment);
    usedPart.setPart(part);
    usedPart.setQuantity(10);

    UsedPart savedUsedPart = usedPartRepository.save(usedPart);

    assertTrue(savedUsedPart.getId() > 0);
  }

  @Test
  public void testGetUsedPartsByAppointment() {
    Appointment appointment = new Appointment();
    appointment.setId(3);

    List<UsedPart> usedParts = usedPartRepository.findByAppointment(appointment);

    assertTrue(usedParts.size() > 0);
  }
}
