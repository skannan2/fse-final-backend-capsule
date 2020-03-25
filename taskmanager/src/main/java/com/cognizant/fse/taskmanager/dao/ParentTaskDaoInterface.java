package com.cognizant.fse.taskmanager.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.fse.taskmanager.model.ParentTaskTbl;


/**
 * Created by Sanjay
 */
@Repository
public interface ParentTaskDaoInterface extends JpaRepository<ParentTaskTbl, Integer> {

	@Query("select c from ParentTaskTbl c where c.parentTask=:name")
    public List<ParentTaskTbl> findParentTaskByName(String name);

}
