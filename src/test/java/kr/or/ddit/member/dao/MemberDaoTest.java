package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVO;


public class MemberDaoTest extends ModelTestConfig{
	
	@Resource(name = "memberRepository")
	private MemberDaoI memberDao;

	@Test
	public void selectAllMember() {
		/***Given : 주어진 상황 기술 ***/
		
		/***When : 행위 ***/
		List<MemberVO> memberList = memberDao.selectAllMember();	
		
		/***Then : 결과 ***/
		assertTrue(memberList.size() > 15);
		
	}

}
