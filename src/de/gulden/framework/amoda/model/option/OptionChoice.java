/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.option.OptionChoice
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
import java.util.*;

/**
 * Class OptionChoice.
 */
public interface OptionChoice extends OptionsGroup, OptionEntry {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the selected option.
     *  
     * @return  The selected option.
     */
    public OptionEntry getSelectedOption();

    /**
     * Returns the selected id.
     *  
     * @return  The selected id.
     */
    public String getSelectedId();

} // end OptionChoice
