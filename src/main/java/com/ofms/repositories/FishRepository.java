package com.ofms.repositories;

import com.ofms.models.Fish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FishRepository extends JpaRepository<Fish, Long> {
    List<Fish> findAllByUserId(Long userId);
    @Query(value = "select p from fishes p")
    Page<Fish> findWithPagable(Pageable pageable);

}
