package servlets;

import game.GameController;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GameController controller;

	public GameServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		controller.updateLayout(controller.getCoordsFromSession(session),
				session);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		// response.sendRedirect("/helloworld/index.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (controller == null) {
			controller = new GameController(request, response);
		}
		HttpSession session = request.getSession(true);
		String[][] coord = controller.getCoordsFromSession(session);
		String keyPressed = controller.findKeyPressed(request);
		int[] pressed = controller.findCoordsPressed(keyPressed, coord);
		int[] empty = controller.findEmptyCell(keyPressed, coord, pressed[0],
				pressed[1]);
		if (empty[0] != -1) {
			coord = controller.exchangeCells(empty, pressed[0], pressed[1],
					coord);
		}
		controller.updateLayout(coord, session);

		session.setAttribute("coords", coord);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		// response.sendRedirect("/helloworld/index.jsp");

	}
}
