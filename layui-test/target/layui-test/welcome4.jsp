<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'p1.jsp' starting page</title>
  </head>
  
  <body>
  	<SCRIPT LANGUAGE="JavaScript">
  	var xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
  	function showInfo(){
		xmlHttp.open("GET", "info.jsp", true);
		xmlHttp.onreadystatechange=showState;
		xmlHttp.send();
	}
	function  showState(){
		if(xmlHttp.readyState==4){
			//infoDiv.innerText = xmlHttp.responseText;
			infoDiv.innerHTML = xmlHttp.responseXml;
		}
		else{
			infoDiv.innerText = "�������룬���Ժ�......";
		}			
	}
	
	</SCRIPT>  	
    	��ӭ�����ʻ�����ϵͳ. <HR>
    	<input type="button" value="��ʾ��˾��Ϣ" onClick="showInfo()"><BR>
    	<div id="infoDiv"></div>
  </body>
</html>
