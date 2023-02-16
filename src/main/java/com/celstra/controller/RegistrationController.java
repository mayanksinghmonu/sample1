package com.celstra.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.celstra.pojo.RegistrationEntity;
import com.celstra.pojo.Users;
import com.celstra.service.intf.RegistrationServiceIntf;

@ManagedBean(name = "RegistrationController")
@ViewScoped
public class RegistrationController {
	
	@ManagedProperty(value = "#{RegistrationServiceImpl}")
	private RegistrationServiceIntf registrationSerIntf;

//	@ManagedProperty(value = "#{RegistrationServiceImpl_Akshay}")
	/*@Autowired
	private RegistrationServiceIntf_Akshay serviceintf_akshay;

	// @Autowired
	private RegistrationEntity entity_akshay;
	private RegistrationEntity entity_akshay1;
	private RegistrationEntity entity_akshay2;
	private List<RegistrationEntity> entities;*/
	private List<RegistrationEntity> regUsersList;
	private RegistrationEntity selUser;
	private RegistrationEntity user;

	@PostConstruct
	public void init() {
		regUsersList = registrationSerIntf.getUsers(null);
		user=new RegistrationEntity();
//	    	System.out.println("Printing all data in controller");
//	    	System.out.println(entities);

	}
	public void delete()
	{
		System.out.println("Hii inside delete");
		String res = registrationSerIntf.deleteUser(selUser);
		if(res.equalsIgnoreCase("Deleted")) {
			regUsersList = registrationSerIntf.getUsers(null);
		}
	}

	public void submit()  {
		System.out.println("Hii inside Submit method in controller");
		String response = registrationSerIntf.saveUser(user);
		System.out.println("Printing resoponse through submit method" + " " + "username :" + user.getUserName()
				+ " " + "Password : " + " " + user.getPassword() + " " + "Email :" + " "
				+ user.getEmailId());

		if (response.equalsIgnoreCase("Success")) {
			setSuccessMessage("Valid", "User Information Saved successfully");
			regUsersList = registrationSerIntf.getUsers(null);
			user = new RegistrationEntity();
			//redirectUrl();
		}
	}

	public void setSuccessMessage(String Info, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, Info, message));
	}

public void redirectUrl() {
		try {
			System.out.println("inside redirecturl try blcock");
			
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("pages/Registration.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public RegistrationServiceIntf getRegistrationSerIntf() {
	return registrationSerIntf;
}
public void setRegistrationSerIntf(RegistrationServiceIntf registrationSerIntf) {
	this.registrationSerIntf = registrationSerIntf;
}
public List<RegistrationEntity> getRegUsersList() {
	return regUsersList;
}
public void setRegUsersList(List<RegistrationEntity> regUsersList) {
	this.regUsersList = regUsersList;
}
public RegistrationEntity getSelUser() {
	return selUser;
}
public void setSelUser(RegistrationEntity selUser) {
	this.selUser = selUser;
}
public RegistrationEntity getUser() {
	return user;
}
public void setUser(RegistrationEntity user) {
	this.user = user;
}



	/*public RegistrationServiceIntf getServiceintf_akshay() {
		return serviceintf_akshay;
	}

	public void setServiceintf_akshay(RegistrationServiceIntf serviceintf_akshay) {
		this.serviceintf_akshay = serviceintf_akshay;
	}

	public RegistrationEntity getEntity_akshay() {
		return entity_akshay;
	}

	public void setEntity_akshay(RegistrationEntity entity_akshay) {
		this.entity_akshay = entity_akshay;
	}

	public List<RegistrationEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<RegistrationEntity> entities) {
		this.entities = entities;
	}

	public RegistrationEntity getEntity_akshay1() {
		return entity_akshay1;
	}

	public void setEntity_akshay1(RegistrationEntity entity_akshay1) {
		this.entity_akshay1 = entity_akshay1;
	}*/



}
