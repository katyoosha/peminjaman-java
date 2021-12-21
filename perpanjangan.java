@@ -276,7 +276,7 @@ static void kembalibarang(){
        String dataKembalian[][] = new String[dataPeminjaman.length][dataPeminjaman[0].length];
        String temp[][] = new String[dataPeminjaman.length][dataPeminjaman[0].length];
        String nimDataKembali, kodeBarangKembali, pengembalianLagi;
        int stockKembali = 0, indexKode, stockBarang, tanggalKembali=0;
        int stockKembali = 0, indexKode, stockBarang, tanggalPinjam=0,tanggalPerpanjangan=0;
        boolean isDataPinjam = false, pengembalianJalan = true;
        String tanggalBalik;

@@ -293,7 +293,7 @@ static void kembalibarang(){
                if(dataPeminjaman[i][0] != null){
                    for(int a = 0; a < dataPeminjaman[i].length; a++){
                        if(dataPeminjaman[i][0].equalsIgnoreCase(nimDataKembali) && dataPeminjaman[i][1].equalsIgnoreCase(kodeBarangKembali)){
                            tanggalKembali = Integer.parseInt(dataPeminjaman[i][2]);
                            tanggalPinjam = Integer.parseInt(dataPeminjaman[i][2]);
                            isDataPinjam = true;
                            stockKembali = Integer.parseInt(dataPeminjaman[i][4]);
                            continue;
@@ -307,32 +307,55 @@ static void kembalibarang(){
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
                    if(Integer.parseInt(tanggalBalik)>tanggalKembali){
                        denda = Integer.parseInt(tanggalBalik)-tanggalKembali;
                        totalDenda = denda*5000;
                        System.out.printf("\nKarena telat mengembalikan %d hari maka didenda %d",denda,totalDenda);
                    }   
                for(int i = 0; i < temp.length; i++) {
                    if(temp[i][0] != null) {
                        dataKembalian[counter++] = temp[i];
                  }else{
                    if(tanggalPinjam>31){
                        tanggalBalik+=31;
                        }
                        if(Integer.parseInt(tanggalBalik)>tanggalPinjam){
                            denda = Integer.parseInt(tanggalBalik)-(tanggalPinjam+7);
                            totalDenda = denda*5000;
                            System.out.printf("\nKarena telat mengembalikan %d hari maka didenda %d",denda,totalDenda);
                        }   
                    for(int i = 0; i < temp.length; i++) {
                        if(temp[i][0] != null) {
                            dataKembalian[counter++] = temp[i];
                        }
                    }
                }

                for(int i = 0; i < dataPeminjaman.length; i++){
                    for(int a = 0; a < dataPeminjaman[i].length; a++){
                        dataPeminjaman[i][a] = dataKembalian[i][a];

                    for(int i = 0; i < dataPeminjaman.length; i++){
                        for(int a = 0; a < dataPeminjaman[i].length; a++){
                            dataPeminjaman[i][a] = dataKembalian[i][a];
                        }
                    }
                }

                    stockBarang = Integer.parseInt(dataBarang[indexKode][2]) + stockKembali;
                    dataBarang[indexKode][2] = Integer.toString(stockBarang);
                    System.out.println("\nBerhasil melakukan pengembalian barang!");
                  }

                stockBarang = Integer.parseInt(dataBarang[indexKode][2]) + stockKembali;
                dataBarang[indexKode][2] = Integer.toString(stockBarang);
                System.out.println("\nBerhasil melakukan pengembalian barang!");
            }else{
                System.out.println("\nMaaf, tidak ada data peminjaman yang sesuai!");
                }else{
                    System.out.println("\nMaaf, tidak ada data peminjaman yang sesuai!");
                }

            }

            System.out.print("Apakah mau melakukan pengembalian lagi? (y/t): ");
@@ -341,7 +364,7 @@ static void kembalibarang(){
                pengembalianJalan = false;
            }
        }        
    }


    public static void main(String[] args){
        initialize();