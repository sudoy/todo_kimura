package todo.beans;

import java.sql.Date;

public class Todo {
	private int todoId;
	private String title;
	private String detail;
	private int importance;
	private Date deadline;

	public Todo(int todoId, String title, String detail, int importance, Date deadline) {
		super();
		this.todoId = todoId;
		this.title = title;
		this.detail = detail;
		this.importance = importance;
		this.deadline = deadline;
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}


}
