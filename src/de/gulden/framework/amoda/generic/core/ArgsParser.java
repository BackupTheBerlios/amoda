/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.core.ArgsParser
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
import de.gulden.framework.amoda.model.data.Value;
import java.util.*;
import java.util.Collection;

/**
 * Class ArgsParser.
 */
public interface ArgsParser {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Parses the options.
     *  
     * @param options The options.
     */
    public void parseOptions(GenericOptions options);

    /**
     * Parses the batch commands.
     *  
     * @param availableCommands The available commands.
     * @return  The collection.
     */
    public Collection parseBatchCommands(Collection availableCommands);

    /**
     * Parses the input values.
     *  
     * @return  The value array.
     */
    public Value[] parseInputValues();

    /**
     * Sets the single arg parser.
     *  
     * @param sap The single arg parser.
     */
    public void setSingleArgParser(SingleArgParser sap);

    /**
     * Returns the single arg parser.
     *  
     * @return  The single arg parser.
     */
    public SingleArgParser getSingleArgParser();

} // end ArgsParser
