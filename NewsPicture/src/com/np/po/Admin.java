package com.np.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	//管理员id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;
	//管理员名
    @Column(length=255, unique=true,nullable=false)  
	private String name;
	//管理员密码
    @Column(length=255, nullable=false)  
    private String pass;

	public Admin() {
	}

	public Admin(String name, String pass) {
		setName(name);
		setPass(pass);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getPass() {
		return this.pass;
	}

}
