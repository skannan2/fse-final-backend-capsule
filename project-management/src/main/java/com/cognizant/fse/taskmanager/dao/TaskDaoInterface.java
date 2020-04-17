package com.cognizant.fse.taskmanager.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.fse.taskmanager.model.TaskTbl;


/**
 * Created by Sanjay
 */
@Repository
public interface TaskDaoInterface extends CrudRepository<TaskTbl, Integer> {

}
