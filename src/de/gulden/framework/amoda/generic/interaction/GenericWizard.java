/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.interaction.GenericWizard
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

package de.gulden.framework.amoda.generic.interaction;

import de.gulden.framework.amoda.generic.option.*;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.interaction.Wizard;
import java.util.*;
import java.util.Collection;

/**
 * Class GenericWizard.
 */
public class GenericWizard extends GenericDialog implements Wizard {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The dialogs.
     */
    protected Collection dialogs;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericWizard.
     */
    public GenericWizard() {
        // your code here

    }

    /**
     * Creates a new instance of GenericWizard.
     *  
     * @param environment The environment.
     */
    public GenericWizard(ApplicationEnvironment environment) {
        super(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the dialogs.
     *  
     * @return  The dialogs.
     */
    public Collection getDialogs() {
        return dialogs;

    }

    /**
     * Sets the dialogs.
     *  
     * @param _dialogs The dialogs.
     */
    public void setDialogs(Collection _dialogs) {
        dialogs = _dialogs;

    }

    public void perform() {
        ((de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment)getEnvironment()).doWizard(this);

    }

} // end GenericWizard
