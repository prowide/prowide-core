package com.prowidesoftware.swift.model.field;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class FieldComponentLabelsCompatibilityTest {

	@SuppressWarnings("rawtypes")
	@Test
	public void test() throws Exception {
        List<Class> classes = getClasses(Field.class.getClassLoader(),"com/prowidesoftware/swift/model/field");
        int missing = 0;
        int availableOK = 0;
        int availableError = 0;
        for (Class c: classes) {
        	Field f = (Field) c.newInstance();
        	int size = f.getComponents().size();
        	final String label = Field.getLabelComponents(f.getName(), null, null, null);
        	if (label.endsWith(".components")) {
        		missing++;
        	} else {
        		String[] labels = StringUtils.split(label, "-");
        		if (labels.length == size) {
        			availableOK++;
        		} else {
        			availableError++;
                    System.out.println(f.getName()+" components="+size+" "+label);
        		}
        	}
        }
        System.out.println("total="+classes.size()+" missing="+missing+" availableOK="+availableOK+" availableError="+availableError);
	}

	@Test
	public void test50K() throws Exception {
		final String label = Field.getLabelComponents("50K", null, null, null);
		System.out.println(label);
	}

    @SuppressWarnings("rawtypes")
	public static List<Class> getClasses(ClassLoader cl,String pack) throws Exception{
        String dottedPackage = pack.replaceAll("[/]", ".");
        List<Class> classes = new ArrayList<Class>();
        URL upackage = cl.getResource(pack);
        BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream) upackage.getContent()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.endsWith(".class") && line.startsWith("Field") && !line.contains("Test") && !line.equals("Field.class")) {
               classes.add(Class.forName(dottedPackage+"."+line.substring(0,line.lastIndexOf('.'))));
            }
        }
        return classes;
    }
}
