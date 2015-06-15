package presentation;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class CustomTableRenderer extends JTable
{
  public CustomTableRenderer( DefaultTableModel model )
  {
    super( model );
  }
  
  @Override
  public Component prepareRenderer( TableCellRenderer renderer, int row, int column )
  {
    Component component = super.prepareRenderer( renderer, row, column );
    int rendererWidth = component.getPreferredSize().width;
    TableColumn tableColumn = getColumnModel().getColumn( column );
    tableColumn.setPreferredWidth( Math.max( rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth() ) );
    return component;
  }
  
}
