import java.util.Scanner;

class Main{

    static boolean cekLogin, menuJalan, masterJalan, programJalan = true;
    static int menu, denda, perpanjangan;
    static String nim, kodeBarang;
    static String dataBarang[][] = new String[50][3];
    static String dataPeminjaman[][] = new String[50][4];;
    static String dataMahasiwa[][] = new String[50][2];
    static private String dataUser[] = {"rani","123"};
    static private String dataLogin[] = new String[2];
    static Scanner input = new Scanner(System.in);
    static String dummyData[][] = {{"A1", "Buku Novel A", "5"}, {"B1", "Buku Novel B", "3"}};

    static void initialize(){
        for(int i = 0; i < dummyData.length; i++){
            dataBarang[i][0] = dummyData[i][0];
            dataBarang[i][1] = dummyData[i][1];
            dataBarang[i][2] = dummyData[i][2];
        }
    }

    static boolean cekLogin(String username, String pass){
        if(username.equals(dataUser[0]) && pass.equals(dataUser[1])){
            return true;
        }else{
            return false;
        }
    }
    
    static void getDataBarang(){
        String leftAlignFormat = "| %-2d | %-4s | %-16s | %-4s |%n";
        System.out.println("\n=========== Daftar Barang =============");
        System.out.format("+----+------+------------------+------+%n");
        System.out.format("| No | Kode | Nama Barang      | Stok |%n");
        System.out.format("+----+------+------------------+------+%n");
        for(int i = 0; i < dataBarang.length; i++){
            if(dataBarang[i][0] != null){
                System.out.format(leftAlignFormat, (i+1), dataBarang[i][0], dataBarang[i][1], dataBarang[i][2]);
            }
        }
        System.out.format("+----+------+------------------+------+%n");
    }

    static void pinjamBarang(){
        Scanner input = new Scanner(System.in);
        System.out.println("=== Menu Pinjam Barang ===");
        
        getDataBarang();
        int tanggalPinjam=0;
        String pjmLagi;
        int k=0;
        int barangKembali=0;
        int kurangStok=0;

        do{
        System.out.print("Masukkan NIM : ");
        dataPeminjaman[k][0] = input.nextLine();
        System.out.print("Masukkan kode barang : ");
        dataPeminjaman[k][1] = input.nextLine();
    
        for(int j=0; j<dataBarang.length;j++){
            if(dataPeminjaman[k][1].equalsIgnoreCase(dataBarang[j][0])){
            kurangStok = Integer.parseInt(dataBarang[j][2]);
            kurangStok-=1;
            dataBarang[j][2] = Integer.toString(kurangStok);
              
           }else{
               System.out.println("Maaf Kode Tidak Valid");
           }
        }
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
       
        
        input.nextLine();
        System.out.println("Apakah ada barang yang ingin dipinjam lagi? (y/t) ");
        pjmLagi = input.nextLine();
        k++;
    
    }while(pjmLagi.equalsIgnoreCase("y"));
    System.out.println("========= Daftar Barang yang telah Dipinjam =========");
    System.out.printf("%-10s %10s %10s %10s\n","NIM","Kode Barang","Tanggal Pinjam","Tanggal Kembali");
    System.out.println("=====================================================");
    for(int i = 0;i < k; i++){
        System.out.printf("%-10s %-10s %10s %10s\n",dataPeminjaman[i][0],dataPeminjaman[i][1],dataPeminjaman[i][2],dataPeminjaman[i][3]);
    }
    }



    static void inputDataBarang(){
        String menuInput;
        for(int i = dummyData.length; i < dataBarang.length; i++){
            System.out.print("Masukkan kode barang: ");
            dataBarang[i][0] = input.nextLine();
            System.out.print("Masukkan nama barang: ");
            dataBarang[i][1] = input.nextLine();
            System.out.print("Masukkan stok barang: ");
            dataBarang[i][2] = input.nextLine();
            System.out.print("Apakah anda ingin lanjut melakukan input barang? (y/t): ");
            menuInput = input.nextLine();

            if(menuInput.equalsIgnoreCase("t")){
                break;
            }
        }
    }

    static void editDataBarang(){
        boolean editJalan, menuEditMaster = true;
        String kodeBarang, namaBarang, stokBarang, isContinue;
        int indexBarang = dataBarang.length+1;
        while(menuEditMaster){
            System.out.print("Masukkan kode barang yang ingin di edit: ");
            kodeBarang = input.nextLine();

            for(int i = 0; i<dataBarang.length; i++){
                if(dataBarang[i][0].equals(kodeBarang)){
                    indexBarang = i;
                    break;
                }
            }

            if(indexBarang != dataBarang.length+1){
                editJalan = true;
                while(editJalan){
                    String leftAlignFormat = "| %-4s | %-16s | %-4s |%n";
                    System.out.println("\nBarang yang ingin anda edit adalah: ");
                    System.out.format("+------+------------------+------+%n");
                    System.out.format("| Kode | Nama Barang      | Stok |%n");
                    System.out.format("+------+------------------+------+%n");
                    System.out.printf(leftAlignFormat, dataBarang[indexBarang][0], dataBarang[indexBarang][1], dataBarang[indexBarang][2]);
                    System.out.format("+------+------------------+------+%n");
        
                    System.out.println("\nApa yang ingin anda ubah?"+
                                        "\n1. Kode Barang" + 
                                        "\n2. Nama Barang" +
                                        "\n3. Stok Barang" +
                                        "\n4. Tidak ada");
                    System.out.print("Masukkan pilihan: ");
                    menu = input.nextInt();
                    input.nextLine();
    
                    switch (menu) {
                        case 1:
                            System.out.print("Kode baru: ");
                            kodeBarang = input.nextLine();
                            dataBarang[indexBarang][0] = kodeBarang;
                            break;
    
                        case 2:
                            System.out.print("Nama baru: ");
                            namaBarang = input.nextLine();
                            dataBarang[indexBarang][1] = namaBarang;
                            break;
    
                        case 3:
                            System.out.print("Stok baru: ");
                            stokBarang = input.nextLine();
                            dataBarang[indexBarang][2] = stokBarang;
                            break;
                        
                        case 4:
                            editJalan = false;
                            break;
                    
                        default:
                        System.out.println("Maaf, pilihan yang anda masukkan salah");
                            break;
                    }
                }
            }else{
                System.out.println("Maaf, kode barang yang anda masukkan salah");
            }

            System.out.println("Apakah ingin melakukan edit kembali? (y/t)");
            isContinue = input.nextLine();
            if(isContinue.equalsIgnoreCase("t")){
                menuEditMaster = false;
            }
        }
    }

    public static void main(String[] args){
        initialize();
        String divider = "=====================================";
        System.out.printf("%s\n Selamat Datang di Sistem Peminjaman \n%s", divider, divider);

        while(programJalan){
            System.out.println("\nMenu: \n1. Login \n2. Keluar Program");
            System.out.print("Masukkan menu yang ingin dipilih: ");
            menu = input.nextInt();
            input.nextLine();

            switch(menu){
                case 1:
                System.out.println("\n===== Login =====");
                System.out.print("Masukkan username anda: ");
                dataLogin[0] = input.nextLine();
                System.out.print("Masukkan password anda: ");
                dataLogin[1] = input.nextLine();
                cekLogin = cekLogin(dataLogin[0], dataLogin[1]);

                if(cekLogin){
                    menuJalan = true;
                    System.out.print("\nSelamat Datang!");
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
                            masterJalan = true;
                            while(masterJalan){
                                getDataBarang();
                                System.out.printf("\nSilahkan pilih menu dibawah:" +
                                               "\n1. Input Barang" +
                                               "\n2. Edit Barang" +
                                               "\n3. Kembali ke menu utama");
                                System.out.print("\nMasukkan menu: ");
                                menu = input.nextInt();
                                input.nextLine();
    
                                switch (menu) {
                                    case 1:
                                    inputDataBarang();
                                    break;
                                    case 2:
                                    editDataBarang();
                                    break;
                                    case 3:
                                    masterJalan = false;
                                    break;
                                
                                    default:
                                    System.out.println("Menu yang anda input salah");
                                    break;
                                }
                            }
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