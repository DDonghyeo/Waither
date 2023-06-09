package com.waither.dto;

import com.waither.entities.UserEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {

    private Long userIdx;

    private String userName;

    private String email;

    private String authId;

    private String pw;


    private String provider;

    private String role;

    private char status;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userName(userName)
                .email(email)
                .authId(authId)
                .pw(pw)
                .provider(provider)
                .role(role)
                .status(status)
                .build();
    }

}
