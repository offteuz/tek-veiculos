package br.com.api.tekveiculos.service;

import br.com.api.tekveiculos.dto.request.MemberRequestDTO;
import br.com.api.tekveiculos.dto.request.MemberUpdatePasswordRequestDTO;
import br.com.api.tekveiculos.dto.request.MemberUpdateRoleRequestDTO;
import br.com.api.tekveiculos.dto.request.MemberUpdateStatusRequestDTO;
import br.com.api.tekveiculos.dto.response.MemberResponseDTO;
import br.com.api.tekveiculos.exception.MemberNotFoundException;
import br.com.api.tekveiculos.exception.PasswordInvalidException;
import br.com.api.tekveiculos.mapper.MemberMapper;
import br.com.api.tekveiculos.model.Member;
import br.com.api.tekveiculos.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberResponseDTO create(MemberRequestDTO dto) {
        Member member = memberMapper.toDTO(dto);

        return new MemberResponseDTO(memberRepository.save(member));
    }

    public List<MemberResponseDTO> findAll() {
        return memberRepository
                .findAll()
                .stream()
                .map(MemberResponseDTO::new)
                .toList();
    }

    public MemberResponseDTO findById(Long idMember) {
        Member member = memberRepository.findById(idMember)
                .orElseThrow(MemberNotFoundException::new);

        return new MemberResponseDTO(member);
    }

    public void updatePassword(Long idMember, MemberUpdatePasswordRequestDTO dto) {
        Member member = memberRepository.findById(idMember)
                .orElseThrow(MemberNotFoundException::new);

        if (!passwordEncoder.matches(dto.currentPassword(), member.getPassword())) {
            throw new PasswordInvalidException();
        }

        member.setPassword(passwordEncoder.encode(dto.newPassword()));
        memberRepository.save(member);
    }

    public void updateRole(Long idMember, MemberUpdateRoleRequestDTO dto) {
        Member member = memberRepository.findById(idMember)
                .orElseThrow(MemberNotFoundException::new);

        member.setRoleMember(dto.roleMember());
        memberRepository.save(member);
    }

    public void updateStatus(Long idMember, MemberUpdateStatusRequestDTO dto) {
        Member member = memberRepository.findById(idMember)
                .orElseThrow(MemberNotFoundException::new);

        member.setStatus(dto.status());
        memberRepository.save(member);
    }

    public void delete(Long idMember) {
        Member member = memberRepository.findById(idMember)
                .orElseThrow(MemberNotFoundException::new);

        memberRepository.delete(member);
    }
}
