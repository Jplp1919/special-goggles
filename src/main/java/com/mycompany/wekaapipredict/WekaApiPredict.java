package com.mycompany.wekaapipredict;

import java.sql.Connection;
import weka.core.converters.ArffLoader;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WekaApiPredict {

    public static void main(String[] args) throws Exception {
        Connection con = new ConnectionFactory().establishConnection();
        Predict predict = new Predict();
        Checker che = new Checker();
        int rows = che.checkCount(con);
        int newRows = rows;
        
        //predict.predict();
                
        
        
      while (true) {
           newRows = che.checkCount(con);
         
            if (newRows != rows) {
                
                rows = che.rowCount;
                
                if(rows == 0){
                    System.out.println("WARNING");
                } else{
                 predict.predict();   
                }
                
                
               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException ex) {
                   Logger.getLogger(WekaApiPredict.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }

    } 
}
