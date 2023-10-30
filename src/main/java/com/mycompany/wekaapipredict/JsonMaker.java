package com.mycompany.wekaapipredict;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class JsonMaker {

    public void makeJson(String prediction, String percentage) {
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        //Inserting key-value pairs into the json object
        if("0".equals(prediction)){
            prediction = "negativo";
        } else if("1".equals(prediction)){
            prediction = "positivo";
        }
        jsonObject.put("Resultado", prediction);
        jsonObject.put("Certeza", percentage);

        try {
            FileWriter file = new FileWriter("C:/Users/Usuário/Desktop/php codes/output.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: " + jsonObject);

    }

}
