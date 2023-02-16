package com.celstra.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.celstra.dao.impl.RegistrationDaoImpl;
import com.celstra.dao.intf.RegistrationDaoIntf;
import com.celstra.pojo.RegistrationEntity;
import com.celstra.service.intf.RegistrationServiceIntf;

@Service("RegistrationServiceImpl")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class RegistartionServiceImpl implements RegistrationServiceIntf {

	@Autowired
	private RegistrationDaoIntf regDaointf;
	
	public String saveUser(RegistrationEntity Entity) {
		System.out.println("Hii inside saveUser method in Service Impl");
		return regDaointf.saveuser(Entity);
	}

	@Override
	public List<RegistrationEntity> getUsers(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return regDaointf.getUsers(map);
	}
	@Override
	public String deleteUser(RegistrationEntity delEntity)
	{ 
		System.out.println("Hii inside service in delete method");
		System.out.println(delEntity.getUserName()+" " + delEntity.getEmailId());
		return regDaointf.delete(delEntity);
	}

}
