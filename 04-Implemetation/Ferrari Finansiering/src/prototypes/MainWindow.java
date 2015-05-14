package prototypes;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;

import logic.*;

public class MainWindow extends JFrame
{
  
  private JPanel contentPane;
  private String comboString[];
  
  public MainWindow()
  {
    setBackground( Color.BLACK );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setBounds( 100, 100, 815, 329 );
    contentPane = new JPanel();
    contentPane.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    setContentPane( contentPane );
    contentPane.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.setBackground( Color.BLACK );
    
//    JPanel logopanel = LogoPanel();
//    contentPane.add( logopanel, BorderLayout.NORTH );
    
    JPanel logopanel2 = LogoPanel2();
    contentPane.add( logopanel2, BorderLayout.EAST );
    
    JPanel sælgermainpanel = SælgerMainPanel();
    contentPane.add( sælgermainpanel, BorderLayout.CENTER );
    
//     JPanel findkundepanel = FindKundePanel();
//     contentPane.add(findkundepanel, BorderLayout.CENTER);
    
    // JPanel findbilpanel = FindBilPanel();
    // contentPane.add(findbilpanel, BorderLayout.CENTER);
    
    // JPanel findaftalepanel = FindLåneaftalePanel();
    // contentPane.add(findaftalepanel, BorderLayout.CENTER);
    
    this.setVisible( true );
    
  }
  
//  private JPanel LogoPanel()
//  {
//    JPanel logopanel = new JPanel();
//    FlowLayout flowLayout = (FlowLayout) logopanel.getLayout();
//    flowLayout.setAlignment( FlowLayout.LEFT );
//    logopanel.setBackground( Color.RED );
//    JLabel label = new JLabel( new ImageIcon( "C:\\Users\\Dennis\\Documents\\GitHub\\1YearProject-Gruppe-3\\04-Implemetation\\Ferrari Finansiering\\Yellow logo on red background.png" ) );
//    label.setLabelFor( label );
//    label.setSize( new Dimension( 300, 100 ) );
//    label.setBackground( new Color( 200, 50, 50 ) );
//    label.setIconTextGap( 0 );
//    label.setPreferredSize( new Dimension( 300, 100 ) );
//    label.setMinimumSize( new Dimension( 100, 50 ) );
//    label.setMaximumSize( new Dimension( 1000, 500 ) );
//    logopanel.add( label );
//    
//    return logopanel;
//  }
  
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
  
  
  public JPanel SælgerMainPanel()
  {
    JPanel sælgerpanel = new JPanel();
    sælgerpanel.setBackground( Color.BLACK );
    sælgerpanel.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    sælgerpanel.setLayout( new BoxLayout( sælgerpanel, BoxLayout.Y_AXIS ) );
    contentPane.add( sælgerpanel, BorderLayout.CENTER );
    JLabel label0 = new JLabel();
    label0.setText( " " );
    sælgerpanel.add( label0 );
    JButton btnOpretLåneanmodning = new JButton( "Opret låneanmodning" );
    btnOpretLåneanmodning.setForeground(Color.BLACK);
    btnOpretLåneanmodning.setBackground(new Color(153, 0, 0));
    sælgerpanel.add( btnOpretLåneanmodning );
    btnOpretLåneanmodning.addActionListener( event ->
    {
      
    } );
    JLabel label1 = new JLabel();
    label1.setText( " " );
    sælgerpanel.add( label1 );
    JButton btnFindKunde = new JButton( "Find kunde" );
    btnFindKunde.setBackground(new Color(153, 0, 0));
    sælgerpanel.add( btnFindKunde );
    btnFindKunde.addActionListener( event ->
    {
      
      sælgerpanel.setVisible( false );
      contentPane.add( FindKundePanel(), BorderLayout.CENTER );
//      contentPane.repaint();
      
    } );
    JLabel label2 = new JLabel();
    label2.setText( " " );
    sælgerpanel.add( label2 );
    JButton btnFindBil = new JButton( "Find bil" );
    btnFindBil.setBackground(new Color(153, 0, 0));
    sælgerpanel.add( btnFindBil );
    btnFindBil.addActionListener( event ->
    {
      sælgerpanel.setVisible( false );
      contentPane.add( FindBilPanel(), BorderLayout.CENTER );
//      contentPane.repaint();
    } );
    JLabel label3 = new JLabel();
    label3.setText( " " );
    sælgerpanel.add( label3 );
    JButton btnFindLåneaftale = new JButton( "Find låneaftale" );
    btnFindLåneaftale.setBackground(new Color(153, 0, 0));
    sælgerpanel.add( btnFindLåneaftale );
    btnFindLåneaftale.addActionListener( event ->
    {
      sælgerpanel.setVisible( false );
      contentPane.add( FindLåneaftalePanel(), BorderLayout.CENTER );
//      contentPane.repaint();
    } );
    
    this.setSize( 350, 340 );
    return sælgerpanel;
  }
  
  
  private JPanel FindKundePanel()
  {
    JPanel findkundepanel = new JPanel();
    findkundepanel.setBackground( Color.RED );
    findkundepanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findkundepanel, BorderLayout.CENTER );
    
    String[] kundeString = new String[] { "Cpr-nummer", "Navn", "Tlf-nr.", "Bil-chassisnummer" };
    setComboString( kundeString );
    
    JPanel searchpanel = SearchPanel();
    findkundepanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findkundepanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findkundepanel.add( buttonpanel, BorderLayout.SOUTH );
    
    this.setSize( 800, 340 );
    return findkundepanel;
  }
  
  
  private JPanel FindBilPanel()
  {
    JPanel findbilpanel = new JPanel();
    findbilpanel.setBackground( Color.RED );
    findbilpanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findbilpanel, BorderLayout.CENTER );
    
    String[] bilString = new String[] { "Chassis-nummer", "Reg. nummer", "Model" };
    setComboString( bilString );
    
    JPanel searchpanel = SearchPanel();
    findbilpanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findbilpanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findbilpanel.add( buttonpanel, BorderLayout.SOUTH );
    
    this.setSize( 800, 340 );
    return findbilpanel;
  }
  
  
  private JPanel FindLåneaftalePanel()
  {
    JPanel findaftalepanel = new JPanel();
    findaftalepanel.setBackground( Color.RED );
    findaftalepanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findaftalepanel, BorderLayout.CENTER );
    
    String[] aftaleString = new String[] { "Aftale-ID", "Cpr-ID", "Cpr-nummer", "Chassis-nummer", "Reg.-nummer", "Sælger-ID" };
    setComboString( aftaleString );
    
    JPanel searchpanel = SearchPanel();
    findaftalepanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findaftalepanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findaftalepanel.add( buttonpanel, BorderLayout.SOUTH );
    
    return findaftalepanel;
  }
  
  
  private JPanel SearchPanel()
  {
    JPanel searchpanel = new JPanel();
    searchpanel.setBackground( Color.BLACK );
    JComboBox comboBox = new JComboBox();
    comboBox.setModel( new DefaultComboBoxModel( comboString ) );
    searchpanel.add( comboBox );
    // comboBox.actionPerformed( );
    JTextField searchField = new JTextField();
    searchpanel.add( searchField );
    searchField.setColumns( 10 );
    JButton searchButton = new JButton( "Søg" );
    searchpanel.add( searchButton );
    searchButton.addActionListener( event ->
    {
      
    });
    
    return searchpanel;
  }
  
  
  private JPanel ResultPanel()
  {
    JPanel resultpanel = new JPanel();
    resultpanel.setBackground( Color.BLACK );
    
    return resultpanel;
  }
  
  
  private JPanel ButtonPanel()
  {
    JPanel buttonpanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) buttonpanel.getLayout();
    flowLayout.setAlignment( FlowLayout.RIGHT );
    buttonpanel.setBackground( Color.BLACK );
    JButton tilbageButton = new JButton( "Tilbage" );
    buttonpanel.add( tilbageButton );
    tilbageButton.addActionListener( event ->
    {
      
    });
    JButton redigerButton = new JButton( "Rediger" );
    buttonpanel.add( redigerButton );
    redigerButton.addActionListener( event ->
    {
      
    });
    
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
