package com.mycompany.wekaapipredict;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;

public class Predict {

    public void scry(String modelPath, String arffPath, int row) {

        try {
           
            Classifier classifier = (Classifier) SerializationHelper.read(modelPath);

            Instances newData = DataSource.read(arffPath);

            newData.setClassIndex(newData.attribute("ValorQualitativo").index());

           // for (int i = 0; i < newData.numInstances(); i++) {
                double prediction = classifier.classifyInstance(newData.instance(row));
                String predict =  newData.classAttribute().value((int) prediction);
                System.out.println("Instance " + (row) + " - Predicted: " + predict);
           // }

         //  for (int i = 0; i < newData.numInstances(); i++) {
                double[] predictionDistribution = classifier.distributionForInstance(newData.instance(row));

                // Replace 'classIndex' with the index of the class you want to get the percentage for.
                int classIndex = 0; // Change to the correct index.

                double percentage = predictionDistribution[classIndex] * 100; // Convert to percentage* 100
                String percent = Double.toString(percentage);
                System.out.println("Instance " + (row) + " - Predicted class " + newData.classAttribute().value(classIndex) + ": " + percentage + "%");
          // }

          JsonMaker jmake = new JsonMaker();
          
          jmake.makeJson(predict, percent);
          
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void predict(int row) {

        Connection con = new ConnectionFactory().establishConnection();

        CsvMaker csvMaker = new CsvMaker();

        //String query = "SELECT * FROM pessoa where id = 1";
        String filename = "person";

        csvMaker.sqlToCSV(row, filename, con);

        ArffMaker arffMaker = new ArffMaker();

        String input = "C:/Users/Usuário/Documents/NetBeansProjects/WekaApiPredict/person.csv";
        String output = "C:/Users/Usuário/Documents/NetBeansProjects/WekaApiPredict/person.arff";

        arffMaker.csvToArff(input, output);

        String arff = "C:/Users/Usuário/Downloads/weka/result.arff";
        String modelPath = "C:/Users/Usuário/Documents/NetBeansProjects/WekaApiPredict/RNA.model";

        Predict predict = new Predict();

        predict.scry(modelPath, output, row);

    }

}
