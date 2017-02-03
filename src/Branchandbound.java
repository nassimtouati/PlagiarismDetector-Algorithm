

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Branchandbound {
	
	
    /*public static boolean checksolution(String s1,String s2,String solution){
   
 	   boolean retval = s1.contains(solution) && s2.contains(solution);
 	   System.out.println("Method returns : " + retval);
	return retval;
 	
    }*/
	
    public String LCS_R(String s1 , String s2){
		 String Result="";
                 //si les chaines sont vides      
    	if (s1.length()==0 || s2.length()==0){
                    Result="";
	}
	else {
            
	// determiner la langueur des chaines   	
            int m = s1.length(); 
            int n = s2.length();
		
		  if (s1.charAt(m-1)==s2.charAt(n-1)){
		    String st1=s1.substring(0,m-1); 
		    String st2=s2.substring(0,n-1);
		 
		    String temp=String.valueOf(s1.charAt(m-1));
			 
		      Result=LCS_R(st1,st2).concat(temp);
		      //Result=temp.concat(LCS_R(st1,st2));
		}
		  else {
			  String st1=s1.substring(0,m-1);
			  String st2=s2.substring(0,n-1);
			  String Z1=LCS_R(st1,s2);
			  Result=Z1;
                          
                          // utilisation de upperbound pour l'exploration des brancches 
                          
			  if (Upperbound(s1,st2)>Z1.length()){
				
			     String Z2=LCS_R(s1,st2);
			   
			     Result=Z2;	  
			     if (Z2.length()>Z1.length())
			    	 Result=Z2;
			     else Result=Z1;
			  } 
		  }
		}
    	
		  return Result;
		}
    
    
    
    
    
    // definition du upperbound
	public static int Upperbound(String s1, String s2){
		    Set<Character> ss1=null;
		    int up=0; 
		   
		    if (s1.length()==0||s2.length()==0){
		    	return up;
		      }
		    else{
		    	
		   
		    ss1 = toSet(s1);
		    ss1.retainAll(toSet(s2));
		 
		    String  st;
			st=ss1.toString();
	
		    int  l=st.length();
		    char a='[';
		    char b=']';  char c=','; char d=' ';
		    int lengths1=s1.length();  int lengths2=s2.length();
		    for (int i=0;i<l;i++){
			   
			 if( st.charAt(i)!=a && st.charAt(i)!=b && st.charAt(i)!=c && st.charAt(i)!=d){
					 
			 int count1=0;
			 int count2=0;
			 for(int j=0;j<lengths1;j++){                //check the occurence in s1
				if (s1.charAt(j) == st.charAt(i))
		        {
		             count1++;
		        }
			 }	
		     for(int j2=0;j2<lengths2;j2++){           //S2
				if (s2.charAt(j2) == st.charAt(i))
			    {
			         count2++;
			    }	
				
			 }
		
			 if (count2>count1){ 
				 up=up+count1;	}   
			 else  {up=up+count2;}	   
				
			  }	   
		     }
		 
			 return up;
		    }
		}

public static Set<Character> toSet(String s) {
        Set<Character> ss = new HashSet<Character>(s.length());
		for (char c : s.toCharArray())
		        ss.add(Character.valueOf(c));
		return ss;
		}
	//caclculer le upperbound
		
	/*
public static void main(String[] args) {
		// TODO Auto-generated method stub
                double score=100;
                float pourcentage;
                long debut = System.currentTimeMillis();
                //enter les 2 Strings
            Scanner sc=new Scanner(System.in);	
            System.out.println("Enter 2 strings to get the LCS ");
            System.out.println("enter the first string ");
            String str1=sc.nextLine();
            System.out.println("enter your second string");
            String str2=sc.nextLine();
            double i1 =str1.length();
            System.out.println("LENGTH OF FIRST TEXT IN STRING :" + i1 + "\t"); 
            String LCS = LCS_R(str1,str2);
	  
	  //String LCS2=LCS_R(str2,str1);
            System.out.println("*** Votre LCS Branch And Bound est ... " +LCS);
            double cmpt= LCS.length();
            System.out.println("LENGTH OF The LCS IS IN STRING : " + cmpt + "\t");
            pourcentage = (float) ((cmpt/i1)*score);
            System.out.println("POURCENTAGE OF PLAGIARISM IS : " +pourcentage+"%");
       //  float f1 = dlcs.pourcentage(i2, i1);
        // System.out.println("*** Votre LCS Dynamic Pourcentage est ... "+f1+"%"); 
            System.out.println(" THE EXECUTION TIME IS **-** ");
            System.out.println(System.currentTimeMillis()-debut + " milisecondes");
	  //System.out.println("le resultat final2 "+LCS2);
	  }
	  */
public  float pourcentage(double n, double m) {

	 float f = (float) ((n/m)*100);
	
	return f;
	}

	}


