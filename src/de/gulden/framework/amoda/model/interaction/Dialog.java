/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.interaction.Dialog
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

package de.gulden.framework.amoda.model.interaction;

import de.gulden.framework.amoda.model.option.*;
import java.util.*;
import java.util.Collection;

/**
 * Class Dialog.
 */
public interface Dialog extends OptionsProvider, InteractionMember {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    public void reset();

    /**
     * Returns the questions.
     *  
     * @return  The questions.
     */
    public Collection getQuestions();

} // end Dialog
