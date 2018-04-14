/*
 * Name: Michal Drahorat, Brody Gartner
 * Description: The Login Servlet
 * Date: February 11th, 2018
 */

package prog3060.bgmd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.derby.authentication.UserAuthenticator;

import prog3060.bgmd.beans.ConnectionBean;
import prog3060.bgmd.beans.ConnectionStuff;
import prog3060.bgmd.beans.EntityManagerFactoryListener;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    public void init() {
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("") || password.equals("")) {
			return;
		}
		else {
			ConnectionBean cb = new ConnectionBean();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("connectionbean", cb);
			try {
				cb.OpenConnnection(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ConnectionBean.isConnected()) {
				response.sendRedirect("./index.jsp");
			}
			else {
				response.sendRedirect("./login.jsp");
			}
		}
		
		
	}
}
