<%@ page language="java" pageEncoding="gb2312"%>
<html>
	<body>
		�ļ��ϴ�
		<hr>
		<form action="/Prj13/servlets/UploadServlet" method="post" 
			enctype="multipart/form-data">
			��ѡ��һ���ļ������ϴ���
			<input type="file" name="myFile">
			<input type="submit" value="�ϴ�">
		</form>
		${msg}
	</body>
</html>
