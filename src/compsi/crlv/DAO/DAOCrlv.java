/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author allan
 */
public class DAOCrlv extends Database {
    
    public void insert() throws ClassNotFoundException, SQLException{
            
        abrirBanco();
        System.out.println("abrir banco");
        boolean a = testarConexao();
        System.out.println(a);
        a = testarConexao();
        System.out.println(a);
        
    }
    

        
}
