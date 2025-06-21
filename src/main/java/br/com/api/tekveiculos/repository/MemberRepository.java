package br.com.api.tekveiculos.repository;

import br.com.api.tekveiculos.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<UserDetails> findByEmail(String email);

    Optional<UserDetails> findByName(String name);

    boolean existsByEmail(String email);

    boolean existsByName(String name);
}
