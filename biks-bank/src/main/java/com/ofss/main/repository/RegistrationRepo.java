package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.*;

@Repository
public interface RegistrationRepo extends CrudRepository<Customer, Integer>{	
	List<Customer> findByCustomerLoginId(String customer_login_id);
}
