package com.example.demo.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
//@AllArgsConstructor  //  <-- 인스턴스 변수 - 필드로 선언된 모든 것을 매개변수로 받는 생성자 생성
@RequiredArgsConstructor  // <-- 특정 변수를 위한 생성자를 만들 때 사용 - final 필드 혹은 @NonNull이 붙은 필드
public class Hotel {
	//final private Chef chef; <-- RequiredArgsConstructor에 매개변수로 넣기 1
	@NonNull
	private Chef chef; // <-- RequiredArgsConstructor에 매개변수로 넣기 2
	
	int data;
}
