package br.com.api.tekveiculos.service;

import br.com.api.tekveiculos.exception.MemberNotFoundException;
import br.com.api.tekveiculos.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public AuthorizationService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException {
        return memberRepository.findByName(input)
                .or(() -> memberRepository.findByEmail(input))
                .orElseThrow(MemberNotFoundException::new);
    }
}
