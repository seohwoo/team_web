package test.spring.mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.spring.mvc.service.AopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/aop-context.xml")
public class AopTest {
	@Autowired
	private AopService service;
	
	@Test
	public void test() {
		service.test();
		service.msg("SJR");
	}
}
