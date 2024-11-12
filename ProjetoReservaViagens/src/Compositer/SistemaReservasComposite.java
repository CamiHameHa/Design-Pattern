import java.util.ArrayList;
import java.util.List;

public class SistemaReservasComposite {
    interface ComponenteReserva {
        void exibirDetalhes();
    }

    class ReservaIndividual implements ComponenteReserva {
        private String nome;

        public ReservaIndividual(String nome) {
            this.nome = nome;
        }

        public void exibirDetalhes() {
            System.out.println("Reserva individual: " + nome);
        }
    }

    class GrupoReservas implements ComponenteReserva {
        private List<ComponenteReserva> reservas = new ArrayList<>();

        public void adicionarReserva(ComponenteReserva reserva) {
            reservas.add(reserva);
        }

        public void exibirDetalhes() {
            for (ComponenteReserva reserva : reservas) {
                reserva.exibirDetalhes();
            }
        }
    }

    public static void main(String[] args) {
        SistemaReservasComposite sistema = new SistemaReservasComposite();

        ComponenteReserva reservaHotel = sistema.new ReservaIndividual("Reserva de Hotel");
        ComponenteReserva reservaVoo = sistema.new ReservaIndividual("Reserva de Voo");

        GrupoReservas grupoReservas = sistema.new GrupoReservas();
        grupoReservas.adicionarReserva(reservaHotel);
        grupoReservas.adicionarReserva(reservaVoo);

        System.out.println("Detalhes das reservas:");
        grupoReservas.exibirDetalhes();
    }
}
