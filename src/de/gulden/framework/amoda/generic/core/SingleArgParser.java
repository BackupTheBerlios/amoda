/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.core.SingleArgParser
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

package de.gulden.framework.amoda.generic.core;

import de.gulden.framework.amoda.generic.metadata.*;
import de.gulden.framework.amoda.generic.option.*;
import java.util.*;

/**
 * Class SingleArgParser.
 */
public interface SingleArgParser {

    // ------------------------------------------------------------------------
    // --- method                                                           ---
    // ------------------------------------------------------------------------
    /**
     * Parses the individual option.
     *  
     * @param name The name.
     * @param suggestedValue The suggested value.
     * @param options The options.
     * @return  The boolean.
     */
    public boolean parseIndividualOption(String name, String suggestedValue, GenericOptions options);

} // end SingleArgParser
