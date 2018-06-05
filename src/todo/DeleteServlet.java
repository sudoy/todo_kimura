package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.utils.DBUtils;
import todo.utils.Utils;

@WebServlet("/delete.html")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if(!Utils.checkLogin(req, resp)) {
			return;
		}

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();

		String todoId = req.getParameter("todoId");

		List<String> errors = validate(todoId);

		//Listにエラーをaddした回数が一回以上の場合の処理
		if(errors.size() > 0) {
			session.setAttribute("errors", errors);
			resp.sendRedirect("index.html");

			return;
		}

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try{
			con = DBUtils.getConnection();

			//UPDATE文
			sql = "DELETE FROM todo"
					+ " WHERE todo_id = ?";

			//INSERT命令の準備
			ps = con.prepareStatement(sql);

			//INSERT命令にポストデータの内容をセット

			ps.setString(1, todoId);

			//sqlを確認(sql文をコピーしてmysqlで確認)
			//System.out.println(ps);

			//INSERT命令を実行
			ps.executeUpdate();

			List<String> successes = new ArrayList<>();
			successes.add("削除しました。");
			session.setAttribute("successes", successes);

			resp.sendRedirect("index.html");
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			//終了処理
			try{
				DBUtils.close(ps);
				DBUtils.close(con);
			}catch(Exception e){
			}
		}

	}

	private List<String> validate(String todoId) {
		//エラーメッセージを入れるためのListを作る
		List<String> errors = new ArrayList<>();

		//idの必須入力
		if(todoId == null || todoId.equals("")) {
			errors.add("不正なアクセスです。");
		}

		return errors;
	}
}

