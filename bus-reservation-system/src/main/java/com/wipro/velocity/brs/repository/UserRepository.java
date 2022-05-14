package com.wipro.velocity.brs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wipro.velocity.brs.model.Customer;
import com.wipro.velocity.brs.model.CustomerAddress;

public interface UserRepository extends JpaRepository<Customer, Long>{
	
	public Customer findByEmail(String email);
	
	@Query("SELECT new com.wipro.velocity.brs.model.CustomerAddress(c.id,c.email,c.fname,c.lname,"
            + "c.mobile,c.password,c.street,c.pincode,c.city,c.state) "
            + "FROM Customer c INNER JOIN c.address a")
	List<CustomerAddress> fetchDealerInnerJoin();
	

}
