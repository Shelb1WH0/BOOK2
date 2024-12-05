package com.demo.repository;

import com.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
//// Пример метода для поиска клиента по фамилии
//    List<Client> findByFullName(String fullName);
}
