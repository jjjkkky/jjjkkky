package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.UserDTO;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceImplTest {
	@Autowired @Qualifier("userServiceImpl")
	private UserService service;
	
	@Test
	@Order(1)
	@DisplayName("UserServiceImpl 생성 체크")
	public void testExist() {
		assertNotNull(service);
	}
	
	@Test
	@Order(2)
	@DisplayName("회원가입 체크 1 - UserServiceImpl.join(UserDTO)")
	public void joinTest() {
		UserDTO udto = new UserDTO();
		udto.setId("testid01");
		udto.setPw("testpassword");
		udto.setName("testname");
		udto.setAge(22);
		assertTrue(service.join(udto));
	}
	
	@Test
	@Order(3)
	@DisplayName("회원가입 실패 체크 1 - 존재하는 ID - UserServiceImpl.join(UserDTO)")
	public void joinFailTest1() {
		UserDTO udto = new UserDTO();
		udto.setId("existid");
		udto.setPw("testpassword");
		udto.setName("testname");
		udto.setAge(22);
		assertFalse(service.join(udto));
	}
	
	@Test
	@Order(4)
	@DisplayName("회원가입 실패 체크 2 - 미기입된 필수입력(pw) - UserServiceImpl.join(UserDTO)")
	public void joinFailTest2() {
		UserDTO udto = new UserDTO();
		udto.setId("existid");
		udto.setName("testname");
		udto.setAge(22);
		assertFalse(service.join(udto));
	}
	
	@Test
	@Order(5)
	@DisplayName("회원탈퇴 테스트 - UserServiceImpl.leaveId(String)")
	public void leaveTest() {
		assertTrue(service.leaveId("targetid"));
	}
	
	@Test
	@Order(6)
	@DisplayName("회원정보 조회 테스트 - UserServiceImpl.getDetail(String)")
	public void getTest() {
		UserDTO res;
		assertNotNull(res = service.getDetail("existid"));
		System.out.println("======================");
		System.out.println("getTest() res");
		System.out.println("id : " + res.getId());
		System.out.println("pw : " + res.getPw());
		System.out.println("name : " + res.getName());
		System.out.println("age : " + res.getAge());
		System.out.println("regdate : " + res.getRegdate());
		System.out.println("======================");
	}
	
	@Test
	@Order(7)
	@DisplayName("회원 로그인 테스트 - UserServiceImpl.login(String, String)")
	public void loginTest() {
		assertTrue(service.login("existid", "existpw"));
	}

	@Test
	@Order(8)
	@DisplayName("회원 로그인 실패 테스트 - 존재하지 않는 id - UserServiceImpl.login(String, String)")
	public void loginFaliTest1() {
		assertFalse(service.login("notexistid", "existpw"));
	}

	@Test
	@Order(9)
	@DisplayName("회원 로그인 실패 테스트 - 비밀번호 틀림 - UserServiceImpl.login(String, String)")
	public void loginFaliTest2() {
		assertFalse(service.login("existid", "notexistpw"));
	}
}
