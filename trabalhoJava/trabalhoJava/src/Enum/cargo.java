package Enum;

public enum cargo {

	desenvolvedor("D"),
	analista("A"),
	gerente("G");
	
	
	private final String cargoAtual;
	
	
	private cargo(String valor) {
		this.cargoAtual = valor;
		
	}
	
}
