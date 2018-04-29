package br.com.welson.client;

import br.com.welson.ejb.InterestCalculatorRemote;
import org.wildfly.naming.client.WildFlyInitialContextFactory;

import javax.naming.Context;
import javax.naming.NamingException;
import java.util.Properties;

public class EJBClient {

    public static void main(String[] args) throws NamingException {
        Context initialContext = new WildFlyInitialContextFactory().getInitialContext(getContextProperties());
        String lookupName = "java:/InterestCalculator/InterestCalculator!br.com.welson.ejb.InterestCalculatorRemote";
        InterestCalculatorRemote bean = (InterestCalculatorRemote) initialContext.lookup(lookupName);
        System.out.println(bean.calculatePercentage(100, -10));
        initialContext.close();
    }

    public static Properties getContextProperties() {
        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, WildFlyInitialContextFactory.class.getName());
        properties.setProperty(Context.PROVIDER_URL, "remote+http://127.0.0.1:8080");
        return properties;
    }
}
