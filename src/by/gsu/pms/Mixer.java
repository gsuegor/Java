package by.gsu.pms;

public class Mixer extends ElectricalAppliance {
    private double cupVolume;//liters
    private int numberOfSpeeds;

    public Mixer(String name, int voltage, double time, double work,
                 boolean isPowered, double cupVolume, int numberOfSpeeds){
        super(name,voltage,time,work,isPowered);
        this.cupVolume = cupVolume;
        this.numberOfSpeeds = numberOfSpeeds;
    }

    public double getCupVolume() {
        return cupVolume;
    }

    public void setCupVolume(double cupVolume) {
        this.cupVolume = cupVolume;
    }

    public int getNumberOfSpeeds() {
        return numberOfSpeeds;
    }

    public void setNumberOfSpeeds(int numberOfSpeeds) {
        this.numberOfSpeeds = numberOfSpeeds;
    }
    @Override
    public String toString(){
        return super.toString()+";"+cupVolume+";"+numberOfSpeeds;
    }
}
