/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.metadata.GenericMetadataEntry
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
import de.gulden.framework.amoda.model.metadata.MetadataEntry;
import de.gulden.framework.amoda.model.metadata.MetadataSchema;
import java.util.*;

/**
 * Class GenericMetadataEntry.
 */
public class GenericMetadataEntry extends GenericValue implements MetadataEntry {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The generic metadata.
     */
    public GenericMetadata genericMetadata;

    /**
     * The source.
     */
    protected String source;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericMetadataEntry.
     */
    public GenericMetadataEntry() {
        // your code here

    }

    /**
     * Creates a new instance of GenericMetadataEntry.
     *  
     * @param name The name.
     * @param value The value.
     */
    public GenericMetadataEntry(String name, Object value) {
        setName(name);
        setObject(value);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the source.
     *  
     * @return  The source.
     */
    public String getSource() {
        return source;

    }

    /**
     * Sets the source.
     *  
     * @param _source The source.
     */
    public void setSource(String _source) {
        source = _source;

    }

    /**
     * Returns the generic metadata.
     *  
     * @return  The generic metadata.
     */
    public GenericMetadata getGenericMetadata() {
        return genericMetadata;

    }

    /**
     * Sets the generic metadata.
     *  
     * @param genericMetadata The generic metadata.
     */
    public void setGenericMetadata(GenericMetadata genericMetadata) {
        if (this.genericMetadata != genericMetadata) {
            if (this.genericMetadata != null) this.genericMetadata.removeGenericMetadataEntry(this);
            this.genericMetadata = genericMetadata;
            if (genericMetadata != null) genericMetadata.addGenericMetadataEntry(this);
        }

    }

    /**
     * Returns the schema.
     *  
     * @return  The schema.
     */
    public MetadataSchema getSchema() {
        return getGenericMetadata().getSchema();

    }

    /**
     *  
     * @return  The string.
     */
    public String toString() {
        return super.toString(); // make access public

    }

} // end GenericMetadataEntry
