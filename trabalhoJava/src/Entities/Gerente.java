package Entities;

import Enum.StatusUsuario;
import Enum.cargo;
import Enum.status;

public class Gerente extends Usuario {

	private static int ultimoId;
	private int id;

	public Gerente() {
		this.id = novoId();
	}

	public Gerente(String name, String email, StatusUsuario stats) {
		super(name, email, stats);
		this.setStats(StatusUsuario.ativo);
		this.id = novoId();
		

	}

	public void setName(String name) {
		if (super.getStats() == StatusUsuario.ativo) {
			super.setName(name);
		}
	}

	public void setEmail(String email) {
		if (super.getStats() == StatusUsuario.ativo) {
			super.setEmail(email);
		}
	}

	public void ListarEquipe() {
		for (Usuario list : listUsuario) {
			if (list.getGerenteResp() == this) {
				System.out.println("- " + list.getName() + " (" + list.getCargo() + ")");
			}
		}
	}

	public void listarAtividadesEmAndamento() {
		for (Tarefa tarefa : Tarefa.listTarefa) {
			if (tarefa.getStats() == status.emAndamento) {
				Usuario responsavel = tarefa.getUsuario();
				if (responsavel != null && responsavel.getGerenteResp() == this) {
					System.out.println("Tarefa: " + tarefa.getTitle() + " | Responsável: " + responsavel.getName());
				}
			}
		}
	}

	public void visualizarTarefas() {
		for (Tarefa task : Tarefa.listTarefa) {
			if (task.getUsuario() == this) {
				System.out.println("Tarefas : " + task.getTitle());
			}
		}
	}

	public cargo getCargo() {
		return cargo.gerente;
	}

	public Gerente getGerenteResp() {
		return null;
	}

	public int novoId() {
		return ++ultimoId;
	}
}
