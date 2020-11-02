package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.CollectionBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/collection.xml"})
public class IocCollectionTest {
	
	// spring collectionBean 주입
	@Resource(name = "collectionBean")
	private CollectionBean collectionBean;

	@Test
	public void mapTest() {
		/***Given : 주어진 상황 기술 ***/
		Map<String, String> map;

		/***When : 행위 ***/
		map = collectionBean.getMap();

		/***Then : 결과 ***/
		assertEquals("brown", map.get("name"));
	}
	
	@Test
	public void setTest() {
		/***Given : 주어진 상황 기술 ***/
		Set<String> set;
		
		/***When : 행위 ***/
		set = collectionBean.getSet();
		
		/***Then : 결과 ***/
		assertEquals(3, set.size());
	}
	
	@Test
	public void ListTest() {
		/***Given : 주어진 상황 기술 ***/
		List<String> list;
		
		/***When : 행위 ***/
		list = collectionBean.getList();
		
		/***Then : 결과 ***/
		assertEquals(3, list.size());
		assertEquals("brown", list.get(0));
		assertEquals("sally", list.get(1));
		assertEquals("cony", list.get(2));
	}
	
	@Test
	public void propertiestTest() {
		/***Given : 주어진 상황 기술 ***/
		Properties props;
		
		/***When : 행위 ***/
		props = collectionBean.getProperties();
		
		/***Then : 결과 ***/
		assertEquals(2, props.size());
		assertEquals("kmy", props.get("jdbc.user"));
		assertEquals("java", props.get("jdbc.pass"));
	}

}
