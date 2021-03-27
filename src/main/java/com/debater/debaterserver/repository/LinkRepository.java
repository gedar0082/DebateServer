package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
