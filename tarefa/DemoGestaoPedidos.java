public class DemoGestaoPedidos {
    public static void main(String[] args) {

        System.out.println("--- Cenário 1: Fluxo de Sucesso ---");
        Pedido pedido1 = new Pedido();

        pedido1.enviar();
        System.out.println("-----------------");

        pedido1.pagar();
        pedido1.enviar();
        pedido1.entregar();
        
        pedido1.cancelar();
        
        System.out.println("\n--- Cenário 2: Cancelamento após Pagamento ---");
        Pedido pedido2 = new Pedido();

        pedido2.pagar();
        pedido2.cancelar();
        
        pedido2.enviar();

        System.out.println("\n--- Cenário 3: Cancelamento Imediato ---");
        Pedido pedido3 = new Pedido();

        pedido3.cancelar();
        
        pedido3.pagar();
        
        System.out.println("\n--- Fim das Demonstrações ---"); 
    }
}