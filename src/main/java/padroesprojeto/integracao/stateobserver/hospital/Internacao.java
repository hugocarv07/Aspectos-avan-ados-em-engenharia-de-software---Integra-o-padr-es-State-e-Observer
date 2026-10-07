package padroesprojeto.integracao.stateobserver.hospital;

/**
 * Integra State e Observer: Internacao é o Context da máquina de
 * estados (delega cada ação para o InternacaoEstado atual) e também o
 * Subject do Observer (estende Notificavel). A notificação só acontece
 * quando a transição de fato ocorre — uma tentativa inválida (que o
 * estado atual recusa, retornando false) não gera nenhum aviso aos
 * observadores.
 */
public class Internacao extends Notificavel {

    private String nomePaciente;
    private InternacaoEstado estado;

    public Internacao(String nomePaciente) {
        this.nomePaciente = nomePaciente;
        this.estado = InternacaoEstadoInternado.getInstance();
    }

    public void setEstado(InternacaoEstado estado) {
        this.estado = estado;
    }

    public InternacaoEstado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public boolean internar() {
        return aplicarTransicao(estado.internar(this));
    }

    public boolean darAltaMedica() {
        return aplicarTransicao(estado.darAltaMedica(this));
    }

    public boolean colocarEmObservacao() {
        return aplicarTransicao(estado.colocarEmObservacao(this));
    }

    public boolean darAltaAdministrativa() {
        return aplicarTransicao(estado.darAltaAdministrativa(this));
    }

    public boolean registrarEvasao() {
        return aplicarTransicao(estado.registrarEvasao(this));
    }

    public boolean transferir() {
        return aplicarTransicao(estado.transferir(this));
    }

    private boolean aplicarTransicao(boolean sucesso) {
        if (sucesso) {
            setAlterado();
            notificarObservadores();
        }
        return sucesso;
    }
}
