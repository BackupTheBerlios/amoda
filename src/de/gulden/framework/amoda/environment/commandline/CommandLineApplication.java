/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.environment.commandline.CommandLineApplication
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

package de.gulden.framework.amoda.environment.commandline;

import de.gulden.framework.amoda.environment.commandline.CommandLineApplicationEnvironmentFactory;
import de.gulden.framework.amoda.generic.core.ArgsParser;
import de.gulden.framework.amoda.generic.core.GenericApplication;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import java.net.URL;
import java.util.*;

/**
 * Class CommandLineApplication.
 */
public abstract class CommandLineApplication extends GenericApplication {

    // ------------------------------------------------------------------------
    // --- static field                                                     ---
    // ------------------------------------------------------------------------
    /**
     * The d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     */
    public static String DEFAULT_CONFIGURATION_RESOURCE=de.gulden.framework.amoda.generic.core.GenericApplicationEnvironmentFactory.DEFAULT_CONFIGURATION_RESOURCE;


    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The args array.
     */
    protected String[] args;

    /**
     * The configuration resource u r l.
     */
    protected URL configurationResourceURL;


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the args.
     *  
     * @return  The args array.
     */
    public String[] getArgs() {
        return args;

    }

    /**
     * Sets the args.
     *  
     * @param _args The args array.
     */
    public void setArgs(String[] _args) {
        args = _args;

    }

    /**
     * Returns the configuration resource u r l.
     *  
     * @return  The configuration resource u r l.
     */
    public URL getConfigurationResourceURL() {
        return configurationResourceURL;

    }

    /**
     * Sets the configuration resource u r l.
     *  
     * @param _configurationResourceURL The configuration resource u r l.
     */
    public void setConfigurationResourceURL(URL _configurationResourceURL) {
        configurationResourceURL = _configurationResourceURL;

    }

    /**
     *  
     * @param args The args.
     */
    public void run(String[] args) {
        run(args,DEFAULT_CONFIGURATION_RESOURCE);

    }

    /**
     *  
     * @param args The args.
     * @param configurationResource The configuration resource.
     */
    public void run(String[] args, String configurationResource) {
        java.net.URL url=this.getClass().getResource(configurationResource);
        setConfigurationResourceURL(url);
        setArgs(args);
        super.run();

    }

    /**
     * Creates the application environment.
     *  
     * @return  The application environment.
     */
    public ApplicationEnvironment createApplicationEnvironment() {
        de.gulden.framework.amoda.model.core.ApplicationEnvironmentFactory factory=new CommandLineApplicationEnvironmentFactory(getArgs(),getConfigurationResourceURL());
        return factory.createApplicationEnvironment();

    }

    /**
     *  
     * @param code The code.
     */
    public void executeCommand(String code) {
        // your code here

    }

    /**
     * Creates the args parser.
     *  
     * @return  The args parser.
     */
    public ArgsParser createArgsParser() {
        return new CommandLineArgsParser(((CommandLineApplicationEnvironment)getEnvironment()).getFactory().getArgs());

    }

    public void start() {
        message(createAboutMessage());
        super.start();
        // to be extended by subclasses

    }

    /**
     *  
     * @param environment The environment.
     */
    public void init(ApplicationEnvironment environment) {
        super.init(environment);

    }

    public void welcome() {
        about();

    }


    // ------------------------------------------------------------------------
    // --- static methods                                                   ---
    // ------------------------------------------------------------------------
    /**
     * Returns the d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     *  
     * @return  The d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     */
    public static String getDEFAULT_CONFIGURATION_RESOURCE() {
        return DEFAULT_CONFIGURATION_RESOURCE;

    }

    /**
     * Sets the d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     *  
     * @param _DEFAULT_CONFIGURATION_RESOURCE The d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     */
    public static void setDEFAULT_CONFIGURATION_RESOURCE(String _DEFAULT_CONFIGURATION_RESOURCE) {
        DEFAULT_CONFIGURATION_RESOURCE = _DEFAULT_CONFIGURATION_RESOURCE;

    }

} // end CommandLineApplication
