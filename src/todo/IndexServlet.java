package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.beans.Todo;
import todo.utils.DBUtils;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try{
			con = DBUtils.getConnection();

			//SQL
			sql = "SELECT todo_id, title, detail, importance, deadline FROM todo ORDER BY todo_id;";

			//SELECT命令の準備
			ps = con.prepareStatement(sql);

			//SELECT命令を実行
			rs = ps.executeQuery();

			//ResultSetをJavaBeansに変換
			List<Todo> list = new ArrayList<>();

			while(rs.next()) {
				int todo_id = rs.getInt("todo_id");
				String title = rs.getString("title");
				String detail = rs.getString("detail");
				int importance = rs.getInt("importance");
				Date deadline = rs.getDate("deadline");
				Todo t = new Todo(todo_id,title,detail,importance,deadline);

				list.add(t);
			}

			//JavaBeansをJSPへ渡す
			req.setAttribute("list", list);

			req.setAttribute("rs", rs);
			//foward→index.jsp
			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
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
}
