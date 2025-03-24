package temperatura;

import java.util.LinkedList;

public class DisplayEstatistico implements Observador {

	private LinkedList<DadosVO> ultimos10Dados = new LinkedList<DadosVO>();
	private double temperaturaMedia;
	private double humidadeMedia;
	private double temperaturaMax;
	private double temperaturaMin;

	@Override
	public void atualizar(double temperatura, double humidade, double pressao) {
		if (this.getUltimos10Dados() != null && !this.getUltimos10Dados().isEmpty()
				&& this.getUltimos10Dados().size() >= 10) {
			this.getUltimos10Dados().removeFirst();
		}
		this.ultimos10Dados.add(new DadosVO(temperatura, humidade, pressao));

		this.temperaturaMedia = Math.round(this.ultimos10Dados.stream().mapToDouble(DadosVO::getTemperatura).average().orElse(0.0)* 100.0) / 100.0;

		this.humidadeMedia = Math.round(this.ultimos10Dados.stream().mapToDouble(DadosVO::getHumidade).average().orElse(0.0)* 100.0) / 100.0;

		this.temperaturaMax = Math.round(this.getUltimos10Dados().stream().map(DadosVO::getTemperatura).max(Double::compare)
				.orElse(0.0)* 100.0) / 100.0;

		this.temperaturaMin = Math.round(this.getUltimos10Dados().stream().map(DadosVO::getTemperatura).min(Double::compare)
				.orElse(0.0)* 100.0) / 100.0;
	}

	public LinkedList<DadosVO> getUltimos10Dados() {
		return ultimos10Dados;
	}

	public void setUltimos10Dados(LinkedList<DadosVO> ultimos10Dados) {
		this.ultimos10Dados = ultimos10Dados;
	}

	public double getTemperaturaMedia() {
		return temperaturaMedia;
	}

	public void setTemperaturaMedia(double temperaturaMedia) {
		this.temperaturaMedia = temperaturaMedia;
	}

	public double getHumidadeMedia() {
		return humidadeMedia;
	}

	public void setHumidadeMedia(double humidadeMedia) {
		this.humidadeMedia = humidadeMedia;
	}

	public double getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	public double getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(double temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}

	@Override
	public String toString() {
		return "Display Estatístico";
	}

	@Override
	public String getDados(int i) {
		return "Temperatura Média: " + this.temperaturaMedia + ", Humidade Média: " + this.humidadeMedia
				+ ", Temperatura Máx: " + this.temperaturaMax + ", Temperatura Mín: " + this.temperaturaMin;
	}
}
