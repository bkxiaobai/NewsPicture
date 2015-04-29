package com.np.dao;

import java.util.List;

import com.np.po.Album;

import com.np.po.Photo;

//PhotoDao接口, test
public interface PhotoDao {
	// 根据id加载photo实例
	Photo get(Integer id);

	// 保存photo
	void save(Photo photo);

	// 跟新photo
	void update(Photo photo);

	// 根据id删除photo
	void delete(int id);

	// 删除指定的photo
	void delete(Photo photo);

	/**
	 * 获取指定相册的封面相片ID。
	 * 
	 * @param al
	 *            指定相册。
	 * @flag 相片是否为相册封面的旗标。
	 * @return 指定相册的封面ID。
	 */
	Integer getCover(Album al, boolean flag);

	/**
	 * 获取指定相册的指定页的相片列表
	 * 
	 * @param al
	 *            指定的相册。
	 * @param first
	 *            指定相册需要显示的第一张相片
	 * @param pageSize
	 *            每页显示的相片数量
	 * @return 特定页所显示的相片列表
	 */
	List<Photo> getPhotos(final Album al, final int first, final int pageSize);

	/**
	 * 显示该相册的浏览次数
	 * 
	 * @param 指定的相册
	 * @return 该相册的浏览次数
	 */
	int getCount(Album al);

	/**
	 * 获取指定相册的封面相片。
	 * 
	 * @param al
	 *            指定相册。
	 * @flag 相片是否为相册封面的旗标。
	 * @return 指定相册的封面。
	 */
	Photo getCoverPhoto(Album al, boolean flag);
}
