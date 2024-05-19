package com.instacom.assessment.repository;

import com.instacom.assessment.model.Leads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LeadsRepository extends JpaRepository<Leads, Long> {
    //Here we use JPQL to make custom sql query
    String GET_USER_LEADS = "SELECT * from Leads where username =?";
    @Query(value = GET_USER_LEADS, nativeQuery = true)
    List<Leads> getUserLeads(String username);

    //Here we use JPQL to make custom sql query
    String GET_UNIQUE_DATES = "SELECT distinct created_at as created_at from Leads";
    @Transactional
    @Query(GET_UNIQUE_DATES)
    List<String> findUniqueDates();

}