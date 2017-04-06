package com.sfx.gpcalc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sfx.gpcalc.model.Account;
import com.sfx.gpcalc.util.Constant;


public class AccountDao {
	
	private static JdbcConnectionSource connectionSource = null;
	private static Dao accDao = null;
	
	public static JdbcConnectionSource connectDb() throws Exception{
		
		// this uses h2 by default but change to match your database
        String databaseUrl = "jdbc:postgresql://localhost:5433/gpa_calculator";
        // create a connection source to our database
        ConnectionSource connectionSource =
                new JdbcConnectionSource(Constant.getServerUrl(), Constant.USERNAME, Constant.PASSWORD);
        return (JdbcConnectionSource) connectionSource;

        
		
	}
	
	public Dao instantiateDao() throws Exception{
		connectionSource = connectDb();
		// instantiate the dao
        Dao<Account, String> accDao =
            DaoManager.createDao(connectionSource, Account.class);
        return (Dao) accDao;
	}
	
	public void createTable() throws Exception{
		connectionSource = connectDb();
		TableUtils.createTableIfNotExists(connectionSource, Account.class);
	}
	
	public void dropTable() throws Exception{
		connectionSource = connectDb();
		TableUtils.dropTable(connectionSource, Account.class, true);
	}
	
	public Boolean addUser(String username, String password, String email) {
		Boolean result = null;
		Account account = new Account();
		account.setName(username);
		account.setPassword(password);
		account.setEmail(email);
		account.setGpa(0.0);
		
		//get the dao from the instantiateDao method 
		try {
			accDao = instantiateDao();
			accDao.create(account);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Boolean saveGpa(String username, double gpa) {
		Boolean result = null;
		
		try {
			accDao = instantiateDao();
			UpdateBuilder<Account, String> updateBuilder = accDao.updateBuilder();
			// set the criteria like you would a QueryBuilder
			updateBuilder.where().eq("name", username);
			// update the value of your field(s)
			updateBuilder.updateColumnValue("gpa" /* column */, gpa /* value */);
			updateBuilder.update();
			
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public double getGpa(String username) {
		double result = 0.0;
		Account account = new Account();
		
		try {
			account = (Account) accDao.queryForId(username);
			result = account.getGpa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public Boolean checkUser(String username, String password) throws Exception{
		Account account2;
		accDao = instantiateDao();
		Boolean result = null;
		try {
			account2 = (Account) accDao.queryForId(username);
			
			if(account2.getPassword().equals(password)){
	        	result = true;
	        }else{
	        	result = false;
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = false;
		}
		return result;
	}
	
	public void closeConnection() throws Exception{
		connectionSource = connectDb();
		connectionSource.close();
	}
	
}
