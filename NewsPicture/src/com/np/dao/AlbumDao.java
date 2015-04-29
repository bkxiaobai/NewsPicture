package com.np.dao;

import java.util.List;

import com.np.po.User;
import com.np.po.Album;

//AlbumDao�ӿ�
public interface AlbumDao {
	// ����id�������
	Album get(Integer id);

	// �������
	void save(Album album);

	// �������
	void update(Album album);

	// ����idɾ�����
	void delete(int id);

	// ɾ��ָ�����
	void delete(Album album);

	/**
	 * ��ҳ��ȡָ���û���ȫ����ᡣ
	 * 
	 * @param user
	 *            ָ�����û���
	 * @param first
	 *            ָ��ҳ����ʾ�ĵ�һ����ᡣ
	 * @pram pageSize ҳ������ʾ���������
	 * @return ��ȡָ��ҳ��ȫ������б�
	 */
	List<Album> getAllByUser(final User user, final int first,
			final int pageSize);

	/**
	 * ��ȡָ���û���ȫ�����
	 * 
	 * @param user
	 * @return
	 */
	List<Album> getAllByUser(final User user);

	/**
	 * ��ȡָ���û����������
	 * 
	 * @return ����ָ���û����������
	 */
	int getAmount(User user);
}
