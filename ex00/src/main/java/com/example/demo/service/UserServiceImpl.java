package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserDTO;
import com.example.demo.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;

	@Override
	public boolean join(UserDTO user) {
		if(null == mapper.selectUserRowByUserid(user.getId())) {
			if( user.getId() != null &&
				user.getPw() != null &&
				user.getName() != null &&
				user.getAge() != null &&
				user.getRegdate() == null ) 
			{
				Integer resRow;
				if(null != (resRow = mapper.insertUserAsJoin(user))) {
					return 1 == resRow;
				}
			}
		}
		return false;
	}

	@Override
	public boolean leaveId(String userid) {
		Integer resRow;
		if(null != (resRow = mapper.deleteUserAsLeave(userid))) {
			return 1 == resRow;
		}
		return false;
	}

	@Override
	public UserDTO getDetail(String userid) {
		UserDTO res;
		if(null != (res = mapper.selectUserRowByUserid(userid))) {
			return res;
		}
		return null;
	}

	@Override
	public boolean login(String userid, String userpw) {
		UserDTO compare;
		if(null != (compare = mapper.selectUserRowByUserid(userid))) {
			if(compare.getPw().equals(userpw)) {
				return true;
			}
		}
		return false;
	}
}
