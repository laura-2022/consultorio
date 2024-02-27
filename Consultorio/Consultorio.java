package com.laurapestana.prg3.Consultorio;

import java.util.Scanner;

public class Consultorio {
    private static final int MAX_MEDICOS = 10;
    private static final int MAX_PACIENTES = 100;

    Medico[] medicos = new Medico[MAX_MEDICOS];
    private Cola[] colaPorMedico = new Cola[MAX_MEDICOS];
    Paciente[] pacientes = new Paciente[MAX_PACIENTES];
    private int numMedicos = 0;
    private int numPacientes = 0;

    public void agregarMedico(Medico medico) {
        if (numMedicos < MAX_MEDICOS) {
            medicos[numMedicos++] = medico;
            colaPorMedico[numMedicos - 1] = new Cola();
        } else {
            System.out.println("No se puede agregar más médicos");
        }
    }

    public void agregarPaciente(Paciente paciente) {
        if (numPacientes < MAX_PACIENTES) {
            pacientes[numPacientes++] = paciente;
        } else {
            System.out.println("No se puede agregar más pacientes");
        }
    }

    public void agregarPacienteACola(Paciente paciente, Medico medico) {
        int indiceMedico = -1;
        for (int i = 0; i < numMedicos; i++) {
            if (medicos[i].equals(medico)) {
                indiceMedico = i;
                break;
            }
        }
        if (indiceMedico != -1) {
            colaPorMedico[indiceMedico].enqueue(paciente);
        } else {
            System.out.println("Médico no encontrado");
        }
    }

    public void llamarPaciente(Medico medico) {
        int indiceMedico = -1;
        for (int i = 0; i < numMedicos; i++) {
            if (medicos[i].equals(medico)) {
                indiceMedico = i;
                break;
            }
        }
        if (indiceMedico != -1) {
            if (!colaPorMedico[indiceMedico].isEmpty()) {
                System.out.println("Llamando al paciente: " + colaPorMedico[indiceMedico].dequeue());
            } else {
                System.out.println("No hay pacientes en cola para el médico " + medico.getNombre());
            }
        } else {
            System.out.println("Médico no encontrado");
        }
    }

    public static void main(String[] args) {
        ConsultorioMedico consultorio = new ConsultorioMedico();
        Scanner scanner = new Scanner(System.in);

        // Ejemplo de uso: Agregar médicos
        consultorio.agregarMedico(new Medico("Dr. Pérez", "Pediatría"));
        consultorio.agregarMedico(new Medico("Dr. Gómez", "Cardiología"));

        // Ejemplo de uso: Agregar pacientes
        consultorio.agregarPaciente(new Paciente("12345", "Juan"));
        consultorio.agregarPaciente(new Paciente("54321", "María"));

        // Ejemplo de uso: Agregar pacientes a cola de espera
        consultorio.agregarPacienteACola(consultorio.pacientes[0], consultorio.medicos[0]);
        consultorio.agregarPacienteACola(consultorio.pacientes[1], consultorio.medicos[1]);

        // Ejemplo de uso: Llamar paciente
        consultorio.llamarPaciente(consultorio.medicos[0]);

        scanner.close();
    }
}