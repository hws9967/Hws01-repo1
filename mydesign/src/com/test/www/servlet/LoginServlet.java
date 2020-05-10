package com.test.www.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.www.po.User;
import com.test.www.service.ServiceUser;
/**
 * 
    * @ClassName: LoginServlet
    * @Description: ?????servlet??
    * @author 395621926
    * @date 2020?1?22?
    *
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//String name = req.getParameter("username");
		//String number  = req.getParameter("number");
		String username = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");
		String password = new String(req.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		if(username==null||"".equals(username)||null==password||"".equals(password)) {
			req.setAttribute("flag", "0");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			System.out.println("error");
		}else {
		
		ServiceUser serviceUser = new ServiceUser();
		User user =new User();
		
		//????????
		user.setU_username(username);
		user.setU_number(password);
		
		//???¨²???
		boolean flag = serviceUser.LoginUser(user);
		String JDBCInfo = "error";
//		???????? 0??????????1????????????????????????????????????????? 2:???????????????????????
		if(flag) {
			List<User> list = serviceUser.userList();
			req.setAttribute("list", list);
			for(User user1:list) {
				if(username.equals(user1.getU_username())&&password.equals(user1.getU_password())) {
					user = user1;
					HttpSession session = req.getSession();
					session.setAttribute("admin", user1);
					if("0".equals(user1.getU_authority())) {
						req.setAttribute("user", user1);
						req.getRequestDispatcher("updateUser.jsp").forward(req, resp);
					}
					break;
				}
			}
			if(!"0".equals(user.getU_authority())) {
			req.getRequestDispatcher("hello.jsp").forward(req, resp);
			System.out.println("???");
			}
		}
		else {
			req.setAttribute("flag", "0");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			System.out.println("error");
		}
		}
		
		
	}

}

