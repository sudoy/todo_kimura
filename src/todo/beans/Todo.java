package todo.beans;

import java.sql.Date;

public class Todo {
	private int todo_id;
	private String title;
	private String detail;
	private int importance;
	private Date deadline;

	public Todo(int todo_id, String title, String detail, int importance, Date deadline) {
		super();
		this.todo_id = todo_id;
		this.title = title;
		this.detail = detail;
		this.importance = importance;
		this.deadline = deadline;
	}

	public int getTodo_id() {
		return todo_id;
	}

	public void setTodo_id(int todo_id) {
		this.todo_id = todo_id;
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
