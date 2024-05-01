package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.UserDTO;

@Mapper
public interface UserMapper {
	public Integer insertUserAsJoin(UserDTO user);
	public Integer deleteUserAsLeave(String id);
	public UserDTO selectUserRowByUserid(String id);
}
