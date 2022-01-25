package com.authordomaindetails.app;

import java.time.LocalDate;

public class AuthorDetailsDomain {
	
	//private variable
	private int authorId;
	private String bookName;
	private int bookVolumeCount;
	private LocalDate bookPublishDate;
	private String singleBookMultipleAuthorsNames;
	
	
	//constructor with arguments
	
	public AuthorDetailsDomain(int authorId, String bookName, int bookVolumeCount, LocalDate bookPublishDate,
			String singleBookMultipleAuthorsNames) {
		super();
		this.authorId = authorId;
		this.bookName = bookName;
		this.bookVolumeCount = bookVolumeCount;
		this.bookPublishDate = bookPublishDate;
		this.singleBookMultipleAuthorsNames = singleBookMultipleAuthorsNames;
	}


	
	// use setter and getter methods
	
	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public int getbookVolumeCount() {
		return bookVolumeCount;
	}


	public void setbookVolumeCount(int bookVolumeCount) {
		this.bookVolumeCount =bookVolumeCount;
	}


	public LocalDate getbookPublishDate() {
		return bookPublishDate;
	}


	public void setbookPublishDate(LocalDate bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}


	public String getsingleBookMultipleAuthorsNames() {
		return singleBookMultipleAuthorsNames;
	}


	public void setsingleBookMultipleAuthorsNames(String singleBookMultipleAuthorsNames) {
		this.singleBookMultipleAuthorsNames = singleBookMultipleAuthorsNames;
	}



	@Override
	public String toString() {
		return "AuthorDetailsDomain [authorId=" + authorId + ", bookName=" + bookName + ", bookVolumeCount=" +bookVolumeCount
				+ ", bookPublishDate=" + bookPublishDate + ", singleBookMultipleAuthorsNames=" +singleBookMultipleAuthorsNames + "]";
	}
	
	
	
	
	
	

}
