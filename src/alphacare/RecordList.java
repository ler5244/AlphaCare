/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class RecordList {
    private ArrayList<Record> record = new ArrayList(); 
    
    public RecordList(){
        record = new ArrayList();
        ArrayList<Record> newRecord = new ArrayList();
        Record exampleRecord = new Record("sickness","symptoms", "miscInfo", "username");
                
        newRecord.add(exampleRecord);
        record = newRecord; 
    }

    public ArrayList<Record> getRecord() {
        return record;
    }

    public void setRecord(ArrayList<Record> record) {
        this.record = record;
    }
}
