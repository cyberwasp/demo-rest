package ru.cwasp.demo.rest.common;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DemoBean {
    public int field = 2;

    public int getField() {
        return field;
    }
}
