
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PNDynamic {
	
    public String WritePNDynamic(String str, int LongLine) {

	       
    	List<String> inputText = new ArrayList<String>(Arrays.asList(str.split(" "))); 
    	
        int cost[][] = new int[inputText.size()][inputText.size()];

       

       // là on va remplir la matrice de la manière suivante  si les mots d'indices de i à j 
        //peuvent être sur la même ligne on calcule les caractères vides a la fin de la prase 
        // sinon on met la valeur à MAX_VALUE

        for(int i=0 ; i < inputText.size(); i++){

            cost[i][i] = LongLine - inputText.get(i).length();

            for(int j=i+1; j < inputText.size(); j++){

                cost[i][j] = cost[i][j-1] - inputText.get(j).length() - 1; 

            }

        }
        
        for(int i=0; i < inputText.size(); i++){

            for(int j=i; j < inputText.size(); j++){

                if(cost[i][j] < 0){

                    cost[i][j] = Integer.MAX_VALUE;

                }else{

                    cost[i][j] = (int)Math.pow(cost[i][j], 2);

                }

            }

        }
// là on va chercher le minimal cout de 1 à length pour la 1ere boucle
   // j entre i et longueur de la chaine et on prend la valeur de j qui a le cout minimal 
       

        
        int minCost[] = new int[inputText.size()];

        int result[] = new int[inputText.size()];

        for(int i = inputText.size() -1; i >= 0 ; i--){

            minCost[i] = cost[i][inputText.size( )-1];

            result[i] = inputText.size();

            for(int j=inputText.size() -1; j > i; j--){

                if(cost[i][j-1] == Integer.MAX_VALUE){

                    continue;

                }

                if(minCost[i] > minCost[j] + cost[i][j-1]){

                    minCost[i] = minCost[j] + cost[i][j-1];

                    result[i] = j;

                }

            }

        }

        int i = 0;

        int j;

       

        System.out.println("Minimum cost is " + minCost[0]);

        System.out.println("\n");

        // et là on va imprimer nos mots sur des ligne en coupant juste au niveau des j récupérés 

        StringBuilder builder = new StringBuilder();

        do{

            j = result[i];

            for(int k=i; k < j; k++){

                builder.append(inputText.get(k) + " ");

            }

            builder.append("\n");

            i = j;

        }while(j < inputText.size());

       

        return builder.toString();

    }
}
