package com.e.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FavorBookVO {
	String favorBookId;	
	String memberId;	
	String bookId;	
}
