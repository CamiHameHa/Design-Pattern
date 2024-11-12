public class SistemaReservasFactoryMethod {
    interface Reserva {
        void exibirDetalhes();
    }

    class ReservaHotel implements Reserva {
        public void exibirDetalhes() {
            System.out.println("Reserva de hotel criada.");
        }
    }

    class ReservaVoo implements Reserva {
        public void exibirDetalhes() {
            System.out.println("Reserva de voo criada.");
        }
    }

    abstract class ReservaCriadora {
        public abstract Reserva criarReserva();
    }

    class ReservaHotelCriadora extends ReservaCriadora {
        public Reserva criarReserva() {
            return new ReservaHotel();
        }
    }

    class ReservaVooCriadora extends ReservaCriadora {
        public Reserva criarReserva() {
            return new ReservaVoo();
        }
    }

    public static void main(String[] args) {
        SistemaReservasFactoryMethod sistema = new SistemaReservasFactoryMethod();

        ReservaCriadora criadoraHotel = sistema.new ReservaHotelCriadora();
        Reserva reservaHotel = criadoraHotel.criarReserva();
        reservaHotel.exibirDetalhes();

        ReservaCriadora criadoraVoo = sistema.new ReservaVooCriadora();
        Reserva reservaVoo = criadoraVoo.criarReserva();
        reservaVoo.exibirDetalhes();
    }
}
