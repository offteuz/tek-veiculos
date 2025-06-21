package br.com.api.tekveiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "VISIT_CLIENT")
public class VisitClient {

    @Id
    @SequenceGenerator(name = "seq_visit_client", sequenceName = "seq_visit_client", allocationSize = 1)
    @GeneratedValue(generator = "seq_visit_client", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "exit_date")
    private LocalDateTime exitDate;

    @Column(name = "km_exit_vehicle")
    private Long kmExitVehicle;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "km_return_vehicle")
    private Long kmReturnVehicle;

    private String observation;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicle", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_visit_client_vehicle"))
    private Vehicle vehicle;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_visit_client_client"))
    private Client client;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_visit_client_status"))
    private Status status;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "visitClient", fetch = FetchType.LAZY)
    private List<Supply> supplyList;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "visitClients", fetch = FetchType.LAZY)
    private Set<Member> members = new HashSet<>();

    @Valid
    @Embedded
    private Audit audit;
}
