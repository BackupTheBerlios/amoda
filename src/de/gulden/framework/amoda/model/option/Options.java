/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.option.Options
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

package de.gulden.framework.amoda.model.option;

import de.gulden.framework.amoda.model.data.*;
import java.awt.Color;
import java.io.File;
import java.util.*;

/**
 * Class Options.
 */
public interface Options extends OptionsGroup {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the string.
     *  
     * @param id The id.
     * @return  The string.
     */
    public String getString(String id);

    /**
     * Returns the int.
     *  
     * @param id The id.
     * @return  The int.
     */
    public int getInt(String id);

    /**
     * Returns the double.
     *  
     * @param id The id.
     * @return  The double.
     */
    public double getDouble(String id);

    /**
     * Returns the boolean.
     *  
     * @param id The id.
     * @return  The boolean.
     */
    public boolean getBoolean(String id);

    /**
     * Returns the object.
     *  
     * @param id The id.
     * @return  The object.
     */
    public Object getObject(String id);

    /**
     * Returns the file.
     *  
     * @param id The id.
     * @return  The file.
     */
    public File getFile(String id);

    /**
     * Returns the color.
     *  
     * @param id The id.
     * @return  The color.
     */
    public Color getColor(String id);

} // end Options
