/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.core.LogFile
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
import de.gulden.framework.amoda.model.interaction.LogMessage;
import de.gulden.framework.amoda.model.interaction.LogMessagePerformer;
import java.io.File;
import java.util.*;

/**
 * Class LogFile.
 */
public class LogFile implements LogMessagePerformer {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The file.
     */
    protected File file;

    /**
     * The max flush count.
     */
    protected int maxFlushCount;

    /**
     * The max flush millisecs.
     */
    protected long maxFlushMillisecs;


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the file.
     *  
     * @return  The file.
     */
    public File getFile() {
        return file;

    }

    /**
     * Sets the file.
     *  
     * @param _file The file.
     */
    public void setFile(File _file) {
        file = _file;

    }

    /**
     * Returns the max flush count.
     *  
     * @return  The max flush count.
     */
    public int getMaxFlushCount() {
        return maxFlushCount;

    }

    /**
     * Sets the max flush count.
     *  
     * @param _maxFlushCount The max flush count.
     */
    public void setMaxFlushCount(int _maxFlushCount) {
        maxFlushCount = _maxFlushCount;

    }

    /**
     * Returns the max flush millisecs.
     *  
     * @return  The max flush millisecs.
     */
    public long getMaxFlushMillisecs() {
        return maxFlushMillisecs;

    }

    /**
     * Sets the max flush millisecs.
     *  
     * @param _maxFlushMillisecs The max flush millisecs.
     */
    public void setMaxFlushMillisecs(long _maxFlushMillisecs) {
        maxFlushMillisecs = _maxFlushMillisecs;

    }

    public void open() {
        // your code here

    }

    /**
     *  
     * @param logMessage The log message.
     */
    public void doLogMessage(LogMessage logMessage) {
        // your code here

    }

    public void flush() {
        // your code here

    }

    public void close() {
        // your code here

    }

} // end LogFile
