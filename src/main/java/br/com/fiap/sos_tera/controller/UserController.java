package br.com.fiap.sos_tera.controller;

import br.com.fiap.sos_tera.dto.user.UserDetailsDTO;
import br.com.fiap.sos_tera.dto.user.UserRegisterDTO;
import br.com.fiap.sos_tera.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/cadastrar")
  @ResponseStatus(HttpStatus.CREATED)
  public UserDetailsDTO registerUser(@RequestBody @Valid UserRegisterDTO user) {
    return userService.save(user);
  }

  @DeleteMapping("/excluir/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUser(@PathVariable Long id) {
    userService.delete(id);
  }

  @PutMapping("/atualizar")
  @ResponseStatus(HttpStatus.OK)
  public UserDetailsDTO updateUser(@RequestBody @Valid UserRegisterDTO user) {
    return userService.update(user);
  }

  @GetMapping("/{id}/perfil")
  @ResponseStatus(HttpStatus.OK)
  public UserDetailsDTO getUserInfo(@PathVariable Long id) {
    return userService.get(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<UserDetailsDTO> getAllUsers() {
    return userService.getAll();
  }
}
