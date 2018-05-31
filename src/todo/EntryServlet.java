package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.utils.DBUtils;

@WebServlet("/entry.html")
public class EntryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//entry.jspへforward
		getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp")
			.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

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
			ps.setString(1, req.getParameter("title"));
			ps.setString(2, req.getParameter("detail"));
			ps.setString(3, req.getParameter("importance"));
			ps.setString(4, req.getParameter("deadline"));

			//INSERT命令を実行
			ps.executeUpdate();

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
		//処理後は入力フォームにリダイレクト
		resp.sendRedirect("index.html");
	}
}