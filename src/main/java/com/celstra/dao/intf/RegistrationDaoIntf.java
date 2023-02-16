package com.celstra.dao.intf;

import java.util.List;
import java.util.Map;

import com.celstra.pojo.RegistrationEntity;
import com.celstra.pojo.Users;

public interface RegistrationDaoIntf {

	public String saveuser(RegistrationEntity users);
	public List<RegistrationEntity> getUsers(Map<String , Object> map);
	public String delete(RegistrationEntity del);
	
}
