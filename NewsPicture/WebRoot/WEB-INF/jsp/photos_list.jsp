<%@ page contentType="text/html; charset=gbk" language="java"%>
<%@ include file="taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����ͼ����ϵͳ</title>
<link href="css.css" rel="stylesheet" type="text/css">
</head>

<body>
	<table width="768" align="center" border="0" cellspacing="0"
		cellpadding="0">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="30" colspan="2"><jsp:include page="l_sail.jsp" />
						</td>
					</tr>
					<tr>
						<td height="17"><jsp:include page="my_sail.jsp" /></td>
					</tr>
				</table></td>
		</tr>
		<script language="JavaScript" src="JavaScript/validate.js"></script>
		<tr>
			<td><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="19" class="td_shang12">&nbsp;</td>
						<td width="8" class="td_shang12">&nbsp;</td>
						<td width="666" valign="bottom" class="td_shang12"><table
								width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="400" class="Statistic">
										��ӭ����${requestScope.album.title}��� &nbsp;&nbsp;&nbsp;����
										${requestScope.page.rsCount}����Ƭ</td>
									<td class="sail"></td>
								</tr>
							</table>
						</td>
						<td width="8" class="td_shang12">&nbsp;</td>
						<td width="19" height="35" class="td_shang12">&nbsp;</td>
					</tr>
					<tr>
						<td colspan="5">
							<div class="sail">&nbsp;&nbsp;&nbsp;&nbsp;</div>
							<div align="center">
								<logic:empty name="photos" scope="request">
									<div>&nbsp;&nbsp;&nbsp;&nbsp;</div>
									<div>&nbsp;&nbsp;&nbsp;&nbsp;</div>
									<span class="PhotoNameClass">������Ƭ</span>
									<div>&nbsp;&nbsp;&nbsp;&nbsp;</div>
									<div>&nbsp;&nbsp;&nbsp;&nbsp;</div>
								</logic:empty>
								<logic:iterate id="photo" name="photos" scope="request">
									<div class="PhotoWrapClass">
										<div class="PhotoImgClass">
											<a href="photouser.do?photoId=${pageScope.photo.id}"><img
												src="${pageScope.photo.smallPicUrl}" border="0">
											</a>
										</div>
										<div class="PhotoNameClass"></div>
									</div>
								</logic:iterate>
								<html:form action="otherphotosa.do">
									<input type="hidden" name="albumId"
										value="${requestScope.album.id}">
									<input type="hidden" name="currentPage"
										value="${requestScope.page.currentPage}">
									<input type="hidden" name="pageCount"
										value="${requestScope.page.pageCount}">
								</html:form>
							</div></td>
					</tr>

					<tr>
						<td height="40" colspan="5" class="td_down"><div
								align="center">
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="td_xia12">
									<tr>
										<td class="page"><div align="right">
												�� ҳ ��ǰ��
												${requestScope.page.currentPage}/${requestScope.page.pageCount}
												<a href="javascript:firstPage();">��ҳ</a> <a
													href="javascript:prePage();">��һҳ</a> <a
													href="javascript:nextPage();">��һҳ</a> <a
													href="javascript:lastPage();">βҳ</a>
											</div>
										</td>
										<td width="32">&nbsp;</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
</body>
</html>
