package temperatura;

import java.util.Random;

public class EquipamentoDeMonitoramento {

	private Random gerador = new Random();

	private SujeitoObservavel monitorDadosClima;

	public double temperaturaAtual;
	public double humidadeAtual;
	public double pressaoAtual;

	public void coletar() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			this.temperaturaAtual = this.getNumero(0, 35);
			this.humidadeAtual = this.getNumero(10, 100);
			this.pressaoAtual = this.getNumero(900, 1100);

			monitorDadosClima.dadosMudaram();

			//Thread.sleep(3000);
		}
	}

	private double getNumero(double min, double max) {
	    double randomValue = gerador.nextDouble() * (max - min) + min;
	    return Math.round(randomValue * 100.0) / 100.0;
	}

	public void setMonitorDadosClima(SujeitoObservavel monitorDadosClima) {
		this.monitorDadosClima = monitorDadosClima;
	}

	public double getTemperaturaAtual() {
		return temperaturaAtual;
	}

	public double getHumidadeAtual() {
		return humidadeAtual;
	}

	public double getPressaoAtual() {
		return pressaoAtual;
	}

}