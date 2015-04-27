/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpxmltodom;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Hasan & Erol & Recep
 */
public class HTTPXmlToDom {

    public static void main(String[] args) {
        try {
            new HTTPXmlToDom().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws Exception {
        URL url = new URL("http://www.w3schools.com/xml/note.xml");
        URLConnection connection = url.openConnection();

        Document doc = parseXML(connection.getInputStream());
        NodeList descNodes = doc.getElementsByTagName("note");

        for (int i = 0; i < descNodes.getLength(); i++) {
            System.out.println(descNodes.item(i).getTextContent());
        }
    }

    private Document parseXML(InputStream stream)
            throws Exception {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        } catch (Exception ex) {
            throw ex;
        }

        return doc;
    }

}
