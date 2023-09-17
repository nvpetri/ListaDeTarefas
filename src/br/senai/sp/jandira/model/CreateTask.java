package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateTask {
    Scanner teclado = new Scanner(System.in);

    public List<Task> tasks = new ArrayList<>();
    public List<RegisterUser> users = new ArrayList<>();

    public CreateTask(List<RegisterUser> users) {
        this.users = users;
    }

    public void addTask() {
        do {
            Task task = new Task();

            System.out.println("Insira a tarefa: ");
            task.title = teclado.nextLine();

            System.out.println("Digite a descrição da tarefa: ");
            task.description = teclado.nextLine();
            
            task.completed = false;

            System.out.println("Insira a data em que a tarefa irá expirar: ");
            task.date = teclado.nextLine();

            System.out.println("Essa tarefa será atribuída a qual usuário?");
            System.out.println("Usuários cadastrados:");

            for (int i = 0; i < users.size(); i++) {
                System.out.println(i + 1 + ". " + users.get(i).name);
            }

            System.out.print("Escolha o número do usuário a quem atribuir a tarefa: ");
            int userChoice = Integer.parseInt(teclado.nextLine());

            if (userChoice >= 1 && userChoice <= users.size()) {
                task.assignedUser = users.get(userChoice - 1);
                System.out.println("Tarefa atribuída ao usuário: " + users.get(userChoice - 1).name);
                tasks.add(task);
            } else {
                System.out.println("Opção inválida. Tarefa não atribuída a nenhum usuário.");
            }

            System.out.println("Deseja criar mais uma tarefa? (S/N)");

        } while (teclado.nextLine().equalsIgnoreCase("s"));
    }
}
