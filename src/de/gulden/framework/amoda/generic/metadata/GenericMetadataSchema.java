/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.metadata.GenericMetadataSchema
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

package de.gulden.framework.amoda.generic.metadata;

import de.gulden.framework.amoda.generic.data.*;
import de.gulden.framework.amoda.model.metadata.MetadataSchema;
import java.util.*;

/**
 * Class GenericMetadataSchema.
 */
public class GenericMetadataSchema implements MetadataSchema {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The version.
     */
    protected String version;

    /**
     * The name.
     */
    private String name;


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the version.
     *  
     * @return  The version.
     */
    public String getVersion() {
        return version;

    }

    /**
     * Sets the version.
     *  
     * @param _version The version.
     */
    public void setVersion(String _version) {
        version = _version;

    }

    /**
     * Returns the name.
     *  
     * @return  The name.
     */
    public String getName() {
        return name;

    }

    /**
     * Sets the name.
     *  
     * @param _name The name.
     */
    public void setName(String _name) {
        name = _name;

    }

} // end GenericMetadataSchema
