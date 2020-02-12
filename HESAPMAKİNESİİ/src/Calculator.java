
    import javax.swing.*;
    import java.awt.Color;//renklendirme icin kullaanilan java kutuphanesi
    import java.util.Scanner;//sistemde yeni degerler olusturabilmek icin kullan?lan kutuphane genelde kullan?l?r
    import java.lang.System;//disalimin yapidigi varsayar
    import javax.swing.plaf.ColorUIResource;//panel renk tercihi icin kullan?lan kutuphane


    public class Calculator {//hesap makinesi sinif.

        private int sayi1;//hesap makinesinde kullanilacak sayiyi tanimladik.
        private int sayi2;//hesap makinesinde kullanilacak ikinci sayiyi kullandik
        private int sayi3;//faktoryel islemi icin kullanilacak sayiyi tanimladik
        private int secim;//hesap makinesinde sececegimiz degere gore islem yaptiriliyor
        private double sayi4;//ondalik sayilarin girilmesi icin ilk sayi tanimladik
        private double sayi5;//virgullu sayilarin kullanilabilmesi icin ikinci sayiyi tanimladik.
        private int userActionChoice;//kullanicinin secim yapamas?


        public void action() {//ikici sinifimiza calculator maine baglandik.
            disiplaymMenu();//menumuzun gorunecegi kisim.
            getUserAction();//hesap makinesi sinifin cagardik.
        }

        private void disiplaymMenu() {

            do {
                    UIManager uim = new UIManager ();
                    uim.put("OptionPane.background", new ColorUIResource(255, 0, 0));
                    uim.put ("Panel.background", new ColorUIResource (255,0,0));
                    UIManager.put("OptionPane.background", Color.DARK_GRAY);
                    UIManager.put("Panel.background", Color.cyan);
                    UIManager.put("Button.background", Color.pink);

                secim = Integer.parseInt(JOptionPane.showInputDialog(null, "LUTFEN YAPACAGINIZ ISLEMI SECINIZ... \n" +//hesap makinesi cal??t???nda c?k?cak menuyu ekrana yazd?rd?k
                        "1:toplama islemi\n" +
                        "2:Cikarma islemi\n" +
                        "3:Carpma islemi\n" +
                        "4:Bolme islemi\n" +
                        "5:Faktoryel hesapla\n" +
                        "6:Yuzde hesapla\n" +
                        "7:Sayinin ussunu aliniz\n" +
                        "8:Karekok hesapla\n" +
                        "9:Modu hesapla\n" +
                        "0:Sistemden cikis islemi\n", "HESAP MAKINESI", 1));

                if (secim == 1) {//toplama islemi icin iki sayi girdirdik ve sonucu istedik.

                    sayi1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Lutfen ilk sayiyi giriniz", "DEGER-1", 1));
                    sayi2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Lutfen ikinci sayiyi giriniz", "DEGER-2", 1));
                    JOptionPane.showMessageDialog(null, "Islem sonucu:  " + toplama(), "SONUC", 1);

                } else if (secim == 2) {//cikarma islemi icin iki sayi istedik ve sonucu aldik.

                    sayi1 = Integer.parseInt(JOptionPane.showInputDialog(null, "lutfen ilk sayiyi giriniz", "DEGER-1", 1));
                    sayi2 = Integer.parseInt(JOptionPane.showInputDialog(null, "lutfen ikinci sayiyi giriniz", "DEGER-2", 1));
                    JOptionPane.showMessageDialog(null, "Islem sonucu: " + cikarma(), "SONUC", 1);

                } else if (secim == 3) {//carpma islemi icin iki sayi istedik ve sonucu aldik.

                    sayi1 = Integer.parseInt(JOptionPane.showInputDialog(null, "lutfen ilk sayiyi giriniz", "DEGER-1", 1));
                    sayi2 = Integer.parseInt(JOptionPane.showInputDialog(null, "lutfen ikinci sayiyi giriniz", "DEGER-2", 1));
                    JOptionPane.showMessageDialog(null, "Islem sonucu: " + carpma(), "SONUC", 1);

                } else if (secim == 4) {//bolme islemi icin double ile tan?mlanan ki sayi aldik ve sonucu aldik

                    sayi4 = Double.parseDouble(JOptionPane.showInputDialog(null, "lutfen bolunen sayiyi giriniz", "DEGER-1", 1));
                    sayi5 = Double.parseDouble(JOptionPane.showInputDialog(null, "lutfen bolen sayiyi giriniz", "DEGER-2", 1));
                    if (sayi5 != 0) {
                        JOptionPane.showMessageDialog(null, "Islem sonucu: " + bolme(), "SONUC", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Hic Bir Sayi 0'a Bolunemez");
                    }

                } else if (secim == 5) {//faktoryel islemi icin bir sayi istedik ve sonucu ald?k

                    sayi3 = Integer.parseInt(JOptionPane.showInputDialog(null, "lutfen faktoryel icin bir sayi giriniz ", "DEGER", 1));
                    JOptionPane.showMessageDialog(null, "Islem sonucu: " + faktoryel(), "SONUC", 1);

                } else if (secim == 6) {//yuzde hesaplayabilmek icin double ile tan?mlanan iki sayi aldik ve sonucu cagardik.

                    sayi4 = Double.parseDouble(JOptionPane.showInputDialog(null, "lutfen yuzdesi alinacak sayiyi giriniz", "DEGER-1", 1));
                    sayi5 = Double.parseDouble(JOptionPane.showInputDialog(null, "lutfen alinacak yuzdeyi giriniz", "DEGER-2", 1));
                    JOptionPane.showMessageDialog(null, "Islem sonucu: " + yuzde(), "SONUC", 1);

                } else if (secim == 7) {//us alma islemi icin iki sayi aldik ve sonucu cagard?k.

                    sayi1 = Integer.parseInt(JOptionPane.showInputDialog(null, "lutfen  ussu alinacak sayiyi giriniz", "DEGER-1", 1));
                    sayi2 = Integer.parseInt(JOptionPane.showInputDialog(null, "lutfen alinacak ussu giriniz", "DEGER-2", 1));
                    JOptionPane.showMessageDialog(null, "Islem sonucu: " + usalma(), "SONUC", 1);

                } else if (secim == 8) {//karekok islemi icin double ile sayi cagardik ve sonucu aldik.

                    sayi4 = Double.parseDouble(JOptionPane.showInputDialog(null, "lutfen karekok icin bir sayi giriniz", "DEGER", 1));
                    JOptionPane.showMessageDialog(null, "Islem sonucu: " + karekok(), "SONUC", 1);

                } else if (secim == 9) {//mod islemi icin double ile tan?mlanan sayi4 ve sayi5 i cagardik ve karekok islemini cagard?k.

                    sayi4 = Double.parseDouble(JOptionPane.showInputDialog(null, "lutfen modu alinacak sayiyi giriniz", "DEGER-1", 1));
                    sayi5 = Double.parseDouble(JOptionPane.showInputDialog(null, "lutfen modu giriniz", "DEGER-2", 1));
                    JOptionPane.showMessageDialog(null, "Islem sonucu: " + mod(), "SONUC:", 1);

                } else if (secim == 0) {//menuden cikis yapabilmek icin bir 0'a basilmasi gerektiiini ekrana yazirdik.
                    JOptionPane.showMessageDialog(null, "Sistemden cikis yaptiniz", "CIKIS", 1);

                } else {//girilen secimler haricinde bir deger girildiginde uyari mesaji olusturduk.

                    JOptionPane.showMessageDialog(null, "Yanlis secim yaptiniz lutfen tekrar deneyiniz", "HATALI GIRIS", 1);
                }
            }
            while (secim >= 1);
        }


        private int getUserAction() {

            Scanner gettingUserAction = new Scanner(System.in);
            userActionChoice = gettingUserAction.nextInt();
            return userActionChoice;
        }

        public int toplama()//toplama isleminin hesabi
        {
            int  top;
            top=sayi1+sayi2;
            return top;
        }
        public int cikarma()//cikarma isleminin hesabi
        {   int   sonuc;
            sonuc=sayi1-sayi2;
            return sonuc;
        }

        public int carpma()//carpma isleminin yapildigi yer
        {
            int sonuc;
            sonuc=sayi1 * sayi2;
            return sonuc;
        }

        public double bolme()//bolme isleminin yapildigi yer
        {
            double sonuc=1;
            if (sayi5 != 0)
            {
                sonuc= sayi4 / sayi5;
            }
            return sonuc;
        }

        public int faktoryel()//faktoryel hesabinin tanimlandigi yer
        {
            int top=1 ;
            for (int i = 1; i <= sayi3; i++) {
                top = top * i;
            }
            return top;
        }

        public double yuzde()//yuzde islemlerinn tanimlandigi yer
        {
            double sonuc;
            sonuc= sayi4*sayi5/100;
            return sonuc;
        }

        public int usalma()//usalma islemlerinin tanimlandigi yer
        {
            int sonuc =1;
            for (int i = 0; i <= (sayi2 - 1); i++)
                if (sayi1 == 1) {
                    sonuc = 1;
                } else if (sayi1 == 0) {
                    sonuc = 0;
                }else if (sayi2 == 0) {
                    sonuc = 1;
                } else {
                    sonuc = sonuc * sayi1;
                }
            return sonuc;
        }

        public double karekok()//karekok isleminin tanimlandigi yer
        {
            double sonuc;
            sonuc=Math.sqrt(sayi4);
            return sonuc;
        }
        public double mod()//mod alma islemlerinin yapidigi yer
        {
            double sonuc;
            sonuc=sayi4%sayi5;
            return sonuc;

        }
    }














