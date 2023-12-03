package hogwarts.api.domain.funcionario;

import hogwarts.api.domain.bruxo.DadosBruxo;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFuncionario(
        @NotNull
        Long id,
        DadosBruxo bruxo,
        String transformacao,
        String materia,
        Cargo cargo
) {
}
