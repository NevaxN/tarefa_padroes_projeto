// Classe de Contexto: Pedido
public class Pedido {

    private EstadoPedido estadoAtual;

    public Pedido() {
        // Todo pedido começa como "Novo"
        this.estadoAtual = EstadoNovo.getInstance();
        System.out.println("Novo pedido criado. Estado: " + getStatus());
    }

    // Método para os objetos de estado alterarem o estado do pedido
    public void setEstado(EstadoPedido novoEstado) {
        this.estadoAtual = novoEstado;
        System.out.println(">>> Pedido mudou para o estado: " + getStatus());
    }

    public String getStatus() {
        return this.estadoAtual.getNome();
    }

    // Ações do cliente: O Pedido delega a chamada para o estado atual
    public void pagar() {
        try {
            estadoAtual.pagar(this);
        } catch (IllegalStateException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    public void enviar() {
        try {
            estadoAtual.enviar(this);
        } catch (IllegalStateException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    public void entregar() {
        try {
            estadoAtual.entregar(this);
        } catch (IllegalStateException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    public void cancelar() {
        try {
            estadoAtual.cancelar(this);
        } catch (IllegalStateException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}