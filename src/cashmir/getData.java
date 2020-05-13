/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashmir;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dwiky-PC
 */
public class getData {
    private static DefaultTableModel model;
    private static Connection con;
    public static void getData(){

        
     model.getDataVector( ).removeAllElements( );
     model.fireTableDataChanged( );
     DatabaseConnection dbc = DatabaseConnection.getDatabaseConnection();
        con = dbc.getConnection();
     try{
         //membuat statemen pemanggilan data pada table tblGaji dari database
         Statement smt = con.createStatement();
           String sql        = "Select * from kasir";
           ResultSet res   = smt.executeQuery(sql);

           //penelusuran baris pada tabel tblGaji dari database
           while(res.next ()){
                Object[ ] obj = new Object[7];
                obj[0] = res.getString("idPelanggan");
                obj[1] = res.getString("nama");
                obj[2] = res.getString("makanan");
                obj[3] = res.getString("minuman");
                obj[4] = res.getString("harga");
                obj[5] = res.getString("uang");
                obj[6] = res.getString("jml_makanan");
                obj[7] = res.getString("jml_minuman");

                model.addRow(obj);
            }
      }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
      }
}
}
