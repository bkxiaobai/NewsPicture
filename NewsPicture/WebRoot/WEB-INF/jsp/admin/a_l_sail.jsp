<%@ page contentType="text/html; charset=gb2312" language="java" %>
<%@ include file="../taglibs.jsp"%>
<div align="left">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" class="sail">
<tr>
<td>&nbsp;</td>
<logic:empty name="channels" scope="session">
	<td>暂无任何种类的相册</td>
</logic:empty>

<logic:notEmpty name="channels" scope="session">
	<logic:iterate id="channel" name="channels" scope="session">
<td width="73"><a href="viewalbumsk.do?channelId=${pageScope.channel.id}" class="03"><bean:write name="channel" property="title"/>
	</a></td>
	</logic:iterate>
</logic:notEmpty>
<td>&nbsp;</td>
</tr>
</table>
</div>