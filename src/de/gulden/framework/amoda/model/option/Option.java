/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.option.Option
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

package de.gulden.framework.amoda.model.option;

import de.gulden.framework.amoda.model.core.ApplicationMember;
import de.gulden.framework.amoda.model.data.*;
import java.util.*;

/**
 * Class Option.
 */
public interface Option extends ApplicationMember {

    // ------------------------------------------------------------------------
    // --- static fields                                                    ---
    // ------------------------------------------------------------------------
    /**
     * Constant STATE_INIT.
     */
    public static final int STATE_INIT=0;

    /**
     * Constant STATE_DEFAULT.
     */
    public static final int STATE_DEFAULT=1;

    /**
     * Constant STATE_SAVED.
     */
    public static final int STATE_SAVED=2;

    /**
     * Constant STATE_CURRENT.
     */
    public static final int STATE_CURRENT=3;

    /**
     * Constant STATE_EDIT.
     */
    public static final int STATE_EDIT=4;


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the id.
     *  
     * @return  The id.
     */
    public String getId();

    /**
     *  
     * @return  The boolean.
     */
    public boolean isValid();

    /**
     * Returns the parent group.
     *  
     * @return  The parent group.
     */
    public OptionsGroup getParentGroup();

} // end Option
