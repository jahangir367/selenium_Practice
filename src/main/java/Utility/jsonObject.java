package Utility;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;

import com.jayway.jsonpath.JsonPath;

public abstract class jsonObject {
  
	
	static File jsonFile;

	 public jsonObject (String filename){
	  jsonFile = new File(filename);
	  }

	public static By getObjectLocator(String jsonpath)
	  {
	  String locatorProperty = null;
	  try {
	 locatorProperty = JsonPath.read(jsonFile, jsonpath).toString();
	  
	  	  } catch (IOException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	  }
	  String locatorType = locatorProperty.split(";")[0];
	  String locatorValue = locatorProperty.split(";")[1];

	By locator = null;
	  switch(locatorType)
	  {
	  case "id":
	  locator = By.id(locatorValue);
	  break;
	  case "name":
	  locator = By.name(locatorValue);
	  break;

	case "class":
	  locator = By.className(locatorValue);
	  break;
	  case "css":
	  locator = By.cssSelector(locatorValue);
	  break;
	  case "link":
	  locator = By.linkText(locatorValue);
	  break;
	  case "partial":
	  locator = By.partialLinkText(locatorValue);
	  break;
	  case "tag":
	  locator = By.tagName(locatorValue);
	  break;
	  case "xpath":
	  locator = By.xpath(locatorValue);
	  break;
	 }
	  return locator;
	  }
	/*
	   PROTECTED FINAL STRING _FUNCTION;
    PROTECTED FINAL OBJECT _VALUE;
    PROTECTED FINAL JAVATYPE _SERIALIZATIONTYPE;

    PUBLIC JSONOBJECT(STRING FUNCTION, OBJECT VALUE) {
        THIS(FUNCTION, VALUE, (JAVATYPE)NULL);
    }

    PUBLIC JSONOBJECT(STRING FUNCTION, OBJECT VALUE, JAVATYPE ASTYPE) {
        THIS._FUNCTION = FUNCTION;
        THIS._VALUE = VALUE;
        THIS._SERIALIZATIONTYPE = ASTYPE;
    }

   	PUBLIC VOID SERIALIZEWITHTYPE(JSONGENERATOR JGEN, SERIALIZERPROVIDER PROVIDER, TYPESERIALIZER TYPESER) THROWS IOEXCEPTION, JSONPROCESSINGEXCEPTION {
        THIS.SERIALIZE(JGEN, PROVIDER);
    }

    PUBLIC VOID SERIALIZE(JSONGENERATOR JGEN, SERIALIZERPROVIDER PROVIDER) THROWS IOEXCEPTION, JSONPROCESSINGEXCEPTION {
        JGEN.WRITERAW(THIS._FUNCTION);
        JGEN.WRITERAW('(');
        IF (THIS._VALUE == NULL) {
            PROVIDER.DEFAULTSERIALIZENULL(JGEN);
        } ELSE IF (THIS._SERIALIZATIONTYPE != NULL) {
            PROVIDER.FINDTYPEDVALUESERIALIZER(THIS._SERIALIZATIONTYPE, TRUE, (BEANPROPERTY)NULL).SERIALIZE(THIS._VALUE, JGEN, PROVIDER);
        } ELSE {
            CLASS<?> CLS = THIS._VALUE.GETCLASS();
            PROVIDER.FINDTYPEDVALUESERIALIZER(CLS, TRUE, (BEANPROPERTY)NULL).SERIALIZE(THIS._VALUE, JGEN, PROVIDER);
        }

        JGEN.WRITERAW(')');
    }

    PUBLIC STRING GETFUNCTION() {
        RETURN THIS._FUNCTION;
    }

    PUBLIC OBJECT GETVALUE() {
        RETURN THIS._VALUE;
    }

    PUBLIC JAVATYPE GETSERIALIZATIONTYPE() {
        RETURN THIS._SERIALIZATIONTYPE;
    }
*/
}
