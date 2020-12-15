
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR001) User Search</title>
<link th:href="@{/resources/css/container.css}" rel="stylesheet" type="text/css" />
<link th:href="@{/resources/css/base.css}" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/resources/js/accordion-menu.js"></script>
<script type="text/javascript" src="/resources/js/general.js"></script>
<script type="text/javascript">
	window.onload = function() {
		menu();
	}
</script>
</head>
<body class="main_body">

	<div th:replace=header></div>

	<div id="container">
		<div id="left_menu">
			<!-- menu html code exist the menu function of general.js -->
		</div>
		<div id="main_contents">
			<div id="contents">
				<div class="search_form">
					<h3>User Search</h3>
					<form action="userSearch" method="post" th:object="${userBean}" >
						<table class="tableForm">
							<tr>
								<td class="tblLabel"><label>User ID</label></td>
								<td class="tblInputNormal"><input type="text" id="txtUserId" class="txt" th:field="*{id}"/></td>
									<label th:if="${#fields.hasErrors('id')}" th:errors="*{id}" style="color:red;">Error</label>

								<td class="tblLabel">User Name</td>
								<td class="tblInputNormal"><input type="text" id="txtUserName" class="txt" th:field="*{name}"/></td>
								<label th:if="${#fields.hasErrors('name')}" th:errors="*{name}" style="color:red;">Error</label>

							</tr>
						</table>

						<br /> <input type="submit" value="Search" class="button" />
					</form>
					
					<a th:href="@{/adduser}"> <input type="button" value="Add" class="button" id="userInsert" /></a>
					<input type="button" value="Reset" onclick="window.location.replace('userManagement')" class="button" /> <br /> <br />
					<div id="errormsg">
						<label id="message" th:text="${err}"></label>
					</div>
					<label th:text="${msg}" style="color: blue;"></label>
				</div>

				<br />
				<br />
				<br />
				<div id="list" th:if="${userlist!=null}">

					<table class="resultTable">
						
							<tr class="tblHeader">
								<th width="1%">Delete</th>
								<th width="1%">Update</th>
								<th width="12%">User ID</th>
								<th width="24%">User Name</th>

							</tr>
						
						
							<tr th:each="user: ${userlist}">
								<td>
									<a th:href="@{/userdelete(id=${user.id})}">
								<input type="button" value="Delete" id="delete" class="button"	onclick="return confirm('Are you sure you want to delete!')" />
								</a>
								</td>
								
								<td><a th:href="@{/userupdate(id=${user.id})}">
								<input type="button" value="Update" class="button" id="userUpdate" />
								</a></td>

								<td th:text="${user.id}"/>
								<td th:text="${user.name}"/>
							</tr>
						
					</table>

				</div>

			</div>
		</div>

	</div>
	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
	</div>
</body>
</html>