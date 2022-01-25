package com.author.services;

import java.util.List;
import java.util.Map;

import com.author.domain.AuthorListDomain;
import com.authordomaindetails.app.AuthorDetailsDomain;

public interface AuthorService{
	
	public boolean add(AuthorListDomain person);
	public List<AuthorListDomain> getallAuthorDetails();
	public boolean  remove(AuthorListDomain person);
	public boolean updateAuthorBooksCountDateDetails(AuthorListDomain person,int bookCount);
	public List<AuthorListDomain> sortByAuthorName();
	public List<AuthorListDomain> createTable();
	public List<AuthorListDomain> getauthorId();
	public Map<Integer,String> authorsList();
	//public List<AuthorListDomain> remove(String person);
}