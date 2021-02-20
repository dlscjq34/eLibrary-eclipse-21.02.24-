package com.e.library.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e.library.dao.BookDAOImpl;
import com.e.library.dao.RentDAOImpl;
import com.e.library.model.DTO;
import com.e.library.model.RentVO;

@Service
public class RentServiceImpl implements RentService {
	
	@Autowired
	private RentDAOImpl dao;
	@Autowired
	private BookDAOImpl bookDao;

	
	
	@Override
	@Transactional
	public void rent(DTO dto) {
		dao.rent(dto);//도서 대출
		dto.setBookStatus("관 외 대출 중");
		dao.updateBookStatus(dto);//대출 도서 상태 변경
	}
	

	
	
	@Override
	public void backRent(RentVO rentVO) {
		dao.backRent(rentVO.getRentId());//도서 반납
		DTO dto = new DTO();
		dto.setBookId(rentVO.getBookId());
		dto.setBookStatus("대출 가능");
		dao.updateBookStatus(dto);//대출 도서 상태 변경
	}


	@Override
	public int getRentCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	@Override
	public List<DTO> getRents(String memberId) {
		
		List<RentVO> rentList = dao.getRents(memberId);
		List<DTO> dtoList = new ArrayList<DTO>();
		
		for (int i = 0; i < rentList.size(); i++) {
			String rentId = rentList.get(i).getRentId();
			String bookId = rentList.get(i).getBookId();
			String bookName = bookDao.getBook(bookId).getBookName();
			Timestamp rentDate = rentList.get(i).getRentDate();
			Timestamp dueDate = rentList.get(i).getDueDate();
			Timestamp returnDate = rentList.get(i).getReturnDate();
			int lateDate = (int)(new Timestamp(System.currentTimeMillis()).getTime() - dueDate.getTime()) / (1000*60*60*24);//현재날짜 - 반납예정일(24시간 기준으로 계산)
			DTO dto = new DTO();
			dto.setRentId(rentId);
			dto.setBookId(bookId);
			dto.setBookName(bookName);
			dto.setRentDate(rentDate);
			dto.setDueDate(dueDate);
			dto.setReturnDate(returnDate);
			dto.setLateDate(lateDate);
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Override
	public List<RentVO> getAllRents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RentVO getRent(String bookId) {
		return dao.getRent(bookId);
	}

}
