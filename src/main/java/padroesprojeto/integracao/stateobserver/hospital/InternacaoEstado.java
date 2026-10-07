package padroesprojeto.integracao.stateobserver.hospital;

public abstract class InternacaoEstado {

    public abstract String getEstado();

    public boolean internar(Internacao internacao) {
        return false;
    }

    public boolean darAltaMedica(Internacao internacao) {
        return false;
    }

    public boolean colocarEmObservacao(Internacao internacao) {
        return false;
    }

    public boolean darAltaAdministrativa(Internacao internacao) {
        return false;
    }

    public boolean registrarEvasao(Internacao internacao) {
        return false;
    }

    public boolean transferir(Internacao internacao) {
        return false;
    }
}
