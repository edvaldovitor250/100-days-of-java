# Day 67

## Desafio:

Crie um sistema em Java para gerenciar um hospital, incluindo cadastro de pacientes, agendamento de consultas e controle de leitos disponíveis.
    
**Resultado:**


```java

import java.util.ArrayList;
import java.util.List;

public class Day067 {

    static class GerenciaHospital {
    
        List<String> pacientes;
        List<String> consulta;
        List<Integer> agendamento;

        public GerenciaHospital() {
            pacientes = new ArrayList<>();
            consulta = new ArrayList<>();
            agendamento = new ArrayList<>();
        }

        public void addPaciente(String paciente, int idade) {
            pacientes.add(paciente);
            agendamento.add(idade);
        }

        public void realizarConsulta(int index, String medico) {
            consulta.add(medico);
            System.out.println("Paciente: " + pacientes.get(index) + ", Médico: " + medico);
        }

        public void listarConsulta() {
            for (int i = 0; i < consulta.size(); i++) {
                System.out.println("Paciente: " + pacientes.get(i) + ", Médico: " + consulta.get(i));
            }
        }
    }

    public static void main(String[] args) {
        GerenciaHospital hospital = new GerenciaHospital();

        hospital.addPaciente("Alice", 30);
        hospital.addPaciente("Bob", 25);
        hospital.addPaciente("Charlie", 40);

        hospital.realizarConsulta(0, "Dr. Smith");
        hospital.realizarConsulta(1, "Dr. Johnson");

        hospital.listarConsulta();
    }
}
