// Classe Agenda
import java.io.*;


public class Agenda {
    private Contato[] contatos;
    private int ultimo;

    public Agenda() {
        this.contatos = new Contato[1000];
        this.ultimo = 0;
    }


    public void adicionarContato(Contato novoContato) {
        // Verifica se o contato já existe
        for (int i = 0; i < ultimo; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(novoContato.getNome())) {
                editarContato(novoContato);
                return;
            }
        }
        // Adiciona o novo contato
        if (ultimo < contatos.length) {
            contatos[ultimo++] = novoContato;
            System.out.println(Cores.VERDE+"Contato adicionado com sucesso.");
        } else {
            System.out.println(Cores.VERMELHO+ "Agenda cheia. Não é possível adicionar mais contatos.");
        }
    }
    
    public void editarContato(Contato contatoAtualizado) {
        for (int i = 0; i < ultimo; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(contatoAtualizado.getNome())) {
                // Atualiza os dados do contato existente
                contatos[i] = contatoAtualizado;
                System.out.println(Cores.VERDE+ "Contato atualizado com sucesso.");
                return;
            }
        }
        System.out.println(Cores.VERMELHO+"Contato não encontrado.");
    }

    public void removerContato(String nome) {
        for (int i = 0; i < ultimo; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) { // 
                contatos[i] = contatos[ultimo - 1]; 
                contatos[ultimo - 1] = null; // Remove a referência
                ultimo--;
                System.out.println(Cores.VERDE +"Contato removido.");
                return;
            }
        }
        System.out.println(Cores.VERMELHO +"Contato não encontrado.");
    }

    public Contato buscarContato(String nome) {
        for (int i = 0; i < ultimo; i++) {
         
            if (contatos[i].getNome().toLowerCase().contains(nome.toLowerCase())) {
           
                System.out.println(Cores.AMARELO+"Contato encontrado: " + contatos[i]);
                return contatos[i]; // Retorna o primeiro contato encontrado
            }
        }
       
        System.out.println(Cores.VERMELHO+"Nenhum contato encontrado com o nome: " + nome);
        return null;
    }
    

    public void listarContatos() {
        if (ultimo == 0) {
            System.out.println(Cores.VERMELHO +"A agenda está vazia.");
        } else {
            for (int i = 0; i < ultimo; i++) {
                System.out.println(Cores.AMARELO+contatos[i]);
            }
        }
    }
    public void salvarContatos(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (int i = 0; i < ultimo; i++) {
                Contato contato = contatos[i];
                // Escreve os dados do contato separados por ponto e vírgula
                writer.println(contato.getNome() + ";" + contato.getTelefone() + ";" + contato.getEndereco() + ";" + contato.getRelacao());
            }
            System.out.println(Cores.VERDE+ "Contatos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: ");
        }
    }
    
    public void carregarContatos(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            ultimo = 0;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    contatos[ultimo++] = new Contato(partes[0], partes[1], partes[2], partes[3]);
                }
            }
            System.out.println(Cores.VERDE +"Contatos carregados com sucesso.");
        } catch (IOException e) {
            System.out.println(Cores.VERMELHO +"Erro ao carregar contatos: ");
        }
    }
}
    