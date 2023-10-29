/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wekaapipredict;

import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class PhpConnection {

    String phpUrl = "https://yourserver.com/your-php-script.php";

    public void connectToPhp(String prediction, String probability) {
        URL url;
        try {
            url = new URL(phpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            
            // Send the value to PHP
            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            osw.write(prediction + " " + probability);
            osw.flush();
            osw.close();
            
        } catch (MalformedURLException e) {
            Logger.getLogger(PhpConnection.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(PhpConnection.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
