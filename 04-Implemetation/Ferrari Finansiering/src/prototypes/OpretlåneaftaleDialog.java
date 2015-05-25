package prototypes;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import domain.Bil;
import domain.Finansieringsaftale;
import domain.Kunde;
import logic.FinansieringsaftaleLogik;
import logic.L�neberegningsLogik;

public class Opretl�neaftaleDialog extends JDialog
{

  private static final long serialVersionUID = 1L;

  private final JPanel contentPanel;
  
  private Finansieringsaftale aftale = null;
  private Bil bil = null;
  private Kunde kunde = null;
  
  private JTextField afviklingsperiodeField;
  private JTextField s�lgerField;
  private JTextField datoField;
  private JTextField f�rsteudbetalingField;
  private JTextField udbetalingField;
  private JTextField bel�bField;
  private JTextField renteField;
  private JTextField navnField;
  private JTextField chassisnummerField;
  
  private JButton backButton;
  private JButton forwardButton;
  

  public Opretl�neaftaleDialog(Kunde kunde, Bil bil)
  {
    this.kunde = kunde;
    this.bil = bil;
    
    contentPanel = new JPanel();
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

    JPanel aftalepanel = L�neaftalePanel();
    contentPanel.add( aftalepanel, BorderLayout.CENTER );
    
    navnField.setText( kunde.getNavn() );
    bel�bField.setText( "" + bil.getPris() );
    chassisnummerField.setText( bil.getChassisnummer() );
    
//    L�neberegningsLogik lblogic = new L�neberegningsLogik();
//    double rente = lblogic.getRente();
    
//    renteField.setText(  );
    
    
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
   * Er langt fra f�rdig!
   */
  private JPanel L�neaftalePanel()
  {
    JPanel lbpanel = new JPanel();
    lbpanel.setBackground(Color.BLACK);
    GridBagLayout gbl_lbpanel = new GridBagLayout();
    gbl_lbpanel.columnWidths = new int[]{0, 0, 0};
    gbl_lbpanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_lbpanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_lbpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    lbpanel.setLayout(gbl_lbpanel);
    contentPanel.add( lbpanel, BorderLayout.CENTER );

      JLabel lblIndtastLnebetingelser = new JLabel("Indtast l�nebetingelser");
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
      gbc_textField_2.anchor = GridBagConstraints.WEST;
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
      gbc_textField_3.anchor = GridBagConstraints.WEST;
      gbc_textField_3.insets = new Insets(0, 0, 5, 5);
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

      bel�bField = new JTextField();
      bel�bField.setMinimumSize(new Dimension(100, 20));
      bel�bField.setEditable(false);
      GridBagConstraints gbc_textField_4 = new GridBagConstraints();
      gbc_textField_4.anchor = GridBagConstraints.WEST;
      gbc_textField_4.insets = new Insets(0, 0, 5, 5);
      gbc_textField_4.gridx = 1;
      gbc_textField_4.gridy = 4;
      lbpanel.add(bel�bField, gbc_textField_4);
      bel�bField.setColumns(15);

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
      gbc_textField_5.insets = new Insets(0, 0, 5, 5);
      gbc_textField_5.gridx = 1;
      gbc_textField_5.gridy = 5;
      lbpanel.add(udbetalingField, gbc_textField_5);
      udbetalingField.setColumns(15);

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
      gbc_textField_6.anchor = GridBagConstraints.WEST;
      gbc_textField_6.insets = new Insets(0, 0, 5, 5);
      gbc_textField_6.gridx = 1;
      gbc_textField_6.gridy = 6;
      lbpanel.add(afviklingsperiodeField, gbc_textField_6);
      afviklingsperiodeField.setColumns(10);

      JLabel f�rsteudbetalinglabel = new JLabel("F�rste Afbetaling:");
      f�rsteudbetalinglabel.setForeground(new Color(150, 0, 0));
      GridBagConstraints gbc_f�rsteudbetalinglabel = new GridBagConstraints();
      gbc_f�rsteudbetalinglabel.anchor = GridBagConstraints.EAST;
      gbc_f�rsteudbetalinglabel.insets = new Insets(0, 0, 5, 5);
      gbc_f�rsteudbetalinglabel.gridx = 0;
      gbc_f�rsteudbetalinglabel.gridy = 7;
      lbpanel.add(f�rsteudbetalinglabel, gbc_f�rsteudbetalinglabel);

      f�rsteudbetalingField = new JTextField();
      f�rsteudbetalingField.setMinimumSize(new Dimension(100, 20));
      GridBagConstraints gbc_textField_7 = new GridBagConstraints();
      gbc_textField_7.anchor = GridBagConstraints.WEST;
      gbc_textField_7.insets = new Insets(0, 0, 5, 5);
      gbc_textField_7.gridx = 1;
      gbc_textField_7.gridy = 7;
      lbpanel.add(f�rsteudbetalingField, gbc_textField_7);
      f�rsteudbetalingField.setColumns(15);

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
      gbc_textField_8.insets = new Insets(0, 0, 5, 5);
      gbc_textField_8.gridx = 1;
      gbc_textField_8.gridy = 8;
      lbpanel.add(chassisnummerField, gbc_textField_8);
      chassisnummerField.setColumns(20);

      JLabel s�lgerlabel = new JLabel("S�lger:");
      s�lgerlabel.setForeground(new Color(150, 0, 0));
      GridBagConstraints gbc_s�lgerlabel = new GridBagConstraints();
      gbc_s�lgerlabel.anchor = GridBagConstraints.EAST;
      gbc_s�lgerlabel.insets = new Insets(0, 0, 5, 5);
      gbc_s�lgerlabel.gridx = 0;
      gbc_s�lgerlabel.gridy = 9;
      lbpanel.add(s�lgerlabel, gbc_s�lgerlabel);

      s�lgerField = new JTextField();
      s�lgerField.setMinimumSize(new Dimension(100, 20));
      GridBagConstraints gbc_textField_9 = new GridBagConstraints();
      gbc_textField_9.anchor = GridBagConstraints.WEST;
      gbc_textField_9.insets = new Insets(0, 0, 5, 5);
      gbc_textField_9.gridx = 1;
      gbc_textField_9.gridy = 9;
      lbpanel.add(s�lgerField, gbc_textField_9);
      s�lgerField.setColumns(20);

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
      
      
      

      
    this.setSize( 650, 340 );
    return lbpanel;
  }
  
  
  private JPanel ButtonPanel()
  {
    JPanel buttonpanel = new JPanel();
    buttonpanel.setBackground(Color.BLACK);
    buttonpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    
    backButton = new JButton("Tilbage");
    buttonpanel.add(backButton);
    
    backButton.addActionListener( event ->
    {
      this.dispose();
      new OpretbilDialog(kunde, bil);
      
    });
    
    forwardButton = new JButton("Opret L�netilbud");
    buttonpanel.add( forwardButton );
    
    forwardButton.addActionListener( event ->
    {
//      S�lgerLogik sl = new S�lgerLogik();
      
      aftale.setBel�b( Double.parseDouble( bel�bField.getText() ) );
      aftale.setUdbetaling( Double.parseDouble( udbetalingField.getText() ) );
      aftale.setRente( Double.parseDouble( renteField.getText() ) );
      aftale.setAfviklingsperiode( Integer.parseInt( afviklingsperiodeField.getText() ) );
      aftale.setOprettelsesdato( datoField.getText() );
      aftale.setS�lgerid( Integer.parseInt( s�lgerField.getText() ) );
      aftale.setChassisnummer( bil.getChassisnummer() );
      aftale.setCprid( Integer.parseInt( navnField.getText() ) );
      
      FinansieringsaftaleLogik fal = new FinansieringsaftaleLogik();
      try
      {
        fal.createFinansieringsaftale( aftale );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
      JOptionPane.showMessageDialog( this, "L�neaftalen er oprettet" );
      
    });      
    
    
    return buttonpanel;
  }
  
  
}
