/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.environment.commandline.CommandLineApplicationEnvironment
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

import de.gulden.framework.amoda.environment.commandline.CommandLineArgsParser;
import de.gulden.framework.amoda.generic.core.ArgsParser;
import de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment;
import de.gulden.framework.amoda.model.data.Value;
import de.gulden.framework.amoda.model.interaction.Dialog;
import de.gulden.framework.amoda.model.interaction.ErrorMessage;
import de.gulden.framework.amoda.model.interaction.Message;
import de.gulden.framework.amoda.model.interaction.Question;
import de.gulden.framework.amoda.model.interaction.Wizard;
import de.gulden.framework.amoda.model.option.Option;
import java.util.*;

/**
 * Class CommandLineApplicationEnvironment.
 */
public class CommandLineApplicationEnvironment extends GenericApplicationEnvironment {

    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of CommandLineApplicationEnvironment.
     */
    public CommandLineApplicationEnvironment() {
        this(null);

    }

    /**
     * Creates a new instance of CommandLineApplicationEnvironment.
     *  
     * @param factory The factory.
     */
    public CommandLineApplicationEnvironment(CommandLineApplicationEnvironmentFactory factory) {
        super(factory);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     *  
     * @param question The question.
     */
    public void doQuestion(Question question) {
        System.out.println(question.getText());
        askOption(question.getAnswer());

    }

    /**
     *  
     * @param message The message.
     */
    public void doMessage(Message message) {
        if (!getGenericApplication().isQuiet()) {
            System.out.println(message.getText());
        }

    }

    /**
     *  
     * @param errorMessage The error message.
     */
    public void doErrorMessage(ErrorMessage errorMessage) {
        String txt=errorMessage.getText();
        if ((txt!=null)&&(txt.length()>1)) {
            txt=txt.substring(0,1).toUpperCase()+txt.substring(1)+(txt.length()>10?".":"");
        }
        System.out.print(txt);
        if (errorMessage.getCause()!=null) {
            txt=" "+errorMessage.getCause().getClass().getName()+": "+errorMessage.getCause().getMessage();
            if (!txt.endsWith(".")) {
                txt+=".";
            }
            System.out.print(txt);
        }
        System.out.println();
        if (errorMessage.getCause()!=null) {
            if (getGenericApplication().isVerbose()) { // !!!!!!!!! isVersbose should be part of ApplicationENVIRONMENT
                errorMessage.getCause().printStackTrace(System.out);
            }
        }
        if (errorMessage.exitApplication()) {
            getGenericApplication().usage();
            System.exit(1); // (from OS point of view, 1 is a good value for returning from any Java program on error (no higher values, because OS is usually unaffected))
        }

    }

    /**
     *  
     * @param dialog The dialog.
     */
    public void doDialog(Dialog dialog) {
        // your code here

    }

    /**
     *  
     * @param wizard The wizard.
     */
    public void doWizard(Wizard wizard) {
        // your code here

    }

    /**
     * Creates the args parser.
     *  
     * @return  The args parser.
     */
    public ArgsParser createArgsParser() {
                return new CommandLineArgsParser(getFactory().getArgs());

    }

    /**
     *  
     * @param option The option.
     */
    protected void askOption(Option option) {
        if (option instanceof de.gulden.framework.amoda.model.option.OptionEntry) {
            de.gulden.framework.amoda.model.option.OptionEntry optionValue=(de.gulden.framework.amoda.model.option.OptionEntry)option;
            Object value=optionValue.getValue(Option.STATE_DEFAULT).getObject();
            String defaultMessage;
            if (value instanceof Boolean) {
                Boolean bool=(Boolean)value;
                boolean b=bool.booleanValue();
                defaultMessage="["+(b?"_j_/n":"j/_n_")+"]"; // *********** VARIABLEN FÜR "J" / "N"
            } else {
                String def=option.toString();
                if ((def!=null)&&(def.length()>0)) {
                    defaultMessage="[default: "+def+"]";
                } else {
                    defaultMessage=null;
                }
            }
            do {
                if (defaultMessage!=null) {
                    System.out.println(defaultMessage);
                }
                try {
                    String r=(new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine();
                    if (!r.equals("")) {
                        ((de.gulden.framework.amoda.generic.data.GenericValue)optionValue.getValue()).parseString(r);
                    } // if "", leave default
                } catch (java.io.IOException ioe) {
                    System.out.println("ERROR: i/o exception");
                    // may lead to accepting default value or to retry
                }
            } while (!optionValue.isValid());
        } else if (option instanceof de.gulden.framework.amoda.model.option.OptionsGroup) {
            // ****** !!!! PROVISORISCH
            Collection values=((de.gulden.framework.amoda.model.option.OptionsGroup)option).getEntries();
            for (Iterator it=values.iterator();it.hasNext();) {
                Option o=(Option)it.next();
                askOption(o); // recurse
            }
        }

    }

} // end CommandLineApplicationEnvironment
