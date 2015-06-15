package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.CsvLogik;
import domain.Finansieringsaftale;

public class CsvDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField navnField;
	private JTextField stedField;

	public CsvDialog(Finansieringsaftale aftale) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 163);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.GRAY);
		contentPanel.setBackground(Color.RED);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblFilnavn = new JLabel("Filnavn:");
		lblFilnavn.setForeground(Color.BLACK);
		contentPanel.add(lblFilnavn);

		navnField = new JTextField();
		contentPanel.add(navnField);
		navnField.setColumns(10);

		JLabel lblFyld = new JLabel("Fyld");
		lblFyld.setForeground(Color.RED);
		lblFyld.setVisible(false);
		contentPanel.add(lblFyld);

		JLabel lblPlacering = new JLabel("Placering:");
		lblPlacering.setForeground(Color.BLACK);
		contentPanel.add(lblPlacering);

		stedField = new JTextField();
		contentPanel.add(stedField);
		stedField.setColumns(10);

		JButton btnEksporterLnetilbudTil = new JButton(
				"Eksporter lånetilbud til Csv-fil");
		contentPanel.add(btnEksporterLnetilbudTil);
		btnEksporterLnetilbudTil
				.addActionListener(event -> {
					CsvLogik csvl = new CsvLogik();
					csvl.writeCsvFile(aftale, stedField.getText(),
							navnField.getText());
					this.dispose();
				});

	}

}
