public class Day037 {
    public static void main(String[] args) {
        RedesSociais redes = new RedesSociais();

        redes.cadastrarUsuario("Alice", 1234);
        redes.cadastrarUsuario("Bob", 5678);

        redes.adicionarAmigo("Alice", "Bob");

        redes.compartilharMensagem("Alice", "Olá, esta é minha primeira mensagem!");
        redes.compartilharMensagem("Bob", "Oi Alice, tudo bem?");

        redes.listarAmigos("Alice");
        redes.listarMensagens("Alice");
        redes.listarMensagens("Bob");
    }

}


