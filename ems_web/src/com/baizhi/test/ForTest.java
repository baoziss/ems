package com.baizhi.test;

import java.util.List;

import org.junit.Test;

import com.baizhi.dao.impl.UserDAOImpl;
import com.baizhi.entity.Emp;
import com.baizhi.entity.User;
import com.baizhi.service.impl.EmpServiceImpl;
import com.baizhi.util.DBCountUtil;

/**
 * 测试类
 * @author Administrator
 *
 */
public class ForTest {
	@Test
	public void testUserSelect(){
		UserDAOImpl ud = new UserDAOImpl();
		User user = ud.selectOne("lisi");
		System.out.println(user);
	}
	@Test
	public void testUserAdd(){
		UserDAOImpl ud = new UserDAOImpl();
		ud.insertUser(new User("1","lisi","张三","123456","男","qwer"));
	}
	@Test
	public void testQueryPage(){
		EmpServiceImpl es = new EmpServiceImpl();
		List<Emp> list = es.queryEmpNyPage(1, 2);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	@Test
	public void testDBCount(){
		int count = DBCountUtil.getCount("ttt_user");
		System.out.println(count);
	}
}
