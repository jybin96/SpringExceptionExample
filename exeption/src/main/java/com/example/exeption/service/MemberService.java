package com.example.exeption.service;

import com.example.exeption.dto.MemberRegisterDto;
import com.example.exeption.model.Member;
import com.example.exeption.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public void register(MemberRegisterDto.Request request) {
        Member member = request.toMember();
        memberRepository.save(member);
    }
}
