package padroesprojeto.integracao.stateobserver.hospital;

public class InternacaoEstadoEmObservacao extends InternacaoEstado {

    private InternacaoEstadoEmObservacao() {};
    private static InternacaoEstadoEmObservacao instance = new InternacaoEstadoEmObservacao();
    public static InternacaoEstadoEmObservacao getInstance() {
        return instance;
    }

    public String getEstado() {
        return "EmObservacao";
    }

    public boolean internar(Internacao internacao) {
        internacao.setEstado(InternacaoEstadoInternado.getInstance());
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
}
