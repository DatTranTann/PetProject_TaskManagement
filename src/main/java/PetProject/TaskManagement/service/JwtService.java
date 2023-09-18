package PetProject.TaskManagement.service;

import PetProject.TaskManagement.entity.Employee;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private static final String Secret_key="123";
    public String generateToken(Employee employee, Collection<SimpleGrantedAuthority> authorities){
        Algorithm algorithm = Algorithm.HMAC256(Secret_key.getBytes());
        return JWT.create()
                .withSubject(employee.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis()+ 50 * 60 * 1000))
                .withClaim("roles", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
    }
    public String generateRefreshToken(Employee employee, Collection<SimpleGrantedAuthority> authorities){
        Algorithm algorithm = Algorithm.HMAC256(Secret_key.getBytes());
        return JWT.create()
                .withSubject(employee.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis()+ 50 * 60 * 1000))
                .sign(algorithm);
    }
}
