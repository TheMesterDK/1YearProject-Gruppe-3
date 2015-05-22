package prototypes;

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

import domain.Bil;
import domain.Kunde;
import logic.BilLogik;

public class OpretbilDialog extends JDialog
{
  
  private final JPanel contentPanel;
  
  private Bil bil = null;
  private Kunde kunde = null;
  
  private JTextField chassisnummerField;
  private JTextField regnummerField;
  private JTextField prisField;
  private JTextField modelField;
  private JTextField �rgangField;
  private JTextField bem�rkningField;
  
  private JButton backButton;
  private JButton forwardButton;

  
  public OpretbilDialog(Kunde kunde)
  {
    this.kunde = kunde;
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

    
    JPanel bilpanel = BilPanel();
    contentPanel.add( bilpanel, BorderLayout.CENTER );
    
    
    this.setVisible( true );
  }
  
  
  public OpretbilDialog(Kunde kunde, Bil bil)
  {
    this(kunde);
    this.bil = bil;
    this.kunde = kunde;
    
    chassisnummerField.setText( bil.getChassisnummer() );
    regnummerField.setText( bil.getRegistreringsnummer() );
    prisField.setText( "" + bil.getPris() );
    modelField.setText( bil.getModel() );
    �rgangField.setText( bil.get�rgang() );
    bem�rkningField.setText( bil.getBem�rkninger() );
    
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
  
  
  private JPanel BilPanel()
  {
    JPanel bilpanel = new JPanel();
    bilpanel.setForeground(Color.RED);
    bilpanel.setBackground(Color.BLACK);
    GridBagLayout gbl_bilpanel = new GridBagLayout();
    gbl_bilpanel.columnWidths = new int[]{0, 0, 0};
    gbl_bilpanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    gbl_bilpanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
    gbl_bilpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    bilpanel.setLayout(gbl_bilpanel);
    contentPanel.add( bilpanel, BorderLayout.CENTER );
    this.setTitle( "Indtast biloplysninger" );
    
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
    gbc_chassisnummerField.anchor = GridBagConstraints.WEST;
    gbc_chassisnummerField.insets = new Insets(0, 0, 5, 0);
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
    gbc_regnummerField.anchor = GridBagConstraints.WEST;
    gbc_regnummerField.insets = new Insets(0, 0, 5, 0);
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
    gbc_prisField.anchor = GridBagConstraints.WEST;
    gbc_prisField.insets = new Insets(0, 0, 5, 0);
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
    gbc_modelField.anchor = GridBagConstraints.WEST;
    gbc_modelField.insets = new Insets(0, 0, 5, 0);
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
    gbc_�rgangField.anchor = GridBagConstraints.WEST;
    gbc_�rgangField.insets = new Insets(0, 0, 5, 0);
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
    gbc_bem�rkningField.anchor = GridBagConstraints.WEST;
    gbc_bem�rkningField.gridx = 1;
    gbc_bem�rkningField.gridy = 6;
    bilpanel.add(bem�rkningField, gbc_bem�rkningField);
    bem�rkningField.setColumns(10);
    
    
    JPanel buttonpanel = ButtonPanel();
    GridBagConstraints gbc_newpanel = new GridBagConstraints();
    gbc_newpanel.insets = new Insets(0, 0, 5, 0);
    gbc_newpanel.fill = GridBagConstraints.BOTH;
    gbc_newpanel.gridx = 1;
    gbc_newpanel.gridy = 9;
    bilpanel.add(buttonpanel, gbc_newpanel);
    
    
    
    this.setSize( 600, 333 );
    bilpanel.setVisible( true );
    return bilpanel;
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
      new OpretkundeDialog(kunde);
      
    });
    
    
    forwardButton = new JButton("Indtast l�nebetingelser");
    buttonpanel.add( forwardButton );
    
    forwardButton.addActionListener( event ->
    {
      bil.setChassisnummer( chassisnummerField.getText() );
      bil.setRegistreringsnummer( regnummerField.getText() );
      bil.setPris( Double.parseDouble( prisField.getText() ) );
      bil.setModel( modelField.getText() );
      bil.set�rgang( �rgangField.getText() );
      bil.setBem�rkninger( bem�rkningField.getText() );
      
      BilLogik bl = new BilLogik();
      try
      {
        bl.createBil( bil );
      }
      catch ( Exception e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      this.dispose();
      new Opretl�neaftaleDialog(kunde, bil);
    });
    
    
    return buttonpanel;
  }
  
  
}
