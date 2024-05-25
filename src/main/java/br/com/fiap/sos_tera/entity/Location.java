package br.com.fiap.sos_tera.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
  private Long id;
  private String latitude;
  private String longitude;
  private String nome;

//  @OneToMany(mappedBy = "localizacao")
//  private List<Alert> alertas;
}
