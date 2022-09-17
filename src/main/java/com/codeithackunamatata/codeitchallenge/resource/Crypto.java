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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;


@RestController
public class Crypto {
    Logger logger = LoggerFactory.getLogger(Crypto.class);

   @RequestMapping(value = "/cryptocollapz",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
   public List<List<Integer>> cryptocollapz(@RequestBody List<List<Integer>> body){
       List<List<Integer>> returnList = new ArrayList<>();
//       Integer value = Integer.parseInt(body.get("input"));
       for(List<Integer> el:body){
           returnList.add(solution(el));
       }
       return returnList;
   }


    public static List<Integer> solution (List<Integer> input){
        List<Integer> returnList = new ArrayList<>();
        for(int current:input){
            returnList.add(solution_helper(current,4));
        }
        return returnList;
    }
    public static int solution_helper(int input,int max){
        if(max<input){
            max=input;
        }
        if(input==2){
            return max;
        }
        int curr;
        if(input%2==0){
            curr = solution_helper(input/2,max);
        } else {
            curr  = solution_helper(input*3+1,max);

        }
        max = Math.max(curr, max);
        return max;
    }
}
