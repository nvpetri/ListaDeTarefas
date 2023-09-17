package br.senai.sp.jandira.model;

import java.util.List;

public class ShowTask {
    public void showTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Não há tarefas cadastradas.");
        } else {
            System.out.println("Lista de Tarefas:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println("Tarefa #" + (i + 1));
                System.out.println("Título: " + task.title);
                System.out.println("Descrição: " + task.description);
                System.out.println("Data de Expiração: " + task.date);
                if (task.completed) {
                    System.out.println("Status: Concluída");
                } else {
                    System.out.println("Status: Não Concluída");
                }
                if (task.assignedUser != null) {
                    System.out.println("Usuário Associado: " + task.assignedUser.name);
                }
                System.out.println("--------------------------");
            }
        }
    }
}
