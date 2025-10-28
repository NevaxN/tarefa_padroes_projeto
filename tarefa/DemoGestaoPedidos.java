// Classe de Demonstração
public class DemoGestaoPedidos {
    public static void main(String[] args) {

        System.out.println("--- Cenário 1: Fluxo de Sucesso ---");
        Pedido pedido1 = new Pedido();

    // Tentar uma ação inválida
        pedido1.enviar(); // Deve falhar
        System.out.println("-----------------");

        // Ações válidas
        pedido1.pagar();  // Novo -> Pago
        pedido1.enviar(); // Pago -> Enviado
        pedido1.entregar(); // Enviado -> Entregue
        
        // Tentar uma ação em estado terminal
        pedido1.cancelar(); // Deve falhar
        
        System.out.println("\n--- Cenário 2: Cancelamento após Pagamento ---");
        Pedido pedido2 = new Pedido();

        pedido2.pagar();  // Novo -> Pago
        pedido2.cancelar(); // Pago -> Cancelado
        
        // Tentar uma ação em estado terminal
        pedido2.enviar(); // Deve falhar

        System.out.println("\n--- Cenário 3: Cancelamento Imediato ---");
        Pedido pedido3 = new Pedido(); // Novo

        pedido3.cancelar(); // Novo -> Cancelado
        
        // Tentar uma ação em estado terminal
        pedido3.pagar(); // Deve falhar
        
        System.out.println("\n--- Fim das Demonstrações ---"); 
    } // Fim do main
} // Fim da classe