/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.behaviour.Rule
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

package de.gulden.framework.amoda.model.behaviour;

import de.gulden.framework.amoda.model.core.ApplicationMember;
import java.util.*;

/**
 * Class Rule.
 */
public interface Rule extends ApplicationMember, BehaviourMember {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    public void apply();

    /**
     * Returns the condition.
     *  
     * @return  The condition.
     */
    public Condition getCondition();

    /**
     * Returns the command.
     *  
     * @return  The command.
     */
    public Command getCommand();

} // end Rule
