/*
 * Name: Michal Drahorat, Brody Gartner
 * Description: The Age Data Servlet
 * Date: February 11th, 2018
 */

package prog3060.bgmd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.bgmd.beans.ConnectionBean;
import prog3060.bgmd.entities.Age;
import prog3060.bgmd.entities.AgeGroup;
import prog3060.bgmd.entities.CensusYear;

/**
 * Servlet implementation class AgeDataServlet
 */
@WebServlet("/AgeData")
public class AgeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		String pass = (String) session.getAttribute("password");
		ConnectionBean cb = (ConnectionBean) session.getAttribute("connectionbean");
		if(ConnectionBean.isConnected()) {
			try {
				List<Age> list = cb.getAgeGroups(user, pass);
				request.setAttribute("ageList", list);
				request.getRequestDispatcher("./agegroups.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
