package com.task_manager_api.demo;

import com.task_manager_api.demo.model.TareaModel;
import com.task_manager_api.demo.repository.ITareaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TareaRepositoryTest {

    @Autowired
    private ITareaRepository tareaRepository;

    @Test
    @DisplayName("Debe guardar una tarea correctamente en la base de datos")
    void testGuardarTarea() {
        // 1. Preparar datos usando el constructor por defecto + setters
        TareaModel nuevaTarea = new TareaModel();
        nuevaTarea.setTitulo("Estudiar JUnit 5");
        nuevaTarea.setDescripcion("Aprender pruebas automatizadas");
        nuevaTarea.setCompletado(false);

        // 2. Ejecutar la acción
        TareaModel tareaGuardada = tareaRepository.save(nuevaTarea);

        // 3. Verificar los resultados (Asserts)
        assertThat(tareaGuardada).isNotNull();
        assertThat(tareaGuardada.getId()).isNotNull();
        assertThat(tareaGuardada.getTitulo()).isEqualTo("Estudiar JUnit 5");
    }
}