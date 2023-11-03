package com.mycompany.wekaapipredict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Classifier;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ArffLoader;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;

public class Predict {

    public void scry(String modelPath, String arffPath) throws Exception {

        try {
            ArffLoader loader = new ArffLoader();
            loader.setFile(new File(arffPath));
            Instances dataset = loader.getDataSet();
            dataset.setClassIndex(dataset.numAttributes() - 1);

            MultilayerPerceptron rnaModel = (MultilayerPerceptron) weka.core.SerializationHelper.read(modelPath);

            Instance lastInstance = dataset.lastInstance();
            try {
                 double[] predictionDistribution = rnaModel.distributionForInstance(lastInstance);
                double prediction = rnaModel.classifyInstance(lastInstance);
                String predict = Double.toString(prediction);
                String percent = Double.toString(predictionDistribution[(int) prediction]*100);
                percent = percent + "%";
                System.out.println("Predicted class for the last instance: " + prediction);
                System.out.println("Percentage confidence: " + (predictionDistribution[(int) prediction] * 100) + "%");
                
                JsonMaker jmake = new JsonMaker();

            jmake.makeJson(predict, percent);
            } catch (Exception e) {
                e.printStackTrace();
            }


            /*       try {
            
            Classifier classifier = (Classifier) SerializationHelper.read(modelPath);
            
            Instances newData = DataSource.read(arffPath);
            System.out.println("0");
            newData.setClassIndex(newData.attribute("ValorQualitativo").index());
            System.out.println("1");
            // for (int i = 0; i < newData.numInstances(); i++) {
            System.out.println(row + "rows");
            double prediction = classifier.classifyInstance(newData.instance(row));
            System.out.println(prediction);
            System.out.println("2");
            String predict = newData.classAttribute().value((int) prediction);
            System.out.println("3");
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
            }*/
        } catch (IOException ex) {
            Logger.getLogger(Predict.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void predict() throws Exception {

        Connection con = new ConnectionFactory().establishConnection();

        CsvMaker csvMaker = new CsvMaker();

        //String query = "SELECT * FROM pessoa where id = 1";
        String filename = "person";

        csvMaker.sqlToCSV(filename, con);

        ArffMaker arffMaker = new ArffMaker();

        String input = "C:/Users/Usuário/Documents/NetBeansProjects/WekaApiPredict/person.csv";
        String output = "C:/Users/Usuário/Documents/NetBeansProjects/WekaApiPredict/person.arff";

        arffMaker.csvToArff(input, output);

        String arff = "C:/Users/Usuário/Downloads/weka/result.arff";
        String modelPath = "C:/Users/Usuário/Documents/NetBeansProjects/WekaApiPredict/RNA.model";

        Predict predict = new Predict();

        predict.scry(modelPath, output);

    }

}
