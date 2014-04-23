package game;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GameController {

	public GameController(HttpServletRequest request,
			HttpServletResponse response) {

	}

	public String[][] getCoordsFromSession(HttpSession session) {
		String[][] coord = (String[][]) session.getAttribute("coords");

		if (coord == null) {
			coord = new String[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					coord[i][j] = "" + ((4 * i) + j + 1);
				}
			}
			coord[3][3] = " ";
		}
		return coord;
	}

	public String[][] exchangeCells(int[] empty, int iPressed, int jPressed,
			String[][] coord) {

		int i = empty[0];
		int j = empty[1];
		String savedValue = coord[i][j];
		coord[i][j] = coord[iPressed][jPressed];
		coord[iPressed][jPressed] = savedValue;
		return coord;

	}

	public void updateLayout(String[][] coord, HttpSession session) {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				session.setAttribute("b" + ((4 * i) + j + 1), coord[i][j]);
			}
		}
	}

	public int[] findEmptyCell(String key, String[][] coord, int iPressed,
			int jPressed) {
		int cx, cy;
		if (!key.equals(" ")) {
			try {
				cx = iPressed - 1;
				cy = jPressed;
				if (cx >= 0 && coord[cx][cy].equals(" ")) {
					int[] retVal = { cx, cy };
					return retVal;
				}
				cx = iPressed;
				cy = jPressed - 1;
				if (cy >= 0 && coord[cx][cy].equals(" ")) {
					int[] retVal = { cx, cy };
					return retVal;
				}

				cx = iPressed + 1;
				cy = jPressed;

				if (cx <= 3 && coord[cx][cy].equals(" ")) {
					int[] retVal = { cx, cy };
					return retVal;
				}

				cx = iPressed;
				cy = jPressed + 1;

				if (cy <= 3 && coord[cx][cy].equals(" ")) {
					int[] retVal = { cx, cy };
					return retVal;
				}

			} catch (Exception ex) {

			}
		}
		int[] retVal = { -1, -1 };
		return retVal;
	}

	public int[] findCoordsPressed(String keyPressed, String[][] coord) {

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (coord[i][j].equals(keyPressed)) {
					int[] retVal = { i, j };
					return retVal;
				}
			}
		}
		return null;
	}

	public String findKeyPressed(HttpServletRequest request) {
		Map<String, String[]> params = request.getParameterMap();
		String keyPressed = "";
		for (String s : params.keySet()) {
			for (int k = 0; k < params.get(s).length; k++) {
				keyPressed = params.get(s)[k];
			}
		}
		return keyPressed;
	}

}
