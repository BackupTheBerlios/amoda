/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.util.xml.XMLException
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

import java.io.IOException;
import java.util.*;
import org.w3c.dom.Element;

/**
 * Class XMLException.
 */
public class XMLException extends IOException {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The element.
     */
    protected Element element;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of XMLException.
     */
    public XMLException() {
        super();
        element=null;

    }

    /**
     * Creates a new instance of XMLException.
     *  
     * @param msg The msg.
     */
    public XMLException(String msg) {
        this(msg,null);

    }

    /**
     * Creates a new instance of XMLException.
     *  
     * @param msg The msg.
     * @param element The element.
     */
    public XMLException(String msg, Element element) {
        super(msg);
        this.element=element;

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the element.
     *  
     * @return  The element.
     */
    public Element getElement() {
        return element;

    }

    /**
     * Sets the element.
     *  
     * @param _element The element.
     */
    public void setElement(Element _element) {
        element = _element;

    }

} // end XMLException
