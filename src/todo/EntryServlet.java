package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

import todo.utils.DBUtils;
import todo.utils.Utils;

@WebServlet("/entry.html")
public class EntryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if(!Utils.checkLogin(req, resp)) {
			return;
		}

		//entry.jspへforward
		getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp")
			.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if(!Utils.checkLogin(req, resp)) {
			return;
		}

		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();

		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		String importance = req.getParameter("importance");
		String deadline = req.getParameter("deadline");

		//バリデーションチェック(エラーの場合)
		//validateメソッドをListに代入
		List<String> errors = validate(title, importance, deadline);

		//Listにエラーをaddした回数が一回以上の場合の処理
		if(errors.size() > 0) {
			session.setAttribute("errors", errors);

			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp")
				.forward(req, resp);

			return;
		}

		//正常の場合
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try{
			con = DBUtils.getConnection();
			sql = "INSERT INTO todo(title,detail,importance,deadline)VALUES(?,?,?,?)";

			//INSERT命令の準備
			ps = con.prepareStatement(sql);

			//INSERT命令にポストデータの内容をセット
			ps.setString(1, title);
			ps.setString(2, detail);
			ps.setString(3, importance);
			//何も入力していない時にnullを入れる
			ps.setString(4, deadline.equals("")? null : deadline);

			//実行前かつプレースホルダーに値をセットした後
			//System.out.print(ps);

			//INSERT命令を実行
			ps.executeUpdate();

			List<String> successes = new ArrayList<>();
			successes.add("登録しました。");
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

	//戻り値の型boolean→List
	private List<String> validate(String title, String importance, String deadline) {
		//エラーメッセージを入れるためのListを作る
		List<String> errors = new ArrayList<>();

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