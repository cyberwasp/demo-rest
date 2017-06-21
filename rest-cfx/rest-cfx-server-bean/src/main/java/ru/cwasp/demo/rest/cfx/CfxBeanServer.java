package ru.cwasp.demo.rest.cfx;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import java.util.Collections;

public class CfxBeanServer {
    public static void main(String[] args) {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(CxfBeanService.class);
        sf.setResourceProvider(CxfBeanService.class, new SingletonResourceProvider(new CxfBeanService()));
        sf.setAddress("http://localhost:8080/");
        sf.setProvider(new CfxJSONProvider());
        sf.setProperties(Collections.singletonMap("media.subtype.partial.check", true));
        BindingFactoryManager manager = sf.getBus().getExtension(BindingFactoryManager.class);
        JAXRSBindingFactory factory = new JAXRSBindingFactory();
        factory.setBus(sf.getBus());
        manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
        sf.create();
    }
}
