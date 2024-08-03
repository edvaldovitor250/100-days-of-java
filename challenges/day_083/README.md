# Day 83

## Desafio:

			Crie um sistema em Java para gerenciar um escritório de advocacia, incluindo cadastro de processos, clientes e agenda de compromissos.
            
**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Day083 {

    public static class Cliente {
        private String nome;
        private String cpf;
        private String endereco;
        private String telefone;

        public Cliente(String nome, String cpf, String endereco, String telefone) {
            this.nome = nome;
            this.cpf = cpf;
            this.endereco = endereco;
            this.telefone = telefone;
        }

        @Override
        public String toString() {
            return "Cliente{" +
                    "nome='" + nome + '\'' +
                    ", cpf='" + cpf + '\'' +
                    ", endereco='" + endereco + '\'' +
                    ", telefone='" + telefone + '\'' +
                    '}';
        }
    }

    public static class Processo {
        private String numero;
        private String descricao;
        private Cliente cliente;

        public Processo(String numero, String descricao, Cliente cliente) {
            this.numero = numero;
            this.descricao = descricao;
            this.cliente = cliente;
        }

        @Override
        public String toString() {
            return "Processo{" +
                    "numero='" + numero + '\'' +
                    ", descricao='" + descricao + '\'' +
                    ", cliente=" + cliente +
                    '}';
        }
    }

    public static class Compromisso {
        private String data;
        private String hora;
        private String descricao;

        public Compromisso(String data, String hora, String descricao) {
            this.data = data;
            this.hora = hora;
            this.descricao = descricao;
        }

        @Override
        public String toString() {
            return "Compromisso{" +
                    "data='" + data + '\'' +
                    ", hora='" + hora + '\'' +
                    ", descricao='" + descricao + '\'' +
                    '}';
        }
    }

    public static class EscritorioAdvocacia {
        private List<Cliente> clientes;
        private List<Processo> processos;
        private List<Compromisso> compromissos;

        public EscritorioAdvocacia() {
            this.clientes = new ArrayList<>();
            this.processos = new ArrayList<>();
            this.compromissos = new ArrayList<>();
        }

        public void cadastrarCliente(String nome, String cpf, String endereco, String telefone) {
            Cliente cliente = new Cliente(nome, cpf, endereco, telefone);
            clientes.add(cliente);
            System.out.println("Cliente cadastrado com sucesso!");
        }

        public void cadastrarProcesso(String numero, String descricao, String cpfCliente) {
            Cliente cliente = buscarClientePorCpf(cpfCliente);
            if (cliente != null) {
                Processo processo = new Processo(numero, descricao, cliente);
                processos.add(processo);
                System.out.println("Processo cadastrado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado!");
            }
        }

        public void agendarCompromisso(String data, String hora, String descricao) {
            Compromisso compromisso = new Compromisso(data, hora, descricao);
            compromissos.add(compromisso);
            System.out.println("Compromisso agendado com sucesso!");
        }

        private Cliente buscarClientePorCpf(String cpf) {
            for (Cliente cliente : clientes) {
                if (cliente.cpf.equals(cpf)) {
                    return cliente;
                }
            }
            return null;
        }

        public void listarClientes() {
            System.out.println("Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }

        public void listarProcessos() {
            System.out.println("Processos:");
            for (Processo processo : processos) {
                System.out.println(processo);
            }
        }

        public void listarCompromissos() {
            System.out.println("Compromissos:");
            for (Compromisso compromisso : compromissos) {
                System.out.println(compromisso);
            }
        }
    }

    public static void main(String[] args) {
        EscritorioAdvocacia escritorio = new EscritorioAdvocacia();
        escritorio.cadastrarCliente("João Silva", "12345678901", "Rua A, 123", "999999999");
        escritorio.cadastrarCliente("Maria Oliveira", "98765432100", "Rua B, 456", "888888888");
        escritorio.cadastrarProcesso("0001", "Ação trabalhista", "12345678901");
        escritorio.cadastrarProcesso("0002", "Ação civil", "98765432100");
        escritorio.agendarCompromisso("2024-08-10", "14:00", "Reunião com cliente João Silva");
        escritorio.agendarCompromisso("2024-08-11", "10:00", "Audiência processo 0001");
        escritorio.listarClientes();
        escritorio.listarProcessos();
        escritorio.listarCompromissos();
    }
}
