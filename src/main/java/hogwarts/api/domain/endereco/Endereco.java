package hogwarts.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String cidade;
    private String complemento;
    private String pais;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cidade = dados.cidade();
        this.complemento = dados.complemento();
        this.pais = dados.pais();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }
        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if(dados.complemento() != null){
            this.complemento = dados.complemento();
        }
        if(dados.pais() != null){
            this.pais = dados.pais();
        }
    }
}
