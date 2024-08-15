package com.ofss.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ofss.main.domain.Cheque;

@Repository
public interface ChequeRepo extends CrudRepository<Cheque, Integer> {
    //public String cheque(int payee_cheque_id, int payer_cheque_id, int cheque_amount);
	public List<Cheque> findByChequeStatus(String status);
}
