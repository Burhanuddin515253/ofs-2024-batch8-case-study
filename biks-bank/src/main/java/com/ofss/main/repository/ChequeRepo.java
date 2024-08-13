package com.ofss.main.repository;

public interface ChequeRepo {
    public String cheque(int payee_cheque_id, int payer_cheque_id, int cheque_amount);
}
