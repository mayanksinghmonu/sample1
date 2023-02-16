package com.celstra.service.intf;

import java.util.List;
import java.util.Map;

import com.celstra.pojo.RegistrationEntity;


public interface RegistrationServiceIntf {

	public String saveUser(RegistrationEntity Entity);
	public List<RegistrationEntity> getUsers(Map<String, Object> map);
	public String deleteUser(RegistrationEntity delEntity);
	
}
