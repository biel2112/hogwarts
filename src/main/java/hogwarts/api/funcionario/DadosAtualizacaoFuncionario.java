package hogwarts.api.funcionario;

import hogwarts.api.bruxo.DadosBruxo;
import hogwarts.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoFuncionario(
        @NotNull
        Long id,
        DadosBruxo bruxo,
        String transformacao,
        String materia,
        Cargo cargo,
        DadosEndereco endereco
) {
}
