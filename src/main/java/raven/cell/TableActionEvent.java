/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package raven.cell;

/**
 *
 * @author MINH QUAN
 */
public interface TableActionEvent {
    
    void onEdit(int row, int[] columnsToEdit);
    void onDelete(int row);
    void onView(int row);
    }
