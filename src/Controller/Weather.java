package Controller;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author Made Rahano Satryani Widhi
 * @NRP 2110191028
 * @kelas 3 D4 IT A
 */
public class Weather {
    private static String[][] dataTraining = {
        {"Sunny", "Warm", "Normal", "Strong", "Warm", "Same", "Yes"},
        {"Sunny", "Warm", "High", "Strong", "Warm", "Same", "Yes"},
        {"Rainy", "Cold", "High", "Strong", "Warm", "Change", "No"},
        {"Sunny", "Warm", "High", "Strong", "Cool", "Change", "Yes"}
    };
    private static int jumlahBaris = dataTraining.length;
    private static int jumlahKolom = dataTraining[0].length;
    private static String[] hipotesis = new String[jumlahKolom-1];
    
    public static void main(String[] args) {
        findS();
        inputDataTesting();
    }
    
    private static void inputDataTesting() {
        Scanner input = new Scanner(System.in);
        String[] dataTesting = new String[jumlahKolom-1];
        boolean[] check = new boolean[jumlahKolom-1];
        boolean result = true;
        
        do{
            System.out.print("Sky (Sunny/Rainy)\t: ");
            dataTesting[0] = input.nextLine();
            if (dataTesting[0].equalsIgnoreCase("Sunny") || 
                    dataTesting[0].equalsIgnoreCase("Rainy")) {
                check[0] = true;
            } else {
                System.out.println("Wrong Input\n");
                dataTesting[0] = "";
            }
        }while(check[0] == false);
        
        do{
            System.out.print("AirTemp (Warm/Cold)\t: ");
            dataTesting[1] = input.nextLine();
            if (dataTesting[1].equalsIgnoreCase("Warm") || 
                    dataTesting[1].equalsIgnoreCase("Cold")) {
                check[1] = true;
            } else {
                System.out.println("Wrong Input\n");
                dataTesting[1] = "";
            }
        }while(check[1] == false);
        
        do{
            System.out.print("Humidity (Normal/High)\t: ");
            dataTesting[2] = input.nextLine();
            if (dataTesting[2].equalsIgnoreCase("Normal") || 
                    dataTesting[2].equalsIgnoreCase("High")) {
                check[2] = true;
            } else {
                System.out.println("Wrong Input\n");
                dataTesting[2] = "";
            }
        }while(check[2] == false);
        
        do{
            System.out.print("Wind (Strong/Weak)\t: ");
            dataTesting[3] = input.nextLine();
            if (dataTesting[3].equalsIgnoreCase("Strong") || 
                    dataTesting[3].equalsIgnoreCase("Weak")) {
                check[3] = true;
            } else {
                System.out.println("Wrong Input\n");
                dataTesting[3] = "";
            }
        }while(check[3] == false);
        
        do{
            System.out.print("Water (Warm/Cool)\t: ");
            dataTesting[4] = input.nextLine();
            if (dataTesting[4].equalsIgnoreCase("Warm") || 
                    dataTesting[4].equalsIgnoreCase("Cool")) {
                check[4] = true;
            } else {
                System.out.println("Wrong Input\n");
                dataTesting[4] = "";
            }
        }while(check[4] == false);
        
        do{
            System.out.print("Forecast (Same/Change)\t: ");
            dataTesting[5] = input.nextLine();
            if (dataTesting[5].equalsIgnoreCase("Same") || 
                    dataTesting[5].equalsIgnoreCase("Change")) {
                check[5] = true;
            } else {
                System.out.println("Wrong Input\n");
                dataTesting[5] = "";
            }
        }while(check[5] == false);
        
        for(int i = 0; i < jumlahKolom-1; i++) {
            if(!hipotesis[i].equals("?") && 
                    !dataTesting[i].equals(hipotesis[i]))
                result = false;
        }
        
        if (result)
            System.out.println("Enjoy Sport? = Yes");
        else
            System.out.println("Enjoy Sport? = No");
    }
    
    private static void findS() {
        System.out.print("Hipotesis (Yes) : ");
        int indeks = 0;
        
        for (int i = 0; i < jumlahBaris; i++) {
            if (dataTraining[i][jumlahKolom-1].equals("Yes")) {
               indeks = i;
               break;
            }
        }
        
        System.arraycopy(dataTraining[indeks], 0, hipotesis, 0, jumlahKolom-1);
        
        for (int i = 1; i < jumlahBaris; i++) {
            if (dataTraining[i][jumlahKolom-1].equals("Yes")) {
                for (int j = 0; j < jumlahKolom-1; j++) {
                    if (!hipotesis[j].equals(dataTraining[i][j]))
                        hipotesis[j] = "?";
                }
            }
        }
        
        for (String hasilHipotesis : hipotesis)
            System.out.print("("+hasilHipotesis+")");
        System.out.println("");
    }
}
