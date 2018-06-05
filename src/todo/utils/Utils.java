package todo.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Utils {
	public static boolean checkLogin(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session = req.getSession();
		//ログインチェック
		if(session.getAttribute("user") == null) {
			//ログインしていない
			List<String> errors = new ArrayList<>();
			errors.add("ログインしてください。");
			session.setAttribute("errors", errors);
			resp.sendRedirect("login.html");
			return false;
		}else {
			//ログインしている
			return true;
		}
	}
}
