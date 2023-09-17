package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterUser {
	public String name;

	Scanner teclado = new Scanner(System.in);
	public static List<RegisterUser> users = new ArrayList<>();

	public void addUser() {
		do {
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
			System.out.println("------------------Cadastro Usuário--------------------");
			System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");

			RegisterUser user = new RegisterUser();
			
			System.out.print("Insira o nome do cliente: ");
            user.name = teclado.nextLine();
            System.out.println("------------------------------------------------------");
            
            
           users.add(user);
            
            System.out.println("Deseja cadastrar mais um cliente? (S/N): ");

		} while (teclado.nextLine().equalsIgnoreCase("S"));
	}
	
}