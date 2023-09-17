package br.senai.sp.jandira.model;

import java.util.List;
import java.util.Scanner;

public class RemoveTask {
    Scanner teclado = new Scanner(System.in);

    public void removeTask(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("A lista de tarefas está vazia. Não há tarefas para remover.");
            return;
        }

        System.out.println("Lista de Tarefas:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + ". " + tasks.get(i).title);
        }

        System.out.print("Digite o número da tarefa que deseja remover: ");
        int taskToRemove = Integer.parseInt(teclado.nextLine());

        if (taskToRemove >= 1 && taskToRemove <= tasks.size()) {
            Task removedTask = tasks.remove(taskToRemove - 1);
            System.out.println("Tarefa removida: " + removedTask.title);
        } else {
            System.out.println("Opção inválida. Nenhuma tarefa foi removida.");
        }
    }
}
