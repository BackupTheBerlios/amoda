/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.util.xml.XMLSerializerFactory
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
import java.util.Hashtable;

/**
 * Class XMLSerializerFactory.
 */
public class XMLSerializerFactory implements Cloneable {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The tagnames to classnames.
     */
    protected Hashtable tagnamesToClassnames;

    /**
     * The classnames to tagnames.
     */
    protected Hashtable classnamesToTagnames;


    // ------------------------------------------------------------------------
    // --- constructor                                                      ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of XMLSerializerFactory.
     */
    public XMLSerializerFactory() {
        tagnamesToClassnames=new Hashtable();
        classnamesToTagnames=new Hashtable();

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the tagnames to classnames.
     *  
     * @return  The tagnames to classnames.
     */
    public Hashtable getTagnamesToClassnames() {
        return tagnamesToClassnames;

    }

    /**
     * Sets the tagnames to classnames.
     *  
     * @param _tagnamesToClassnames The tagnames to classnames.
     */
    public void setTagnamesToClassnames(Hashtable _tagnamesToClassnames) {
        tagnamesToClassnames = _tagnamesToClassnames;

    }

    /**
     * Returns the classnames to tagnames.
     *  
     * @return  The classnames to tagnames.
     */
    public Hashtable getClassnamesToTagnames() {
        return classnamesToTagnames;

    }

    /**
     * Sets the classnames to tagnames.
     *  
     * @param _classnamesToTagnames The classnames to tagnames.
     */
    public void setClassnamesToTagnames(Hashtable _classnamesToTagnames) {
        classnamesToTagnames = _classnamesToTagnames;

    }

    /**
     *  
     * @param tagname The tagname.
     * @param xmlSerializableClassname The xml serializable classname.
     */
    public void register(String tagname, String xmlSerializableClassname) {
        tagnamesToClassnames.put(tagname,xmlSerializableClassname);
        classnamesToTagnames.put(xmlSerializableClassname,tagname);

    }

    /**
     * Creates the x m l serializer.
     *  
     * @return  The x m l serializer.
     */
    public XMLSerializer createXMLSerializer() {
        try {
            return new XMLSerializer((XMLSerializerFactory)this.clone());
        } catch (CloneNotSupportedException e) {
            return null;
        }

    }

    /**
     *  
     * @param tagname The tagname.
     * @return  The string.
     */
    String mapToClassname(String tagname) {
        return (String)tagnamesToClassnames.get(tagname);

    }

    /**
     *  
     * @param xmlSerializableClassname The xml serializable classname.
     * @return  The string.
     */
    String mapToTagname(String xmlSerializableClassname) {
        return (String)classnamesToTagnames.get(xmlSerializableClassname);

    }

} // end XMLSerializerFactory
