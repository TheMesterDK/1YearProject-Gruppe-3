package prototypes;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import logic.*;



public class MainWindow extends JFrame
{
  
  private JPanel contentPane;
  private JTextField searchField;
  

  
  /**
   * Create the frame.
   */
  public MainWindow()
  {
    setBackground(Color.RED);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setBounds( 100, 100, 500, 500 );
    contentPane = new JPanel();
    contentPane.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    setContentPane( contentPane );
    contentPane.setLayout(new BorderLayout(0, 0));
    contentPane.setBackground(Color.RED);
    
    JPanel logopanel = LogoPanel();
    contentPane.add(logopanel, BorderLayout.NORTH);
    
//    JPanel sælgerpanel = SælgerPanel();
//    contentPane.add(sælgerpanel, BorderLayout.CENTER);
    
    JPanel findkundepanel = FindKundePanel();
    contentPane.add(findkundepanel, BorderLayout.CENTER);

    
    
  }
  
  
  
  private JPanel SælgerPanel()
  {
    JPanel sælgerpanel = new JPanel();
    sælgerpanel.setBackground(Color.RED);
    
    sælgerpanel.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    sælgerpanel.setLayout(new BoxLayout(sælgerpanel, BoxLayout.Y_AXIS));
    
    JLabel label0 = new JLabel();
    label0.setText(" ");
    sælgerpanel.add( label0 );
    
    JButton btnOpretLåneanmodning = new JButton("Opret låneanmodning");
    sælgerpanel.add(btnOpretLåneanmodning);
//    btnOpretLåneanmodning.addActionListener(  );
    
    JLabel label1 = new JLabel();
    label1.setText(" ");
    sælgerpanel.add( label1 );
    
    JButton btnFindKunde = new JButton("Find kunde");
    sælgerpanel.add(btnFindKunde);
 //   btnFindKunde.addActionListener(  );
    
    JLabel label2 = new JLabel();
    label2.setText(" ");
    sælgerpanel.add( label2 );
    
    JButton btnFindBil = new JButton("Find bil");
    sælgerpanel.add(btnFindBil);
//    btnFindBil.addActionListener(  );
    
    JLabel label3 = new JLabel();
    label3.setText(" ");
    sælgerpanel.add( label3 );
    
    JButton btnFindLåneaftale = new JButton("Find låneaftale");
    sælgerpanel.add(btnFindLåneaftale);
//    btnFindLåneaftale.addActionListener(  );
    
    return sælgerpanel;
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
  
  
  private JPanel FindKundePanel()
  {
    JPanel findkundepanel = new JPanel();
    findkundepanel.setBackground(Color.RED);
    findkundepanel.setLayout(new BorderLayout(0, 0));
    
    JPanel searchpanel = new JPanel();
    findkundepanel.add(searchpanel, BorderLayout.NORTH);
    searchpanel.setBackground(Color.RED);
    JComboBox comboBox = new JComboBox();
    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cpr-nummer", "Navn", "Tlf-nr.", "Bil-chassisnummer"}));
    searchpanel.add(comboBox);
//    comboBox.actionPerformed(  );
    searchField = new JTextField();
    searchpanel.add(searchField);
    searchField.setColumns(10);
    JButton searchButton = new JButton("New button");
    searchpanel.add(searchButton);
//    searchButton.addActionListener(  );

    JPanel resultpanel = new JPanel();
    resultpanel.setBackground(Color.RED);
    findkundepanel.add(resultpanel, BorderLayout.CENTER);
    
    JPanel buttonpanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) buttonpanel.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    buttonpanel.setBackground(Color.RED);
    findkundepanel.add(buttonpanel, BorderLayout.SOUTH);
    JButton tilbageButton = new JButton("Tilbage");
    buttonpanel.add(tilbageButton);
//    tilbageButton.addActionListener(  );
    JButton redigerButton = new JButton("Rediger");
    buttonpanel.add(redigerButton);
//    redigerButton.addActionListener(  );
    
    
    
    
    return findkundepanel;
  }
  
}
