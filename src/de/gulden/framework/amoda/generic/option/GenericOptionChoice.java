/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.option.GenericOptionChoice
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
import de.gulden.framework.amoda.model.data.Value;
import de.gulden.framework.amoda.model.option.OptionChoice;
import de.gulden.framework.amoda.model.option.OptionEntry;
import java.util.*;
import java.util.Collection;

/**
 * Class GenericOptionChoice.
 */
public class GenericOptionChoice extends GenericOptions implements OptionChoice {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The options.
     */
    protected Collection options;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericOptionChoice.
     */
    public GenericOptionChoice() {
        // your code here

    }

    /**
     * Creates a new instance of GenericOptionChoice.
     *  
     * @param environment The environment.
     */
    public GenericOptionChoice(ApplicationEnvironment environment) {
        super(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the options.
     *  
     * @return  The options.
     */
    public Collection getOptions() {
        return options;

    }

    /**
     * Sets the options.
     *  
     * @param _options The options.
     */
    public void setOptions(Collection _options) {
        options = _options;

    }

    /**
     * Returns the selected option.
     *  
     * @return  The selected option.
     */
    public OptionEntry getSelectedOption() {
        for (Iterator it=getEntries().iterator();it.hasNext();) {
            OptionEntry o=(OptionEntry)it.next();
            if (o.getValue().getBoolean()==true) {
                return o;
            }
        }
        return null;

    }

    /**
     * Returns the selected id.
     *  
     * @return  The selected id.
     */
    public String getSelectedId() {
        OptionEntry o=getSelectedOption();
        if (o!=null) {
            return o.getId();
        } else {
            return null;
        }

    }

    /**
     * Returns the value.
     *  
     * @return  The value.
     */
    public Value getValue() {
        // your code here
        return null;

    }

    /**
     * Returns the value.
     *  
     * @param state The state.
     * @return  The value.
     */
    public Value getValue(int state) {
        // your code here
        return null;

    }

    /**
     * Returns the type.
     *  
     * @return  The type.
     */
    public Class getType() {
        throw new AbstractMethodError("getType() is not available on GenericOptionsChoice");

    }

} // end GenericOptionChoice
