package Entities;

import Interfaces.ISubordinado;

import java.util.ArrayList;
import java.util.List;

import Enum.*;
public class Desenvolvedor extends Usuario implements ISubordinado {
	
	
	private Gerente gerenteResp;
	private static List<EspecialidadeDev> listEspecialidade = new ArrayList<>();
	
	
	public Desenvolvedor(String name, String email, StatusUsuario stats, Gerente gerenteResp) {
		super(name, email, stats);
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
	public void addEsp(EspecialidadeDev esp) {
		if(super.getStats() == StatusUsuario.ativo) {
			listEspecialidade.add(esp);
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
	
	public static Gerente chamarGerente(String nomeGerente) {
	    for (Usuario manager : Gerente.listUsuario) {
	        if (manager.getName().equalsIgnoreCase(nomeGerente)) {
	            return (Gerente) manager;
	        }
	    }
	    return null;
	}
	}
