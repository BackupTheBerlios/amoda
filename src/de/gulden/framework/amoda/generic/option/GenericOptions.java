/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.option.GenericOptions
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

package de.gulden.framework.amoda.generic.option;

import de.gulden.framework.amoda.generic.data.*;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.option.Option;
import de.gulden.framework.amoda.model.option.OptionEntry;
import de.gulden.framework.amoda.model.option.Options;
import de.gulden.framework.amoda.model.option.OptionsGroup;
import de.gulden.util.xml.XMLHandler;
import de.gulden.util.xml.XMLToolbox;
import java.awt.Color;
import java.io.File;
import java.util.*;
import java.util.Collection;
import java.util.Hashtable;

/**
 * Class GenericOptions.
 */
public class GenericOptions extends GenericOption implements Options {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The generic option entry.
     */
    public Collection genericOptionEntry=new Vector();

    /**
     * The generic options.
     */
    public Collection genericOptions=new Vector();

    /**
     * The options hash.
     */
    protected Hashtable optionsHash=new Hashtable();


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericOptions.
     */
    public GenericOptions() {
        // your code here

    }

    /**
     * Creates a new instance of GenericOptions.
     *  
     * @param environment The environment.
     */
    public GenericOptions(ApplicationEnvironment environment) {
        super(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the options hash.
     *  
     * @return  The options hash.
     */
    public Hashtable getOptionsHash() {
        return optionsHash;

    }

    /**
     * Sets the options hash.
     *  
     * @param _optionsHash The options hash.
     */
    public void setOptionsHash(Hashtable _optionsHash) {
        optionsHash = _optionsHash;

    }

    /**
     * Returns the generic option entrys.
     *  
     * @return  The generic option entrys.
     */
    public Collection getGenericOptionEntrys() {
        return genericOptionEntry;

    }

    /**
     * Adds a generic option entry.
     *  
     * @param genericOptionEntry The generic option entry.
     */
    public void addGenericOptionEntry(GenericOptionEntry genericOptionEntry) {
        if (! this.genericOptionEntry.contains(genericOptionEntry)) this.genericOptionEntry.add(genericOptionEntry);

    }

    /**
     * Removes a generic option entry.
     *  
     * @param genericOptionEntry The generic option entry.
     */
    public void removeGenericOptionEntry(GenericOptionEntry genericOptionEntry) {
        this.genericOptionEntry.remove(genericOptionEntry);

    }

    /**
     * Returns the generic optionss.
     *  
     * @return  The generic optionss.
     */
    public Collection getGenericOptionss() {
        return genericOptions;

    }

    /**
     * Adds a generic options.
     *  
     * @param genericOptions The generic options.
     */
    public void addGenericOptions(GenericOptions genericOptions) {
        if (! this.genericOptions.contains(genericOptions)) this.genericOptions.add(genericOptions);

    }

    /**
     * Removes a generic options.
     *  
     * @param genericOptions The generic options.
     */
    public void removeGenericOptions(GenericOptions genericOptions) {
        this.genericOptions.remove(genericOptions);

    }

    /**
     * Returns the entries.
     *  
     * @return  The entries.
     */
    public Collection getEntries() {
        return genericOptionEntry;

    }

    /**
     * Returns the entry.
     *  
     * @param id The id.
     * @return  The entry.
     */
    public OptionEntry getEntry(String id) {
        OptionEntry option=(OptionEntry)optionsHash.get(id);
        if (option!=null) {
            return option;
        } else {
            throw new de.gulden.framework.amoda.model.option.IllegalOptionError("unknown option '"+id+"'");
        }

    }

    /**
     * Returns the groups.
     *  
     * @return  The groups.
     */
    public Collection getGroups() {
        return genericOptions;

    }

    /**
     * Returns the group.
     *  
     * @param id The id.
     * @return  The group.
     */
    public OptionsGroup getGroup(String id) {
        return (OptionsGroup)optionsHash.get(id);

    }

    /**
     * Returns the string.
     *  
     * @param name The name.
     * @return  The string.
     */
    public String getString(String name) {
        de.gulden.framework.amoda.model.option.OptionEntry e=getEntry(name);
        de.gulden.framework.amoda.model.data.Value v=e.getValue();
        if (v!=null) {
            return v.getString();
        } else {
            return null;
        }

    }

    /**
     * Returns the int.
     *  
     * @param name The name.
     * @return  The int.
     */
    public int getInt(String name) {
        de.gulden.framework.amoda.model.option.OptionEntry e=getEntry(name);
        de.gulden.framework.amoda.model.data.Value v=e.getValue();
        if (v!=null) {
            return v.getInt();
        } else {
            return -1;
        }

    }

    /**
     * Returns the double.
     *  
     * @param name The name.
     * @return  The double.
     */
    public double getDouble(String name) {
        de.gulden.framework.amoda.model.option.OptionEntry e=getEntry(name);
        de.gulden.framework.amoda.model.data.Value v=e.getValue();
        if (v!=null) {
            return v.getDouble();
        } else {
            return -1.0;
        }

    }

    /**
     * Returns the boolean.
     *  
     * @param name The name.
     * @return  The boolean.
     */
    public boolean getBoolean(String name) {
        de.gulden.framework.amoda.model.option.OptionEntry e=getEntry(name);
        de.gulden.framework.amoda.model.data.Value v=e.getValue();
        if (v!=null) {
            return v.getBoolean();
        } else {
            return false;
        }

    }

    /**
     * Returns the object.
     *  
     * @param id The id.
     * @return  The object.
     */
    public Object getObject(String id) {
        de.gulden.framework.amoda.model.option.OptionEntry e=getEntry(id);
        de.gulden.framework.amoda.model.data.Value v=e.getValue();
        if (v!=null) {
            return v.getObject();
        } else {
            return null;
        }

    }

    /**
     *  
     * @return  The boolean.
     */
    public boolean isValid() {
        // your code here
        return true;

    }

    /**
     * Adds a option.
     *  
     * @param option The option.
     */
    public void addOption(Option option) {
        optionsHash.put(option.getId(),option);
        if (option instanceof GenericOptionEntry) {
            addGenericOptionEntry((GenericOptionEntry)option);
        } else if (option instanceof GenericOptions) {
            addGenericOptions((GenericOptions)option);
        }

    }

    /**
     *  
     * @param propertiesFilename The properties filename.
     */
    public void loadFromProperties(String propertiesFilename) {
        try {
            Properties props=new Properties();
            java.io.FileInputStream f=new java.io.FileInputStream(propertiesFilename);
            props.load(f);
            f.close();
            for (Enumeration e=props.keys();e.hasMoreElements();) {
                String id=(String)e.nextElement();
                String value=props.getProperty(id);
                GenericOptionEntry o=(GenericOptionEntry)getEntry(id);
                ((de.gulden.framework.amoda.generic.data.GenericValue)o.getValue(STATE_SAVED)).parseString(value);
            }
        } catch (java.io.IOException ioe) {
            de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment env=(de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment)getEnvironment();
            env.doLogMessage(env.createDefaultLogMessage("unable to load properties file - using defaults",null,0,null));
        }

    }

    /**
     * Returns the file.
     *  
     * @param id The id.
     * @return  The file.
     */
    public File getFile(String id) {
        de.gulden.framework.amoda.model.option.OptionEntry e=getEntry(id);
        de.gulden.framework.amoda.model.data.Value v=e.getValue();
        if (v!=null) {
            return v.getFile();
        } else {
            return null;
        }

    }

    /**
     * Returns the color.
     *  
     * @param id The id.
     * @return  The color.
     */
    public Color getColor(String id) {
        de.gulden.framework.amoda.model.option.OptionEntry e=getEntry(id);
        de.gulden.framework.amoda.model.data.Value v=e.getValue();
        if (v!=null) {
            return v.getColor();
        } else {
            return null;
        }

    }

    /**
     * Adds a all.
     *  
     * @param options The options.
     */
    public void addAll(Options options) {
        addAll(options,false);

    }

    /**
     * Adds a all.
     *  
     * @param options The options.
     * @param addInFront The add in front.
     */
    public void addAll(Options options, boolean addInFront) {
        for (Iterator it=options.getEntries().iterator();it.hasNext();) {
            Option option=(Option)it.next();
            addOption(option);
            if (addInFront) {
                moveToFrontInAssociations(option);
            }
        }
        for (Iterator it=options.getGroups().iterator();it.hasNext();) {
            Option option=(Option)it.next();
            addOption(option);
            if (addInFront) {
                moveToFrontInAssociations(option);
            }
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
                // element is root element "application-environment"
                XMLToolbox.requireTagName(element,"options");
                org.w3c.dom.Element e=XMLToolbox.getFirstChild(element);
                // single option entries don't have their own XMLHandler, so "deserialize" them here
                parseOptionsXML(e,null,serializer);
            }
            
            private void parseOptionsXML(org.w3c.dom.Element e,GenericOptions parentGroup,de.gulden.util.xml.XMLSerializer serializer) throws de.gulden.util.xml.XMLException {
                while (e!=null) {
                    String tagname = e.getTagName();
                    String id = e.getAttribute("id");
                    String description = XMLToolbox.getLangstring(XMLToolbox.getChild(e,"description"),null);
                    GenericOption o;
                    if (tagname.equals("options-group")) {
                        o=new GenericOptions(); // implements OptionsGroup
                    } else if (tagname.equals("option")) {
                        o=new GenericOptionEntry();
                    } else if (tagname.equals("option-choice")) {
                        o=new GenericOptionChoice();
                    } else {
                        throw new de.gulden.util.xml.XMLException("unknown tag <"+tagname+">");
                    }
                    o.setId(id);
                    o.setMetadata(((de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment)getEnvironment()).createDefaultMetadata(id,description)); // use id again as title
                    o.setEnvironment(getEnvironment());
                    o.setParentGroup(parentGroup);
                    if (parentGroup!=null) {
                        parentGroup.addOption(o);
                    }
                    GenericOptions.this.addOption(o);
                    if (o instanceof GenericOptions) { // GenericOptions OR GenericOptionChoice
                        parseOptionsXML(XMLToolbox.getFirstChild(e),(GenericOptions)o,serializer); // RECURSION, with this group as current parent group, all inner options are still inserted here
                    } else if (o instanceof GenericOptionEntry) {
                        Class type;
                        String typeName = XMLToolbox.getChildText(e,"type");
                        if (typeName==null) {
                            typeName = "java.lang.String"; // default option type
                        } else {
                            typeName=typeName.trim();
                        }
                        try {
                            type = de.gulden.util.Toolbox.getPrimitiveTypeWrapperClass(typeName); // maybe it's a primitive type - use wrapper class then
                        } catch (ClassNotFoundException cnfe1) {
                            try {
                                type = Class.forName(typeName); // get as normal class
                            } catch (ClassNotFoundException cnfe2) {
                                throw new de.gulden.util.xml.XMLException("cannot load class '"+typeName+"' for option '"+id+"'");
                            }
                        }
                        String defaultValueString = XMLToolbox.getChildText(e,"default-value"); // may be null
                        GenericOptionEntry optionEntry=(GenericOptionEntry)o;
                        optionEntry.setType(type);
                        if (defaultValueString!=null) {
                            ((de.gulden.framework.amoda.generic.data.GenericValue)optionEntry.getValue(de.gulden.framework.amoda.model.option.Option.STATE_DEFAULT)).parseString(defaultValueString.trim());
                        }
                    }
                    e=XMLToolbox.getFollowingElement(e);
                }
            }
            
            public void toXML(org.w3c.dom.Element element,de.gulden.util.xml.XMLSerializer serializer) {
            }
            
            public org.w3c.dom.Element getSchemaFragment(org.w3c.dom.Document document) {
                return null;
            }
            
            public String getDTDFragment() {
                String dtd;
                dtd="<!ELEMENT application (metadata?,options?,members?)>\n"
                   +"<!ATTLIST application\n"
                   +"          version ID #REQUIRED>\n"
                   +"<!ENTITY interaction-member message|log-message|question|dialog|wizard>\n"
                   +"<!ENTITY behaviour-member command|condition|rule|state>\n"
                   +"<!ELEMENT members (%interaction-member;|%behaviour-member;)*>\n"
                   +(new de.gulden.framework.amoda.generic.option.GenericOptions()).getXMLHandler().getDTDFragment()
                   +(new de.gulden.framework.amoda.generic.metadata.GenericMetadata()).getXMLHandler().getDTDFragment()
                   +(new de.gulden.framework.amoda.generic.interaction.GenericMessage()).getXMLHandler().getDTDFragment()
                   +(new de.gulden.framework.amoda.generic.interaction.GenericLogMessage()).getXMLHandler().getDTDFragment()
                   +(new de.gulden.framework.amoda.generic.interaction.GenericErrorMessage()).getXMLHandler().getDTDFragment()
                   +(new de.gulden.framework.amoda.generic.interaction.GenericQuestion()).getXMLHandler().getDTDFragment()
                   +(new de.gulden.framework.amoda.generic.interaction.GenericDialog()).getXMLHandler().getDTDFragment()
                   +(new de.gulden.framework.amoda.generic.interaction.GenericWizard()).getXMLHandler().getDTDFragment();
                return dtd;
            }
        };

    }

    /**
     *  
     * @param option The option.
     */
    private void moveToFrontInAssociations(Option option) {
        // after adding, move to front in those Vectors representing the multiple association
        // (this is quite a dirty solution)
        if (genericOptionEntry.remove(option)) {
            ((Vector)genericOptionEntry).insertElementAt(option,0);
        }
        if (genericOptions.remove(option)) {
            ((Vector)genericOptions).insertElementAt(option,0);
        }

    }

} // end GenericOptions
