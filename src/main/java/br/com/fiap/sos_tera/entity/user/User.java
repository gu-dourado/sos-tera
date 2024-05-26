package br.com.fiap.sos_tera.entity.user;

import br.com.fiap.sos_tera.entity.alert.Alert;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_users")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
  @Id
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "USERS_SEQ")
  @SequenceGenerator(
          name = "USERS_SEQ",
          sequenceName = "USERS_SEQ",
          allocationSize = 1
  )
  private Long id;
  private String nome;
  private String email;
  private String senha;
}
