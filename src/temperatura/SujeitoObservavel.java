package temperatura;

public interface SujeitoObservavel {
	void dadosMudaram();

	void registraObservador(Observador o);

	void removeObservador(Observador o);

	void notificaObservadores();

}
