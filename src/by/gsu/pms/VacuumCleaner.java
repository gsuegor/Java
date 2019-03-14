package by.gsu.pms;

public class VacuumCleaner extends ElectricalAppliance {
    private double noiseLevel;
    private int suctionPower;
    private double capacity;

    public VacuumCleaner(String name, int voltage, double time, double work,
                         boolean isPowered, double noiseLevel, int suctionPower, double capacity){
        super(name,voltage,time,work,isPowered);
        this.noiseLevel = noiseLevel;
        this.suctionPower = suctionPower;
        this.capacity = capacity;
    }

    public double getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(double noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public int getSuctionPower() {
        return suctionPower;
    }

    public void setSuctionPower(int suctionPower) {
        this.suctionPower = suctionPower;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    @Override
    public String toString(){
        return super.toString()+";"+noiseLevel+";"+suctionPower+";"+capacity;
    }
}
