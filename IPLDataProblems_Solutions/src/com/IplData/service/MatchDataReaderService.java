package com.IplData.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.IplData.beans.Match;

public class MatchDataReaderService implements DataReaderServiceInterface {
    
//    private String[] matchData;
//
//    public MatchDataReaderService(String[] matchData) {
//        this.matchData = matchData;
//    }
    
    public static List<Match> matchesData = new ArrayList<Match>();
    
    public void readDataFromFile(){
        // Change the value w.r.t "matches.csv" file path.
        String csvFile = "inputData/matches.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int skip = 0;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                if(skip == 0){
                    skip++;
                    continue;
                }
                // split by comma
                String[] match = line.split(cvsSplitBy);
                this.storeData(match);               
                
            }
        }
            

         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
          
    }
    
    
    public void storeData(String[] data) {
        Match match = new Match();
        
        int data0 = Integer.parseInt(data[0]);
        int data1 = Integer.parseInt(data[1]);   
        
        match.setMatchId(data0);
        match.setSeason(data1);
        match.setCity(data[2]);
        match.setDate(data[3]);
        match.setTeam1(data[4]);
        match.setTeam2(data[5]);
        match.setTossWinner(data[6]);
        match.setTossDecision(data[7]);
        match.setResult(data[8]);
        match.setWinner(data[9]);
        
        matchesData.add(match);
       
        
    }
    
}
