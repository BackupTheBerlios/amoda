/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.interaction.GenericDialog
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

package de.gulden.framework.amoda.generic.interaction;

import de.gulden.framework.amoda.generic.option.*;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.interaction.Dialog;
import de.gulden.framework.amoda.model.option.Options;
import java.util.*;
import java.util.Collection;

/**
 * Class GenericDialog.
 */
public class GenericDialog extends GenericInteractionMemberAbstract implements Dialog {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The questions.
     */
    protected Collection questions;

    /**
     * The text.
     */
    protected String text;

    /**
     * The options.
     */
    protected Options options;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericDialog.
     */
    public GenericDialog() {
        // your code here

    }

    /**
     * Creates a new instance of GenericDialog.
     *  
     * @param environment The environment.
     */
    public GenericDialog(ApplicationEnvironment environment) {
        super(environment);

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the questions.
     *  
     * @return  The questions.
     */
    public Collection getQuestions() {
        return questions;

    }

    /**
     * Sets the questions.
     *  
     * @param _questions The questions.
     */
    public void setQuestions(Collection _questions) {
        questions = _questions;

    }

    /**
     * Returns the text.
     *  
     * @return  The text.
     */
    public String getText() {
        return text;

    }

    /**
     * Sets the text.
     *  
     * @param _text The text.
     */
    public void setText(String _text) {
        text = _text;

    }

    /**
     * Returns the options.
     *  
     * @return  The options.
     */
    public Options getOptions() {
        return options;

    }

    /**
     * Sets the options.
     *  
     * @param _options The options.
     */
    public void setOptions(Options _options) {
        options = _options;

    }

    public void reset() {
        // your code here

    }

    public void perform() {
        ((de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment)getEnvironment()).doDialog(this);

    }

} // end GenericDialog
