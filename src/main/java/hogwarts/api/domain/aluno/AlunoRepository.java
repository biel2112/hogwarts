package hogwarts.api.domain.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Modifying
    @Query("UPDATE Aluno a SET a.status = :status WHERE a.id = :id")
    void expulsarAluno(@Param("id") Long id, @Param("status") Status status);

}
