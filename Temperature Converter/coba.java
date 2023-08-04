import java.util.Scanner;

public class coba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan jumlah celcius: ");

        int celsius = scanner.nextInt();
        int fahrenheit = (celsius * 9 / 5) + 32;
        int kelvin = celsius + 273;
        System.out.println("Suhu dalam farenheit adalah: " + fahrenheit );
        System.out.println("Suhu dalam kelvin adalah: " + kelvin );
        scanner.close();
    }
}