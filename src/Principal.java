public class Principal {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        agenda.adicionarContato(new Contato("Fulano", "123456789", "Rua A", "Amigo"));
        agenda.adicionarContato(new Contato("Ciclano", "12345642489", "Rua B", "Amigao"));
        agenda.adicionarContato(new Contato("Beltrano", "987654321", "Rua C", "Colega"));

        agenda.adicionarContato(new Contato("Fulano", "1", "Rua B", "UFF"));
        agenda.removerContato("Ciclano");
        agenda.listarContatos();
        agenda.buscarContato("Fulano");

    }
}
