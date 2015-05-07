package com.dafy.myoaservice.parserutil;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.*;

public class XmlUtil {

    public static String toXML(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromXML(String xml, Class<T> valueType) {
        try {
            JAXBContext context = JAXBContext.newInstance(valueType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public static enum DataTypeEnum{
    	VARCHAR("''"),
    	BIGINT("0"),
    	LONGTEXT("''"),
    	DATETIME("0"),
    	INT("0"),
    	DECIMAL("0"),
    	TEXT("''"),
    	BIT("0"),
    	TINYINT("0"),
    	DATE("NOW()"),
    	TIMESTAMP("NOW()"),
    	CHAR("''"),
    	LONGBLOB("''"),
    	BLOB("''"),
    	DOUBLE("0.0"),
    	TIME("NOW()"),
    	SET("''"),
    	ENUM("''"),
    	MEDIUMTEXT("0"),
    	SMALLINT("0");
    	private String defaultValue;
    	public String getDefaultValue() {
			return defaultValue;
		}
		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}
		DataTypeEnum(String defaultValue)
    	{
    		this.defaultValue = defaultValue;
    	}
    }
    public static String getDefault(String value)
    {
    	if(value.equalsIgnoreCase("varchar"))
    	{
    		return DataTypeEnum.VARCHAR.defaultValue;
    	}else if(value.equalsIgnoreCase("int"))
    	{
    		return DataTypeEnum.INT.defaultValue;
    	}
    	return "''";
    }
}
