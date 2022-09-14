import java.util.Random;

public class MineSweeper {
    public String[][] tarla;
    private int tarlayukseklik;
    private int tarlagenislik;
    public int[][] mayinlar;
    Random rand = new Random();
    public MineSweeper(int a, int b) {
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz!");
        tarla = new String[a][b];
        tarlayukseklik = a;
        tarlagenislik = b;
        for(int i=0;i<tarlayukseklik;i++){
            for(int j=0;j<tarlagenislik;j++){
                tarla[i][j] = "-";
            }
        }
        MayinKoy(a,b);
    }
    public void MayinKoy(int a, int b){
        int tarlaboyutu = a * b;
        int mayinsayisi = tarlaboyutu/4;
        mayinlar = new int[mayinsayisi][2];
        for(int i=0;i<mayinsayisi;i++){
            int mayinsatir = rand.nextInt(a);
            int mayinsutun = rand.nextInt(b);
            boolean mayinkontrol = Mayinvarmi(a,b);
            if(!mayinkontrol){
                mayinlar[i][0] = mayinsatir;
                mayinlar[i][1] = mayinsutun;
            }else{
                i--;
            }
        }
    }
    public void TarlaYazdir(){
        for(int i=0;i<tarlayukseklik;i++){
            for(int j=0;j<tarlagenislik;j++){
                System.out.print(tarla[i][j] + " ");
                if(j+1 == tarlagenislik && i+1 != tarlayukseklik){
                    System.out.print("\n");
                }
            }
        }
        System.out.print("\n");
    }
    public boolean Mayinvarmi(int a,int b){
        boolean result = false;
        for(int i=0;i< mayinlar.length;i++){
            if(mayinlar[i][0] == a && mayinlar[i][1] == b){
                result = true;
            }
        }
        return result;
    }
    public int CevreKontrol(int a,int b){
        int result = 0;
        System.out.println(tarlayukseklik + " " + tarlagenislik);
        for(int i=a-1;i<=a+1;i++){
            for(int j=b-1;j<=b+1;j++){
                if(Mayinvarmi(i,j)){
                    result++;
                }
            }
        }
        return result;
    }
    public String HucreKontrol(int a,int b){
        if(a>tarlayukseklik || b>tarlagenislik){
            return "Girilen Sayı Tarlanın Dışında!";
        }
        boolean mayinkontrol = Mayinvarmi(a,b);
        if(mayinkontrol){
            return "Oyunu Kaybettiniz.";
        }
        int cevredekibomba = CevreKontrol(a,b);
        tarla[a][b] = String.valueOf(cevredekibomba);
        return "Devam";
    }
    public boolean WinKontrol(){
        boolean result = false;
        int hucresayisi = (tarlagenislik*tarlayukseklik)- mayinlar.length;
        int doluhucre = 0;
        for(String[] i:tarla){
            for(String a:i){
                if(a != "-"){
                    doluhucre++;
                }
            }
        }
        if(hucresayisi == doluhucre){
            result = true;
        }
        return result;
    }
}
