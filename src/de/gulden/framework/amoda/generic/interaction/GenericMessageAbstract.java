/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.interaction.GenericMessageAbstract
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

package de.gulden.framework.amoda.generic.interaction;

import de.gulden.framework.amoda.generic.option.*;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.util.xml.XMLException;
import java.util.*;
import org.w3c.dom.Element;

/**
 * Class GenericMessageAbstract.
 */
public abstract class GenericMessageAbstract extends GenericInteractionMemberAbstract {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The type.
     */
    protected int type;

    /**
     * The text.
     */
    protected String text;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericMessageAbstract.
     */
    public GenericMessageAbstract() {
        // your code here

    }

    /**
     * Creates a new instance of GenericMessageAbstract.
     *  
     * @param environment The environment.
     */
    public GenericMessageAbstract(ApplicationEnvironment environment) {
        super(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the type.
     *  
     * @return  The type.
     */
    public int getType() {
        return type;

    }

    /**
     * Sets the type.
     *  
     * @param _type The type.
     */
    public void setType(int _type) {
        type = _type;

    }

    /**
     * Returns the text.
     *  
     * @return  The text.
     */
    public String getText() {
        return text;

    }

    /**
     * Sets the text.
     *  
     * @param _text The text.
     */
    public void setText(String _text) {
        text = _text;

    }

    /**
     * Parses the x m l.
     *  
     * @param element The element.
     */
    public void parseXML(Element element) throws XMLException {
        super.parseXML(element);
        setText(
            de.gulden.util.xml.XMLToolbox.getLangstring(
                de.gulden.util.xml.XMLToolbox.getChildRequired(element,"text"),
                "de"));

    }

} // end GenericMessageAbstract
