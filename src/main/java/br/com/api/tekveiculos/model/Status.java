package br.com.api.tekveiculos.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

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

    @Valid
    @Embedded
    private Audit audit;
}
