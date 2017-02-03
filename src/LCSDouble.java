
import java.util.ArrayList;
  
    public class LCSDouble {
	
    	 public ArrayList<String> LCS(String text1, String text2) {
             String[] text1Words = text1.split(" ");
             String[] text2Words = text2.split(" ");
             int text1WordCount = text1Words.length;
             int text2WordCount = text2Words.length;
            
             int[][] solutionMatrix = new int[text1WordCount + 1][text2WordCount + 1];
            
             for (int i = text1WordCount - 1; i >= 0; i--) {
                 for (int j = text2WordCount - 1; j >= 0; j--) {
                     if (text1Words[i].equals(text2Words[j])) {
                         solutionMatrix[i][j] = solutionMatrix[i + 1][j + 1] + 1;
                     }
                     else {
                         solutionMatrix[i][j] = Math.max(solutionMatrix[i + 1][j],
                             solutionMatrix[i][j + 1]);
                     }
                 }
             }
            
             int i = 0, j = 0;
             ArrayList<String> lcsResultList = new ArrayList<String>();
             while (i < text1WordCount && j < text2WordCount) {
                 if (text1Words[i].equals(text2Words[j])) {
                     lcsResultList.add(text2Words[j]);
                     i++;
                     j++;
                 }
                 else if (solutionMatrix[i + 1][j] >= solutionMatrix[i][j + 1]) {
                     i++;
                 }
                 else {
                     j++;
                 }
             }
             return lcsResultList;
         }
    	 public  int pourcentage(double n, double m) {

			 int f = (int) ((n/m)*100);
			
			return f;
			}

}
