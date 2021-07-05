<%@ page import="servlet.ChoiseXXX" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab_17</title>

</head>

<script>
	function sendFile() {
		let fileSrc = document.getElementById("file").files[0];
		let fd = new FormData();
		fd.append("file", fileSrc);

		let xhr = new XMLHttpRequest();
		xhr.open("POST", "http://localhost:8080/Lab_23/Sss?fileName=" + (fileSrc.name), true)
		xhr.onreadystatechange = function () {
			if (this.readyState === 4) {
				if (this.status === 200)
					alert("Uploaded!");
				else
					alert(this.status + "\n" + this.statusText);
			}
		}
		xhr.send(fd);
	}

</script>

<body>
<%
	String d = (String) config.getServletContext().getInitParameter("doc-dir");
	ChoiseXXX ch = new ChoiseXXX(d, "docx");
	String ll = null;
	for (int i = 0; i < ch.listxxx.length; i++) {
		ll = ch.listxxx[i];
%>
<br />
<a href="Sss?file=<%=ll%>"> <%=ll%> </a>
<%}%>
<br/>

<br><form action="Sss" method="post" enctype="multipart/form-data">
	<input type="file" name="file" id="file"/>
	<input type="button" onclick="sendFile()" value="Upload File"/>
</form>
</body>
</html>