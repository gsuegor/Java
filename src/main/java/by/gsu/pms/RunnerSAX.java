package by.gsu.pms;

import by.gsu.pms.model.BankHandler;
import by.gsu.pms.model.DailyExRates;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

import static by.gsu.pms.Utils.FILE_PATH;

public class RunnerSAX {
    public static void main(String[] args) {
        DailyExRates dailyExRates;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            BankHandler bankHandler = new BankHandler();
            saxParser.parse(new File(FILE_PATH), bankHandler);
            dailyExRates = bankHandler.getDailyExRates();
            System.out.println(dailyExRates);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
