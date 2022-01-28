package com.authorImpl.services;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.author.domain.AuthorListDomain;


public class AuthorServiceJdbcUtil  {

	String url = "Jdbc:mysql://localhost:3306/authordetails";
	String userName = "root";
	String password = "1234";
	Statement statement;
	Connection connection;
	
	public void getConnection() throws SQLException {
		
		connection = DriverManager.getConnection(url,userName,password);
		System.out.println("connected");
		statement = connection.createStatement();
		System.out.println("create statement platform");
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	public void createTable() throws Exception{
			getConnection();
			statement.executeUpdate("create table authortable(Author_Id int, Author_name  varchar(255),Gender varchar(20), Birth_year  date, Birth_place  varchar(255), Book_Theme  varchar(255), Books_published_count  int,Last_Book_Publish_Date date)");
				
			System.out.println("author information table created");
		
	}
	
	
	public boolean insertValues(AuthorListDomain person) throws Exception{
		getConnection();
		try {

			PreparedStatement pst = connection.prepareStatement("insert into authortable Values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, person.getAuthorId());
			pst.setString(2, person.getAuthorName());
			pst.setString(3, person.getGender());
			pst.setDate(4, Date.valueOf(person.getBorn()));
			pst.setString(5, person.getBornLocation());
			pst.setString(6, person.getBookTheme());
			pst.setInt(7, person.getNumberOfBooksPublished());
			pst.setDate(8, Date.valueOf(person.getlastBookPublishDate()));
			pst.execute();
			return true;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return false;
   }
   
	/*public void updateValues() throws Exception{
		getConnection();
		
		
		statement.executeUpdate("update authortable set Books_published_count = ? where id = ?");	
		
		System.out.println("update Birth_year in authortable"); 
	
   }*/
	
	public void updateValues(AuthorListDomain person,int bookCount) throws Exception{
		getConnection();
		
		int authorId = person.getAuthorId();
		Date publishDate =  Date.valueOf(LocalDate.now());
		String query = "update authortable set  Books_published_count= ?,Books_publish_Date=? where id = ?";	
		
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1,bookCount);
		stmt.setDate(2, publishDate);
		stmt.setInt(3, authorId);
		stmt.execute();
		System.out.println("update Birth_year in authortable"); 
		closeConnection();
		
   }
	
	/*public ResultSet authorDetailsList() throws Exception{
		getConnection();
		
		List person = new ArrayList();
		ResultSet rs = null;
		try {
			rs = statement.executeQuery("select * from authortable");
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
   }*/
	
	
	public List authorDetailsList() throws SQLException{
		getConnection();
		
		List <AuthorListDomain>person = new ArrayList();
		
		try {
			ResultSet rs = statement.executeQuery("select * from authortable");
			
			while (rs.next()){
				int authorId =   rs.getInt("Author_Id");
				String authorName = rs.getString("Author_name");
				String gender = rs.getString("Gender");
				String born =  rs.getString("Birth_year");
				String bornDate =  String.valueOf(born);
				String bornLocation =  rs.getString("Birth_place");
				String theme =  rs.getString("Book_Theme");
				int numberOfBooksPublished =  rs.getInt("Books_published_count");
				LocalDate publishDate = rs.getDate("Books_publish_Date").toLocalDate();
				
				person.add(new AuthorListDomain (authorName,gender,bornDate,bornLocation,theme,numberOfBooksPublished,publishDate,authorId));

		}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return person;
		
   }
	
	public void deleteValues(AuthorListDomain person) throws SQLException{
		
		getConnection();
		int authorId = (int)person.getAuthorId();
		String query = "delete from authortable where Author_Id = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		
		stmt.setInt(1, authorId);
		stmt.execute();
		System.out.println("delete Books_published_count in authortable");
		closeConnection();
   }
	
	public List authorId() throws SQLException{
		getConnection();
		
		List <AuthorListDomain>person = new ArrayList();
		
		try {
			ResultSet rs = statement.executeQuery("select * from authortable where Author_Id=?");
			
			while (rs.next()){
				int authorId =   rs.getInt("Author_Id");
				String authorName = rs.getString("Author_name");
				String gender = rs.getString("Gender");
				String born =  rs.getString("Birth_year");
				String bornDate =  String.valueOf(born);
				String bornLocation =  rs.getString("Birth_place");
				String theme =  rs.getString("Book_Theme");
				int numberOfBooksPublished =  rs.getInt("Books_published_count");
				LocalDate publishDate = rs.getDate("Books_publish_Date").toLocalDate();
				
				person.add(new AuthorListDomain (authorName,gender,bornDate,bornLocation,theme,numberOfBooksPublished,publishDate,authorId));

		}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return person;
		
   }
	/*public void authorId(AuthorListDomain person) throws Exception{
		getConnection();
		
		int authorId = person.getAuthorId();
		String authorName = person.getAuthorName();
		String born = (String)person.getBorn();
		String bornLocation = person.getBornLocation();
		String theme = person.getBookTheme();
		int numberOfBooksPublished = (int) person.getNumberOfBooksPublished();
		LocalDate publishDate =(LocalDate) person.getlastBookPublishDate();
		Date modifyDate = Date.valueOf(publishDate);
		//Date publishDate =  Date.valueOf(LocalDate.now());
		String query = "select  Author_Id= ?, Author_name=?,Birth_year=?,Birth_place=?,Book_Theme=?, Books_published_count= ?,Last_Book_Publish_Date=? from authortable where id = ?";	
		
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.getInt(1,authorId);
		stmt.getString(2, authorName);
		stmt.getString(3, born);
		stmt.getString(4, bornLocation);
		stmt.getString(5, theme);
		stmt.getInt(6, numberOfBooksPublished);
		stmt.getDate(7, modifyDate);
		stmt.getInt(8, authorId);
		stmt.execute();
		System.out.println("display single book author details"); 
	
   }*/
	
	/*public void deleteValues() throws Exception{
		getConnection();
		statement.executeUpdate("delete from authortable where id=3");
		
		System.out.println("delete Books_published_count in authortable");
	
   }*/
	
	/*public List sortByAuthorName() throws SQLException{
		getConnection();
		
		List <AuthorListDomain>person = new ArrayList();
		
		try {
			ResultSet rs = statement.executeQuery("select * from authortable  order by author_name");
			
			while (rs.next()){
				int authorId =   rs.getInt("id");
				String authorName = rs.getString("Author_name");
				String born =  rs.getString("Birth_year");
				String bornDate =  String.valueOf(born);
				String bornLocation =  rs.getString("Birth_place");
				String theme =  rs.getString("Theme");
				int numberOfBooksPublished =  rs.getInt("Books_published_count");
				LocalDate publishDate = rs.getDate("Books_publish_Date").toLocalDate();
				
				person.add(new AuthorListDomain (authorName,bornDate,bornLocation,theme,numberOfBooksPublished,publishDate,authorId));

		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return person;
		
   }*/
	//sort syntax select * from author_details.authortable  order by author_name;
}
