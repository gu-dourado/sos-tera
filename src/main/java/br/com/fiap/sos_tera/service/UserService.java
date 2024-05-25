package br.com.fiap.sos_tera.service;

import br.com.fiap.sos_tera.dto.UserDetailsDTO;
import br.com.fiap.sos_tera.dto.UserRegisterDTO;
import br.com.fiap.sos_tera.entity.User;
import br.com.fiap.sos_tera.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public UserDetailsDTO save(UserRegisterDTO userRegisterDTO) {
    User user = new User();
    BeanUtils.copyProperties(userRegisterDTO, user);
    User savedUser = userRepository.save(user);
    return new UserDetailsDTO(savedUser);
  }

  public void delete(Long id) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {
      userRepository.delete(optionalUser.get());
    } else {
      throw new RuntimeException("User not found with ID: " + id);
    }
  }

  public UserDetailsDTO update(UserRegisterDTO userRegisterDTO) {
    User user = new User();
    BeanUtils.copyProperties(userRegisterDTO, user);

    Optional<User> optionalUser = userRepository.findById(user.getId());

    if (optionalUser.isPresent()) {
      return new UserDetailsDTO(userRepository.save(optionalUser.get()));
    } else {
      throw new RuntimeException("User not found");
    }
  }

  public UserDetailsDTO get(Long id) {
    Optional<User> optionalUser = userRepository.findById(id);

    if (optionalUser.isPresent()) {
      return new UserDetailsDTO(optionalUser.get());
    } else {
      throw new RuntimeException("User not found with ID: " + id);
    }
  }

  public List<UserDetailsDTO> getAll() {
    return userRepository
            .findAll()
            .stream()
            .map(UserDetailsDTO::new)
            .toList();
  }
}