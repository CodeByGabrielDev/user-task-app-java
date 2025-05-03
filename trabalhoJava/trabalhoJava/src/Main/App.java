package Main;

import java.util.Scanner;

import Entities.*;
import Enum.*;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to our application");
		menu();

	}

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		int choice = 1;
		do {

			System.out.println("Hello, what will be your option?");
			System.out.println("1 - register user");
			System.out.println("2 - create task");
			System.out.println("3- list task");
			System.out.println("4 - exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				escolhaDeCadastro();

				break;

			case 2:
				createTask();
				break;
			}
		} while (choice != 4);

	}

	public static void escolhaDeCadastro() {
		Scanner sc = new Scanner(System.in);
		int choice = 1;
		do {

			System.out.println("What type of user do you want to register in the company?");
			System.out.println("1 - Analyst");
			System.out.println("2 - Manager");
			System.out.println("3 - developer");
			System.out.println("4 - exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				cadastrarAnalista();
				break;

			case 2:
				cadastrarGerente();
				break;

			case 3:
				cadastrarDev();
			}
		} while (choice != 4);
	}

	public static Analista cadastrarAnalista() {
		Scanner sc = new Scanner(System.in);
		System.out.println("write information please.");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		int especialty = 1;
		System.out.println("Who is the manager?");
		Gerente manager = chamarGerente();
		sc.nextLine();
		Analista analyst = new Analista(name, email, StatusUsuario.ativo, manager);
		do {
			// Lembrar que pode possivelmente ter mais de uma especialidade, codar para
			// ajustar isso.
			System.out.println("how many specialties the analyst will have");
			int quantity = sc.nextInt();
			for (int i = 0; i < quantity; i++) {
				System.out.println("how many specialties the analyst will have");
				System.out.println("1-System");
				System.out.println("2-requirements");
				System.out.println("3-Business");
				System.out.println("4 - quality");
				especialty = sc.nextInt();
				if (especialty == 1) {
					analyst.addEsp(EspecialidadeAnalista.SISTEMA);
				}
				if (especialty == 2) {
					analyst.addEsp(EspecialidadeAnalista.REQUISITOS);
				}
				if (especialty == 3) {
					analyst.addEsp(EspecialidadeAnalista.NEGOCIO);
				}
				if (especialty == 4) {
					analyst.addEsp(EspecialidadeAnalista.QUALIDADE);
				}
			}

		} while (especialty > 4 || especialty < 1);
		System.out.println("Analyst addictioned with sucesseful");
		return analyst;
	}

	public static Gerente cadastrarGerente() {
		Scanner sc = new Scanner(System.in);
		/*
		 * private static int ultimoId; private int id; private String name; private
		 * String email; private StatusUsuario stats;
		 */
		System.out.println("write information please.");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		return new Gerente(name, email, StatusUsuario.ativo);
	}

	public static Desenvolvedor cadastrarDev() {
		Scanner sc = new Scanner(System.in);
		System.out.println("write information please.");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		int specialty = 1;
		Gerente manager = chamarGerente();
		System.out.println("How many especialty");
		int quantity = sc.nextInt();
		Desenvolvedor dev = new Desenvolvedor(name, email, StatusUsuario.ativo, manager);
		do {
			for (int i = 0; i < quantity; i++) {
				System.out.println("how many specialties the developer will have");
				System.out.println("1-Back-end");
				System.out.println("2-front-end");
				System.out.println("3-fullstack");
				System.out.println("4 - database");
				specialty = sc.nextInt();
				if (specialty == 1) {
					dev.addEsp(EspecialidadeDev.BACKEND);
				}
				if (specialty == 2) {
					dev.addEsp(EspecialidadeDev.FRONTEND);
				}
				if (specialty == 3) {
					dev.addEsp(EspecialidadeDev.FULLSTACK);
				}
				if (specialty == 4) {
					dev.addEsp(EspecialidadeDev.BANCODEDADOS);
				}

			}
		} while (specialty > 5 || specialty < 1);
		System.out.println("Dev addictioned with sucessuful");
		return dev;

	}

	public static Gerente chamarGerente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to inform a manager or register a new manager?");
		System.out.println("1 - register");
		System.out.println("2- inform");
		int choice = sc.nextInt();
		if (choice == 1) {
			cadastrarGerente();
		}
		if (choice == 2) {
			System.out.println("inform the name of the manager");
			String managerName = sc.next();
			sc.nextLine();
			Gerente manager = Desenvolvedor.chamarGerente(managerName);
			if (manager == null) {
				System.out.println("not found");
				System.out.println("register the manager");
				Gerente manager2 = cadastrarGerente();
				return manager2;

			}
			return manager;

		}
		return null;
	}

	public static void createTask() {
		/*
		 * private static int ultimoId;
		 *  private String title; 
		 *  private String desc; 
		 *  list
		 * com add 
		 * private prioridade prioridade; 
		 * private status stats; 
		 * private Usuario usuario;
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the task title");
		String title = sc.next();
		System.out.println("Enter the description of task");
		String desc = sc.next();
		sc.nextLine();
		System.out.println("What would be the priority of this task?");
		System.out.println("1 -urgent ");
		System.out.println("2 - High");
		System.out.println("3 - medium");
		System.out.println("4- low");
		int escolha = sc.nextInt();
		prioridade priority = prioridade.baixa;
		
		switch (escolha) {
		case 1:
			priority = prioridade.urgente;
			break;
			
		case 2:
			priority = prioridade.alta;
			break;
			
		case 3:
			priority = prioridade.media;
			break;
		case 4:
			priority = prioridade.baixa;
		}
		System.out.println("Do you want to link a user or create a user and link it?");
		System.out.println("1 - Create");
		System.out.println("2 - link");
		int a = sc.nextInt();
				if(a == 1) {
					Usuario developer = cadastrarDev();
					Tarefa task = new Tarefa(title,desc,priority,developer);
					task.vincularUsuario(developer);
					
				}if(a == 2) {
					try {
					System.out.println("What is the username?");
					String name = sc.next();
					sc.nextLine();
					Usuario userFound = Usuario.encontrarUsuario(name);
					Tarefa task = new Tarefa(title,desc,priority,userFound);
					task.vincularUsuario(userFound);
					}catch(NullPointerException e) {
						System.out.println("User not found, please create one");
						Usuario developer = cadastrarDev();
						Tarefa task = new Tarefa(title,desc,priority,developer);
						task.vincularUsuario(developer);
					}
				}
	}

}
