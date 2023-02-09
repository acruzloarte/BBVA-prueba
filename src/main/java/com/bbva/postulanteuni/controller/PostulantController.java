package com.bbva.postulanteuni.controller;

import com.bbva.postulanteuni.bussines.PostulantBussines;
import com.bbva.postulanteuni.model.PostulantEntity;
import com.bbva.postulanteuni.exception.NotFoundException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v1")
@Api(value = "PostulantController", produces = "application/json", tags = { "Postulant Controller" })
public class PostulantController {
    @Autowired
    private PostulantBussines postulantBussines;

    @GetMapping("/postulants")
    public List<PostulantEntity> getAllPostulants(){
        return postulantBussines.getAllPostulants();
    }

    @GetMapping("/postulants/{id}")
    public ResponseEntity<PostulantEntity> getPostulantByID(@PathVariable(value = "id") Long postulantId) throws NotFoundException {

        return postulantBussines.getPostulantByID(postulantId);
    }

    @PostMapping("/postulants")
    public PostulantEntity createPostulant(@RequestBody PostulantEntity postulantEntity){
        return postulantBussines.createPostulant(postulantEntity);
    }

    @PutMapping("/postulants/{id}")
    public ResponseEntity<PostulantEntity> updatePostulant(@PathVariable (value = "id") Long postulantId,
                                                        @RequestBody PostulantEntity postulantDetails) throws NotFoundException{

        return postulantBussines.updatePostulant(postulantId,postulantDetails);
    }

    @DeleteMapping("/postulants/{id}")
    public Map<String, Boolean> deletePostulant(@PathVariable(value = "id") Long postulantId) throws NotFoundException{
        return postulantBussines.deletePostulant(postulantId);
    }
}
