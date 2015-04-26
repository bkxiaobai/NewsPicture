package com.np.po;

//��׼ע��
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "photo")
public class Photo {
	// ͼƬID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	// ��ͼƬ������
	@Column(length = 255, nullable = false)
	private String title;
	// ͼƬ�ڷ������ϵ��ļ���
	@Column(length = 255, unique = true, nullable = false)
	private String fileName;
	// ��ͼƬ�Ĺؼ�������
	@Column(length = 255, nullable = false)
	private String keyword;

	// �����ͼƬ�������û�
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// user���Ե�setter��getter����
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}
	
	//�����ͼƬ������ͼ��
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
	private Album album;
	
	//album���Ե�setter��getter����
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	// �޲����Ĺ�����
	public Photo() {
	}

	// ��ʼ��ȫ�����ԵĹ�����
	public Photo(Integer id, String title, String fileName, String keyword,
			User user,Album album) {
		this.id = id;
		this.title = title;
		this.fileName = fileName;
		this.keyword = keyword;
		this.user = user;
		this.album = album;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// title���Ե�setter��getter����
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// fileName���Ե�setter��getter����
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

	// keyword���Ե�setter��getter����
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	

}