package com.praveen.cms.api.security;

import com.praveen.cms.api.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserPrincipal implements UserDetails {

    private String name;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String name, String email,String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.email = email;
        this.password=password;
        this.authorities = authorities;
    }

    public UserPrincipal create(Customer customer) {
        System.out.println("In create method of UserPrincioal authorities: "+authorities);
        name = customer.getFirstName()+ " " +customer.getLastName();
        return new UserPrincipal(
                name,
                customer.getEmail(),
                customer.getPassword(),
                new HashSet<>()
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
