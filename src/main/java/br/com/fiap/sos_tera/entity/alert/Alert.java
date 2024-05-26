package br.com.fiap.sos_tera.entity.alert;

import jakarta.persistence.*;
import lombok.*;

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

  @Column(name = "tipo_desastre")
  private String tipoDesastre;

  @Column(name = "data_hora")
  private String dataHora;
  private String gravidade;
  private String status;
}
