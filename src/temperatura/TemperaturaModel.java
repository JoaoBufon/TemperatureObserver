package temperatura;

public class TemperaturaModel {
	public String getDados(Observador observador, int i) {
		if (observador.getUltimos10Dados() != null && !observador.getUltimos10Dados().isEmpty() && i+1 <= observador.getUltimos10Dados().size()) {
			return observador.getDados(i);
					//getUltimos10Dados().get(i).toString();
		}
		
		return "***";
	}
	
}
