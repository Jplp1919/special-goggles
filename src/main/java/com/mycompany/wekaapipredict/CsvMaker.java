package com.mycompany.wekaapipredict;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CsvMaker {

    public void sqlToCSV(int id, String filename, Connection con) {

        try {
            Statement statement = con.createStatement();
            FileWriter fw = new FileWriter(filename + ".csv");
            //ResultSet rs = statement.executeQuery("SELECT * FROM pessoa where id = " + id);
            ResultSet rs = statement.executeQuery("SELECT * FROM pessoa");
            int cols = rs.getMetaData().getColumnCount();

            for (int i = 1; i <= cols; i++) {
                fw.append(rs.getMetaData().getColumnLabel(i));
                if (i < cols) {
                    fw.append(',');
                } else {
                    fw.append('\n');
                }

            }

            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    if (rs.getString(i) == null) {
                        fw.append("?");
                    } else {
                        fw.append(rs.getString(i));
                    }

                    if (i < cols) {
                        fw.append(',');
                    }
                }
                fw.append('\n');
            }

            fw.flush();
            fw.close();
            con.close();

        } catch (IOException | SQLException e) {
          
            System.out.println(e.getMessage());
        }

    }
}
