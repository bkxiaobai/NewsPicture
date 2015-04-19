package com.np.po;

//标准注解
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="photo")
public class Photo {
	// 图片ID
	 @Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	// 该图片的名称
	 @Column(length=255, nullable=false) 
	private String title;
	// 图片在服务器上的文件名
	 @Column(length=255, unique=true,nullable=false) 
	private String fileName;
	// 该图片的关键词属性
	 @Column(length=255,nullable=false) 
	private String keyword;
	 //保存该图片所属的用户
	 @Column(nullable=false) 
	private User user;
	/**保存该图片所属的图集
	 @Column(nullable=false) 
    private Album album;
   **/
	 
	// 无参数的构造器
	public Photo() {
	}

	// 初始化全部属性的构造器
	public Photo(Integer id, String title, String fileName,String keyword,User user) {
		this.id = id;
		this.title = title;
		this.fileName = fileName;
		this.keyword = keyword;
		this.user = user;
	//	this.album =album;
	}

	//延迟加载：多对一方式
	//关联信息：外键name = "user_id"
		 @ManyToOne(fetch = FetchType.LAZY)
		 @JoinColumn(name = "user_id")	
		 
	// id属性的setter和getter方法
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// title属性的setter和getter方法
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// fileName属性的setter和getter方法
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	// keyword属性的setter和getter方法
	public String getKeyword() {
		return this.keyword;
		}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
		}
	
	// user属性的setter和getter方法
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	/** album属性的setter和getter方法
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	**/
	
}