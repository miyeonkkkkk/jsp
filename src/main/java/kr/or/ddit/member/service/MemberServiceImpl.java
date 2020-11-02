package kr.or.ddit.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceImpl implements MemberServiceI {

	private static MemberServiceI service;
	private MemberDaoI memberDao;

	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl(); // 제어건이 우리에게 있다.
	}

//	public static MemberServiceI getService() {
//		if(service == null) {
//			service = new MemberServiceImpl();
//		}
//		return service;
//	}

	@Override
	public MemberVO getMember(String userId) {

		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVO> selectAllMember() {

//		MemberDaoI memberDao = new MemberDaoImpl();
		return memberDao.selectAllMember();
	}

	@Override
	public Map<String, Object> selectAllMemberPage(PageVO pv) {

		// 하나의 트랜잭션에서 작업하기 위해서 Dao가 아니라 Service에서 생성해야 한다.
		// Dao에서 생성할 경우 서로 다른 트랜잭션에서 생성됨.
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		Map<String, Object> map = new HashMap<>();
		map.put("memberList", memberDao.selectAllMemberPage(sqlSession, pv));

		// 페이지바를 만들기 위한 것
		// 15건, 페이지 사이즈를 7로 가정했을 때 3개의 페이지가 나와야 한다.
		// 15/7 = 2.14...올림 ==> 3페이지
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);
//		int pages = (int)Math.ceil((double)totalCnt/7);

//		map.put("pages", pages);
		map.put("totalCnt", totalCnt);

		sqlSession.close();
		return map;
	}

	@Override
	public int insertMember(MemberVO mv) {
		return memberDao.insertMember(mv);
	}

	@Override
	public int deleteMember(String userid) {
		return memberDao.deleteMember(userid);
	}

	@Override
	public int updateMember(MemberVO mv) {
		return memberDao.updateMember(mv);
	}

}
