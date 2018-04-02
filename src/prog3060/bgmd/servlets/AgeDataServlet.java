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
import prog3060.bgmd.daos.AgeDataDAO;
import prog3060.bgmd.entities.Age;
import prog3060.bgmd.entities.AgeGroup;
import prog3060.bgmd.entities.CensusYear;

/**
 * Servlet implementation class AgeDataServlet
 */
@WebServlet("/AgeData")
public class AgeDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AgeDataDAO addo;
	
	@Override
	public void init() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnectionBean cb = new ConnectionBean();
		cb.setUsername("user");
		cb.setPassword("123");
		cb.setConnected(true);
		
		try {
			List<Object[]> list = cb.getAgeGroups();
			
			List<Age> ageList = new ArrayList<>();
			List<AgeGroup> ageGroups = new ArrayList<>();
			List<CensusYear> cenYears = new ArrayList<>();
			
			for(Object[] items : list) {
				Age ageRoot = (Age) items[0];
				AgeGroup ageGroup = (AgeGroup) items[1];
				CensusYear cenYear = (CensusYear) items[2];
				
				ageList.add(ageRoot);
				ageGroups.add(ageGroup);
				cenYears.add(cenYear);
			}
			
			request.setAttribute("ageList", ageList);
			request.setAttribute("ageGroup", ageGroups);
			request.setAttribute("cenYear", cenYears);
			request.getRequestDispatcher("./agegroups.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
