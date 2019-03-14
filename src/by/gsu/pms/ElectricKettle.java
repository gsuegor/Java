package by.gsu.pms;

public class ElectricKettle extends ElectricalAppliance {
    private double volume;

    public ElectricKettle(String name, int voltage, double time,
                               double work, boolean isPowered, double volume){
        super(name,voltage,time,work,isPowered);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    @Override
    public String toString(){
        return super.toString()+";"+volume;
    }
}
