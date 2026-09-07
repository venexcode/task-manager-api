package com.task_manager_api.demo.controller;

import com.task_manager_api.demo.model.TareaModel;
import com.task_manager_api.demo.repository.ITareaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<TareaModel> agregarTareas(@RequestBody TareaModel tarea) {
        TareaModel tareaGuardada = tareaRepository.save(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaGuardada);
    }
}