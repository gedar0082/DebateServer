package com.debater.debaterserver.repository;

import com.debater.debaterserver.entity.ArgumentRaw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArgumentRawRepository {

    List<ArgumentRaw> getArgumentRaw(Long id);
}
