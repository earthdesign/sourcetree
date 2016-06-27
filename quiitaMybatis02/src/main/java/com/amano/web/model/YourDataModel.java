package com.amano.web.model;

public class YourDataModel {

	private Integer id;
	private String name;
	private String mail;
	private String tel;

	public YourDataModel() {
		super();
	}

	public YourDataModel(String name, String mail) {
		super();
		this.name = name;
		this.mail = mail;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String toString() {
		return "[name:" + name + ", mail:" + mail + "]";
	}

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
