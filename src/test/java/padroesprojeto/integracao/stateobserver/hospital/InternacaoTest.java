package padroesprojeto.integracao.stateobserver.hospital;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternacaoTest {

    @Test
    void deveIniciarInternado() {
        Internacao internacao = new Internacao("Paciente 1");
        assertEquals("Internado", internacao.getNomeEstado());
    }

    @Test
    void deveDarAltaMedicaAPartirDeInternado() {
        Internacao internacao = new Internacao("Paciente 1");
        assertTrue(internacao.darAltaMedica());
        assertEquals("AltaMedica", internacao.getNomeEstado());
    }

    @Test
    void deveColocarEmObservacaoAPartirDeInternado() {
        Internacao internacao = new Internacao("Paciente 1");
        assertTrue(internacao.colocarEmObservacao());
        assertEquals("EmObservacao", internacao.getNomeEstado());
    }

    @Test
    void deveInternarAPartirDeEmObservacao() {
        Internacao internacao = new Internacao("Paciente 1");
        internacao.colocarEmObservacao();
        assertTrue(internacao.internar());
        assertEquals("Internado", internacao.getNomeEstado());
    }

    @Test
    void deveDarAltaAdministrativaAPartirDeInternado() {
        Internacao internacao = new Internacao("Paciente 1");
        assertTrue(internacao.darAltaAdministrativa());
        assertEquals("AltaAdministrativa", internacao.getNomeEstado());
    }

    @Test
    void deveDarAltaAdministrativaAPartirDeEmObservacao() {
        Internacao internacao = new Internacao("Paciente 1");
        internacao.colocarEmObservacao();
        assertTrue(internacao.darAltaAdministrativa());
        assertEquals("AltaAdministrativa", internacao.getNomeEstado());
    }

    @Test
    void deveDarAltaAdministrativaAPartirDeEvasao() {
        Internacao internacao = new Internacao("Paciente 1");
        internacao.registrarEvasao();
        assertTrue(internacao.darAltaAdministrativa());
        assertEquals("AltaAdministrativa", internacao.getNomeEstado());
    }

    @Test
    void deveRegistrarEvasaoAPartirDeEmObservacao() {
        Internacao internacao = new Internacao("Paciente 1");
        internacao.colocarEmObservacao();
        assertTrue(internacao.registrarEvasao());
        assertEquals("Evasao", internacao.getNomeEstado());
    }

    @Test
    void deveTransferirAPartirDeInternado() {
        Internacao internacao = new Internacao("Paciente 1");
        assertTrue(internacao.transferir());
        assertEquals("Transferido", internacao.getNomeEstado());
    }

    @Test
    void naoDeveDarAltaMedicaAPartirDeEmObservacao() {
        Internacao internacao = new Internacao("Paciente 1");
        internacao.colocarEmObservacao();
        assertFalse(internacao.darAltaMedica());
        assertEquals("EmObservacao", internacao.getNomeEstado());
    }

    @Test
    void naoDevePermitirTransicaoAPartirDeEstadoTerminal() {
        Internacao internacao = new Internacao("Paciente 1");
        internacao.darAltaMedica();
        assertFalse(internacao.colocarEmObservacao());
        assertFalse(internacao.transferir());
        assertFalse(internacao.registrarEvasao());
        assertEquals("AltaMedica", internacao.getNomeEstado());
    }
}
