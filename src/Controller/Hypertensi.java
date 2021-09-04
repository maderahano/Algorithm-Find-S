package Controller;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author Made Rahano Satryani Widhi
 * @NRP 2110191028
 * @kelas 3 D4 IT A
 */
public class Hypertensi {
    private static String[][] dataTraining = {
        {"Muda", "Gemuk", "Tidak"},
        {"Muda", "Sangat Gemuk", "Tidak"},
        {"Paruh Baya", "Gemuk", "Tidak"},
        {"Paruh Baya", "Terlalu Gemuk", "Ya"},
        {"Tua", "Terlalu Gemuk", "Ya"}
    };
    private static int jumlahBaris = dataTraining.length;
    private static int jumlahKolom = dataTraining[0].length;
    private static String[] hipotesis = new String[jumlahKolom-1];
    
    public static void main(String[] args) {
        String Target;
        
        Target = "Ya";
        findS(Target);
        inputDataTesting();
    }
    
    private static void inputDataTesting() {
        Scanner input = new Scanner(System.in);
        String[] dataTesting = new String[jumlahKolom-1];
        boolean[] check = new boolean[jumlahKolom-1];
        boolean result = true;
        
        do{
            System.out.print("Umur (Muda/Paruh Baya/Tua)\t\t: ");
            dataTesting[0] = input.nextLine();
            if (dataTesting[0].equalsIgnoreCase("Muda") || 
                    dataTesting[0].equalsIgnoreCase("Paruh Baya") || 
                    dataTesting[0].equalsIgnoreCase("Tua")) {
                check[0] = true;
            } else {
                System.out.println("Wrong Input!\n");
                dataTesting[0] = "";
            }
        }while(check[0] == false);
        
        do{
            System.out.print("Kegemukan (Gemuk/Sangat Gemuk/Terlalu Gemuk)\t: ");
            dataTesting[1] = input.nextLine();
            if (dataTesting[1].equalsIgnoreCase("Gemuk") || 
                    dataTesting[1].equalsIgnoreCase("Sangat Gemuk") ||
                    dataTesting[1].equalsIgnoreCase("Terlalu Gemuk")) {
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
            System.out.println("Hipertensi? = Ya");
        else
            System.out.println("Hipertensi? = Tidak");
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
