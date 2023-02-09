package com.bbva.postulanteuni;

import com.bbva.postulanteuni.model.PostulantEntity;
import com.bbva.postulanteuni.repository.PostulantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@SpringBootTest
public class PostulantTests {
    private final List<PostulantEntity> lista = new ArrayList<>();
    private PostulantEntity firstPostulant = new PostulantEntity();
    private PostulantEntity secondPostulant = new PostulantEntity();


    @MockBean
    private PostulantRepository service;

    @BeforeEach
    public void setup(){
        firstPostulant.setName("Jorge");
        firstPostulant.setLastName("Martinez");
        firstPostulant.setEmail("jorgemartinez@gmail.com");
        firstPostulant.setStatus("Ingresó");
        firstPostulant.setProfession("Ingeniería civil");
        lista.add(firstPostulant);

        secondPostulant.setName("Edson");
        secondPostulant.setLastName("Guerra");
        secondPostulant.setEmail("edsonguerra@gmail.com");
        secondPostulant.setStatus("No Ingresó");
        secondPostulant.setProfession("Ingeniería de Sistemas");
        lista.add(secondPostulant);
    }

    @Test
    public void postulantGetAllTest(){
        when(service.findAll()).thenReturn(lista);
        List<PostulantEntity> listaTest = service.findAll();
        assertNotNull(listaTest);
        assertEquals(2,listaTest.size());
    }

    @Test
    public void postulantGetByIdTest(){
        when(service.findById(1L)).thenReturn(Optional.ofNullable(firstPostulant));
        PostulantEntity foundPostulant = service.findById(1L).get();
        assertNotNull(foundPostulant);
        assertEquals(firstPostulant.getId(),foundPostulant.getId());
    }

    @Test
    public void postulantUpdateSave(){
        when(service.save(firstPostulant)).thenReturn(firstPostulant);
        PostulantEntity savePostulant = service.save(firstPostulant);
        assertNotNull(savePostulant);
        assertEquals(firstPostulant.getId(),savePostulant.getId());
    }

    @Test
    public void deletePostulant(){
        service.deleteById(firstPostulant.getId());
        verify(service).deleteById(any());
    }

}
