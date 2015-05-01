<%@ page contentType="text/html; charset=gbk" language="java"%>
<%@ include file="taglibs.jsp"%>
<br>
<center>
	<font color="blue" size="5"> <b>新闻图库子系统</b> </font>
</center>
<br>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="sail">
	<tr>
		<td>
			&nbsp;
		</td>
		<logic:empty name="channels" scope="session">
			<td>

			</td>
		</logic:empty>

		<logic:notEmpty name="channels" scope="session">
			<logic:iterate id="channel" name="channels" scope="session">
				<td width="73">
					<a href="viewalbumsk.do?channelId=${pageScope.channel.id}" class="03"><bean:write
							name="channel" property="title" /> </a>
				</td>
			</logic:iterate>
		</logic:notEmpty>
		<td>
			&nbsp;
		</td>
	</tr>
</table>