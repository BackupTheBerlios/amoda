/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.interaction.GenericInteractionMemberAbstract
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

import de.gulden.framework.amoda.generic.core.GenericApplicationMemberAbstract;
import de.gulden.framework.amoda.generic.option.*;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.interaction.InteractionMember;
import de.gulden.util.xml.XMLException;
import de.gulden.util.xml.XMLHandler;
import java.util.*;
import org.w3c.dom.Element;

/**
 * Class GenericInteractionMemberAbstract.
 */
public abstract class GenericInteractionMemberAbstract extends GenericApplicationMemberAbstract implements InteractionMember {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The title.
     */
    protected String title;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericInteractionMemberAbstract.
     */
    public GenericInteractionMemberAbstract() {
        // your code here

    }

    /**
     * Creates a new instance of GenericInteractionMemberAbstract.
     *  
     * @param environment The environment.
     */
    public GenericInteractionMemberAbstract(ApplicationEnvironment environment) {
        super(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the title.
     *  
     * @return  The title.
     */
    public String getTitle() {
        return title;

    }

    /**
     * Sets the title.
     *  
     * @param _title The title.
     */
    public void setTitle(String _title) {
        title = _title;

    }

    public abstract void perform();

    /**
     * Parses the x m l.
     *  
     * @param element The element.
     */
    public void parseXML(Element element) throws XMLException {
                setId(element.getAttribute("id"));
        setTitle(
            de.gulden.util.xml.XMLToolbox.getLangstring(
                de.gulden.util.xml.XMLToolbox.getChildRequired(element,"title"),
                "de"));

    }

    /**
     * Creates the x m l handler.
     *  
     * @return  The x m l handler.
     */
    protected XMLHandler createXMLHandler() {
        return new XMLHandler() {
            public void parseXML(org.w3c.dom.Element element,de.gulden.util.xml.XMLSerializer serializer) throws de.gulden.util.xml.XMLException {
                GenericInteractionMemberAbstract.this.parseXML(element);
            }
            
            public void toXML(org.w3c.dom.Element element,de.gulden.util.xml.XMLSerializer serializer) {
                // TODO
            }
            
            public org.w3c.dom.Element getSchemaFragment(org.w3c.dom.Document document) {
                return null;
            }
            
            public String getDTDFragment() {
                return null;
            }
        };

    }

} // end GenericInteractionMemberAbstract
