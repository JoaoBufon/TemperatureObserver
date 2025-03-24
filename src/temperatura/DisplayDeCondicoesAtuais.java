package temperatura;

import java.util.LinkedList;

public class DisplayDeCondicoesAtuais implements Observador{

	private LinkedList<DadosVO> ultimos10Dados = new LinkedList<>();
	
	@Override
	public void atualizar(double temperatura, double humidade, double pressao) { 
		if(this.getUltimos10Dados() != null && !this.getUltimos10Dados().isEmpty() && this.getUltimos10Dados().size() >= 10) {
			this.getUltimos10Dados().removeFirst();
		}
		this.ultimos10Dados.add(new DadosVO(temperatura, humidade, pressao));
	}
	
	public LinkedList<DadosVO> getUltimos10Dados() {
		return ultimos10Dados;
	}

	public void setUltimos10Dados(LinkedList<DadosVO> ultimos10Dados) {
		this.ultimos10Dados = ultimos10Dados;
	}
	
	@Override
	public String toString() {
		return "Display Condicoes atuais";
	}

	@Override
	public String getDados(int i) {
		return this.getUltimos10Dados().get(i).toString();
	}
}
