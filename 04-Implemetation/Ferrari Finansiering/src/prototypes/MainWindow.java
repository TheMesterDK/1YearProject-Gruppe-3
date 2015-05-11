package prototypes;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import logic.*;



public class MainWindow extends JFrame
{
  
  private JPanel contentPane;
  private String comboString[];
  


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
    
//    JPanel s�lgermainpanel = S�lgerMainPanel();
//    contentPane.add(s�lgermainpanel, BorderLayout.CENTER);
    
//    JPanel findkundepanel = FindKundePanel();
//    contentPane.add(findkundepanel, BorderLayout.CENTER);
    
//    JPanel findbilpanel = FindBilPanel();
//    contentPane.add(findbilpanel, BorderLayout.CENTER);
    
    JPanel findaftalepanel = FindL�neaftalePanel();
    contentPane.add(findaftalepanel, BorderLayout.CENTER);

    
    
  }
  
  
  private JPanel S�lgerMainPanel()
  {
    JPanel s�lgerpanel = new JPanel();
    s�lgerpanel.setBackground(Color.RED);
    s�lgerpanel.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    s�lgerpanel.setLayout(new BoxLayout(s�lgerpanel, BoxLayout.Y_AXIS));
    JLabel label0 = new JLabel();
    label0.setText(" ");
    s�lgerpanel.add( label0 );
    JButton btnOpretL�neanmodning = new JButton("Opret l�neanmodning");
    s�lgerpanel.add(btnOpretL�neanmodning);
//    btnOpretL�neanmodning.addActionListener(  );
    JLabel label1 = new JLabel();
    label1.setText(" ");
    s�lgerpanel.add( label1 );
    JButton btnFindKunde = new JButton("Find kunde");
    s�lgerpanel.add(btnFindKunde);
 //   btnFindKunde.addActionListener(  );
    JLabel label2 = new JLabel();
    label2.setText(" ");
    s�lgerpanel.add( label2 );
    JButton btnFindBil = new JButton("Find bil");
    s�lgerpanel.add(btnFindBil);
//    btnFindBil.addActionListener(  );
    JLabel label3 = new JLabel();
    label3.setText(" ");
    s�lgerpanel.add( label3 );
    JButton btnFindL�neaftale = new JButton("Find l�neaftale");
    s�lgerpanel.add(btnFindL�neaftale);
//    btnFindL�neaftale.addActionListener(  );
    
    return s�lgerpanel;
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
    
    String[] kundeString = new String[] {"Cpr-nummer", "Navn", "Tlf-nr.", "Bil-chassisnummer"};
    setComboString(kundeString);
    
    JPanel searchpanel = SearchPanel();
    findkundepanel.add(searchpanel, BorderLayout.NORTH);
    
    JPanel resultpanel =ResultPanel();
    findkundepanel.add(resultpanel, BorderLayout.CENTER);
    
    JPanel buttonpanel = ButtonPanel();
    findkundepanel.add(buttonpanel, BorderLayout.SOUTH);

    return findkundepanel;
  }
  
  
  private JPanel FindBilPanel()
  {
    JPanel findbilpanel = new JPanel();
    
    findbilpanel.setBackground(Color.RED);
    findbilpanel.setLayout(new BorderLayout(0, 0));
    
    String[] bilString = new String[] {"Chassis-nummer", "Reg. nummer", "Model"};
    setComboString(bilString);
    
    JPanel searchpanel = SearchPanel();
    findbilpanel.add(searchpanel, BorderLayout.NORTH);
    
    JPanel resultpanel =ResultPanel();
    findbilpanel.add(resultpanel, BorderLayout.CENTER);
    
    JPanel buttonpanel = ButtonPanel();
    findbilpanel.add(buttonpanel, BorderLayout.SOUTH);

    return findbilpanel;
  }
  
  
  private JPanel FindL�neaftalePanel()
  {
    JPanel findaftalepanel = new JPanel();
    
    findaftalepanel.setBackground(Color.RED);
    findaftalepanel.setLayout(new BorderLayout(0, 0));
    
    String[] aftaleString = new String[] {"Aftale-ID", "Cpr-ID", "Cpr-nummer", "Chassis-nummer", "Reg.-nummer", "S�lger-ID"};
    setComboString(aftaleString);
    
    JPanel searchpanel = SearchPanel();
    findaftalepanel.add(searchpanel, BorderLayout.NORTH);
    
    JPanel resultpanel =ResultPanel();
    findaftalepanel.add(resultpanel, BorderLayout.CENTER);
    
    JPanel buttonpanel = ButtonPanel();
    findaftalepanel.add(buttonpanel, BorderLayout.SOUTH);

    return findaftalepanel;
  }
  
  
                    private JPanel SearchPanel()
                    {
                      JPanel searchpanel = new JPanel();
                      searchpanel.setBackground(Color.RED);
                      JComboBox comboBox = new JComboBox();
                      comboBox.setModel(new DefaultComboBoxModel(comboString));
                      searchpanel.add(comboBox);
                  //    comboBox.actionPerformed(  );
                      JTextField searchField = new JTextField();
                      searchpanel.add(searchField);
                      searchField.setColumns(10);
                      JButton searchButton = new JButton("S�g");
                      searchpanel.add(searchButton);
                  //    searchButton.addActionListener(  );
                      
                      return searchpanel;
                    }
                    
                    
                    private JPanel ResultPanel()
                    {
                      JPanel resultpanel = new JPanel();
                      resultpanel.setBackground(Color.RED);
                      
                      return resultpanel;
                    }
                    
                    
                    private JPanel ButtonPanel()
                    {
                      JPanel buttonpanel = new JPanel();
                      FlowLayout flowLayout = (FlowLayout) buttonpanel.getLayout();
                      flowLayout.setAlignment(FlowLayout.RIGHT);
                      buttonpanel.setBackground(Color.RED);
                      JButton tilbageButton = new JButton("Tilbage");
                      buttonpanel.add(tilbageButton);
                      //  tilbageButton.addActionListener(  );
                      JButton redigerButton = new JButton("Rediger");
                      buttonpanel.add(redigerButton);
                      //  redigerButton.addActionListener(  );
                      
                      return buttonpanel;
                    }
   



  
  
  
  
  public String[] getComboString()
  {
    return comboString;
  }

  public void setComboString( String[] comboString )
  {
    this.comboString = comboString;
  }
  
  
}
