package com.ofss.main.service;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Cheque;

@Service
public interface ChequeService {
    //public String cheque(int payee_cheque_id, int payer_cheque_id, int cheque_amount);
	public String createCheque(Cheque cheque);
}
