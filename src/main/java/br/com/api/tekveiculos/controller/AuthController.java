package br.com.api.tekveiculos.controller;

import br.com.api.tekveiculos.dto.request.MemberLoginRequestDTO;
import br.com.api.tekveiculos.dto.request.MemberRequestDTO;
import br.com.api.tekveiculos.dto.response.TokenResponseDTO;
import br.com.api.tekveiculos.model.Member;
import br.com.api.tekveiculos.repository.MemberRepository;
import br.com.api.tekveiculos.service.MemberService;
import br.com.api.tekveiculos.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final MemberRepository memberRepository;

    private final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, MemberRepository memberRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.memberRepository = memberRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/auth/login/v0")
    public ResponseEntity login(@Valid @RequestBody MemberLoginRequestDTO dto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.identifier(), dto.password());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        String token = tokenService.tokengenerate((Member) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenResponseDTO(token));
    }

    @PostMapping("/auth/register/v0")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity register(@Valid @RequestBody MemberRequestDTO dto) {
        if (this.memberRepository.existsByName(dto.name()) || this.memberRepository.existsByEmail(dto.email())) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        Member newMember = new Member(dto.roleMember(), dto.email(), dto.name(), encryptedPassword);

        this.memberRepository.save(newMember);

        return ResponseEntity.ok().build();
    }
}
