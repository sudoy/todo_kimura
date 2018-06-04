package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.beans.Todo;
import todo.utils.DBUtils;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String id = req.getParameter("todoId");

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try{
			con = DBUtils.getConnection();

			//SQL
			sql = "SELECT todo_id, title, detail, importance, deadline FROM todo WHERE todo_id = ?;";

			//SELECT命令の準備
			ps = con.prepareStatement(sql);

			ps.setString(1, id);

			//SELECT命令を実行
			rs = ps.executeQuery();

			//System.out.println(ps);

			//ResultSetをJavaBeansに変換
			rs.next();

			int todoId = rs.getInt("todo_id");
			String title = rs.getString("title");
			String detail = rs.getString("detail");
			int importance = rs.getInt("importance");
			Date deadline = rs.getDate("deadline");

			Todo todo = new Todo(todoId,title,detail,importance,deadline);

			//JavaBeansをJSPへ渡す
			req.setAttribute("todo", todo);

			//foward→index.jsp
			getServletContext().getRequestDispatcher("/WEB-INF/update.jsp")
				.forward(req, resp);
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();

		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		String importance = req.getParameter("importance");
		String deadline = req.getParameter("deadline");
		String todoId = req.getParameter("todoId");

		List<String> errors = validate(todoId, title, importance, deadline);

		//Listにエラーをaddした回数が一回以上の場合の処理
		if(errors.size() > 0) {
			session.setAttribute("errors", errors);

			getServletContext().getRequestDispatcher("/WEB-INF/update.jsp")
				.forward(req, resp);

			return;
		}

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try{
			con = DBUtils.getConnection();

			//UPDATE文
			sql = "UPDATE todo SET title = ?, detail = ?, importance = ?, deadline = ? WHERE todo_id = ?";

			//UPDATE命令の準備
			ps = con.prepareStatement(sql);

			//UPDATE命令にポストデータの内容をセット
			ps.setString(1, title);
			ps.setString(2, detail);
			ps.setString(3, importance);
			ps.setString(4, deadline.equals("")? null : deadline);
			ps.setString(5, todoId);

			//UPDATE命令を実行
			ps.executeUpdate();

			List<String> successes = new ArrayList<>();
			successes.add("登録しました。");
			session.setAttribute("successes", successes);

			//処理後は入力フォームにリダイレクト
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

	private List<String> validate(String todoId, String title, String importance, String deadline) {
		//エラーメッセージを入れるためのListを作る
		List<String> errors = new ArrayList<>();

		//idの必須入力
		if(todoId.equals("")) {
			errors.add("不正なアクセスです。");
		}

		//題名の必須入力チェック
		if(title.equals("")) {
			errors.add("題名は必須入力です。");
		}
		//題名100文字制限
		if(title.length() > 100) {
			errors.add("題名は100文字以内にしてください。");
		}

		//日付の形式yyyy/mm/ddだけにする
		if(!deadline.equals("")) {

		    try {
		    	DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

		    	df.setLenient(false);
				String s = df.format(df.parse(deadline));

				if(deadline.equals(s)) {

				}else {
					errors.add("期限は「YYYY/MM/DD」形式で入力してください。");
				}
			} catch (ParseException e) {
				errors.add("期限は「YYYY/MM/DD」形式で入力してください。");
			}
		}

		//重要度1-3だけにする
		if(!(importance.equals("1")) && !(importance.equals("2")) && !(importance.equals("3"))) {
			errors.add("不正なアクセスです。");
		}

		return errors;
	}
}
