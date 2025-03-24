package temperatura;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TemperaturaView {
	public static void main(String[] args) {
		TemperaturaController controller = new TemperaturaController();
		controller.init();

		for (Observador observador : controller.getObservadores()) {
			JFrame jFrame = new JFrame("Monitoramento de temperatura - " + observador.toString());
			int loops = observador.toString().equals("Display Condicoes atuais") ? 10 : 1;
			jFrame.setSize(500, 500);

			JPanel jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = java.awt.GridBagConstraints.CENTER;
			gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gbc.insets = new java.awt.Insets(5, 0, 5, 0);

			ArrayList<JLabel> labels = new ArrayList<>();
			for (int i = 0; i < loops; i++) {
				JLabel jLabel = new JLabel(controller.getDados(observador, i));
				labels.add(jLabel);
				gbc.gridy++;
				jPanel.add(jLabel, gbc);
			}

			observador.addUIComponent(() -> {
				SwingUtilities.invokeLater(() -> {
					for (int i = 0; i < loops; i++) {
						labels.get(i).setText(controller.getDados(observador, i));
					}
				});
			});

			JButton registrar = new JButton("Registrar Observador");
			registrar.addActionListener((ActionEvent e) -> controller.registraObservador(observador));

			JButton remover = new JButton("Remover Observador");
			remover.addActionListener((ActionEvent e) -> controller.removeObservador(observador));

			gbc.insets = new java.awt.Insets(15, 0, 5, 0);
			gbc.gridy++;
			jPanel.add(registrar, gbc);
			gbc.insets = new java.awt.Insets(5, 0, 5, 0);
			gbc.gridy++;
			jPanel.add(remover, gbc);

			jFrame.add(jPanel);
			jFrame.setVisible(true);
		}

		controller.coletarDescoletar();
	}
}