package com.waither.security.oauth;

import com.waither.entities.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Log4j2
@Getter
public class CustomAuthentication implements OAuth2User, UserDetails {

    private String id;
//    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    @Setter
    private Map<String, Object> attributes;

    public CustomAuthentication(String id, /*String email, */Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
//        this.email = email;
        this.authorities = authorities;
    }


    public static CustomAuthentication create(UserEntity user) {
        List<GrantedAuthority> authorityList = Collections.singletonList(new SimpleGrantedAuthority(
                "" + RoleType.USER));
        return new CustomAuthentication(
                user.getAuthId(),
//                user.getEmail(),
                authorityList
        );
    }

    public static CustomAuthentication create(UserEntity user, Map<String, Object> attributes) {
        log.info("CustomAuthentication create : " + attributes.toString());
        CustomAuthentication customAuthentication = CustomAuthentication.create(user);
        customAuthentication.setAttributes(attributes);
        log.info("CustomAuthentication create : " + customAuthentication.id);
        return customAuthentication;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return String.valueOf(id);
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }
}