package br.com.fiap.sos_tera.controller;

import br.com.fiap.sos_tera.config.security.TokenService;
import br.com.fiap.sos_tera.dto.token.TokenDTO;
import br.com.fiap.sos_tera.dto.user.UserDetailsDTO;
import br.com.fiap.sos_tera.dto.user.UserLoginDTO;
import br.com.fiap.sos_tera.dto.user.UserRegisterDTO;
import br.com.fiap.sos_tera.model.user.User;
import br.com.fiap.sos_tera.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserService userService;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody @Valid UserLoginDTO userLoginDTO) {
    UsernamePasswordAuthenticationToken usernamePasswordAuthToken =
            new UsernamePasswordAuthenticationToken(userLoginDTO.email(), userLoginDTO.senha());

    Authentication auth = authenticationManager.authenticate(usernamePasswordAuthToken);

    String token = tokenService.generateToken((User) auth.getPrincipal());

    return ResponseEntity.ok(new TokenDTO(token));
  }

  @PostMapping("/cadastro")
  @ResponseStatus(HttpStatus.CREATED)
  public UserDetailsDTO register(@RequestBody @Valid UserRegisterDTO userRegisterDTO) {
    UserDetailsDTO savedUser = null;
    savedUser = userService.save(userRegisterDTO);
    return savedUser;
  }
}