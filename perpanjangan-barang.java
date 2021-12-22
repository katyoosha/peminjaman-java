static void kembalibarang(){
        String dataKembalian[][] = new String[dataPeminjaman.length][dataPeminjaman[0].length];
        String temp[][] = new String[dataPeminjaman.length][dataPeminjaman[0].length];
        String nimDataKembali, kodeBarangKembali, pengembalianLagi;
        int stockKembali = 0, indexKode, stockBarang, tanggalKembali=0;
        int stockKembali = 0, indexKode, stockBarang, tanggalPinjam=0,tanggalPerpanjangan=0;
        boolean isDataPinjam = false, pengembalianJalan = true;
        String tanggalBalik;

        static void kembalibarang(){
                if(dataPeminjaman[i][0] != null){
                    for(int a = 0; a < dataPeminjaman[i].length; a++){
                        if(dataPeminjaman[i][0].equalsIgnoreCase(nimDataKembali) && dataPeminjaman[i][1].equalsIgnoreCase(kodeBarangKembali)){
                            tanggalKembali = Integer.parseInt(dataPeminjaman[i][2]);
                            tanggalPinjam = Integer.parseInt(dataPeminjaman[i][2]);
                            isDataPinjam = true;
                            stockKembali = Integer.parseInt(dataPeminjaman[i][4]);
                            continue;

        static void kembalibarang(){
            if(isDataPinjam){
                int counter = 0;
                int denda=0,totalDenda=0;
                String perpanjangan;
                indexKode = cariKode(kodeBarangKembali);
                if(tanggalKembali>31){
                    tanggalBalik+=31;
                if(Integer.parseInt(tanggalBalik)<=tanggalPinjam+7){
                    System.out.print("Apakah anda ingin memperpanjang peminjaman? (y/t) ");
                    perpanjangan= input.nextLine();
                    if(perpanjangan.equalsIgnoreCase("y")){
                        for(int i = 0; i < dataPeminjaman.length; i++){
                            if(dataPeminjaman[i][0] != null){

                        if(dataPeminjaman[i][0].equalsIgnoreCase(nimDataKembali) && dataPeminjaman[i][1].equalsIgnoreCase(kodeBarangKembali)){
                                        tanggalPerpanjangan= Integer.parseInt(tanggalBalik)+7;
                                        dataPeminjaman[i][3] = Integer.toString(tanggalPerpanjangan);
                                        System.out.println("Selamat anda telah melakukan perpanjangan, silahkan kembalikan pada tanggal "+dataPeminjaman[i][3]);   
                                        System.out.println(" ");
                                    }

                            }
                        }
                    }

                    