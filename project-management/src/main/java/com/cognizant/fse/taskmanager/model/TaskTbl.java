package com.cognizant.fse.taskmanager.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Sanjay
 */
@Entity
@Table
public class TaskTbl implements Serializable {
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/*
	 * public int getParentTaskId() { return parentTaskId; }
	 * 
	 * public void setParentTaskId(int parentTaskId) { this.parentTaskId =
	 * parentTaskId; }
	 */

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public ParentTaskTbl getParentTaskTbl() {
		return parentTaskTbl;
	}

	public void setParentTaskTbl(ParentTaskTbl parentTaskTbl) {
		this.parentTaskTbl = parentTaskTbl;
	}
	

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int taskId;
	@Column
	String task;
	@Column
	LocalDate startDate;
	@Column
	LocalDate endDate;
	@Column
	int priority;
	@ManyToOne
	private ParentTaskTbl parentTaskTbl;

}