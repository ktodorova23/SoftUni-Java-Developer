package com.softuni.xmlprocessing.utils;

import javax.xml.bind.JAXBException;

public interface XMLParser {
    <E>  E parseXml(Class<E> objectClass, String path) throws JAXBException;

    <E> void exportToXml(E object, Class<E> objectClass, String path) throws JAXBException;
}
