package br.com.api.tekveiculos.model;

import br.com.api.tekveiculos.model.enumerator.MarkVehicle;
import br.com.api.tekveiculos.model.enumerator.ModelVehicle;
import br.com.api.tekveiculos.model.enumerator.TypeVehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "VEHICLE")
public class Vehicle {

    @Id
    @SequenceGenerator(name = "seq_vehicle", sequenceName = "seq_vehicle", allocationSize = 1)
    @GeneratedValue(generator = "seq_vehicle", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "type_vehicle")
    private TypeVehicle typeVehicle;

    @Column(name = "mark_vehicle")
    private MarkVehicle markVehicle;

    @Column(name = "model_vehicle")
    private ModelVehicle modelVehicle;

    private String color;

    @Column(name = "year_manufacture")
    private String yearManufacture;

    @Column(unique = true)
    private String plate;

    private String km;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @JsonIgnore
    private Status status;

    @Valid
    @Embedded
    private Audit audit;
}
