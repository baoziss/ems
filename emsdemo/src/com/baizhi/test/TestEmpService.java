package com.baizhi.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import com.baizhi.service.impl.EmpServiceImpl;
import com.baizhi.util.MybatisUtil;

/**
 * 员工操作业务测试
 * @author Administrator
 *
 */
public class TestEmpService {
	
	private EmpService es = new EmpServiceImpl();
	@Test
	public void testAdd(){
		es.addEmp(new Emp(null,"李四",12000.0,18));
	}
	@Test
	public void testSelectAll(){
		List<Emp> list = es.queryAll();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	@Test
	public void testQueryOne(){
		Emp emp = es.queryOne("eec68ba7-e829-4a5e-ae2c-04bee77e4994");
		System.out.println(emp);
	}
	@Test
	public void testUpdate(){
		Emp emp = es.queryOne("eec68ba7-e829-4a5e-ae2c-04bee77e4994");
		emp.setName("张三");
		es.changeEmp(emp);
	}
	@Test
	public void testDelete(){
		es.dropEmp("eec68ba7-e829-4a5e-ae2c-04bee77e4994");
	}
	@Test
	public void testttt() throws Throwable{
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Connection connection = sqlSession.getConnection();
		connection.close();
		finalize();
		System.out.println(connection);
		
	}
	
}
