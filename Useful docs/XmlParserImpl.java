package com.softuni.xmlprocessing.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlParserImpl implements XMLParser {
    @Override
    public <E> E parseXml(Class<E> objectClass, String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(objectClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (E) unmarshaller.unmarshal(new File(path));
    }

    @Override
    public <E> void exportToXml(E object, Class<E> objectClass, String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(objectClass);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(object, new File(path));
    }
}
