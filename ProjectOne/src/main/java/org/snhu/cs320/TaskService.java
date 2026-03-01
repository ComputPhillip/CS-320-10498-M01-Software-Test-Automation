package org.snhu.cs320;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private final Map<String, Task> tasks = new HashMap<>();

	public void addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("task must not be null");
		}
		String taskId = task.getTaskId();
		if (tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task ID already exists: " + taskId);
		}
		tasks.put(taskId, task);
	}

	public Task addTask(String taskId, String name, String description) {
		Task task = new Task(taskId, name, description);
		addTask(task);
		return task;
	}

	public void deleteTask(String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("taskId must not be null");
		}
		Task removed = tasks.remove(taskId);
		if (removed == null) {
			throw new IllegalArgumentException("No task found for ID: " + taskId);
		}
	}

	public void updateName(String taskId, String name) {
		getTask(taskId).setName(name);
	}

	public void updateDescription(String taskId, String description) {
		getTask(taskId).setDescription(description);
	}

	public Task getTask(String taskId) {
		if (taskId == null) {
			throw new IllegalArgumentException("taskId must not be null");
		}
		Task task = tasks.get(taskId);
		if (task == null) {
			throw new IllegalArgumentException("No task found for ID: " + taskId);
		}
		return task;
	}
}
