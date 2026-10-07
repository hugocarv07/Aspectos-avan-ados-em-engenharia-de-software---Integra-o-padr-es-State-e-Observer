package padroesprojeto.integracao.stateobserver.hospital;

public class InternacaoEstadoInternado extends InternacaoEstado {

    private InternacaoEstadoInternado() {};
    private static InternacaoEstadoInternado instance = new InternacaoEstadoInternado();
    public static InternacaoEstadoInternado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Internado";
    }

    public boolean darAltaMedica(Internacao internacao) {
        internacao.setEstado(InternacaoEstadoAltaMedica.getInstance());
        return true;
    }

    public boolean colocarEmObservacao(Internacao internacao) {
        internacao.setEstado(InternacaoEstadoEmObservacao.getInstance());
        return true;
    }

    public boolean darAltaAdministrativa(Internacao internacao) {
        internacao.setEstado(InternacaoEstadoAltaAdministrativa.getInstance());
        return true;
    }

    public boolean registrarEvasao(Internacao internacao) {
        internacao.setEstado(InternacaoEstadoEvasao.getInstance());
        return true;
    }

    public boolean transferir(Internacao internacao) {
        internacao.setEstado(InternacaoEstadoTransferido.getInstance());
        return true;
    }
}
