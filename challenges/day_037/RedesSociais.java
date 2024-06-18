import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedesSociais {
  private Map<String, Integer> usuarios;
    private Map<String, List<String>> amigos;
    private Map<String, List<String>> mensagens;

    public RedesSociais() {
        this.usuarios = new HashMap<>();
        this.amigos = new HashMap<>();
        this.mensagens = new HashMap<>();
    }

    public void cadastrarUsuario(String nome, int senha) {
        if (usuarios.containsKey(nome)) {
            System.out.println("Usuário " + nome + " já está cadastrado.");
        } else {
            usuarios.put(nome, senha);
            amigos.put(nome, new ArrayList<>());
            mensagens.put(nome, new ArrayList<>());
            System.out.println("Usuário " + nome + " cadastrado com sucesso!");
        }
    }

    public void adicionarAmigo(String usuario, String amigo) {
        if (usuarios.containsKey(usuario) && usuarios.containsKey(amigo)) {
            amigos.get(usuario).add(amigo);
            amigos.get(amigo).add(usuario);
            System.out.println("Amigo " + amigo + " adicionado a " + usuario);
        } else {
            System.out.println("Um dos usuários não está cadastrado.");
        }
    }

    public void compartilharMensagem(String usuario, String mensagem) {
        if (usuarios.containsKey(usuario)) {
            mensagens.get(usuario).add(mensagem);
            System.out.println("Mensagem compartilhada: " + mensagem);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void listarAmigos(String usuario) {
        if (usuarios.containsKey(usuario)) {
            List<String> listaAmigos = amigos.get(usuario);
            System.out.println("Amigos de " + usuario + ": " + String.join(", ", listaAmigos));
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void listarMensagens(String usuario) {
        if (usuarios.containsKey(usuario)) {
            List<String> listaMensagens = mensagens.get(usuario);
            System.out.println("Mensagens de " + usuario + ": ");
            for (String mensagem : listaMensagens) {
                System.out.println("- " + mensagem);
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
    
}