package com.bbva.postulanteuni.bussines.impl;

import com.bbva.postulanteuni.bussines.PostulantBussines;
import com.bbva.postulanteuni.exception.NotFoundException;
import com.bbva.postulanteuni.model.PostulantEntity;
import com.bbva.postulanteuni.repository.PostulantRepository;
import com.bbva.postulanteuni.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostulantBussinesImp implements PostulantBussines {

    @Autowired
    private PostulantRepository postulantRepository;
    @Override
    public List<PostulantEntity> getAllPostulants() {
        return postulantRepository.findAll();
    }

    @Override
    public ResponseEntity<PostulantEntity> getPostulantByID(Long postulantId) throws NotFoundException {
        PostulantEntity postulant = postulantRepository.findById(postulantId)
                .orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND_POSTULANT_ID_MSG + postulantId));
        return ResponseEntity.ok().body(postulant);
    }

    @Override
    public PostulantEntity createPostulant(PostulantEntity PostulantEntity) {
        return postulantRepository.save(PostulantEntity);
    }

    @Override
    public ResponseEntity<PostulantEntity> updatePostulant(Long postulantId, PostulantEntity postulantDetails) throws NotFoundException {
        PostulantEntity postulant = postulantRepository.findById(postulantId)
                .orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND_POSTULANT_ID_MSG + postulantId));
        postulant.setName((postulantDetails.getName() ==null )?postulant.getName():postulantDetails.getName() );
        postulant.setLastName((postulantDetails.getLastName() ==null )?postulant.getLastName():postulantDetails.getLastName());
        postulant.setEmail((postulantDetails.getEmail() ==null )?postulant.getEmail():postulantDetails.getEmail());
        postulant.setStatus((postulantDetails.getStatus() ==null )?postulant.getStatus():postulantDetails.getStatus());
        postulant.setProfession((postulantDetails.getProfession() ==null )?postulant.getProfession():postulantDetails.getProfession());
        final PostulantEntity updatePostulant = postulantRepository.save(postulant);
        return ResponseEntity.ok(updatePostulant);
    }

    @Override
    public Map<String, Boolean> deletePostulant(Long postulantId) throws NotFoundException {
        PostulantEntity postulant = postulantRepository.findById(postulantId)
                .orElseThrow(() -> new NotFoundException(Constants.NOT_FOUND_POSTULANT_ID_MSG  + postulantId));

        postulantRepository.delete(postulant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Postulant Borrado", Boolean.TRUE);
        return response;
    }
}
