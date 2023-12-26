/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.giaodienthick;

import com.mycompany.giaodienthick.GiaoDienAdd.SaveEvent;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import raven.cell.TableActionCellEditor;
import raven.cell.TableActionCellRender;
import raven.cell.TableActionEvent;

/**
 *
 * @author MINH QUAN
 */
public class GiaoDien extends javax.swing.JFrame implements SaveListener{
private TableActionEvent event;
private int editedRow = -1;
    /**
     * Creates new form GiaoDien
     */
private DefaultTableModel model2;
    public GiaoDien() {
        
        int[] columnsToEdit = {0, 1, 2};
        initComponents();
        TableActionEvent event = new TableActionEvent() {
            @Override
        public void onEdit(int row, int[] columnsToEdit) {
//            openCustomEditor(row, columnsToEdit);
//            openCustomEditor2(row, columnsToEdit);
//            openCustomEditor3(row, columnsToEdit);
//            editedRow = row; // Lưu lại dòng đã chỉnh sửa
//
//            int selectedRow = jTable1.getSelectedRow();
//            int id = (int) jTable1.getValueAt(editedRow, 0);
//            String fullname = (String) jTable1.getValueAt(editedRow, 1);
//            String email = (String) jTable1.getValueAt(editedRow, 2);
//
//    // Cập nhật dữ liệu và kiểm tra kết quả
//            if (capNhatDuLieu(id, fullname, email)) {
//                loadData(); // Load lại dữ liệu sau khi cập nhật
//                jTable1.setRowSelectionInterval(editedRow, editedRow);
//            } else {
//                System.out.println("Lỗi");
//            }
            view();
        }

            @Override
            public void onDelete(int row) {
                int s=jTable1.getSelectedRow();
                int id=(int)jTable1.getValueAt(s, 0);
                xoa(id);
            }

            @Override
            public void onView(int row) {
                view();
                System.out.println("View row : " + row);
                
            }

            private void openCustomEditor(int row, int[] columnsToEdit) {
    // Tạo một JTextField để hiển thị giá trị cũ
            JTextField textField = new JTextField(jTable1.getValueAt(row, 0).toString());
    
    // Hiển thị trình chỉnh sửa tùy chỉnh, chẳng hạn một JDialog
            int result = javax.swing.JOptionPane.showConfirmDialog(null, textField, "Edit value ID", javax.swing.JOptionPane.OK_CANCEL_OPTION);
    
    // Nếu người dùng nhấn OK, cập nhật giá trị cho cột đầu tiên (ID)
            if (result == javax.swing.JOptionPane.OK_OPTION) {
                jTable1.setValueAt(textField.getText(), row, 0);
            }
}
            
    private void openCustomEditor2(int row, int[] columnsToEdit) {
    // Tạo một JTextField để hiển thị giá trị cũ
        JTextField textField = new JTextField(jTable1.getValueAt(row, 0).toString());
    
    // Hiển thị trình chỉnh sửa tùy chỉnh, chẳng hạn một JDialog
        int result = javax.swing.JOptionPane.showConfirmDialog(null, textField, "Edit value Fullname", javax.swing.JOptionPane.OK_CANCEL_OPTION);
    
    // Nếu người dùng nhấn OK, cập nhật giá trị cho cột đầu tiên (ID)
        if (result == javax.swing.JOptionPane.OK_OPTION) {
            jTable1.setValueAt(textField.getText(), row, 1);
        }
    }
    
    private void openCustomEditor3(int row, int[] columnsToEdit) {
    // Tạo một JTextField để hiển thị giá trị cũ
        JTextField textField = new JTextField(jTable1.getValueAt(row, 0).toString());
    
    // Hiển thị trình chỉnh sửa tùy chỉnh, chẳng hạn một JDialog
        int result = javax.swing.JOptionPane.showConfirmDialog(null, textField, "Edit value Email", javax.swing.JOptionPane.OK_CANCEL_OPTION);
    
    // Nếu người dùng nhấn OK, cập nhật giá trị cho cột đầu tiên (ID)
        if (result == javax.swing.JOptionPane.OK_OPTION) {
            jTable1.setValueAt(textField.getText(), row, 2);
        }
    }
            
    };
    jTable1.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
    jTable1.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event, -1, new int[]{}));        
    jTable1.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });

    DefaultTableModel model = new DefaultTableModel() {
    boolean[] canEdit = new boolean[] {false, false, false, true};

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
    };
    model2 = (DefaultTableModel) jTable1.getModel();
    loadData();
    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Fullname", "Email", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);

        jButtonAdd.setText("+Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jButtonXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdd)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButtonAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonXoa)))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        
        GiaoDienAdd gd = new GiaoDienAdd();
        gd.addSaveListener(this);
        gd.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();
        int id = (int)jTable1.getValueAt(selectedRow, 0);
        xoa(id);
    }//GEN-LAST:event_jButtonXoaActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void onSave(SaveEvent event) {
        JOptionPane.showMessageDialog(this, "GiaoDienAdd đã được đóng và dữ liệu đã được lưu.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    if (editedRow != -1) {
        // Nếu có dòng đã chỉnh sửa, load lại dữ liệu và chọn lại dòng đó
        loadData();
        jTable1.setRowSelectionInterval(editedRow, editedRow);
        editedRow = -1; // Đặt lại giá trị để tránh tình trạng lặp
    } else {
        // Nếu không có dòng đã chỉnh sửa, chỉ load lại dữ liệu
        loadData();
    }
    }

    
    private void loadData(){
        Connection connection = null;

        try {
            // Kết nối đến SQL Server sử dụng class KetNoiMSSQL
            connection = KetNoi.layKetNoi();
            
            // Truy vấn dữ liệu từ SQL Server (thay YourTableName bằng tên bảng của bạn)
            String query = "SELECT * FROM QuanLySV";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Xóa dữ liệu hiện tại trong model
            model2.setRowCount(0);

            // Lấy thông tin về cột từ metadata
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Đặt tên cột cho model
            /*for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultSet.getMetaData().getColumnName(i));
            }*/

            // Thêm dữ liệu từ ResultSet vào model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model2.addRow(row);
            }

            // Đóng ResultSet và PreparedStatement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error connecting to the database: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Đóng kết nối sau khi sử dụng
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void view(){
        int selectedRow = jTable1.getSelectedRow();
        
        if(selectedRow != -1){
            int id = (int)jTable1.getValueAt(selectedRow, 0);
            String fullname = jTable1.getValueAt(selectedRow, 1).toString();
            String email=jTable1.getValueAt(selectedRow, 2).toString();
            
            GiaoDienView gdView = new GiaoDienView(id, fullname, email);
            gdView.setVisible(true);
            this.dispose();
        } else {
        // Hiển thị thông báo nếu không có dòng nào được chọn
            JOptionPane.showMessageDialog(this, "Please select a row to load", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void xoa(int id) {
    Connection ketNoi = KetNoi.layKetNoi();
    String sql = "DELETE FROM QuanLySV WHERE id = ?";
    try {
        PreparedStatement ps = ketNoi.prepareStatement(sql);
        ps.setInt(1, id);

        int rowCount = ps.executeUpdate();

        if (rowCount > 0) {
            JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Cập nhật lại dữ liệu trong table sau khi xóa
            loadData();
        } else {
            JOptionPane.showMessageDialog(this, "Không thể xóa sinh viên", "Error", JOptionPane.ERROR_MESSAGE);
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi xóa sinh viên: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (ketNoi != null && !ketNoi.isClosed()) {
                ketNoi.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }
    public void capNhatDuLieu(int id, String fullname, String email) {
    Connection ketNoi = null;
    try {
        ketNoi = KetNoi.layKetNoi();
        String sql = "UPDATE QuanLySV SET fullname = ?, email = ? WHERE id = ?";
        PreparedStatement ps = ketNoi.prepareStatement(sql);
        ps.setString(1, fullname);
        ps.setString(2, email);
        ps.setInt(3, id);

        int rowCount = ps.executeUpdate();

        // Commit the changes
        ketNoi.commit();

        // Check if the update was successful
        if (rowCount > 0) {
            JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thành công", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Không thể cập nhật sinh viên", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật sinh viên: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        try {
            if (ketNoi != null && !ketNoi.isClosed()) {
                ketNoi.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
