package com.np.tool;

import org.apache.struts.upload.FormFile;


import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics;
import java.io.File;

public class Upload
{
	private String url;

	private String fileName;
	
	/** �ϴ��ļ�����
	  * @param FormFile file, ѡ���ļ���ʵ��
	  * @param request HttpServletRequest
	  * @param userName �û�������,String��
	  * @param webPath �������ľ���·��
	  * @param suffix �����ļ��ĺ�׺
	  */
	public void upload(FormFile file, String path, String suffix)
		throws Exception
	{
		
		//��ȡ�ļ��Ĵ�С
		byte[] content = file.getFileData();
		//��ʱ���ʽ�����ļ���
		String url = makeUrl(path, suffix);
		this.url = url;		
		//������������ļ�
		FileOutputStream fos = new FileOutputStream(url);
		//д��ʱ��
		fos.write(content);
		//�ر������
		fos.close();
	}
	private String makeUrl(String path, String suffix)
	{
		File file = new File(path);
		file.mkdirs();
		this.fileName = DateUtil.getStringTime();
		return path + "\\" + this.fileName + suffix;
	}

	public String makeNewUrl(String path, String suffix, String other)
	{
		return path + "\\" + this.fileName + other + suffix;
	}

	/** �����ϴ����ļ��ľ���URL
	  * @return String
	  */
	public String getUrl()
	{
		return this.url;
	}

	public String getFileName()
	{
		return this.fileName;
	}

	/** ���������ϴ�����ͼƬ�ĸ���
	  * @param url ԭͼ�ľ���URL
	  * @param newWidth ���ɸ������¿��
	  * @param newHeight ���ɸ������¸߶�
	  * @param newUrl ���ɸ����ĵ�ַ
	  * @param formatName ����ͼƬ�ĸ�ʽ
	  */
	public void makeImage(String url, int newWidth, int newHeight, String newUrl, String formatName)
		throws Exception
	{
		//��ȡͼƬ
		BufferedImage bi = ImageIO.read(new File(url));
		//�ж϶���ͼƬ�Ŀ�͸�
		if (bi.getHeight() > bi.getWidth())
		{
			//����߱ȿ��,�ͽ�����ֵ,ȷ�����ɵ�ͼƬ�ĳ�������һ����Χ��
			int tmp = newWidth;
			newWidth = newHeight;
			newHeight = tmp;
		}
		//��Image��ķ�����ͼƬ���еȱ�ѹ��,ֻҪ��͸���һֵΪ��,���������Ǹ�ֵΪ���߽��еȱ�ѹ��
		Image image2 = bi.getScaledInstance(newWidth, newHeight, Image.SCALE_AREA_AVERAGING);
		//��ȡѹ����ͼƬ�ĸߺͿ�
		int height = image2.getHeight(null);
		int width = image2.getWidth(null);			
		//FileOutputStream fos = new FileOutputStream(new File(newUrl));
		//���µĸߺͿ���һ���µĻ���ͼƬ
		BufferedImage bi3 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi3.getGraphics();
		//���µĻ���ͼƬ�л�ͼ
		g.drawImage(image2, 0, 0, null);
		//����IO��������ļ�
		FileOutputStream fos = new FileOutputStream(new File(newUrl));
		ImageIO.write(bi3, formatName, fos);
		fos.close();
	}

	/** �÷�����ɾ��ͼƬ
	  * @param url ɾ��ͼƬ�ľ��Ե�ַ
	  * @param bigUrl ���ݿ��д�ͼƬ��URL
	  * @param smallUrl ���ݿ�СͼƬ��URL
	  * @param realPath �������еľ���·��
	  */
	public void deleteImage(String url, String bigUrl, String smallUrl, String realPath)
	{
		//���������ļ�����,���÷��������ж�Ӧ��ͼƬɾ��
		File fUrl = new File(realPath + "/" + url);
		File fBigUrl = new File(realPath + "/" + bigUrl);
		File fSmallUrl = new File(realPath + "/" + smallUrl);
		fUrl.delete();
		fBigUrl.delete();
		fSmallUrl.delete();
	}
}
