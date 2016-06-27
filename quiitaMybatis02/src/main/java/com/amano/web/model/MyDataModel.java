package com.amano.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class MyDataModel {

	@Id
	@GeneratedValue
	private Integer id;

	@Length(max = 20)
	@NotBlank
	private String name;

    @Email
    @NotNull
	private String mail;

    @Length(max = 100)
    @NotNull
	private String tel;

	public MyDataModel() {
		super();
	}

	public MyDataModel(int id, String name, String mail, String tel) {
    }

	public MyDataModel(String name, String mail) {
    }

    public Integer getId() {
		return id;
	}

    public void setId(Integer id) {
        this.id = id;
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
