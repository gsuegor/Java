import by.gsu.pms.ElectricKettle;
import by.gsu.pms.ElectricalAppliance;
import by.gsu.pms.Mixer;
import by.gsu.pms.VacuumCleaner;

import java.util.Arrays;
import java.util.Comparator;

public class Runner {
    public static void main(String[] args) {

        ElectricalAppliance[] electricalAppliances = {
                new ElectricKettle("Braun WK 600",220,5,11000,true,1.7),
                new ElectricKettle("ENERGY E-256",230,4,6000,false,1.5),
                new Mixer("Kitfort KT-1308-3",220,2,1200,true,4.2,6),
                new Mixer("Atlanta ATH-3122",220,2,760,false,3,5),
                new VacuumCleaner("SAMSUNG SC18M2110SB",220,2,3200,
                        true,87,380,1.5),
                new VacuumCleaner("HYUNDAI H-VCB01",220,3,5400,
                        true,90,350,2)
        };
        show(electricalAppliances);
        double powerConsumption = 0;
        for (ElectricalAppliance item : electricalAppliances){
            powerConsumption += item.getPower();
        }

        System.out.println("\tPower consumption = "+powerConsumption);

        Arrays.sort(electricalAppliances, new Comparator<ElectricalAppliance>() {
            @Override
            public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
                double compare = o1.getPower()-o2.getPower();
                int answer =  (int) compare;
                return answer;
            }
        });
        show(electricalAppliances);

        double leftBorder = 3000;
        double rightBorder = 7000;
        System.out.println("\tResult of sort in selected range");
        for (ElectricalAppliance item : electricalAppliances){
            if (item.getWork() > leftBorder && item.getWork() < rightBorder){
                System.out.println(item);
            }
        }
    }
    private static void show(ElectricalAppliance[] array){
        System.out.println("\tElectrical appliance in this nome:");
        for (ElectricalAppliance item : array){
            System.out.println(item);
        }
    }
    private enum PARAM{
        NAME,VOLTAGE,TIME,WORK
    }
}
