package hogwarts.api.bruxo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bruxo {

    private String nome;
    private String sobrenome;
    private String varinha;
    private String patrono;

    public Bruxo(DadosBruxo dados) {
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.varinha = dados.varinha();
        this.patrono = dados.patrono();
    }

    public void atualizarInformacoes(DadosBruxo dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.sobrenome() != null){
            this.sobrenome = dados.sobrenome();
        }
        if(dados.varinha() != null){
            this.varinha = dados.varinha();
        }
        if(dados.patrono() != null){
            this.patrono = dados.patrono();
        }
    }
}
