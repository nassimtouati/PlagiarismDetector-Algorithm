


public class DivideAndConquer {
	public  float pourcentage(double n, double m) {

		 float f = (float) ((n/m)*100);
		
		return f;
		}
    String lcsDv(String str1, String str2) {
        int tabDv[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    tabDv[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    tabDv[i][j] = tabDv[i - 1][j - 1] + 1;
                } else {
                    tabDv[i][j] = Math.max(tabDv[i - 1][j], tabDv[i][j - 1]);
                }

            }
        }

        int index = tabDv[str1.length()][str2.length()];

        char lcsTabChar[] = new char[index + 1];

        int i = str1.length(), j = str2.length();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcsTabChar[index - 1] = str1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (tabDv[i - 1][j] > tabDv[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(lcsTabChar);
    }

    public int divConTemp(String a, String b) {
        if (a.length() < 2 && b.length() < 2) {
            if (a.charAt(0) == b.charAt(0)) {
                return 0;
            } else {
                return 1;
            }
        } else {
            int word = divCon(a, b);

            String firstParta = a.substring(0, word);
            String secondParta = a.substring(word);
            String firstPartb = b.substring(0, (b.length() / 2));
            String secondPartb = b.substring((b.length() / 2));

            int[][] m1 = new int[2][b.length()];
            int[][] m2 = new int[2][b.length()];
            int m11 = divCon(firstPartb, b);
            int m22 = divCon(secondPartb, b);

            int[][] m3 = new int[2][b.length()];
            System.out.println();
            for (int j = 0; j < 2; j++) {
                m3[0][0] = 0;
                for (int i = 0; i < b.length(); i++) {
                    m3[j][i] = m1[j][i] + m2[j][i];
//                    
                }
                System.out.println();
            }
           
            int t = m11 + m22;
//            System.out.println(t);

            lcsDv(a, b);
            System.out.println(lcsDv(a, b));
            return word;
        }
    }

    public static int divCon(String x, String y) {
        int[][] tabConq = new int[2][y.length()];
        if (x.length() < 2 && y.length() < 2) {
            if (x.length() == 0 && y.length() == 0) {
                tabConq[1][0] = 0;
                return tabConq[1][0];
            } else {
                if (x.charAt(0) == y.charAt(0)) {
                    return tabConq[1][0];
                } else {
                    tabConq[1][0] = tabConq[0][0] + 1;
                }
                return tabConq[1][0];
            }
        } else {
            for (int i = 1; i < y.length(); i++) {
                tabConq[0][i] = i;
            }
            for (int i = 1; i < x.length(); i++) {
                tabConq[1][0] = i;
                for (int j = 1; j < y.length(); j++) {
                    if (x.charAt(i - 1) == y.charAt(j)) {
                        tabConq[1][j] = tabConq[0][j - 1];
                    }

                    for (int c = 0; c < 2; c++) {
                        for (int k = 0; k < y.length(); k++) {
                            tabConq[0][k] = tabConq[1][k];
                        }
                    }
                }
            }

            return tabConq[1][y.length() - 1];

        }
    }
/*
    public static void main(String[] args) {
        
        String chaine1 = "mon nom est cedric hezhg tfrhjjhjghjjhj ok";
        String chaine2 = "cedric est mon nom z gzg ok";
        
        System.out.println("The size of the first protein = " + chaine1.length());
        System.out.println("The size of the first protein = " + chaine2.length());
        long debut = System.currentTimeMillis();
        DivideAndConquer dc = new DivideAndConquer();
        int motFinal = dc.divConTemp(chaine1, chaine2);
        System.out.println(System.currentTimeMillis()-debut);
    }
*/
}
