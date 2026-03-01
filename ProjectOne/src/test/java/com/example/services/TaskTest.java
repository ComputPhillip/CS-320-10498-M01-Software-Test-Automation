package com.example.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
	@Test
	void createTask_validFields_setsAllFields() {
		Task task = new Task("t1", "Call mom", "Call mom on Sunday afternoon");
		assertEquals("t1", task.getTaskId());
		assertEquals("Call mom", task.getName());
		assertEquals("Call mom on Sunday afternoon", task.getDescription());
	}

	@Test
	void createTask_taskIdNull_throws() {
		assertThrows(IllegalArgumentException.class, () -> new Task(null, "Name", "Desc"));
	}

	@Test
	void createTask_taskIdTooLong_throws() {
		assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Desc"));
	}

	@Test
	void createTask_nameNull_throws() {
		assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "Desc"));
	}

	@Test
	void createTask_nameTooLong_throws() {
		assertThrows(IllegalArgumentException.class, () -> new Task("1", "123456789012345678901", "Desc"));
	}

	@Test
	void createTask_descriptionNull_throws() {
		assertThrows(IllegalArgumentException.class, () -> new Task("1", "Name", null));
	}

	@Test
	void createTask_descriptionTooLong_throws() {
		String longDesc = "123456789012345678901234567890123456789012345678901"; // 51 chars
		assertThrows(IllegalArgumentException.class, () -> new Task("1", "Name", longDesc));
	}

	@Test
	void taskId_isNotUpdatable() {
		Task task = new Task("id", "Name", "Desc");
		task.setName("New Name");
		task.setDescription("New Desc");
		assertEquals("id", task.getTaskId());
	}
}
