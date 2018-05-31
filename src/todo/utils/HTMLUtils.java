package todo.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

import todo.beans.Todo;

public class HTMLUtils {

	public static String formatImportance(Todo todo) {

		if(todo.getImportance() == 1) {
			return "★";
		}else if(todo.getImportance() == 2) {
			return "★★";
		}else if(todo.getImportance() == 3) {
			return "★★★";
		}else {
			return "";
		}

	}

	public static String getDeadline(Todo todo) {
		Date deadline = todo.getDeadline();
		if(deadline == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(deadline);

	}
}
