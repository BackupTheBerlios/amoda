/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.interaction.GenericErrorMessage
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
import de.gulden.framework.amoda.model.interaction.ErrorMessage;
import de.gulden.util.xml.XMLException;
import java.util.*;
import org.w3c.dom.Element;

/**
 * Class GenericErrorMessage.
 */
public class GenericErrorMessage extends GenericMessageAbstract implements ErrorMessage {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The cause.
     */
    protected Throwable cause;

    /**
     * The exit.
     */
    protected boolean exit;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericErrorMessage.
     */
    public GenericErrorMessage() {
        // your code here

    }

    /**
     * Creates a new instance of GenericErrorMessage.
     *  
     * @param environment The environment.
     */
    public GenericErrorMessage(ApplicationEnvironment environment) {
        super(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the cause.
     *  
     * @return  The cause.
     */
    public Throwable getCause() {
        return cause;

    }

    /**
     * Sets the cause.
     *  
     * @param _cause The cause.
     */
    public void setCause(Throwable _cause) {
        cause = _cause;

    }

    /**
     *  
     * @return  The boolean.
     */
    public boolean isExit() {
        return exit;

    }

    /**
     * Sets the exit.
     *  
     * @param _exit The exit.
     */
    public void setExit(boolean _exit) {
        exit = _exit;

    }

    /**
     *  
     * @return  The boolean.
     */
    public boolean exitApplication() {
        return isExit();

    }

    /**
     * Parses the x m l.
     *  
     * @param element The element.
     */
    public void parseXML(Element element) throws XMLException {
        super.parseXML(element);
        setExit(Boolean.valueOf(de.gulden.util.xml.XMLToolbox.getAttributeRequired(element,"exit")).booleanValue());

    }

    public void perform() {
        ((de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment)getEnvironment()).doErrorMessage(this);

    }

} // end GenericErrorMessage
