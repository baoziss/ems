package com.baizhi.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.entity.User;
import com.baizhi.service.DeptService;
import com.baizhi.service.EmpService;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.DeptServiceImpl;
import com.baizhi.service.impl.EmpServiceImpl;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.JdbcUtil;
import com.baizhi.util.MD5Util;
import com.baizhi.util.SaltUtil;

public class TestUtil {
	@Test
	public void testCon(){
		Connection con = JdbcUtil.getCon();
		System.out.println(con);
	}
	@Test
	public void testMD5(){
		String code = MD5Util.getMd5Code("123456");
		System.out.println(code);
		System.out.println(code.length());
	}
	@Test
	public void testSalt(){
		String salt = SaltUtil.getSalt(3);
		System.out.println(salt);
	}
	@Test
	public void testQuery(){
		UserService usi = new UserServiceImpl();
		User user = usi.queryOne("wult");
		System.out.println(user);
	}
	@Test
	public void testQueryAllDept(){
		DeptService ds = new DeptServiceImpl();
		List<Dept> list = ds.queryAll();
		for (Dept d : list) {
			System.out.println(d);
		}
	}
	@Test
	public void testQueryAllEmp(){
		EmpService es = new EmpServiceImpl();
		List<Emp> list = es.queryAll("1");
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	@Test
	public void testQueryOneEmp(){
		EmpService es = new EmpServiceImpl();
		Emp emp = es.queryOne("2");
		System.out.println(emp);
	}
	@Test
	public void testChangeEmp(){
		EmpService es = new EmpServiceImpl();
		DeptService ds = new DeptServiceImpl();
		Dept dept = ds.queryOne("1");
		System.out.println(dept);
	}
}
