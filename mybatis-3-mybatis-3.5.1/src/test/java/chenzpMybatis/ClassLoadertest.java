package chenzpMybatis;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;

public class ClassLoadertest {

    @Test
    public  void testClassLoader() throws  Exception{

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("sqlmap-config.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
            Document parse = documentBuilder.parse(resourceAsStream);
            Element documentElement = parse.getDocumentElement();
            NodeList mappers = documentElement.getElementsByTagName("mappers");
            for (int i = 0; i < mappers.getLength(); i++) {}
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

}
