package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SCRDao;

/**
 * Servlet implementation class scrController
 */
@WebServlet("/")
public class scrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scrController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPro(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPro(request, response);
	}
	
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath();
		String command = request.getServletPath();
		String site = null;
		
		SCRDao dao = new SCRDao();
		switch(command) {
		case "/home" : site = "index.jsp"; break;
		case "/viewall" : site = dao.ViewAll(response, request); break;
		case "/resv" : site = "resv.jsp";	
		case "/result" : 
			PrintWriter out = response.getWriter();
			if(dao.ScoreInsert(response, request)==1) {
				out.println("<script>");
				out.println(" alert('개인정보등록정보가 등록 되었습니다!'); location.href='" + context + "';  ");
				out.println("</script>");
				out.flush();
			}; break;
		case "stat" : site = ""; break;
		}
		
		getServletContext().getRequestDispatcher("/"+site).forward(request, response);
		
	}

}
