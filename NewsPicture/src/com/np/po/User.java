package com.np.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class User {
	// �û�ID
    @Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	// �û���
    @Column(length=255, unique=true,nullable=false)  
	private String username;
	// �û�����
    @Column(length=255, nullable=false)  
	private String password;


	// id���Ե�setter��getter����
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// name���Ե�setter��getter����
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserame() {
		return this.username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
