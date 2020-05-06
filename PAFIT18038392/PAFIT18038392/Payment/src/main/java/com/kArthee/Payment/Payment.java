package com.kushan.Payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {

	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql://localhost/payment","root","");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 } 
	
	public String insertPayment(String appid, String pname, String amount, String cname)
	{
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {
		 return "Error while connecting to the database for inserting.";
		 }
		 // create a prepared statement
		 String query = " insert into payments(`paymentid`,`appointmentid`,`patientname`,`amount`,`cardname`)"
		 + " values (?, ?, ?, ?, ?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, appid);
		 preparedStmt.setString(3, pname);
		 preparedStmt.setDouble(4, Double.parseDouble(amount));
		 preparedStmt.setString(5, cname);
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 String newPayments = readPayments();
		 output = "{\"status\":\"success\", \"data\": \"" +
		 newPayments + "\"}";
		 }
		 catch (Exception e)
		 {
		 output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 } 
	
	
	public String readPayments()
	{
		 String output = "";
		try
		 {
		 Connection con = connect();
		 if (con == null)
		 {
		 return "Error while connecting to the database for reading.";
		 }
		 // Prepare the html table to be displayed
		 output = "<table border='1'><tr><th>Appointment ID</th>"
		 		+ "<th>Patient Name</th><th>Amount</th>"
				 + "<th>Card Name</th>"
				 + "<th>Update</th><th>Remove</th></tr>";
		 String query = "select * from payments";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String paymentID = Integer.toString(rs.getInt("paymentid"));
		 String appointmentID = rs.getString("appointmentid");
		 String patientName = rs.getString("patientname");
		 String amount = Double.toString(rs.getDouble("amount"));
		 String cardName = rs.getString("cardname"); 
		 
		// Add into the html table
		 output += "<tr><td><input id='hidItemIDUpdate'"
		 		+ "name='hidItemIDUpdate' type='hidden'"
		 		+ "value='" + paymentID + "'>" + appointmentID + "</td>";
		 output += "<td>" + patientName + "</td>";
		 output += "<td>" + amount + "</td>";
		 output += "<td>" + cardName + "</td>";
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update'  class='btnUpdate btn btn-secondary'></td>"
		 		+ "<td><input name='btnRemove' type='button'  value='Remove'  class='btnRemove btn btn-danger' data-itemid='"
				 + paymentID + "'>" + "</td></tr>";
		 }
		 con.close();
		 // Complete the html table
		 output += "</table>";
		 }
		catch (Exception e)
		 {
		 output = "Error while reading the payment.";
		 System.err.println(e.getMessage());
		 }
		return output;
		}

	
	
	public String updatePayment(String ID, String appid, String pname, String amount, String cname)
	{
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {
		 return "Error while connecting to the database for updating.";
		 }
		 // create a prepared statement
		 String query = "UPDATE payments SET appointmentid=?,patientname=?,amount=?,cardname=? WHERE paymentid=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, appid);
		 preparedStmt.setString(2, pname);
		 preparedStmt.setDouble(3, Double.parseDouble(amount));
		 preparedStmt.setString(4, cname);
		 preparedStmt.setInt(5, Integer.parseInt(ID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 String newPayments = readPayments();
		 output = "{\"status\":\"success\", \"data\": \"" +
		 newPayments + "\"}";
		 }
		 catch (Exception e)
		 {
		 output = "{\"status\":\"error\", \"data\":\"Error while updating the payment.\"}";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 } 
	
	public String deletePayment(String paymentID)
	{
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {
		 return "Error while connecting to the database for deleting.";
		 } 
		// create a prepared statement
		 String query = "delete from payments where paymentid=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(paymentID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 String newPayments = readPayments();
		 output = "{\"status\":\"success\", \"data\": \"" +
		 newPayments + "\"}";
		 }
		 catch (Exception e)
		 {
		 output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		


}

