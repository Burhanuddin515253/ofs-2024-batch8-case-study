package com.ofss.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ofss.main.domain.*;

public class CHequeRepoImpl implements ChequeRepo{

    final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/inb";
    private static final String userName = "root";;
    private static final String password = "root";

    // connect to database
    private Connection connection = null;
    // store and execute query
    private PreparedStatement preparedStatement = null;
    // store result retrieved from database
    private ResultSet resultSet = null;

    private static final String INSERT_NEW_CHEQUE = "INSERT INTO Cheque(cheque_status, payee_account_id, payer_account_id, cheque_amount,cheque_date) VALUES (?,?,?,?,?)";
    @Override
    public String cheque(int payee_cheque_id, int payer_cheque_id, int cheque_amount) {

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement(INSERT_NEW_CHEQUE);
            preparedStatement.setString(1,"issued");
            preparedStatement.setInt(2,payee_cheque_id);
            preparedStatement.setInt(3,payer_cheque_id);
            preparedStatement.setInt(4,cheque_amount);
            preparedStatement.setString(5,"2024-07-18 10:58:22");


            int rowCount= preparedStatement.executeUpdate();

            if (rowCount > 0) {
                return "Cheque Issued Succesfully";
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection");
                e.printStackTrace();
            }
        }
        return null;
    }
}
