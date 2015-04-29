package com.np.vo;

import java.io.Serializable;

public class ChannelVO implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;

	public ChannelVO()
	{	
	}

	public ChannelVO(int id, String title)
	{
		setId(id);
		setTitle(title);
		
	}

	public void setId(int id) {
		this.id = id; 
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

}
