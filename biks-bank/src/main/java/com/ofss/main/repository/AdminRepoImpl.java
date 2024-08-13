package com.ofss.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.ofss.main.domain.*;

public class AdminRepoImpl implements AdminRepo{
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

    private static final String SELECT_ONE_ADMIN = "SELECT * FROM Admin WHERE admin_login_id= ?";
    private static final String SELECT_ONE_CUSTOMER = "SELECT * FROM Customer WHERE customer_login_id= ?";
    private final String UPDATE_STATUS_ATTEMPTS = "UPDATE Customer SET login_attempts=? , customer_status=? WHERE customer_login_id = ?";
    private static final String GET_ALL_ACCOUNT = "Select * from Account where customer_id=? AND account_status = ?";
    private final String UPDATE_ACCOUNT_STATUS = "UPDATE Account SET account_status=? WHERE account_id=?";
    private final String GET_ALL_CHEQUES = "Select * from Cheque WHERE cheque_status=?";
    private final String GET_ACCOUNT_TYPE = "Select a.account_type from Account a JOIN Cheque c ON a.account_id=c.payee_account_id where c.cheque_id=?";
    private final String UPDATE_CHEQUE_STATUS = "UPDATE Cheque SET cheque_status=? WHERE cheque_id=?";

    
    @Override
    public String adminLogin(String admin_login_id, String admin_password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");
            if(connection!=null){
                System.out.println("Connected to db.");
            }
            preparedStatement = connection.prepareStatement(SELECT_ONE_ADMIN);
            preparedStatement.setString(1, admin_login_id);
            resultSet = preparedStatement.executeQuery();
            String result = null;
            if(resultSet.next()){
                String pass = resultSet.getString("admin_password");
                if(pass.equals(admin_password)){
                    return "Login Successful !";
                }else{
                    return "Password Incorrect";
                }
            }else{
                result = "Admin does not exist.";
                return result;
            }
        } catch (ClassNotFoundException | SQLException e) {
            return e.toString();
        }
    }


    @Override
    public String unblock(String customer_login_id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");
            if(connection!=null){
                System.out.println("Connected to db.");
            }
            preparedStatement = connection.prepareStatement(SELECT_ONE_CUSTOMER);
            preparedStatement.setString(1, customer_login_id);
            resultSet = preparedStatement.executeQuery();
            String result = null;
            if(resultSet.next()){
                int attempts = resultSet.getInt("login_attempts");
                String status = resultSet.getString("customer_status");
                if(status.equals("inactive")){
                    status = "active";
                    attempts = 0;
                    preparedStatement = connection.prepareStatement(UPDATE_STATUS_ATTEMPTS);
                    preparedStatement.setInt(1, attempts);
                    preparedStatement.setString(2, status);
                    preparedStatement.setString(3,customer_login_id);
                    preparedStatement.execute();
                }
            }
            return null;
        } catch (ClassNotFoundException | SQLException e) {
            return e.toString();
        }
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


    @Override
    public String approve(Account account) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");
            if(connection!=null){
                System.out.println("Connected to db.");
            }
            preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_STATUS);
            String status ="active";
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, account.getAccount_id());
            preparedStatement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            return e.toString();
        }
        return null;
    }


    @Override
    public List<Cheque> getCheques() {
        List<Cheque> chequeList = new ArrayList<>();
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement(GET_ALL_CHEQUES);
            preparedStatement.setString(1, "issued");
            resultSet = preparedStatement.executeQuery();
            System.out.println("DATABASE CONNECTED");
            while(resultSet.next()){
                int cheque_id =resultSet.getInt("cheque_id");
                int cheque_payee_account = resultSet.getInt("payee_account_id");
                int cheque_payer_account = resultSet.getInt("payer_account_id");
                int cheque_amount = resultSet.getInt("cheque_amount");
                Account a_payee=new Account(cheque_payee_account);
                Account a_payer=new Account(cheque_payer_account);
                Cheque c = new Cheque();
                c.setCheque_id(cheque_id);
                c.setCheque_payee_account(a_payee);
                c.setCheque_payer_account(a_payer);
                c.setCheque_amount(cheque_amount);
                chequeList.add(c);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
            e.printStackTrace();
        }
        
        return chequeList;

    }


    @Override
    public String getAccountType(int account_id) {
        try{
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement(GET_ACCOUNT_TYPE);
            preparedStatement.setInt(1, account_id);
            resultSet = preparedStatement.executeQuery();
            System.out.println("DATABASE CONNECTED");
            if(resultSet.next()){
                String account_type =resultSet.getString("account_type");
                return account_type;
            }
        }catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String clearCheque(int cheque_id, boolean flag) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");
            if(connection!=null){
                System.out.println("Connected to db.");
            }
            preparedStatement = connection.prepareStatement(UPDATE_CHEQUE_STATUS);
            if(flag){
                preparedStatement.setString(1, "approved");
            }else{
                preparedStatement.setString(1, "blocked");
            }
            
            preparedStatement.setInt(2, cheque_id);
            preparedStatement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            return e.toString();
        }
        return null;
    }

    

    

    



    

    
}
