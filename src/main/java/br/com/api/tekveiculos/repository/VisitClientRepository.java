package br.com.api.tekveiculos.repository;

import br.com.api.tekveiculos.model.VisitClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitClientRepository extends JpaRepository<VisitClient, Long> {
}
