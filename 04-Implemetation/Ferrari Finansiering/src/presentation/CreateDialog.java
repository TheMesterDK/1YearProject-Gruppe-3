package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.BilLogik;
import logic.FinansieringsaftaleLogik;
import logic.KundeLogik;
import logic.LåneberegningsLogik;
import logic.SælgerLogik;
import domain.Bil;
import domain.Finansieringsaftale;
import domain.Kunde;

public class CreateDialog extends JDialog {

	private JPanel contentPanel;
	private JPanel mainpanel;

	private JTextField returnField;

	private JTextField cpridField;
	private JTextField cprnummerField;
	private JTextField navnField;
	private JTextField adresseField;
	private JTextField telefonField;
	private JTextField postnrField;
	private JTextField emailField;
	private JTextField kommentarField;

	private JTextField chassisnummerField;
	private JTextField regnummerField;
	private JTextField prisField;
	private JTextField modelField;
	private JTextField årgangField;
	private JTextField bemærkningField;

	private JTextField sælgerField;
	private JTextField datoField;
	private JTextField førsteudbetalingField;
	private JTextField udbetalingField;
	private JTextField beløbField;
	private JTextField renteField;
	private JTextField kundeField;

	private JButton NyKundeButton;
	private JButton backButton;
	private JButton forwardButton;

	private Kunde kunde = null;
	private Bil bil = null;
	private Finansieringsaftale aftale = null;

	private String kreditværdighed;
	private String buttonString;

	public CreateDialog() {
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
	 * Mangler actionListeners, og måske lidt layout
	 */
	public JPanel CprPanel() {
		JPanel cprpanel = new JPanel();
		cprpanel.setForeground(new Color(150, 0, 0));
		cprpanel.setBackground(Color.BLACK);
		GridBagLayout gbl_cprpanel = new GridBagLayout();
		gbl_cprpanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_cprpanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gbl_cprpanel.columnWeights = new double[] { 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_cprpanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		cprpanel.setLayout(gbl_cprpanel);
		contentPanel.add(cprpanel, BorderLayout.CENTER);
		this.setTitle("Kontroller kreditværdighed");

		JLabel lblIndtastKundensCprnummer = new JLabel("Indtast Cpr-Nummer");
		lblIndtastKundensCprnummer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIndtastKundensCprnummer.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_lblIndtastKundensCprnummer = new GridBagConstraints();
		gbc_lblIndtastKundensCprnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndtastKundensCprnummer.gridx = 1;
		gbc_lblIndtastKundensCprnummer.gridy = 0;
		cprpanel.add(lblIndtastKundensCprnummer, gbc_lblIndtastKundensCprnummer);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVisible(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		cprpanel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		cprpanel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblCprnummer = new JLabel("Cpr-nummer:");
		lblCprnummer.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_lblCprnummer = new GridBagConstraints();
		gbc_lblCprnummer.anchor = GridBagConstraints.EAST;
		gbc_lblCprnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCprnummer.gridx = 0;
		gbc_lblCprnummer.gridy = 3;
		cprpanel.add(lblCprnummer, gbc_lblCprnummer);

		cprnummerField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		cprpanel.add(cprnummerField, gbc_textField);
		cprnummerField.setColumns(10);

		JButton button = new JButton("Hent Kreditværdighed");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 3;

		// Nedenstående actionlistener fungerer ikke korrekt!
		button.addActionListener(event -> {
			LåneberegningsLogik lblogic = new LåneberegningsLogik();
			kreditværdighed = lblogic.getKreditVærdighed(cprnummerField
					.getText());
			returnField.setText(kreditværdighed);
			if (kreditværdighed == "A" || kreditværdighed == "B"
					|| kreditværdighed == "C") {
				NyKundeButton.setEnabled(true);
			}
			cprpanel.repaint();
		});
		cprpanel.add(button, gbc_button);

		JLabel label = new JLabel("(10 cifre. Ingen tegn eller mellemrum)");
		label.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 4;
		cprpanel.add(label, gbc_label);

		JLabel label_1 = new JLabel("Kundens kreditværdighed er:");
		label_1.setForeground(new Color(150, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 7;
		cprpanel.add(label_1, gbc_label_1);

		returnField = new JTextField();
		returnField.setEditable(false);
		returnField.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 7;
		cprpanel.add(returnField, gbc_textField_1);

		NyKundeButton = new JButton("Opret Kunde");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		NyKundeButton.addActionListener(event -> {
			kunde = new Kunde();
			kunde.setCprnummer(cprnummerField.getText());

			contentPanel.remove(cprpanel);
			contentPanel.add(KundePanel(), BorderLayout.CENTER);
			contentPanel.repaint();

		});
		NyKundeButton.setEnabled(false);
		cprpanel.add(NyKundeButton, gbc_btnNewButton);

		return cprpanel;
	}

	private JPanel KundePanel() {
		JPanel kundepanel = new JPanel();
		kundepanel.setForeground(new Color(150, 0, 0));
		kundepanel.setBackground(Color.BLACK);
		GridBagLayout gbl_kundepanel = new GridBagLayout();
		gbl_kundepanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_kundepanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
		gbl_kundepanel.columnWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_kundepanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		kundepanel.setLayout(gbl_kundepanel);
		contentPanel.add(kundepanel, BorderLayout.CENTER);
		this.setTitle("Indtast Kundeoplysninger");

		JLabel lblKunde = new JLabel("Kunde:");
		lblKunde.setForeground(new Color(150, 0, 0));
		lblKunde.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblKunde = new GridBagConstraints();
		gbc_lblKunde.insets = new Insets(0, 0, 5, 0);
		gbc_lblKunde.gridx = 1;
		gbc_lblKunde.gridy = 0;
		kundepanel.add(lblKunde, gbc_lblKunde);

		JLabel label_6 = new JLabel("Cpr-ID:");
		label_6.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 1;
		kundepanel.add(label_6, gbc_label_6);

		cpridField = new JTextField(5);
		cpridField.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_cpridField = new GridBagConstraints();
		gbc_cpridField.insets = new Insets(0, 0, 5, 0);
		gbc_cpridField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cpridField.gridx = 1;
		gbc_cpridField.gridy = 1;
		kundepanel.add(cpridField, gbc_cpridField);
		cpridField.setColumns(5);

		JLabel label_5 = new JLabel("Navn:");
		label_5.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 2;
		kundepanel.add(label_5, gbc_label_5);

		navnField = new JTextField();
		GridBagConstraints gbc_navnField = new GridBagConstraints();
		gbc_navnField.insets = new Insets(0, 0, 5, 0);
		gbc_navnField.fill = GridBagConstraints.HORIZONTAL;
		gbc_navnField.gridx = 1;
		gbc_navnField.gridy = 2;
		kundepanel.add(navnField, gbc_navnField);
		navnField.setColumns(10);

		JLabel label_4 = new JLabel("Adresse:");
		label_4.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 3;
		kundepanel.add(label_4, gbc_label_4);

		adresseField = new JTextField();
		GridBagConstraints gbc_adresseField = new GridBagConstraints();
		gbc_adresseField.insets = new Insets(0, 0, 5, 0);
		gbc_adresseField.fill = GridBagConstraints.HORIZONTAL;
		gbc_adresseField.gridx = 1;
		gbc_adresseField.gridy = 3;
		kundepanel.add(adresseField, gbc_adresseField);
		adresseField.setColumns(10);

		JLabel label_3 = new JLabel("Telefon-nr:");
		label_3.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 4;
		kundepanel.add(label_3, gbc_label_3);

		telefonField = new JTextField();
		GridBagConstraints gbc_telefonField = new GridBagConstraints();
		gbc_telefonField.insets = new Insets(0, 0, 5, 0);
		gbc_telefonField.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefonField.gridx = 1;
		gbc_telefonField.gridy = 4;
		kundepanel.add(telefonField, gbc_telefonField);
		telefonField.setColumns(10);

		JLabel label_2 = new JLabel("Post-nr:");
		label_2.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 5;
		kundepanel.add(label_2, gbc_label_2);

		postnrField = new JTextField();
		GridBagConstraints gbc_postnrField = new GridBagConstraints();
		gbc_postnrField.insets = new Insets(0, 0, 5, 0);
		gbc_postnrField.fill = GridBagConstraints.HORIZONTAL;
		gbc_postnrField.gridx = 1;
		gbc_postnrField.gridy = 5;
		kundepanel.add(postnrField, gbc_postnrField);
		postnrField.setColumns(10);

		JLabel label_1 = new JLabel("Email:");
		label_1.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 6;
		kundepanel.add(label_1, gbc_label_1);

		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 0);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 6;
		kundepanel.add(emailField, gbc_emailField);
		emailField.setColumns(10);

		JLabel label = new JLabel("Kommentar:");
		label.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 7;
		kundepanel.add(label, gbc_label);

		kommentarField = new JTextField();
		GridBagConstraints gbc_kommentarField = new GridBagConstraints();
		gbc_kommentarField.insets = new Insets(0, 0, 5, 0);
		gbc_kommentarField.fill = GridBagConstraints.HORIZONTAL;
		gbc_kommentarField.gridx = 1;
		gbc_kommentarField.gridy = 7;
		kundepanel.add(kommentarField, gbc_kommentarField);
		kommentarField.setColumns(10);

		buttonString = "Indtast Bil";

		JPanel buttonpanel = ButtonPanel();
		GridBagConstraints gbc_newpanel = new GridBagConstraints();
		gbc_newpanel.insets = new Insets(0, 0, 5, 0);
		gbc_newpanel.fill = GridBagConstraints.BOTH;
		gbc_newpanel.gridx = 1;
		gbc_newpanel.gridy = 9;
		kundepanel.add(buttonpanel, gbc_newpanel);

		backButton.addActionListener(event -> {
			contentPanel.remove(kundepanel);
			contentPanel.add(CprPanel(), BorderLayout.CENTER);
			cprnummerField.setText(kunde.getCprnummer());
			contentPanel.repaint();

		});

		forwardButton.addActionListener(event -> {
			kunde.setNavn(navnField.getText());
			kunde.setAdresse(adresseField.getText());
			kunde.setPostnummer(postnrField.getText());
			kunde.setTelefonnummer(telefonField.getText());
			kunde.setEmail(emailField.getText());
			kunde.setKommentar(kommentarField.getText());

			KundeLogik kl = new KundeLogik();
			try {
				kl.createKunde(kunde);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			contentPanel.remove(kundepanel);
			contentPanel.add(BilPanel(), BorderLayout.CENTER);
			contentPanel.repaint();

		});

		this.setSize(600, 333);
		kundepanel.setVisible(true);
		return kundepanel;
	}

	private JPanel BilPanel() {
		JPanel bilpanel = new JPanel();
		bilpanel.setForeground(Color.RED);
		bilpanel.setBackground(Color.BLACK);
		GridBagLayout gbl_bilpanel = new GridBagLayout();
		gbl_bilpanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_bilpanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_bilpanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_bilpanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		bilpanel.setLayout(gbl_bilpanel);
		contentPanel.add(bilpanel, BorderLayout.CENTER);
		this.setTitle("Indtast biloplysninger");

		JLabel lblOverskrift = new JLabel("Bil");
		lblOverskrift.setForeground(Color.RED);
		lblOverskrift.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblOverskrift = new GridBagConstraints();
		gbc_lblOverskrift.insets = new Insets(0, 0, 5, 0);
		gbc_lblOverskrift.gridx = 1;
		gbc_lblOverskrift.gridy = 0;
		bilpanel.add(lblOverskrift, gbc_lblOverskrift);

		JLabel lblChassisnummer = new JLabel("Chassis-nummer:");
		lblChassisnummer.setForeground(Color.RED);
		GridBagConstraints gbc_lblChassisnummer = new GridBagConstraints();
		gbc_lblChassisnummer.anchor = GridBagConstraints.EAST;
		gbc_lblChassisnummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblChassisnummer.gridx = 0;
		gbc_lblChassisnummer.gridy = 1;
		bilpanel.add(lblChassisnummer, gbc_lblChassisnummer);

		chassisnummerField = new JTextField();
		GridBagConstraints gbc_chassisnummerField = new GridBagConstraints();
		gbc_chassisnummerField.insets = new Insets(0, 0, 5, 0);
		gbc_chassisnummerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_chassisnummerField.gridx = 1;
		gbc_chassisnummerField.gridy = 1;
		bilpanel.add(chassisnummerField, gbc_chassisnummerField);
		chassisnummerField.setColumns(10);

		JLabel lblRegNummer = new JLabel("Reg.-nummer:");
		lblRegNummer.setForeground(Color.RED);
		GridBagConstraints gbc_lblRegNummer = new GridBagConstraints();
		gbc_lblRegNummer.anchor = GridBagConstraints.EAST;
		gbc_lblRegNummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegNummer.gridx = 0;
		gbc_lblRegNummer.gridy = 2;
		bilpanel.add(lblRegNummer, gbc_lblRegNummer);

		regnummerField = new JTextField();
		GridBagConstraints gbc_regnummerField = new GridBagConstraints();
		gbc_regnummerField.insets = new Insets(0, 0, 5, 0);
		gbc_regnummerField.fill = GridBagConstraints.HORIZONTAL;
		gbc_regnummerField.gridx = 1;
		gbc_regnummerField.gridy = 2;
		bilpanel.add(regnummerField, gbc_regnummerField);
		regnummerField.setColumns(10);

		JLabel lblPris = new JLabel("Pris:");
		lblPris.setForeground(Color.RED);
		GridBagConstraints gbc_lblPris = new GridBagConstraints();
		gbc_lblPris.anchor = GridBagConstraints.EAST;
		gbc_lblPris.insets = new Insets(0, 0, 5, 5);
		gbc_lblPris.gridx = 0;
		gbc_lblPris.gridy = 3;
		bilpanel.add(lblPris, gbc_lblPris);

		prisField = new JTextField();
		GridBagConstraints gbc_prisField = new GridBagConstraints();
		gbc_prisField.insets = new Insets(0, 0, 5, 0);
		gbc_prisField.fill = GridBagConstraints.HORIZONTAL;
		gbc_prisField.gridx = 1;
		gbc_prisField.gridy = 3;
		bilpanel.add(prisField, gbc_prisField);
		prisField.setColumns(10);

		JLabel lblModel = new JLabel("Model:");
		lblModel.setForeground(Color.RED);
		GridBagConstraints gbc_lblModel = new GridBagConstraints();
		gbc_lblModel.anchor = GridBagConstraints.EAST;
		gbc_lblModel.insets = new Insets(0, 0, 5, 5);
		gbc_lblModel.gridx = 0;
		gbc_lblModel.gridy = 4;
		bilpanel.add(lblModel, gbc_lblModel);

		modelField = new JTextField();
		GridBagConstraints gbc_modelField = new GridBagConstraints();
		gbc_modelField.insets = new Insets(0, 0, 5, 0);
		gbc_modelField.fill = GridBagConstraints.HORIZONTAL;
		gbc_modelField.gridx = 1;
		gbc_modelField.gridy = 4;
		bilpanel.add(modelField, gbc_modelField);
		modelField.setColumns(10);

		JLabel lblrgang = new JLabel("årgang:");
		lblrgang.setForeground(Color.RED);
		GridBagConstraints gbc_lblrgang = new GridBagConstraints();
		gbc_lblrgang.anchor = GridBagConstraints.EAST;
		gbc_lblrgang.insets = new Insets(0, 0, 5, 5);
		gbc_lblrgang.gridx = 0;
		gbc_lblrgang.gridy = 5;
		bilpanel.add(lblrgang, gbc_lblrgang);

		årgangField = new JTextField();
		GridBagConstraints gbc_årgangField = new GridBagConstraints();
		gbc_årgangField.insets = new Insets(0, 0, 5, 0);
		gbc_årgangField.fill = GridBagConstraints.HORIZONTAL;
		gbc_årgangField.gridx = 1;
		gbc_årgangField.gridy = 5;
		bilpanel.add(årgangField, gbc_årgangField);
		årgangField.setColumns(10);

		JLabel lblBemrkninger = new JLabel("Bemærkninger:");
		lblBemrkninger.setForeground(Color.RED);
		GridBagConstraints gbc_lblBemrkninger = new GridBagConstraints();
		gbc_lblBemrkninger.anchor = GridBagConstraints.EAST;
		gbc_lblBemrkninger.insets = new Insets(0, 0, 0, 5);
		gbc_lblBemrkninger.gridx = 0;
		gbc_lblBemrkninger.gridy = 6;
		bilpanel.add(lblBemrkninger, gbc_lblBemrkninger);

		bemærkningField = new JTextField();
		GridBagConstraints gbc_bemærkningField = new GridBagConstraints();
		gbc_bemærkningField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bemærkningField.gridx = 1;
		gbc_bemærkningField.gridy = 6;
		bilpanel.add(bemærkningField, gbc_bemærkningField);
		bemærkningField.setColumns(10);

		buttonString = "Indtast betingelser";

		JPanel buttonpanel = ButtonPanel();
		GridBagConstraints gbc_newpanel = new GridBagConstraints();
		gbc_newpanel.insets = new Insets(0, 0, 5, 0);
		gbc_newpanel.fill = GridBagConstraints.BOTH;
		gbc_newpanel.gridx = 1;
		gbc_newpanel.gridy = 9;
		bilpanel.add(buttonpanel, gbc_newpanel);

		backButton.addActionListener(event -> {
			contentPanel.remove(bilpanel);
			contentPanel.add(KundePanel(), BorderLayout.CENTER);

			cpridField.setText("" + kunde.getCprid());
			navnField.setText(kunde.getNavn());
			adresseField.setText(kunde.getAdresse());
			telefonField.setText(kunde.getTelefonnummer());
			postnrField.setText(kunde.getPostnummer());
			emailField.setText(kunde.getEmail());
			kommentarField.setText(kunde.getKommentar());

			contentPanel.repaint();

		});

		forwardButton.addActionListener(event -> {
			bil.setChassisnummer(chassisnummerField.getText());
			bil.setRegistreringsnummer(regnummerField.getText());
			bil.setPris(Double.parseDouble(prisField.getText()));
			bil.setModel(modelField.getText());
			bil.setÅrgang(årgangField.getText());
			bil.setBemærkninger(bemærkningField.getText());

			BilLogik bl = new BilLogik();
			try {
				bl.createBil(bil);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contentPanel.remove(bilpanel);
			contentPanel.add(LånebetingelserPanel(), BorderLayout.CENTER);
			contentPanel.repaint();
		});

		this.setSize(600, 333);
		bilpanel.setVisible(true);
		return bilpanel;
	}

	/*
	 * Er langt fra færdig!
	 */
	private JPanel LånebetingelserPanel() {
		JPanel lbpanel = new JPanel();
		lbpanel.setBackground(Color.BLACK);
		GridBagLayout gbl_lbpanel = new GridBagLayout();
		gbl_lbpanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_lbpanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_lbpanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_lbpanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		lbpanel.setLayout(gbl_lbpanel);
		contentPanel.add(lbpanel, BorderLayout.CENTER);

		JLabel lblIndtastLnebetingelser = new JLabel("Indtast lånebetingelser");
		lblIndtastLnebetingelser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIndtastLnebetingelser.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_lblIndtastLnebetingelser = new GridBagConstraints();
		gbc_lblIndtastLnebetingelser.insets = new Insets(0, 0, 5, 0);
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

		kundeField = new JTextField();
		kundeField.setMinimumSize(new Dimension(100, 20));
		kundeField.setEditable(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		lbpanel.add(kundeField, gbc_textField_2);
		kundeField.setColumns(10);

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
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
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
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		lbpanel.add(beløbField, gbc_textField_4);
		beløbField.setColumns(10);

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
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 5;
		lbpanel.add(udbetalingField, gbc_textField_5);
		udbetalingField.setColumns(10);

		JLabel afviklingsperiodelabel = new JLabel("Afviklingsperiode:");
		afviklingsperiodelabel.setForeground(new Color(150, 0, 0));
		GridBagConstraints gbc_afviklingsperiodelabel = new GridBagConstraints();
		gbc_afviklingsperiodelabel.anchor = GridBagConstraints.EAST;
		gbc_afviklingsperiodelabel.insets = new Insets(0, 0, 5, 5);
		gbc_afviklingsperiodelabel.gridx = 0;
		gbc_afviklingsperiodelabel.gridy = 6;
		lbpanel.add(afviklingsperiodelabel, gbc_afviklingsperiodelabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "6", "12",
				"18", "24", "30", "36" }));

		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		lbpanel.add(comboBox, gbc_comboBox);

		JLabel førsteudbetalinglabel = new JLabel("Første Afbetaling:");
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
		gbc_textField_7.anchor = GridBagConstraints.WEST;
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 7;
		lbpanel.add(førsteudbetalingField, gbc_textField_7);
		førsteudbetalingField.setColumns(10);

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
		gbc_textField_8.anchor = GridBagConstraints.WEST;
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 8;
		lbpanel.add(chassisnummerField, gbc_textField_8);
		chassisnummerField.setColumns(10);

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
		gbc_textField_9.anchor = GridBagConstraints.WEST;
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 9;
		lbpanel.add(sælgerField, gbc_textField_9);
		sælgerField.setColumns(10);

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
		gbc_textField_10.anchor = GridBagConstraints.WEST;
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 10;
		lbpanel.add(datoField, gbc_textField_10);
		datoField.setColumns(10);

		buttonString = "Opret Lånetilbud";

		JPanel buttonpanel = ButtonPanel();
		GridBagConstraints gbc_buttonpanel = new GridBagConstraints();
		gbc_buttonpanel.anchor = GridBagConstraints.WEST;
		gbc_buttonpanel.gridx = 2;
		gbc_buttonpanel.gridy = 10;
		lbpanel.add(buttonpanel, gbc_buttonpanel);

		backButton.addActionListener(event -> {
			contentPanel.remove(lbpanel);
			contentPanel.add(BilPanel(), BorderLayout.CENTER);

			chassisnummerField.setText(bil.getChassisnummer());
			regnummerField.setText(bil.getRegistreringsnummer());
			prisField.setText("" + bil.getPris());
			modelField.setText(bil.getModel());
			årgangField.setText(bil.getÅrgang());
			bemærkningField.setText(bil.getBemærkninger());

			contentPanel.repaint();

		});

		forwardButton
				.addActionListener(event -> {
					SælgerLogik sl = new SælgerLogik();

					aftale.setBeløb(Double.parseDouble(beløbField.getText()));
					aftale.setUdbetaling(Double.parseDouble(udbetalingField
							.getText()));
					aftale.setRente(Double.parseDouble(renteField.getText()));
					aftale.setAfviklingsperiode(Integer
							.parseInt((String) comboBox.getSelectedItem()));
					aftale.setOprettelsesdato(datoField.getText());
					aftale.setSælgerid(Integer.parseInt(sælgerField.getText()));
					aftale.setChassisnummer(bil.getChassisnummer());
					aftale.setCprid(Integer.parseInt(cpridField.getText()));

					FinansieringsaftaleLogik fal = new FinansieringsaftaleLogik();
					try {
						fal.createFinansieringsaftale(aftale);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(this, "");

				});

		this.setSize(600, 333);
		return lbpanel;
	}

	private JPanel ButtonPanel() {
		JPanel buttonpanel = new JPanel();
		buttonpanel.setBackground(Color.BLACK);
		buttonpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		backButton = new JButton("Tilbage");
		buttonpanel.add(backButton);

		forwardButton = new JButton(buttonString);
		buttonpanel.add(forwardButton);

		return buttonpanel;
	}

}
