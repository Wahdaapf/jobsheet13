import java.util.Scanner; // Mengimpor kelas Scanner untuk membaca input dari pengguna

public class TugasKelompok6 { // Deklarasi kelas utama
    static Scanner sc = new Scanner(System.in); // Membuat objek Scanner untuk input pengguna

    // Menampilkan menu utama
    static void tampilMenu(String[] menu) {
        System.out.println("=== PENCATATAN PRESTASI MAHASISWA ==="); // Menampilkan judul menu
        for (int i = 0; i < menu.length; i++) { // Iterasi melalui array menu
            System.out.println((i + 1) + ". " + menu[i]); // Menampilkan setiap opsi menu
        }
    }

    // Metode untuk memasukkan nilai mahasiswa
    static void inputNilai(String[][] dataMahasiswa, int jumlahMahasiswa) {
        int panjangMahasiswa = 0; // Variabel untuk menghitung jumlah mahasiswa yang sudah diinput
        for (int i = 0; i < dataMahasiswa.length; i++) { // Iterasi untuk menghitung data yang sudah ada
            if (dataMahasiswa[i][0] != null) { // Jika data pada indeks tidak kosong
                panjangMahasiswa++; // Tambahkan ke panjangMahasiswa
            }
        }
        System.out.println("\nMasukkan data mahasiswa ke-" + (panjangMahasiswa + 1)); // Menampilkan indeks data mahasiswa yang akan diinput
        System.out.print("Nama Mahasiswa\t: "); // Meminta input nama mahasiswa
        dataMahasiswa[panjangMahasiswa][0] = sc.nextLine(); // Menyimpan nama mahasiswa ke array

        System.out.print("NIM\t\t: "); // Meminta input NIM
        dataMahasiswa[panjangMahasiswa][1] = sc.nextLine(); // Menyimpan NIM ke array

        System.out.print("Jenis Prestasi\t: "); // Meminta input jenis prestasi
        dataMahasiswa[panjangMahasiswa][2] = sc.nextLine(); // Menyimpan jenis prestasi ke array

        // Validasi input tingkat prestasi
        while (true) { // Looping untuk validasi tingkat prestasi
            System.out.print("Tingkat Prestasi (Lokal, Nasional, Internasional): "); // Meminta input tingkat prestasi
            String tingkat = sc.nextLine(); // Membaca input pengguna
            if (tingkat.equalsIgnoreCase("Lokal") || // Memeriksa apakah tingkat valid
                tingkat.equalsIgnoreCase("Nasional") || 
                tingkat.equalsIgnoreCase("Internasional")) {
                dataMahasiswa[panjangMahasiswa][3] = tingkat; // Menyimpan tingkat prestasi jika valid
                break; // Keluar dari loop jika input valid
            } else {
                System.out.println("Tingkat prestasi tidak valid. Coba lagi."); // Pesan jika input tidak valid
            }
        }

        // Validasi input tahun prestasi
        while (true) { // Looping untuk validasi tahun prestasi
            System.out.print("Tahun Prestasi (2010 - 2024): "); // Meminta input tahun prestasi
            String tahun = sc.nextLine(); // Membaca input pengguna
            int tahunInt = Integer.parseInt(tahun); // Mengonversi input string menjadi integer
            int tahunSaatIni = 2024; // Mendefinisikan tahun saat ini
            if (tahunInt >= 2010 && tahunInt <= tahunSaatIni) { // Memeriksa apakah tahun valid
                dataMahasiswa[panjangMahasiswa][4] = tahun; // Menyimpan tahun prestasi jika valid
                break; // Keluar dari loop jika input valid
            } else {
                System.out.println("Tahun tidak valid. Coba lagi."); // Pesan jika input tidak valid
            }
        }

        System.out.println("Data Berhasil Di Tambahkan\n\n"); // Menampilkan pesan keberhasilan
    }

    // Metode untuk menampilkan semua data mahasiswa
    static void tampilkanSemuaPrestasi(String[][] dataMahasiswa, int jumlahMahasiswa) {
        int panjangMahasiswa = 0; // Variabel untuk menghitung jumlah data mahasiswa yang tersedia
        for (String[] dataMahasiswa1 : dataMahasiswa) { // Iterasi untuk menghitung data yang sudah ada
            if (dataMahasiswa1[0] != null) { // Jika data pada indeks tidak kosong
                panjangMahasiswa++; // Tambahkan ke panjangMahasiswa
            }
        }
        if (panjangMahasiswa == 0) { // Jika tidak ada data mahasiswa
            System.out.print("Belum ada data prestasi.\n\n"); // Tampilkan pesan tidak ada data
        } else { // Jika ada data mahasiswa
            System.out.println("\nDaftar Semua Prestasi Mahasiswa:"); // Tampilkan header daftar prestasi
            for (int i = 0; i < jumlahMahasiswa; i++) { // Iterasi untuk menampilkan setiap data mahasiswa
                if (dataMahasiswa[i][0] != null) { // Jika data mahasiswa tidak kosong
                    System.out.printf("Mahasiswa ke - %s\nNama\t: %s\nNIM\t: %s\nTingkat\t: %s\nTahun\t: %s\n\n",
                        i+1, dataMahasiswa[i][0], dataMahasiswa[i][1], 
                        dataMahasiswa[i][3], dataMahasiswa[i][4]); // Menampilkan data mahasiswa
                }
            }
        }
    }

    // Metode untuk menganalisis prestasi berdasarkan jenis
    static void analisisPrestasi(String[][] dataMahasiswa, int jumlahMahasiswa) {
        System.out.print("\nMasukkan jenis prestasi yang ingin dianalisis: "); // Meminta input jenis prestasi
        String jenisPrestasi = sc.nextLine(); // Membaca input jenis prestasi
        System.out.println("\nPrestasi yang sesuai:"); // Tampilkan header analisis
        boolean ditemukan = false; // Variabel untuk melacak apakah prestasi ditemukan

        for (int i = 0; i < jumlahMahasiswa; i++) { // Iterasi untuk memeriksa data mahasiswa
            if(dataMahasiswa[i][0] != null) { // Jika data mahasiswa tidak kosong
                if (dataMahasiswa[i][2].equalsIgnoreCase(jenisPrestasi)) { // Jika jenis prestasi sesuai
                    System.out.printf("Mahasiswa ke - %s\nNama\t: %s\nNIM\t: %s\nTingkat\t: %s\nTahun\t: %s\n\n",
                        i+1, dataMahasiswa[i][0], dataMahasiswa[i][1], 
                        dataMahasiswa[i][3], dataMahasiswa[i][4]); // Menampilkan data mahasiswa
                    ditemukan = true; // Menandai bahwa prestasi ditemukan
                }
            }
        }
        if (!ditemukan) { // Jika tidak ada prestasi yang sesuai
            System.out.println("Tidak ada prestasi dengan jenis tersebut."); // Tampilkan pesan tidak ditemukan
        }
    }

    // Metode untuk menangani navigasi menu
    static void switchMenu(
        boolean isRunning, 
        String[][] dataMahasiswa, 
        int jumlahMahasiswa, 
        String[] menu
    ) {
        while (isRunning) { // Looping selama program berjalan
            tampilMenu(menu); // Menampilkan menu
            System.out.print("Pilih menu: "); // Meminta input pilihan menu
            int pilihan = sc.nextInt(); // Membaca input pilihan menu
            sc.nextLine(); // Membersihkan buffer input
            System.out.println("\n");
            
            switch (pilihan) { // Memeriksa pilihan menu
                case 1: // Pilihan untuk menambah data
                    inputNilai(dataMahasiswa, jumlahMahasiswa); // Panggil metode untuk menambah data
                    break;
                case 2: // Pilihan untuk menampilkan semua data
                    tampilkanSemuaPrestasi(dataMahasiswa, jumlahMahasiswa); // Panggil metode untuk menampilkan data
                    break;
                case 3: // Pilihan untuk menganalisis data
                    analisisPrestasi(dataMahasiswa, jumlahMahasiswa); // Panggil metode untuk menganalisis data
                    break;
                case 4: // Pilihan untuk keluar
                    System.out.println("Terima kasih! Program selesai."); // Tampilkan pesan keluar
                    isRunning = false; // Hentikan loop program
                    break;
                default: // Jika input tidak valid
                    System.out.println("Pilihan tidak valid. Coba lagi."); // Tampilkan pesan kesalahan
            }
        }
    }

    // Metode utama (entry point program)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Membuat Scanner untuk input
        String[] menu = { // Array untuk menyimpan menu
            "Tambah Data Prestasi", 
            "Tampilkan Semua Prestasi",
            "Analisis Prestasi Berdasarkan Jenis",
            "Keluar"
        };

        int jumlahMahasiswa = 100; // Ukuran awal array untuk menyimpan data mahasiswa
        String[][] dataMahasiswa = new String[jumlahMahasiswa][5]; // Array 2D untuk menyimpan data mahasiswa
        boolean isRunning = true; // Variabel untuk menentukan apakah program berjalan
        
        switchMenu(isRunning, dataMahasiswa, jumlahMahasiswa, menu); // Memanggil metode switchMenu
        sc.close(); // Menutup Scanner untuk menghindari kebocoran sumber daya
    }
}
