/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.option.OptionEntry
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

import de.gulden.framework.amoda.model.data.*;
import de.gulden.framework.amoda.model.data.Value;
import java.util.*;

/**
 * Class OptionEntry.
 */
public interface OptionEntry extends Option {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the value.
     *  
     * @return  The value.
     */
    public Value getValue();

    /**
     * Returns the value.
     *  
     * @param state The state.
     * @return  The value.
     */
    public Value getValue(int state);

    /**
     * Returns the type.
     *  
     * @return  The type.
     */
    public Class getType();

} // end OptionEntry
