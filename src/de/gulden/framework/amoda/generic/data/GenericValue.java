/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.data.GenericValue
 * Version: 0.1
 *
 * Date:    2002-10-24
 *
 * Note:    Contains auto-generated Javadoc comments
 *          created by BeautyJ (http://beautyj.berlios.de).
 *  
 * This is licensed under the GNU Lesser General Public License (LGPL)
 * and comes with NO WARRANTY. See file license.txt for details.
 *
 * Author:  Jens Gulden
 * Email:   amoda@jensgulden.de
 */

package de.gulden.framework.amoda.generic.data;

import de.gulden.framework.amoda.model.data.NamedValue;
import de.gulden.util.xml.XMLHandler;
import de.gulden.util.xml.XMLSerializable;
import java.awt.Color;
import java.io.File;
import java.util.*;

/**
 * Class GenericValue.
 */
public class GenericValue implements NamedValue, XMLSerializable {

    // ------------------------------------------------------------------------
    // --- static field                                                     ---
    // ------------------------------------------------------------------------
    /**
     * The b o o l e a n_ l i t e r a l s array.
     */
    public static String[][] BOOLEAN_LITERALS={{"true","yes","on"},{"false","no","off"}};


    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The type.
     */
    protected Class type;

    /**
     * The object.
     */
    protected Object object;

    /**
     * The name.
     */
    protected String name;

    /**
     * The x m l handler.
     */
    protected XMLHandler xMLHandler;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericValue.
     */
    public GenericValue() {
        setXMLHandler(createXMLHandler());

    }

    /**
     * Creates a new instance of GenericValue.
     *  
     * @param value The value.
     */
    public GenericValue(Object value) {
        this();
        setType(value.getClass());
        setObject(value);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the type.
     *  
     * @return  The type.
     */
    public Class getType() {
        return type;

    }

    /**
     * Sets the type.
     *  
     * @param _type The type.
     */
    public void setType(Class _type) {
        type = _type;

    }

    /**
     * Returns the object.
     *  
     * @return  The object.
     */
    public Object getObject() {
        return object;

    }

    /**
     * Sets the object.
     *  
     * @param _object The object.
     */
    public void setObject(Object _object) {
        object = _object;

    }

    /**
     * Returns the name.
     *  
     * @return  The name.
     */
    public String getName() {
        return name;

    }

    /**
     * Sets the name.
     *  
     * @param _name The name.
     */
    public void setName(String _name) {
        name = _name;

    }

    /**
     * Returns the x m l handler.
     *  
     * @return  The x m l handler.
     */
    public XMLHandler getXMLHandler() {
        return xMLHandler;

    }

    /**
     * Sets the x m l handler.
     *  
     * @param _xMLHandler The x m l handler.
     */
    public void setXMLHandler(XMLHandler _xMLHandler) {
        xMLHandler = _xMLHandler;

    }

    /**
     * Returns the string.
     *  
     * @return  The string.
     */
    public String getString() {
        return toString(getObject());

    }

    /**
     * Returns the int.
     *  
     * @return  The int.
     */
    public int getInt() {
        if (object instanceof Number) {
            return ((Number)object).intValue();
        } else if (object instanceof String) {
            try {
                return Integer.valueOf((String)object).intValue();
            } catch (NumberFormatException nfe) {
                throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot convert "+((String)object)+" to int");
            }
        } else {
            throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot convert value of type "+object.getClass().getName()+" ["+object.toString()+"] to int");
        }

    }

    /**
     * Returns the double.
     *  
     * @return  The double.
     */
    public double getDouble() {
        if (object instanceof Number) {
            return ((Number)object).doubleValue();
        } else if (object instanceof String) {
            try {
                return Double.valueOf((String)object).doubleValue();
            } catch (NumberFormatException nfe) {
                throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot convert "+((String)object)+" to double");
            }
        } else {
            throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot convert value of type "+object.getClass().getName()+" ["+object.toString()+"] to double");
        }

    }

    /**
     * Returns the boolean.
     *  
     * @return  The boolean.
     */
    public boolean getBoolean() {
        if (object instanceof Boolean) {
            return ((Boolean)object).booleanValue();
        } else if (object instanceof String) {
            String boolString=(String)object;
            return isBooleanLiteral(true,boolString);
        } else if (object instanceof Number) {
            return (((Number)object).doubleValue()!=0.0);
        } else {
            throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot convert value of type "+object.getClass().getName()+" ["+object.toString()+"] to boolean");
        }

    }

    /**
     *  
     * @param type The type.
     * @return  The boolean.
     */
    public boolean isTypeAvailable(Class type) {
        // ...**** quick and drity ****************************************************
        if ((object!=null)&&(type.isAssignableFrom(object.getClass()))) {
            return true;
        } else if (type.isAssignableFrom(this.type)) { 
            return true;
        } else if (String.class.isAssignableFrom(type)) { 
            return true; // everything can be converted to string somehow
        } else if (Integer.class.isAssignableFrom(type)||Double.class.isAssignableFrom(type)) {
            return Number.class.isAssignableFrom(this.type);
        } else if (Boolean.class.isAssignableFrom(type)) {
            return Boolean.class.isAssignableFrom(this.type)
                || Number.class.isAssignableFrom(this.type)
                || String.class.isAssignableFrom(this.type);
        } else {
            return false;
        }

    }

    /**
     * Parses the string.
     *  
     * @param s The s.
     */
    public void parseString(String s) {
        try {
            if (String.class.isAssignableFrom(type)) {
                object=s;
            } else if (Boolean.class.isAssignableFrom(type)) {
                object=Boolean.valueOf(isBooleanLiteral(true,s));
            } else if (Double.class.isAssignableFrom(type)) {
                object=Double.valueOf(s);
            } else if (Integer.class.isAssignableFrom(type)) {
                object=Integer.valueOf(s);
            } else if (File.class.isAssignableFrom(type)) {
                object=(new File(s));//.getCanonicalFile(); // test validity - disabled, allow empty string as path 
            } else if (Color.class.isAssignableFrom(type)) {
                object=de.gulden.util.Toolbox.parseColor(s);
                if (object==null) {
                    throw new de.gulden.framework.amoda.model.data.IllegalTypeError("string '"+s+"' is not a valid color");
                }
            }
        } catch (NumberFormatException nfe) {
            throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot parse string '"+s+"' as value for type "+type.getName());
        }

    }

    /**
     *  
     * @param o The o.
     * @return  The string.
     */
    public String toString(Object o) {
        if (object instanceof Color) {
            return de.gulden.util.Toolbox.toString((Color)object);
        } else if (object instanceof File) {
            return ((File)object).getAbsolutePath();
        } else if (o!=null) {
            return o.toString(); // *** TODO
        } else {
            return null;
        }

    }

    /**
     * Returns the file.
     *  
     * @return  The file.
     */
    public File getFile() {
        if (object instanceof File) {
            return ((File)object);
        } else if (object instanceof String) {
            File f=new File((String)object);
            try {
                f=f.getCanonicalFile();
                return f;
            } catch (java.io.IOException ioe) {
                throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot convert value of type "+object.getClass().getName()+" ["+object.toString()+"] to File");
            }
        } else {
            throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot convert value of type "+object.getClass().getName()+" ["+object.toString()+"] to File");
        }

    }

    /**
     * Returns the color.
     *  
     * @return  The color.
     */
    public Color getColor() {
        if (object instanceof java.awt.Color) {
            return ((Color)object);
        } else if (object instanceof String) {
            Color c=de.gulden.util.Toolbox.parseColor((String)object);
            if (c!=null) {
                return c;
            } else {
                throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot convert '"+((String)object)+" to Color");
            }
        } else {
            throw new de.gulden.framework.amoda.model.data.IllegalTypeError("cannot convert value of type "+object.getClass().getName()+" ["+object.toString()+"] to Color");
        }

    }

    /**
     * Creates the x m l handler.
     *  
     * @return  The x m l handler.
     */
    protected XMLHandler createXMLHandler() {
        // your code here
        return null;

    }


    // ------------------------------------------------------------------------
    // --- static methods                                                   ---
    // ------------------------------------------------------------------------
    /**
     * Returns the b o o l e a n_ l i t e r a l s.
     *  
     * @return  The b o o l e a n_ l i t e r a l s array.
     */
    public static String[][] getBOOLEAN_LITERALS() {
        return BOOLEAN_LITERALS;

    }

    /**
     * Sets the b o o l e a n_ l i t e r a l s.
     *  
     * @param _BOOLEAN_LITERALS The b o o l e a n_ l i t e r a l s array.
     */
    public static void setBOOLEAN_LITERALS(String[][] _BOOLEAN_LITERALS) {
        BOOLEAN_LITERALS = _BOOLEAN_LITERALS;

    }

    /**
     *  
     * @param booleanValue The boolean value.
     * @param s The s.
     * @return  The boolean.
     */
    public static boolean isBooleanLiteral(boolean booleanValue, String s) {
        int b=booleanValue?0:1;
        for (int i=0;i<BOOLEAN_LITERALS[b].length;i++) {
            if (s.equalsIgnoreCase(BOOLEAN_LITERALS[b][i])) {
                return true;
            }
        }
        return false;

    }

} // end GenericValue
