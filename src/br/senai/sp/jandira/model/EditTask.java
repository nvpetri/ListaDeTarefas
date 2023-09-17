package br.senai.sp.jandira.model;

import java.util.List;
import java.util.Scanner;

public class EditTask {
    Scanner teclado = new Scanner(System.in);

    public void editTask(List<Task> tasks, List<RegisterUser> users) {
        if (tasks.isEmpty()) {
            System.out.println("Não há tarefas cadastradas para editar.");
            return;
        }

        System.out.println("Lista de Tarefas para Edição:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + ". " + tasks.get(i).title);
        }

        System.out.print("Digite o número da tarefa que deseja editar: ");
        int taskToEdit = Integer.parseInt(teclado.nextLine());

        if (taskToEdit >= 1 && taskToEdit <= tasks.size()) {
            Task task = tasks.get(taskToEdit - 1);

            System.out.println("Tarefa selecionada para edição: " + task.title);

            System.out.print("Novo Título (ou pressione Enter para manter o atual): ");
            String newTitle = teclado.nextLine();
            if (!newTitle.isEmpty()) {
                task.title = newTitle;
            }

            System.out.print("Nova Descrição (ou pressione Enter para manter a atual): ");
            String newDescription = teclado.nextLine();
            if (!newDescription.isEmpty()) {
                task.description = newDescription;
            }

            System.out.print("Nova Data (ou pressione Enter para manter a atual): ");
            String newDate = teclado.nextLine();
            if (!newDate.isEmpty()) {
                task.date = newDate;
            }

            System.out.println("Atribuir a outra pessoa? (S/N)");
            String assignToAnotherPerson = teclado.nextLine();
            if (assignToAnotherPerson.equalsIgnoreCase("S")) {
                System.out.println("Usuários cadastrados:");
                for (int i = 0; i < users.size(); i++) {
                    System.out.println(i + 1 + ". " + users.get(i).name);
                }
                System.out.print("Escolha o número do novo usuário: ");
                int newUserIndex = Integer.parseInt(teclado.nextLine());
                if (newUserIndex >= 1 && newUserIndex <= users.size()) {
                    task.assignedUser = users.get(newUserIndex - 1);
                } else {
                    System.out.println("Opção inválida. Tarefa mantida com o usuário atual.");
                }
                System.out.println("Editar Status? (S/N)");
                String editStatus = teclado.nextLine();
                if (editStatus.equalsIgnoreCase("S")) {
                    System.out.println("Status atual: " + (task.completed ? "Concluída" : "Não Concluída"));
                    System.out.print("Novo Status (Concluída ou Não Concluída): ");
                    String newStatus = teclado.nextLine();
                    if (newStatus.equalsIgnoreCase("Concluída")) {
                        task.completed = true;
                    } else if (newStatus.equalsIgnoreCase("Não Concluída")) {
                        task.completed = false;
                    } else {
                        System.out.println("Opção de status inválida. O status da tarefa não foi alterado.");
                    }
                }
            }
            System.out.println("Tarefa editada com sucesso.");
        } else {
            System.out.println("Opção inválida. Nenhuma tarefa foi editada.");
        }
    }
}
