/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.data.Value
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

package de.gulden.framework.amoda.model.data;

import java.awt.Color;
import java.io.File;
import java.util.*;

/**
 * Class Value.
 */
public interface Value {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the string.
     *  
     * @return  The string.
     */
    public String getString();

    /**
     * Returns the object.
     *  
     * @return  The object.
     */
    public Object getObject();

    /**
     * Returns the boolean.
     *  
     * @return  The boolean.
     */
    public boolean getBoolean();

    /**
     * Returns the int.
     *  
     * @return  The int.
     */
    public int getInt();

    /**
     * Returns the double.
     *  
     * @return  The double.
     */
    public double getDouble();

    /**
     *  
     * @param type The type.
     * @return  The boolean.
     */
    public boolean isTypeAvailable(Class type);

    /**
     * Returns the file.
     *  
     * @return  The file.
     */
    public File getFile();

    /**
     * Returns the color.
     *  
     * @return  The color.
     */
    public Color getColor();

} // end Value
