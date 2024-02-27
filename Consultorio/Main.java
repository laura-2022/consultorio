package com.laurapestana.prg3.Consultorio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();
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


