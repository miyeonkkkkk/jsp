package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberRepository")
public class MemberDaoImpl implements MemberDaoI {
	
	@Override
	public MemberVO getMember(String userid) {
		
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userid);
		
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

//	@Override
//	public List<MemberVO> selectAllMemberPage(SqlSession sqlSession,PageVO pv) {
//		// sqlSession 객체를 service에서 생성하여 넘겨 받기 때문에 굳이 변수에 담을 필요가 없다. close할 필요가 없기 때문
////		List<MemberVO> memList = sqlSession.selectList("member.selectAllMemberPage", pv);
//		return sqlSession.selectList("member.selectAllMemberPage", pv);
//	}

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
//		int memberTotalCnt = sqlSession.selectOne("member.selectMemberTotalCnt");
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}
 
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
