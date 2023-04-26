package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ssafy.test.dto.Board;
import com.ssafy.test.dto.Detail;
import com.ssafy.test.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	BoardDao boardDao;

	@Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	@Override
	public List<Board> selectAll() throws SQLException {
		return boardDao.selectAll();
	}
	@Override
	public Detail selectByAno(String ano) throws SQLException {
		return boardDao.selectByAno(ano);
	}
	@Override
	public void deleteCar(String[] ano) throws SQLException {
		for (String n : ano) {
			boardDao.deleteCar(n);
		}
		
	}
	@Override
	public void registCar(Board board) throws SQLException {
		boardDao.registCar(board);
		
	}

}
