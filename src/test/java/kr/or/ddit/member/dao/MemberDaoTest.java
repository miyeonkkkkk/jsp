package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {
	
	// 테스트 메소드 : @Test가 붙은 메서드를 실행, 인자와 반환값이 없어야 한다.
	// life cycle 
	// @BeforeClass : 테스트 코드가 실행 되었을때 딱 한번만 실행 / 메소드가 static이어야 한다.
	// @Before => @Test => After (테스트 메서드 마다 실행된다.)
	// @AfterClass : 테스트 코드가 실행 되었을때 딱 한번만 실행 / 메소드가 static이어야 한다.
	
	private MemberDaoI memberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDaoTest.class);
	
	@Before
	public void setup() {
		memberDao = new MemberDaoImpl();
		String userid = "kmy2";
		
		memberDao.deleteMember(userid);
	}

	@Test
	public void getMemberTest() {
		
		/***Given : 주어진 상황 기술 ***/
//		MemberDaoI memberDao = new MemberDaoImpl();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/***When : 행위 ***/
		MemberVO memberVo = memberDao.getMember(userId);

		/***Then : 결과 ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
		// memberVo에 속성을 추가하였기 때문에 오류가 난다.
//		assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void selectAllMember() {
		/***Given : 주어진 상황 기술 ***/
//		MemberDaoI memberDao = new MemberDaoImpl();

		/***When : 행위 ***/
		List<MemberVO> memList = memberDao.selectAllMember();

		/***Then : 결과 ***/
//		assertNotNull(memList);
		assertEquals(15, memList.size()); // 약식 비교
	}
	
	@Test
	public void selectAllMemberPage() {
		/***Given : 주어진 상황 기술 ***/
//		MemberDaoI memberDao = new MemberDaoImpl();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/***When : 행위 ***/
//		int page = 1;
		PageVO pv = new PageVO(1, 5);
		
		List<MemberVO> memList = memberDao.selectAllMemberPage(sqlSession, pv);
		
		sqlSession.close();
		
		/***Then : 결과 ***/
//		assertNotNull(memList);
		assertEquals(5, memList.size()); // 약식 비교
	}
	
	@Test
	public void selectMemberTotalCnt() {
		/***Given : 주어진 상황 기술 ***/
//		MemberDaoI memberDao = new MemberDaoImpl();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/***When : 행위 ***/
		int memberTotalCnt = memberDao.selectMemberTotalCnt(sqlSession);
		
		sqlSession.close();
		
		/***Then : 결과 ***/
		assertEquals(15, memberTotalCnt);
	}
	
	@Test
	public void insertMemberTest() {
		/***Given : 주어진 상황 기술 ***/
//		MemberDaoI memberDao = new MemberDaoImpl();
		MemberVO mv = new MemberVO("kmy2", "pass1234", "김미연", "김미", "대전 중구 중앙로 76", "영민빌딩 404호", "34940", "D:\\profile\\aa.png", "aa.png");

		/***When : 행위 ***/
		int insertCnt = memberDao.insertMember(mv);

		/***Then : 결과 ***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given : 주어진 상황 기술 ***/
		MemberVO mv = new MemberVO("kmy2", "pass1234", "김미연", "김미", "대전 중구 중앙로 76", "영민빌딩 404호", "34940", "D:\\profile\\aa.png", "aa.png");
		MemberVO mv2 = new MemberVO("kmy2", "pass1234", "유승호", "유호호2", "대전 중구 중앙로 76", "영민빌딩 404호", "34940", "D:\\profile\\aa.png", "aa.png");
		
		/***When : 행위 ***/
		memberDao.insertMember(mv);
		int updateCnt = memberDao.updateMember(mv2);
		
		/***Then : 결과 ***/
		assertEquals(1, updateCnt);
	}

}
