/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.core.AbstractArgsParser
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
 * Class AbstractArgsParser.
 */
public abstract class AbstractArgsParser implements ArgsParser, SingleArgParser {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The single arg parser.
     */
    protected SingleArgParser singleArgParser;


    // ------------------------------------------------------------------------
    // --- constructor                                                      ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of AbstractArgsParser.
     */
    public AbstractArgsParser() {
        setSingleArgParser(this);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the single arg parser.
     *  
     * @return  The single arg parser.
     */
    public SingleArgParser getSingleArgParser() {
        return singleArgParser;

    }

    /**
     * Sets the single arg parser.
     *  
     * @param _singleArgParser The single arg parser.
     */
    public void setSingleArgParser(SingleArgParser _singleArgParser) {
        singleArgParser = _singleArgParser;

    }

} // end AbstractArgsParser
