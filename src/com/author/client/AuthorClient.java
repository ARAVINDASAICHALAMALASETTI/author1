package com.author.client;





import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import com.author.domain.AuthorListDomain;
import com.author.services.AuthorService;
import com.author.services.AuthorServiceImpl;
import com.authorImpl.services.AuthorListJdbcImpl;
import com.authordetailsserviceimpl.app.AuthorDetailsJdbcImpl;
import com.authordetailsserviceimpl.app.AuthorDetailsService;
import com.authordomaindetails.app.AuthorDetailsDomain;

public class AuthorClient {
	
	
	public static void main(String[] args) {

		// create person one object
		AuthorListDomain person1 = new AuthorListDomain(" StepenKing","Male", "1978-6-18", " Portland,UnitedStates", " Mystery", 10, LocalDate.of(2018,6,18), 1);

		AuthorListDomain person2 = new AuthorListDomain(" JohnRubino","Female", "1962-2-10", " Kanto,Japan", " HOPELESS ", 15,LocalDate.of(2016,10,19), 2);
 
		AuthorListDomain person3 = new AuthorListDomain(" HoffMann","Male", "1989-8-28", " Moscow,Russia", " Thriller", 12, LocalDate.of(2011,6,10), 3);
		
		AuthorListDomain person4 = new AuthorListDomain(" JamesTrunk","Female", "1958-11-5", " Moscow,Russia", " Thriller", 18, LocalDate.of(2013, 6, 10), 4);

		AuthorService authorService = new AuthorListJdbcImpl();

		//authorService.add(person1);

		//authorService.add(person2);

		//authorService.add(person3);

		// calling the get details method
		//System.out.println("before sorting");
		//System.out.println(authorService.getallAuthorDetails());

		// update books count and date
		// authorService.updateAuthorBooksCountDateDetails(person3,13);
		// System.out.println(person3);

		/*/System.out.println();
		System.out.println("after sorting");
		System.out.println(authorService.sortByAuthorName());*/

		//System.out.println(authorService.createTable());
		System.out.println(authorService.add(person1));
		//System.out.println(authorService.getallAuthorDetails());
		//System.out.println(authorService.updateAuthorBooksCountDateDetails(person3, 16));
		//System.out.println(authorService.remove(person3));
		//System.out.println(authorService.authorId(person3));
		
		//create person two object
				AuthorDetailsDomain author1 = new AuthorDetailsDomain(1, "Fiction Can Be Murder", 2,LocalDate.of(2018, 6, 15),"Becky Clark");
				AuthorDetailsDomain author2 = new AuthorDetailsDomain(2, "LOSING HOPE", 5, LocalDate.of(2008, 9, 05), "Colleen Hoover");
				AuthorDetailsDomain author3 = new AuthorDetailsDomain(3, "The Last Thing To Burn ", 4, LocalDate.of(2012, 11, 19), "Will Dean");
				AuthorDetailsDomain author4 = new AuthorDetailsDomain(4, "Fiction Can Be Murder", 2, LocalDate.of(2018, 6, 15), "Becky Clark");
				
				AuthorDetailsService authorDetails = new AuthorDetailsJdbcImpl();
				
				//System.out.println(authorDetails.createTable());
				//System.out.println(authorDetails.add(author3));
				//System.out.println(authorDetails.getallAuthorDetails());
				//System.out.println(authorDetails.remove(author3));
				//System.out.println(authorDetails.updateMultipleAuthorsNames(author3, "Robert"));
		}
	
	
}
	

	


