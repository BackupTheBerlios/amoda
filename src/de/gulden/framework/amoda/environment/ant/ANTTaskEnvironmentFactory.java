/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.environment.ant.ANTTaskEnvironmentFactory
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
import java.net.URL;
import java.util.*;

/**
 * Class ANTTaskEnvironmentFactory.
 */
public class ANTTaskEnvironmentFactory extends CommandLineApplicationEnvironmentFactory {

    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of ANTTaskEnvironmentFactory.
     */
    public ANTTaskEnvironmentFactory() {
        super(null);

    }

    /**
     * Creates a new instance of ANTTaskEnvironmentFactory.
     *  
     * @param configurationResource The configuration resource.
     */
    public ANTTaskEnvironmentFactory(URL configurationResource) {
        super(null,configurationResource);

    }


    // ------------------------------------------------------------------------
    // --- method                                                           ---
    // ------------------------------------------------------------------------
    /**
     * Returns the application class name.
     *  
     * @return  The application class name.
     */
    public String getApplicationClassName() {
        // overwrites CommandLineApplicationEnvironmentFactory.getApplicationClassName
        return "de.gulden.framework.amoda.environment.ant.ANTTaskEnvironment";

    }

} // end ANTTaskEnvironmentFactory
