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

	public static String formatDeadline(Date deadline) {
		Todo todo = new Todo(0, null, null, 0, deadline);
		deadline = todo.getDeadline();
		if(deadline == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(deadline);
	}


	public static String checkImportance(String param, String value) {
		if(param.equals("") && value.equals("3")) {
			return "checked";
		}else if(param.equals(value)) {
			return "checked";
		}else {
			return "";
		}
	}

}
