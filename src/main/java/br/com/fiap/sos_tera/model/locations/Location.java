package br.com.fiap.sos_tera.model.locations;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_locations")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Location {
  @Id
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "LOCATIONS_SEQ")
  @SequenceGenerator(
          name = "LOCATIONS_SEQ",
          sequenceName = "LOCATIONS_SEQ",
          allocationSize = 1
  )
  private Long id;
  private String latitude;
  private String longitude;
  private String nome;
}
