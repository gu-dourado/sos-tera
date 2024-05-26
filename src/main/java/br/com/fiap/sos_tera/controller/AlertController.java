package br.com.fiap.sos_tera.controller;

import br.com.fiap.sos_tera.dto.alert.AlertDetailsDTO;
import br.com.fiap.sos_tera.dto.alert.AlertRegisterDTO;
import br.com.fiap.sos_tera.service.AlertService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertController {
  @Autowired
  private AlertService alertService;

  @PostMapping("/cadastrar")
  @ResponseStatus(HttpStatus.CREATED)
  public AlertDetailsDTO registerAlert(@RequestBody @Valid AlertRegisterDTO alert) {
    return alertService.save(alert);
  }

  @DeleteMapping("/excluir/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAlert(@PathVariable Long id) {
    alertService.delete(id);
  }

  @PutMapping("/atualizar")
  @ResponseStatus(HttpStatus.OK)
  public AlertDetailsDTO updateAlert(@RequestBody @Valid AlertRegisterDTO alert) {
    return alertService.update(alert);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public AlertDetailsDTO getAlertInfo(@PathVariable Long id) {
    return alertService.get(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<AlertDetailsDTO> getAllAlerts() {
    return alertService.getAll();
  }
}
