package com.authordetailsserviceimpl.app;

import java.util.List;

import com.authordomaindetails.app.AuthorDetailsDomain;

public interface AuthorDetailsService {

	public List<AuthorDetailsDomain> getallAuthorDetails();
	public boolean add(AuthorDetailsDomain person);
	public boolean  remove(AuthorDetailsDomain person);
	public List<AuthorDetailsDomain> createTable();
	public boolean updateMultipleAuthorsNames(AuthorDetailsDomain person,String modifyName);

}
