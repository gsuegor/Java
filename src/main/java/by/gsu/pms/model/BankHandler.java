package by.gsu.pms.model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static by.gsu.pms.Utils.xmlDateToLocalDate;
import static by.gsu.pms.model.XmlModel.*;

public class BankHandler extends DefaultHandler {
    private DailyExRates dailyExRates = new DailyExRates();
    private List<Currency> currencyList = new ArrayList<>();
    private Currency currency;
    private boolean numCodeFlag = false;
    private boolean charCodeFlag = false;
    private boolean scaleFlag = false;
    private boolean nameFlag = false;
    private boolean rateFlag = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(XML_TAG_DAILY_EX_RATES))
            dailyExRates.setDate(xmlDateToLocalDate(attributes.getValue(XML_ATTRIBUTE_DATE)));
        if (qName.equals(XML_TAG_CURRENCY)){
            currency = new Currency();
            currency.setId(Integer.parseInt(attributes.getValue(XML_ATTRIBUTE_ID)));
        }
        if (qName.equals(XML_TAG_NUM_CODE))
            numCodeFlag = true;
        if (qName.equals(XML_TAG_CHAR_CODE))
            charCodeFlag = true;
        if (qName.equals(XML_TAG_SCALE))
            scaleFlag = true;
        if (qName.equals(XML_TAG_NAME))
            nameFlag = true;
        if (qName.equals(XML_TAG_RATE))
            rateFlag = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(XML_TAG_CURRENCY)) currencyList.add(currency);
        if (qName.equals(XML_TAG_DAILY_EX_RATES)) dailyExRates.setCurrencies(currencyList);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (numCodeFlag){
            currency.setNumCode(Integer.parseInt(value));
            numCodeFlag = false;
        }
        if (charCodeFlag){
            currency.setCharCode(value);
            charCodeFlag = false;
        }
        if (scaleFlag){
            currency.setScale(Integer.parseInt(value));
            scaleFlag = false;
        }
        if (nameFlag){
            currency.setName(value);
            nameFlag = false;
        }
        if (rateFlag){
            if (!value.contains("\n")){
                currency.setRate(Double.parseDouble(value));
            }
            rateFlag = false;
        }
    }
    public DailyExRates getDailyExRates(){
        return dailyExRates;
    }
}