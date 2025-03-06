package core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {
    private PropertiesLoader instance;
    private Properties properties;
    private PropertiesLoader getInstance() {
        if (instance == null) {
            instance = new PropertiesLoader();
        }
        return instance;
    }
    public PropertiesLoader() {
        initProps();
    }
    private void initProps() {
        System.setProperty("logback.configurationFile", "config/logback.xml");

        String sConfigFile = getSystemProperty("BDDConfigFile", "testingDemoQa.properties");
        properties = getPropsFromResource(sConfigFile);

        Map<String, String> all = getAllProps();
        List<String> keys = all.keySet().stream().filter(k -> k.toLowerCase().endsWith("_properties_file"))
                .toList();
        keys.forEach(k -> {
            String s = getOrEnv(k);
            if (!s.isEmpty()) {
                Properties p = getPropsFromResource(s);
                p.forEach((key, value) -> properties.setProperty(key.toString(), value.toString()));
            }
        });
    }

    private Map<String, String> getAllProps() {
        Map<String, String> map = new HashMap<>();
        properties.forEach((key, value) -> map.put(key.toString(), value.toString()));
        map.putAll(System.getenv());
        System.getProperties().forEach((key, value) -> map.put(key.toString(), value.toString()));
        return map;
    }
    private Properties getPropsFromResource(String resource) {
        Properties properties = new Properties();
        InputStream in = PropertiesLoader.class.getClassLoader().getResourceAsStream(resource);
        if (in == null) {
            try (FileInputStream fin = new FileInputStream(resource)) {
                properties.load(fin);
            } catch (IOException e) {
                System.out.printf("Failed to initialize properties: %s%n", e);
            }
        } else {
            try {
                properties.load(in);
            } catch (IOException e) {
                System.out.printf("Failed to initialize properties: %s%n", e);
            }
        }
        return properties;
    }
    private String getSystemProperty(String propName, String defVal) {
        String val = System.getProperty(propName);
        if (null == val)
            val = System.getenv(propName.toUpperCase());
        if (null == val)
            val = System.getenv(propName);
        if (null == val)
            val = defVal;
        return val;
    }
    public String getOrEnv(String prop) {
        return getOrEnv(prop, "");
    }
    public String getOrEnv(String prop, String defVal) {
        String val = System.getProperty(prop);
        if (null == val)
            val = System.getenv(prop.toUpperCase());
        if (null == val)
            val = System.getenv(prop);
        if (null == val) {
            if (properties == null)
                getInstance();
            if (properties != null)
                val = properties.getProperty(prop);
        }
        if (null == val)
            val = defVal;
        return val;
    }
    public String getSelenoidIP() {
        String selenoid_ip = getOrEnv("SELENOID_IP", null);
        return selenoid_ip;
    }
    public String getWebdriverRemoteUrl() {
        String url = getOrEnv("webdriver.remoteUrl", null);
        if (url == null) {
            String selenoid_ip = getSelenoidIP();
            if (selenoid_ip != null) {
                url = String.format("http://%s:4444/wd/hub", selenoid_ip);
            }
        }
        return url;
    }
}
