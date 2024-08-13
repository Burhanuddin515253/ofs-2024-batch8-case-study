package com.ofss.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ofss.main.domain.Account;



public class AccountRepoImpl implements AccountRepo{

    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/inb";
    private static final String userName = "root";;
    private static final String password = "root";

    // connect to database
    private Connection connection = null;
    //store and execute query
    private PreparedStatement preparedStatement = null;
    // store result retrieved from database
    private ResultSet resultSet = null;


    private static final String INSERT_NEW_ACCOUNT = "INSERT INTO Account(customer_id, account_type,account_rate,account_balance,account_minimum_balance,overdraft_amount,account_status) VALUES (?,?,?,?,?,?,?)";
    private static final String GET_ALL_ACCOUNT = "Select * from Account where customer_id=? AND account_status = ?";


    @Override
    public boolean newAccount(int customer_id, String account_type, int overdraft_amount) {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement(INSERT_NEW_ACCOUNT);
            preparedStatement.setInt(1,customer_id);
            preparedStatement.setString(2,account_type);
            preparedStatement.setDouble(3,account_type.equalsIgnoreCase("savings") ? 4.5 : 0);
            preparedStatement.setDouble(4,account_type.equalsIgnoreCase("savings") ? 1000 : 0);
            preparedStatement.setDouble(5,account_type.equalsIgnoreCase("savings") ? 1000 : 0);
            preparedStatement.setInt(6,account_type.equalsIgnoreCase("savings") ? 0 : overdraft_amount);
            preparedStatement.setString(7,"inactive");


            int rowCount= preparedStatement.executeUpdate();

            if (rowCount > 0) {
                return true;
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
        return false;
    }
    
    @Override
    public List<Account> getAccounts(int customer_id) {

        List<Account> accountList = new ArrayList<>();
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement(GET_ALL_ACCOUNT);
            preparedStatement.setInt(1, customer_id);
            preparedStatement.setString(2, "inactive");
            resultSet = preparedStatement.executeQuery();
            System.out.println("DATABASE CONNECTED");
            while(resultSet.next()){
                //int customer_id = resultSet.getInt("customer_id");
                int account_id=resultSet.getInt("account_id");
                String account_type= resultSet.getString("account_type");
                Double account_rate= resultSet.getDouble("account_rate");
                Double account_balance= resultSet.getDouble("account_balance");
                Double account_minimum_balance= resultSet.getDouble("account_minimum_balance");
                String account_status = resultSet.getString("account_status");
                int overdraft_amount = resultSet.getInt("overdraft_amount");

                Account account = new Account(account_id, account_type, account_rate, account_balance, account_minimum_balance, account_status, overdraft_amount);
                accountList.add(account);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
            e.printStackTrace();
        }
        
        return accountList;
    }

    

    


}
