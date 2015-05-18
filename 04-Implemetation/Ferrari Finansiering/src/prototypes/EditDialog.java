package prototypes;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import logic.*;
import domain.*;




public class EditDialog extends JDialog
{

  private static final long serialVersionUID = 1L;

  private final JPanel contentPanel;
  
  private JTextField chassisnummerField;
  private JTextField regnummerField;
  private JTextField prisField;
  private JTextField modelField;
  private JTextField �rgangField;
  private JTextField bem�rkningField;
  
  private JTextField cpridField;
  private JTextField navnField;
  private JTextField adresseField;
  private JTextField telefonField;
  private JTextField postnrField;
  private JTextField emailField;
  private JTextField kommentarField;
  
  private JTextField s�lgeridField;
  private JTextField s�lgernavnField;
  
  private JTextField aftaleidField;
  private JTextField l�nebel�bField;
  private JTextField udbetalingField;
  private JTextField renteField;
  private JTextField afviklingsperiodeField;
  private JTextField oprettelsesdatoField;
  
  private JButton deleteButton;
  private JButton editButton;
  
  
  
  public EditDialog()
  {
    this.setLocation( 400, 200 );
    this.setSize( 450, 200 );
    
    contentPanel = new JPanel();
    setBackground(Color.BLACK);
    setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
    setBounds( 100, 100, 600, 336 );
    contentPanel.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    contentPanel.setBackground(Color.BLACK);
    setContentPane(contentPanel);
    contentPanel.setLayout(new BorderLayout(0, 0));
    
    
//    JPanel toppanel = LogoPanel();
//    contentPanel.add(toppanel, BorderLayout.NORTH);
    
    JPanel toppanel2 = LogoPanel2();
    contentPanel.add(toppanel2, BorderLayout.EAST);
    
//    JPanel bilpanel = BilPanel();
//    contentPanel.add(bilpanel, BorderLayout.CENTER);
    
//    JPanel kundepanel = KundePanel();
//    contentPanel.add(kundepanel, BorderLayout.CENTER);
//    this.getContentPane().add( contentPanel, BorderLayout.CENTER );
    this.setVisible( true );
  }
  
  public EditDialog(Kunde kunde)
  {
    this();
    
    JPanel kundepanel = KundePanel();
    this.contentPanel.add(kundepanel, BorderLayout.CENTER);
    
    cpridField.setText( "" + kunde.getCprid() );
    navnField.setText( kunde.getNavn() );
    adresseField.setText( kunde.getAdresse() );
    telefonField.setText( kunde.getTelefonnummer() );
    postnrField.setText( kunde.getPostnummer() );
    emailField.setText( kunde.getEmail() );
    kommentarField.setText( kunde.getKommentar() );
    
  }
  
  public EditDialog(Bil bil)
  {
    this();
    
    JPanel bilpanel = BilPanel();
    this.contentPanel.add(bilpanel, BorderLayout.CENTER);
    
    chassisnummerField.setText( bil.getChassisnummer() );
    regnummerField.setText( bil.getRegistreringsnummer() );
    prisField.setText( "" + bil.getPris() );
    modelField.setText( bil.getModel() );
    �rgangField.setText( bil.get�rgang() );
    bem�rkningField.setText( bil.getBem�rkninger() );
    
  }
  
  public EditDialog(Finansieringsaftale aftale)
  {
    this();
    
    JPanel aftalepanel = FinansieringsaftalePanel();
    this.contentPanel.add(aftalepanel, BorderLayout.CENTER);
    
    aftaleidField.setText( "" + aftale.getAftaleid() );
    l�nebel�bField.setText( "" + aftale.getBel�b() );
    udbetalingField.setText( "" + aftale.getUdbetaling() );
    renteField.setText( "" + aftale.getRente() );
    afviklingsperiodeField.setText( "" + aftale.getAfviklingsperiode() );
    oprettelsesdatoField.setText( aftale.getOprettelsesdato() );
    s�lgeridField.setText( "" + aftale.getS�lgerid() );
    chassisnummerField.setText( aftale.getChassisnummer() );
//    kundenavnField.setText(  );
    cpridField.setText( "" + aftale.getCprid() );
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
  
  
  private JPanel LogoPanel2()
  {
    JPanel logopanel2 = new JPanel();
    
    FlowLayout flowLayout = (FlowLayout) logopanel2.getLayout();
    flowLayout.setAlignment( FlowLayout.LEFT );
    logopanel2.setBackground( Color.BLACK );
    JLabel label2 = new JLabel( new ImageIcon( "C:\\Users\\Dennis\\Documents\\GitHub\\1YearProject-Gruppe-3\\04-Implemetation\\Ferrari Finansiering\\Capture.png" ) );
    label2.setLabelFor( label2 );
    label2.setSize( new Dimension( 300, 100 ) );
    label2.setBackground( new Color( 200, 50, 50 ) );
    label2.setIconTextGap( 0 );
    label2.setMinimumSize( new Dimension(50, 300) );
    label2.setMaximumSize( new Dimension( 1000, 500 ) );
    logopanel2.add( label2 );
    
    // JLabel lblNewLabel = new JLabel("New label");
    // contentPane.add(lblNewLabel, BorderLayout.EAST);
    
    return logopanel2;
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
    
    JLabel lblrgang = new JLabel("�rgang:");
    GridBagConstraints gbc_lblrgang = new GridBagConstraints();
    gbc_lblrgang.anchor = GridBagConstraints.EAST;
    gbc_lblrgang.insets = new Insets(0, 0, 5, 5);
    gbc_lblrgang.gridx = 0;
    gbc_lblrgang.gridy = 5;
    bilpanel.add(lblrgang, gbc_lblrgang);
    
    �rgangField = new JTextField();
    GridBagConstraints gbc_�rgangField = new GridBagConstraints();
    gbc_�rgangField.insets = new Insets(0, 0, 5, 0);
    gbc_�rgangField.fill = GridBagConstraints.HORIZONTAL;
    gbc_�rgangField.gridx = 1;
    gbc_�rgangField.gridy = 5;
    bilpanel.add(�rgangField, gbc_�rgangField);
    �rgangField.setColumns(10);
    
    JLabel lblBemrkninger = new JLabel("Bem�rkninger:");
    GridBagConstraints gbc_lblBemrkninger = new GridBagConstraints();
    gbc_lblBemrkninger.anchor = GridBagConstraints.EAST;
    gbc_lblBemrkninger.insets = new Insets(0, 0, 0, 5);
    gbc_lblBemrkninger.gridx = 0;
    gbc_lblBemrkninger.gridy = 6;
    bilpanel.add(lblBemrkninger, gbc_lblBemrkninger);
    
    bem�rkningField = new JTextField();
    GridBagConstraints gbc_bem�rkningField = new GridBagConstraints();
    gbc_bem�rkningField.fill = GridBagConstraints.HORIZONTAL;
    gbc_bem�rkningField.gridx = 1;
    gbc_bem�rkningField.gridy = 6;
    bilpanel.add(bem�rkningField, gbc_bem�rkningField);
    bem�rkningField.setColumns(10);

    return bilpanel;
  }
  
  
  public JPanel KundePanel()
  {   
    JPanel kundepanel = new JPanel();
    kundepanel.setForeground(new Color(153, 0, 0));
    kundepanel.setBackground(Color.BLACK);
    GridBagLayout gbl_kundepanel = new GridBagLayout();
    gbl_kundepanel.columnWidths = new int[]{0, 0, 0};
    gbl_kundepanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_kundepanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_kundepanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
    kundepanel.setLayout(gbl_kundepanel);
    
    JLabel lblKunde = new JLabel("Kunde:");
    lblKunde.setForeground(Color.RED);
    lblKunde.setFont(new Font("Tahoma", Font.PLAIN, 18));
    GridBagConstraints gbc_lblKunde = new GridBagConstraints();
    gbc_lblKunde.insets = new Insets(0, 0, 5, 0);
    gbc_lblKunde.gridx = 1;
    gbc_lblKunde.gridy = 0;
    kundepanel.add(lblKunde, gbc_lblKunde);
    
    JLabel label_6 = new JLabel("Cpr-ID:");
    label_6.setForeground(new Color(153, 0, 0));
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
    label_5.setForeground(new Color(153, 0, 0));
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
    label_4.setForeground(new Color(153, 0, 0));
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
    label_3.setForeground(new Color(153, 0, 0));
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
    label_2.setForeground(new Color(153, 0, 0));
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
    label_1.setForeground(new Color(153, 0, 0));
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
    label.setForeground(new Color(153, 0, 0));
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
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.BLACK);
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.insets = new Insets(0, 0, 5, 0);
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 1;
    gbc_panel.gridy = 9;
    kundepanel.add(panel, gbc_panel);
    panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    
    JButton button_1 = new JButton("Cancel");
    panel.add(button_1);
    button_1.addActionListener( event -> this.dispose() );
    
    JButton button = new JButton("OK");
    panel.add(button);
    button.addActionListener( event -> 
    {
      Kunde kunde = new Kunde();
      KundeLogik kl = new KundeLogik();
      kunde.setCprid( Integer.parseInt( cpridField.getText() ) );
      kunde.setNavn( navnField.getText() );
      kunde.setAdresse( adresseField.getText() );
      kunde.setPostnummer( postnrField.getText() );
      kunde.setTelefonnummer( telefonField.getText() );
      kunde.setEmail( emailField.getText() );
      kunde.setKommentar( kommentarField.getText() );
      try
      {
        kl.updateKunde( kunde );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
    });

    deleteButton = new JButton("Slet kunde");
    deleteButton.setVisible( false );
    panel.add( deleteButton );
    deleteButton.addActionListener( event -> 
    {
      KundeLogik kl = new  KundeLogik();
      try
      {
        kl.deleteKunde( Integer.parseInt( cpridField.getText() ) );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
    });

    return kundepanel;
  }
  
  
  public JPanel S�lgerPanel()
  {
    JPanel s�lgerpanel = new JPanel();
    s�lgerpanel.setBackground(Color.RED);
    GridBagLayout gbl_s�lgerpanel = new GridBagLayout();
    gbl_s�lgerpanel.columnWidths = new int[]{0, 0, 0};
    gbl_s�lgerpanel.rowHeights = new int[]{0, 0, 0, 0};
    gbl_s�lgerpanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_s�lgerpanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
    s�lgerpanel.setLayout(gbl_s�lgerpanel);
    
    JLabel lblS�lger = new JLabel("S�lger");
    lblS�lger.setFont(new Font("Tahoma", Font.PLAIN, 18));
    GridBagConstraints gbc_lblS�lger = new GridBagConstraints();
    gbc_lblS�lger.insets = new Insets(0, 0, 5, 0);
    gbc_lblS�lger.gridx = 1;
    gbc_lblS�lger.gridy = 0;
    s�lgerpanel.add(lblS�lger, gbc_lblS�lger);
    
    JLabel lblS�lgerid = new JLabel("S�lger-ID:");
    GridBagConstraints gbc_lblS�lgerid = new GridBagConstraints();
    gbc_lblS�lgerid.anchor = GridBagConstraints.EAST;
    gbc_lblS�lgerid.insets = new Insets(0, 0, 5, 5);
    gbc_lblS�lgerid.gridx = 0;
    gbc_lblS�lgerid.gridy = 1;
    s�lgerpanel.add(lblS�lgerid, gbc_lblS�lgerid);
    
    s�lgeridField = new JTextField();
    GridBagConstraints gbc_s�lgeridField = new GridBagConstraints();
    gbc_s�lgeridField.insets = new Insets(0, 0, 5, 0);
    gbc_s�lgeridField.fill = GridBagConstraints.HORIZONTAL;
    gbc_s�lgeridField.gridx = 1;
    gbc_s�lgeridField.gridy = 1;
    s�lgerpanel.add(s�lgeridField, gbc_s�lgeridField);
    s�lgeridField.setColumns(10);
    
    JLabel lblS�lgernavn = new JLabel("S�lger-Navn:");
    GridBagConstraints gbc_lblS�lgernavn = new GridBagConstraints();
    gbc_lblS�lgernavn.anchor = GridBagConstraints.EAST;
    gbc_lblS�lgernavn.insets = new Insets(0, 0, 0, 5);
    gbc_lblS�lgernavn.gridx = 0;
    gbc_lblS�lgernavn.gridy = 2;
    s�lgerpanel.add(lblS�lgernavn, gbc_lblS�lgernavn);
    
    s�lgernavnField = new JTextField();
    GridBagConstraints gbc_s�lgernavnField = new GridBagConstraints();
    gbc_s�lgernavnField.fill = GridBagConstraints.HORIZONTAL;
    gbc_s�lgernavnField.gridx = 1;
    gbc_s�lgernavnField.gridy = 2;
    s�lgerpanel.add(s�lgernavnField, gbc_s�lgernavnField);
    s�lgernavnField.setColumns(10);

    return s�lgerpanel;
  }
  
  
  public JPanel FinansieringsaftalePanel()
  {
    JPanel aftalepanel = new JPanel();
    aftalepanel.setBackground(Color.RED);
    GridBagLayout gbl_aftalepanel = new GridBagLayout();
    gbl_aftalepanel.columnWidths = new int[]{0, 0, 0};
    gbl_aftalepanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_aftalepanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_aftalepanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    aftalepanel.setLayout(gbl_aftalepanel);
    
    JLabel lblFinansieringsaftale = new JLabel("Finansieringsaftale");
    lblFinansieringsaftale.setFont(new Font("Tahoma", Font.PLAIN, 18));
    GridBagConstraints gbc_lblFinansieringsaftale = new GridBagConstraints();
    gbc_lblFinansieringsaftale.insets = new Insets(0, 0, 5, 0);
    gbc_lblFinansieringsaftale.gridx = 1;
    gbc_lblFinansieringsaftale.gridy = 0;
    aftalepanel.add(lblFinansieringsaftale, gbc_lblFinansieringsaftale);
    
    JLabel lblAftaleid = new JLabel("Aftale-ID:");
    GridBagConstraints gbc_lblAftaleid = new GridBagConstraints();
    gbc_lblAftaleid.anchor = GridBagConstraints.EAST;
    gbc_lblAftaleid.insets = new Insets(0, 0, 5, 5);
    gbc_lblAftaleid.gridx = 0;
    gbc_lblAftaleid.gridy = 1;
    aftalepanel.add(lblAftaleid, gbc_lblAftaleid);
    
    aftaleidField = new JTextField();
    GridBagConstraints gbc_aftaleidField = new GridBagConstraints();
    gbc_aftaleidField.insets = new Insets(0, 0, 5, 0);
    gbc_aftaleidField.fill = GridBagConstraints.HORIZONTAL;
    gbc_aftaleidField.gridx = 1;
    gbc_aftaleidField.gridy = 1;
    aftalepanel.add(aftaleidField, gbc_aftaleidField);
    aftaleidField.setColumns(10);
    
    JLabel lblLnebelb = new JLabel("L\u00E5nebel\u00F8b:");
    GridBagConstraints gbc_lblLnebelb = new GridBagConstraints();
    gbc_lblLnebelb.anchor = GridBagConstraints.EAST;
    gbc_lblLnebelb.insets = new Insets(0, 0, 5, 5);
    gbc_lblLnebelb.gridx = 0;
    gbc_lblLnebelb.gridy = 2;
    aftalepanel.add(lblLnebelb, gbc_lblLnebelb);
    
    l�nebel�bField = new JTextField();
    GridBagConstraints gbc_l�nebel�bField = new GridBagConstraints();
    gbc_l�nebel�bField.insets = new Insets(0, 0, 5, 0);
    gbc_l�nebel�bField.fill = GridBagConstraints.HORIZONTAL;
    gbc_l�nebel�bField.gridx = 1;
    gbc_l�nebel�bField.gridy = 2;
    aftalepanel.add(l�nebel�bField, gbc_l�nebel�bField);
    l�nebel�bField.setColumns(10);
    
    JLabel lblUdbetaling = new JLabel("Udbetaling:");
    GridBagConstraints gbc_lblUdbetaling = new GridBagConstraints();
    gbc_lblUdbetaling.anchor = GridBagConstraints.EAST;
    gbc_lblUdbetaling.insets = new Insets(0, 0, 5, 5);
    gbc_lblUdbetaling.gridx = 0;
    gbc_lblUdbetaling.gridy = 3;
    aftalepanel.add(lblUdbetaling, gbc_lblUdbetaling);
    
    udbetalingField = new JTextField();
    GridBagConstraints gbc_udbetalingField = new GridBagConstraints();
    gbc_udbetalingField.insets = new Insets(0, 0, 5, 0);
    gbc_udbetalingField.fill = GridBagConstraints.HORIZONTAL;
    gbc_udbetalingField.gridx = 1;
    gbc_udbetalingField.gridy = 3;
    aftalepanel.add(udbetalingField, gbc_udbetalingField);
    udbetalingField.setColumns(10);
    
    JLabel lblRente = new JLabel("Rente:");
    GridBagConstraints gbc_lblRente = new GridBagConstraints();
    gbc_lblRente.anchor = GridBagConstraints.EAST;
    gbc_lblRente.insets = new Insets(0, 0, 5, 5);
    gbc_lblRente.gridx = 0;
    gbc_lblRente.gridy = 4;
    aftalepanel.add(lblRente, gbc_lblRente);
    
    renteField = new JTextField();
    GridBagConstraints gbc_renteField = new GridBagConstraints();
    gbc_renteField.insets = new Insets(0, 0, 5, 0);
    gbc_renteField.fill = GridBagConstraints.HORIZONTAL;
    gbc_renteField.gridx = 1;
    gbc_renteField.gridy = 4;
    aftalepanel.add(renteField, gbc_renteField);
    renteField.setColumns(10);
    
    JLabel lblAfviklingsperiode = new JLabel("Afviklingsperiode:");
    GridBagConstraints gbc_lblAfviklingsperiode = new GridBagConstraints();
    gbc_lblAfviklingsperiode.anchor = GridBagConstraints.EAST;
    gbc_lblAfviklingsperiode.insets = new Insets(0, 0, 5, 5);
    gbc_lblAfviklingsperiode.gridx = 0;
    gbc_lblAfviklingsperiode.gridy = 5;
    aftalepanel.add(lblAfviklingsperiode, gbc_lblAfviklingsperiode);
    
    afviklingsperiodeField = new JTextField();
    GridBagConstraints gbc_afviklingsperiodeField = new GridBagConstraints();
    gbc_afviklingsperiodeField.insets = new Insets(0, 0, 5, 0);
    gbc_afviklingsperiodeField.fill = GridBagConstraints.HORIZONTAL;
    gbc_afviklingsperiodeField.gridx = 1;
    gbc_afviklingsperiodeField.gridy = 5;
    aftalepanel.add(afviklingsperiodeField, gbc_afviklingsperiodeField);
    afviklingsperiodeField.setColumns(10);
    
    JLabel lblOprettelsesdato = new JLabel("Oprettelsesdato:");
    GridBagConstraints gbc_lblOprettelsesdato = new GridBagConstraints();
    gbc_lblOprettelsesdato.anchor = GridBagConstraints.EAST;
    gbc_lblOprettelsesdato.insets = new Insets(0, 0, 5, 5);
    gbc_lblOprettelsesdato.gridx = 0;
    gbc_lblOprettelsesdato.gridy = 6;
    aftalepanel.add(lblOprettelsesdato, gbc_lblOprettelsesdato);
    
    oprettelsesdatoField = new JTextField();
    GridBagConstraints gbc_oprettelsesdatoField = new GridBagConstraints();
    gbc_oprettelsesdatoField.insets = new Insets(0, 0, 5, 0);
    gbc_oprettelsesdatoField.fill = GridBagConstraints.HORIZONTAL;
    gbc_oprettelsesdatoField.gridx = 1;
    gbc_oprettelsesdatoField.gridy = 6;
    aftalepanel.add(oprettelsesdatoField, gbc_oprettelsesdatoField);
    oprettelsesdatoField.setColumns(10);
    
    JLabel lblSlger = new JLabel("S\u00E6lger:");
    GridBagConstraints gbc_lblSlger = new GridBagConstraints();
    gbc_lblSlger.anchor = GridBagConstraints.EAST;
    gbc_lblSlger.insets = new Insets(0, 0, 5, 5);
    gbc_lblSlger.gridx = 0;
    gbc_lblSlger.gridy = 7;
    aftalepanel.add(lblSlger, gbc_lblSlger);
    
    s�lgeridField = new JTextField();
    GridBagConstraints gbc_s�lgerField = new GridBagConstraints();
    gbc_s�lgerField.insets = new Insets(0, 0, 5, 0);
    gbc_s�lgerField.fill = GridBagConstraints.HORIZONTAL;
    gbc_s�lgerField.gridx = 1;
    gbc_s�lgerField.gridy = 7;
    aftalepanel.add(s�lgeridField, gbc_s�lgerField);
    s�lgeridField.setColumns(10);
    
    JLabel lblBilmodel = new JLabel("Bilmodel:");
    GridBagConstraints gbc_lblBilmodel = new GridBagConstraints();
    gbc_lblBilmodel.anchor = GridBagConstraints.EAST;
    gbc_lblBilmodel.insets = new Insets(0, 0, 5, 5);
    gbc_lblBilmodel.gridx = 0;
    gbc_lblBilmodel.gridy = 8;
    aftalepanel.add(lblBilmodel, gbc_lblBilmodel);
    
    modelField = new JTextField();
    GridBagConstraints gbc_bilmodelField = new GridBagConstraints();
    gbc_bilmodelField.insets = new Insets(0, 0, 5, 0);
    gbc_bilmodelField.fill = GridBagConstraints.HORIZONTAL;
    gbc_bilmodelField.gridx = 1;
    gbc_bilmodelField.gridy = 8;
    aftalepanel.add(modelField, gbc_bilmodelField);
    modelField.setColumns(10);
    
    JLabel lblBilChassisnummer = new JLabel("Bil Chassisnummer:");
    GridBagConstraints gbc_lblBilChassisnummer = new GridBagConstraints();
    gbc_lblBilChassisnummer.anchor = GridBagConstraints.EAST;
    gbc_lblBilChassisnummer.insets = new Insets(0, 0, 5, 5);
    gbc_lblBilChassisnummer.gridx = 0;
    gbc_lblBilChassisnummer.gridy = 9;
    aftalepanel.add(lblBilChassisnummer, gbc_lblBilChassisnummer);
    
    chassisnummerField = new JTextField();
    chassisnummerField.setColumns(10);
    GridBagConstraints gbc_bilchassisnummerField = new GridBagConstraints();
    gbc_bilchassisnummerField.insets = new Insets(0, 0, 5, 0);
    gbc_bilchassisnummerField.fill = GridBagConstraints.HORIZONTAL;
    gbc_bilchassisnummerField.gridx = 1;
    gbc_bilchassisnummerField.gridy = 9;
    aftalepanel.add(chassisnummerField, gbc_bilchassisnummerField);
    
    JLabel lblKundeNavn = new JLabel("Kunde Navn:");
    GridBagConstraints gbc_lblKundeNavn = new GridBagConstraints();
    gbc_lblKundeNavn.anchor = GridBagConstraints.EAST;
    gbc_lblKundeNavn.insets = new Insets(0, 0, 5, 5);
    gbc_lblKundeNavn.gridx = 0;
    gbc_lblKundeNavn.gridy = 10;
    aftalepanel.add(lblKundeNavn, gbc_lblKundeNavn);
    
    navnField = new JTextField();
    GridBagConstraints gbc_kundenavnField = new GridBagConstraints();
    gbc_kundenavnField.insets = new Insets(0, 0, 5, 0);
    gbc_kundenavnField.fill = GridBagConstraints.HORIZONTAL;
    gbc_kundenavnField.gridx = 1;
    gbc_kundenavnField.gridy = 10;
    aftalepanel.add(navnField, gbc_kundenavnField);
    navnField.setColumns(10);
    
    JLabel lblKundeCprid = new JLabel("Kunde Cpr-ID:");
    GridBagConstraints gbc_lblKundeCprid = new GridBagConstraints();
    gbc_lblKundeCprid.anchor = GridBagConstraints.EAST;
    gbc_lblKundeCprid.insets = new Insets(0, 0, 0, 5);
    gbc_lblKundeCprid.gridx = 0;
    gbc_lblKundeCprid.gridy = 11;
    aftalepanel.add(lblKundeCprid, gbc_lblKundeCprid);
    
    cpridField = new JTextField();
    GridBagConstraints gbc_kundecpridField = new GridBagConstraints();
    gbc_kundecpridField.fill = GridBagConstraints.HORIZONTAL;
    gbc_kundecpridField.gridx = 1;
    gbc_kundecpridField.gridy = 11;
    aftalepanel.add(cpridField, gbc_kundecpridField);
    cpridField.setColumns(10);
    
    
    
    return aftalepanel;
  }
  
  
  
  
//  private JPanel ButtonPanel()
//  {
//  }
  
  
  
}
