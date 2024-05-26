package br.com.fiap.sos_tera.controller;

import br.com.fiap.sos_tera.dto.location.LocationDetailsDTO;
import br.com.fiap.sos_tera.dto.location.LocationRegisterDTO;
import br.com.fiap.sos_tera.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locais")
public class LocationController {
  @Autowired
  private LocationService locationService;

  @PostMapping("/cadastrar")
  @ResponseStatus(HttpStatus.CREATED)
  public LocationDetailsDTO registerLocation(@RequestBody @Valid LocationRegisterDTO location) {
    return locationService.save(location);
  }

  @DeleteMapping("/excluir/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteLocation(@PathVariable Long id) {
    locationService.delete(id);
  }

  @PutMapping("/atualizar")
  @ResponseStatus(HttpStatus.OK)
  public LocationDetailsDTO updateLocation(@RequestBody @Valid LocationRegisterDTO location) {
    return locationService.update(location);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public LocationDetailsDTO getUserLocation(@PathVariable Long id) {
    return locationService.get(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<LocationDetailsDTO> getAllLocations() {
    return locationService.getAll();
  }
}

