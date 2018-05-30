package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

			req.setAttribute("rs", rs);
			//foward→index.jsp
			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
				.forward(req, resp);
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			//終了処理
			try{
				DBUtils.close(con);
				DBUtils.close(ps);
				DBUtils.close(rs);
			}catch(Exception e){
			}
		}
	}
}
