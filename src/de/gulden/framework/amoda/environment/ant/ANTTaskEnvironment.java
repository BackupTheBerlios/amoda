/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.environment.ant.ANTTaskEnvironment
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

package de.gulden.framework.amoda.environment.ant;

import de.gulden.framework.amoda.environment.commandline.*;
import de.gulden.framework.amoda.generic.core.ArgsParser;
import de.gulden.framework.amoda.model.interaction.ErrorMessage;
import java.util.*;

/**
 * Class ANTTaskEnvironment.
 */
public class ANTTaskEnvironment extends CommandLineApplicationEnvironment {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The task wrapper.
     */
    protected ANTTaskApplicationWrapper taskWrapper;


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the task wrapper.
     *  
     * @return  The task wrapper.
     */
    public ANTTaskApplicationWrapper getTaskWrapper() {
        return taskWrapper;

    }

    /**
     * Sets the task wrapper.
     *  
     * @param aNTTaskApplicationWrapper The task wrapper.
     */
    public void setTaskWrapper(ANTTaskApplicationWrapper aNTTaskApplicationWrapper) {
        if (this.taskWrapper != aNTTaskApplicationWrapper) {
            this.taskWrapper = aNTTaskApplicationWrapper;
            if (aNTTaskApplicationWrapper != null) aNTTaskApplicationWrapper.setEnvironment(this);
        }

    }

    /**
     * Creates the args parser.
     *  
     * @return  The args parser.
     */
    public ArgsParser createArgsParser() {
        return new ANTArgsParser(taskWrapper);

    }

    /**
     *  
     * @param msg The msg.
     */
    public void doErrorMessage(ErrorMessage msg) {
        if (msg.exitApplication()) {
            Throwable t=msg.getCause();
            if (t!=null) {
                throw new org.apache.tools.ant.BuildException(msg.getText()+" - "+t.getMessage(),t);
            } else {
                throw new org.apache.tools.ant.BuildException(msg.getText());
            }
        } else {
            getTaskWrapper().log(msg.getText(),org.apache.tools.ant.Project.MSG_ERR);
        }

    }

} // end ANTTaskEnvironment
