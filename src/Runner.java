import by.gsu.pms.Music;

import java.io.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        final int ARRAY_SIZE = 3;
        final String FILE_NAME = "music.dat";

        Music[] musics = new Music[ARRAY_SIZE];

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME)); Scanner in = new Scanner(System.in)){
            for (int i = 0; i < ARRAY_SIZE; i++){

                System.out.print("Input name: ");
                String name = in.next();
                System.out.print("Input number of sales: ");
                int count = in.nextInt();
                System.out.print("Can download from web?: ");
                boolean downloadMP3 = in.nextBoolean();
                oos.writeObject(new Music(name, count, downloadMP3));
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            for (int i = 0; i < ARRAY_SIZE; i++){
                musics[i] = (Music) ois.readObject();
            }
        }catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }

        System.out.println("\tInit array:");
        show(musics);

        System.out.println("\tSold copies = "+countSales(musics));

        System.out.println("\tDownloadable from internet copies = "+countDownload(musics));
    }

    private static void show(Music[] array){
        for (Music item : array){
            System.out.println(item);
        }
    }
    private static int countSales(Music[] array){
        int copies = 0;
        for (Music item : array){
            copies += item.getNumberOfSales();
        }
        return copies;
    }
    private static int countDownload(Music[] array){
        int num = 0;
        for (Music item : array){
            if (item.isDownloadMP3()){
                num++;
            }
        }
        return num;
    }
}
