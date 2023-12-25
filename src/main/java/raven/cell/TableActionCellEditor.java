/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.cell;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
/**
 *
 * @author MINH QUAN
 */
public class TableActionCellEditor extends DefaultCellEditor{
    private TableActionEvent event;
    private int row;  // Added row field to store the row information
    private int[] columnsToEdit;

    public TableActionCellEditor(TableActionEvent event, int row, int[] columnsToEdit) {
        super(new JCheckBox());
        this.event = event;
        this.row = row;
        this.columnsToEdit = columnsToEdit;

        PanelAction action = new PanelAction();
        action.initEvent(event, row, columnsToEdit);
        editorComponent = action;
        setClickCountToStart(1);
    }

    // Implement the getRow method to retrieve the stored row information
    public int getRow() {
        return row;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
    PanelAction action = new PanelAction();
    int[] columnsToEdit = {0, 1, 2};  // Specify the columns you want to make editable
    action.initEvent(event, row, columnsToEdit);
    action.setBackground(jtable.getSelectionBackground());
    return action;
    }
}
