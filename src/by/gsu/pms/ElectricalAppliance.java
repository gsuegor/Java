package by.gsu.pms;

public class ElectricalAppliance {
    private String name;
    private int voltage; //V
    private double time;
    private double work;
    private boolean isPowered;

    public ElectricalAppliance(){}

    public ElectricalAppliance(String name, int voltage, double time, double work, boolean isPowered){
        this.name = name;
        this.voltage = voltage;
        this.time = time;
        this.work = work;
        this.isPowered = isPowered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getWork() {
        return work;
    }

    public void setWork(double work) {
        this.work = work;
    }

    public boolean isPowered() {
        return isPowered;
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }

    public double getPower(){
        return work/time;
    }
    @Override
    public String toString() {
        return name+";"+voltage+";"+time+";"+work+";"+getPower()+";"+isPowered;
    }

}
