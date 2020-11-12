package kr.or.ddit.member.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

@Repository("memberRepository")
public class MemberDaoImpl implements MemberDaoI {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MemberVO getMember(String userid) {
		
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		MemberVO memberVo = sqlSession.selectOne("member.getMember", userid);
		
//		sqlSession.close();
		
		return memberVo;
	}

	@Override
	public List<MemberVO> selectAllMember() {
		
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<MemberVO> memList = sqlSession.selectList("member.selectAllMember");
		
//		sqlSession.close();
		
		return memList;
	}

	@Override
	public List<MemberVO> selectAllMemberPage(PageVO pageVo) {
//		 sqlSession 객체를 service에서 생성하여 넘겨 받기 때문에 굳이 변수에 담을 필요가 없다. close할 필요가 없기 때문
//		List<MemberVO> memList = sqlSession.selectList("member.selectAllMemberPage", pageVo);
		
		return sqlSession.selectList("member.selectAllMemberPage", pageVo);
	}

	@Override
	public int selectMemberTotalCnt() {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}
 
	public int insertMember(MemberVO mv) {
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		
		insertCnt = sqlSession.insert("member.insertMember", mv);
		
		return insertCnt;
	}

	@Override
	public int deleteMember(String userid) {
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int deletetCnt = sqlSession.delete("member.deleteMember", userid);
		
		if(deletetCnt > 0) {
//			sqlSession.commit();
		}else {
//			sqlSession.rollback();
		}
//		sqlSession.close();
		
		return deletetCnt;
		
	}

	@Override
	public int updateMember(MemberVO mv) {
//		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int updateCnt = 0;
		
		updateCnt = sqlSession.update("member.updateMember", mv);
		
		if(updateCnt > 0) {
//			sqlSession.commit();
		}else {
//			sqlSession.rollback();
		}
//		sqlSession.close();
		
		return updateCnt;
	}


}
