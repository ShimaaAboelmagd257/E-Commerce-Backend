package com.sham.e_commerce.security;

import com.sham.e_commerce.domain.entity.User;
import com.sham.e_commerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {


    private final UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"+ email));
        return new SecurityUserDetails(user);
    }
}
