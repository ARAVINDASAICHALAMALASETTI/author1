package com.author.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.author.domain.AuthorListDomain;
import com.authordetailsserviceimpl.app.AuthorDetailsService;
import com.authordetailsserviceimpl.app.AuthorDetailsServiceImpl;


public class AuthorServiceImpl implements AuthorService {

		// TODO Auto-generated method stub
		List< AuthorListDomain > author = new ArrayList<AuthorListDomain>();
		
		Map<Integer,String> authorsList = new HashMap<>();
		
		AuthorDetailsService serviceImpl = new AuthorDetailsServiceImpl();
		
		@Override
		public List<AuthorListDomain> getallAuthorDetails() {
			// TODO Auto-generated method stub
			return author;
		}
		
		@Override
		public boolean add(AuthorListDomain person) {
			// TODO Auto-generated method stub
			author.add(person);
			authorsList.put(person.getAuthorId(), person.getAuthorName());
			return true;
		}
		
		@Override
		public boolean  remove(AuthorListDomain person) {
			// TODO Auto-generated method stub
			author.remove(person);
			return true;
		}

		public boolean updateAuthorBooksCountDateDetails(AuthorListDomain person,int bookCount) {
			person.setNumberOfBooksPublished(bookCount);
			person.setupdateDate(LocalDate.now());
			return true;
		}
		
		@Override
		public List<AuthorListDomain> sortByAuthorName() {
			// TODO Auto-generated method stub
			Collections.sort(author, new Comparator<AuthorListDomain>() { //implementing a comparator interface

				@Override
				public int compare(AuthorListDomain person1, AuthorListDomain person2) {
					// TODO Auto-generated method stub
					
					String name1 = (String)person1.getAuthorName();
					String name2 = (String)person2.getAuthorName();
					return name1.compareTo(name2);
				}
								
					});
			
			return author;
		}

		@Override
		public List<AuthorListDomain> createTable() {
			// TODO Auto-generated method stub
			return author;
		}
		
		@Override
		public List<AuthorListDomain> getauthorId() {
			// TODO Auto-generated method stub
			return author;
		}

		public Map<Integer,String> authorsList(){
			return authorsList;
		}
}
