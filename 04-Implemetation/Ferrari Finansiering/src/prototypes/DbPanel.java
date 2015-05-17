package prototypes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import logic.*;
import domain.*;

public class DbPanel extends JPanel
{
  
  private CustomTableModel model;
  private CustomTableRenderer table;
  private JPanel contentPane;
  private JTextField searchField;
  private String comboString[];
  private String combochoise;
  private JComboBox comboBox;
  private String[] columnNames;
  private JButton redigerButton = new JButton( "Rediger" );
  
  
  public DbPanel()
  {
    setBackground( Color.BLACK );
    setBounds( 100, 100, 815, 329 );
    contentPane = new JPanel();
    contentPane.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    contentPane.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.setBackground( Color.BLACK );
    
    JPanel logopanel2 = LogoPanel2();
    contentPane.add( logopanel2, BorderLayout.EAST );
    
    this.setVisible( true );
  }
  
  
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
  
  
  
  
  
  
  private JPanel FindKundePanel()
  {
    JPanel findkundepanel = new JPanel();
    findkundepanel.setBackground( Color.RED );
    findkundepanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findkundepanel, BorderLayout.CENTER );
    
    comboString = new String[] { "Cpr-nummer", "Navn", "Tlf-nr.", "Bil-chassisnummer" };
    
    JPanel searchpanel = SearchPanel();
    findkundepanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findkundepanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findkundepanel.add( buttonpanel, BorderLayout.SOUTH );
    
//    this.setTitle( "Kunde" );
    this.setSize( 800, 340 );
    return findkundepanel;
  }
  
  
  private JPanel FindBilPanel()
  {
    JPanel findbilpanel = new JPanel();
    findbilpanel.setBackground( Color.RED );
    findbilpanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findbilpanel, BorderLayout.CENTER );
    
    comboString = new String[] { "Chassis-nummer", "Reg. nummer", "Model" };
    
    JPanel searchpanel = SearchPanel();
    findbilpanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findbilpanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findbilpanel.add( buttonpanel, BorderLayout.SOUTH );
    
//    this.setTitle( "Bil" );
    this.setSize( 800, 340 );
    return findbilpanel;
  }
  
  
  private JPanel FindLåneaftalePanel()
  {
    JPanel findaftalepanel = new JPanel();
    findaftalepanel.setBackground( Color.RED );
    findaftalepanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findaftalepanel, BorderLayout.CENTER );
    
    comboString = new String[] { "Aftale-ID", "Cpr-ID", "Cpr-nummer", "Chassis-nummer", "Reg.-nummer", "Sælger-ID" };

    
    JPanel searchpanel = SearchPanel();
    findaftalepanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findaftalepanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findaftalepanel.add( buttonpanel, BorderLayout.SOUTH );
    
//    this.setTitle( "LåneAftale" );
    this.setSize( 800, 340 );
    return findaftalepanel;
  }
  
  
  private JPanel SearchPanel()
  {
    JPanel searchpanel = new JPanel();
    searchpanel.setBackground( Color.BLACK );
    comboBox = new JComboBox();
    comboBox.setModel( new DefaultComboBoxModel( comboString ) );
    searchpanel.add( comboBox );
//    comboBox.addActionListener(event ->
//      {
//        
//      });
    JTextField searchField = new JTextField();
    searchpanel.add( searchField );
    searchField.setColumns( 10 );
    JButton searchButton = new JButton( "Søg" );
    searchpanel.add( searchButton );
    searchButton.addActionListener( event -> searchButtonPressed());
    
    this.getRootPane().setDefaultButton(searchButton);
    return searchpanel;
  }
  
  
  private JPanel ResultPanel()
  {
    JPanel resultpanel = new JPanel();
    resultpanel.setForeground(Color.RED);
    resultpanel.setBackground( Color.BLACK );
    
    model = new CustomTableModel();
    table = new CustomTableRenderer(model);
    table.getTableHeader().setReorderingAllowed(false);
    table.setRowSorter(new TableRowSorter<>(model));
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    model.setColumnIdentifiers(columnNames);
    int width = 0;
    int frameHeight = 400;
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
    contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
//    this.pack();
    this.setVisible(true);
    
    return resultpanel;
  }
  
  
 
  public void searchButtonPressed()
  {
    logic.KundeLogik kl = new KundeLogik();
    logic.BilLogik bl = new BilLogik();
    logic.FinansieringsaftaleLogik fl = new FinansieringsaftaleLogik();
    List<Kunde> kundesearchlist = null;
    List<Bil> bilsearchlist = null;
    List<Finansieringsaftale> aftalesearchlist = null;
//    List searchlist;
    if(this.getTitle() == "Kunde")
    {
      columnNames = new String[] { "Cpr-ID", "Navn", "Adresse", "Postnummer", "Telefon", "Email", "Kommentar"};
      model.setRowCount(0);
//      List<Kunde> searchlist = kl.listKunder( comboBox.getSelectedItem().toString(), searchField.getText() );
//      if(comboBox.getSelectedItem().toString() == "Cpr-nummer")
//      {
//        try
//        {
//          kundesearchlist = kl.listKunder( "Cprnummer", searchField.getText() );
//        }
//        catch ( SQLException e )
//        {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//        }
//      }
//      else
//      {
        try
        {
          kundesearchlist = kl.listKunder( comboBox.getSelectedItem().toString(), searchField.getText() );
        }
        catch ( SQLException e )
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
//      }
//      searchlist = kundesearchlist;
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
      try
      {
        bilsearchlist = bl.listBiler( comboBox.getSelectedItem().toString(), searchField.getText() );
      }
      catch ( SQLException e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
//      searchlist = bilsearchlist;
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
      else if(comboBox.getSelectedItem().toString() == "Reg.-nummer")
      {
        
      }
      else
      {
        try
        {
          aftalesearchlist = fl.listFinansieringsaftaler( comboBox.getSelectedItem().toString(), searchField.getText() );
        }
        catch ( SQLException e )
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
//      searchlist = aftalesearchlist;
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
    
    
//    TableModel TabelModel = new AbstractTableModel()
//    {
//      // String[] columnNames = { "Album titel", "Bandnavn", "Genre", "#", "Sangtitel", "år"};
//      
//      public String getColumnName( int col )
//      {
//        return columnNames[col].toString();
//      }
//      
//      public int getColumnCount()
//      {
//        return columnNames.length;
//      }
//      
//      public int getRowCount()
//      {
//        return searchlist.size();
//      }
//      
//      public Object getValueAt( int row, int col )
//      {
//        if ( col == 0 )
//        {
//          return searchlist.get( row ).getAlbumtitel();
//        }
//        else if ( col == 1 )
//        {
//          return searchlist.get( row ).getBandnavn();
//        }
//        else if ( col == 2 )
//        {
//          return searchlist.get( row ).getGenretype();
//        }
//        else if ( col == 3 )
//        {
//          return searchlist.get( row ).getSangnummer();
//        }
//        else if ( col == 4 )
//        {
//          return searchlist.get( row ).getSangtitel();
//        }
//        else
//        {
//          return searchlist.get( row ).getUdgivelse();
//        }
//      }
//    };
//    liste.setModel( TabelModel );
//    liste.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
//    liste.getColumnModel().getColumn( 3 ).setPreferredWidth( 1 );
//    liste.getColumnModel().getColumn( 5 ).setPreferredWidth( 4 );
//    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//    rightRenderer.setHorizontalAlignment( SwingConstants.RIGHT );
//    liste.getColumnModel().getColumn( 0 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 1 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 2 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 3 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 4 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 5 ).setCellRenderer( rightRenderer );
//    scrollListe.setViewportView( liste );
    
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
    redigerButton = new JButton();
    redigerButton.setEnabled( false );
    buttonpanel.add( redigerButton );
    redigerButton.addActionListener( event ->
    {
      
    });
    
    return buttonpanel;
  }
}
