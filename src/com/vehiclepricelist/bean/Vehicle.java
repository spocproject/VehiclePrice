package com.vehiclepricelist.bean;

public class Vehicle {
	
	private Integer id;
	private String makeName;
	private String modelName;
	private String modelEdition;
	private Integer price;
	private Integer options;
	private String funct;

	public String getFunct() {
		return funct;
	}

	public void setFunct(String funct) {
		this.funct = funct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMakeName() {
		return makeName;
	}

	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelEdition() {
		return modelEdition;
	}

	public void setModelEdition(String modelEdition) {
		this.modelEdition = modelEdition;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getOptions() {
		return options;
	}

	public void setOptions(Integer options) {
		this.options = options;
	}

}
