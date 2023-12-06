package hogwarts.api.domain.funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
