package com.ofms.repositories;

import com.ofms.models.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FishRepository extends JpaRepository<Fish, Long> {
    List<Fish> findAllByUserId(Long userId);
}
