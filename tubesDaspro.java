import java.util.Scanner;
public class tubesDaspro {
    
   



    static boolean cekLogin, menuJalan, programJalan = true;
    static int menu, denda, perpanjangan;
    static String nim, kodeBarang;
    static String dataBarang[][] = {{"A1", "Buku Novel A", "5"}, {"B1", "Buku Novel B", "3"}};
    static String dataPeminjaman[][] = new String[4][50];;
    static String dataMahasiwa[][] = new String[2][50];
    static private String dataUser[] = {"rani","123"};
    static private String dataLogin[] = new String[2];

    static boolean cekLogin(String username, String pass){
        if(username.equals(dataUser[0]) && pass.equals(dataUser[1])){
            return true;
        }else{
            return false;
        }
    }

    static void getDataBarang(){
        System.out.println("=== Daftar Barang ===");
        System.out.print("No\tKode Barang\tNama Barang\tStok Barang");
        for(int i = 0; i < dataBarang.length; i++){
            System.out.printf("\n%d\t%s\t\t%s\t%s", (i+1), dataBarang[i][0], dataBarang[i][1], dataBarang[i][2]);
        }
    }

        static void pinjamBarang(){
        Scanner input = new Scanner(System.in);
        System.out.println("=== Menu Pinjam Barang ===");
        getDataBarang();
        int tanggalPinjam=0;
        String pjmLagi;
        int k=0;
        int barangKembali=0;
        int nim=0;

        do{
        System.out.print("\nMasukkan NIM : ");
        nim = input.nextInt();
        dataPeminjaman[k][0] = Integer.toString(nim);
        input.nextLine();
        System.out.print("Masukkan kode barang : ");
        dataPeminjaman[k][1] = input.nextLine();
        
        do{
        System.out.print("Masukkan tanggal pinjam [1-31] : ");    
        tanggalPinjam = input.nextInt();    
        if(tanggalPinjam<=0||tanggalPinjam>=31){
            System.out.println("Tanggal Salah!");
        }
        }while(tanggalPinjam<=0||tanggalPinjam>31);
         dataPeminjaman[k][2] = Integer.toString(tanggalPinjam);
        if(tanggalPinjam<25){
           barangKembali = tanggalPinjam+7; 
        }else{
            barangKembali = (tanggalPinjam+7)-30;
        }
        dataPeminjaman[k][3] = Integer.toString(barangKembali);
        k++;
        
        input.nextLine();
        System.out.println("Apakah ada barang yang ingin dipinjam lagi? (y/t) ");
        pjmLagi = input.nextLine();
         
    }while(pjmLagi.equalsIgnoreCase("y"));
    System.out.println("========= Daftar Barang yang telah Dipinjam =========");
    System.out.printf("%-10s %10s %10s %10s\n","NIM","Kode Barang","Tanggal Pinjam","Tanggal Kembali");
    System.out.println("=====================================================");
    for(int i = 0;i < k; i++){
        System.out.printf("%-10s %-10s %10s %10s\n",dataPeminjaman[i][0],dataPeminjaman[i][1],dataPeminjaman[i][2],dataPeminjaman[i][3]);
    }
    }

        public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String divider = " ====================================";

        System.out.printf("%s\n Selamat Datang di Sistem Peminjaman \n%s", divider, divider);

        while(programJalan){
            System.out.println("\nMenu: \n1. Login \n2. Keluar Program");
            System.out.print("Masukkan menu yang ingin dipilih: ");
            menu = input.nextInt();
            input.nextLine();

            switch(menu){
                case 1:
                System.out.print("Masukkan username anda: ");
                dataLogin[0] = input.nextLine();
                System.out.print("Masukkan password anda: ");
                dataLogin[1] = input.nextLine();
                cekLogin = cekLogin(dataLogin[0], dataLogin[1]);

                if(cekLogin){
                    menuJalan = true;
                    System.out.println("Selamat Datang");
                    while(menuJalan){
                        System.out.printf("\nSilahkan pilih menu dibawah:" +
                                           "\n1. Menu Data Master Barang" +
                                           "\n2. Menu Input Peminjaman" +
                                           "\n3. Menu Input Pengembalian" +
                                           "\n4. Logout");
                        System.out.print("\nMasukkan menu: ");
                        menu = input.nextInt();
                        input.nextLine();
                        switch(menu){
                            case 1:
                            getDataBarang();
                            System.out.printf("\nSilahkan pilih menu dibawah:" +
                                           "\n1. Input Barang" +
                                           "\n2. Edit Barang" +
                                           "\n3. Kembali ke menu utama");
                            System.out.print("\nMasukkan menu: ");
                            menu = input.nextInt();
                            input.nextLine();
                            break;

                            case 2:
                            System.out.println("Masuk pinjam");
                            pinjamBarang();
                            break;

                            case 3:
                            System.out.println("Masuk kembali");
                            break;

                            case 4:
                            menuJalan = false;
                            break;

                            default:
                            System.out.println("Maaf, mohon cek kembali menu yang ingin dipilih");
                            break;
                        }
                    }
                }else{
                    System.out.println("Maaf password salah");
                }
                break;

                case 2:
                programJalan = false;
                break;

                default:
                System.out.println("Maaf, menu yang anda masukkan salah");
                break;
            }
        }
    }
}

