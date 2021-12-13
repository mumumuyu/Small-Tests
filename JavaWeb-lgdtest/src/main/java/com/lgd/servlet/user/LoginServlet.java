package com.lgd.servlet.user;

import com.google.gson.Gson;
import com.lgd.pojo.ResBody;
import com.lgd.pojo.User;
import com.lgd.service.user.UserService;
import com.lgd.service.user.UserServiceImpl;
import com.lgd.utils.Constants;
import org.w3c.dom.html.HTMLAppletElement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Asus
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	//�����û�����������ҵ��㡢ת����ͼ
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		System.out.println("login ============ " );

		//��ȡ�û���������
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		//����service�����������û�ƥ��
		UserService userService = new UserServiceImpl();
		User user = userService.login(id,pwd);
		PrintWriter out = resp.getWriter();
		if(null != user){
			//��¼�ɹ�
			System.out.println("succeed ============ " );
			//����session
			req.getSession().setAttribute(Constants.USER_SESSION,user);
			out.print("<script>alert('succeed!');window.location.href='"+getServletContext().getContextPath()+"/login/theme.jsp'</script>");
		}else {
			System.out.println("��¼ʧ�� ============ ");
			//ҳ����ת��login.jsp��������ʾ��Ϣ--ת��
			out.print("<script>alert('The username or password is wrong!!');window.location.href='"+getServletContext().getContextPath()+"/login/login.jsp'</script>");
		}
	}
}
