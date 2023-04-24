package com.ssafy.test.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.dto.Board;


public interface BoardDao {
	//자동차 전체조회
		public abstract List<Board> selectAll() throws SQLException;
		//자동차 상세 조회
		public abstract Board selectByAno(String ano) throws SQLException;
		public abstract void deleteCar(String ano) throws SQLException;
		public abstract void registCar(Board board) throws SQLException;
}
