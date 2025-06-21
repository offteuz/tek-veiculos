package br.com.api.tekveiculos.model;

import br.com.api.tekveiculos.model.enumerator.RoleMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity(name = "MEMBER")
public class Member implements UserDetails {

    @Id
    @SequenceGenerator(name = "seq_member", sequenceName = "seq_member", allocationSize = 1)
    @GeneratedValue(generator = "seq_member", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "role_member")
    private RoleMember roleMember;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String name;

    private String password;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_member_status"))
    private Status status;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "MEMBER_VISIT_CLIENT", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "visit_client_id"))
    private Set<VisitClient> visitClients = new HashSet<>();

    @Embedded
    @Valid
    private Audit audit;

    public Member(RoleMember roleMember, String email, String name, String password) {
        this.roleMember = roleMember;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.roleMember.equals(RoleMember.ADMIN)) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
