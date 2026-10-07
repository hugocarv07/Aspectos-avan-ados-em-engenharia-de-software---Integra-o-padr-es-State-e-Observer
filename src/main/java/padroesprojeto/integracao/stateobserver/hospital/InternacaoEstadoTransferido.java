package padroesprojeto.integracao.stateobserver.hospital;

public class InternacaoEstadoTransferido extends InternacaoEstado {

    private InternacaoEstadoTransferido() {};
    private static InternacaoEstadoTransferido instance = new InternacaoEstadoTransferido();
    public static InternacaoEstadoTransferido getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Transferido";
    }
}
