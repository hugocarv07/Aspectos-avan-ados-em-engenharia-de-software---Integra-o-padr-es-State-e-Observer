package padroesprojeto.integracao.stateobserver.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternacaoObserverTest {

    @Test
    void deveNotificarResponsavelQuandoEstadoMuda() {
        Internacao internacao = new Internacao("Paciente 1");
        ResponsavelPaciente responsavel = new ResponsavelPaciente("Responsável 1");
        responsavel.acompanhar(internacao);

        internacao.darAltaMedica();

        assertEquals("Responsável 1, paciente Paciente 1 mudou para o estado AltaMedica",
                responsavel.getUltimaNotificacao());
    }

    @Test
    void deveNotificarMultiplosResponsaveis() {
        Internacao internacao = new Internacao("Paciente 1");
        ResponsavelPaciente responsavel1 = new ResponsavelPaciente("Responsável 1");
        ResponsavelPaciente responsavel2 = new ResponsavelPaciente("Responsável 2");
        responsavel1.acompanhar(internacao);
        responsavel2.acompanhar(internacao);

        internacao.colocarEmObservacao();

        assertEquals("Responsável 1, paciente Paciente 1 mudou para o estado EmObservacao",
                responsavel1.getUltimaNotificacao());
        assertEquals("Responsável 2, paciente Paciente 1 mudou para o estado EmObservacao",
                responsavel2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarQuandoTransicaoForInvalida() {
        Internacao internacao = new Internacao("Paciente 1");
        ResponsavelPaciente responsavel = new ResponsavelPaciente("Responsável 1");
        responsavel.acompanhar(internacao);

        internacao.darAltaMedica();
        responsavel.getUltimaNotificacao();
        String notificacaoAposAlta = responsavel.getUltimaNotificacao();

        internacao.colocarEmObservacao(); // inválida a partir de AltaMedica, retorna false

        assertEquals(notificacaoAposAlta, responsavel.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasQuemAcompanhaAInternacao() {
        Internacao internacao1 = new Internacao("Paciente 1");
        Internacao internacao2 = new Internacao("Paciente 2");
        ResponsavelPaciente responsavel1 = new ResponsavelPaciente("Responsável 1");
        ResponsavelPaciente responsavel2 = new ResponsavelPaciente("Responsável 2");
        responsavel1.acompanhar(internacao1);
        responsavel2.acompanhar(internacao2);

        internacao1.darAltaMedica();

        assertEquals("Responsável 1, paciente Paciente 1 mudou para o estado AltaMedica",
                responsavel1.getUltimaNotificacao());
        assertEquals(null, responsavel2.getUltimaNotificacao());
    }
}
