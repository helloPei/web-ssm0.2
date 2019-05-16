package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.UserDao;

public class SpringTest extends SpringTestBase{
	@Autowired
	private UserDao userDao;
	@Test
	public void findAllUser() {
		
	}
}
