package hogwarts.api.domain.aula.validacoes;

import hogwarts.api.domain.ValidacaoException;
import hogwarts.api.domain.aula.DadosAgendamentoAula;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoAula{

    public void validar(DadosAgendamentoAula dados){
        var dataAula = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataAula).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidacaoException("Aula deve ser agendada com antecedência de 30 minutos!");
        }
    }

}
