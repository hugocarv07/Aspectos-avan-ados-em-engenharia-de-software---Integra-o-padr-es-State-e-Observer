package padroesprojeto.integracao.stateobserver.hospital;

import java.util.ArrayList;
import java.util.List;

public abstract class Notificavel {

    private List<Observador> observadores = new ArrayList<>();
    private boolean alterado = false;

    public void addObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removeObservador(Observador observador) {
        observadores.remove(observador);
    }

    protected void setAlterado() {
        this.alterado = true;
    }

    protected boolean foiAlterado() {
        return this.alterado;
    }

    protected void notificarObservadores() {
        notificarObservadores(null);
    }

    protected void notificarObservadores(Object dado) {
        if (!foiAlterado()) {
            return;
        }
        for (Observador observador : observadores) {
            observador.atualizar(this, dado);
        }
        this.alterado = false;
    }
}
