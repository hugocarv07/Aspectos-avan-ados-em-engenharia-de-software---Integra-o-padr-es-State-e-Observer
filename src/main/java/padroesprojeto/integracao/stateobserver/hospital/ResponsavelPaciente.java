package padroesprojeto.integracao.stateobserver.hospital;

public class ResponsavelPaciente implements Observador {

    private String nome;
    private String ultimaNotificacao;

    public ResponsavelPaciente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void acompanhar(Internacao internacao) {
        internacao.addObservador(this);
    }

    public void atualizar(Object fonte, Object dado) {
        Internacao internacao = (Internacao) fonte;
        this.ultimaNotificacao = this.nome + ", paciente " + internacao.getNomePaciente()
                + " mudou para o estado " + internacao.getNomeEstado();
    }
}
