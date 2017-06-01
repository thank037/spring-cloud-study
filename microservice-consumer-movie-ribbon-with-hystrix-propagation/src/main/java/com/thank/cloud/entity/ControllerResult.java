package com.thank.cloud.entity;

import java.util.List;
import java.util.Map;

public class ControllerResult {
	
	private String objectId;
	
	private Map<String, User> resultMap;
	
	private List<?> resultList;
	
	private User user;
	
	private Object obj;
	
	
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public Map<String, User> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, User> resultMap) {
		this.resultMap = resultMap;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	
}
