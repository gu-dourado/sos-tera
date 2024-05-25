package br.com.fiap.sos_tera.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
  private Long id;
  private String tipoDesastre;
  private LocalDateTime dataHora;
  private Character gravidade;
  private String status;

//  @ManyToOne
//  private Location localizacao;
//
//  @OneToMany(mappedBy = "alerta")
//  private List<User> usuarios;
}
