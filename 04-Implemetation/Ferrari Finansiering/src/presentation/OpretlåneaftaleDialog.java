package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.FinansieringsaftaleLogik;
import logic.LåneberegningsLogik;
import domain.Bil;
import domain.Finansieringsaftale;
import domain.Kunde;

public class OpretlåneaftaleDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel;

	private Finansieringsaftale aftale = null;
	private Bil bil = null;
	private Kunde kunde = null;

	private JTextField afviklingsperiodeField;
	private JTextField sælgerField;
	private JTextField datoField;
	private JTextField førsteudbetalingField;
	private JTextField udbetalingField;
	private JTextField beløbField;
	private JTextField renteField;
	private JTextField navnField;
	private JTextField chassisnummerField;
	private JTextField afdragField;

	private JButton backButton;
	private JButton forwardButton;

	public OpretlåneaftaleDialog(Kunde kunde, Bil bil) {
		this.kunde = kunde;
		this.bil = bil;

		contentPanel = new JPanel();
		setLocation(400, 200);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 340);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.BLACK);
		setContentPane(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel logopanel = LogoPanel();
		contentPanel.add(logopanel, BorderLayout.EAST);

		JPanel aftalepanel = LåneaftalePanel();
		contentPanel.add(aftalepanel, BorderLayout.CENTER);

		navnField.setText(kunde.getNavn());
		beløbField.setText("" + bil.getPris());
		chassisnummerField.setText(bil.getChassisnummer());

		this.setVisible(true);
	}

	private JPanel LogoPanel() {
		JPanel logopanel = new JPanel();

		FlowLayout flowLayout = (FlowLayout) logopanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		logopanel.setBackground(Color.BLACK);
		JLabel label2 = new JLabel(
				new ImageIcon(
						"C:\\Users\\Gammel\\Dropbox\\F\u00F8rste\u00C5rsPr\u00F8ven-Gruppe-3\\Unfinished documents by Dennis\\Capture.PNG"));
		label2.setLabelFor(label2);
		label2.setSize(new Dimension(300, 100));
		label2.setBackground(new Color(200, 50, 50));
		label2.setIconTextGap(0);
		label2.setMinimumSize(new Dimension(50, 300));
		label2.setMaximumSize(new Dimension(1000, 500));
		logopanel.add(label2);

		return logopanel;
	}

	/*
	 * Er langt fra færdig!
	 */
	private JPanel LåneaftalePanel() {
		JPanel lbpanel = new JPanel();
		lbpanel.setBackground(Color.BLACK);
		GridBagLayout gbl_lbpanel = new GridBagLayout();
		gbl_lbpanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_lbpanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_lbpanel.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_lbpanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		lbpanel.setLayout(gbl_lbpanel);
		contentPanel.add(lbpanel, BorderLayout.CENTER);

		JLabel lblIndtastLnebetingelser = new JLabel("Indtast lånebetingelser");
		lblIndtastLnebetingelser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIndtastLnebetingelser.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_lblIndtastLnebetingelser = new GridBagConstraints();
		gbc_lblIndtastLnebetingelser.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndtastLnebetingelser.gridx = 1;
		gbc_lblIndtastLnebetingelser.gridy = 0;
		lbpanel.add(lblIndtastLnebetingelser, gbc_lblIndtastLnebetingelser);

		JLabel kundelabel = new JLabel("Kundens Navn:");
		kundelabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_kundelabel = new GridBagConstraints();
		gbc_kundelabel.anchor = GridBagConstraints.EAST;
		gbc_kundelabel.insets = new Insets(0, 0, 5, 5);
		gbc_kundelabel.gridx = 0;
		gbc_kundelabel.gridy = 2;
		lbpanel.add(kundelabel, gbc_kundelabel);

		navnField = new JTextField();
		navnField.setMinimumSize(new Dimension(100, 20));
		navnField.setEditable(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		lbpanel.add(navnField, gbc_textField_2);
		navnField.setColumns(25);

		JLabel rentelabel = new JLabel("Rente:");
		rentelabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_rentelabel = new GridBagConstraints();
		gbc_rentelabel.anchor = GridBagConstraints.EAST;
		gbc_rentelabel.insets = new Insets(0, 0, 5, 5);
		gbc_rentelabel.gridx = 0;
		gbc_rentelabel.gridy = 3;
		lbpanel.add(rentelabel, gbc_rentelabel);

		renteField = new JTextField();
		renteField.setMinimumSize(new Dimension(100, 20));
		renteField.setEditable(false);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		lbpanel.add(renteField, gbc_textField_3);
		renteField.setColumns(10);

		JLabel beløblabel = new JLabel("Beløb:");
		beløblabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_beløblabel = new GridBagConstraints();
		gbc_beløblabel.anchor = GridBagConstraints.EAST;
		gbc_beløblabel.insets = new Insets(0, 0, 5, 5);
		gbc_beløblabel.gridx = 0;
		gbc_beløblabel.gridy = 4;
		lbpanel.add(beløblabel, gbc_beløblabel);

		beløbField = new JTextField();
		beløbField.setMinimumSize(new Dimension(100, 20));
		beløbField.setEditable(false);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		lbpanel.add(beløbField, gbc_textField_4);
		beløbField.setColumns(15);

		JLabel udbetalinglabel = new JLabel("Udbetaling:");
		udbetalinglabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_udbetalinglabel = new GridBagConstraints();
		gbc_udbetalinglabel.anchor = GridBagConstraints.EAST;
		gbc_udbetalinglabel.insets = new Insets(0, 0, 5, 5);
		gbc_udbetalinglabel.gridx = 0;
		gbc_udbetalinglabel.gridy = 5;
		lbpanel.add(udbetalinglabel, gbc_udbetalinglabel);

		udbetalingField = new JTextField();
		udbetalingField.setMinimumSize(new Dimension(100, 20));
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 5;
		lbpanel.add(udbetalingField, gbc_textField_5);
		udbetalingField.setColumns(15);

		afdragField = new JTextField();
		afdragField.setEditable(false);
		GridBagConstraints gbc_afdragField = new GridBagConstraints();
		gbc_afdragField.fill = GridBagConstraints.HORIZONTAL;
		gbc_afdragField.insets = new Insets(0, 0, 5, 0);
		gbc_afdragField.gridx = 2;
		gbc_afdragField.gridy = 5;
		lbpanel.add(afdragField, gbc_afdragField);
		afdragField.setColumns(20);

		JLabel afviklingsperiodelabel = new JLabel("Afviklingsperiode:");
		afviklingsperiodelabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_afviklingsperiodelabel = new GridBagConstraints();
		gbc_afviklingsperiodelabel.anchor = GridBagConstraints.EAST;
		gbc_afviklingsperiodelabel.insets = new Insets(0, 0, 5, 5);
		gbc_afviklingsperiodelabel.gridx = 0;
		gbc_afviklingsperiodelabel.gridy = 6;
		lbpanel.add(afviklingsperiodelabel, gbc_afviklingsperiodelabel);

		afviklingsperiodeField = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 6;
		lbpanel.add(afviklingsperiodeField, gbc_textField_6);
		afviklingsperiodeField.setColumns(10);

		JLabel førsteudbetalinglabel = new JLabel("F\u00F8rste AfdragsDato:");
		førsteudbetalinglabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_førsteudbetalinglabel = new GridBagConstraints();
		gbc_førsteudbetalinglabel.anchor = GridBagConstraints.EAST;
		gbc_førsteudbetalinglabel.insets = new Insets(0, 0, 5, 5);
		gbc_førsteudbetalinglabel.gridx = 0;
		gbc_førsteudbetalinglabel.gridy = 7;
		lbpanel.add(førsteudbetalinglabel, gbc_førsteudbetalinglabel);

		førsteudbetalingField = new JTextField();
		førsteudbetalingField.setMinimumSize(new Dimension(100, 20));
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 7;
		lbpanel.add(førsteudbetalingField, gbc_textField_7);
		førsteudbetalingField.setColumns(15);

		JLabel chassisnummerlabel = new JLabel("Chassis-Nummer:");
		chassisnummerlabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_chassisnummerlabel = new GridBagConstraints();
		gbc_chassisnummerlabel.anchor = GridBagConstraints.EAST;
		gbc_chassisnummerlabel.insets = new Insets(0, 0, 5, 5);
		gbc_chassisnummerlabel.gridx = 0;
		gbc_chassisnummerlabel.gridy = 8;
		lbpanel.add(chassisnummerlabel, gbc_chassisnummerlabel);

		chassisnummerField = new JTextField();
		chassisnummerField.setMinimumSize(new Dimension(100, 20));
		chassisnummerField.setEditable(false);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 8;
		lbpanel.add(chassisnummerField, gbc_textField_8);
		chassisnummerField.setColumns(20);

		JLabel sælgerlabel = new JLabel("Sælger:");
		sælgerlabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_sælgerlabel = new GridBagConstraints();
		gbc_sælgerlabel.anchor = GridBagConstraints.EAST;
		gbc_sælgerlabel.insets = new Insets(0, 0, 5, 5);
		gbc_sælgerlabel.gridx = 0;
		gbc_sælgerlabel.gridy = 9;
		lbpanel.add(sælgerlabel, gbc_sælgerlabel);

		sælgerField = new JTextField();
		sælgerField.setMinimumSize(new Dimension(100, 20));
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 9;
		lbpanel.add(sælgerField, gbc_textField_9);
		sælgerField.setColumns(20);

		JLabel datolabel = new JLabel("Dato:");
		datolabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_datolabel = new GridBagConstraints();
		gbc_datolabel.anchor = GridBagConstraints.EAST;
		gbc_datolabel.insets = new Insets(0, 0, 0, 5);
		gbc_datolabel.gridx = 0;
		gbc_datolabel.gridy = 10;
		lbpanel.add(datolabel, gbc_datolabel);

		datoField = new JTextField();
		datoField.setMinimumSize(new Dimension(50, 20));
		datoField.setPreferredSize(new Dimension(50, 20));
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 0, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 10;
		lbpanel.add(datoField, gbc_textField_10);
		datoField.setColumns(10);

		JPanel buttonpanel = ButtonPanel();
		GridBagConstraints gbc_buttonpanel = new GridBagConstraints();
		gbc_buttonpanel.anchor = GridBagConstraints.WEST;
		gbc_buttonpanel.gridx = 2;
		gbc_buttonpanel.gridy = 10;
		lbpanel.add(buttonpanel, gbc_buttonpanel);

		JButton csvbutton = new JButton("Udskriv CSV-fil");
		csvbutton.setEnabled(false);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.WEST;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 9;
		lbpanel.add(csvbutton, gbc_button_1);
		csvbutton.addActionListener(event -> new CsvDialog(aftale));

		JButton ltbutton = new JButton("Beregn lånetilbud");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 8;
		lbpanel.add(ltbutton, gbc_button);
		ltbutton.addActionListener(event -> {
			LåneberegningsLogik lbl = new LåneberegningsLogik();
			aftale = lbl.beregnTilbud(kunde.getKreditværdighed(), aftale);
			renteField.setText("" + aftale.getRente());
			afdragField.setText("" + aftale.getAfdragsbeløb());
			forwardButton.setEnabled(true);
			csvbutton.setEnabled(true);
		});

		this.setSize(800, 340);
		return lbpanel;
	}

	private JPanel ButtonPanel() {
		JPanel buttonpanel = new JPanel();
		buttonpanel.setBackground(Color.BLACK);
		buttonpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		backButton = new JButton("Tilbage");
		buttonpanel.add(backButton);

		backButton.addActionListener(event -> {
			this.dispose();
			new OpretbilDialog(kunde, bil);

		});

		forwardButton = new JButton("Opret Lånetilbud");
		forwardButton.setEnabled(false);
		buttonpanel.add(forwardButton);

		forwardButton
				.addActionListener(event -> {

					aftale.setBeløb(Double.parseDouble(beløbField.getText()));
					aftale.setUdbetaling(Double.parseDouble(udbetalingField
							.getText()));
					aftale.setRente(Double.parseDouble(renteField.getText()));
					aftale.setAfviklingsperiode(Integer
							.parseInt(afviklingsperiodeField.getText()));
					aftale.setOprettelsesdato(datoField.getText());

					aftale.setSælgerid(Integer.parseInt(sælgerField.getText()));
					aftale.setChassisnummer(bil.getChassisnummer());
					aftale.setCprid(Integer.parseInt(navnField.getText()));

					FinansieringsaftaleLogik fal = new FinansieringsaftaleLogik();
					try {
						fal.createFinansieringsaftale(aftale);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.dispose();
					JOptionPane.showMessageDialog(this,
							"Låneaftalen er oprettet");

				});

		return buttonpanel;
	}

}
