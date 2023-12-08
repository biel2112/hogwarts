package hogwarts.api.controller;

import hogwarts.api.domain.aula.AgendamentoAula;
import hogwarts.api.domain.aula.DadosAgendamentoAula;
import hogwarts.api.domain.aula.DadosDetalhamentoAula;
import org.junit.jupiter.api.Assertions;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AulaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosAgendamentoAula> dadosAgendamentoAulaJacksonTester;

    @Autowired
    private JacksonTester<DadosDetalhamentoAula> dadosDetalahamentoAulaJacksonTester;

    @MockBean
    private AgendamentoAula agendamentoAula;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void agendarCenario1() throws Exception {
        var response = mvc.perform(post("/aulas"))
            .andReturn().getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void agendarCenario2() throws Exception {
        var data = LocalDateTime.now().plusHours(1);

        var dadosDetalhamento = new DadosDetalhamentoAula(null, 1L, 1L, data);

        when(agendamentoAula.agendar(any())).thenReturn(dadosDetalhamento);

        var response = mvc.perform(
                post("/aulas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosAgendamentoAulaJacksonTester.write(
                                new DadosAgendamentoAula(1L, 1L, data)
                        ).getJson()
                        ))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        var jsonEsperado = dadosDetalahamentoAulaJacksonTester.write(
                dadosDetalhamento
        ).getJson();

        assertEquals(jsonEsperado, response.getContentAsString());
    }

}