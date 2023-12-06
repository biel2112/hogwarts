package hogwarts.api.domain.aula.validacoes;

import hogwarts.api.domain.ValidacaoException;
import hogwarts.api.domain.aula.DadosAgendamentoAula;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioPermitidoAula implements ValidadorAgendamentoAula{

    public void validar(DadosAgendamentoAula dados){

        var dataAula = dados.data();

        var domingo = dataAula.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDoHorarioPermitido = dataAula.getHour() < 15;
        var depoisDoHorarioPermitido = dataAula.getHour() > 19;

        if(domingo || antesDoHorarioPermitido || depoisDoHorarioPermitido){
            throw new ValidacaoException("Data ou horário não permitidos!");
        }

    }

}
