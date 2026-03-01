package org.snhu.cs320;

public final class Task {
	private final String taskId;
	private String name;
	private String description;

	public Task(String taskId, String name, String description) {
		this.taskId = validateId(taskId);
		this.name = validateName(name);
		this.description = validateDescription(description);
	}

	public String getTaskId() {
		return taskId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = validateName(name);
	}

	public void setDescription(String description) {
		this.description = validateDescription(description);
	}

	private static String validateId(String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("taskId must not be null");
		}
		if (taskId.length() > 10) {
			throw new IllegalArgumentException("taskId must be 10 characters or fewer");
		}
		return taskId;
	}

	private static String validateName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null");
		}
		if (name.length() > 20) {
			throw new IllegalArgumentException("name must be 20 characters or fewer");
		}
		return name;
	}

	private static String validateDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("description must not be null");
		}
		if (description.length() > 50) {
			throw new IllegalArgumentException("description must be 50 characters or fewer");
		}
		return description;
	}
}
