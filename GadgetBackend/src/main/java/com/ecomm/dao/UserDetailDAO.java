package com.ecomm.dao;

import com.ecomm.model.UserDetail;

public interface UserDetailDAO 
{
	public boolean registerUser(UserDetail userdetail);
	public boolean updateUser(UserDetail userdetail);
	public UserDetail getUser(String username);
}
