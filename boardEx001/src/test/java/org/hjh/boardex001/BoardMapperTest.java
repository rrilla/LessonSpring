package org.hjh.boardex001;

import java.sql.Connection;


import javax.sql.DataSource;

import org.hjh.boardex001.domain.BoardVo;
import org.hjh.boardex001.mapper.BoardMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTest {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private DataSource dataSource;
	//getBean();안해도 되는 이유 = web.xml에 경로 설정되어있음.
	
	@Test
	public void testConnection() {
		try(Connection conn = dataSource.getConnection()){
			log.info(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testList() {
		mapper.getList().forEach(board->log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVo board = new BoardVo();
		board.setTitle("new title");
		board.setContent("new content");
		board.setWriter("new writer");
		mapper.insert(board);
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVo board = new BoardVo();
		board.setTitle("new title2");
		board.setContent("new content2");
		board.setWriter("new writer2");
		mapper.insert(board);
		log.info(board);
	}
	
	@Test
	public void testListNo() {
		mapper.selectNo(4).forEach(board->log.info(board));
	}
	
}
