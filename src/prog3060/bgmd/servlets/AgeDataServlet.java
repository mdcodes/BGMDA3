/*
 * Name: Michal Drahorat, Brody Gartner
 * Description: The Age Data Servlet
 * Date: February 11th, 2018
 */

package prog3060.bgmd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.bgmd.beans.AgeDataBean;
import prog3060.bgmd.beans.ConnectionBean;
import prog3060.bgmd.daos.AgeDataDAO;

/**
 * Servlet implementation class AgeDataServlet
 */
@WebServlet("/AgeData")
public class AgeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AgeDataDAO addo;
	
	@Override
	public void init() {
		addo = new AgeDataDAO();
		ConnectionBean.getConnection();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AgeDataBean> ageGroup = addo.getAgeData();
		request.setAttribute("ageGroup", ageGroup);
		request.getRequestDispatcher("./agegroups.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
