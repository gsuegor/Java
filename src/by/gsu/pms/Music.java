package by.gsu.pms;

import java.io.Serializable;

public class Music implements Serializable {
    private String name;
    private int numberOfSales;
    private boolean downloadMP3;

    public Music(String name, int numberOfSales, boolean downloadMP3){
        this.name = name;
        this.numberOfSales = numberOfSales;
        this.downloadMP3 = downloadMP3;
    }
    public Music(String name, int numberOfSales){
        this(name,numberOfSales,true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    public boolean isDownloadMP3() {
        return downloadMP3;
    }

    public void setDownloadMP3(boolean downloadMP3) {
        this.downloadMP3 = downloadMP3;
    }
    @Override
    public String toString(){
        return name+";"+numberOfSales+";"+downloadMP3;
    }
}
