<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
		String filename = request.getParameter("file");
	    //���߿ͻ��˳������ؿ򣬲�ָ�����ؿ��е��ļ���
		response.setHeader("Content-Disposition","attachment;filename="+filename);   
    	//ָ���ļ�����   
		response.setContentType("image/jpeg");   
		//ָ���ļ�
		RequestDispatcher rd = request.getRequestDispatcher("/image/" + filename);
		rd.forward(request, response);
 %>