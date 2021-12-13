import java.util.Scanner;

class Main{

    static boolean cekLogin, menuJalan, masterJalan, programJalan = true;
    static int menu, denda, perpanjangan;
    static String nim, kodeBarang;
    static String dataBarang[][] = new String[50][3];
    static String dataPeminjaman[][] = new String[50][3];;
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
        initialize();
        System.out.println("=== Daftar Barang ===");
        System.out.print("No\tKode Barang\tNama Barang\tStok Barang");
        for(int i = 0; i < dataBarang.length; i++){
            if(dataBarang[i][0] != null){
                System.out.printf("\n%d\t%s\t\t%s\t%s", (i+1), dataBarang[i][0], dataBarang[i][1], dataBarang[i][2]);
            }
        }
    }

    static void inputDataBarang(){
        String menuInput;
        System.out.println("Input Barang");
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
        System.out.println("Edit Barang");
    }

    public static void main(String[] args){
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