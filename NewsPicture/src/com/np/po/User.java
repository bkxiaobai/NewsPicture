package com.np.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class User {
	// 用户ID
    @Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	// 用户名
    @Column(length=255, unique=true,nullable=false)  
	private String username;
	// 用户密码
    @Column(length=255, nullable=false)  
	private String password;
    
    @Column()
    private boolean isAdmin;

    
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	// id属性的setter和getter方法
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// name属性的setter和getter方法
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}
	
	// pass属性的setter和getter方法
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
