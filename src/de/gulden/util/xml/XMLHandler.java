/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.util.xml.XMLHandler
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
 * Class XMLHandler.
 */
public interface XMLHandler {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Parses the x m l.
     *  
     * @param element The element.
     * @param serializer The serializer.
     */
    public void parseXML(Element element, XMLSerializer serializer) throws XMLException;

    /**
     *  
     * @param element The element.
     * @param serializer The serializer.
     */
    public void toXML(Element element, XMLSerializer serializer);

    /**
     * Returns the schema fragment.
     *  
     * @param document The document.
     * @return  The schema fragment.
     */
    public Element getSchemaFragment(Document document);

    /**
     * Returns the d t d fragment.
     *  
     * @return  The d t d fragment.
     */
    public String getDTDFragment();

} // end XMLHandler
