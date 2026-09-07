package com.task_manager_api.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task_manager_api.demo.controller.TareaController;
import com.task_manager_api.demo.model.TareaModel;
import com.task_manager_api.demo.repository.ITareaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TareaController.class)
public class TareaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ITareaRepository tareaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("GET /api/tareas/listar - Debe listar todas las tareas")
    void testObtenerTodasLasTareas() throws Exception {
        // Given
        TareaModel t1 = new TareaModel(1L, "Tarea 1", "Descripción 1", false);
        TareaModel t2 = new TareaModel(2L, "Tarea 2", "Descripción 2", true);
        given(tareaRepository.findAll()).willReturn(List.of(t1, t2));

        // When & Then (Llamada a /api/tareas/listar)
        mockMvc.perform(get("/api/tareas/listar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].titulo").value("Tarea 1"))
                .andExpect(jsonPath("$[1].completado").value(true));
    }

    @Test
    @DisplayName("POST /api/tareas/guardar - Debe crear una tarea y retornar 201 Created")
    void testCrearTarea() throws Exception {
        // Given
        TareaModel nuevaTarea = new TareaModel(null, "Nueva Tarea", "Detalle", false);
        TareaModel tareaCreada = new TareaModel(1L, "Nueva Tarea", "Detalle", false);
        
        given(tareaRepository.save(any(TareaModel.class))).willReturn(tareaCreada);

        // When & Then (Llamada a /api/tareas/guardar)
        mockMvc.perform(post("/api/tareas/guardar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nuevaTarea)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.titulo").value("Nueva Tarea"));
    }
}