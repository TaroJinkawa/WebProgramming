package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/NewUserServlet")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newuser.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		UserDao newuser = new UserDao();

		boolean isCheck = newuser.UserNameDate(loginId);

		if(isCheck) {
			request.setAttribute("errMsg", "このIDはすでに使われています");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/err.jsp");
			dispatcher.forward(request, response);
			return;
		}


		if(!password.equals(password2)) {
			request.setAttribute("errMsg", "パスワードが一致しません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/err.jsp");
			dispatcher.forward(request, response);
			return;
		}

		newuser.insertDate(loginId, password, name, birthDate);
		response.sendRedirect("ListServlet");





	}


}
