package hogwarts.api.domain.aluno;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository repository;

    @Test
    @DisplayName("Deve expulsar o aluno corretamente")
    void expulsarAlunoCorretamente() {

        Long id = 1L;
        Status novoStatus = Status.EXPULSO;
        repository.expulsarAluno(id, novoStatus);
        Optional<Aluno> alunoExpulso = repository.findById(id);
        assertEquals(novoStatus, alunoExpulso.get().getStatus());
    }
}