/*
 * Name: Michal Drahorat, Brody Gartner
 * Description: The Geographic Area Data Servlet
 * Date: February 11th, 2018
 */

package prog3060.bgmd.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.bgmd.beans.ConnectionBean;
import prog3060.bgmd.beans.GeographicAreaBean;
import prog3060.bgmd.daos.GeographicAreaDAO;

/**
 * Servlet implementation class GeographicAreaServlet
 */
@WebServlet(name = "GeographicArea", urlPatterns = { "/GeographicArea" })
public class GeographicAreaServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private GeographicAreaDAO gadao;
	
	@Override
	public void init() {
		gadao = new GeographicAreaDAO();
		ConnectionBean.getConnection();
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer levelCode = Integer.parseInt(request.getParameter("level"));
    	
		if(levelCode.equals(null)) 
		{
			request.setAttribute("data", "select a code");
		}
		else 
		{
			
			try
			{
				List<GeographicAreaBean> gabList = gadao.getGeoAreasByLevel(levelCode);
			
				request.setAttribute("gabList", gabList);
				request.getRequestDispatcher("./index.jsp").forward(request, response);

			
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

    }

}
