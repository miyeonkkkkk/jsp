package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoImpl implements MemberDaoI {

	SqlSession sqlSession = MybatisUtil.getSqlSession();

	@Override
	public MemberVO getMember(String userId) {
		// 원래는 db에서 데이터를 조회하는 로직이 있어야 하나
		// controller 기능에 집중 => 하드코딩을 통해 dao, service는 간략하게 넘어간다.
		//						  Mock 객체(가짜객체)
		
//		MemberVO memberVo = new MemberVO();
//		memberVo.setUserId("brown");
//		memberVo.setPassword("passBrown");
		
		
		// select
		// 한건 : selectOne()
		// 여러건 : selectLsit()
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userId);
		
		return memberVo;
	}

	@Override
	public List<MemberVO> selectAllMember() {
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<MemberVO> memList = sqlSession.selectList("member.selectAllMember");
		
		return memList;
	}

}
