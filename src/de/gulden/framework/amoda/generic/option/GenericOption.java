/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.option.GenericOption
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

import de.gulden.framework.amoda.generic.core.GenericApplicationMemberAbstract;
import de.gulden.framework.amoda.generic.data.*;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.option.Option;
import de.gulden.framework.amoda.model.option.OptionsGroup;
import java.util.*;

/**
 * Class GenericOption.
 */
public abstract class GenericOption extends GenericApplicationMemberAbstract implements Option {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The parent group.
     */
    protected OptionsGroup parentGroup;

    /**
     * The description.
     */
    protected String description;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericOption.
     */
    public GenericOption() {
        super();

    }

    /**
     * Creates a new instance of GenericOption.
     *  
     * @param environment The environment.
     */
    public GenericOption(ApplicationEnvironment environment) {
        super(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the parent group.
     *  
     * @return  The parent group.
     */
    public OptionsGroup getParentGroup() {
        return parentGroup;

    }

    /**
     * Sets the parent group.
     *  
     * @param _parentGroup The parent group.
     */
    public void setParentGroup(OptionsGroup _parentGroup) {
        parentGroup = _parentGroup;

    }

    /**
     * Returns the description.
     *  
     * @return  The description.
     */
    public String getDescription() {
        return description;

    }

    /**
     * Sets the description.
     *  
     * @param _description The description.
     */
    public void setDescription(String _description) {
        description = _description;

    }

} // end GenericOption
