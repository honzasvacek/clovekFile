import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static Clovek arr[] = new Clovek[5];
    public static void main(String[] args) {

        /*if(file.exists()){
            System.out.println(file + " exists"); //kontroluje zda soubor existuje
        }*/

        try {
            File file = new File("C:\\Users\\oem\\Desktop\\data.txt"); //vytvoří soubor a argument je url souboru
            Scanner scanner = new Scanner(file); //scanner ktery bere vstup ze souboru
            int i = 0;
            while(scanner.hasNextLine()){
                String jmeno = scanner.next(); //čte jednotlivá slova
                String prijmeni = scanner.next();
                String vekStr = scanner.next();
                int vek = 0;
                try {
                    vek = Integer.parseInt(vekStr);
                }
                catch (Exception err){
                    System.out.println(err);
                }
                int str = Integer.parseInt(vekStr);
                //System.out.println(data);
                arr[i] = new Clovek(jmeno, prijmeni, vek);
                i++;
            }
        }
        catch (FileNotFoundException err) {
            System.out.println(err);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].prijmeni.compareTo(arr[j + 1].prijmeni) > 0){
                    Clovek c = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = c;
                }
                else if (arr[j].jmeno.compareTo(arr[j + 1].jmeno) > 0){
                    Clovek c = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = c;
                }
                else if (arr[j].vek > arr[j + 1].vek){
                    Clovek c = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = c;
                }

            }
        }




        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].jmeno + " ");
            System.out.print(arr[i].prijmeni + " ");
            System.out.print(arr[i].vek);
            System.out.println("");
        }

    }
}