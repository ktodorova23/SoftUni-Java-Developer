package com.softuni.xmlprocessingcardealerhomework.utils;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <E> E parseXml(Class<E> objectClass, String path) throws JAXBException;

    <E> void exportToXml(E object, Class<E> objectClass, String path) throws JAXBException;
}
