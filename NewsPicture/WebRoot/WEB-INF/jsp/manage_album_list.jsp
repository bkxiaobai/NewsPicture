<%@ page contentType="text/html; charset=gbk" language="java" %>
<%@ include file="taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>����ͼ����ϵͳ</title>
<link href="css.css" rel="stylesheet" type="text/css">
</head>

<body>

<table width="768" align="center" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
		<table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="30" colspan="2">
				<jsp:include page="l_sail.jsp"/>
			</td>
            </tr>
          <tr>
            <td height="17"><jsp:include page="my_sail.jsp"/></td>
          </tr>
        </table>
	</td>
  </tr>
<script language="JavaScript" src="JavaScript/validate.js"></script>		  
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="19" class="td_shang12">&nbsp;</td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="666" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="246" class="Statistic">&nbsp;&nbsp;
					<bean:write name="userInfo" scope="session" property="username"/> 
					��ӭ����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�㹲��<bean:write name="page" scope="request" property="rsCount"/>�����</td>
                    <td width="313" class="Statistic"><jsp:include page="album_sail.jsp"/></td>
                  </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5">
						<div class="sail">
						<bean:write name="success" scope="request" ignore="true"/>
						<bean:write name="noexist" scope="request" ignore="true"/>&nbsp;&nbsp;&nbsp;&nbsp;						</div>
					<logic:empty name="albums" scope="request">
					<div align="center">
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
						<div class="sail">
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
						<div>
						<span class="PhotoNameClass">�������,���ȴ���</span>						</div>
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
					</logic:empty>
					<logic:iterate id="album" name="albums" scope="request">
						<div class="PhotoWrapClass">
							<div class="PhotoImgClass">
							<logic:present name="album" property="coverUrl">
							<a href="viewphotos.do?albumId=${pageScope.album.id}">
							<img src="${pageScope.album.coverUrl}" border="0"></a>							</logic:present>
							<logic:notPresent name="album" property="coverUrl">
							<a href="viewphotos.do?albumId=${pageScope.album.id}">
							<img src="none.gif" width="140" height="105" border="0"></a>							</logic:notPresent></div>
							<div class="PhotoNameClass"><a href="viewphotos.do?albumId=${pageScope.album.id}">
							${pageScope.album.title}</a>&nbsp;&nbsp;<br>
							&nbsp;&nbsp;��������:${pageScope.album.channelTitle}<br>
							&nbsp;&nbsp;�����:${pageScope.album.times}&nbsp;&nbsp;<br>
							<a href="viewalbuminfo.do?albumId=${pageScope.album.id}">�޸�</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delalbum.do?albumId=${pageScope.album.id}">ɾ��</a></div>
						</div>
					</logic:iterate>				</td>
              </tr>
              <tr>
                <td height="40" colspan="5" class="td_down"><div align="center">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="td_xia12">
                      <tr>
                        <td class="page"><div align="right">
						��<bean:write name="page" scope="request" property="pageCount"/>ҳ 
						��ǰ��${requestScope.page.currentPage}/${requestScope.page.pageCount} 
						  <form action="albumpage.do" name="form1">
      <input type="hidden" name="currentPage" value="${requestScope.page.currentPage}"/>
      <input type="hidden" name="pageCount" value="${requestScope.page.pageCount}"/>
						<a href="javascript:firstPage(form1);">��ҳ</a> 
						<a href="javascript:prePage(form1);">��һҳ</a> 
						<a href="javascript:nextPage(form1);">��һҳ</a> 
						<a href="javascript:lastPage(form1);">βҳ</a></form></div></td>
                        <td width="32">&nbsp;</td>
                      </tr>
                          </table>
                </div></td>
              </tr>
            </table></td>
          </tr>
        </table>
  </tr>

</body>
</html>
