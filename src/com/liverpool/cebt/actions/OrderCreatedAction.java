package com.liverpool.cebt.actions;

import com.liverpool.cebt.service.CebtAction;

public class OrderCreatedAction extends CebtAction 
{
	/**
	 * Version ActionS
	 */
	private static final long serialVersionUID = 1L;
	private String currentDate;
	
	public String initialLoad()
	{
		
		return null;
	}
	
	
	/*
	 * GET AND SET
	 */
	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	
}
