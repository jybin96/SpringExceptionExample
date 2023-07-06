package com.example.exeption.dto;

import com.example.exeption.model.Member;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MemberRegisterDto {
    @Data
    public static class Request{

        @NotBlank(message = "name은 필수 값입니다.")
        private String name;

        @NotBlank(message = "email은 필수 값입니다.")
        private String email;

        @Min(value = 18, message = "18세 이상만 입장 가능합니다.")
        private int age;

        @NotNull(message = "금액은 필수 값입니다.")
        @Min(value = 1000, message = "1000원 이상 소지해야합니다.")
        private int money;

        public Member toMember(){
            return new Member(name, email, age, money);
        }
    }
}
