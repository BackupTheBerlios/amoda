/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.environment.ant.ANTTaskApplicationWrapper
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

package de.gulden.framework.amoda.environment.ant;

import de.gulden.framework.amoda.environment.commandline.*;
import de.gulden.framework.amoda.generic.core.GenericApplication;
import java.net.URL;
import java.util.*;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.xml.sax.AttributeList;

/**
 * Class ANTTaskApplicationWrapper.
 */
public abstract class ANTTaskApplicationWrapper extends Task {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The src.
     */
    public Collection src=new Vector();

    /**
     * The original attributes.
     */
    protected AttributeList originalAttributes;

    /**
     * The application.
     */
    protected GenericApplication application;

    /**
     * The environment.
     */
    protected ANTTaskEnvironment environment;


    // ------------------------------------------------------------------------
    // --- constructor                                                      ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of ANTTaskApplicationWrapper.
     */
    public ANTTaskApplicationWrapper() {
        super();

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the original attributes.
     *  
     * @return  The original attributes.
     */
    public AttributeList getOriginalAttributes() {
        return originalAttributes;

    }

    /**
     * Sets the original attributes.
     *  
     * @param _originalAttributes The original attributes.
     */
    public void setOriginalAttributes(AttributeList _originalAttributes) {
        originalAttributes = _originalAttributes;

    }

    /**
     * Returns the application.
     *  
     * @return  The application.
     */
    public GenericApplication getApplication() {
        return application;

    }

    /**
     * Sets the application.
     *  
     * @param genericApplication The application.
     */
    public void setApplication(GenericApplication genericApplication) {
        this.application = genericApplication;

    }

    /**
     * Returns the environment.
     *  
     * @return  The environment.
     */
    public ANTTaskEnvironment getEnvironment() {
        return environment;

    }

    /**
     * Sets the environment.
     *  
     * @param aNTTaskEnvironment The environment.
     */
    public void setEnvironment(ANTTaskEnvironment aNTTaskEnvironment) {
        if (this.environment != aNTTaskEnvironment) {
            this.environment = aNTTaskEnvironment;
            if (aNTTaskEnvironment != null) aNTTaskEnvironment.setTaskWrapper(this);
        }

    }

    /**
     * Returns the srcs.
     *  
     * @return  The srcs.
     */
    public Collection getSrcs() {
        return src;

    }

    /**
     * Adds a src.
     *  
     * @param src The src.
     */
    public void addSrc(Src src) {
        if (! this.src.contains(src)) this.src.add(src);

    }

    /**
     * Removes a src.
     *  
     * @param src The src.
     */
    public void removeSrc(Src src) {
        this.src.remove(src);

    }

    /**
     * Creates the wrapped application.
     *  
     * @return  The generic application.
     */
    public abstract GenericApplication createWrappedApplication();

    public void init() {
        setApplication(createWrappedApplication());
        ANTTaskEnvironmentFactory f=new ANTTaskEnvironmentFactory(getConfigurationResourceURL());
        ANTTaskEnvironment env=(ANTTaskEnvironment)f.createApplicationEnvironment();
        env.setTaskWrapper(this);
        this.setEnvironment(env);

    }

    /**
     * Returns the configuration resource u r l.
     *  
     * @return  The configuration resource u r l.
     */
    public URL getConfigurationResourceURL() {
        // default, may be overwritten
        return getApplication().getClass().getResource(getConfigurationResourceName());

    }

    /**
     * Returns the configuration resource name.
     *  
     * @return  The configuration resource name.
     */
    public String getConfigurationResourceName() {
        return de.gulden.framework.amoda.generic.core.GenericApplicationEnvironmentFactory.DEFAULT_CONFIGURATION_RESOURCE;

    }

    public void execute() {
        try {
            getEnvironment().launch(getApplication());
        } catch (de.gulden.framework.amoda.model.option.IllegalOptionError ioe) {
            throw new BuildException(ioe);
        }

    }

    public void maybeConfigure() throws BuildException {
        if (getOriginalAttributes()==null) { // if first time here, set value now (before destroying original in wrapper)
            setOriginalAttributes(getRuntimeConfigurableWrapper().getAttributes());
        }
        // avoid introspection on attributes (which is done later) by forcing attributes to null (RuntimeConfigurable test if null and ignores in that case)
        getRuntimeConfigurableWrapper().setAttributes(new org.xml.sax.helpers.AttributeListImpl()); // set empty list to avoid introspection on attrinutes here
        // now continue the default way, all to do is handle nested <src> elements
        super.maybeConfigure();

    }

} // end ANTTaskApplicationWrapper
