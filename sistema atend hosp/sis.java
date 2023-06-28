import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Paciente {
    private String nome;
    private String cpf;
    private int prioridade;

    public Paciente(String nome, String cpf, int prioridade) {
        this.nome = nome;
        this.cpf = cpf;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getPrioridade() {
        return prioridade;
    }
}

class GestaoHospital {
    private Queue<Paciente> filaNormal;
    private Queue<Paciente> filaLeve;
    private Queue<Paciente> filaModerado;
    private Queue<Paciente> filaSevero;

    public GestaoHospital() {
        filaNormal = new LinkedList<>();
        filaLeve = new LinkedList<>();
        filaModerado = new LinkedList<>();
        filaSevero = new LinkedList<>();
    }

    public void adicionarPaciente(String nome, String cpf, int prioridade) {
        Paciente paciente = new Paciente(nome, cpf, prioridade);
        switch (prioridade) {
            case 0:
                filaNormal.offer(paciente);
                break;
            case 1:
                filaLeve.offer(paciente);
                break;
            case 2:
                filaModerado.offer(paciente);
                break;
            case 3:
                filaSevero.offer(paciente);
                break;
            default:
                System.out.println("Prioridade inválida. O paciente não foi adicionado.");
        }
        System.out.println("Paciente adicionado com sucesso!");
    }

    public void atenderProximoPaciente() {
        if (!filaSevero.isEmpty()) {
            Paciente paciente = filaSevero.poll();
            System.out.println("Atendendo paciente SEVERO: " + paciente.getNome());
        } else if (!filaModerado.isEmpty()) {
            Paciente paciente = filaModerado.poll();
            System.out.println("Atendendo paciente MODERADO: " + paciente.getNome());
        } else if (!filaLeve.isEmpty()) {
            Paciente paciente = filaLeve.poll();
            System.out.println("Atendendo paciente LEVE: " + paciente.getNome());
        } else if (!filaNormal.isEmpty()) {
            Paciente paciente = filaNormal.poll();
            System.out.println("Atendendo paciente NORMAL: " + paciente.getNome());
        } else {
            System.out.println("Não há pacientes na fila.");
        }
    }

    public int getNumeroPacientesNaFila() {
        return filaNormal.size() + filaLeve.size() + filaModerado.size() + filaSevero.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestaoHospital gestaoHospital = new GestaoHospital();

        while (true) {
            System.out.println("\n==== Sistema de Atendimento Hospitalar ====");
            System.out.println("1. Adicionar paciente à fila");
            System.out.println("2. Atender próximo paciente");
            System.out.println("3. Exibir número de pacientes na fila");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // Limpa o buffer do scanner
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("
