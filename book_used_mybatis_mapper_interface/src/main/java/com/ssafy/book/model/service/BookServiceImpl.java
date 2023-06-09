package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.book.dto.Book;
import com.ssafy.book.model.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<Book> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return bookMapper.selectAll();
	}

	@Override
	public Book selectByIsbn(String isbn) throws SQLException {
		// TODO Auto-generated method stub
		return bookMapper.selectByIsbn(isbn);
	}

	@Override
	public void registBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		bookMapper.registBook(book);
	}

	@Override
	@Transactional //처리하는 도중에 예외가 발생하면 trasaction을 취소하고 롤백함
	public void deleteByIsbn(String[] isbn) throws SQLException {
		bookMapper.deleteByIsbn(isbn);
		//if(true) throw new NullPointerException();
		
		//Book book = new Book(); 
		//bookMapper.registBook(book); // 여기서 터짐
		//transaction
		// delete + insert 이렇게 두개 되있는데
		//insert에서 터짐. 데이터 무결성 위해서 delete도 롤백되야함
	}
}





