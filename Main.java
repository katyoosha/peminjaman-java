import java.util.Scanner;

class Main{

    static boolean cekLogin, menuJalan, masterJalan, programJalan = true;
    static boolean menuPinjamJalan;
    static int menu, denda, perpanjangan;
    static String nim, kodeBarang;
    static String dataBarang[][] = new String[50][3];
    static String dataPeminjaman[][] = new String[50][4];
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

    static void getDataPeminjaman(){
        String leftAlignFormat = "| %-2d | %-13s | %-11s | %-11s | %-12s |%n";
        System.out.println("\n======================= Daftar Peminjaman =======================");
        System.out.format("+----+---------------+-------------+-------------+--------------+%n");
        System.out.format("| No | NIM           | Kode Barang | Tgl. Pinjam | Tgl. Kembali |%n");
        System.out.format("+----+---------------+-------------+-------------+--------------+%n");
        for(int i = 0; i < dataPeminjaman.length; i++){
            if(dataPeminjaman[i][0] != null){
                System.out.format(leftAlignFormat, (i+1), dataPeminjaman[i][0], dataPeminjaman[i][1], dataPeminjaman[i][2], dataPeminjaman[i][3]);
            }
        }
        System.out.format("+----+---------------+-------------+-------------+--------------+%n");
    }

    static boolean cekLogin(String username, String pass){
        if(username.equals(dataUser[0]) && pass.equals(dataUser[1])){
            return true;
        }else{
            return false;
        }
    }

    static void pinjamBarang(){
        System.out.println("=== Menu Pinjam Barang ===");
        
        getDataBarang();
        String pjmLagi, nimPeminjaman, kodeBarangPinjam;
        String dataPinjamMenu[][] = new String[dataPeminjaman.length][dataPeminjaman[0].length];
        int tanggalPinjam = 0;
        int k = 0;
        int barangKembali = 0;
        int kurangStok = 0;
        int indexKode = dataBarang.length+1;

        do{
            System.out.print("Masukkan NIM : ");
            nimPeminjaman = input.nextLine();
            System.out.print("Masukkan kode barang : ");
            kodeBarangPinjam = input.nextLine();

            indexKode = cariKode(kodeBarangPinjam);

            if(indexKode != dataBarang.length+1){
                kurangStok = Integer.parseInt(dataBarang[indexKode][2]);
                if(kurangStok > 0){
                    kurangStok-=1;
                    dataBarang[indexKode][2] = Integer.toString(kurangStok);
    
                    do{
                        System.out.print("Masukkan tanggal pinjam [1-31] : ");    
                        tanggalPinjam = input.nextInt();    
                        if(tanggalPinjam<=0||tanggalPinjam>31){
                            System.out.println("Tanggal Salah!");
                        }
                    }
                    while(tanggalPinjam<=0||tanggalPinjam>31);
                    
                    dataPeminjaman[k][2] = Integer.toString(tanggalPinjam);
                    if(tanggalPinjam<25){
                        barangKembali = tanggalPinjam+7; 
                    }else{
                        barangKembali = (tanggalPinjam+7)-30;
                    }
    
                    dataPeminjaman[k][0] = nimPeminjaman;
                    dataPeminjaman[k][1] = kodeBarangPinjam;
                    dataPeminjaman[k][3] = Integer.toString(barangKembali);
                    dataPinjamMenu[k] = dataPeminjaman[k];
                    input.nextLine();
                }else{
                    System.out.println("Maaf, stok untuk barang ini habis!");
                }
            }else{
                System.out.println("Maaf, kode barang yang anda masukkan salah!");
            }
           
            System.out.print("Apakah ada barang yang ingin dipinjam lagi? (y/t) ");
            pjmLagi = input.nextLine();
            k++;
        }
        while(pjmLagi.equalsIgnoreCase("y"));
        String leftAlignFormat = "| %-2d | %-13s | %-11s | %-11s | %-12s |%n";
        System.out.println("\n=============== Daftar Barang yang telah Dipinjam ===============");
        System.out.format("+----+---------------+-------------+-------------+--------------+%n");
        System.out.format("| No | NIM           | Kode Barang | Tgl. Pinjam | Tgl. Kembali |%n");
        System.out.format("+----+---------------+-------------+-------------+--------------+%n");
        for(int i = 0; i < k; i++){
            if(dataPinjamMenu[i][0] != null){
                System.out.format(leftAlignFormat, (i+1), dataPinjamMenu[i][0],dataPinjamMenu[i][1],dataPinjamMenu[i][2],dataPinjamMenu[i][3]);
            }
        }
        System.out.format("+----+---------------+-------------+-------------+--------------+%n");
    }

    static int cariKode(String kode){
        int indexKode = dataBarang.length+1;
        for(int i = 0; i < dataBarang.length; i++){
            if(kode.equalsIgnoreCase(dataBarang[i][0])){
                indexKode = i;
            }
        }

        return indexKode;
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

    static void kembalibarang(){
        String dataKembalian[][] = new String[dataPeminjaman.length][dataPeminjaman[0].length];
        String temp[][] = new String[dataPeminjaman.length][dataPeminjaman[0].length];
        String nimDataKembali, kodeBarangKembali, pengembalianLagi;
        boolean isDataPinjam = false, pengembalianJalan = true;

        while(pengembalianJalan){
            System.out.println("\n==== Pengembalian Barang ====");
            System.out.print("Masukkan NIM:\t");
            nimDataKembali = input.nextLine();
            System.out.print("Masukkan Kode:\t");
            kodeBarangKembali = input.nextLine();
    
            for(int i = 0; i < dataPeminjaman.length; i++){
                for(int a = 0; a < dataPeminjaman[i].length; a++){
                    if(dataPeminjaman[i][0] != null){
                        if(dataPeminjaman[i][0].equalsIgnoreCase(nimDataKembali) && dataPeminjaman[i][1].equalsIgnoreCase(kodeBarangKembali)){
                            isDataPinjam = true;
                            continue;
                        }else{
                            temp[i][a] = dataPeminjaman[i][a];
                        }
                    }
                }
            }
    
            if(isDataPinjam){
                int counter = 0;
                for(int i = 0; i < temp.length; i++) {
                    if(temp[i][0] != null) {
                        dataKembalian[counter++] = temp[i];
                    }
                }
        
                for(int i = 0; i < dataPeminjaman.length; i++){
                    for(int a = 0; a < dataPeminjaman[i].length; a++){
                        dataPeminjaman[i][a] = dataKembalian[i][a];
                    }
                }
        
                System.out.println("\nBerhasil melakukan pengembalian barang!");
            }else{
                System.out.println("\nMaaf, tidak ada data peminjaman yang sesuai!");
            }

            System.out.print("Apakah mau melakukan pengembalian lagi? (y/t): ");
            pengembalianLagi = input.nextLine();
            if(pengembalianLagi.equalsIgnoreCase("t")){
                pengembalianJalan = false;
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
                            menuPinjamJalan = true;
                            while(menuPinjamJalan){
                                System.out.printf("\n==== Sub-menu Peminjaman ====" +
                                                "\nSilahkan pilih menu dibawah:" +
                                                "\n1. Lihat Data Peminjaman" +
                                                "\n2. Input Peminjaman" +
                                                "\n3. Kembali ke menu utama");
                                System.out.print("\nMasukkan menu: ");
                                menu = input.nextInt();
                                input.nextLine();
                                switch (menu) {
                                    case 1:
                                    getDataPeminjaman();
                                    break;
                                    case 2:
                                    pinjamBarang();
                                    break;
                                    case 3:
                                    menuPinjamJalan = false;
                                    break;
                                
                                    default:
                                    System.out.println("Menu yang anda input salah");
                                    break;
                                }
                            } 
                            break;

                            case 3:
                            kembalibarang();
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