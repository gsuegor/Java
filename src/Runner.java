import by.gsu.pms.BusinessTrip;
import by.gsu.pms.Utilites;

public class Runner {

    public static void main(String[] args) {
        BusinessTrip[] businessTrips = {
                new BusinessTrip("Anton", 500, 31),
                null,
                new BusinessTrip("Sergey", 1235, 7),
                new BusinessTrip("Misha", 12767, 1),
                new BusinessTrip("Ken", 543, 23),
                new BusinessTrip("Edik", 8767, 32),
                new BusinessTrip()
        };
        for (BusinessTrip item : businessTrips){
            if (item != null){
                item.show();
            }
            System.out.println();
        }
        businessTrips[6].setTransport(55);

        System.out.println("Duration = "+(businessTrips[2].getDays()+businessTrips[3].getDays()));

        for (BusinessTrip item : businessTrips){
            System.out.println(item);
            System.out.println();
        }
        int sum = 0;
        for (BusinessTrip item : businessTrips){
            if (item != null){
                sum += item.getTotal();
            }

        }
        System.out.println("Sum of the total expenses = "+ Utilites.toBYN(sum));
        BusinessTrip max = businessTrips[0];
        for (BusinessTrip item: businessTrips){
            if (item != null && item.getTotal() > max.getTotal()){
                max = item;
            }
        }
        System.out.println("Account with the max total = "+max.getAccount());
    }
}
