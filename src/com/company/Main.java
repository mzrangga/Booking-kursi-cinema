package com.company;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer[][]> kursi = new ArrayList<>();
        String[][] booking = new String[5][6];
        int baris, booked = 0, vacant = 30;
        String nama;
        int menu;
        boolean validMenu = false;
        ArrayList<String> history = new ArrayList<>();
        while (!validMenu) {
            System.out.println("============================");
            System.out.println("Terdapat 30 kursi yang belum di book dan " + booked + " kursi yang sudah di book”");
            System.out.println("1. Pesan Kursi: ");
            System.out.println("2. Lihat Status KUrsi:");
            System.out.println("3. Lihat Riwayat Pemesanan:");
            System.out.println("4. Keluar");
            System.out.print("pilih menu: ");
            menu = scan.nextInt();
            validMenu = true;
            switch (menu){
                case 1 :
                    boolean case1 = false;
                    scan.nextLine();
                    while (!case1){
                        System.out.print("Pilih row ke (1 - 5 ) : ");
                        baris = Integer.parseInt(scan.nextLine());
                        System.out.print("Pilih kursi ke (1 - 6 ): ");
                        int nomorkursi = Integer.parseInt(scan.nextLine());

                        if(booking[baris - 1][nomorkursi - 1]== null) {
                            System.out.println("Masukan nama anda");
                            nama = scan.nextLine();
                            booking[baris - 1][nomorkursi - 1] = nama;
                            System.out.println("berhasil pesan");
                            history.add(String.format
                                    ("pada tanggal %s, barisan %d, kursi ke %d, berhasil dipesan oleh %s",LocalDate.now(),baris,nomorkursi,nama));
                            vacant--;
                            booked++;
                        }else {
                            System.out.println("kursi tidak kosong");
                        }
                        System.out.println("ingin memesan lagi? (Y/N)");
                        String conf = scan.nextLine();
                        if (conf.equals("Y")||conf.equals("y")){
                            case1 = false;
                        }
                        else {
                            case1 = true;
                            validMenu = false;
                        }
                    }
                    break;
                case 2 :
                    cekKursi(booking);
                    validMenu = false;
                    break;
                case 3 :
                    Riwayat(history);
                    validMenu = false;
                    break;
                case 4 :
                    System.out.println("Terima kasih telah menggunakan layanan kami");
                    System.exit(0);
                default:
                    System.out.println("masukan pilihan yang tertera");
                    validMenu = false;
            }
        }
    }

    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    static void cekKursi(String[][] kursi) {
        int nomorRow = 0;
        int noKursi;
        for (String[] status : kursi) {
            nomorRow++;
            noKursi = 0;
            for (String status2 : status) {
                noKursi++;
                if (status2 != null) {
                    System.out.println(String.format("barisan %d, Kursi %d : Booked", nomorRow, noKursi));
                } else {
                    System.out.println(String.format("barisan %d, Kursi %d : Vacant", nomorRow, noKursi));
                }
            }
        }
    }

    static void Riwayat(ArrayList<String> log) {
        int no = 1;
        for (String value : log) {
            System.out.print(no++ +". ");
            System.out.println(log);
        }
    }
}
