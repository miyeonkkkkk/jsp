package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoImpl implements MemberDaoI {
	
	private static MemberDaoI dao;
	
	// sqlSession의 인스턴스는 공유하여 사용할 수 없기 때문에 
	// close()후 새로 생성하여 사용해야 한다.
//	private SqlSession sqlSession;
	
	public MemberDaoImpl(){
//		sqlSession = MybatisUtil.getSqlSession();
	}
	
//	public static MemberDaoI getDao() {
//		if(dao == null) {
//			dao = new MemberDaoImpl();
//		}
//		return dao;
//	}
	
	@Override
	public MemberVO getMember(String userId) {
		// 원래는 db에서 데이터를 조회하는 로직이 있어야 하나
		// controller 기능에 집중 => 하드코딩을 통해 dao, service는 간략하게 넘어간다.
		//						  Mock 객체(가짜객체)
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
//		MemberVO memberVo = new MemberVO();
//		memberVo.setUserId("brown");
//		memberVo.setPassword("passBrown");
		
		
		// select
		// 한건 : selectOne()
		// 여러건 : selectLsit()
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userId);
		
		// insert, update, delete의 경우 아래의 두경우 중 한개는 해주어야 한다. => 데이터 변경이 일어날 경우
		// 명시적으로 해준다.
		//sqlSession.commit(); // 반영
		//sqlSession.rollback(); // 반영X
		
		sqlSession.close();
		
		return memberVo;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<MemberVO> memList = sqlSession.selectList("member.selectAllMember");
		
		sqlSession.close();
		
		return memList;
	}

	@Override
	public List<MemberVO> selectAllMemberPage(SqlSession sqlSession,PageVO pv) {
		// sqlSession 객체를 service에서 생성하여 넘겨 받기 때문에 굳이 변수에 담을 필요가 없다. close할 필요가 없기 때문
//		List<MemberVO> memList = sqlSession.selectList("member.selectAllMemberPage", pv);
		return sqlSession.selectList("member.selectAllMemberPage", pv);
	}

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
//		int memberTotalCnt = sqlSession.selectOne("member.selectMemberTotalCnt");
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}

	@Override
	public int insertMember(MemberVO mv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		
		try {
			insertCnt = sqlSession.insert("member.insertMember", mv);
		}catch (Exception e) {
		
		}
		
		if(insertCnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int deleteMember(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int deletetCnt = sqlSession.insert("member.deleteMember", userid);
		
		if(deletetCnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return deletetCnt;
		
	}

	@Override
	public int updateMember(MemberVO mv) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = 0;
		
		try {
			updateCnt = sqlSession.insert("member.updateMember", mv);
		}catch (Exception e) {
		
		}
		
		if(updateCnt > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return updateCnt;
	}


}
