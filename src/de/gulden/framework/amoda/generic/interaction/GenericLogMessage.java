/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.interaction.GenericLogMessage
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
import de.gulden.framework.amoda.model.interaction.LogMessage;
import java.util.*;

/**
 * Class GenericLogMessage.
 */
public class GenericLogMessage extends GenericMessageAbstract implements LogMessage {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The cause.
     */
    protected Object cause;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericLogMessage.
     */
    public GenericLogMessage() {
        // your code here

    }

    /**
     * Creates a new instance of GenericLogMessage.
     *  
     * @param environment The environment.
     */
    public GenericLogMessage(ApplicationEnvironment environment) {
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
    public Object getCause() {
        return cause;

    }

    /**
     * Sets the cause.
     *  
     * @param _cause The cause.
     */
    public void setCause(Object _cause) {
        cause = _cause;

    }

    public void perform() {
        ((de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment)getEnvironment()).doLogMessage(this);

    }

} // end GenericLogMessage
