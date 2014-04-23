package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[][] coords = { { "1", "5", "9", "13" },
			{ "2", "6", "10", "14" }, { "3", "7", "11", "15" },
			{ "4", "8", "12", " " } };
	private int iPressed = -1;
	private int jPressed = -1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		setLayout(session);
		response.sendRedirect("/helloworld/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Map<String, String[]> params = request.getParameterMap();
		String keyPressed = findKeyPressed(params);
		findCoordsPressed(keyPressed);

		int[] empty = findEmptyCell(keyPressed);

		exchangeCells(empty);
		setLayout(session);
		response.sendRedirect("/helloworld/index.jsp");

	}

	private void exchangeCells(int[] empty) {
		int i = empty[0];
		int j = empty[1];
		if (i != -1) {
			String savedValue = coords[i][j];
			coords[i][j] = coords[iPressed][jPressed];
			coords[iPressed][jPressed] = savedValue;
		}
	}

	private void setLayout(HttpSession session) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				session.setAttribute("b" + ((4 * i) + j + 1), coords[i][j]);
			}
		}
	}

	private int[] findEmptyCell(String key) {
		int cx, cy;
		if (!key.equals(" ")) {
			try {
				cx = iPressed - 1;
				cy = jPressed;
				if (cx >= 0 && coords[cx][cy].equals(" ")) {
					int[] retVal = { cx, cy };
					return retVal;
				}
				cx = iPressed;
				cy = jPressed - 1;
				if (cy >= 0 && coords[cx][cy].equals(" ")) {
					int[] retVal = { cx, cy };
					return retVal;
				}

				cx = iPressed + 1;
				cy = jPressed;

				if (cx <= 3 && coords[cx][cy].equals(" ")) {
					int[] retVal = { cx, cy };
					return retVal;
				}

				cx = iPressed;
				cy = jPressed + 1;

				if (cy <= 3 && coords[cx][cy].equals(" ")) {
					int[] retVal = { cx, cy };
					return retVal;
				}

			} catch (Exception ex) {

			}
		}
		int[] retVal = { -1, -1 };
		return retVal;
	}

	private void findCoordsPressed(String keyPressed) {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (coords[i][j].equals(keyPressed)) {
					iPressed = i;
					jPressed = j;
				}
			}
		}
	}

	private String findKeyPressed(Map<String, String[]> params) {
		String keyPressed = "";
		for (String s : params.keySet()) {
			for (int k = 0; k < params.get(s).length; k++) {
				keyPressed = params.get(s)[k];
			}
		}
		return keyPressed;
	}

}
