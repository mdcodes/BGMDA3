/**
 * Names: Michal Drahorat, Brody Gartner
 * Description: The Area Detail Servlet
 * 
 * Date: 2/16/18
 */
package prog3060.bgmd.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import prog3060.bgmd.*;
import prog3060.bgmd.beans.ConnectionBean;
import prog3060.bgmd.beans.TotalIncomeBeanLocal;
import prog3060.bgmd.entities.Age;
import prog3060.bgmd.entities.CensusYear;
import prog3060.bgmd.entities.GeographicArea;
import prog3060.bgmd.entities.Household;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AreaDetailServlet
 */
@WebServlet("/AreaDetail")
public class AreaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	TotalIncomeBeanLocal totalIncomeBean;
	
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
		String areaId = request.getParameter("areaId");
		int level = Integer.parseInt(request.getParameter("level"));
//		int altCode = Integer.parseInt(request.getParameter("altCode"));
		if(ConnectionBean.isConnected()) {
			try {
				List<GeographicArea> geoList = cb.getGeoInfo(user, pass, areaId);
				List<Age> ageList = cb.getAgeInfo(user, pass, areaId);
				
				GeographicArea ga = geoList.get(0); 
				CensusYear cy = ageList.get(0).getCensusYear();
				
				String reportString = totalIncomeBean.getResultFromLocal(ga, cy, user, pass);
				session.setAttribute("output", reportString);
				
				request.setAttribute("geoDetails", geoList);
				request.setAttribute("ageDetails", ageList);
				
				if(level== 0)
				{
					List<Household> householdList = cb.getHouseholdInfo(user, pass, areaId);
					
					List<GeographicArea> geoSubList = cb.getSubCountry(user, pass);
					
					request.setAttribute("householdAmount", householdList.size());
					request.setAttribute("householdDetails", householdList);
					request.setAttribute("subLevelCountry", geoSubList);
	
				}
				else if(level == 1)
				{
					List<Household> householdList = cb.getHouseholdInfo(user, pass, areaId);
					
					List<GeographicArea> geoSubList = cb.getSubProvince(user, pass);
					
					System.out.println(householdList.size());
					request.setAttribute("householdDetails", householdList);
					request.setAttribute("subLevelProvince", geoSubList);
	
				}
				
				else if(level == 2)
				{
					List<GeographicArea> geoSubList = cb.getSubCity(user, pass);
					
					request.setAttribute("subLevelCity", geoSubList);
	
				}
				request.getRequestDispatcher("./detail.jsp").forward(request, response);
				
				
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
