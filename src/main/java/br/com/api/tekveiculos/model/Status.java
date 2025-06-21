package br.com.api.tekveiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "STATUS")
public class Status {

    @Id
    @SequenceGenerator(name = "seq_status", sequenceName = "seq_status", allocationSize = 1)
    @GeneratedValue(generator = "seq_status", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Client> clientList;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Vehicle> vehicleList;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Member> memberList;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<VisitClient> visitClientLists;

    @Valid
    @Embedded
    private Audit audit;
}
