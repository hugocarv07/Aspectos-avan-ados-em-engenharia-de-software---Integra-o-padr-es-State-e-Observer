package padroesprojeto.integracao.stateobserver.hospital;

public class InternacaoEstadoEvasao extends InternacaoEstado {

    private InternacaoEstadoEvasao() {};
    private static InternacaoEstadoEvasao instance = new InternacaoEstadoEvasao();
    public static InternacaoEstadoEvasao getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Evasao";
    }

    public boolean darAltaAdministrativa(Internacao internacao) {
        internacao.setEstado(InternacaoEstadoAltaAdministrativa.getInstance());
        return true;
    }
}
