package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.dto.Board;
import com.ssafy.test.dto.Detail;

public interface BoardService {
	public abstract List<Board> selectAll() throws SQLException;
	public abstract Detail selectByAno(String ano) throws SQLException;
	public abstract void deleteCar(String[] number) throws SQLException;
	public abstract void registCar(Board board) throws SQLException;
}
