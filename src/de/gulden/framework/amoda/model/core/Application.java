/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.core.Application
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

package de.gulden.framework.amoda.model.core;

import de.gulden.framework.amoda.model.behaviour.*;
import de.gulden.framework.amoda.model.metadata.*;
import de.gulden.framework.amoda.model.option.*;
import java.util.*;

/**
 * Class Application.
 */
public interface Application extends ApplicationMember, OptionsProvider {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     *  
     * @param environment The environment.
     */
    public void init(ApplicationEnvironment environment);

    public void start();

    public void stop();

    public void destroy();

} // end Application
