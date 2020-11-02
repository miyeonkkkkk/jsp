package kr.or.ddit.board.service;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.repository.BoardRepositoryI;

public class BoardServiceImpl implements BoardServiceI{
	
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
