package padroesprojeto.integracao.stateobserver.hospital;

public class InternacaoEstadoAltaAdministrativa extends InternacaoEstado {

    private InternacaoEstadoAltaAdministrativa() {};
    private static InternacaoEstadoAltaAdministrativa instance = new InternacaoEstadoAltaAdministrativa();
    public static InternacaoEstadoAltaAdministrativa getInstance() {
        return instance;
    }

    public String getEstado() {
        return "AltaAdministrativa";
    }
}
