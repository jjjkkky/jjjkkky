package com.example.demo.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {
	private String id;
	private String pw;
	private String name;
	private Integer age;
	private LocalDateTime regdate;
}
