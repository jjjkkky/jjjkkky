package com.example.demo.sample;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestaurantTests {
	@Autowired
	private Restaurant restaurant;
	
	//JUnit 에서 테스트 대상임을 표시
	@Test
	//JUnit 상에서 해당 메서드의 이름을 지정함
	@DisplayName("테스트 이름")
	public void testExist() {
		//assert~~ : ~~이면 테스트 통과
		//assertNull : 인수가 null이면 테스트 통과
		//assertNull(restaurant.getChef());
		
		//assertNotNull : 인수가 null이 아니면 테스트 통과 
		assertNotNull(restaurant.getChef());
		System.out.println(restaurant);
	}
}
