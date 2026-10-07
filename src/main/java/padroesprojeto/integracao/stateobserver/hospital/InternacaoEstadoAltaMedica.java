package padroesprojeto.integracao.stateobserver.hospital;

public class InternacaoEstadoAltaMedica extends InternacaoEstado {

    private InternacaoEstadoAltaMedica() {};
    private static InternacaoEstadoAltaMedica instance = new InternacaoEstadoAltaMedica();
    public static InternacaoEstadoAltaMedica getInstance() {
        return instance;
    }

    public String getEstado() {
        return "AltaMedica";
    }
}
