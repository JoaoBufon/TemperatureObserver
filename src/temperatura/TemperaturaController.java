package temperatura;

import java.util.ArrayList;

public class TemperaturaController {
	private EquipamentoDeMonitoramento equipamentoDeMonitoramento = new EquipamentoDeMonitoramento();
	private MonitorDeDadosDoClima monitorDeDados = new MonitorDeDadosDoClima(equipamentoDeMonitoramento);
	private ArrayList<Observador> observadores = new ArrayList<>();
	private TemperaturaModel model = new TemperaturaModel();
	
	public void init() {
		this.equipamentoDeMonitoramento.setMonitorDadosClima(monitorDeDados);
		this.observadores.add(new DisplayDeCondicoesAtuais());
		this.observadores.add(new DisplayEstatistico());
	}
	
	public void coletar() throws InterruptedException{
		this.equipamentoDeMonitoramento.coletar();
	}
	
	public void registraObservador(Observador o) {
		this.monitorDeDados.registraObservador(o);
	}
	
	public void removeObservador(Observador o) {
		this.monitorDeDados.removeObservador(o);
	}
	
	public String getDados(Observador observador,int i) {
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
	
}
