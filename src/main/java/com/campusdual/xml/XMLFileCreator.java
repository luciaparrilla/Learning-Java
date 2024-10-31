package com.campusdual.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Calendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.File;
import java.io.IOException;


public class XMLFileCreator {
    private static void createDocument() throws ParserConfigurationException, TransformerConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("computer");
        document.appendChild(root);
        Element components = document.createElement("components");
        root.appendChild(components);

        //Element component = document.createElement("component");
        //component.setAttribute("quantity", "1");
        //component.setTextContent("CPU");
        //components.appendChild(component);

        components.appendChild(createItem(document, "component", "quantity", "1", "CPU"));
        components.appendChild(createItem(document, "component", "quantity", "2", "RAM"));
        components.appendChild(createItem(document, "component", "quantity", "3", "Fan"));
        components.appendChild(createItem(document, "component", "quantity", "1", "Graphic card"));
        components.appendChild(createItem(document, "component", "quantity", "1", "Motherboard"));
        components.appendChild(createItem(document, "component", "quantity", "1", "SSD"));
        components.appendChild(createItem(document, "component", "quantity", "2", "Power suply"));
        components.appendChild(createItem(document, "component", "quantity", "1", "Computer case"));
        writeToFile(document, "src/main/resources/computerList.xml");
    }

    private static void writeToFile(Document document, String pathFile) throws TransformerConfigurationException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
    }



    private static Element createItem(Document document, String tagName, String attribute, String attrValue, String textComponent){
        Element component = document.createElement(tagName);
        component.setAttribute(attribute, attrValue);
        component.setTextContent(textComponent);
        return component;
    }


    public static void main(String[] args) {
        try {
            XMLFileCreator.createDocument();
        } catch (ParserConfigurationException | TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }

    }
}
