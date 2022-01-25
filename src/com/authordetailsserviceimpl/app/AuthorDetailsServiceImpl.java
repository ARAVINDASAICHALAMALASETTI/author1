package com.authordetailsserviceimpl.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import com.authordomaindetails.app.AuthorDetailsDomain;



public class  AuthorDetailsServiceImpl implements AuthorDetailsService {

		// TODO Auto-generated method stub
		List< AuthorDetailsDomain > author = new ArrayList<AuthorDetailsDomain>();

		public List<AuthorDetailsDomain> getallAuthorDetails() {
			// TODO Auto-generated method stub
			return author;
		}
		
		public boolean add(AuthorDetailsDomain person) {
			// TODO Auto-generated method stub
			author.add(person);
			return true;
		}
		
		public boolean  remove(AuthorDetailsDomain person) {
			// TODO Auto-generated method stub
			author.remove(person);
			return true;
		}

		public boolean updateMultipleAuthorsNames(AuthorDetailsDomain person,String modifyName) {
		    person.setsingleBookMultipleAuthorsNames(modifyName);
			return true;
		}
		
		
		public List<AuthorDetailsDomain> createTable() {
			// TODO Auto-generated method stub
			return author;
		}
		

		
}



