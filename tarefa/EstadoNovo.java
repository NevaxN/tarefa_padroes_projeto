// Estado: Novo
class EstadoNovo extends DefaultEstadoPedido {
    private static final EstadoNovo instance = new EstadoNovo();
    private EstadoNovo() {}
    public static EstadoNovo getInstance() { return instance; }

    @Override
    public String getNome() { return "Novo"; }

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Pedido pago com sucesso.");
        // Transição de estado
        pedido.setEstado(EstadoPago.getInstance());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Pedido cancelado.");
        // Transição de estado
        pedido.setEstado(EstadoCancelado.getInstance());
    }
}

// Estado: Pago
class EstadoPago extends DefaultEstadoPedido {
    private static final EstadoPago instance = new EstadoPago();
    private EstadoPago() {}
    public static EstadoPago getInstance() { return instance; }

    @Override
    public String getNome() { return "Pago"; }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("Pedido enviado para o cliente.");
        // Transição de estado
        pedido.setEstado(EstadoEnviado.getInstance());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Pedido pago cancelado (estorno processado).");
        // Transição de estado
        pedido.setEstado(EstadoCancelado.getInstance());
    }
}

// Estado: Enviado
class EstadoEnviado extends DefaultEstadoPedido {
    private static final EstadoEnviado instance = new EstadoEnviado();
    private EstadoEnviado() {}
    public static EstadoEnviado getInstance() { return instance; }

    @Override
    public String getNome() { return "Enviado"; }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("Pedido entregue ao cliente.");
        // Transição de estado
        pedido.setEstado(EstadoEntregue.getInstance());
    }
}

// Estado: Entregue (Estado Terminal)
class EstadoEntregue extends DefaultEstadoPedido {
    private static final EstadoEntregue instance = new EstadoEntregue();
    private EstadoEntregue() {}
    public static EstadoEntregue getInstance() { return instance; }

    @Override
    public String getNome() { return "Entregue"; }

    // Nenhuma ação é permitida a partir daqui. 
    // A classe pai (DefaultEstadoPedido) já lança exceções.
}

// Estado: Cancelado (Estado Terminal)
class EstadoCancelado extends DefaultEstadoPedido {
    private static final EstadoCancelado instance = new EstadoCancelado();
    private EstadoCancelado() {}
    public static EstadoCancelado getInstance() { return instance; }

    @Override
    public String getNome() { return "Cancelado"; }

    // Nenhuma ação é permitida a partir daqui.
}