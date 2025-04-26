package Main;

import java.util.Scanner;

import Entities.*;
import Enum.EspecialidadeAnalista;
import Enum.StatusUsuario;

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
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				cadastrarAnalista();
				break;

			default:
				break;
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
		}while(especialty > 4 || especialty <1 );
		System.out.println("Who is the manager?");
		Gerente manager = cadastrarGerente();
		sc.nextLine();
		if(especialty == 1) {
			Usuario Analyst = new Analista(name, email,StatusUsuario.ativo,EspecialidadeAnalista.SISTEMA,manager);
		}
	}
	public static Gerente cadastrarGerente() {
		Scanner sc = new Scanner(System.in);
		/*
		 * private static int ultimoId;
	private int id;
	private String name;
	private String email;
	private StatusUsuario stats;
		 */
		System.out.println("write information please.");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		return new Gerente(name,email,StatusUsuario.ativo);
	}

}
