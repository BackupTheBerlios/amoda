/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.interaction.Message
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
 * Class Message.
 */
public interface Message extends InteractionMember {

    // ------------------------------------------------------------------------
    // --- static fields                                                    ---
    // ------------------------------------------------------------------------
    /**
     * Constant TYPE_DEBUG.
     */
    public static final int TYPE_DEBUG=-2;

    /**
     * Constant TYPE_VERBOSE.
     */
    public static final int TYPE_VERBOSE=-1;

    /**
     * Constant TYPE_INFO.
     */
    public static final int TYPE_INFO=0;

    /**
     * Constant TYPE_WARNING.
     */
    public static final int TYPE_WARNING=1;

    /**
     * Constant TYPE_FATAL.
     */
    public static final int TYPE_FATAL=2;


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the type.
     *  
     * @return  The type.
     */
    public int getType();

    /**
     * Returns the text.
     *  
     * @return  The text.
     */
    public String getText();

    /**
     *  
     * @return  The string.
     */
    public String toString();

} // end Message
