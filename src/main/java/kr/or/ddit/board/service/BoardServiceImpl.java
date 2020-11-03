package kr.or.ddit.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardRepositoryI;

// <bean id="boardService" /> 동일한 작업
@Service("boardService")
public class BoardServiceImpl implements BoardServiceI{
	
	@Resource(name = "boardRepository")
	private BoardRepositoryI boardRepository;
	
	public BoardServiceImpl() {
		
	}
	
	public BoardServiceImpl(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}
		

	public BoardRepositoryI getBoardRepository() {
		return boardRepository;
	}

	public void setBoardRepository(BoardRepositoryI boardRepository) {
		this.boardRepository = boardRepository;
	}

	@Override
	public BoardVo getBoard(int boardNo) {
		return boardRepository.getBoard(boardNo);
	}
	
}
