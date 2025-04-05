package com.bridgelab.json_filehandling.practice_problem;

import org.json.JSONObject;

public class MergeTwoJsonObject {

    public static JSONObject mergeObject(JSONObject ob1, JSONObject ob2){
        JSONObject merge = new JSONObject(ob1);

        for(String key : JSONObject.getNames(ob2)){
            merge.put(key, ob2.get(key));
        }
        for(String key : JSONObject.getNames(ob1)){
            merge.put(key, ob1.get(key));
        }
        return  merge;
    }

    public static void main(String[] args) {

        JSONObject obj1 = new JSONObject();
        obj1.put("Id",123);
        obj1.put("Name","deepak");
        obj1.put("Age",23);

        JSONObject obj2 = new JSONObject();
        obj2.put("City","imphal");
        obj2.put("isStudent",true);

        System.out.println("Before merging: ");
        System.out.println(obj1);
        System.out.println(obj2);


        JSONObject mergeObj = mergeObject(obj1,obj2);

        System.out.println("After merging: ");
        System.out.println(mergeObj.toString());

    }

}
