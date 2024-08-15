package com.ofss.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.*;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Integer>{
	public Optional<Admin> findByAdminLoginId(String adminLoginId);
	
}
