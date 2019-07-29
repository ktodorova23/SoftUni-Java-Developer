package alararestaurant.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <E> E parseXml(Class<E> objectClass, String path) throws JAXBException;
}
