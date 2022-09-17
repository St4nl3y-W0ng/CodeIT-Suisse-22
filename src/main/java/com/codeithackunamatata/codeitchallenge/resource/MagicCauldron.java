package com.codeithackunamatata.codeitchallenge.resource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MagicCauldron {
    Logger logger = LoggerFactory.getLogger(MagicCauldron.class);

   @RequestMapping(value = "/magiccauldrons",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
   public List<Map<String,Integer>> magiccauldrons(@RequestBody List<Map<String,Map<String,Integer>>> body){

       List<Map<String,Integer>> returnList = new ArrayList<>();
       for(Map<String,Map<String,Integer>>el:body){
           Map<String,Integer> partOne = el.get("part1");
           Map<String,Integer> partTwo = el.get("part2");
           Map<String,Integer> partThree = el.get("part3");
           Map<String,Integer> partFour = el.get("part4");


          Map<String,Integer> output = new HashMap<>();
           output.put("part1",solution_part1(partOne.get("flow_rate"),partOne.get("time"),partOne.get("row_number"),partOne.get("col_number")));
           output.put("part2",solution_part2(partTwo.get("flow_rate"),partTwo.get("amount_of_soup"),partTwo.get("row_number"),partTwo.get("col_number")));
           output.put("part3",solution_part3(partThree.get("flow_rate"),partThree.get("time"),partThree.get("row_number"),partThree.get("col_number")));
           output.put("part4",solution_part4(partFour.get("flow_rate"),partFour.get("amount_of_soup"),partFour.get("row_number"),partFour.get("col_number")));

           returnList.add(output);
       }


       return returnList;
   }
    public static int solution_part1(int flow_Rate,int time, int row, int col){
        int volume = flow_Rate*time;
        int cauldrons_before = (row)*(row+1)/2;
        if(cauldrons_before*100>=volume){
            return 0;
        }
        int remaining_volume = volume - cauldrons_before*100;
        return remaining_volume/(row+1);
    }
    public static int solution_part2(int flow_Rate,int amount_of_soup, int row, int col){
        int cauldrons_before = (row)*(row+1)/2;
        int volume = cauldrons_before*100+(row+1)*amount_of_soup;
        return volume/flow_Rate;
    }
    public static int solution_part3(int flow_Rate,int time, int row, int col){
        int volume = flow_Rate*time;
        int cauldrons_before = (row)*(row+1)/2;

        int[] irregularArr = new int[100];
        for(int i=0;i<irregularArr.length;i++){
            if(i==0){
                irregularArr[i]=0;
            }
            else if(i==1){
                irregularArr[i]=1;
            }
            else if(i%2==0){
                irregularArr[i]=irregularArr[i-1];
            } else {
                irregularArr[i] = irregularArr[i-1]+1;
            }
        }
        int[] cumulative_irregularArr = new int[100];
        for (int i=0;i<cumulative_irregularArr.length;i++){
            if(i==0){
                cumulative_irregularArr[i]=0;
            } else if (i==1){
                cumulative_irregularArr[i]=1;
            } else {
                cumulative_irregularArr[i]=irregularArr[i]+cumulative_irregularArr[i-1];
            }
        }
        int num_irregular = cumulative_irregularArr[row];
        int helper = (cauldrons_before - num_irregular) * 100 + num_irregular * 150;
        if(helper >=volume){
            return 0;
        }
        int remaining_volume = volume - helper;
        return remaining_volume/(row+1);
    }
    public static int solution_part4(int flow_Rate,int amount_of_soup, int row, int col){
        int[] irregularArr = new int[100];
        for(int i=0;i<irregularArr.length;i++){
            if(i==0){
                irregularArr[i]=0;
            }
            else if(i==1){
                irregularArr[i]=1;
            }
            else if(i%2==0){
                irregularArr[i]=irregularArr[i-1];
            } else {
                irregularArr[i] = irregularArr[i-1]+1;
            }
        }
        int[] cumulative_irregularArr = new int[100];
        for (int i=0;i<cumulative_irregularArr.length;i++){
            if(i==0){
                cumulative_irregularArr[i]=0;
            } else if (i==1){
                cumulative_irregularArr[i]=1;
            } else {
                cumulative_irregularArr[i]=irregularArr[i]+cumulative_irregularArr[i-1];
            }
        }
        int cauldrons_before = (row)*(row+1)/2;
        int num_irregular = cumulative_irregularArr[row];
        int volume = (cauldrons_before - num_irregular) * 100 + num_irregular * 150+(row+1)*amount_of_soup;
        return volume/flow_Rate;
    }


}
