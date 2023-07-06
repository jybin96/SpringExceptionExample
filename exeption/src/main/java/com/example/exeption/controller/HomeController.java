package com.example.exeption.controller;

import com.example.exeption.dto.MemberRegisterDto;
import com.example.exeption.exception.type.InvalidValueException;
import com.example.exeption.model.Member;
import com.example.exeption.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<?> create(@RequestBody @Valid MemberRegisterDto.Request request) throws BindException {
        memberService.register(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
