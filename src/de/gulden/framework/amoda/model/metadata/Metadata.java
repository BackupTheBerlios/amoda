/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.metadata.Metadata
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

package de.gulden.framework.amoda.model.metadata;

import de.gulden.framework.amoda.model.data.*;
import java.util.*;
import java.util.Collection;

/**
 * Class Metadata.
 */
public interface Metadata {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the schema.
     *  
     * @return  The schema.
     */
    public MetadataSchema getSchema();

    /**
     * Returns the entries.
     *  
     * @return  The entries.
     */
    public Collection getEntries();

    /**
     * Returns the entry.
     *  
     * @param name The name.
     * @return  The entry.
     */
    public MetadataEntry getEntry(String name);

    /**
     *  
     * @return  The string.
     */
    public String toString();

    /**
     *  
     * @param name The name.
     * @return  The string.
     */
    public String get(String name);

} // end Metadata
