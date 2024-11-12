import java.util.ArrayList;
import java.util.List;

public class SistemaReservasObserver {
    interface Observador {
        void atualizar(String mensagem);
    }

    class SistemaReservas {
        private List<Observador> observadores = new ArrayList<>();

        public void adicionarObservador(Observador observador) {
            observadores.add(observador);
        }

        public void removerObservador(Observador observador) {
            observadores.remove(observador);
        }

        public void notificarObservadores(String mensagem) {
            for (Observador observador : observadores) {
                observador.atualizar(mensagem);
            }
        }

        public void confirmarReserva(String tipoReserva) {
            System.out.println("Reserva confirmada: " + tipoReserva);
            notificarObservadores("Reserva de " + tipoReserva + " foi confirmada.");
        }
    }

    class Cliente implements Observador {
        private String nome;

        public Cliente(String nome) {
            this.nome = nome;
        }

        public void atualizar(String mensagem) {
            System.out.println(nome + " recebeu a mensagem: " + mensagem);
        }
    }

    public static void main(String[] args) {
        SistemaReservasObserver sistema = new SistemaReservasObserver();

        SistemaReservas sistemaReservas = sistema.new SistemaReservas();
        Cliente cliente1 = sistema.new Cliente("João");
        Cliente cliente2 = sistema.new Cliente("Maria");

        sistemaReservas.adicionarObservador(cliente1);
        sistemaReservas.adicionarObservador(cliente2);

        sistemaReservas.confirmarReserva("Hotel");
    }
}
