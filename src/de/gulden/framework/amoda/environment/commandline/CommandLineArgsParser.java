/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.environment.commandline.CommandLineArgsParser
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

package de.gulden.framework.amoda.environment.commandline;

import de.gulden.framework.amoda.generic.core.AbstractArgsParser;
import de.gulden.framework.amoda.generic.data.GenericValue;
import de.gulden.framework.amoda.generic.option.GenericOptions;
import de.gulden.framework.amoda.model.data.Value;
import java.util.*;
import java.util.Collection;

/**
 * Class CommandLineArgsParser.
 */
public class CommandLineArgsParser extends AbstractArgsParser {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The args array.
     */
    protected String[] args;

    /**
     * The index.
     */
    protected int index;


    // ------------------------------------------------------------------------
    // --- constructor                                                      ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of CommandLineArgsParser.
     *  
     * @param args The args.
     */
    public CommandLineArgsParser(String[] args) {
        this.args=args;
        index=0;

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the args.
     *  
     * @return  The args array.
     */
    public String[] getArgs() {
        return args;

    }

    /**
     * Sets the args.
     *  
     * @param _args The args array.
     */
    public void setArgs(String[] _args) {
        args = _args;

    }

    /**
     * Returns the index.
     *  
     * @return  The index.
     */
    public int getIndex() {
        return index;

    }

    /**
     * Sets the index.
     *  
     * @param _index The index.
     */
    public void setIndex(int _index) {
        index = _index;

    }

    /**
     * Parses the options.
     *  
     * @param options The options.
     */
    public void parseOptions(GenericOptions options) {
        // format: -option1[=][value] -option2[=][value] ...
        index=0; // allow multiple calls (but must preserve oder)
        if (args.length>index) {
            String a=args[index];
            while ((a!=null)&&(a.startsWith("-"))) {
                a=a.substring(1); // remove leading '-'
                index++;
                int eqPos=a.indexOf('=');
                String possibleValue;
                if (eqPos==-1) { // not separated by '=', so value _maybe_ follows in next arg (boolean values may have no following value but are implicitly set to true if occurring)
                    if (index<args.length) {
                        possibleValue=args[index];
                    } else {
                        possibleValue=null;
                    }
                } else {
                    possibleValue=a.substring(eqPos+1); // (is already known value, not only 'possible')
                    a=a.substring(0,eqPos);
                }
                if (getSingleArgParser().parseIndividualOption(a,possibleValue,options) // will always be evaluated... (must not be optimized right-to-left according to Java language spec.)
                && (eqPos==-1)) { //... increase index only value followed and if value wasn't given after '='
                    index++; // parseOptionInternal returns true if possibleValue has been consumed
                }
                if (index<args.length) {
                    a=args[index];
                } else {
                    a=null;
                }
            }
        }

    }

    /**
     * Parses the batch commands.
     *  
     * @param availableCommands The available commands.
     * @return  The collection.
     */
    public Collection parseBatchCommands(Collection availableCommands) {
        // commands must be identified by SINGLE LETTER ids!
        Collection c=new ArrayList();
        Map m=new HashMap();
        de.gulden.framework.amoda.environment.commandline.CommandLineCommand command;
        for (Iterator it=availableCommands.iterator();it.hasNext();) {
            command=(de.gulden.framework.amoda.environment.commandline.CommandLineCommand)it.next();
            m.put(command.getCode(),command);
        }
        while (args.length>index) {
            // each entry may consist of multiple letters - accept only if all valid commands
            String a=args[index];
            int charindex=0;
            Collection tempC=new ArrayList();
            while (charindex<a.length()) {
                String id=a.substring(charindex,charindex+1);
                command=(de.gulden.framework.amoda.environment.commandline.CommandLineCommand)m.get(id);
                if (command==null) { // not a command - assume parameters have started
                    return c; // index not increased, none of commands in current arg used
                } else {
                    tempC.add(command);
                }
                charindex++;
            }
            // now it is sure that all commands are valid, so copy them
            c.addAll(tempC);
            // increase args index
            index++;
        }
        return c;

    }

    /**
     * Parses the input values.
     *  
     * @return  The value array.
     */
    public Value[] parseInputValues() {
        // parseOptions and parseBatchCommands must have been called before
        de.gulden.framework.amoda.model.data.Value[] values=new de.gulden.framework.amoda.model.data.Value[args.length-index];
        for (int i=0;i<values.length;i++) {
            values[i]=new de.gulden.framework.amoda.generic.data.GenericValue(args[index+i]);
        }
        return values;

    }

    /**
     * Parses the individual option.
     *  
     * @param name The name.
     * @param suggestedValue The suggested value.
     * @param options The options.
     * @return  The boolean.
     */
    public boolean parseIndividualOption(String name, String suggestedValue, GenericOptions options) {
        boolean result;
        de.gulden.framework.amoda.model.option.OptionEntry o=options.getEntry(name); // may throw IllegalOptionError
        Class type=o.getType();
        String v;
        if (!Boolean.class.isAssignableFrom(type)) { // normal case: non-boolean (value always follows)
            if (suggestedValue==null) {
                throw new de.gulden.framework.amoda.model.option.IllegalOptionError("value for option "+name+" must be specified");
            } else {
                v=suggestedValue;
                result=true; // use up suggestedValue
            }
        } else {
            // boolean, maybe value follows (if no value follows, assume TRUE)
            if (suggestedValue!=null) {
                if ((GenericValue.isBooleanLiteral(true,suggestedValue)||GenericValue.isBooleanLiteral(false,suggestedValue))) {
                    v=suggestedValue;
                    result=true;
                } else {
                    v="true";
                    result=false;
                }
            } else {
                v="true";
                result=false;
            }
        }
        ((GenericValue)o.getValue(GenericOptions.STATE_CURRENT)).parseString(v);
        return result;

    }

} // end CommandLineArgsParser
