public abstract class DefaultEstadoPedido implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Não é possível pagar um pedido no estado: " + getNome());
    }

    @Override
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Não é possível enviar um pedido no estado: " + getNome());
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new IllegalStateException("Não é possível entregar um pedido no estado: " + getNome());
    }

    @Override
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Não é possível cancelar um pedido no estado: " + getNome());
    }
}
