public class sequential {
    public static void pencarian(String[] args) {

    int i = 0;
    boolean temukan = false;
   
    for (i = 0; i < Data.length; i++) {
       if (menuJalan== Data[i] ){
           temukan = true;
           break;
  }
}
    if (temukan){
        String leftAlignFormat = "| %-2d | %-13s | %-11s | %-11s | %-12s | %-12s |%n";
        System.out.println("\n======================= Data Peminjaman =======================");
        System.out.format("+----+---------------+-------------+-------------+--------------+--------------+%n");
        System.out.format("| No | NIM           | Kode Barang | Tgl. Pinjam | Tgl. Kembali |     Banyak   |%n");
        System.out.format("+----+---------------+-------------+-------------+--------------+--------------+%n");
        System.out.println("Data : " + menuJalan );
        System.out.println("Ada");
    }
    else {
        System.out.println("Tidak Ada");
    }
}
}
