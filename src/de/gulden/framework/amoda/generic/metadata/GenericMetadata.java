/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.metadata.GenericMetadata
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
import de.gulden.framework.amoda.model.metadata.Metadata;
import de.gulden.framework.amoda.model.metadata.MetadataEntry;
import de.gulden.framework.amoda.model.metadata.MetadataSchema;
import de.gulden.util.xml.XMLHandler;
import de.gulden.util.xml.XMLSerializable;
import java.util.*;
import java.util.Collection;
import java.util.Hashtable;

/**
 * Class GenericMetadata.
 */
public class GenericMetadata implements Metadata, XMLSerializable {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The generic metadata entry.
     */
    public Collection genericMetadataEntry=new ArrayList();

    /**
     * The generic metadata schema.
     */
    public GenericMetadataSchema genericMetadataSchema;

    /**
     * The metadata entries.
     */
    protected Hashtable metadataEntries;

    /**
     * The x m l handler.
     */
    protected XMLHandler xMLHandler;


    // ------------------------------------------------------------------------
    // --- constructor                                                      ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericMetadata.
     */
    public GenericMetadata() {
        setXMLHandler(createXMLHandler());
        metadataEntries=new Hashtable();

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the metadata entries.
     *  
     * @return  The metadata entries.
     */
    public Hashtable getMetadataEntries() {
        return metadataEntries;

    }

    /**
     * Sets the metadata entries.
     *  
     * @param _metadataEntries The metadata entries.
     */
    public void setMetadataEntries(Hashtable _metadataEntries) {
        metadataEntries = _metadataEntries;

    }

    /**
     * Returns the x m l handler.
     *  
     * @return  The x m l handler.
     */
    public XMLHandler getXMLHandler() {
        return xMLHandler;

    }

    /**
     * Sets the x m l handler.
     *  
     * @param _xMLHandler The x m l handler.
     */
    public void setXMLHandler(XMLHandler _xMLHandler) {
        xMLHandler = _xMLHandler;

    }

    /**
     * Returns the generic metadata entrys.
     *  
     * @return  The generic metadata entrys.
     */
    public Collection getGenericMetadataEntrys() {
        return genericMetadataEntry;

    }

    /**
     * Adds a generic metadata entry.
     *  
     * @param genericMetadataEntry The generic metadata entry.
     */
    public void addGenericMetadataEntry(GenericMetadataEntry genericMetadataEntry) {
        if (! this.genericMetadataEntry.contains(genericMetadataEntry)) {
            this.genericMetadataEntry.add(genericMetadataEntry);
            genericMetadataEntry.setGenericMetadata(this);
        }

    }

    /**
     * Removes a generic metadata entry.
     *  
     * @param genericMetadataEntry The generic metadata entry.
     */
    public void removeGenericMetadataEntry(GenericMetadataEntry genericMetadataEntry) {
        boolean removed = this.genericMetadataEntry.remove(genericMetadataEntry);
        if (removed) genericMetadataEntry.setGenericMetadata((GenericMetadata)null);

    }

    /**
     * Returns the generic metadata schema.
     *  
     * @return  The generic metadata schema.
     */
    public GenericMetadataSchema getGenericMetadataSchema() {
        return genericMetadataSchema;

    }

    /**
     * Sets the generic metadata schema.
     *  
     * @param genericMetadataSchema The generic metadata schema.
     */
    public void setGenericMetadataSchema(GenericMetadataSchema genericMetadataSchema) {
        this.genericMetadataSchema = genericMetadataSchema;

    }

    /**
     * Returns the schema.
     *  
     * @return  The schema.
     */
    public MetadataSchema getSchema() {
        // your code here
        return null;

    }

    /**
     * Returns the entries.
     *  
     * @return  The entries.
     */
    public Collection getEntries() {
        return metadataEntries.values();

    }

    /**
     * Returns the entry.
     *  
     * @param name The name.
     * @return  The entry.
     */
    public MetadataEntry getEntry(String name) {
        return (MetadataEntry)metadataEntries.get(name);

    }

    /**
     *  
     * @return  The string.
     */
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for (Iterator it=getEntries().iterator();it.hasNext();) {
            MetadataEntry entry=(MetadataEntry)it.next();
            sb.append(entry.toString()+de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment.NL);
        }
        return sb.toString();

    }

    /**
     * Adds a entry.
     *  
     * @param name The name.
     * @param value The value.
     */
    public void addEntry(String name, Object value) {
        metadataEntries.put(name,new GenericMetadataEntry(name,value));

    }

    /**
     *  
     * @param name The name.
     * @return  The string.
     */
    public String get(String name) {
        GenericMetadataEntry entry=(GenericMetadataEntry)getEntry(name);
        if (entry!=null) {
            return entry.getString();
        } else {
            return null;
        }

    }

    /**
     * Creates the x m l handler.
     *  
     * @return  The x m l handler.
     */
    protected XMLHandler createXMLHandler() {
        return new XMLHandler() {
            public void parseXML(org.w3c.dom.Element element,de.gulden.util.xml.XMLSerializer serializer) throws de.gulden.util.xml.XMLException {
                handleEntry("title",element,true);
                handleEntry("name",element,false);
                handleEntry("longname",element,true);
                handleEntry("version",element,false);
                handleEntry("author",element,false);
                handleEntry("email",element,false);
                handleEntry("copyright",element,true);
                handleEntry("description",element,true);
                handleEntry("license",element,false);
                handleEntry("license-message",element,true);
            }
            
            private void handleEntry(String entryName,org.w3c.dom.Element element,boolean langstring) {
                org.w3c.dom.Element e=de.gulden.util.xml.XMLToolbox.getChild(element,entryName);
                if (e!=null) {
                    String text;
                    if (langstring) {
                        text=de.gulden.util.xml.XMLToolbox.getLangstring(e); // *** ADD langauge!!!* ****
                    } else {
                        text=de.gulden.util.xml.XMLToolbox.getText(e);
                    }
                    addEntry(entryName,text);
                }
            }
            
            public void toXML(org.w3c.dom.Element element,de.gulden.util.xml.XMLSerializer serializer) {
            }
            
            public org.w3c.dom.Element getSchemaFragment(org.w3c.dom.Document document) {
                return null;
            }
            
            public String getDTDFragment() {
                return null;
            }
        };

    }

} // end GenericMetadata
