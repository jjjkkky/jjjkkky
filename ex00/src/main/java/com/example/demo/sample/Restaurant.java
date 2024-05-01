package com.example.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter  <-- 클래스 위에 있으면 모든 필드에게 적용 / 필드 위에 있으면 해당 필드에게만 적용
@Data  //  <-- @Setter, @Getter, @ToString 등등을 하나로 합친 어노테이션
@Component
public class Restaurant {
	//@Setter(onMethod_ = @Autowired)  <-- setter가 호출될 때 @Autowired(DI - 주입)
	@Autowired //  <-- 위와 동일
	private Chef chef;
	
	//의존성 주입1
//	public Restaurant(Chef chef) {
//		this.chef = chef;
//	}
	
	//의존성 주입2
//	public void setChef(Chef chef) {
//		this.chef = chef;
//	}

}
