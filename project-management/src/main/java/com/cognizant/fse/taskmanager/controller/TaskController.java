package com.cognizant.fse.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.fse.taskmanager.model.Task;
import com.cognizant.fse.taskmanager.model.TaskTbl;
import com.cognizant.fse.taskmanager.service.TaskService;

/**
 * Created by Sanjay on 10/28/2018.
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	
	@PostMapping(path = "/addtask", consumes = "application/json")
	public ResponseEntity<String> addTask(@RequestBody Task task) {

		taskService.addUpdateTask(task);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PutMapping("/updatetask")
	public ResponseEntity<String> updateTask(@RequestBody Task task) {		

		taskService.addUpdateTask(task);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping(path="/deletetask/{taskId}")
	public ResponseEntity<String> deleteBook(@PathVariable("taskId") int taskId) {

		taskService.deleteTask(taskId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping("/gettasklist")
	public ResponseEntity<List> getAllTask() {
		
		List<TaskTbl> taskList = taskService.getTask();
		System.out.println("**TaskList***"+taskList.size());
		
		return new ResponseEntity<List>(taskList, HttpStatus.OK);
	}
	
	@GetMapping("/gettask/{taskId}")
	public ResponseEntity<Task> getTask(@PathVariable("taskId") int taskId) {
		
		TaskTbl task = taskService.getTaskById(taskId);
		System.out.println("**Task***"+task);
		Task taskObj = new Task();
		if (task != null) {
			taskObj.setTaskId(task.getTaskId());
			taskObj.setTask(task.getTask());
			taskObj.setParentTaskId(task.getParentTaskTbl().getParentTaskId());
			taskObj.setParentTask(task.getParentTaskTbl().getParentTask());
			taskObj.setPriority(task.getPriority());
			taskObj.setStartDate(task.getStartDate().toString());
			taskObj.setEndDate(task.getEndDate().toString());
		}		
		
		return new ResponseEntity<Task>(taskObj, HttpStatus.OK);
	}
}
