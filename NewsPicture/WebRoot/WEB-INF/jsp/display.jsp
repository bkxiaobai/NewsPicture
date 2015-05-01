<%@ page contentType="text/html; charset=gbk" language="java" %>
<%@ include file="taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>新闻图库子系统</title>
<link href="css.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style1 {color: #333333}
-->
</style>
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
  <tr>
    <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="718" height="186" valign="top" bgcolor="#F1F9FF" class="td_top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="303" class="td_shang14-2"><table width="100"  border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="100" align="center" bgcolor="#FFFFFF" class="td_shang-xia"><table width="100"  border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td align="center" class="td_shang8_xia8">
					<a href="${requestScope.photo.picUrl}" target="_blank"><img src="${requestScope.photo.bigPicUrl}" border="0"></a></td>
                  </tr>
                </table></td>
                </tr>
            </table>              
              <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="40">&nbsp;</td>
                  <td width="60">&nbsp;</td>
                  <td width="60">&nbsp;</td>
                  <td width="60">&nbsp;</td>
                  <td width="30">&nbsp;</td>
                  <td width="60">&nbsp;</td>
                  <td width="123">&nbsp;</td>
                  <td width="124">&nbsp;</td>
                </tr>
                <tr>
                  <td height="20">&nbsp;</td>
                  <td width="60" class="Statistic2">照片名称：</td>
                  <td class="Statistic"><bean:write name="photo" property="title" scope="request"/></td>
                  <td colspan="2" class="Statistic"><span class="style1">点击次数：</span>${requestScope.photo.times}</td>
                  <td colspan="2" class="Statistic">&nbsp;</td>
                  <td class="Statistic">&nbsp;</td>
                </tr>
                <tr>
                  <td height="17">&nbsp;</td>
                  <td width="60" class="Statistic2">所属栏目：</td>
                  <td class="Statistic">${requestScope.channel.title}</td>
                  <td colspan="3" class="Statistic">添加时间：${requestScope.photo.date}</td>
                </tr>
				
                <tr>
                  <td>&nbsp;</td>
                  <td width="60" class="Statistic2">照片简介：</td>
                  <td colspan="6" class="Statistic">${requestScope.photo.keyword}</td>
                </tr>
              </table></td>
          </tr>
        </table></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
