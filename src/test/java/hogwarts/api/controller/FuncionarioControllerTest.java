package hogwarts.api.controller;

import hogwarts.api.domain.aluno.*;
import hogwarts.api.domain.bruxo.Bruxo;
import hogwarts.api.domain.bruxo.DadosBruxo;
import hogwarts.api.domain.funcionario.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class FuncionarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroFuncionario> dadosCadastroFuncionario;

    @Autowired
    private JacksonTester<DadosDetalhamentoFuncionario> dadosDetalhamentoFuncionario;

    @MockBean
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioService service;

    @Test
    @DisplayName("Deve retornar código 400 por oferecer informações incorretas!")
    @WithMockUser
    void cadastrarFuncionarioIncorretamente() throws Exception{
        var response = mvc.perform(post("/alunos"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrarFuncionarioCorretamente() throws Exception{
        var dadosCadastro = new DadosCadastroFuncionario(
                dadosBruxo(),
                "",
                "DCAT",
                Cargo.PROFESSOR
                );


        when(repository.save(any())).thenReturn(new Funcionario(dadosCadastro));

        var response = mvc
                .perform(post("/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroFuncionario.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhamento = new DadosDetalhamentoFuncionario(
                null,
                new Bruxo(dadosCadastro.bruxo()),
                dadosCadastro.cargo(),
                dadosCadastro.materia(),
                dadosCadastro.transformacao()


        );
        var jsonEsperado = dadosDetalhamentoFuncionario.write(dadosDetalhamento).getJson();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertEquals(jsonEsperado, response.getContentAsString());
    }

    private DadosBruxo dadosBruxo(){
        return new DadosBruxo(
                "Olho-Tonto",
                "Moody",
                "Laranjeira",
                "Ganso"
        );
    }
}