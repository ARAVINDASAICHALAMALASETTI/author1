package com.authordetailsserviceimpl.app;

import java.sql.SQLException;
import java.util.List;

import com.author.domain.AuthorListDomain;
import com.authorImpl.services.AuthorServiceJdbcUtil;
import com.authordetailsutil.app.AuthorDetailsUtil;
import com.authordomaindetails.app.AuthorDetailsDomain;

public class AuthorDetailsJdbcImpl implements AuthorDetailsService {

	 AuthorDetailsUtil author = new  AuthorDetailsUtil();

	@Override
	public List<AuthorDetailsDomain> getallAuthorDetails() {
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
	public boolean add(AuthorDetailsDomain person) {
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
	public boolean remove(AuthorDetailsDomain person) {
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
	public List<AuthorDetailsDomain> createTable() {
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
	public boolean updateMultipleAuthorsNames(AuthorDetailsDomain person, String modifyName) {
		// TODO Auto-generated method stub
		try {
			author.updateMultipleAuthorsNamesData(person, modifyName);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
