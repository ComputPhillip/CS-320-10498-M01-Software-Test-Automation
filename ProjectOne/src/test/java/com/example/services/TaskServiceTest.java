package com.example.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
	@Test
	void addTask_uniqueId_addsTask() {
		TaskService service = new TaskService();
		service.addTask("1", "Name", "Description");
		assertEquals("Name", service.getTask("1").getName());
	}

	@Test
	void addTask_duplicateId_throws() {
		TaskService service = new TaskService();
		service.addTask("1", "Name", "Description");
		assertThrows(IllegalArgumentException.class, () -> service.addTask("1", "Other", "Other"));
	}

	@Test
	void deleteTask_byId_removesTask() {
		TaskService service = new TaskService();
		service.addTask("1", "Name", "Description");
		service.deleteTask("1");
		assertThrows(IllegalArgumentException.class, () -> service.getTask("1"));
	}

	@Test
	void updateTaskFields_byId_updatesOnlyUpdatableFields() {
		TaskService service = new TaskService();
		service.addTask("1", "Name", "Description");

		service.updateName("1", "New Name");
		service.updateDescription("1", "New Description");

		Task updated = service.getTask("1");
		assertEquals("1", updated.getTaskId());
		assertEquals("New Name", updated.getName());
		assertEquals("New Description", updated.getDescription());
	}

	@Test
	void updateMissingTask_throws() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.updateName("missing", "New Name"));
	}
}
