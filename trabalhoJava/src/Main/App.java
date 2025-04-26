package Main;

import java.util.Scanner;


import Entities.*;
import Enum.EspecialidadeAnalista;
import Enum.StatusUsuario;
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

			default:
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

			case 2 : 
				cadastrarGerente();
				break;
			
			case 3:
				cadastrarDev();
			}
		} while (choice != 4);
	}

	public static void cadastrarAnalista() {
		Scanner sc = new Scanner(System.in);
		System.out.println("write information please.");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		int especialty = 1;

		do {
			System.out.println("what is the specialty");
			System.out.println("1-System");
			System.out.println("2-requirements");
			System.out.println("3-Business");
			System.out.println("4 - quality");
			especialty = sc.nextInt();
		} while (especialty > 4 || especialty < 1);
		System.out.println("Who is the manager?");
		Gerente manager = cadastrarGerente();
		sc.nextLine();
		if (especialty == 1) {
			Usuario analyst = new Analista(name, email, StatusUsuario.ativo, EspecialidadeAnalista.SISTEMA, manager);
		}
		if (especialty == 2) {
			Usuario analyst = new Analista(name, email, StatusUsuario.ativo, EspecialidadeAnalista.REQUISITOS, manager);
		}
		if (especialty == 3) {
			Usuario analyst = new Analista(name, email, StatusUsuario.ativo, EspecialidadeAnalista.NEGOCIO, manager);
		}
		if (especialty == 4) {
			Usuario analyst = new Analista(name, email, StatusUsuario.ativo, EspecialidadeAnalista.QUALIDADE, manager);
		}
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
	
	public static void cadastrarDev() {
		Scanner sc = new Scanner(System.in);
		System.out.println("write information please.");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		int specialty = 1;
		do {
			System.out.println("what is the specialty");
			System.out.println("1-Back-end");
			System.out.println("2-Front-end");
			System.out.println("3-FullStack");
			System.out.println("4 - Banco De Dados");
			specialty = sc.nextInt();
			
			Gerente manager = chamarGerente();
			if(specialty == 1) {
				Usuario Dev = new Desenvolvedor(name, email, StatusUsuario.ativo, EspecialidadeDev.BACKEND , manager);
			}if(specialty == 2) {
				Usuario Dev = new Desenvolvedor(name,email,StatusUsuario.ativo,EspecialidadeDev.FRONTEND,manager);
			}if(specialty == 3) {
				Usuario Dev = new Desenvolvedor(name,email,StatusUsuario.ativo,EspecialidadeDev.FULLSTACK,manager);
			}if(specialty == 4) {
				Usuario Dev = new Desenvolvedor(name,email,StatusUsuario.ativo,EspecialidadeDev.BANCODEDADOS,manager);
			}else {
				System.out.println("report a specialty that was illustrated");
			}
		}while(specialty > 4 || specialty < 1);
		
		
	}
	public static Gerente chamarGerente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to inform a manager or register a new manager?");
		System.out.println("1 - register");
		System.out.println("2- inform");
		int choice = sc.nextInt();
		if(choice == 1) {
			cadastrarGerente();
		}if(choice == 2) {
			System.out.println("inform the name of the manager");
			String managerName = sc.next();
			sc.nextLine();
			Gerente manager = Desenvolvedor.chamarGerente(managerName);
			if(manager == null) {
				System.out.println("not found");
				System.out.println("register the manager");
				Gerente manager2 = cadastrarGerente();
				return manager2;
				
			}
			return manager;
			
		}
		return null;
	}
}
