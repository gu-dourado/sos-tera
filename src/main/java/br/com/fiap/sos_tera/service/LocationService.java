package br.com.fiap.sos_tera.service;

import br.com.fiap.sos_tera.dto.location.LocationDetailsDTO;
import br.com.fiap.sos_tera.dto.location.LocationRegisterDTO;
import br.com.fiap.sos_tera.entity.locations.Location;
import br.com.fiap.sos_tera.entity.locations.exceptions.LocationNotFoundException;
import br.com.fiap.sos_tera.entity.user.User;
import br.com.fiap.sos_tera.repository.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

  @Autowired
  private LocationRepository locationRepository;

  public LocationDetailsDTO save(LocationRegisterDTO locationRegisterDTO) {
    Location location = new Location();
    BeanUtils.copyProperties(locationRegisterDTO, location);
    Location savedLocation = locationRepository.save(location);
    return new LocationDetailsDTO(savedLocation);
  }

  public void delete(Long id) {
    Optional<Location> optionalLocation = locationRepository.findById(id);

    if (optionalLocation.isPresent()) {
      locationRepository.delete(optionalLocation.get());
    } else {
      throw new LocationNotFoundException("Location not found with ID: " + id);
    }
  }

  public LocationDetailsDTO update(LocationRegisterDTO locationRegisterDTO) {
    Location location = new Location();
    BeanUtils.copyProperties(locationRegisterDTO, location);

    Optional<Location> optionalLocation = locationRepository.findById(location.getId());

    Location savedLocation = locationRepository.save(location);

    if (optionalLocation.isPresent()) {
      return new LocationDetailsDTO(savedLocation);
    } else {
      throw new LocationNotFoundException("User not found");
    }
  }

  public LocationDetailsDTO get(Long id) {
    return new LocationDetailsDTO(locationRepository.findById(id).orElseThrow(() -> new LocationNotFoundException("Location not found with ID: " + id)));
  }

  public List<LocationDetailsDTO> getAll() {
    return locationRepository
            .findAll()
            .stream()
            .map(LocationDetailsDTO::new)
            .toList();
  }
}