package com.instacom.assessment.Assessment;

import com.instacom.assessment.model.Leads;
import com.instacom.assessment.repository.LeadsRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LeadsRepositoryTest {

    @Autowired
    private LeadsRepository leadsRepository;
    // JUnit test for saveLaed
    @Test
    @Rollback(false)
    void saveLeadTest(){
        //Here we can test new user creation
        Leads lead = new Leads();
        lead.setFirstName("Sovenga");
        lead.setLastName("Ngoves");
        leadsRepository.save(lead);
        assertThat(lead.getId()).isGreaterThan(0);
    }
    @Test
    public void testFindProductByName() {
        long n = 40;
        Optional<Leads> lead = leadsRepository.findById(n);
        assertThat(lead.isPresent());
    }
    @Test
    public void testListAllLeads() {
        List<Leads> leads = (List<Leads>) leadsRepository.findAll();
        assertThat(leads).size().isGreaterThan(0);
    }
    @Test
    public void testListUserLeads() {
        //here we can test with any username
        String username = "wayne";
        List<Leads> leads = (List<Leads>) leadsRepository.getUserLeads(username);
        assertThat(leads).size().isGreaterThan(0);
    }
}
