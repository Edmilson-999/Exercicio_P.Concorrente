public class ProcessadorPedidos implements Runnable {
    private Pedido pedido;

    public ProcessadorPedidos(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Processando pedido " + pedido.getId() + " do cliente " + pedido.getCliente());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Processamento do pedido " + pedido.getId() + " interrompido");
        }
    }
}