package com.e.library.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookVO {
	String bookId;	
	String bookName;	
	String writer;	
	String publisher;	
	Timestamp publiDate;	
	String status;
}
