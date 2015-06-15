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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.LåneberegningsLogik;


public class KreditværdighedDialog extends JDialog
{
  
  private static final long serialVersionUID = 1L;

  private final JPanel contentPanel;
  
  private JTextField returnField;
  private JTextField cprnummerField;
  private JButton NyKundeButton;
  private String kreditværdighed;
  

  public KreditværdighedDialog()
  {
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
    
    
    JPanel cprpanel = CprPanel();
    contentPanel.add(cprpanel, BorderLayout.CENTER);
    
    
    this.setVisible( true );
  }
  
  
  public KreditværdighedDialog(String cprnummer)
  {
    this();
    cprnummerField.setText( cprnummer );
    
  }
  
  
  private JPanel LogoPanel()
  {
    JPanel logopanel = new JPanel();
    
    FlowLayout flowLayout = (FlowLayout) logopanel.getLayout();
    flowLayout.setAlignment( FlowLayout.LEFT );
    logopanel.setBackground( Color.BLACK );
    JLabel label2 = new JLabel( new ImageIcon( "C:\\Users\\Gammel\\My Documents\\GitHub\\1YearProject-Gruppe-3\\04-Implemetation\\Ferrari Finansiering\\Capture.png" ) );
    label2.setLabelFor( label2 );
    label2.setSize( new Dimension( 300, 100 ) );
    label2.setBackground( new Color( 200, 50, 50 ) );
    label2.setIconTextGap( 0 );
    label2.setMinimumSize( new Dimension(50, 300) );
    label2.setMaximumSize( new Dimension( 1000, 500 ) );
    logopanel.add( label2 );
    
    return logopanel;
  }
  
  
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
    contentPanel.add( cprpanel, BorderLayout.CENTER );
    this.setTitle( "Kontroller kreditværdighed" );
 
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
      
    
      button.addActionListener( event -> 
      {

        LåneberegningsLogik lblogic = new LåneberegningsLogik();
        kreditværdighed = lblogic.getKreditVærdighed( cprnummerField.getText() );
        returnField.setText(kreditværdighed);
        if(kreditværdighed == "A" || kreditværdighed == "B" || kreditværdighed == "C")
        {
          NyKundeButton.setEnabled( true );
          returnField.setBackground( Color.GREEN );
        }
        else
        {
          returnField.setBackground( Color.RED );
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
      returnField.setFont(new Font("Tahoma", Font.BOLD, 12));
      returnField.setHorizontalAlignment(SwingConstants.CENTER);
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
        this.dispose();
        new OpretkundeDialog(cprnummerField.getText(), kreditværdighed);

      });
      NyKundeButton.setEnabled( false );
      cprpanel.add(NyKundeButton, gbc_btnNewButton);

      
    return cprpanel;
  }
  
  
  
}
