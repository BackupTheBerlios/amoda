/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.environment.ant.ANTArgsParser
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
import de.gulden.framework.amoda.generic.option.GenericOptions;
import de.gulden.framework.amoda.model.data.Value;
import java.util.*;
import java.util.Collection;
import org.apache.tools.ant.ProjectHelper;

/**
 * Class ANTArgsParser.
 */
public class ANTArgsParser extends CommandLineArgsParser {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The task.
     */
    protected ANTTaskApplicationWrapper task;


    // ------------------------------------------------------------------------
    // --- constructor                                                      ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of ANTArgsParser.
     *  
     * @param antTask The ant task.
     */
    public ANTArgsParser(ANTTaskApplicationWrapper antTask) {
        super(null);
        setTask(antTask);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the task.
     *  
     * @return  The task.
     */
    public ANTTaskApplicationWrapper getTask() {
        return task;

    }

    /**
     * Sets the task.
     *  
     * @param aNTTaskApplicationWrapper The task.
     */
    public void setTask(ANTTaskApplicationWrapper aNTTaskApplicationWrapper) {
        this.task = aNTTaskApplicationWrapper;

    }

    /**
     * Parses the options.
     *  
     * @param options The options.
     */
    public void parseOptions(GenericOptions options) {
                org.xml.sax.AttributeList l=task.getOriginalAttributes();
        for (int i=0;i<l.getLength();i++) {
            // resolve variables before parse value
            String value=ProjectHelper.replaceProperties(getTask().getProject(),l.getValue(i),getTask().getProject().getProperties());
            // now parse
            getSingleArgParser().parseIndividualOption(l.getName(i),value,options);
        }

    }

    /**
     * Parses the batch commands.
     *  
     * @param availableCommands The available commands.
     * @return  The collection.
     */
    public Collection parseBatchCommands(Collection availableCommands) {
        return null;

    }

    /**
     * Parses the input values.
     *  
     * @return  The value array.
     */
    public Value[] parseInputValues() {
                Value[] v=new Value[getTask().getSrcs().size()];
        int i=0;
        for (Iterator it=getTask().getSrcs().iterator();it.hasNext();) {
            Src src=(Src)it.next();
            v[i++]=new de.gulden.framework.amoda.generic.data.GenericValue(src.getPath());
        }
        return v;

    }

} // end ANTArgsParser
