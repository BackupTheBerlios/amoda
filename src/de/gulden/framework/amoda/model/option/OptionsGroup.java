/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.option.OptionsGroup
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
import java.util.Collection;

/**
 * Class OptionsGroup.
 */
public interface OptionsGroup extends Option {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the entries.
     *  
     * @return  The entries.
     */
    public Collection getEntries();

    /**
     * Returns the entry.
     *  
     * @param id The id.
     * @return  The entry.
     */
    public OptionEntry getEntry(String id);

    /**
     * Returns the groups.
     *  
     * @return  The groups.
     */
    public Collection getGroups();

    /**
     * Returns the group.
     *  
     * @param id The id.
     * @return  The group.
     */
    public OptionsGroup getGroup(String id);

} // end OptionsGroup
