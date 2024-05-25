package br.com.fiap.sos_tera.entity;

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
          generator = "LOCATION_SEQ")
  @SequenceGenerator(
          name = "LOCATION_SEQ",
          sequenceName = "LOCATION_SEQ",
          allocationSize = 1
  )
  Long id;
  String latitude;
  String longitude;
  String nome;
}
