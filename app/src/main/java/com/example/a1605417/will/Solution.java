package com.example.a1605417.will;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Solution {
    public static  void main(String []args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         int n,j,k;
         ArrayList<Data> inputList=new ArrayList<Data>();
         ArrayList<Data> checkList=new ArrayList<Data>();
         n=Integer.parseInt(br.readLine());
         while(n!=0){
             String s=br.readLine();
             if(s.equalsIgnoreCase("SERVED")){
                 Data data=new Data("SERVED",null,0.0,0);
                 inputList.add(data);
             }
            else{
                 String[] split=s.split(" ");
                 Data data=new Data(split[0],split[1],Double.parseDouble(split[2]),Integer.parseInt(split[3]));
                 inputList.add(data);
             }
             n--;
         }
         for(int i=0;i<inputList.size();i++){
             if(inputList.get(i).getStatus().equals("SERVED")){
                 Collections.sort(checkList,new Comparator<Data>() {

                     public int compare( Data o1, Data o2) {
                         return Double.compare(o1.getCgpa(),o2.getCgpa());
                     }
                 });
                 Collections.reverse(checkList);
                 for(j=0;j<checkList.size()-1;j++){
                     if(checkList.get(j).getCgpa()!=checkList.get(j+1).getCgpa()){
                         break;
                     }
                 }
                 Collections.sort(checkList.subList(0,j+1),new Comparator<Data>() {
                     public int compare( Data o1, Data o2) {
                         return o1.getName().compareTo(o2.getName());
                     }
                 });
                 for(k=0;k<checkList.size()-1;k++){
                     if(checkList.get(k).getCgpa()!=checkList.get(k+1).getCgpa()||!checkList.get(k).getName().equals(checkList.get(k+1).getName())){
                         break;
                     }
                 }
                 Collections.sort(checkList.subList(0,k+1),new Comparator<Data>() {

                     public int compare( Data o1, Data o2) {
                         return Integer.compare(o1.getToken(),o2.getToken());
                     }
                 });
                 checkList.remove(0);
             }
             else{
              checkList.add(inputList.get(i));
             }
         }
         for(int a=0;a<checkList.size();a++){
             System.out.println(checkList.get(a).getName());
         }
         if(checkList.isEmpty())
             System.out.println("EMPTY");
    }

 }

class Data {


    private String name;
    private double cgpa;
    private int token;
    private String status;


    public Data(String status, String name, double cgpa, int token){

        this.name=name;
        this.status=status;
        this.cgpa=cgpa;
        this.token=token;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
