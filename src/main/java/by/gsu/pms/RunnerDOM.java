package by.gsu.pms;

import by.gsu.pms.model.Currency;
import by.gsu.pms.model.DailyExRates;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.pms.Utils.FILE_PATH;
import static by.gsu.pms.Utils.xmlDateToLocalDate;
import static by.gsu.pms.model.XmlModel.*;

public class RunnerDOM {
    public static void main(String[] args) throws IOException {
        DailyExRates dailyExRates = new DailyExRates();
        Utils.downloadXML();
        File xmlFile = new File(FILE_PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName(XML_TAG_DAILY_EX_RATES);
            Element element = (Element) nodeList.item(0);
            dailyExRates.setDate(xmlDateToLocalDate(element.getAttribute(XML_ATTRIBUTE_DATE)));

            nodeList = document.getElementsByTagName(XML_TAG_CURRENCY);
            List<Currency> currencyList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                currencyList.add(getPeople(nodeList.item(i)));
            }
            dailyExRates.setCurrencies(currencyList);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(dailyExRates);
    }

    private static Currency getPeople(Node node) {
        Currency currency = new Currency();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            currency.setId(Integer.parseInt(element.getAttribute(XML_ATTRIBUTE_ID)));
            currency.setNumCode(Integer.parseInt(getTagValue(XML_TAG_NUM_CODE, element)));
            currency.setCharCode(getTagValue(XML_TAG_CHAR_CODE, element));
            currency.setScale(Integer.parseInt(getTagValue(XML_TAG_SCALE, element)));
            currency.setName(getTagValue(XML_TAG_NAME, element));
            currency.setRate(Double.parseDouble(getTagValue(XML_TAG_RATE, element)));
        }
        return currency;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
