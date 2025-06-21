package br.com.api.tekveiculos.repository;

import br.com.api.tekveiculos.model.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<Supply, Long> {
}
