/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.util.Toolbox
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

package de.gulden.util;

import java.awt.Color;
import java.util.*;

/**
 * Class Toolbox.
 */
public class Toolbox {

    // ------------------------------------------------------------------------
    // --- static fields                                                    ---
    // ------------------------------------------------------------------------
    /**
     * Constant NL.
     */
    public static final String NL=System.getProperty("line.separator");

    /**
     * Constant primitiveTypeWrappers[][].
     */
    private static final Object[][] primitiveTypeWrappers={{"boolean","byte","short","int","long","float","double","char"},{java.lang.Boolean.class,java.lang.Byte.class,java.lang.Short.class,java.lang.Integer.class,java.lang.Long.class,java.lang.Float.class,java.lang.Double.class,java.lang.Character.class}};


    // ------------------------------------------------------------------------
    // --- static methods                                                   ---
    // ------------------------------------------------------------------------
    /**
     * Returns the n l.
     *  
     * @return  The n l.
     */
    public static String getNL() {
        return NL;

    }

    /**
     * Returns the primitive type wrappers.
     *  
     * @return  The primitive type wrappers array.
     */
    public static Object[][] getPrimitiveTypeWrappers() {
        return primitiveTypeWrappers;

    }

    /**
     * Returns the primitive type wrapper class.
     *  
     * @param typename The typename.
     * @return  The primitive type wrapper class.
     */
    public static Class getPrimitiveTypeWrapperClass(String typename) throws ClassNotFoundException {
        int i=getPrimitiveTypeIndex(typename);
        if (i!=-1) {
            return (Class)primitiveTypeWrappers[1][i];
        } else {
            throw new ClassNotFoundException("'"+typename+"' is not a primitive type");
        }

    }

    /**
     * Returns the primitive type class.
     *  
     * @param typename The typename.
     * @return  The primitive type class.
     */
    public static Class getPrimitiveTypeClass(String typename) throws ClassNotFoundException {
        Class wrapper=getPrimitiveTypeWrapperClass(typename);
        try {
            java.lang.reflect.Field field=wrapper.getField("TYPE"); // all wrapper classes have public static field TYPE to represent the primitive Class
            Class primitiveClass=(Class)field.get(null);
            return primitiveClass;
        } catch (Exception e) {
            throw new ClassNotFoundException("wrapper for '"+typename+"' has no TYPE field");
        }

    }

    /**
     *  
     * @param typename The typename.
     * @return  The boolean.
     */
    public static boolean isPrimitiveType(String typename) {
        return (getPrimitiveTypeIndex(typename)!=-1);

    }

    /**
     * Parses the color.
     *  
     * @param s The s.
     * @return  The color.
     */
    public static Color parseColor(String s) {
        if (s.length()==7) {
            if (s.startsWith("#")) {
                String rStr=s.substring(1,3);
                String gStr=s.substring(3,5);
                String bStr=s.substring(5,7);
                int r=decimal(rStr);
                int g=decimal(gStr);
                int b=decimal(bStr);
                return new Color(r,g,b);
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    /**
     *  
     * @param color The color.
     * @return  The string.
     */
    public static String toString(Color color) {
        return "#"+hex(color.getRed(),2)+hex(color.getGreen(),2)+hex(color.getBlue(),2);

    }

    /**
     *  
     * @param i The i.
     * @return  The string.
     */
    public static String hex(int i) {
        return Integer.toHexString(i);

    }

    /**
     *  
     * @param i The i.
     * @param minLength The min length.
     * @return  The string.
     */
    public static String hex(int i, int minLength) {
        String s=hex(i);
        int lendiff=minLength-s.length();
        return s+repeat('0',lendiff); // negative values are ok for repeat

    }

    /**
     *  
     * @param hex The hex.
     * @return  The int.
     */
    public static int decimal(String hex) {
        return Integer.valueOf(hex,16).intValue();

    }

    /**
     *  
     * @param s The s.
     * @param count The count.
     * @return  The string.
     */
    public static String repeat(String s, int count) {
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<count;i++) {
            sb.append(s);
        }
        return sb.toString();

    }

    /**
     *  
     * @param c The c.
     * @param count The count.
     * @return  The string.
     */
    public static String repeat(char c, int count) {
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<count;i++) {
            sb.append(c);
        }
        return sb.toString();

    }

    /**
     *  
     * @param s The s.
     * @return  The string.
     */
    public static String noNull(String s) {
        if (s!=null) {
            return s;
        } else {
            return "";
        }

    }

    /**
     *  
     * @param s The s.
     * @return  The string.
     */
    public static String unqualify(String s) {
        int pos=s.lastIndexOf('.');
        if (pos!=-1) {
            return s.substring(pos+1);
        } else {
            return s;
        }

    }

    /**
     *  
     * @param s The s.
     * @param fill The fill.
     * @param len The len.
     * @return  The string.
     */
    public static String padRight(String s, String fill, int len) {
        return s+repeat(fill,len-s.length());

    }

    /**
     *  
     * @param s The s.
     * @param fill The fill.
     * @param len The len.
     * @return  The string.
     */
    public static String padLeft(String s, String fill, int len) {
        return repeat(fill,len-s.length())+s;

    }

    /**
     * Returns the primitive type index.
     *  
     * @param typename The typename.
     * @return  The primitive type index.
     */
    private static int getPrimitiveTypeIndex(String typename) {
        for (int i=0;i<primitiveTypeWrappers[0].length;i++) {
            if (primitiveTypeWrappers[0][i].equals(typename)) {
                return i;
            }
        }
        return -1;

    }

} // end Toolbox
