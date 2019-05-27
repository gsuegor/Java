import by.gsu.pms.Material;
import by.gsu.pms.Subject;

public class Runner {
    public static void main(String[] args) {
        Material steel = new Material("steel",7850);
        Subject wire = new Subject("wire", steel, 0.03);
        System.out.println("\tInit wire");
        System.out.println(wire);

        wire.setMaterial(new Material("copper",8500));

        System.out.println("\tAfter changer material");
        System.out.println(wire.getMass());

        wire.setMaterial(steel);

        System.out.println("\tRestored wire");
        System.out.println(wire);
    }
}
