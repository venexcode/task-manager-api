package com.task_manager_api.demo.controller;

import com.task_manager_api.demo.model.TareaModel;
import com.task_manager_api.demo.repository.ITareaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private ITareaRepository tareaRepository;

    @GetMapping("/listar")
    public List<TareaModel> listarTarea() {
        return tareaRepository.findAll();
    }

    @PostMapping("/guardar")
    public TareaModel agregarTareas(@RequestBody TareaModel tarea) {
         return tareaRepository.save(tarea);
    }
}
