package br.com.fiap.sos_tera.service;

import br.com.fiap.sos_tera.dto.user.UserDetailsDTO;
import br.com.fiap.sos_tera.dto.user.UserRegisterDTO;
import br.com.fiap.sos_tera.entity.user.User;
import br.com.fiap.sos_tera.entity.user.exceptions.UserNotFoundException;
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
      throw new UserNotFoundException("User not found with ID: " + id);
    }
  }

  public UserDetailsDTO update(UserRegisterDTO userRegisterDTO) {
    User user = new User();
    BeanUtils.copyProperties(userRegisterDTO, user);

    Optional<User> optionalUser = userRepository.findById(user.getId());

    User savedUser = userRepository.save(user);

    if (optionalUser.isPresent()) {
      return new UserDetailsDTO(savedUser);
    } else {
      throw new UserNotFoundException("User not found");
    }
  }

  public UserDetailsDTO get(Long id) {
      return new UserDetailsDTO(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id)));
  }

  public List<UserDetailsDTO> getAll() {
    return userRepository
            .findAll()
            .stream()
            .map(UserDetailsDTO::new)
            .toList();
  }
}