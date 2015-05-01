<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ include file="taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>新闻图库子系统</title>
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
  <tr>
    <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="718" height="186" valign="top" class="td_shang14"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td bgcolor="#FFFFFF"><div align="center">
			<SCRIPT language="JavaScript" src="JavaScript/validate.js">

</SCRIPT>

			</div></td>
          </tr>
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="19" class="td_shang12">&nbsp;</td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="666" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td class="Statistic">&nbsp;&nbsp;&nbsp;欢迎使用图库&nbsp;&nbsp;<span class="RegFont darkRed">
					<a href="reglink.do">如果没有帐号请先注册</a></span>
					&nbsp;&nbsp;&nbsp;<span class="RegFont blue">Change Time For......</span></td>
                    </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5">
				<div id="RegisterDivWrap">
					<html:form action="userLogin.do" onsubmit="return validateUserLoginForm(this)">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label><span class="red">
						<logic:messagesPresent>
				  	    	<html:messages id="error">
				  		    	<bean:write name="error"/><br>&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					      	</html:messages>
				        </logic:messagesPresent>
						</span>
						<bean:write name="wrong" scope="request" ignore="true"/>
						<bean:write name="success" scope="request" ignore="true"/>
						</label>
					</div>
					<div>
						<label><span class="red">*</span> 昵&nbsp;&nbsp;&nbsp;&nbsp;称：</label>
					    <html:text property="username" styleClass="input" value="${requestScope.username}"/>
					</div>
					<div>
						<label><span class="red">*</span> 密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
						<input type="password" name="pass" class="input">
					</div>
					<input name="" type="submit" value="登 录" class="input" style="width:50px;">
					&nbsp;&nbsp;<input name="" type="reset" value="重 置" class="input" style="width:50px;">
					</div>
					</html:form>
				</div>				</td>
              </tr>
              <tr>
                <td height="40" colspan="5" class="td_down"><div align="center">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="td_xia12">
                      <tr>
                        <td class="page"></td>
                        <td width="32">&nbsp;</td>
                      </tr>
                          </table>
                </div></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
