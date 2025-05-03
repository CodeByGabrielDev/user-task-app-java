package Entities;

import java.util.ArrayList;
import java.util.List;

import Enum.*;

public class Notificacao {

	private static int ultimoId;
	private int id;
	private TipoNot tipo;
	private Tarefa task;
	private Usuario usuario;
	private String mensage;
	private StatusNot stats;
	private static List<Notificacao> listNotification = new ArrayList<>();

	public Notificacao() {
		this.id = novoId();
	}

	public Notificacao(TipoNot tipo, Tarefa task, Usuario usuario, String mensage) {
		this.tipo = tipo;
		this.task = task;
		this.usuario = usuario;
		this.mensage = mensage;
		stats = StatusNot.NAOLIDO;
		listNotification.add(this);
		this.id = novoId();
	}

	public int novoId() {
		return ++ultimoId;
	}

	public TipoNot getTipo() {
		return tipo;
	}

	public Tarefa getTask() {
		return task;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getMensage() {
		return mensage;
	}

	public StatusNot getStats() {
		return stats;
	}

	public void marcarComoLida() {
		this.stats = StatusNot.LIDO;
	}

	public void excluir() {
		listNotification.remove(this);
	}

	public void limparNotificacoesDoUsuario(Usuario usuario) {
		for (Notificacao not : listNotification) {
			if (not.getUsuario() == usuario) {

			}
		}
	}
}
