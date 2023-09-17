package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {
	Scanner teclado = new Scanner(System.in);
	
	CreateTask task = new CreateTask(RegisterUser.users);
	RegisterUser user = new RegisterUser();
	ShowTask taskViewer = new ShowTask();
	RemoveTask remove = new RemoveTask();
	EditTask edit = new EditTask();

	boolean continuar = true;
	
	public void startMenu() {
		while(continuar) {
			System.out.println("------------------------------------------------------------");
			System.out.println("-------------------Olá, seja bem vindo----------------------");
			System.out.println("----------------ao Gerenciador de Tarefas-------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("- 1 - Cadastrar Usuário");
			System.out.println("- 2 - Criar Tarefa");
			System.out.println("- 3 - Mostrar Tarefas");
			System.out.println("- 4 - Excluir Tarefas");
			System.out.println("- 5 - Editar Tarefas");
			System.out.println("------------------------------------------------------------");
			
			int userOption = teclado.nextInt();
			
			switch (userOption) {
			case 1: 
				user.addUser();
				break;
			case 2:
				task.addTask();
				break;
			case 3:
				taskViewer.showTasks(task.tasks);
				break;
			case 4:
				remove.removeTask(task.tasks);
				break;
			case 5:
				edit.editTask(task.tasks, RegisterUser.users);
				break;
			default:
				System.out.println("Opção Invalida");
				break;
			}
			
		}
	}
	
}
