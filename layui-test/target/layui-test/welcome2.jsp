<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	<SCRIPT LANGUAGE="JavaScript">
  	function showInfo(){
  		var xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		xmlHttp.open("GET", "info.jsp", true);		
		xmlHttp.onreadystatechange=function() {
			if (xmlHttp.readyState==4) {
				infoDiv.innerHTML = xmlHttp.responseText;
			}
		}
		xmlHttp.send();
	}
	</SCRIPT>  	
    	��ӭ������ϵͳ. <HR>
    	<input type="button" value="��ʾ��˾��Ϣ" onClick="showInfo()">
    	<div id="infoDiv"></div>
  </body>
</html>
