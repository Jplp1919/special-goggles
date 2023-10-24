package com.mycompany.wekaapipredict;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Checker {

    int rowCount =0;

    public boolean check() {
        
        return false;
    }

    public int checkCount(Connection con) {
        try {
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM pessoa");
            // get the number of rows from the result set
            rs.next();
            rowCount = rs.getInt(1);
            //System.out.println(rowCount);
        } catch (SQLException ex) {
             
            Logger.getLogger(Checker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowCount;
    }
}
