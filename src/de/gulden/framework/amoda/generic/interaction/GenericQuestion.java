/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.interaction.GenericQuestion
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
import de.gulden.framework.amoda.model.interaction.Question;
import de.gulden.framework.amoda.model.option.Option;
import de.gulden.framework.amoda.model.option.Options;
import java.util.*;
import java.util.Collection;

/**
 * Class GenericQuestion.
 */
public class GenericQuestion extends GenericMessageAbstract implements Question {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The answer.
     */
    protected Option answer;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericQuestion.
     *  
     * @param environment The environment.
     */
    public GenericQuestion(ApplicationEnvironment environment) {
        super(environment);

    }

    /**
     * Creates a new instance of GenericQuestion.
     */
    public GenericQuestion() {
        // your code here

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the answer.
     *  
     * @return  The answer.
     */
    public Option getAnswer() {
        return answer;

    }

    /**
     * Sets the answer.
     *  
     * @param _answer The answer.
     */
    public void setAnswer(Option _answer) {
        answer = _answer;

    }

    /**
     * Returns the options.
     *  
     * @return  The options.
     */
    public Options getOptions() {
        // your code here
        return null;

    }

    public void reset() {
        // your code here

    }

    /**
     * Returns the questions.
     *  
     * @return  The questions.
     */
    public Collection getQuestions() {
        // your code here
        return null;

    }

    public void perform() {
        ((de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment)getEnvironment()).doQuestion(this);

    }

} // end GenericQuestion
