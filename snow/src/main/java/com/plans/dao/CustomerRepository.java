package com.plans.dao;

/**
 * Spring Data JPA
 */

import com.plans.entity.Customer;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    @Query("Select * from journey where name=?0 allow filtering")
    List<Customer> findJourneyByName(String name);

    @Query("Select * from journey")
    List<Customer> findAllJourneys();
}
