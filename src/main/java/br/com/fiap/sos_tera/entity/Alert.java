package br.com.fiap.sos_tera.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_alerts")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Alert {
  @Id
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "ALERTS_SEQ")
  @SequenceGenerator(
          name = "ALERTS_SEQ",
          sequenceName = "ALERTS_SEQ",
          allocationSize = 1
  )
  Long id;

  String tipo;
  LocalDateTime dataEHora;
  Character gravidade;
  String status;
}
