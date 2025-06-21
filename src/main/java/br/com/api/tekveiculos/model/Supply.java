package br.com.api.tekveiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "SUPPLY")
public class Supply {

    @Id
    @SequenceGenerator(name = "seq_supply", sequenceName = "seq_supply", allocationSize = 1)
    @GeneratedValue(generator = "seq_supply", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "supply_date")
    private LocalDateTime supplyDate;

    @Column(name = "km_current_vehicle")
    private Long kmCurrentVehicle;

    private float liters;

    @Column(name = "value_liter")
    private float valueLiter;

    @Column(name = "value_all")
    private float valueAll;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_visit_client", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_supply_visit_client"))
    private VisitClient visitClient;
}
