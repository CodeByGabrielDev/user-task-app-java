
package Entities;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import Enum.*;

public abstract class Usuario {

	private static int ultimoId;
	private int id;
	private String name;
	private String email;
	private StatusUsuario stats;
	protected static List<Usuario> listUsuario = new ArrayList<>();

	public Usuario() {
		this.id = novoId();
	}

	public Usuario(String name, String email, StatusUsuario stats) {
		this.name = name;
		this.email = email;
		this.stats = StatusUsuario.ativo;
		listUsuario.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(stats == StatusUsuario.ativo) {
			this.name = name;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(stats == StatusUsuario.ativo) {
			this.email = email;
		}
	}

	public StatusUsuario getStats() {
		return stats;
	}

	public void setStats(StatusUsuario stats) {
		this.stats = stats;
	}

	public int getId() {
		return id;
	}

	public int novoId() {
		return this.id = ++ultimoId;
	}
	
	public void inativarUsuario(Usuario usuario) {
		for(Tarefa task:Tarefa.listTarefa) {
			if(task.getStats() == status.emAndamento) {
				
			}
		}
		
	}
	
	
	
	public abstract void visualizarTarefas();
	public abstract Gerente getGerenteResp();
	public abstract cargo getCargo();

}