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
<script language="JavaScript" src="JavaScript/validate.js">
</script>		  
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="19" class="td_shang12">&nbsp;</td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="666" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="400" class="Statistic">&nbsp;&nbsp;
					������Ϊ&nbsp;&nbsp;<span class="sail">${sessionScope.albumInfo.title}</span>
					&nbsp;&nbsp;�ϴ���Ƭ
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="viewphotos.do?albumId=${sessionScope.albumInfo.id}">�鿴��Ƭ�б�</a></td>
                    <td width="313" class="Statistic"><jsp:include page="album_sail.jsp"/></td>
                  </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5"><div align="center">
                  <html:form action="addphoto.do" enctype="multipart/form-data" onsubmit="return validateAddPhotoForm(this);">
                    <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="19">&nbsp;</td>
                        <td width="147">&nbsp;</td>
                        <td width="200">
						<label><span class="sail">&nbsp;&nbsp;&nbsp;&nbsp;
						<logic:messagesPresent>
				  	    	<html:messages id="error">
				  		    	<bean:write name="error"/><br>&nbsp;&nbsp;&nbsp;&nbsp;					      	
				  		    </html:messages>
				        </logic:messagesPresent>
					<bean:write name="wrongType" scope="request" ignore="true"/>
					<bean:write name="success" scope="request" ignore="true"/>
					<bean:write name="nofind" scope="request" ignore="true"/>
					<bean:write name="tooBig" scope="request" ignore="true"/>
						</span></label>						</td>
                        <td width="233">&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td height="25" class="Statistic2">ͼƬ���ƣ�</td>
                        <td><html:text property="title" styleClass="input"/></td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td height="25" class="Statistic2">ͼƬ��</td>
                        <td><html:file property="image" styleClass="input"/>  </td>
                        <td class="Statistic"><div align="left">(ֻ֧��bmp,jpeg��ʽͼƬ,��ע���ʽ)</div></td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td height="25" class="Statistic2">�ļ���飺</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td class="Statistic2">&nbsp;</td>
                        <td colspan="2"><input type="hidden" name="albumId" value="${requestScope.albumInfo.id}">
                          <html:textarea property="keyword" cols="40" rows="5" styleClass="input3"/></td>
                        </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td class="Statistic2">&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><input name="Submit" type="submit" class="input" value="�ύ">
                        <input type="button"  class="input" onclick="javascript:history.back();" value="����"/></td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
                  </html:form>
                  </div></td>
              </tr>
              <tr>
                <td height="40" colspan="5" class="td_down"><div align="center">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="td_xia12">
                      <tr>
                        <td class="page"><div align="right"></div></td>
                        <td width="32">&nbsp;</td>
                      </tr>
                          </table>
                </div></td>
              </tr>
            </table></td>
          </tr>
        </table>
</body>
</html>
