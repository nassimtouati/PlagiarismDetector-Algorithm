
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyVisio extends JFrame{
	 JFrame window;
	 JFrame windowRes;
	 JPanel panel;
	 JPanel panelRes;
	 JComboBox combolcs = new JComboBox();
	 JComboBox combopn = new JComboBox();
	 JLabel labellcs = new JLabel("LCS");
	 JTextArea labelRes = new JTextArea("****_**** And the Result is ****_****");

	 JLabel labelpn = new JLabel("PN");
	 JPanel container = new JPanel();
	 JLabel label = new JLabel("wight");
	 JButton go = new JButton ("GO!");
	 JButton file1 = new JButton (" ADD FILE 1 ");
	 JButton file2 = new JButton (" ADD FILE 2 ");
	 JTextArea text1 = new JTextArea("");
	 JTextArea text2 = new JTextArea("");
	 
	 String str1 = "";
	 String str2 ="";
	 String choixlcs="";
	 String choixpn="";
	 String strRes = "";
	 int LongLigne;
	
	 JTextField weight = new JTextField();
	
	 public MyVisio(){
		
		  this.setTitle("My Algo Program");
		    this.setSize(1200, 400);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    container.setBackground(Color.white);
		    container.setLayout(new BorderLayout());
		    combolcs.setPreferredSize(new Dimension(200, 20));
		    combopn.setPreferredSize(new Dimension(200, 20));
		    weight.setPreferredSize(new Dimension(200,20));
		    labelRes.setSize(600, 300);
		    labelRes.setEditable(false);
		    labelRes.setBackground(Color.LIGHT_GRAY);
		    labelRes.setLineWrap(true);
		    JScrollPane scrollPane3 = new JScrollPane(labelRes, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		    JScrollPane scrollPane1 = new JScrollPane(text1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			 JScrollPane scrollPane2 = new JScrollPane(text2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			 scrollPane1.setPreferredSize(new Dimension(500,250));
			 scrollPane2.setPreferredSize(new Dimension(500,250));
			 scrollPane3.setPreferredSize(new Dimension(800,300));

	
		    JPanel top = new JPanel();
		    JPanel buttom=new JPanel();
		    JPanel center=new JPanel();
		   
		    top.add(labellcs);
		    top.add(combolcs);
		    top.add(labelpn);
		    top.add(combopn);
		    top.add(label);
		    top.add(weight);
		    
		    buttom.add(go);
		
		    center.add(scrollPane1);
		    center.add(scrollPane2);
		    center.add( scrollPane3);
		    //center.add(choix);
		   // result.add(text3);
		   // result2.add(text4);
		    //center.add(text4);
		    
		    container.add(top, BorderLayout.NORTH);
		    container.add(buttom, BorderLayout.SOUTH);
		    container.add(file2, BorderLayout.EAST);
		    container.add(file1, BorderLayout.WEST);
		    container.add(center, BorderLayout.CENTER);
		    this.setContentPane(container);
		    this.setVisible(true); 
		    combolcs.addItem("Dynamic");
		    combolcs.addItem("Divide and conquer");
		    combolcs.addItem("branch and bound");
		    combopn.addItem("PNDynamic");
		    combopn.addItem("PNGreedy");
		    
		   
		    go.addActionListener(new Traitementgo());
		    combolcs.addItemListener(new ItemState());
		    
		    file1.addActionListener(new Traitementfile());
		    file2.addActionListener(new Traitementfile());
		   
		    
		   
        	  //récupérer le LCSChoix // 
        //	System.out.println(combolcs.getSelectedItem().toString());
        	
        	
        	//récupérer le weigt
        	
	 }
	 
	 private static String ReadFileOne(String path) throws FileNotFoundException, IOException {
	        String ch="";
	    BufferedReader br = new BufferedReader(new FileReader(path));
				try {
				    StringBuilder sb = new StringBuilder();
				    String line = br.readLine();

				    while (line != null) {
				        sb.append(line);
				        sb.append(System.lineSeparator());
				        line = br.readLine();
				    }
				     ch = sb.toString();
				} finally {
				    br.close();
				}
	                       ch=ch.replaceAll("\\r?\\n", " ");
	        return ch;
	    }
	 

	 
	 public  class   Traitementfile implements   ActionListener
	    {
	 public  void    actionPerformed(ActionEvent e1)
	    {
	        Object  source=e1.getSource();
	        
	        if  (source==file1){
	        	JFileChooser choix = new JFileChooser();
	        	 FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        		        "TXT", "txt");
	        		    choix.setFileFilter(filter);
	        	int retour=choix.showOpenDialog(getParent());
	        	if(retour==JFileChooser.APPROVE_OPTION){
	        	   // un fichier a été choisi (sortie par OK)
	        	   // nom du fichier  choisi 
	        	   choix.getSelectedFile().getName();
	        	   // chemin absolu du fichier choisi
	        	  String pathAb1 = choix.getSelectedFile().
     	          getAbsolutePath();
	        	   		//System.out.println( choix.getSelectedFile().
	        	         // getAbsolutePath());
	        	   		try {
							String var = ReadFileOne(pathAb1);
							//System.out.println(var);
							text1.setText(var);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        	}
	        	}
	        	 if  (source==file2){
	 	        	JFileChooser choix2 = new JFileChooser();
	 	        	int retour2=choix2.showOpenDialog(getParent());
	 	        	if(retour2==JFileChooser.APPROVE_OPTION){
	 	        	   
	 	        	   choix2.getSelectedFile().
	 	        	          getAbsolutePath();
	 	        	  FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
		        		        "TXT", "txt");
	 	        	 choix2.setFileFilter(filter2);
	 	        	  String pathAb2 = choix2.getSelectedFile().
	 	        	          getAbsolutePath();
	 	   	        	   		System.out.println( choix2.getSelectedFile().
	 	   	        	          getAbsolutePath());
	 	   	        	   		try {
	 	   							String var2 = ReadFileOne(pathAb2);
	 	   							//System.out.println(var2);
	 	   							text2.setText(var2);
	 	   						} catch (IOException e) {
	 	   							// TODO Auto-generated catch block
	 	   							e.printStackTrace();
	 	   						}
	 	        	}
	        }
	        }
	 }
	 public  class   Traitementgo implements   ActionListener
	    {
	 public  void    actionPerformed(ActionEvent e)
	    {
	        Object  source=e.getSource();
	        
	        if  (source==go){
	        	
	        	//***************************et que les choses dures commencent*******
	        	choixlcs = combolcs.getSelectedItem().toString();
	        	 //récupérer le PNChoix // 
	        	//System.out.println(combopn.getSelectedItem().toString());
	        	choixpn = combopn.getSelectedItem().toString();
	        	
	        	 //récupérer le texte 1 // 
      		    str1 = text1.getText();
              	//récupérer le texte 2 // 
      		    str2 = text2.getText();
      		    
      		    LongLigne = Integer.parseInt(weight.getText());
      		    
	        	  if (choixlcs=="Dynamic") {
	        		 
	        	    	 long debut = System.currentTimeMillis();
	        	    	 strRes +="\n"+"**_** LCS Dynamic **_**"+"\n\n";
	        	    	 LCSDouble dlcs = new LCSDouble();
	        	    	 ArrayList<String> str3=dlcs.LCS(str1 , str2);
	        	    	 String str5 = str3.toString().replaceAll("\\[|\\]",  "").replaceAll(", " , " ");
	        	    	 strRes +="\n*** Votre LCS Dynamic est ... "+str5;
	        	    	 double i1 =str1.length();
	        	         double i2 =str5.length();
	        	         strRes += "\n la longueur de votre test est de :"+i1; 
                         strRes += "\n la longueur de votre LCS est de :"+i2;
	        	         
	        	         float f1 = dlcs.pourcentage(i2, i1);
	        	         strRes +="\n*** Votre LCS Dynamic Pourcentage est ... "+f1;
	        	         strRes +="\n Le temps d'exécution est de **-** "+ "\n";
	        	         strRes +=System.currentTimeMillis()-debut + "\n\n";
	        	         
	        	         
	        	         if (choixpn=="PNDynamic") {
	        	         
	        	     strRes +="\n"+"********Printing Neatly Dynamic ***************"+"\n\n";
	        	     long debut2 = System.currentTimeMillis();
	        	   	 strRes +="\nOn va l'afficher suivant la méthode PN Dynamic ..."+"\n\n";
	        	     PNDynamic pnd = new PNDynamic();
	        	     String str10 =pnd.WritePNDynamic(str5 , LongLigne);
	        	     strRes +="\n"+str10+"\n\n";
	        	     strRes +="\n"+"**_** temps d'exéction **_**\n";
	        	     strRes += System.currentTimeMillis()-debut2 ;
	        	     labelRes.setText(strRes);
	        	         }
	        	         
	        	         
	        	         
	        	         if (choixpn=="PNGreedy") {
	        	        	 
	        	        	 strRes +="\n"+"********Printing Neatly Greedy version ***************"+"\n\n";
	        	        	 long debut2 = System.currentTimeMillis();
	        	        	 strRes +="\nOn va l'afficher suivant la méthode PN Greedy ..."+"\n\n";
	        	        	 PNGreedy png = new PNGreedy();
	        	        	 String str10 = png.print(str5, LongLigne);
	        	        	 strRes +="\n"+str10+"\n\n";
	    	        	     strRes +="\n"+"**_** temps d'exéction **_**\n";
	    	        	     strRes += System.currentTimeMillis()-debut2 ;
	    	        	     labelRes.setText(strRes);
	    	        	         }
	        	        	 
	        	        	 
	        	         
	        	  }
	        	     if (choixlcs=="branch and bound") {
		        	      
	        	    	 long debut3 = System.currentTimeMillis();
	        	    	 Branchandbound bblcs = new Branchandbound();
	        	    	 String strBB = bblcs.LCS_R(str1 , str2);
	        	    	 strRes+="*** Votre LCS B&B est ... "+strBB;
	        	    	 double i3 =str1.length();
	        	         double i4 =strBB.length();
	        	         strRes += "\n la longueur de votre test est de :"+i3; 
                         strRes += "\n la longueur de votre LCS est de :"+i4;
	        	         
	        	         float fBB = bblcs.pourcentage(i4, i3);
	        	         strRes+="\n*** Votre LCS B&B est ... "+fBB+" % ";
	        	         strRes+="Le temps d'exécution est de **-** ";
	        	         strRes+=System.currentTimeMillis()-debut3 + "millisecondes";
	        	         
	        	         
	        	         if (choixpn=="PNDynamic") {
		        	         
		        	     strRes +="\n"+"********Printing Neatly Dynamic ***************"+"\n\n";
		        	     long debut2 = System.currentTimeMillis();
		        	   	 strRes +="\nOn va l'afficher suivant la méthode PN Dynamic ..."+"\n\n";
		        	     PNDynamic pnd = new PNDynamic();
		        	     String str10 =pnd.WritePNDynamic(strBB , LongLigne);
		        	     strRes +="\n"+str10+"\n\n";
		        	     strRes +="\n"+"**_** temps d'exéction **_**\n";
		        	     strRes += System.currentTimeMillis()-debut2 ;
		        	     labelRes.setText(strRes);
		        	         }
		        	         
		        	         
		        	         
		        	         if (choixpn=="PNGreedy") {
		        	        	 
			        	        	 
			        	        	 strRes +="\n"+"********Printing Neatly Greedy version ***************"+"\n\n";
			        	        	 long debut2 = System.currentTimeMillis();
			        	        	 strRes +="\nOn va l'afficher suivant la méthode PN Greedy ..."+"\n\n";
			        	        	 PNGreedy png = new PNGreedy();
			        	        	 String str10 = png.print(strBB, LongLigne);
			        	        	 strRes +="\n"+str10+"\n\n";
			    	        	     strRes +="\n"+"**_** temps d'exéction **_**\n";
			    	        	     strRes += System.currentTimeMillis()-debut2 ;
			    	        	     labelRes.setText(strRes);
			    	        	         }
	        	     }
	        	     
	        	     
	        	     if (choixlcs=="Divide and conquer"){ 
	        	    	 strRes+=" **_** Divide and Conquer **_** \n";
	        	    	 long debut5 = System.currentTimeMillis();
	        	    	 DivideAndConquer ddlcs = new DivideAndConquer();
	        	    	 String str170 = ddlcs.lcsDv(str1 , str2);
	        	    	 strRes+="*** Votre LCS D&D est ... "+str170+"\n";
	        	    	 double i5 =str1.length();
	        	         double i6 =str170.length();
	        	         strRes += "\n la longueur de votre test est de :"+i5; 
                         strRes += "\n la longueur de votre LCS est de :"+i6;
	        	         float f2 = ddlcs.pourcentage(i6, i5);
	        	         strRes+="\n *** Votre LCS B&B est ... "+f2+" % ";
	        	         strRes+="\n Le temps d'exécution est de **-** ";
	        	         strRes+=System.currentTimeMillis()-debut5;
	        	        
	        	   	     
	        	   	 
	        	   	  if (choixpn=="PNDynamic") {
		        	         
		        	     strRes +="\n"+"********Printing Neatly Dynamic ***************"+"\n\n";
		        	     long debut2 = System.currentTimeMillis();
		        	   	 strRes +="\nOn va l'afficher suivant la méthode PN Dynamic ..."+"\n\n";
		        	     PNDynamic pnd = new PNDynamic();
		        	     String str10 =pnd.WritePNDynamic(str170 , LongLigne);
		        	     strRes +="\n"+str10+"\n\n";
		        	     strRes +="\n"+"**_** temps d'exéction **_**\n";
		        	     strRes += System.currentTimeMillis()-debut2 ;
		        	     labelRes.setText(strRes);
		        	         }
		        	         
		        	         
		        	     
		        	        	 if (choixpn=="PNGreedy") {
			        	        	 
			        	        	 strRes +="\n"+"********Printing Neatly Greedy version ***************"+"\n\n";
			        	        	 long debut2 = System.currentTimeMillis();
			        	        	 strRes +="\nOn va l'afficher suivant la méthode PN Greedy ..."+"\n\n";
			        	        	 PNGreedy png = new PNGreedy();
			        	        	 String str10 = png.print(str170 , LongLigne);
			        	        	 strRes +="\n"+str10+"\n\n";
			    	        	     strRes +="\n"+"**_** temps d'exéction **_**\n";
			    	        	     strRes += System.currentTimeMillis()-debut2 ;
			    	        	     labelRes.setText(strRes);
			    	        	         }
		        	     
	        	   	  }
	        	   }
	        	     
	        
	        	//*****************************************FIN***********************
	        	
	         }
          } 
	    }

	  //Classe interne implémentant l'interface ItemListener
	  class ItemState implements ItemListener{
	    public void itemStateChanged(ItemEvent e) {
	   //   System.out.println("événement déclenché sur : " + e.getItem());
	    }               
	  }

