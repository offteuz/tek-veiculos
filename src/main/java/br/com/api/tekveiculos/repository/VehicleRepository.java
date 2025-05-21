package br.com.api.tekveiculos.repository;

import br.com.api.tekveiculos.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
