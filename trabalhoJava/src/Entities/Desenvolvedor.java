package Entities;

import Interfaces.ISubordinado;
import Enum.*;
public class Desenvolvedor extends Usuario implements ISubordinado {
	
	
	private EspecialidadeDev espDev;
	private Gerente gerenteResp;

	
	
	public Desenvolvedor(String name, String email, StatusUsuario stats, EspecialidadeDev espDev, Gerente gerenteResp) {
		super(name, email, stats);
		this.espDev = espDev;
		this.gerenteResp = gerenteResp;
		super.setStats(StatusUsuario.ativo);
	}
	public void setName(String name) {
		if(super.getStats() == StatusUsuario.ativo) {
			super.setName(name);
		}
	}
	public void setEmail(String email) {
		if(super.getStats() == StatusUsuario.ativo) {
			super.setEmail(email);
		}
	}

	public void visualizarTarefa() {
		for(Tarefa task:Tarefa.listTarefa) {
			if(task.getUsuario() == this) {
				System.out.println("Title : " +task.getTitle());
			}
		}
	}

	
	public void vincularGerente(Gerente gerente){
		this.gerenteResp = gerente;
	}
	public Gerente getGerenteResp() {
		return gerenteResp;
	}
	public cargo getCargo() {
		return cargo.desenvolvedor;
	}
	
	
	public void visualizarTarefas() {
		for(Tarefa task:Tarefa.listTarefa) {
			if(task.getUsuario() == this) {
				System.out.println("Title : " +task.getTitle());
			}
		}
	}
	
	
}
