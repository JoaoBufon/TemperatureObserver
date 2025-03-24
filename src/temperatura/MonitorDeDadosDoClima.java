package temperatura;

import java.util.ArrayList;

public class MonitorDeDadosDoClima implements SujeitoObservavel {

	private ArrayList<Observador> observadores;

	private double temperatura;
	private double humidade;
	private double pressao;

	private EquipamentoDeMonitoramento equipamento;

	public MonitorDeDadosDoClima(EquipamentoDeMonitoramento equipamento) {
		observadores = new ArrayList<Observador>();

		this.equipamento = equipamento;
	}

	@Override
	public void registraObservador(Observador o) {
		observadores.add(o);
	}

	@Override
	public void removeObservador(Observador o) {
		int i = observadores.indexOf(o);

		observadores.remove(i);
	}

	@Override
	public void notificaObservadores() {
		for (Observador item : this.observadores) {
			item.atualizar(this.temperatura, this.humidade, this.pressao);
		}
	}

	@Override
	public void dadosMudaram() {
		this.temperatura = equipamento.getTemperaturaAtual();
		this.humidade = equipamento.getHumidadeAtual();
		this.pressao = equipamento.getPressaoAtual();

		notificaObservadores();

	}

}