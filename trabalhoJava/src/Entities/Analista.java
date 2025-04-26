package Entities;

import Enum.*;

public class Analista extends Usuario {
	

	private EspecialidadeAnalista espAnalista;
	private Gerente gerenteResp;

	public Analista(String name, String email, StatusUsuario stats, EspecialidadeAnalista espAnalista,
			Gerente gerenteResp) {
		super(name, email, stats);
		this.espAnalista = espAnalista;
		this.gerenteResp = gerenteResp;
	}

	public Analista(String name, String email, StatusUsuario stats) {
		super(name, email, stats);
		this.setStats(stats.ativo);

	}

	public EspecialidadeAnalista getEspAnalista() {
		return espAnalista;
	}

	public void setEspAnalista(EspecialidadeAnalista espAnalista) {
		if (super.getStats() == StatusUsuario.ativo) {
			this.espAnalista = espAnalista;
		}
	}

	public Gerente getGerenteResp() {
		return gerenteResp;
	}

	public void setGerenteResp(Gerente gerenteResp) {
		if (super.getStats() == StatusUsuario.ativo) {
			this.gerenteResp = gerenteResp;
		}
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



	public void visualizarTarefas() {
		for (Tarefa task : Tarefa.listTarefa) {
			if (task.getUsuario() == this) {
				System.out.println("Titulo da Tarefa" + task.getTitle());

			}
		}
	}
	
	public void vincularGerente(Gerente gerente) {
		this.gerenteResp = gerente;
	}
	
	public cargo getCargo() {
		return cargo.analista;
	}
	
	
	
}

