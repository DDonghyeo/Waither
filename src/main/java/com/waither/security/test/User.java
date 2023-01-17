package com.waither.security.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class User {

    private String authId;

    private String email;

    private String role;

    private int active;

    private String authProvider;


}

