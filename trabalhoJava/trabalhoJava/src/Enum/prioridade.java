package Enum;

public enum prioridade {
	
	urgente("4"),
	alta("3"),
	media("2"),
	baixa("1");
	
	
	private final String prioridadeAtual;
	
	
	private prioridade(String valor) {
		this.prioridadeAtual = valor;
		
	}
	
	
	
}
