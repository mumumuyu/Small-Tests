<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	<SCRIPT LANGUAGE="JavaScript">
  	var xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  	function showInfo(){
		xmlHttp.open("GET", "info.jsp", true);
		xmlHttp.onreadystatechange=showState;
		xmlHttp.send();
	}
	function showState(){
		document.writeln(xmlHttp.readyState);
	}
	</SCRIPT>  	
    	��ӭ������ϵͳ. <HR>
    	<input type="button" value="��ʾ��˾��Ϣ" onClick="showInfo()">
  </body>
</html>
