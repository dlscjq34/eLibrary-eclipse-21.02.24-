package com.e.library.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DTO {
	String memberId;
	String rentId;
	String bookId;
	String bookName;
	Timestamp rentDate;	
	Timestamp dueDate;	
	Timestamp returnDate;	
	String bookStatus;
	int lateDate;	
}
