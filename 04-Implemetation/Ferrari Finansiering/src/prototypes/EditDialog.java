package prototypes;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;




public class EditDialog extends JDialog
{
  
  private final JPanel contentPanel = new JPanel();
  private JTextField chassisnummerField;
  private JTextField regnummerField;
  private JTextField prisField;
  private JTextField modelField;
  private JTextField årgangField;
  private JTextField bemærkningField;
  private JTextField cpridField;
  private JTextField navnField;
  private JTextField adresseField;
  private JTextField telefonField;
  private JTextField postnrField;
  private JTextField emailField;
  private JTextField kommentarField;
  private JTextField sælgeridField;
  private JTextField sælgernavnField;
  
  
  
  public EditDialog()
  {
    setBackground(Color.RED);
    setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
    setBounds( 100, 100, 450, 400 );
    contentPanel.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    contentPanel.setBackground(Color.RED);
    setContentPane(contentPanel);
    contentPanel.setLayout(new BorderLayout(0, 0));
    
    
    JPanel toppanel = LogoPanel();
    contentPanel.add(toppanel, BorderLayout.NORTH);
    
//    JPanel bilpanel = BilPanel();
//    contentPanel.add(bilpanel, BorderLayout.CENTER);
    
//    JPanel kundepanel = KundePanel();
//    contentPanel.add(kundepanel, BorderLayout.CENTER);
    
    JPanel sælgerpanel = SælgerPanel();
    contentPanel.add(sælgerpanel, BorderLayout.CENTER);

    JPanel buttonpanel = ButtonPanel();
    contentPanel.add(buttonpanel, BorderLayout.SOUTH);
    
  }
  
  
  private JPanel LogoPanel()
  {
    JPanel logopanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) logopanel.getLayout();
    flowLayout.setAlignment(FlowLayout.LEFT);
    logopanel.setBackground(Color.RED);
    JLabel label = new JLabel(new ImageIcon("C:\\Users\\Dennis\\Documents\\GitHub\\1YearProject-Gruppe-3\\04-Implemetation\\Ferrari Finansiering\\Yellow logo on red background.png"));
    label.setLabelFor(label);
    label.setSize(new Dimension(300, 100));
    label.setBackground(new Color(200, 50, 50));
    label.setIconTextGap(0);
    label.setPreferredSize(new Dimension(300, 100));
    label.setMinimumSize(new Dimension(100, 50));
    label.setMaximumSize(new Dimension(1000, 500));
    logopanel.add(label);
    
    return logopanel;
  }
    
  
  private JPanel BilPanel()
  {
    JPanel bilpanel = new JPanel();
    bilpanel.setBackground(Color.RED);
    
    GridBagLayout gbl_bilpanel = new GridBagLayout();
    gbl_bilpanel.columnWidths = new int[]{0, 0, 0};
    gbl_bilpanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    gbl_bilpanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_bilpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    bilpanel.setLayout(gbl_bilpanel);
    
    JLabel lblOverskrift = new JLabel("Bil");
    lblOverskrift.setFont(new Font("Tahoma", Font.PLAIN, 18));
    GridBagConstraints gbc_lblOverskrift = new GridBagConstraints();
    gbc_lblOverskrift.insets = new Insets(0, 0, 5, 0);
    gbc_lblOverskrift.gridx = 1;
    gbc_lblOverskrift.gridy = 0;
    bilpanel.add(lblOverskrift, gbc_lblOverskrift);
    
    JLabel lblChassisnummer = new JLabel("Chassis-nummer:");
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

    return bilpanel;
  }
  
  
  private JPanel KundePanel()
  {
    JPanel kundepanel = new JPanel();
    kundepanel.setBackground(Color.RED);
    GridBagLayout gbl_kundepanel = new GridBagLayout();
    gbl_kundepanel.columnWidths = new int[]{0, 0, 0};
    gbl_kundepanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_kundepanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_kundepanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    kundepanel.setLayout(gbl_kundepanel);
    
    JLabel lblKunde = new JLabel("Kunde:");
    lblKunde.setFont(new Font("Tahoma", Font.PLAIN, 18));
    GridBagConstraints gbc_lblKunde = new GridBagConstraints();
    gbc_lblKunde.insets = new Insets(0, 0, 5, 0);
    gbc_lblKunde.gridx = 1;
    gbc_lblKunde.gridy = 0;
    kundepanel.add(lblKunde, gbc_lblKunde);
    
    JLabel label_6 = new JLabel("Cpr-ID:");
    GridBagConstraints gbc_label_6 = new GridBagConstraints();
    gbc_label_6.anchor = GridBagConstraints.EAST;
    gbc_label_6.insets = new Insets(0, 0, 5, 5);
    gbc_label_6.gridx = 0;
    gbc_label_6.gridy = 1;
    kundepanel.add(label_6, gbc_label_6);
    
    cpridField = new JTextField();
    GridBagConstraints gbc_cpridField = new GridBagConstraints();
    gbc_cpridField.insets = new Insets(0, 0, 5, 0);
    gbc_cpridField.fill = GridBagConstraints.HORIZONTAL;
    gbc_cpridField.gridx = 1;
    gbc_cpridField.gridy = 1;
    kundepanel.add(cpridField, gbc_cpridField);
    cpridField.setColumns(10);
    
    JLabel label_5 = new JLabel("Navn:");
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
    GridBagConstraints gbc_label = new GridBagConstraints();
    gbc_label.anchor = GridBagConstraints.EAST;
    gbc_label.insets = new Insets(0, 0, 0, 5);
    gbc_label.gridx = 0;
    gbc_label.gridy = 7;
    kundepanel.add(label, gbc_label);
    
    kommentarField = new JTextField();
    GridBagConstraints gbc_kommentarField = new GridBagConstraints();
    gbc_kommentarField.fill = GridBagConstraints.HORIZONTAL;
    gbc_kommentarField.gridx = 1;
    gbc_kommentarField.gridy = 7;
    kundepanel.add(kommentarField, gbc_kommentarField);
    kommentarField.setColumns(10);

    return kundepanel;
  }
  
  
  private JPanel SælgerPanel()
  {
    JPanel sælgerpanel = new JPanel();
    sælgerpanel.setBackground(Color.RED);
    GridBagLayout gbl_sælgerpanel = new GridBagLayout();
    gbl_sælgerpanel.columnWidths = new int[]{0, 0, 0};
    gbl_sælgerpanel.rowHeights = new int[]{0, 0, 0, 0};
    gbl_sælgerpanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_sælgerpanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
    sælgerpanel.setLayout(gbl_sælgerpanel);
    
    JLabel lblSælger = new JLabel("Sælger");
    lblSælger.setFont(new Font("Tahoma", Font.PLAIN, 18));
    GridBagConstraints gbc_lblSælger = new GridBagConstraints();
    gbc_lblSælger.insets = new Insets(0, 0, 5, 0);
    gbc_lblSælger.gridx = 1;
    gbc_lblSælger.gridy = 0;
    sælgerpanel.add(lblSælger, gbc_lblSælger);
    
    JLabel lblSælgerid = new JLabel("Sælger-ID:");
    GridBagConstraints gbc_lblSælgerid = new GridBagConstraints();
    gbc_lblSælgerid.anchor = GridBagConstraints.EAST;
    gbc_lblSælgerid.insets = new Insets(0, 0, 5, 5);
    gbc_lblSælgerid.gridx = 0;
    gbc_lblSælgerid.gridy = 1;
    sælgerpanel.add(lblSælgerid, gbc_lblSælgerid);
    
    sælgeridField = new JTextField();
    GridBagConstraints gbc_sælgeridField = new GridBagConstraints();
    gbc_sælgeridField.insets = new Insets(0, 0, 5, 0);
    gbc_sælgeridField.fill = GridBagConstraints.HORIZONTAL;
    gbc_sælgeridField.gridx = 1;
    gbc_sælgeridField.gridy = 1;
    sælgerpanel.add(sælgeridField, gbc_sælgeridField);
    sælgeridField.setColumns(10);
    
    JLabel lblSælgernavn = new JLabel("Sælger-Navn:");
    GridBagConstraints gbc_lblSælgernavn = new GridBagConstraints();
    gbc_lblSælgernavn.anchor = GridBagConstraints.EAST;
    gbc_lblSælgernavn.insets = new Insets(0, 0, 0, 5);
    gbc_lblSælgernavn.gridx = 0;
    gbc_lblSælgernavn.gridy = 2;
    sælgerpanel.add(lblSælgernavn, gbc_lblSælgernavn);
    
    sælgernavnField = new JTextField();
    GridBagConstraints gbc_sælgernavnField = new GridBagConstraints();
    gbc_sælgernavnField.fill = GridBagConstraints.HORIZONTAL;
    gbc_sælgernavnField.gridx = 1;
    gbc_sælgernavnField.gridy = 2;
    sælgerpanel.add(sælgernavnField, gbc_sælgernavnField);
    sælgernavnField.setColumns(10);

    return sælgerpanel;
  }
  
  
  
  
  
  
  
  
  
  
  
  private JPanel ButtonPanel()
  {
    JPanel buttonpanel = new JPanel();
    buttonpanel.setBackground(Color.RED);
    buttonpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    
    JButton button = new JButton("OK");
    button.setActionCommand("OK");
    buttonpanel.add(button);
    
    JButton button_1 = new JButton("Cancel");
    button_1.setActionCommand("Cancel");
    buttonpanel.add(button_1);

    return buttonpanel;
  }
  
  
  
}
