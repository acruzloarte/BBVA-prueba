package com.bbva.postulanteuni.bussines;

import com.bbva.postulanteuni.exception.NotFoundException;
import com.bbva.postulanteuni.model.PostulantEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PostulantBussines {
    List<PostulantEntity> getAllPostulants();
    ResponseEntity<PostulantEntity> getPostulantByID(Long postulantId) throws NotFoundException;
    PostulantEntity createPostulant(PostulantEntity PostulantEntity);
    ResponseEntity<PostulantEntity> updatePostulant(Long postulantId, PostulantEntity postulantDetails) throws NotFoundException;
    Map<String, Boolean> deletePostulant(Long postulantId) throws NotFoundException;
}
