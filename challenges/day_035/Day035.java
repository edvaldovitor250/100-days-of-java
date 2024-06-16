public class Day035 {
    public static void main(String[] args) {
        AgendaNova agenda = new AgendaNova();

        agenda.adicionar("Alice", 123456789);
        agenda.adicionar("Bob", 987654321);
        agenda.adicionar("Charlie", 555555555);

        agenda.listarAgenda();

        agenda.atualizar("Bob", 111111111);

        agenda.listarAgenda();

        agenda.remover("Alice");

        agenda.listarAgenda();

        agenda.remover("David");

        agenda.atualizar("David", 222222222);

        agenda.listarAgenda();
    }
}