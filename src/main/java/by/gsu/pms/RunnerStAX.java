package by.gsu.pms;

import by.gsu.pms.model.Currency;
import by.gsu.pms.model.DailyExRates;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.pms.Utils.FILE_PATH;
import static by.gsu.pms.Utils.xmlDateToLocalDate;
import static by.gsu.pms.model.XmlModel.*;

public class RunnerStAX {
    public static void main(String[] args) {
        System.out.println(parseXml());
    }
    private static DailyExRates parseXml(){
        DailyExRates dailyExRates = new DailyExRates();
        List<Currency> currencyList = new ArrayList<>();
        Currency currency = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(FILE_PATH));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()){
                        case XML_TAG_DAILY_EX_RATES:{
                            Attribute idAttr = startElement.getAttributeByName(new QName(XML_ATTRIBUTE_DATE));
                            if (idAttr != null) {
                                dailyExRates.setDate(xmlDateToLocalDate(idAttr.getValue()));
                            }
                        }break;
                        case XML_TAG_CURRENCY:{
                            currency = new Currency();
                            Attribute idAttr = startElement.getAttributeByName(new QName(XML_ATTRIBUTE_ID));
                            if (idAttr != null) {
                                currency.setId(Integer.parseInt(idAttr.getValue()));
                            }
                        }break;
                        case XML_TAG_NUM_CODE:{
                            xmlEvent = reader.nextEvent();
                            currency.setNumCode(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        }break;
                        case XML_TAG_CHAR_CODE:{
                            xmlEvent = reader.nextEvent();
                            currency.setCharCode(xmlEvent.asCharacters().getData());
                        }break;
                        case XML_TAG_SCALE:{
                            xmlEvent = reader.nextEvent();
                            currency.setScale(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        }break;
                        case XML_TAG_NAME:{
                            xmlEvent = reader.nextEvent();
                            currency.setName(xmlEvent.asCharacters().getData());
                        }break;
                        case XML_TAG_RATE:{
                            xmlEvent = reader.nextEvent();
                            currency.setRate(Double.parseDouble(xmlEvent.asCharacters().getData()));
                        }break;
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    switch (endElement.getName().getLocalPart()){
                        case XML_TAG_CURRENCY:{
                            currencyList.add(currency);
                        }break;
                        case XML_TAG_DAILY_EX_RATES:{
                            dailyExRates.setCurrencies(currencyList);
                        }break;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dailyExRates;
    }
}
