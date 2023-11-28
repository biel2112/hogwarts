package hogwarts.api.domain.funcionario;

import hogwarts.api.domain.bruxo.Bruxo;

public record DadosListagemFuncionario(Long id, Bruxo bruxo, Cargo cargo, String transformacao, String materia) {

    public DadosListagemFuncionario(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getBruxo(), funcionario.getCargo(), funcionario.getTransformacao(), funcionario.getMateria());
    }
}
