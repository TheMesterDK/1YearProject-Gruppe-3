package prototypes;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;


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
