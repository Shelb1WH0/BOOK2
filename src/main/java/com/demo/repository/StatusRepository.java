package com.demo.repository;

import com.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    // Пример метода для поиска статуса по имени
   //List<Status> findByName(String name);
}
