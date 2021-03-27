package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Regulations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegulationsRepository extends JpaRepository<Regulations, Long> {
}
