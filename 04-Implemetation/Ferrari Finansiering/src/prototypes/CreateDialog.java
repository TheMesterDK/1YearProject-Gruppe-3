package prototypes;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import logic.KundeLogik;
import logic.L�neberegningsLogik;
import domain.Kunde;

public class CreateDialog extends JDialog
{
  
  private final JPanel contentPanel = new JPanel();
  
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
  private JTextField �rgangField;
  private JTextField bem�rkningField;
  
  private JButton NyKundeButton;
  private JButton backButton;
  private JButton forwardButton;
  
  
  private Kunde kunde = null;
  
  private String kreditv�rdighed;

  public CreateDialog()
  {
    setLocation( 400, 200 );
    setBackground(Color.BLACK);
    setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
    setBounds( 100, 100, 600, 340 );
    contentPanel.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    contentPanel.setBackground(Color.BLACK);
    setContentPane(contentPanel);
    contentPanel.setLayout(new BorderLayout(0, 0));
    
    JPanel logopanel = LogoPanel();
    contentPanel.add(logopanel, BorderLayout.EAST);
    
//    JPanel cprpanel = CprPanel();
//    contentPanel.add(cprpanel, BorderLayout.CENTER);
    
    JPanel l�nepanel = L�nebetingelserPanel();
    contentPanel.add(l�nepanel, BorderLayout.CENTER);
    
    
    this.setVisible( true );
  }
  
  
  
  private JPanel LogoPanel()
  {
    JPanel logopanel = new JPanel();
    
    FlowLayout flowLayout = (FlowLayout) logopanel.getLayout();
    flowLayout.setAlignment( FlowLayout.LEFT );
    logopanel.setBackground( Color.BLACK );
    JLabel label2 = new JLabel( new ImageIcon( "C:\\Users\\Dennis\\Documents\\GitHub\\1YearProject-Gruppe-3\\04-Implemetation\\Ferrari Finansiering\\Capture.png" ) );
    label2.setLabelFor( label2 );
    label2.setSize( new Dimension( 300, 100 ) );
    label2.setBackground( new Color( 200, 50, 50 ) );
    label2.setIconTextGap( 0 );
    label2.setMinimumSize( new Dimension(50, 300) );
    label2.setMaximumSize( new Dimension( 1000, 500 ) );
    logopanel.add( label2 );
    
    return logopanel;
  }
  
  
  /*
   * Mangler actionListeners, og m�ske lidt layout
   */
  public JPanel CprPanel()
  {
    JPanel cprpanel = new JPanel();
    cprpanel.setForeground(new Color(150, 0, 0));
    cprpanel.setBackground(Color.BLACK);
    GridBagLayout gbl_cprpanel = new GridBagLayout();
    gbl_cprpanel.columnWidths = new int[]{0, 0, 0, 0};
    gbl_cprpanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_cprpanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
    gbl_cprpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    cprpanel.setLayout(gbl_cprpanel);
 
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
      
      JButton button = new JButton("Hent Kreditv�rdighed");
      GridBagConstraints gbc_button = new GridBagConstraints();
      gbc_button.anchor = GridBagConstraints.WEST;
      gbc_button.insets = new Insets(0, 0, 5, 0);
      gbc_button.gridx = 2;
      gbc_button.gridy = 3;
      
// Nedenst�ende actionlistener fungerer ikke korrekt(Kreditv�rdigheden hentes ikke)!     
      button.addActionListener( event -> 
      {
        kunde = new Kunde();
        kunde.setCprnummer( cprnummerField.getText() );
        L�neberegningsLogik lblogic = new L�neberegningsLogik();
        kreditv�rdighed = lblogic.getKreditV�rdighed( kunde.getCprnummer() );
        returnField.setText(kreditv�rdighed);
//        if(kreditv�rdighed == "A" || kreditv�rdighed == "B" || kreditv�rdighed == "C" || kreditv�rdighed == "D")
//        {
          NyKundeButton.setEnabled( true );
//        }
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
      
      JLabel label_1 = new JLabel("Kundens kreditv�rdighed er:");
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
      NyKundeButton.addActionListener( event -> 
      {
        
        contentPanel.remove( cprpanel );
        contentPanel.add( KundePanel(), BorderLayout.CENTER );
        contentPanel.repaint();
        
      });
      NyKundeButton.setEnabled( false );
      cprpanel.add(NyKundeButton, gbc_btnNewButton);

      
    return cprpanel;
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

    
    JPanel buttonpanel = ButtonPanel();
    GridBagConstraints gbc_newpanel = new GridBagConstraints();
    gbc_newpanel.insets = new Insets(0, 0, 5, 0);
    gbc_newpanel.fill = GridBagConstraints.BOTH;
    gbc_newpanel.gridx = 1;
    gbc_newpanel.gridy = 9;
    kundepanel.add(buttonpanel, gbc_newpanel);
    
    backButton.addActionListener( event ->
    {
      contentPanel.remove( kundepanel );
      contentPanel.add(CprPanel(), BorderLayout.CENTER );
      cprnummerField.setText( kunde.getCprnummer() );
      contentPanel.repaint();
      
    });
    
    forwardButton.addActionListener( event ->
    {
      kunde.setNavn( navnField.getText() );
      kunde.setAdresse( adresseField.getText() );
      kunde.setPostnummer( postnrField.getText() );
      kunde.setTelefonnummer( telefonField.getText() );
      kunde.setEmail( emailField.getText() );
      kunde.setKommentar( kommentarField.getText() );
      
      KundeLogik kl = new KundeLogik();
      try
      {
        kl.createKunde( kunde );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      contentPanel.remove( kundepanel );
      contentPanel.add( L�nebetingelserPanel(), BorderLayout.CENTER );
      contentPanel.repaint();
      
    });

    return kundepanel;
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
    
    JLabel lblrgang = new JLabel("�rgang:");
    lblrgang.setForeground(Color.RED);
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
    lblBemrkninger.setForeground(Color.RED);
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
  
  
  /*
   * Er langt fra f�rdig!
   */
  private JPanel L�nebetingelserPanel()
  {
    JPanel lbpanel = new JPanel();
    lbpanel.setBackground(Color.BLACK);
    GridBagLayout gbl_lbpanel = new GridBagLayout();
    gbl_lbpanel.columnWidths = new int[]{0, 0, 0};
    gbl_lbpanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_lbpanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_lbpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    lbpanel.setLayout(gbl_lbpanel);

      JLabel lblIndtastLnebetingelser = new JLabel("Indtast l�nebetingelser");
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

      JTextField kundeField = new JTextField();
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

      JTextField renteField = new JTextField();
      renteField.setMinimumSize(new Dimension(100, 20));
      renteField.setEditable(false);
      GridBagConstraints gbc_textField_3 = new GridBagConstraints();
      gbc_textField_3.anchor = GridBagConstraints.WEST;
      gbc_textField_3.insets = new Insets(0, 0, 5, 0);
      gbc_textField_3.gridx = 1;
      gbc_textField_3.gridy = 3;
      lbpanel.add(renteField, gbc_textField_3);
      renteField.setColumns(10);

      JLabel bel�blabel = new JLabel("Bel�b:");
      bel�blabel.setForeground(new Color(150, 0, 0));
      GridBagConstraints gbc_bel�blabel = new GridBagConstraints();
      gbc_bel�blabel.anchor = GridBagConstraints.EAST;
      gbc_bel�blabel.insets = new Insets(0, 0, 5, 5);
      gbc_bel�blabel.gridx = 0;
      gbc_bel�blabel.gridy = 4;
      lbpanel.add(bel�blabel, gbc_bel�blabel);

      JTextField bel�bField = new JTextField();
      bel�bField.setMinimumSize(new Dimension(100, 20));
      bel�bField.setEditable(false);
      GridBagConstraints gbc_textField_4 = new GridBagConstraints();
      gbc_textField_4.anchor = GridBagConstraints.WEST;
      gbc_textField_4.insets = new Insets(0, 0, 5, 0);
      gbc_textField_4.gridx = 1;
      gbc_textField_4.gridy = 4;
      lbpanel.add(bel�bField, gbc_textField_4);
      bel�bField.setColumns(10);

      JLabel udbetalinglabel = new JLabel("Udbetaling:");
      udbetalinglabel.setForeground(new Color(150, 0, 0));
      GridBagConstraints gbc_udbetalinglabel = new GridBagConstraints();
      gbc_udbetalinglabel.anchor = GridBagConstraints.EAST;
      gbc_udbetalinglabel.insets = new Insets(0, 0, 5, 5);
      gbc_udbetalinglabel.gridx = 0;
      gbc_udbetalinglabel.gridy = 5;
      lbpanel.add(udbetalinglabel, gbc_udbetalinglabel);

      JTextField udbetalingField = new JTextField();
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
      
      GridBagConstraints gbc_comboBox = new GridBagConstraints();
      gbc_comboBox.anchor = GridBagConstraints.WEST;
      gbc_comboBox.insets = new Insets(0, 0, 5, 0);
      gbc_comboBox.gridx = 1;
      gbc_comboBox.gridy = 6;
      lbpanel.add(comboBox, gbc_comboBox);

      JLabel f�rsteudbetalinglabel = new JLabel("F�rste Afbetaling:");
      f�rsteudbetalinglabel.setForeground(new Color(150, 0, 0));
      GridBagConstraints gbc_f�rsteudbetalinglabel = new GridBagConstraints();
      gbc_f�rsteudbetalinglabel.anchor = GridBagConstraints.EAST;
      gbc_f�rsteudbetalinglabel.insets = new Insets(0, 0, 5, 5);
      gbc_f�rsteudbetalinglabel.gridx = 0;
      gbc_f�rsteudbetalinglabel.gridy = 7;
      lbpanel.add(f�rsteudbetalinglabel, gbc_f�rsteudbetalinglabel);

      JTextField f�rsteudbetalingField = new JTextField();
      f�rsteudbetalingField.setMinimumSize(new Dimension(100, 20));
      GridBagConstraints gbc_textField_7 = new GridBagConstraints();
      gbc_textField_7.anchor = GridBagConstraints.WEST;
      gbc_textField_7.insets = new Insets(0, 0, 5, 0);
      gbc_textField_7.gridx = 1;
      gbc_textField_7.gridy = 7;
      lbpanel.add(f�rsteudbetalingField, gbc_textField_7);
      f�rsteudbetalingField.setColumns(10);

      JLabel chassisnummerlabel = new JLabel("Chassis-Nummer:");
      chassisnummerlabel.setForeground(new Color(150, 0, 0));
      GridBagConstraints gbc_chassisnummerlabel = new GridBagConstraints();
      gbc_chassisnummerlabel.anchor = GridBagConstraints.EAST;
      gbc_chassisnummerlabel.insets = new Insets(0, 0, 5, 5);
      gbc_chassisnummerlabel.gridx = 0;
      gbc_chassisnummerlabel.gridy = 8;
      lbpanel.add(chassisnummerlabel, gbc_chassisnummerlabel);

      JTextField chassisnummerField = new JTextField();
      chassisnummerField.setMinimumSize(new Dimension(100, 20));
      chassisnummerField.setEditable(false);
      GridBagConstraints gbc_textField_8 = new GridBagConstraints();
      gbc_textField_8.anchor = GridBagConstraints.WEST;
      gbc_textField_8.insets = new Insets(0, 0, 5, 0);
      gbc_textField_8.gridx = 1;
      gbc_textField_8.gridy = 8;
      lbpanel.add(chassisnummerField, gbc_textField_8);
      chassisnummerField.setColumns(10);

      JLabel s�lgerlabel = new JLabel("S�lger:");
      s�lgerlabel.setForeground(new Color(150, 0, 0));
      GridBagConstraints gbc_s�lgerlabel = new GridBagConstraints();
      gbc_s�lgerlabel.anchor = GridBagConstraints.EAST;
      gbc_s�lgerlabel.insets = new Insets(0, 0, 5, 5);
      gbc_s�lgerlabel.gridx = 0;
      gbc_s�lgerlabel.gridy = 9;
      lbpanel.add(s�lgerlabel, gbc_s�lgerlabel);

      JTextField s�lgerField = new JTextField();
      s�lgerField.setMinimumSize(new Dimension(100, 20));
      GridBagConstraints gbc_textField_9 = new GridBagConstraints();
      gbc_textField_9.anchor = GridBagConstraints.WEST;
      gbc_textField_9.insets = new Insets(0, 0, 5, 0);
      gbc_textField_9.gridx = 1;
      gbc_textField_9.gridy = 9;
      lbpanel.add(s�lgerField, gbc_textField_9);
      s�lgerField.setColumns(10);

      JLabel datolabel = new JLabel("Dato:");
      datolabel.setForeground(new Color(150, 0, 0));
      GridBagConstraints gbc_datolabel = new GridBagConstraints();
      gbc_datolabel.anchor = GridBagConstraints.EAST;
      gbc_datolabel.insets = new Insets(0, 0, 0, 5);
      gbc_datolabel.gridx = 0;
      gbc_datolabel.gridy = 10;
      lbpanel.add(datolabel, gbc_datolabel);

      JTextField datoField = new JTextField();
      datoField.setMinimumSize(new Dimension(50, 20));
      datoField.setPreferredSize(new Dimension(50, 20));
      GridBagConstraints gbc_textField_10 = new GridBagConstraints();
      gbc_textField_10.anchor = GridBagConstraints.WEST;
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
      

    return lbpanel;
  }
  
  
  private JPanel ButtonPanel()
  {
    JPanel buttonpanel = new JPanel();
    buttonpanel.setBackground(Color.BLACK);
    buttonpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    
    backButton = new JButton("Tilbage");
    buttonpanel.add(backButton);
    
    forwardButton = new JButton("Indtast l�nebetingelser");
    buttonpanel.add( forwardButton );
    
    return buttonpanel;
  }
  
  
  
}
