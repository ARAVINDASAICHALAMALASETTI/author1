package com.author.domain;


import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.authordomaindetails.app.AuthorDetailsDomain;
;

public class AuthorListDomain {
	//private variable
	private int authorId;
	private String authorName;
	private String gender;
	private String bornDate;
	private String bornLocation;
	private String bookTheme;
	private int numberOfBooksPublished;
	private LocalDate lastBookPublishDate;
	private LocalDate updateDate;
	public Map<Integer, AuthorDetailsDomain> secondDomainDetails = new HashMap<>();
	//constructor with arguments
	
	public AuthorListDomain(String authorName,String gender, String born, String bornLocation, String bookTheme, int numberOfBooksPublished,
			LocalDate lastBookPublishDate, int authorId,Map<Integer, AuthorDetailsDomain> secondDomainDetails) {
		
		this.authorId = authorId;
		this.authorName = authorName;
		this.gender = gender;
		this.bornDate = born;
		this.bornLocation = bornLocation;
		this.bookTheme = bookTheme;
		this.numberOfBooksPublished = numberOfBooksPublished;
		this.lastBookPublishDate = lastBookPublishDate;
		this.secondDomainDetails = secondDomainDetails;
		
	}
	
	public AuthorListDomain(String authorName,String gender, String born, String bornLocation, String bookTheme, int numberOfBooksPublished,
			LocalDate lastBookPublishDate, int authorId) {
		
		this.authorId = authorId;
		this.authorName = authorName;
		this.gender = gender;
		this.bornDate = born;
		this.bornLocation = bornLocation;
		this.bookTheme = bookTheme;
		this.numberOfBooksPublished = numberOfBooksPublished;
		this.lastBookPublishDate = lastBookPublishDate;
		
	}
	
	

	// use setter and getter methods
	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBorn() {
		return bornDate;
	}


	public void setBorn(String born) {
		this.bornDate = born;
	}


	public String getBornLocation() {
		return bornLocation;
	}


	public void setBornLocation(String bornLocation) {
		this.bornLocation = bornLocation;
	}


	public String getBookTheme() {
		return bookTheme;
	}


	public void setBookTheme(String theme) {
		this.bookTheme = bookTheme;
	}


	public int getNumberOfBooksPublished() {
		return numberOfBooksPublished;
	}


	public void setNumberOfBooksPublished(int numberOfBooksPublished) {
		this.numberOfBooksPublished = numberOfBooksPublished;
	}


	public LocalDate getlastBookPublishDate() {
		return lastBookPublishDate;
	}


	public void setPublishDate(LocalDate lastBookPublishDate) {
		this.lastBookPublishDate = lastBookPublishDate;
	}
	
	public LocalDate getupdateDate() {
		return updateDate;
	}


	public void setupdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "AuthorListDomain [authorId=" + authorId + ", authorName=" + authorName + ", gender=" + gender
				+ ", bornDate=" + bornDate + ", bornLocation=" + bornLocation + ", bookTheme=" + bookTheme
				+ ", numberOfBooksPublished=" + numberOfBooksPublished + ", lastBookPublishDate=" + lastBookPublishDate
				+ ", updateDate=" + updateDate + ", secondDomainDetails=" + secondDomainDetails + "]";
	}
	
	
	
		
}

