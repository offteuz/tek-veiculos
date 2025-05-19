package br.com.api.tekveiculos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "social_reason")
    private String socialReason;

    @Column(name = "fantasy_name")
    private String fantasyName;

    @Column(unique = true)
    private String cnpj;

    private String city;

    private String uf;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @JsonIgnore
    private Status status;

    @Embedded
    private Audit audit;
}
