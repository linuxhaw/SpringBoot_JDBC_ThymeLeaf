
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Update</title>
<link th:href="@{/resources/css/container.css}" rel="stylesheet" type="text/css" />
<link th:href="@{/resources/css/base.css}" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/resources/js/accordion-menu.js"></script>
<script type="text/javascript" src="/resources/js/general.js"></script>
<script type="text/javascript">
	window.onload = function() {
		menu();
	}

	function deleteStudent() {
		var isOk = confirm("Are you sure to delete?");
		if (isOk) {
			document.getElementById("myform").action = "studentDelete";
			document.getElementById("myform").submit();
		}
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
					<h3>Student Update</h3>
					<label id="errormsg" th:text=" ${err}"> </label> 
					<label style="color: blue;" th:text="${msg}"></label>
					<br />
					<br />
					<br />
					<form action="studentUpdate" method="post" id="myform" th:object="${studentBean}">
						
						<table class="tableForm">
							<tr height="30px">
								<td class="tblSingleLabel">Student No.</td>
								<td class="tblSingleInput"><input type="text" readonly="readonly" th:field="*{id}" class="txtlong"/></td>
							</tr>

							<tr>
								<td class="tblSingleLabel">Student Name *</td>
								<td class="tblSingleInput"><input type="text" class="txtlong" th:field="*{name}" required/></td>
								
							</tr>
							<tr>
								<td class="tblSingleLabel">Class Name *</td>
								<td class="tblSingleInput"><select id="expenseType" class="normal_sel" th:field="*{className}">
										<option th:value="${null}"></option>
										<option th:each="list:${application.classlist}" th:value="${list.name}" th:text="${list.name}"></option>
								</select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Registered Date *</td>
								<td class="tblSingleInput"><select id="expenseType" class="short_sel" th:field="*{year}">
											<option th:each="i: ${#numbers.sequence(2020, 2030)}" th:value="${i}" th:text="${i}">Year</option>

								</select> <select id="expenseType" class="short_sel" th:field="*{month}">
										<option th:value="${null}">Month</option>
										<option th:each="i: ${#numbers.sequence(1, 12)}" th:value="${i}" th:text="${i}">Month</option>
								</select> <select id="expenseType" class="short_sel" th:field="*{day}">
											<option th:value="${null}">Day</option>
										<option th:each="i: ${#numbers.sequence(1, 31)}" th:value="${i}" th:text="${i}">Day</option>
								</select></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Status *</td>
								<td class="tblSingleInput"><select id="expenseType" class="normal_sel" th:field="*{status}">
										<option th:value="${null}"></option>
										<option th:value="Attending">Attending</option>
										<option th:value="Passed">Passed</option>
										<option th:value="Failed">Failed</option>
								</select></td>
							</tr>
						</table>
						<br />
						<div id="btnGroup">
							<input type="submit" value="Update" class="button" />
						    <input type="button" value="Delete" id="delete" class="button" onclick="deleteStudent()" />
					</form>
					<input type="button" value="Back" class="button" 	onclick="window.location.replace('search')" />

				</div>
			</div>
		</div>
	</div>


	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>