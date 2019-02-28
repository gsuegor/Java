import by.gsu.pms.Music;

import java.util.Arrays;
import java.util.Comparator;

public class Runner {
    public static void main(String[] args) {
        Music[] musics = {
                new Music("ButterFly",15000,true),
                new Music("RainBow",1450000,true),
                new Music("Window",54000,false),
                new Music("Sing",187878),
                new Music("Follow",8595745,true),
                new Music("Run",98657,false),
                new Music("Common",437334),
                new Music("Loon",34573,true),
                new Music("Cucu",123443,false),
                new Music("Lion",9888823,true),
        };

        System.out.println("\tInit array:");
        show(musics);

        Arrays.sort(musics, new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                return o1.getNumberOfSales() - o2.getNumberOfSales();
            }
        });
        System.out.println("\tSort by numbers of sale:");
        show(musics);

        Arrays.sort(musics, new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("\tSort by name:");
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
