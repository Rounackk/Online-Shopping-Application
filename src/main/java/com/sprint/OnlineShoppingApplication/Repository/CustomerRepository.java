package com.sprint.OnlineShoppingApplication.Repository;

import com.sprint.OnlineShoppingApplication.model.Customer;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

//    @Query("from Customer c where c.address in (from Address a where a.city=:location)")
    @Query("from Customer c inner join c.address a where a.city = :location ")
    public List<Customer> findByLocation(@Param("location") String location);
}
