package com.task_manager_api.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
@Entity
public class TareaModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String descripcion;
    private boolean completado;
}
