package br.com.fiap.sos_tera.model.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tbl_users")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User implements UserDetails {
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
  private String nome, email, senha;

  @Enumerated(EnumType.STRING)
  private UserRole role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (this.role == UserRole.ADMIN) {
      return List.of(
              new SimpleGrantedAuthority("ROLE_ADMIN"),
              new SimpleGrantedAuthority("ROLE_USER")
      );
    } else {
      return List.of(
              new SimpleGrantedAuthority("ROLE_USER")
      );
    }
  }

  @Override
  public String getPassword() {
    return this.senha;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
