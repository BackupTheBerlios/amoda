/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.interaction.ErrorMessage
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

package de.gulden.framework.amoda.model.interaction;

import de.gulden.framework.amoda.model.option.*;
import java.util.*;

/**
 * Class ErrorMessage.
 */
public interface ErrorMessage extends Message {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the cause.
     *  
     * @return  The cause.
     */
    public Throwable getCause();

    /**
     *  
     * @return  The boolean.
     */
    public boolean exitApplication();

} // end ErrorMessage
