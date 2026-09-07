package com.task_manager_api.demo.repository;

import com.task_manager_api.demo.model.TareaModel;

import org.springframework.data.jpa.repository.JpaRepository;;

public interface ITareaRepository extends JpaRepository<TareaModel, Long>{
    
}
