package com.ofss.main.service;

import com.ofss.main.repository.CHequeRepoImpl;
import com.ofss.main.repository.ChequeRepo;

public class ChequeServiceImpl implements ChequeService{

    ChequeRepo chequeService = new CHequeRepoImpl();
    @Override
    public String cheque(int payee_cheque_id, int payer_cheque_id, int cheque_amount) {
        return chequeService.cheque(payee_cheque_id, payer_cheque_id, cheque_amount);
    }

    
}
