package com.authordetailsutil.app;


import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.author.domain.AuthorListDomain;
import com.authordomaindetails.app.AuthorDetailsDomain;

public class AuthorDetailsUtil {

	String url = "Jdbc:mysql://localhost:3306/author_details";
	String userName = "root";
	String password = "12345";
	Statement statement;
	Connection connection;
	
	public void getConnection() throws SQLException {
		
		connection = DriverManager.getConnection(url,userName,password);
		System.out.println("connected");
		statement = connection.createStatement();
		System.out.println("create statement platform");
	}
	
	public void createTable() throws Exception{
			getConnection();
			statement.executeUpdate("create table authortable2(id int, Book_name  varchar(255), Book_Volume_count int, Book_Publish_Date date,Single_book_multiple_authors_names  varchar(255))");
				
			System.out.println("author information table created");
		
	}
	
	
	public boolean insertValues(AuthorDetailsDomain person) throws Exception{
		getConnection();
		
		try {
			PreparedStatement pst = connection.prepareStatement("insert into authortable2 Values(?,?,?,?,?)");
			pst.setInt(1, person.getAuthorId());
			pst.setString(2, person.getBookName());
			pst.setInt(3, person.getbookVolumeCount());
			pst.setDate(4, Date.valueOf(person.getbookPublishDate()));
			pst.setString(5, person.getsingleBookMultipleAuthorsNames());
			pst.execute();
		return true;
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
   }
   
	/*public void updateValues() throws Exception{
		getConnection();
		
		
		statement.executeUpdate("update authortable2 set Books_published_count = ? where id = ?");	
		
		System.out.println("update Birth_year in authortable2"); 
	
   }*/
	
	public void updateMultipleAuthorsNamesData(AuthorDetailsDomain person,String author) throws Exception{
		getConnection();
		
		int authorId = person.getAuthorId();
		//String singleBookMultipleAuthorsNames = person.getsingleBookMultipleAuthorsNames();
		String query = "update authortable2 set  Single_book_multiple_authors_names= ? where id = ?";	
		
		PreparedStatement stmt = connection.prepareStatement(query);
		
		stmt.setString(1, author);
		stmt.setInt(2, authorId);
		stmt.execute();
		System.out.println("update Birth_year in authortable"); 
	
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
		
		List <AuthorDetailsDomain>person = new ArrayList();
		
		try {
			ResultSet rs = statement.executeQuery("select * from authortable2");
			
			while (rs.next()){
				int authorId =   rs.getInt("id");
				String bookName = rs.getString("Book_name");
				int bookVolumeCount =  rs.getInt("Book_Volume_count");
				String singleBookMultipleAuthorsNames =  rs.getString("Single_book_multiple_authors_names");
				LocalDate publishDate = rs.getDate("Book_Publish_Date").toLocalDate();
				
				person.add(new AuthorDetailsDomain ( authorId, bookName ,bookVolumeCount,publishDate,singleBookMultipleAuthorsNames));

		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return person;
		
   }
	
	public void deleteValues(AuthorDetailsDomain person) throws SQLException{
		
		getConnection();
		int authorId = (int)person.getAuthorId();
		String query = "delete from authortable2 where Id = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		
		stmt.setInt(1, authorId);
		stmt.execute();
		System.out.println("delete Books_published_count in authortable2");
	
   }
	
	/*public void deleteValues() throws Exception{
		getConnection();
		statement.executeUpdate("delete from authortable where id=3");
		
		System.out.println("delete Books_published_count in authortable");
	
   }*/
	
	/*public List sortByAuthorName() throws SQLException{
		getConnection();
		
		List <AuthorDetailsDomain>person = new ArrayList();
		
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


