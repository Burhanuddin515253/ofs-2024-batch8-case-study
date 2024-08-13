package com.ofss.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TransactionRepo {
    public String transact(int payee_account_id, int payer_account_id, int amount, String type);
}
