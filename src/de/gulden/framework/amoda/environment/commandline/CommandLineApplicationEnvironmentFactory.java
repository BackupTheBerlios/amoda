/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.environment.commandline.CommandLineApplicationEnvironmentFactory
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

import de.gulden.framework.amoda.generic.core.GenericApplicationEnvironmentFactory;
import de.gulden.util.xml.XMLSerializer;
import java.net.URL;
import java.util.*;

/**
 * Class CommandLineApplicationEnvironmentFactory.
 */
public class CommandLineApplicationEnvironmentFactory extends GenericApplicationEnvironmentFactory {

    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of CommandLineApplicationEnvironmentFactory.
     *  
     * @param args The args.
     */
    public CommandLineApplicationEnvironmentFactory(String[] args) {
        super(args);

    }

    /**
     * Creates a new instance of CommandLineApplicationEnvironmentFactory.
     *  
     * @param args The args.
     * @param configurationResource The configuration resource.
     */
    public CommandLineApplicationEnvironmentFactory(String[] args, URL configurationResource) {
        super(args,configurationResource);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Creates the x m l serializer.
     *  
     * @return  The x m l serializer.
     */
    protected XMLSerializer createXMLSerializer() {
        de.gulden.util.xml.XMLSerializerFactory f=new de.gulden.util.xml.XMLSerializerFactory();
        f.register("application",getApplicationClassName());
        f.register("command","de.gulden.framework.amoda.environment.commandline.CommandLineCommand");
        f.register("message","de.gulden.framework.amoda.generic.interaction.GenericMessage");
        f.register("log-message","de.gulden.framework.amoda.generic.interaction.GenericLogMessage");
        f.register("error-message","de.gulden.framework.amoda.generic.interaction.GenericErrorMessage");
        f.register("question","de.gulden.framework.amoda.generic.interaction.GenericQuestion");
        f.register("dialog","de.gulden.framework.amoda.generic.interaction.GenericDialog");
        f.register("wizard","de.gulden.framework.amoda.generic.interaction.GenericWizard");
        f.register("options","de.gulden.framework.amoda.generic.option.GenericOptions");
        f.register("option","de.gulden.framework.amoda.generic.option.GenericOptionEntry");
        f.register("metadata","de.gulden.framework.amoda.generic.metadata.GenericMetadata");
        // command
        // condition
        // rule
        // state
        return f.createXMLSerializer();

    }

    /**
     * Returns the application class name.
     *  
     * @return  The application class name.
     */
    protected String getApplicationClassName() {
        return "de.gulden.framework.amoda.environment.commandline.CommandLineApplicationEnvironment";

    }

} // end CommandLineApplicationEnvironmentFactory
