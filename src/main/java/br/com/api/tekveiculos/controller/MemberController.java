package br.com.api.tekveiculos.controller;

import br.com.api.tekveiculos.dto.request.MemberRequestDTO;
import br.com.api.tekveiculos.dto.response.MemberResponseDTO;
import br.com.api.tekveiculos.repository.MemberRepository;
import br.com.api.tekveiculos.service.MemberService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;

    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @PostMapping("/create/member")
    @ResponseStatus(HttpStatus.OK)
    public MemberResponseDTO create(@RequestBody MemberRequestDTO dto) {
        return memberService.create(dto);
    }
}
