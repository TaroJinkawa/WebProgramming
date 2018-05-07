package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(null == session.getAttribute("userInfo")) {
			response.sendRedirect("LoginServlet");
			return;
		}

		String id = request.getParameter("id");

		UserDao userdata = new UserDao();

		User userData = userdata.UserDate(id);

		request.setAttribute("userData", userData);





		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userupdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String id = request.getParameter("id");


		if(password.equals(password2)) {


			if(password.equals("")) {
				UserDao userupdatenopass = new UserDao();
				userupdatenopass.updateDateNoPass(name, birthDate, id);

				response.sendRedirect("ListServlet");
				return;
			}



			UserDao userupdate = new UserDao();
			userupdate.updateDate(password, name, birthDate, id);


			response.sendRedirect("ListServlet");



		}else {

			request.setAttribute("errMsg", "パスワードが一致しません");


			UserDao userdata = new UserDao();

			User userData = userdata.UserDate(id);

			request.setAttribute("userData", userData);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userupdate.jsp");
			dispatcher.forward(request, response);


			return;

		}

	}

}
