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
@Entity(name = "CLIENT")
public class Client {

    @Id
    @SequenceGenerator(name = "seq_client", sequenceName = "seq_client", allocationSize = 1)
    @GeneratedValue(generator = "seq_client", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "social_reason", unique = true)
    private String socialReason;

    @Column(name = "fantasy_name")
    private String fantasyName;

    @Column(unique = true)
    private String cnpj;

    private String city;

    private String uf;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "f_client_status"))
    private Status status;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<VisitClient> visitClientLists;

    @Embedded
    @Valid
    private Audit audit;
}
