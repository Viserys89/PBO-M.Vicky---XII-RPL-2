import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        boolean repeat = true;
        System.out.println("Selamat datang di Mini Calculator!!!");

        while(repeat){
            System.out.println("Masukan angka pertama :");
            int firstNum = userInput.nextInt();
            System.out.println("Masukan angka kedua : ");
            int secondNum = userInput.nextInt();
            System.out.println("Silahkan pilih operasi yang di inginkan : \n 1.Pertambahan \n 2.Pengurangan \n 3.Perkalian \n 4.Pembagian");
            int operation = userInput.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Hasil pertambahan dari " + firstNum + " dan " + secondNum + " adalah " + (firstNum + secondNum));
                    break;
                case 2:
                    System.out.println("Hasil perkalian dari " + firstNum + " dan " + secondNum + " adalah " + (firstNum - secondNum));
                    break;
                case 3:
                    System.out.println("Hasil perkalian dari " + firstNum + " dan " + secondNum + " adalah " + (firstNum * secondNum));
                    break;
                case 4:
                    System.out.println("Hasil perkalian dari " + firstNum + " dan " + secondNum + " adalah " + (firstNum / secondNum));
                    break;
                default:
                    System.out.println("Masukan pilihan yang benar!");
                    break;
            }
            System.out.println("Ingin melakukan operasi lagi? \n (y/n)");
            userInput.nextLine();
            String choice = userInput.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                repeat = false;
                System.out.println("Baik, Terimakasih!");
            }
        }
        userInput.close();
    }
}