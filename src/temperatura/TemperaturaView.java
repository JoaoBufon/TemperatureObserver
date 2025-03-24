package temperatura;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;

public class TemperaturaView {
	public static void main(String[] args) {
		TemperaturaController controller = new TemperaturaController();
		controller.init();

		for (Observador observador : controller.getObservadores()) {
			JFrame jFrame = new JFrame("Monitoramento de temperatura - " + observador.toString());
			int loops = observador.toString().equals("Display Condicoes atuais") ? 10 : 1;
			jFrame.setSize(500, 500);

			JPanel jPanel = new JPanel();
			jPanel.setSize(500, 500);
			jPanel.setLayout(new GridBagLayout());
			java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.anchor = java.awt.GridBagConstraints.CENTER;
			gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
			gbc.insets = new java.awt.Insets(5, 0, 5, 0);

			ArrayList<JLabel> labels = new ArrayList<>();
			for (int i = 0; i < loops; i++) {
				JLabel jLabel = new JLabel();
				jLabel.setText(controller.getDados(observador, i));
				labels.add(jLabel);
				gbc.gridy++;
				jPanel.add(jLabel, gbc);
			}

			JButton registrar = new JButton("Registrar Observador");
			registrar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.registraObservador(observador);
				}
			});

			JButton remover = new JButton("Remover Observador");
			remover.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.removeObservador(observador);
				}
			});

			JButton coletar = new JButton("Coletar Dados");
			coletar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						controller.coletar();
						for (int i = 0; i < loops; i++) {
							labels.get(i).setText(controller.getDados(observador, i));
						}
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			});

			gbc.insets = new java.awt.Insets(15, 0, 5, 0);
			gbc.gridy++;
			jPanel.add(registrar, gbc);
			gbc.insets = new java.awt.Insets(5, 0, 5, 0);
			gbc.gridy++;
			jPanel.add(remover, gbc);
			gbc.gridy++;
			jPanel.add(coletar, gbc);

			jFrame.add(jPanel);
			jFrame.setVisible(true);
		}

	}
}
