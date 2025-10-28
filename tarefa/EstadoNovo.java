class EstadoNovo extends DefaultEstadoPedido {
    private static final EstadoNovo instance = new EstadoNovo();
    private EstadoNovo() {}
    public static EstadoNovo getInstance() { return instance; }

    @Override
    public String getNome() { return "Novo"; }

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Pedido pago com sucesso.");
        pedido.setEstado(EstadoPago.getInstance());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Pedido cancelado.");
        pedido.setEstado(EstadoCancelado.getInstance());
    }
}

class EstadoPago extends DefaultEstadoPedido {
    private static final EstadoPago instance = new EstadoPago();
    private EstadoPago() {}
    public static EstadoPago getInstance() { return instance; }

    @Override
    public String getNome() { return "Pago"; }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("Pedido enviado para o cliente.");
        pedido.setEstado(EstadoEnviado.getInstance());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Pedido pago cancelado (estorno processado).");
        pedido.setEstado(EstadoCancelado.getInstance());
    }
}

class EstadoEnviado extends DefaultEstadoPedido {
    private static final EstadoEnviado instance = new EstadoEnviado();
    private EstadoEnviado() {}
    public static EstadoEnviado getInstance() { return instance; }

    @Override
    public String getNome() { return "Enviado"; }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("Pedido entregue ao cliente.");
        pedido.setEstado(EstadoEntregue.getInstance());
    }
}

class EstadoEntregue extends DefaultEstadoPedido {
    private static final EstadoEntregue instance = new EstadoEntregue();
    private EstadoEntregue() {}
    public static EstadoEntregue getInstance() { return instance; }

    @Override
    public String getNome() { return "Entregue"; }
}

class EstadoCancelado extends DefaultEstadoPedido {
    private static final EstadoCancelado instance = new EstadoCancelado();
    private EstadoCancelado() {}
    public static EstadoCancelado getInstance() { return instance; }

    @Override
    public String getNome() { return "Cancelado"; }
}