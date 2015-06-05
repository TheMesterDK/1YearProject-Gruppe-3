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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.BilLogik;
import logic.FinansieringsaftaleLogik;
import logic.KundeLogik;
import logic.SælgerLogik;
import domain.Bil;
import domain.Finansieringsaftale;
import domain.Kunde;
import domain.Sælger;




public class EditDialog extends JDialog
{

  private static final long serialVersionUID = 1L;

  private final JPanel contentPanel;
  
  private JPanel editbuttonpanel;
  
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
  
  private JTextField aftaleidField;
  private JTextField lånebeløbField;
  private JTextField udbetalingField;
  private JTextField renteField;
  private JTextField afviklingsperiodeField;
  private JTextField oprettelsesdatoField;
  
  private JButton deleteButton;
  private JButton okButton;
  
  
  
  public EditDialog()
  {
    this.setLocation( 400, 200 );
    
    contentPanel = new JPanel();
    setBackground(Color.BLACK);
    setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
    setBounds( 100, 100, 600, 336 );
    contentPanel.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    contentPanel.setBackground(Color.BLACK);
    setContentPane(contentPanel);
    contentPanel.setLayout(new BorderLayout(0, 0));
    
    JPanel toppanel2 = LogoPanel2();
    contentPanel.add(toppanel2, BorderLayout.EAST);
    
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
    årgangField.setText( bil.getÅrgang() );
    bemærkningField.setText( bil.getBemærkninger() );
    
  }
  
  public EditDialog(Finansieringsaftale aftale)
  {
    this();
    
    JPanel aftalepanel = FinansieringsaftalePanel();
    this.contentPanel.add(aftalepanel, BorderLayout.CENTER);
    
    aftaleidField.setText( "" + aftale.getAftaleid() );
    lånebeløbField.setText( "" + aftale.getBeløb() );
    udbetalingField.setText( "" + aftale.getUdbetaling() );
    renteField.setText( "" + aftale.getRente() );
    afviklingsperiodeField.setText( "" + aftale.getAfviklingsperiode() );
    oprettelsesdatoField.setText( aftale.getOprettelsesdato() );
    sælgeridField.setText( "" + aftale.getSælgerid() );
    chassisnummerField.setText( aftale.getChassisnummer() );
//    kundenavnField.setText(  );
    cpridField.setText( "" + aftale.getCprid() );
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
    
    return logopanel2;
  }
  
  
  public JPanel KundePanel()
  {   
    JPanel kundepanel = new JPanel();
    kundepanel.setForeground(new Color(150, 0, 0));
    kundepanel.setBackground(Color.BLACK);
    GridBagLayout gbl_kundepanel = new GridBagLayout();
    gbl_kundepanel.columnWidths = new int[]{0, 0, 0};
    gbl_kundepanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_kundepanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_kundepanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
    kundepanel.setLayout(gbl_kundepanel);
    this.setSize( 600, 340 );
    
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
    
    
    JPanel panel = EditButtonPanel();
    panel.setBackground(Color.BLACK);
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.insets = new Insets(0, 0, 5, 0);
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 1;
    gbc_panel.gridy = 9;
    kundepanel.add(panel, gbc_panel);

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

    okButton.addActionListener( event -> 
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
    
    return kundepanel;
  }

  
  public JPanel SælgerPanel()
  {
    JPanel sælgerpanel = new JPanel();
    sælgerpanel.setBackground(Color.BLACK);
    GridBagLayout gbl_sælgerpanel = new GridBagLayout();
    gbl_sælgerpanel.columnWidths = new int[]{0, 0, 0};
    gbl_sælgerpanel.rowHeights = new int[]{0, 0, 0, 0};
    gbl_sælgerpanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_sælgerpanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
    sælgerpanel.setLayout(gbl_sælgerpanel);
    this.setSize( 600, 333 );
    
    JLabel lblSælger = new JLabel("Sælger");
    lblSælger.setForeground(new Color(150, 0, 0));
    lblSælger.setFont(new Font("Tahoma", Font.PLAIN, 18));
    GridBagConstraints gbc_lblSælger = new GridBagConstraints();
    gbc_lblSælger.insets = new Insets(0, 0, 5, 0);
    gbc_lblSælger.gridx = 1;
    gbc_lblSælger.gridy = 0;
    sælgerpanel.add(lblSælger, gbc_lblSælger);
    
    JLabel lblSælgerid = new JLabel("Sælger-ID:");
    lblSælgerid.setForeground(new Color(150, 0, 0));
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
    lblSælgernavn.setForeground(new Color(150, 0, 0));
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
    
    
    JPanel panel = EditButtonPanel();
    panel.setBackground(Color.BLACK);
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.insets = new Insets(0, 0, 5, 0);
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 1;
    gbc_panel.gridy = 3;
    sælgerpanel.add(panel, gbc_panel);
    
    deleteButton.addActionListener( event -> 
    {
      SælgerLogik sl = new  SælgerLogik();
      try
      {
        sl.deleteSælger( Integer.parseInt( sælgeridField.getText() ) );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
    });

    okButton.addActionListener( event -> 
    {
      Sælger sælger = new Sælger();
      SælgerLogik sl = new SælgerLogik();
      sælger.setSælgerid( Integer.parseInt( sælgeridField.getText() ) );
      sælger.setSælgernavn( sælgernavnField.getText() );
      try
      {
        sl.updateSælger( sælger );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
    });
    
    
    return sælgerpanel;
  }
  
  
  private JPanel BilPanel()
  {
    JPanel bilpanel = new JPanel();
    bilpanel.setForeground(Color.RED);
    bilpanel.setBackground(Color.BLACK);
    this.setSize( 600, 333 );
    
    GridBagLayout gbl_bilpanel = new GridBagLayout();
    gbl_bilpanel.columnWidths = new int[]{0, 0, 0};
    gbl_bilpanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    gbl_bilpanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_bilpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    bilpanel.setLayout(gbl_bilpanel);
    
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
    
    
    JPanel panel = EditButtonPanel();
    panel.setBackground(Color.BLACK);
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.insets = new Insets(0, 0, 5, 0);
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 1;
    gbc_panel.gridy = 7;
    bilpanel.add(panel, gbc_panel);

    deleteButton.addActionListener( event -> 
    {
      BilLogik bl = new  BilLogik();
      try
      {
        bl.deleteBil( chassisnummerField.getText() );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
    });

    okButton.addActionListener( event -> 
    {
      Bil bil = new Bil();
      BilLogik bl = new BilLogik();
      bil.setChassisnummer( chassisnummerField.getText() );
      bil.setRegistreringsnummer( regnummerField.getText() );
      bil.setPris( Double.parseDouble( prisField.getText() ) );
      bil.setModel( modelField.getText() );
      bil.setÅrgang( årgangField.getText() );
      bil.setBemærkninger( bemærkningField.getText() );
      try
      {
        bl.updateBil( bil );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
    });
    
    return bilpanel;
  }
  
  
  public JPanel FinansieringsaftalePanel()
  {
    JPanel aftalepanel = new JPanel();
    aftalepanel.setForeground(Color.RED);
    aftalepanel.setBackground(Color.BLACK);
    GridBagLayout gbl_aftalepanel = new GridBagLayout();
    gbl_aftalepanel.columnWidths = new int[]{0, 0, 0};
    gbl_aftalepanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_aftalepanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_aftalepanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    aftalepanel.setLayout(gbl_aftalepanel);
    this.setSize( 600, 400 );
    
    JLabel lblFinansieringsaftale = new JLabel("Finansieringsaftale");
    lblFinansieringsaftale.setForeground(new Color(150, 0, 0));
    lblFinansieringsaftale.setFont(new Font("Tahoma", Font.PLAIN, 18));
    GridBagConstraints gbc_lblFinansieringsaftale = new GridBagConstraints();
    gbc_lblFinansieringsaftale.insets = new Insets(0, 0, 5, 0);
    gbc_lblFinansieringsaftale.gridx = 1;
    gbc_lblFinansieringsaftale.gridy = 0;
    aftalepanel.add(lblFinansieringsaftale, gbc_lblFinansieringsaftale);
    
    JLabel lblAftaleid = new JLabel("Aftale-ID:");
    lblAftaleid.setForeground(new Color(150, 0, 0));
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
    lblLnebelb.setForeground(new Color(150, 0, 0));
    GridBagConstraints gbc_lblLnebelb = new GridBagConstraints();
    gbc_lblLnebelb.anchor = GridBagConstraints.EAST;
    gbc_lblLnebelb.insets = new Insets(0, 0, 5, 5);
    gbc_lblLnebelb.gridx = 0;
    gbc_lblLnebelb.gridy = 2;
    aftalepanel.add(lblLnebelb, gbc_lblLnebelb);
    
    lånebeløbField = new JTextField();
    GridBagConstraints gbc_lånebeløbField = new GridBagConstraints();
    gbc_lånebeløbField.insets = new Insets(0, 0, 5, 0);
    gbc_lånebeløbField.fill = GridBagConstraints.HORIZONTAL;
    gbc_lånebeløbField.gridx = 1;
    gbc_lånebeløbField.gridy = 2;
    aftalepanel.add(lånebeløbField, gbc_lånebeløbField);
    lånebeløbField.setColumns(10);
    
    JLabel lblUdbetaling = new JLabel("Udbetaling:");
    lblUdbetaling.setForeground(new Color(150, 0, 0));
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
    lblRente.setForeground(new Color(150, 0, 0));
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
    lblAfviklingsperiode.setForeground(new Color(150, 0, 0));
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
    lblOprettelsesdato.setForeground(new Color(150, 0, 0));
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
    lblSlger.setForeground(new Color(150, 0, 0));
    GridBagConstraints gbc_lblSlger = new GridBagConstraints();
    gbc_lblSlger.anchor = GridBagConstraints.EAST;
    gbc_lblSlger.insets = new Insets(0, 0, 5, 5);
    gbc_lblSlger.gridx = 0;
    gbc_lblSlger.gridy = 7;
    aftalepanel.add(lblSlger, gbc_lblSlger);
    
    sælgeridField = new JTextField();
    GridBagConstraints gbc_sælgerField = new GridBagConstraints();
    gbc_sælgerField.insets = new Insets(0, 0, 5, 0);
    gbc_sælgerField.fill = GridBagConstraints.HORIZONTAL;
    gbc_sælgerField.gridx = 1;
    gbc_sælgerField.gridy = 7;
    aftalepanel.add(sælgeridField, gbc_sælgerField);
    sælgeridField.setColumns(10);
    
    JLabel lblBilmodel = new JLabel("Bilmodel:");
    lblBilmodel.setForeground(new Color(150, 0, 0));
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
    lblBilChassisnummer.setForeground(new Color(150, 0, 0));
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
    lblKundeNavn.setForeground(new Color(150, 0, 0));
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
    lblKundeCprid.setForeground(new Color(150, 0, 0));
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
    
    
    JPanel panel = EditButtonPanel();
    panel.setBackground(Color.BLACK);
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.insets = new Insets(0, 0, 5, 0);
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 1;
    gbc_panel.gridy = 9;
    aftalepanel.add(panel, gbc_panel);

    deleteButton.addActionListener( event -> 
    {
      FinansieringsaftaleLogik fal = new  FinansieringsaftaleLogik();
      try
      {
        fal.deleteFinansieringsaftale( Integer.parseInt( aftaleidField.getText() ) );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
    });

    okButton.addActionListener( event -> 
    {
      Finansieringsaftale aftale = new Finansieringsaftale();
      FinansieringsaftaleLogik fal = new FinansieringsaftaleLogik();
      aftale.setAftaleid( Integer.parseInt( aftaleidField.getText() ) );
      aftale.setBeløb( Double.parseDouble( prisField.getText() ) );
      aftale.setUdbetaling( Double.parseDouble( udbetalingField.getText() ) );
      aftale.setRente( Double.parseDouble( renteField.getText() ) );
      aftale.setAfviklingsperiode( Integer.parseInt( afviklingsperiodeField.getText() ) );
      aftale.setOprettelsesdato( oprettelsesdatoField.getText() );
      aftale.setSælgerid( Integer.parseInt( sælgeridField.getText() ) );
      aftale.setChassisnummer( chassisnummerField.getText() );
      aftale.setCprid( Integer.parseInt( cpridField.getText() ) );
      try
      {
        fal.updateFinansieringsaftale( aftale );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
    });
    
    
    return aftalepanel;
  }
  
  
  private JPanel EditButtonPanel()
  {
    editbuttonpanel = new JPanel();
    
    editbuttonpanel.setBackground(Color.BLACK);
    editbuttonpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    
    deleteButton = new JButton("Slet");
    editbuttonpanel.add( deleteButton );
    
    JButton button_1 = new JButton("Cancel");
    editbuttonpanel.add(button_1);
    button_1.addActionListener( event -> this.dispose() );
    
    okButton = new JButton("OK");
    editbuttonpanel.add(okButton);
      
    return editbuttonpanel;
  }
  
  
  
}
