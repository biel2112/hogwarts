package hogwarts.api.controller;

import hogwarts.api.domain.aluno.*;
import hogwarts.api.domain.aula.DadosAgendamentoAula;
import hogwarts.api.domain.aula.DadosDetalhamentoAula;
import hogwarts.api.domain.bruxo.Bruxo;
import hogwarts.api.domain.bruxo.DadosBruxo;
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

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AlunoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroAluno> dadosCadastroAluno;

    @Autowired
    private JacksonTester<DadosDetalhamentoAluno> dadosDetalhamentoAluno;

    @MockBean
    private AlunoRepository repository;

    @Autowired
    private AlunoService service;

    @Test
    @DisplayName("Deve retornar código 400 por oferecer informações incorretas!")
    @WithMockUser
    void cadastrarAlunoIncorretamente() throws Exception {
        var response = mvc.perform(post("/alunos"))
                .andReturn().getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrarAlunoCorretamente() throws Exception {
        var dadosCadastro = new DadosCadastroAluno(
                dadosBruxo(),
                Casa.GRIFINORIA,
                "Sapo",
                Status.ALUNO,
                1);


        when(repository.save(any())).thenReturn(new Aluno(dadosCadastro));

        var response = mvc
                .perform(post("/alunos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroAluno.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhamento = new DadosDetalhamentoAluno(
                null,
                dadosCadastro.casa(),
                dadosCadastro.status(),
                dadosCadastro.ano(),
                dadosCadastro.mascote(),
                new Bruxo(dadosCadastro.bruxo())


        );
        var jsonEsperado = dadosDetalhamentoAluno.write(dadosDetalhamento).getJson();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertEquals(jsonEsperado, response.getContentAsString());
    }

    private DadosBruxo dadosBruxo(){
        return new DadosBruxo(
                "Neville",
                "Longbottom",
                "Macieira",
                ""
        );
    }
}