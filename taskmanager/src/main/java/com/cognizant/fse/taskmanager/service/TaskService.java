package com.cognizant.fse.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.fse.taskmanager.dao.ParentTaskDaoInterface;
import com.cognizant.fse.taskmanager.dao.TaskDaoInterface;
import com.cognizant.fse.taskmanager.model.ParentTaskTbl;
import com.cognizant.fse.taskmanager.model.Task;
import com.cognizant.fse.taskmanager.model.TaskTbl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sanjay on 10/2/2018.
 */
@Service
public class TaskService {

	@Autowired
    private TaskDaoInterface taskDao;
	@Autowired
    private ParentTaskDaoInterface parentTaskDao;

	@Transactional
    public String addUpdateTask(Task task) {
		int parentTaskId = task.getParentTaskId();
		Optional<ParentTaskTbl> parentTaskObj = null;
		ParentTaskTbl parentTaskTbl = null;
		if (parentTaskId > 0) {
			parentTaskObj = parentTaskDao.findById(parentTaskId);
			parentTaskTbl = parentTaskObj.get();
			parentTaskTbl.setParentTaskId(parentTaskId);
			parentTaskTbl.setParentTask(task.getParentTask());	
			
			parentTaskDao.save(parentTaskTbl);			
		} else {
			parentTaskTbl = new ParentTaskTbl();
			
			parentTaskTbl.setParentTask(task.getParentTask());		
			parentTaskDao.save(parentTaskTbl);
			
			/*
			 * List<ParentTaskTbl> parentTaskList =
			 * parentTaskDao.findParentTaskByName(task.getParentTask());
			 * 
			 * for (ParentTaskTbl parentTask: parentTaskList) { parentTaskId =
			 * parentTask.getParentTaskId(); }
			 */		
		}
				
		
		int taskId = task.getTaskId();
		Optional<TaskTbl> taskObj = null;
		TaskTbl taskTbl = null;
		if (taskId > 0) {			
			taskObj = taskDao.findById(taskId);
			taskTbl = taskObj.get();
			taskTbl.setTaskId(taskId);
		} else {			
			taskTbl = new TaskTbl();
		} 
				
		System.out.println("***taskId**"+task.getTaskId());
		System.out.println("***task Name**"+task.getTask());
		System.out.println("***parent task Id**"+task.getParentTaskId());
		System.out.println("***parent task Name**"+task.getParentTask());
		System.out.println("***Priority**"+task.getPriority());
		System.out.println("***Start Date**"+task.getStartDate());
		System.out.println("***End date**"+task.getEndDate());
		
		taskTbl.setTask(task.getTask());
		//taskTbl.setParentTaskId(parentTaskId);
		taskTbl.setPriority(task.getPriority());
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate startdateTime = LocalDate.parse(task.getStartDate(), formatter);
		 
		taskTbl.setStartDate(startdateTime);
		LocalDate enddateTime = LocalDate.parse(task.getEndDate(), formatter);
		taskTbl.setEndDate(enddateTime);		
		taskTbl.setParentTaskTbl(parentTaskTbl);
		
		taskDao.save(taskTbl);
		
		return "Successful";
    }
	
		
	@Transactional
    public List<TaskTbl> getTask() {
		List<TaskTbl> taskList = (List<TaskTbl>) taskDao.findAll();
		
		return taskList;
    }
	
	@Transactional
    public TaskTbl getTaskById(int taskId) {
		Optional<TaskTbl> taskObj = taskDao.findById(taskId);
		TaskTbl task = (TaskTbl) taskObj.get();
		
		return task;
    }
	
	@Transactional
    public void deleteTask(int taskId) {
		
		taskDao.deleteById(taskId);
    }
			
		
}
