<%@ include file="/WEB-INF/jsp/header/componentHeader.jsp"%>

<html>
	<h1>Log On</h1>
	<form action="" method="POST">
		<table>
			<tr>
				<td align="right">User&nbsp;Name:</td>
				<td>
					<input type="input" id="uid" name="uid" />
				</td>
			</tr>
			<tr>
				<td align="right">Password:</td>
				<td>
					<input type="password" id="pwd" name="pwd" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td width="100%">
					<input type="submit" width="100%" value="Log On" /> 
				</td>
			</tr>
		</table>
	</form>
</html>