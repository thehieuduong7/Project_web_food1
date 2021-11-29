package com.models;

public class CategoryModel {
	int id_category;
	String name_category;
	String icon;
	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public String getName_category() {
		return name_category;
	}
	public void setName_category(String name_category) {
		this.name_category = name_category;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public CategoryModel(int id_category, String name_category, String icon) {
		super();
		this.id_category = id_category;
		this.name_category = name_category;
		this.icon = icon;
	}
	
}
