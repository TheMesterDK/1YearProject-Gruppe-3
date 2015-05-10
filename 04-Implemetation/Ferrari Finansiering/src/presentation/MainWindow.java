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
    
    JPanel s�lgerpanel = S�lgerPanel();
    contentPane.add(s�lgerpanel, BorderLayout.CENTER);
    
    
    
  }
  
  
  
  private JPanel S�lgerPanel()
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
