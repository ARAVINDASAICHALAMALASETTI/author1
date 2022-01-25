package com.authorImpl.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.author.domain.AuthorListDomain;
import com.author.services.AuthorService;
import com.authordetailsserviceimpl.app.AuthorDetailsJdbcImpl;
import com.authordetailsserviceimpl.app.AuthorDetailsService;
import com.authordetailsserviceimpl.app.AuthorDetailsServiceImpl;

public class AuthorListJdbcImpl implements AuthorService {

	AuthorServiceJdbcUtil author = new AuthorServiceJdbcUtil();

	AuthorDetailsService secondDomain = new AuthorDetailsJdbcImpl();
	@Override
	public boolean add(AuthorListDomain person) {
		// TODO Auto-generated method stub
		try {
			author.insertValues(person);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<AuthorListDomain> getallAuthorDetails() {
		// TODO Auto-generated method stub
		try {
			return author.authorDetailsList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remove(AuthorListDomain person) {
		// TODO Auto-generated method stub
		try {
			author.deleteValues(person);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateAuthorBooksCountDateDetails(AuthorListDomain person, int bookCount) {
		// TODO Auto-generated method stub
		try {
			author.updateValues(person,bookCount);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<AuthorListDomain> sortByAuthorName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorListDomain> createTable() {
		// TODO Auto-generated method stub
		try {
			author.createTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AuthorListDomain> getauthorId() {
		// TODO Auto-generated method stub
		try {
			return author.authorId();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<Integer, String> authorsList() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
