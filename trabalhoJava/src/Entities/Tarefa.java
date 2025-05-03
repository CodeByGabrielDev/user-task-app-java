package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Enum.*;

public class Tarefa {

	private static int ultimoId;
	private int id;
	private String title;
	private String desc;
	private prioridade prioridade;
	private status stats;
	private Usuario usuario;
	private static List<cargo> listCargosResp = new ArrayList<>();
	public static List<Tarefa> listTarefa = new ArrayList<>();

	public Tarefa() {
		this.id = novoId();
	}

	public Tarefa(String title, String desc, prioridade prioridade, Usuario usuario) {
		this.title = title;
		this.desc = desc;
		this.prioridade = prioridade;
		this.stats = status.pendente;
		this.usuario = usuario;
		this.id = novoId();
		listTarefa.add(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (stats == status.pendente) {
			this.title = title;
		}
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		if (stats == status.pendente) {
			this.desc = desc;
		}
	}

	public prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(prioridade prioridade) {
		if (stats == status.pendente) {
			this.prioridade = prioridade;
		}
	}

	public status getStats() {
		return stats;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public int getId() {
		return id;
	}

	public int novoId() {
		return ++ultimoId;
	}

	public void exportarPorStatus(String aux) {
		boolean found = false;
		for (Tarefa task : listTarefa) {
			if (task.getStats().name().equals(aux)) {
				System.out.println("Titulo: " + task);
				found = true;
			}
			if (found != true) {
				System.out.println("nao foi encontrado nada");
			}
		}
	}

	public void exportarPorPrioridade(String aux) {
		boolean found = false;
		for (Tarefa task : listTarefa) {
			if (task.getPrioridade().name().equals(aux)) {
				System.out.println("Titulo: " + task);
				found = true;
			}
			if (found == false) {
				System.out.println("nao encontrou nada");
			}
		}

	}

	public  void exportarPorDesenvolvedor(Usuario aux) {
		boolean found = false;
		for (Tarefa task : listTarefa) {
			if (task.getUsuario().equals(aux)) {
				System.out.println("Titulo: " + aux);
				found = true;
			}
			if (found == false) {
				System.out.println("nao encontrou nada.");
			}
		}
	}

	public void vincularUsuario(Usuario usuario) {
		if (this.stats == status.pendente && usuario.getStats() == StatusUsuario.ativo) {
			this.usuario = usuario;
			this.stats = status.emAndamento;
		}

	}

	public void desvincularUsuario(Usuario usuario) {
		if (stats == status.emAndamento) {
			stats = status.pendente;
			this.usuario = usuario;

		}

	}

	public void concluirTarefa() {
		if (stats == status.emAndamento) {
			stats = status.concluido;
		}
	}
	public void addCargos(cargo cargo) {
		listCargosResp.add(cargo);
		
	}
	
	
	
	@Override
	public String toString() {
		return "id: " + this.id + "titulo " + this.title + "Descricao " + this.desc 
				+ "prioridade: " + this.prioridade + " status " + this.stats;
	}

}