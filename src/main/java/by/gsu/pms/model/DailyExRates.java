package by.gsu.pms.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Setter
@NoArgsConstructor
public class DailyExRates {
    private LocalDate date;
    private List<Currency> currencies;

    @Override
    public String toString() {
        return "DailyExRates{" +
                "\ndate=" + date +
                ", \ncurrencies=" + currencies +
                '}';
    }
}
