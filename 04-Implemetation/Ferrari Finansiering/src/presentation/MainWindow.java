package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import logic.*;
import java.awt.Dimension;



public class MainWindow extends JFrame
{
  
  private JPanel contentPane;
  

  
  /**
   * Create the frame.
   */
  public MainWindow()
  {
    setBackground(Color.RED);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setBounds( 100, 100, 300, 400 );
    contentPane = new JPanel();
    contentPane.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    setContentPane( contentPane );
    contentPane.setLayout(new BorderLayout(0, 0));
    contentPane.setBackground(Color.RED);
    
    JPanel logopanel = LogoPanel();
    contentPane.add(logopanel, BorderLayout.NORTH);
    
    JPanel sælgerpanel = SælgerPanel();
    contentPane.add(sælgerpanel, BorderLayout.CENTER);
    
    
    
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
  
  
}
