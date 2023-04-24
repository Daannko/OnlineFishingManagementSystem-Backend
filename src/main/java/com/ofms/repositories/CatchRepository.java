package com.ofms.repositories;

import com.ofms.models.Catch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatchRepository extends JpaRepository<Catch, Long> {
    List<Catch> findAllByUserId(Long userId);
    Optional<Catch> findById(Long Id);
}
