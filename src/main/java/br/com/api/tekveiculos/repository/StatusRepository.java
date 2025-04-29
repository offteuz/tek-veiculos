package br.com.api.tekveiculos.repository;

import br.com.api.tekveiculos.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
