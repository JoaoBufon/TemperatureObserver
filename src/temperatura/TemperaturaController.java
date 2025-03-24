package temperatura;

import java.util.ArrayList;

public class TemperaturaController {
	private EquipamentoDeMonitoramento equipamentoDeMonitoramento = new EquipamentoDeMonitoramento();
	private MonitorDeDadosDoClima monitorDeDados = new MonitorDeDadosDoClima(equipamentoDeMonitoramento);
	private ArrayList<Observador> observadores = new ArrayList<>();
	private TemperaturaModel model = new TemperaturaModel();
	private boolean shouldCollectData = false;

	public void init() {
		this.equipamentoDeMonitoramento.setMonitorDadosClima(monitorDeDados);
		this.observadores.add(new DisplayDeCondicoesAtuais());
		this.observadores.add(new DisplayEstatistico());
	}

	public void coletarDescoletar() {
		if (this.shouldCollectData == true) {
			this.shouldCollectData = false;
		} else {
			this.shouldCollectData = true;
			this.coletar();
		}
		return;
	}

	private void coletar() {
		try {
			while (shouldCollectData) {
				this.equipamentoDeMonitoramento.coletar();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void registraObservador(Observador o) {
		this.monitorDeDados.registraObservador(o);
	}

	public void removeObservador(Observador o) {
		this.monitorDeDados.removeObservador(o);
	}

	public String getDados(Observador observador, int i) {
		return model.getDados(observador, i);
	}

	public ArrayList<Observador> getObservadores() {
		return observadores;
	}

	public void setObservadores(ArrayList<Observador> observadores) {
		this.observadores = observadores;
	}

	public EquipamentoDeMonitoramento getEquipamentoDeMonitoramento() {
		return equipamentoDeMonitoramento;
	}

	public void setEquipamentoDeMonitoramento(EquipamentoDeMonitoramento equipamentoDeMonitoramento) {
		this.equipamentoDeMonitoramento = equipamentoDeMonitoramento;
	}

	public MonitorDeDadosDoClima getMonitorDeDados() {
		return monitorDeDados;
	}

	public void setMonitorDeDados(MonitorDeDadosDoClima monitorDeDados) {
		this.monitorDeDados = monitorDeDados;
	}

	public boolean isShouldCollectData() {
		return shouldCollectData;
	}

	public void setShouldCollectData(boolean shouldCollectData) {
		this.shouldCollectData = shouldCollectData;
	}

}