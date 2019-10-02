package by.gsu.pms.model;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class Currency {
    private int id;
    private int numCode;
    private String charCode;
    private int scale;
    private String name;
    private double rate;

    @Override
    public String toString() {
        return "\nCurrency{" +
                "id = " + id +
                ", numCode = " + numCode +
                ", charCode = " + charCode +
                ", scale = " + scale +
                ", name = " + name +
                ", rate = " + rate +
                '}';
    }
}
