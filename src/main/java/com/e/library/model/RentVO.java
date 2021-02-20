package com.e.library.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentVO {
	String rentId;	
	String bookId;	
	String memberId;	
	Timestamp rentDate;	
	Timestamp dueDate;	
	Timestamp returnDate;	
}
