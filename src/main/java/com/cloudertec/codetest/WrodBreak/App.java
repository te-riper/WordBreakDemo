package com.cloudertec.codetest.WrodBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);  
    	System.out.println("InputString：");
    	String input = sc.next();
    	
    	//String s ="ilikesamsungmobile";
    	Set<String> dict = new HashSet<String>();
        dict.add("i");
        dict.add("like");
        dict.add("sam");
        dict.add("sung");
        dict.add("samsung");
        dict.add("mobile");
        dict.add("ice");
        dict.add("cream");
        dict.add("and");
        //dict.add("icecream");
        dict.add("man");
        dict.add("go");
        //dict.add("mango");
        
        //Get the breaker instance
        Breaker breaker = Breaker.getBreaker();
        ArrayList<String> arr = breaker.goBreak(input, dict);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

    }
}


abstract class Breaker{
	
	public static Breaker getBreaker()
	{
		//can be set any logic for different Implements algorithm
		if(1==1)
		{
			return new DFSBreaker();
		}
		return new DFSBreaker();
	}
	
	public abstract ArrayList<String> goBreak(String s, Set<String> dict);
}

class DFSBreaker extends Breaker{
    public ArrayList<String> goBreak(String s, Set<String> dict) {
        return DFS(s,dict,new HashMap<String, ArrayList<String>>());
    }
    
    //DFS Method
    private ArrayList<String> DFS(String s,Set<String> dict,HashMap<String,ArrayList<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        } 
        ArrayList<String> res = new ArrayList<String>();
        if(s.length()==0){
            res.add("");
            return res;
        }
        for(String str:dict){
            if(s.startsWith(str)){
                for(String subStr : DFS(s.substring(str.length()),dict,map)){
                    res.add(str+(subStr ==""?"":" ")+subStr);
                }
            }
        }
        map.put(s,res);
        return res;
    }
	
  }
