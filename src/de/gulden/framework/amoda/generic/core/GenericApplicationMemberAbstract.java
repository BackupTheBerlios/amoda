/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.core.GenericApplicationMemberAbstract
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

package de.gulden.framework.amoda.generic.core;

import de.gulden.framework.amoda.generic.metadata.*;
import de.gulden.framework.amoda.generic.option.*;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.metadata.Metadata;
import de.gulden.util.xml.XMLHandler;
import java.util.*;

/**
 * Class GenericApplicationMemberAbstract.
 */
public abstract class GenericApplicationMemberAbstract implements GenericApplicationMemberInterface {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The id.
     */
    protected String id;

    /**
     * The environment.
     */
    protected ApplicationEnvironment environment;

    /**
     * The metadata.
     */
    protected Metadata metadata;

    /**
     * The x m l handler.
     */
    protected XMLHandler xMLHandler;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericApplicationMemberAbstract.
     */
    public GenericApplicationMemberAbstract() {
        super();
        setXMLHandler(createXMLHandler());
        setMetadata(createMetadata()); // by default, keeps metadata==null

    }

    /**
     * Creates a new instance of GenericApplicationMemberAbstract.
     *  
     * @param environment The environment.
     */
    public GenericApplicationMemberAbstract(ApplicationEnvironment environment) {
        this();
        setEnvironment(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the id.
     *  
     * @return  The id.
     */
    public String getId() {
        return id;

    }

    /**
     * Sets the id.
     *  
     * @param _id The id.
     */
    public void setId(String _id) {
        id = _id;

    }

    /**
     * Returns the environment.
     *  
     * @return  The environment.
     */
    public ApplicationEnvironment getEnvironment() {
        return environment;

    }

    /**
     * Sets the environment.
     *  
     * @param _environment The environment.
     */
    public void setEnvironment(ApplicationEnvironment _environment) {
        environment = _environment;

    }

    /**
     * Returns the metadata.
     *  
     * @return  The metadata.
     */
    public Metadata getMetadata() {
        return metadata;

    }

    /**
     * Sets the metadata.
     *  
     * @param _metadata The metadata.
     */
    public void setMetadata(Metadata _metadata) {
        metadata = _metadata;

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
     * Creates the metadata.
     *  
     * @return  The metadata.
     */
    protected Metadata createMetadata() {
        return null; // may be overwritten by subclasses (not used here)

    }

    /**
     * Creates the x m l handler.
     *  
     * @return  The x m l handler.
     */
    protected abstract XMLHandler createXMLHandler();

} // end GenericApplicationMemberAbstract
