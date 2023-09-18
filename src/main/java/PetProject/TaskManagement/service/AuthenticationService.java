package PetProject.TaskManagement.service;

import PetProject.TaskManagement.auth.AuthenticationRequest;
import PetProject.TaskManagement.auth.AuthenticationResponse;
import PetProject.TaskManagement.entity.Employee;
import PetProject.TaskManagement.entity.Role;
import PetProject.TaskManagement.repository.EmployeeRepository;
import PetProject.TaskManagement.repository.RoleCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final EmployeeRepository employeeRepository;
    private final AuthenticationManager authenticationManager;
    private final RoleCustomRepository roleCustomRepository;
    private  final JwtService jwtService;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        Employee employee = employeeRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow();
        List<Role> roles = null;
        if (employee != null){
            roles = roleCustomRepository.getRole(employee);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Set<Role> set = new HashSet<>();
        roles.stream().forEach(c ->set.add(new Role(c.getRoleName())));
        set.stream().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getRoleName())));
        var jwtToken = jwtService.generateToken(employee, authorities);
        var jwtRefreshToken = jwtService.generateRefreshToken(employee, authorities);
        return AuthenticationResponse.builder().token(jwtToken).refreshToken(jwtRefreshToken).build();
    }
}
