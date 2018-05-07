package database;

import enzymes.Enzyme;
import enzymes.EnzymeList;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class DatabaseConnection {

    private String url;

    public DatabaseConnection() {
        this.url = null;
    }

    public Document getDocument(String filepath) {
        try {
            File file = new File(filepath);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory
                    .newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            return document;

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public EnzymeList getEnzymesFromXML() {

        Document document = getDocument("src/main/java/database/defaultEnzymes.xml");
        NodeList enzymes = document.getElementsByTagName("Enzyme");

        EnzymeList list = new EnzymeList();

        for (int i = 0; i < enzymes.getLength(); i++) {

            String enzyme_text = enzymes.item(i).getTextContent();
            Element fstElmnt = (Element) enzymes.item(i);
            String enzyme_name = fstElmnt.getAttribute("name");
            Enzyme enzyme = new Enzyme(enzyme_name, enzyme_text);
//                System.out.println(enzyme.toString());
//                System.out.println(enzyme_text);
//                System.out.println(enzyme_name);
            list.addEnzyme(enzyme);
        }

        return list;

    }

}
