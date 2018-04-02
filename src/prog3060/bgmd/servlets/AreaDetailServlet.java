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
import prog3060.bgmd.daos.GeographicAreaDAO;
import prog3060.bgmd.entities.GeographicArea;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AreaDetailServlet
 */
@WebServlet("/AreaDetail")
public class AreaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GeographicAreaDAO gdao;

	@Override
	public void init() {
		gdao = new GeographicAreaDAO();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnectionBean cb = new ConnectionBean();
		cb.setUsername("user");
		cb.setPassword("123");
		int areaId = Integer.parseInt(request.getParameter("name"));
		
		try {
			List<GeographicArea> list = cb.getAllGeoAreas(areaId);
			
			request.setAttribute("areaDetails", list);
			
			request.getRequestDispatcher("./detail.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(areaId == -1) {
			throw new NullPointerException();
		}
		
		else 
		{
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
