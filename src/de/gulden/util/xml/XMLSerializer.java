/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.util.xml.XMLSerializer
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

package de.gulden.util.xml;

import java.util.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class XMLSerializer.
 */
public class XMLSerializer {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The factory.
     */
    public XMLSerializerFactory factory;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of XMLSerializer.
     */
    public XMLSerializer() {
        super();

    }

    /**
     * Creates a new instance of XMLSerializer.
     *  
     * @param factory The factory.
     */
    public XMLSerializer(XMLSerializerFactory factory) {
        this();
        setFactory(factory);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the factory.
     *  
     * @return  The factory.
     */
    public XMLSerializerFactory getFactory() {
        return factory;

    }

    /**
     * Sets the factory.
     *  
     * @param xMLSerializerFactory The factory.
     */
    public void setFactory(XMLSerializerFactory xMLSerializerFactory) {
        this.factory = xMLSerializerFactory;

    }

    /**
     *  
     * @param object The object.
     * @param document The document.
     * @return  The element.
     */
    public Element serialize(XMLSerializable object, Document document) {
        Class cl=object.getClass();
        String tagname;
        tagname=getFactory().mapToTagname(cl.getName());
        Element e=document.createElement(tagname);
        object.getXMLHandler().toXML(e,this);
        return e;

    }

    /**
     *  
     * @param element The element.
     * @return  The object.
     */
    public Object deserialize(Element element) throws XMLException {
        String tagname=element.getTagName();
        String classname=element.getAttribute("class"); // use class attribute...
        if (classname==null||classname.equals("")) {
            classname=getFactory().mapToClassname(tagname); // ... or preset-table
        }
        if (classname!=null) {
            Class cl;
            try {
                cl=this.getClass().getClassLoader().loadClass(classname);
            } catch (ClassNotFoundException cnfe) {
                throw new XMLException("cannot load class "+classname);
            }
            Object o;
            try {
                o=cl.newInstance();
            } catch (Exception e) {
                throw new XMLException("cannot instanciate class "+classname);
            }
            XMLSerializable x=(XMLSerializable)o;
            x.getXMLHandler().parseXML(element,this);
            return x;
        } else {
            throw new XMLException("cannot deserialize, unknown tag <"+tagname+">");
        }

    }

} // end XMLSerializer
