/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

/**
 *
 * @author Laura
 */
public class PersistentDataController {
    private static PersistentDataController thePersistentDataCntl;
    private PersistentDataCollection thePersistentDataCollection;

    private final String JSON_FILE_NAME = "AlphaCareData.json";
    
    private PersistentDataController(){
        
        readJSONDataModel();
        if(thePersistentDataCollection == null){
            thePersistentDataCollection = new PersistentDataCollection();
            
            writeJSONDataModel();
            readJSONDataModel();
        }
    }
    
    /**
     * Get the current persistent data controller
     * @return thePersistentDataCntl
     */
    public static PersistentDataController getPersistentDataCntl(){
        if(thePersistentDataCntl == null){
            thePersistentDataCntl = new PersistentDataController();
        }
        return thePersistentDataCntl;
    }
    
    public PersistentDataCollection getPersistentDataCollection(){
        return thePersistentDataCollection;
    }
    
    /**
     * Writes the data to JSON format
     */
    public void writeJSONDataModel(){
        try{
            Writer writer = new FileWriter(JSON_FILE_NAME);
            Gson gson = new GsonBuilder().create();
            gson.toJson(thePersistentDataCollection, writer);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Reads in the JSON data
     */
    public void readJSONDataModel(){
        Gson gson = new Gson();
        try{
            BufferedReader br = new BufferedReader(new FileReader(JSON_FILE_NAME));
            thePersistentDataCollection = gson.fromJson(br, PersistentDataCollection.class);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
