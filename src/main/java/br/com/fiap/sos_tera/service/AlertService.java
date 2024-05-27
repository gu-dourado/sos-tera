package br.com.fiap.sos_tera.service;

import br.com.fiap.sos_tera.dto.alert.AlertDetailsDTO;
import br.com.fiap.sos_tera.dto.alert.AlertRegisterDTO;
import br.com.fiap.sos_tera.model.alert.Alert;
import br.com.fiap.sos_tera.model.user.exceptions.UserNotFoundException;
import br.com.fiap.sos_tera.repository.AlertRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AlertService {

  @Autowired
  private AlertRepository alertRepository;

  public AlertDetailsDTO save(AlertRegisterDTO alertRegisterDTO) {
    Alert alert = new Alert();
    BeanUtils.copyProperties(alertRegisterDTO, alert);

    String formattedDateTime = formatLocalDateTime(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");

    alert.setDataHora(formattedDateTime);

    Alert savedAlert = alertRepository.save(alert);
    return new AlertDetailsDTO(savedAlert);
  }

  public void delete(Long id) {
    Optional<Alert> optionalAlert = alertRepository.findById(id);

    if (optionalAlert.isPresent()) {
      alertRepository.delete(optionalAlert.get());
    } else {
      throw new UserNotFoundException("Alert not found with ID: " + id);
    }
  }

  public AlertDetailsDTO update(AlertRegisterDTO alertRegisterDTO) {
    Alert alert = new Alert();
    BeanUtils.copyProperties(alertRegisterDTO, alert);

    Optional<Alert> optionalAlert = alertRepository.findById(alert.getId());

    Alert savedAlert = alertRepository.save(alert);

    if (optionalAlert.isPresent()) {
      return new AlertDetailsDTO(savedAlert);
    } else {
      throw new UserNotFoundException("Alert not found");
    }
  }

  public AlertDetailsDTO get(Long id) {
    return new AlertDetailsDTO(alertRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Alert not found with ID: " + id)));
  }

  public List<AlertDetailsDTO> getAll() {
    return alertRepository
            .findAll()
            .stream()
            .map(AlertDetailsDTO::new)
            .toList();
  }

  private String formatLocalDateTime(LocalDateTime dateTime, String pattern) {
    return dateTime.format(DateTimeFormatter.ofPattern(pattern));
  }
}

