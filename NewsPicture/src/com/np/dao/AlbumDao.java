package com.np.dao;

import java.util.List;

import com.np.po.User;
import com.np.po.Album;

//AlbumDao接口
public interface AlbumDao {
	// 根据id加载相册
	Album get(Integer id);

	// 保存相册
	void save(Album album);

	// 跟新相册
	void update(Album album);

	// 根据id删除相册
	void delete(int id);

	// 删除指定相册
	void delete(Album album);

	/**
	 * 分页获取指定用户的全部相册。
	 * 
	 * @param user
	 *            指定的用户。
	 * @param first
	 *            指定页需显示的第一个相册。
	 * @pram pageSize 页面中显示的相册数。
	 * @return 获取指定页的全部相册列表。
	 */
	List<Album> getAllByUser(final User user, final int first,
			final int pageSize);

	/**
	 * 获取指定用户的全部相册
	 * 
	 * @param user
	 * @return
	 */
	List<Album> getAllByUser(final User user);

	/**
	 * 获取指定用户的相册数量
	 * 
	 * @return 返回指定用户的相册数量
	 */
	int getAmount(User user);
}
