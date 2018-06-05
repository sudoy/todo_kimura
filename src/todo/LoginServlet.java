package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.beans.User;
import todo.utils.DBUtils;

@WebServlet("/login.html")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		//バリデーションチェック
		List<String> errors = validate(email, password);
		if(errors.size() > 0) {
			session.setAttribute("errors", errors);

			getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(req, resp);

			return;
		}

		//関連チェック
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try{
			con = DBUtils.getConnection();
			//SQL
			sql = "SELECT id, email, password, name FROM users WHERE email = ? AND password = MD5(?);";

			//SELECT命令の準備
			ps = con.prepareStatement(sql);

			ps.setString(1, email);
			ps.setString(2, password);

			//SELECT命令を実行
			rs = ps.executeQuery();

			if(rs.next()) {
				//emailとpasswordが正しい時

				//ログイン処理
				//(セッションにログイン情報を保存する)
				User user  = new User(rs.getInt("id"),
								rs.getString("email"),
								rs.getString("password"),
								rs.getString("name"));

				session.setAttribute("user", user);

				resp.sendRedirect("index.html");
			}else {
				//どちらかが間違っているとき
				errors.add("メールアドレスかパスワードが間違っています。");
				session.setAttribute("errors", errors);
				getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
				.forward(req, resp);
			}


		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			//終了処理
			try{
				DBUtils.close(rs);
				DBUtils.close(ps);
				DBUtils.close(con);
			}catch(Exception e){
			}
		}

	}

	private List<String> validate(String email, String password) {
		//エラーメッセージを入れるためのListを作る
		List<String> errors = new ArrayList<>();

		//メールアドレスの必須入力
		if(email.equals("")) {
			errors.add("メールアドレスは必須入力です。");
		}

		//パスワードの必須入力
		if(password.equals("")) {
			errors.add("パスワードは必須入力です。");
		}

		return errors;
	}
}
