
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
     
    public static void bahsısAt(String para,int bah,String countryname){//overloading
 
        System.out.println(countryname+" isimli ülkenin parası olan "+para+" ile bahsis olarak "+bah+" alınmıstır");
        
        }
     
    public static void bahsısAt(String para,int bah){//overloading
        if(para.equals("€")){
            System.out.println("alının bahsis : "+bah+" tl "+para+" cinsindendir.");
        }else if(para.equals("$")){
            System.out.println("alının bahsis : "+bah+" tl "+para+" cinsindendir.");
        }else{
            System.out.println("yanlış yada hatalı bir tuslama yaptınız");
            
        }
        
    }

    public static int bahsısAt(int bah){
        return bah;
    }

    public static void main(String[] args) throws InterruptedException {
       Scanner scn = new Scanner(System.in);
       Queue<String> araba = new LinkedList<String>();
       Queue<String> isim = new LinkedList<String>();
       Queue<String> yapılanIslem = new LinkedList<String>();
       
       Random fiyat = new Random();
       int fatura = fiyat.nextInt(50000);
       
       String islemler ="1) Araç Kayıt,Istek Islem\n"
               + "2)Islem Kuyruğu Görüntüle\n"
               + "3)Islemler Görüntüle\n"
               + "4)Fıyat Listesi\n"
               + "5)Bahsis at\n"
               + "6)rastgele bahsis at\n"
               + "7)€ ile yada $ bahsis ver(ısın hızlansın)\n+"
               + "8) Farklı bir para birimi ile bahsis var\n"
               + "q)ile sistemden cık";
       
        System.out.println(islemler);
       while(true){
           System.out.println("Yapmak İstediğiniz işlemi giriniz :");
           String secim = scn.nextLine();
        
            if(secim.equals("1")){
                try(FileWriter fw = new FileWriter("MusteriBilgi.txt",true)){
                    System.out.println("araç markası : ");
                    String fwarac = scn.nextLine();
                    araba.offer(fwarac);
                    System.out.println("araç sahibi : ");
                    String fwisim = scn.nextLine();
                    isim.offer(fwisim); 
                    while(true){

                    System.out.println("Yaptırılmak istenen işlemler11");
                    String isString = scn.nextLine();
                    yapılanIslem.offer(isString);
                    if(isString.equals("-1")){
                        System.out.println("İşlem Sonlandırılıyor.");
                        Thread.sleep(1500);
                        break;
                    }
                    fw.write(fwarac+","+fwisim+","+isString+"\n");
                   }

               } catch (IOException ex) {
                   System.out.println("Dosya Açılırken Bir Sorunla Karşılaşıldı");
               }
           }else if(secim.equals("q")){
                System.out.println("Sistemden çıkış Gerçekleşiyor Lütfen Bekleyiniz.");
                Thread.sleep(1500);
                System.out.println("this program is programmed by hlbr");
                break;
           }else if(secim.equals("3")){
                System.out.println("****************************************");
                System.out.println(islemler);
                System.out.println("****************************************");
           }else if(secim.equals("4")){
                System.out.println("Fiyat Listesi Getiriliyor.Lütfen Bekleyiniz...");
                
                Thread.sleep(1500);
                try(Scanner f_Liste = new Scanner(new FileReader("fliste.txt"))){
                    while(f_Liste.hasNextLine()){
                       // System.out.println(f_Liste.nextLine());
                       String fliste = f_Liste.nextLine();
                       String[] fStrings =fliste.split(",");
                        System.out.println("İşlem : "+fStrings[0]+"ücret : " +fStrings[1]+" tl");
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("Okunacak Dosya Bulunamadı");
               }
           }else if(secim.equals("2")){
                 try(Scanner f_Liste = new Scanner(new FileReader("MusteriBilgi.txt"));
                    FileWriter fw = new FileWriter("MusteriBilgi.txt",true)){
                    while(f_Liste.hasNextLine()){
                       // System.out.println(f_Liste.nextLine());
                       String fliste = f_Liste.nextLine();
                       String[] fStrings =fliste.split(",");
                       System.out.println(fStrings[0]+" markalı araba " +fStrings[1]+" araç sahibi "+fStrings[2]+" istenen işlem");
                        Thread.sleep(1200);
                    }
                }catch (FileNotFoundException ex) {
                    System.out.println("Okunacak Dosya Bulunamadı");
                }catch (IOException ex) {
                    System.out.println("Dosya açılırken sorun meydana geldi");
                }catch(NullPointerException ex){
                    System.out.println("bos nokta hatası");
               }
           }else if(secim.equals("5")){
               String bahString = scn.nextLine();
               int a =  Integer.valueOf(bahString);
               if(a == 0){
                   System.out.println("Aracınızın Teslim süresi uzatılıyor...\n"
                           + "Lütfen Ostim esnafının canını Sıkmayınız.");
              break;
               }
                System.out.println("atılan bahsis : " +bahsısAt(a)+" tl ");

           }else if(secim.equals("6")){
               Random r = new Random();
               int a =1 + r.nextInt(5000);
                System.out.println("atılan bahsıs : "+bahsısAt(a)+" tl ");
                
           }else if(secim.equals("7")){
                System.out.println("Lütfen bahsis mikatını yazınız : ");
                String b = scn.nextLine();//nextLıne yaparak bazı karmaşaları önlüyoruz
                int bb = Integer.valueOf(b);
                System.out.println("lütfen bahsis vermek istediğiniz para birimini giriniz");
                String c = scn.nextLine();
                bahsısAt(c, bb);
                
           }else if(secim.equals("8")){
                System.out.println("Lütfen bahsis mikatını yazınız : ");
                String b = scn.nextLine();//nextLıne yaparak bazı karmaşaları önlüyoruz
                int bb = Integer.valueOf(b);
                System.out.println("lütfen bahsis vermek istediğiniz para birimini giriniz");
                String c = scn.nextLine();
                System.out.println("paranın verildiği ülke adı ");
                String adss = scn.nextLine();
                bahsısAt(c, bb,adss);
           }
               
            
       }
        
    }
    
}
