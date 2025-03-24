package temperatura;

import java.util.LinkedList;

public interface Observador {

	void atualizar(double temperatura, double humidade, double pressao);

	LinkedList<DadosVO> getUltimos10Dados();

	String toString();

	String getDados(int i);

	void addUIComponent(Runnable uiUpdater);
}