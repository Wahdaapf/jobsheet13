import java.util.Scanner;

public class TugasKelompok6dawi {

    // Metode untuk memasukkan nilai mahasiswa
    static void inputNilai(String[][] dataMahasiswa, int jumlahMahasiswa, Scanner sc) {
        int panjangMahasiswa = 0;
        for (int i = 0; i < dataMahasiswa.length; i++) {
            if (dataMahasiswa[i][0] != null) { 
                panjangMahasiswa++;
            }
        }
        System.out.println("\nMasukkan data mahasiswa ke-" + (panjangMahasiswa + 1));
        System.out.print("Nama Mahasiswa: ");
        dataMahasiswa[panjangMahasiswa][0] = sc.nextLine();

        System.out.print("NIM: ");
        dataMahasiswa[panjangMahasiswa][1] = sc.nextLine();

        System.out.print("Jenis Prestasi: ");
            dataMahasiswa[panjangMahasiswa][2] = sc.nextLine();

        // Validasi input tingkat prestasi
        while (true) {
            System.out.print("Tingkat Prestasi (Lokal, Nasional, Internasional): ");
            String tingkat = sc.nextLine();
            if (tingkat.equalsIgnoreCase("Lokal") || 
                tingkat.equalsIgnoreCase("Nasional") || 
                tingkat.equalsIgnoreCase("Internasional")) {
                dataMahasiswa[panjangMahasiswa][3] = tingkat;
                break;
            } else {
                System.out.println("Tingkat prestasi tidak valid. Coba lagi.");
            }
        }

        // Validasi input tahun prestasi
        while (true) {
            System.out.print("Tahun Prestasi (2010 hingga saat ini): ");
            String tahun = sc.nextLine();
            try {
                int tahunInt = Integer.parseInt(tahun);
                int tahunSaatIni = java.time.Year.now().getValue();
                if (tahunInt >= 2010 && tahunInt <= tahunSaatIni) {
                    dataMahasiswa[panjangMahasiswa][4] = tahun;
                    break;
                } else {
                    System.out.println("Tahun tidak valid. Coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Harap masukkan angka tahun yang valid.");
            }
        }
    }


    static void analisisPrestasi(String[][] dataMahasiswa, int jumlahMahasiswa, Scanner sc) {
        System.out.print("\nMasukkan jenis prestasi yang ingin dianalisis: ");
        String jenisPrestasi = sc.nextLine();
        System.out.println("\nPrestasi yang sesuai:");
        boolean ditemukan = false;

        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (dataMahasiswa[i][2].equalsIgnoreCase(jenisPrestasi)) {
                System.out.printf("Nama: %s, NIM: %s, Tingkat: %s, Tahun: %s\n",
                    dataMahasiswa[i][0], dataMahasiswa[i][1], 
                    dataMahasiswa[i][3], dataMahasiswa[i][4]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada prestasi dengan jenis tersebut.");
        }
    }
    






    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] menu = {
            "Tambah Data Prestasi", 
            "Tampilkan Semua Prestasi",
            "Analisis Prestasi Berdasarkan Jenis",
            "Keluar"
        };

        int jumlahMahasiswa = 100; // Ukuran awal array
        String[][] dataMahasiswa = new String[jumlahMahasiswa][5];
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMenu:");
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); // Bersihkan buffer

            switch (pilihan) {
                case 1:
                    inputNilai(dataMahasiswa, jumlahMahasiswa, sc);
                    break;
                case 2:
                    // tampilkanSemuaPrestasi(dataMahasiswa, jumlahMahasiswa);
                    break;
                case 3:
                    analisisPrestasi(dataMahasiswa, jumlahMahasiswa, sc);
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }

        sc.close();
    }
}
