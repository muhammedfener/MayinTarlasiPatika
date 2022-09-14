import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int a,b,satir,sutun;
        Scanner inp = new Scanner(System.in);
        System.out.print("Yükseklik Girin: ");
        a = inp.nextInt();
        System.out.print("Genişlik Girin: ");
        b = inp.nextInt();
        MineSweeper game = new MineSweeper(a,b);
        while(true){
            game.TarlaYazdir();
            System.out.print("Satır Giriniz: ");
            satir = inp.nextInt();
            System.out.print("Sütun Giriniz: ");
            sutun = inp.nextInt();
            String sonuc = game.HucreKontrol(satir-1,sutun-1);
            if(sonuc.equals("Oyunu Kaybettiniz.")){
                System.out.print(sonuc + "\n");
                System.out.print("===========================\n");
                break;
            }else{
                boolean result = game.WinKontrol();
                if(result){
                    System.out.println("Oyunu Kazandınız!");
                    game.TarlaYazdir();
                    break;
                }
                System.out.print("===========================\n");
            }
        }

    }
}
