package prototypes;


import java.awt.*;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import domain.*;
import logic.*;

public class MainWindow extends JFrame
{
  private JPanel contentPane;
  private CustomTableModel model;
  private CustomTableRenderer table;
  private JTextField searchField;
  private JComboBox comboBox;
  private String comboString[];
  private String[] columnNames;
  private JButton redigerButton;
  private JButton tilbageButton;
  
//  private JComboBox<String> comboBox = new JComboBox<String>();

  
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
    
//    JPanel sælgermainpanel = SælgerMainPanel();
//    contentPane.add( sælgermainpanel, BorderLayout.CENTER );
    
//     JPanel findkundepanel = FindKundePanel();
//     contentPane.add(findkundepanel, BorderLayout.CENTER);
    
//     JPanel findbilpanel = FindBilPanel();
//     contentPane.add(findbilpanel, BorderLayout.CENTER);
    
//     JPanel findaftalepanel = FindLåneaftalePanel();
//     contentPane.add(findaftalepanel, BorderLayout.CENTER);
    
    this.setVisible( true );
    
  }
  
  
  private JPanel LogoPanel2()
  {
    JPanel logopanel2 = new JPanel();
    logopanel2.setPreferredSize(new Dimension(100, 300));
    
    FlowLayout flowLayout = (FlowLayout) logopanel2.getLayout();
    flowLayout.setAlignment( FlowLayout.CENTER );
    logopanel2.setBackground( Color.BLACK );
    JLabel label2 = new JLabel( new ImageIcon( "C:\\Users\\Dennis\\Documents\\GitHub\\1YearProject-Gruppe-3\\04-Implemetation\\Ferrari Finansiering\\Capture.png" ) );
    label2.setPreferredSize(new Dimension(100, 280));
    label2.setLabelFor( label2 );
    label2.setSize( new Dimension(100, 280) );
    label2.setBackground( new Color( 200, 50, 50 ) );
    label2.setIconTextGap( 0 );
    label2.setMinimumSize( new Dimension(100, 250) );
    label2.setMaximumSize( new Dimension(100, 350) );
    logopanel2.add( label2 );
    
    return logopanel2;
  }
  
  
  /*
   * IKKE HELT FÆRDIG!
   * 
   * ActionListener på "Opret Låneanmodning" fungerer ikke helt som den skal.
   */
  public JPanel SælgerMainPanel()
  {
    JPanel sælgerpanel = new JPanel();
    sælgerpanel.setBackground( Color.BLACK );
    sælgerpanel.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    sælgerpanel.setLayout( new BoxLayout( sælgerpanel, BoxLayout.Y_AXIS ) );
    contentPane.add( sælgerpanel, BorderLayout.CENTER );
    this.setTitle( "Ferrari Finance Solutions" );
    JLabel label0 = new JLabel();
    label0.setText( " " );
    sælgerpanel.add( label0 );
    JButton btnOpretLåneanmodning = new JButton( "Opret låneanmodning" );
    btnOpretLåneanmodning.setForeground(Color.BLACK);
    btnOpretLåneanmodning.setBackground(new Color(150, 0, 0));
    sælgerpanel.add( btnOpretLåneanmodning );
    btnOpretLåneanmodning.addActionListener( event ->
    {
//      JPanel cp = new EditDialog().CprPanel();
//      new EditDialog().add( cp, BorderLayout.CENTER );
//      new EditDialog().add( CprPanel(),  );
      new CreateDialog();
      
    } );
    JLabel label1 = new JLabel();
    label1.setText( " " );
    sælgerpanel.add( label1 );
    JButton btnFindKunde = new JButton( "Find kunde" );
    btnFindKunde.setForeground(Color.BLACK);
    btnFindKunde.setBackground(new Color(150, 0, 0));
    sælgerpanel.add( btnFindKunde );
    btnFindKunde.addActionListener( event ->
    {
      
      contentPane.remove( sælgerpanel );
      contentPane.add( FindKundePanel(), BorderLayout.CENTER );
      contentPane.repaint();
      
    } );
    JLabel label2 = new JLabel();
    label2.setText( " " );
    sælgerpanel.add( label2 );
    JButton btnFindBil = new JButton( "Find bil" );
    btnFindBil.setForeground(Color.BLACK);
    btnFindBil.setBackground(new Color(150, 0, 0));
    sælgerpanel.add( btnFindBil );
    btnFindBil.addActionListener( event ->
    {
      contentPane.remove( sælgerpanel );
      contentPane.add( FindBilPanel(), BorderLayout.CENTER );
      contentPane.repaint();
    } );
    JLabel label3 = new JLabel();
    label3.setText( " " );
    sælgerpanel.add( label3 );
    JButton btnFindLåneaftale = new JButton( "Find låneaftale" );
    btnFindLåneaftale.setForeground(Color.BLACK);
    btnFindLåneaftale.setBackground(new Color(150, 0, 0));
    sælgerpanel.add( btnFindLåneaftale );
    btnFindLåneaftale.addActionListener( event ->
    {
      contentPane.remove( sælgerpanel );
      contentPane.add( FindLåneaftalePanel(), BorderLayout.CENTER );
      contentPane.repaint();
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
    this.setTitle( "Kunde" );
    
    comboString = new String[] { "CprID", "Navn", "Telefonnummer", "Adresse", "Email" };
    
    JPanel searchpanel = SearchPanel();
    findkundepanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findkundepanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findkundepanel.add( buttonpanel, BorderLayout.SOUTH );
    tilbageButton.addActionListener( event ->
    {
      contentPane.remove( findkundepanel );
      contentPane.add( SælgerMainPanel(), BorderLayout.CENTER );
      contentPane.repaint();
    });
    
    this.setSize( 800, 350 );
    return findkundepanel;
  }
  
  
  private JPanel FindBilPanel()
  {
    JPanel findbilpanel = new JPanel();
    findbilpanel.setBackground( Color.RED );
    findbilpanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findbilpanel, BorderLayout.CENTER );
    this.setTitle( "Bil" );
    
    comboString = new String[] { "Chassisnummer", "Registreringsnummer", "Model" };
    
    JPanel searchpanel = SearchPanel();
    findbilpanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findbilpanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findbilpanel.add( buttonpanel, BorderLayout.SOUTH );
    tilbageButton.addActionListener( event ->
    {
      contentPane.remove( findbilpanel );
      contentPane.add( SælgerMainPanel(), BorderLayout.CENTER );
      contentPane.repaint();
    });
    
    this.setSize( 800, 350 );
    return findbilpanel;
  }
  
  
  private JPanel FindLåneaftalePanel()
  {
    JPanel findaftalepanel = new JPanel();
    findaftalepanel.setBackground( Color.RED );
    findaftalepanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findaftalepanel, BorderLayout.CENTER );
    this.setTitle( "LåneAftale" );
    
    comboString = new String[] { "AftaleID", "CprID", "Cprnummer", "Chassisnummer", "Registreringsnummer", "SælgerID" };

    
    JPanel searchpanel = SearchPanel();
    findaftalepanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findaftalepanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findaftalepanel.add( buttonpanel, BorderLayout.SOUTH );
    tilbageButton.addActionListener( event ->
    {
      contentPane.remove( findaftalepanel );
      contentPane.add( SælgerMainPanel(), BorderLayout.CENTER );
      contentPane.repaint();
    });
    
    this.setSize( 800, 350 );
    return findaftalepanel;
  }
  
  
  private JPanel SearchPanel()
  {
    JPanel searchpanel = new JPanel();
    searchpanel.setBackground( Color.BLACK );
    comboBox = new JComboBox();
    comboBox.setModel( new DefaultComboBoxModel( comboString ) );
    searchpanel.add( comboBox );

    searchField = new JTextField();
    searchpanel.add( searchField );
    searchField.setColumns( 10 );
    JButton searchButton = new JButton( "Søg" );
    searchpanel.add( searchButton );
    searchButton.addActionListener( event -> searchButtonPressed());
    
    searchpanel.getRootPane().setDefaultButton(searchButton);
    return searchpanel;
  }
  
 
  private JPanel ResultPanel()
  {
    JPanel resultpanel = new JPanel();
    resultpanel.setForeground(Color.RED);
    resultpanel.setBackground( Color.BLACK );
    
    model = new CustomTableModel();
    table = new CustomTableRenderer(model);
    table.setOpaque(true);
    table.setGridColor(Color.WHITE);
    table.setForeground(Color.RED);
    table.setBackground(Color.BLACK);
    table.getTableHeader().setReorderingAllowed(false);
    table.setRowSorter(new TableRowSorter<>(model));
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    model.setColumnIdentifiers(columnNames);
    int width = 0;
    int frameHeight = 550;
    for (int i = 0; i < table.getColumnCount() ; i++) 
    {
        width += table.getColumnModel().getColumn(i).getWidth();
    }
    ListSelectionModel listSelectionModel = table.getSelectionModel();
    listSelectionModel.addListSelectionListener(e -> 
    {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        redigerButton.setEnabled(!lsm.isSelectionEmpty());
    });
    
//    this.setPreferredSize(new Dimension(width, frameHeight));
    JScrollPane scrollPane = new JScrollPane(table);
//    scrollPane.setOpaque(true);

    scrollPane.setForeground(Color.RED);
    scrollPane.setMinimumSize(new Dimension(200, 25));
    scrollPane.setPreferredSize(new Dimension(600, 200));
    scrollPane.setBackground(Color.BLACK);
    scrollPane.getViewport().setBackground(Color.BLACK);
    table.getTableHeader().setBackground( Color.BLACK );
    table.getTableHeader().setForeground( Color.RED );
    resultpanel.add(scrollPane, BorderLayout.CENTER);
//    this.pack();
    resultpanel.setVisible(true);
    
    return resultpanel;
  }
  
  
 /*
  * STADIG IKKE FÆRDIG!!!
  * 
  *  LåneaftalePanel mangler stadig at blive sat op.
  *  
  *  Umiddelbart virker KundePanel og BilPanel som de skal.
  *  
  */
  public void searchButtonPressed()
  {
    try
    {
      KundeLogik kl = new KundeLogik();
      BilLogik bl = new BilLogik();
      FinansieringsaftaleLogik fl = new FinansieringsaftaleLogik();
      List<Kunde> kundesearchlist = null;
      List<Bil> bilsearchlist = null;
      List<Finansieringsaftale> aftalesearchlist = null;
      model.setRowCount(0);
      if(this.getTitle() == "Kunde")
      {
        columnNames = new String[] { "Cpr-ID", "Navn", "Adresse", "Postnummer", "Telefon", "Email", "Kommentar"};
        kundesearchlist = kl.listKunder( comboBox.getSelectedItem().toString(), searchField.getText() );
        
        if(kundesearchlist.isEmpty()) 
        {
          JOptionPane.showMessageDialog(this, "Søgningen gav intet resultat");
        }
        else
        {
          model.setColumnIdentifiers(columnNames);
          for (Kunde k : kundesearchlist) 
          {
            Object[] o = new Object[7];
            o[0] = k.getCprid();
            //          o[1] = k.getCprnummer();
            o[1] = k.getNavn();
            o[2] = k.getAdresse();
            o[3] = k.getPostnummer();
            o[4] = k.getTelefonnummer();
            o[5] = k.getEmail();
            o[6] = k.getKommentar();
            model.addRow(o);
          }
        }
      }
      
      else if(this.getTitle() == "Bil")
      {
        columnNames = new String[] { "Chassisnummer", "Reg-nummer", "Pris", "Model", "Årgang", "Bemærkninger"};
        bilsearchlist = bl.listBiler( comboBox.getSelectedItem().toString(), searchField.getText() );
  
        
        if(bilsearchlist.isEmpty()) 
        {
          JOptionPane.showMessageDialog(this, "Søgningen gav intet resultat");
        }
        else
        {
          model.setColumnIdentifiers(columnNames);
          for (Bil b : bilsearchlist) 
          {
            Object[] o = new Object[6];
            o[0] = b.getChassisnummer();
            o[1] = b.getRegistreringsnummer();
            o[2] = b.getPris();
            o[3] = b.getModel();
            o[4] = b.getÅrgang();
            o[5] = b.getBemærkninger();
            model.addRow(o);
          }
        }
      }
      
      else if(this.getTitle() == "LåneAftale")
      {
        columnNames = new String[] { "Aftale-ID", "Oprettelsesdato", "Cpr-ID", "Beløb", "Udbetaling", "Rente", "Afviklingsperiode", "Bil-Chassisnummer", "SælgerID"};
        
        if(comboBox.getSelectedItem().toString() == "Cpr-nummer")
        {
          
        }
        else if(comboBox.getSelectedItem().toString() == "Reg.nummer")
        {
          
        }
        else
        {

            aftalesearchlist = fl.listFinansieringsaftaler( comboBox.getSelectedItem().toString(), searchField.getText() );
            
        }
        
        if(aftalesearchlist.isEmpty()) 
        {
          JOptionPane.showMessageDialog(this, "Søgningen gav intet resultat");
        }
        else
        {
          model.setColumnIdentifiers(columnNames);
          for (Finansieringsaftale fa : aftalesearchlist) 
          {
            Object[] o = new Object[9];
            o[0] = fa.getAftaleid();
            o[1] = fa.getOprettelsesdato();
            o[2] = fa.getCprid();
            o[3] = fa.getBeløb();
            o[4] = fa.getUdbetaling();
            o[5] = fa.getRente();
            o[6] = fa.getAfviklingsperiode();
            o[7] = fa.getChassisnummer();
            o[8] = fa.getSælgerid();
            model.addRow(o);
          }
        }
      } 
    }
    catch (SQLException e) 
    {
      JOptionPane.showMessageDialog(this, "[-] SQL Error\nNo connection to database." ,"Error!", JOptionPane.ERROR_MESSAGE);
    }
    this.setVisible( true );
  }

  
  private JPanel ButtonPanel()
  {
    JPanel buttonpanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) buttonpanel.getLayout();
    flowLayout.setAlignment( FlowLayout.RIGHT );
    buttonpanel.setBackground( Color.BLACK );
    tilbageButton = new JButton( "Tilbage" );
    buttonpanel.add( tilbageButton );

    redigerButton = new JButton( "Rediger" );
    buttonpanel.add( redigerButton );    
    redigerButton.setEnabled( false );
    redigerButton.addActionListener( event ->
    {
      if(this.getTitle() == "Kunde")
      {
        
        Kunde kunde = new Kunde();
        kunde.setCprid(Integer.parseInt( table.getValueAt( table.getSelectedRow(), 0 ).toString() ) );
        kunde.setNavn( table.getValueAt( table.getSelectedRow(), 1 ).toString() );
        kunde.setAdresse( table.getValueAt( table.getSelectedRow(), 2 ).toString() );
        kunde.setPostnummer( table.getValueAt( table.getSelectedRow(), 3 ).toString() );
        kunde.setTelefonnummer( table.getValueAt( table.getSelectedRow(), 4 ).toString() );
        kunde.setEmail( table.getValueAt( table.getSelectedRow(), 5 ).toString() );
        kunde.setKommentar( table.getValueAt( table.getSelectedRow(), 6 ).toString() );
        new EditDialog(kunde);
      }
      else if(this.getTitle() == "Bil")
      {
        Bil bil = new Bil();
        bil.setChassisnummer( table.getValueAt( table.getSelectedRow(), 0 ).toString() );
        bil.setRegistreringsnummer( table.getValueAt( table.getSelectedRow(), 1 ).toString() );
        bil.setPris(Double.parseDouble( table.getValueAt( table.getSelectedRow(), 2 ).toString() ) );
        bil.setModel( table.getValueAt( table.getSelectedRow(), 3 ).toString() );
        bil.setÅrgang( table.getValueAt( table.getSelectedRow(), 4 ).toString() );
        bil.setBemærkninger( table.getValueAt( table.getSelectedRow(), 5 ).toString() );
        new EditDialog(bil);
      }
      else if(this.getTitle() == "LåneAftale")
      {
        Finansieringsaftale aftale = new Finansieringsaftale();
        aftale.setAftaleid(Integer.parseInt( table.getValueAt( table.getSelectedRow(), 0 ).toString() ) );
        aftale.setOprettelsesdato( table.getValueAt( table.getSelectedRow(), 1 ).toString() );
        aftale.setCprid(Integer.parseInt( table.getValueAt( table.getSelectedRow(), 2 ).toString() ) );
        aftale.setBeløb(Double.parseDouble( table.getValueAt( table.getSelectedRow(), 3 ).toString() ) );
        aftale.setUdbetaling(Double.parseDouble( table.getValueAt( table.getSelectedRow(), 4 ).toString() ) );
        aftale.setRente(Double.parseDouble( table.getValueAt( table.getSelectedRow(), 5 ).toString() ) );
        aftale.setAfviklingsperiode(Integer.parseInt( table.getValueAt( table.getSelectedRow(), 6 ).toString() ) );
        aftale.setChassisnummer( table.getValueAt( table.getSelectedRow(), 7 ).toString() );
        aftale.setSælgerid(Integer.parseInt( table.getValueAt( table.getSelectedRow(), 8 ).toString() ) );
        new EditDialog(aftale);
      }
    });
    
    return buttonpanel;
  }

  
  
}
