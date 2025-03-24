package temperatura;

import java.util.Objects;

public class DadosVO{
	private double temperatura;
	private double humidade;
	private double pressao;
	
	public DadosVO(double temperatura, double humidade, double pressao) {
		super();
		this.temperatura = temperatura;
		this.humidade = humidade;
		this.pressao = pressao;
	}
	
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getHumidade() {
		return humidade;
	}
	public void setHumidade(double humidade) {
		this.humidade = humidade;
	}
	public double getPressao() {
		return pressao;
	}
	public void setPressao(double pressao) {
		this.pressao = pressao;
	}
	
	@Override
	public String toString() {
		return "Temperatura=" + temperatura + ", humidade=" + humidade + ", pressao=" + pressao;
	}
	
	
}
