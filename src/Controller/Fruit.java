package Controller;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author Made Rahano Satryani Widhi
 * @NRP 2110191028
 * @kelas 3 D4 IT A
 */
public class Fruit {
    private static String[][] dataTraining = {
        {"Panjang", "Panjang", "Pisang"},
        {"Panjang", "Pendek", "Pisang"},
        {"Pendek", "Pendek", "Apel"}
    };
    private static int jumlahBaris = dataTraining.length;
    private static int jumlahKolom = dataTraining[0].length;
    private static String[] hipotesis = new String[jumlahKolom-1];
    
    public static void main(String[] args) {
        String Target;
        
        Target = "Pisang";
        findS(Target);
        inputDataTesting();
    }
    
    private static void inputDataTesting() {
        Scanner input = new Scanner(System.in);
        String[] dataTesting = new String[jumlahKolom-1];
        boolean[] check = new boolean[jumlahKolom-1];
        boolean result = true;
        
        do{
            System.out.print("Panjang (Panjang/Pendek)\t: ");
            dataTesting[0] = input.nextLine();
            if (dataTesting[0].equalsIgnoreCase("Panjang") || 
                    dataTesting[0].equalsIgnoreCase("Pendek")) {
                check[0] = true;
            } else {
                System.out.println("Wrong Input!\n");
                dataTesting[0] = "";
            }
        }while(check[0] == false);
        
        do{
            System.out.print("Lebar (Sedang/Pendek)\t: ");
            dataTesting[1] = input.nextLine();
            if (dataTesting[1].equalsIgnoreCase("Sedang") || 
                    dataTesting[1].equalsIgnoreCase("Pendek")) {
                check[1] = true;
            } else {
                System.out.println("Wrong Input\n");
                dataTesting[1] = "";
            }
        }while(check[1] == false);
        
        for(int i = 0; i < jumlahKolom-1; i++) {
            if(!hipotesis[i].equals("?") && 
                    !dataTesting[i].equals(hipotesis[i]))
                result = false;
        }
        
        if (result)
            System.out.println("Nama Buah = Pisang");
        else
            System.out.println("Nama Buah = Apel");
    }
    
    private static void findS(String Source) {
        String Target = Source;
        System.out.print("Hipotesis ("+Target+") : ");
        int indeks = 0;
        
        for (int i = 0; i < jumlahBaris; i++) {
            if (dataTraining[i][jumlahKolom-1].equals(Target)) {
               indeks = i;
               break;
            }
        }
        
        System.arraycopy(dataTraining[indeks], 0, hipotesis, 0, jumlahKolom-1);
        
        for (int i = 1; i < jumlahBaris; i++) {
            if (dataTraining[i][jumlahKolom-1].equals(Target)) {
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
