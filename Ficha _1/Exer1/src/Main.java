import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(1, "João", 100.0));
        pedidos.add(new Pedido(2, "Maria", 200.0));
        pedidos.add(new Pedido(3, "Pedro", 150.0));

        List<Thread> threads = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            Thread thread = new Thread(new ProcessadorPedidos(pedido));
            threads.add(thread);
            thread.start();
        }

        try {
            Thread.sleep(10000); // Aguarda 10 segundos
            for (Thread thread : threads) {
                thread.interrupt();
            }
            for (Thread thread : threads) {
                thread.join(); // Aguarda as threads terminarem
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}