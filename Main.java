package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	String [] projects= new String []{"a","b","c","d","e","f"};
    String[][] dependencies=new String[][]{{"a","d"},{"f","b"},{"b","d"},{"f","a"},{"d","c"}};

        System.out.println("Order: "+ Order(projects,dependencies));
    }

    public static List<String> Order(String[] projects, String[][] dependencies) {
        List<String> results=new ArrayList<>();
        int length= dependencies.length;
        int loop=0;
        for(String project: projects){
            for(String[] dependency:dependencies){
                if(!project.equals(dependency[1])){
                    loop++;
                }
            }
            if(loop==length){
                results.add(project);
            }
            loop=0;
        }
        for(int i=0;i<results.size();i++){
            for(String[] dependency: dependencies){
                if(results.get(i).equals(dependency[0])){
                    results.add(dependency[1]);
                }
            }
        }
        return results;
    }


}
