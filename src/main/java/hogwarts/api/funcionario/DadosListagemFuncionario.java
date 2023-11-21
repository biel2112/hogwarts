package hogwarts.api.funcionario;

import hogwarts.api.bruxo.Bruxo;

public record DadosListagemFuncionario(Long id, Bruxo bruxo, Cargo cargo, String transformacao) {

    public DadosListagemFuncionario(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getBruxo(), funcionario.getCargo(), funcionario.getTransformacao());
    }
}