/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.metadata.MetadataEntry
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

/**
 * Class MetadataEntry.
 */
public interface MetadataEntry extends NamedValue {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the source.
     *  
     * @return  The source.
     */
    public String getSource();

    /**
     *  
     * @return  The string.
     */
    public String toString();

} // end MetadataEntry
