package br.com.api.tekveiculos.repository;

import br.com.api.tekveiculos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
