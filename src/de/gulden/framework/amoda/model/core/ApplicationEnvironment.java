/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.core.ApplicationEnvironment
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
import de.gulden.framework.amoda.model.interaction.DialogPerformer;
import de.gulden.framework.amoda.model.interaction.ErrorMessagePerformer;
import de.gulden.framework.amoda.model.interaction.LogMessagePerformer;
import de.gulden.framework.amoda.model.interaction.MessagePerformer;
import de.gulden.framework.amoda.model.interaction.QuestionPerformer;
import de.gulden.framework.amoda.model.metadata.*;
import de.gulden.framework.amoda.model.option.*;
import java.util.*;

/**
 * Class ApplicationEnvironment.
 */
public interface ApplicationEnvironment extends MetadataProvider, DialogPerformer, ErrorMessagePerformer, MessagePerformer, QuestionPerformer, LogMessagePerformer, InputValuesProvider {

    // ------------------------------------------------------------------------
    // --- method                                                           ---
    // ------------------------------------------------------------------------
    /**
     *  
     * @param application The application.
     */
    public void launch(Application application);

} // end ApplicationEnvironment
