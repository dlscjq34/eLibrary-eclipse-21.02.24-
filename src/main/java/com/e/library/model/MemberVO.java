package com.e.library.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberVO {
	String memberId;	
	String memberName;	
	String memberRole;	
	String pswd;	
	String addr;	
	String tel;
	Timestamp regDate;	
	int favorBook;
	int howManyLate;	
}
