package com.bbva.postulanteuni.repository;

import com.bbva.postulanteuni.model.PostulantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulantRepository extends JpaRepository<PostulantEntity,Long> {
}
