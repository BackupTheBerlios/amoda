/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.core.GenericApplication
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

import de.gulden.framework.amoda.generic.core.GenericApplicationEnvironmentFactory;
import de.gulden.framework.amoda.generic.metadata.*;
import de.gulden.framework.amoda.generic.option.*;
import de.gulden.framework.amoda.model.core.Application;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.core.ApplicationEnvironmentFactory;
import de.gulden.framework.amoda.model.interaction.Message;
import de.gulden.framework.amoda.model.metadata.Metadata;
import de.gulden.framework.amoda.model.option.Option;
import de.gulden.framework.amoda.model.option.Options;
import de.gulden.util.Queue;
import de.gulden.util.xml.XMLHandler;
import java.util.*;
import java.util.Stack;

/**
 * Class GenericApplication.
 */
public abstract class GenericApplication extends GenericApplicationMemberAbstract implements Application, ApplicationEnvironmentFactory {

    // ------------------------------------------------------------------------
    // --- static fields                                                    ---
    // ------------------------------------------------------------------------
    /**
     * The y e s.
     */
    public static int YES=0;

    /**
     * The n o.
     */
    public static int NO=2;

    /**
     * The c a n c e l.
     */
    public static int CANCEL=4;


    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The generic application environment.
     */
    public GenericApplicationEnvironment genericApplicationEnvironment;

    /**
     * The undo stack.
     */
    public UndoStack undoStack;

    /**
     * The command queue.
     */
    protected Queue commandQueue;

    /**
     * The command undo stack.
     */
    protected Stack commandUndoStack;

    /**
     * The verbose.
     */
    protected boolean verbose;

    /**
     * The debug.
     */
    protected boolean debug;

    /**
     * The simple answer options array.
     */
    protected Option[] simpleAnswerOptions;

    /**
     * The quiet.
     */
    protected boolean quiet;


    // ------------------------------------------------------------------------
    // --- constructor                                                      ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericApplication.
     */
    public GenericApplication() {
        super(null); // set ApplicationEnvironment later
        //setMetadata(createApplicationMetadata()); (schon in GenericApplicationMember)

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the command queue.
     *  
     * @return  The command queue.
     */
    public Queue getCommandQueue() {
        return commandQueue;

    }

    /**
     * Sets the command queue.
     *  
     * @param _commandQueue The command queue.
     */
    public void setCommandQueue(Queue _commandQueue) {
        commandQueue = _commandQueue;

    }

    /**
     * Returns the command undo stack.
     *  
     * @return  The command undo stack.
     */
    public Stack getCommandUndoStack() {
        return commandUndoStack;

    }

    /**
     * Sets the command undo stack.
     *  
     * @param _commandUndoStack The command undo stack.
     */
    public void setCommandUndoStack(Stack _commandUndoStack) {
        commandUndoStack = _commandUndoStack;

    }

    /**
     *  
     * @return  The boolean.
     */
    public boolean isVerbose() {
        return verbose;

    }

    /**
     * Sets the verbose.
     *  
     * @param _verbose The verbose.
     */
    public void setVerbose(boolean _verbose) {
        verbose = _verbose;

    }

    /**
     *  
     * @return  The boolean.
     */
    public boolean isDebug() {
        return debug;

    }

    /**
     * Sets the debug.
     *  
     * @param _debug The debug.
     */
    public void setDebug(boolean _debug) {
        debug = _debug;

    }

    /**
     * Returns the simple answer options.
     *  
     * @return  The simple answer options array.
     */
    public Option[] getSimpleAnswerOptions() {
        return simpleAnswerOptions;

    }

    /**
     * Sets the simple answer options.
     *  
     * @param _simpleAnswerOptions The simple answer options array.
     */
    public void setSimpleAnswerOptions(Option[] _simpleAnswerOptions) {
        simpleAnswerOptions = _simpleAnswerOptions;

    }

    /**
     *  
     * @return  The boolean.
     */
    public boolean isQuiet() {
        return quiet;

    }

    /**
     * Sets the quiet.
     *  
     * @param _quiet The quiet.
     */
    public void setQuiet(boolean _quiet) {
        quiet = _quiet;

    }

    /**
     * Returns the generic application environment.
     *  
     * @return  The generic application environment.
     */
    public GenericApplicationEnvironment getGenericApplicationEnvironment() {
        return genericApplicationEnvironment;

    }

    /**
     * Sets the generic application environment.
     *  
     * @param genericApplicationEnvironment The generic application environment.
     */
    public void setGenericApplicationEnvironment(GenericApplicationEnvironment genericApplicationEnvironment) {
        if (this.genericApplicationEnvironment != genericApplicationEnvironment) {
            this.genericApplicationEnvironment = genericApplicationEnvironment;
            if (genericApplicationEnvironment != null) genericApplicationEnvironment.setGenericApplication(this);
        }

    }

    /**
     * Returns the undo stack.
     *  
     * @return  The undo stack.
     */
    public UndoStack getUndoStack() {
        return undoStack;

    }

    /**
     * Sets the undo stack.
     *  
     * @param undoStack The undo stack.
     */
    public void setUndoStack(UndoStack undoStack) {
        this.undoStack = undoStack;

    }

    /**
     *  
     * @param environment The environment.
     */
    public void init(ApplicationEnvironment environment) {
        GenericApplicationEnvironment env=(GenericApplicationEnvironment)environment; // throws ClastCastException if invalid environment
        setGenericApplicationEnvironment(env);
        setEnvironment(environment);
        simpleAnswerOptions=new de.gulden.framework.amoda.model.option.Option[3];
        simpleAnswerOptions[0]=env.createDefaultOption("YES",Boolean.FALSE,env.createDefaultMetadata("Yes"));
        simpleAnswerOptions[1]=env.createDefaultOption("NO",Boolean.FALSE,env.createDefaultMetadata("No"));
        simpleAnswerOptions[2]=env.createDefaultOption("CANCEL",Boolean.FALSE,env.createDefaultMetadata("Cancel"));
        undoStack=new UndoStack();
        setMetadata(createApplicationMetadata());

    }

    public void start() {
        // to be extended or overwritten by subclass
        if (getGenericApplicationEnvironment().getConfiguration().getBoolean(GenericApplicationEnvironment.CONFIGURATION_BATCH_MODE)) {
            Collection batchCommands=((GenericApplicationEnvironment)getEnvironment()).getBatchCommands();
            // do batch commands before starting interaction
            for (Iterator it=batchCommands.iterator();it.hasNext();) {
                de.gulden.framework.amoda.model.behaviour.Command c=(de.gulden.framework.amoda.model.behaviour.Command)it.next();
                c.execute();
            }
        }
        if (getGenericApplicationEnvironment().getConfiguration().getBoolean(GenericApplicationEnvironment.CONFIGURATION_INTERACTION_MODE)) {
            startInteraction();
        }

    }

    public void stop() {
        // nop

    }

    public void destroy() {
        // nop

    }

    /**
     *  
     * @param title The title.
     * @param text The text.
     */
    public void defaultMessage(String title, String text) {
        de.gulden.framework.amoda.model.interaction.Message m=getGenericApplicationEnvironment().createDefaultMessage(title,text,Message.TYPE_INFO,null);
        m.perform();

    }

    /**
     *  
     * @param id The id.
     */
    public void message(String id) {
        de.gulden.framework.amoda.model.interaction.Message m=getGenericApplicationEnvironment().getMessage(id);
        m.perform();

    }

    /**
     *  
     * @param text The text.
     */
    public void log(String text) {
        de.gulden.framework.amoda.model.interaction.LogMessage m=getGenericApplicationEnvironment().createDefaultLogMessage(text,null,Message.TYPE_INFO,null);
        m.perform();

    }

    /**
     *  
     * @param text The text.
     * @param throwable The throwable.
     * @param exitApplication The exit application.
     */
    public void error(String text, Throwable throwable, boolean exitApplication) {
        de.gulden.framework.amoda.model.interaction.ErrorMessage m=getGenericApplicationEnvironment().createDefaultErrorMessage(text,throwable,exitApplication,null);
        m.perform();

    }

    /**
     *  
     * @param title The title.
     * @param text The text.
     * @param answerMask The answer mask.
     * @return  The int.
     */
    public int question(String title, String text, int answerMask) {
        de.gulden.framework.amoda.model.option.Options answerOption=getGenericApplicationEnvironment().createDefaultOptions();
        for (int i=0;i<simpleAnswerOptions.length;i++) {
            if ((answerMask&(2^i))!=0) {
                answerOption.getEntries().add(simpleAnswerOptions[i]);
            }
        }
        de.gulden.framework.amoda.model.interaction.Question q=getGenericApplicationEnvironment().createDefaultQuestion(title,text,answerOption,null);
        getGenericApplicationEnvironment().doQuestion(q);
        return -1; // *********!!!!!!!!1

    }

    /**
     *  
     * @param text The text.
     * @param answerMask The answer mask.
     * @return  The int.
     */
    public int question(String text, int answerMask) {
        return question("",text,answerMask);

    }

    /**
     *  
     * @param title The title.
     * @param text The text.
     * @return  The boolean.
     */
    public boolean confirm(String title, String text) {
        return (question(title,text,YES|NO)==YES);

    }

    /**
     *  
     * @param text The text.
     * @return  The boolean.
     */
    public boolean confirm(String text) {
        return confirm("",text);

    }

    public void usage() {
        de.gulden.framework.amoda.model.interaction.Message m=createUsageMessage();
        if (m!=null) {
            m.perform();
        }

    }

    /**
     * Creates the application environment.
     *  
     * @return  The application environment.
     */
    public abstract ApplicationEnvironment createApplicationEnvironment();

    public void run() {
        ApplicationEnvironment env=createApplicationEnvironment();
        env.launch(this);

    }

    /**
     * Creates the x m l handler.
     *  
     * @return  The x m l handler.
     */
    public XMLHandler createXMLHandler() {
        return null; // this is a dummy to subtract the feature of XMLSerializability from Genericapplication

    }

    /**
     * Returns the options.
     *  
     * @return  The options.
     */
    public Options getOptions() {
        return getGenericApplicationEnvironment().getApplicationOptions();

    }

    /**
     *  
     * @param message The message.
     */
    public void message(Message message) {
        getGenericApplicationEnvironment().doMessage(message);

    }

    public void startInteraction() {
        // your code here

    }

    public void about() {
        message(createAboutMessage());

    }

    public void welcome() {
        // nop (gets overwritten e.g. by CommandLineApplication to output about-message in the very start of an application)

    }

    /**
     *  
     * @param environment The environment.
     */
    public void prepare(GenericApplicationEnvironment environment) {
        // nop, may be used by subclasses

    }

    /**
     *  
     * @param throwable The throwable.
     * @param exit The exit.
     */
    public void error(Throwable throwable, boolean exit) {
        error("",throwable,exit);

    }

    /**
     *  
     * @return  The boolean.
     */
    public synchronized boolean isInInitializing() {
        return true;

    }

    /**
     *  
     * @return  The boolean.
     */
    public synchronized boolean isInRunning() {
        return true;

    }

    /**
     *  
     * @return  The boolean.
     */
    public synchronized boolean isInWaitingForCommand() {
        return true;

    }

    /**
     *  
     * @return  The boolean.
     */
    public synchronized boolean isInExecutingCommand() {
        return true;

    }

    /**
     *  
     * @return  The boolean.
     */
    public synchronized boolean isInDestroying() {
        return true;

    }

    /**
     * Creates the application metadata.
     *  
     * @return  The metadata.
     */
    protected Metadata createApplicationMetadata() {
        org.w3c.dom.Element applicationTag=((GenericApplicationEnvironment)getEnvironment()).getFactory().getConfiguration().getDocumentElement();
        org.w3c.dom.Element metadataTag=de.gulden.util.xml.XMLToolbox.getChild(applicationTag,"metadata");
        try {
            return (de.gulden.framework.amoda.model.metadata.Metadata)((GenericApplicationEnvironment)getEnvironment()).getFactory().getXMLSerializer().deserialize(metadataTag);
        } catch (de.gulden.util.xml.XMLException e) {
            // stays null
            return null;
        }

    }

    /**
     * Creates the about message.
     *  
     * @return  The message.
     */
    protected Message createAboutMessage() {
        String license=getMetadata().get("license-message"); // metadata description by default
        if (license!=null) {
            license=NL+license;
        } else {
            license="";
        }
        String name=getMetadata().get("longname");
        if (name==null) {
            name=getMetadata().get("name");
            if (name==null) {
                name="";
            }
        }
        String version=getMetadata().get("version");
        if (version!=null) {
            version=" "+version;
        } else {
            version="";
        }
        String author=getMetadata().get("author");
        if (author!=null) {
            author=" by "+author;
            String email=getMetadata().get("email");
            if (email!=null) {
                email=", "+email;
                author=author+email;
            }
        } else {
            author="";
        }
        return getGenericApplicationEnvironment().createDefaultMessage("about", name + version + author + license ,0,null);

    }

    /**
     * Creates the usage message.
     *  
     * @return  The message.
     */
    protected Message createUsageMessage() {
        StringBuffer sb=new StringBuffer();
                sb.append("Usage: "+NL);
        //            String d=getMetadata().get("description"); // metadata description by default
                double[] weights={0.0,0.0,1.0};
                de.gulden.util.text.TextTable table=new de.gulden.util.text.TextTable(3,79,weights,' ');
                for (Iterator it=getOptions().getEntries().iterator();it.hasNext();) {
                    de.gulden.framework.amoda.generic.option.GenericOptionEntry o=(de.gulden.framework.amoda.generic.option.GenericOptionEntry)it.next();
                    String description=de.gulden.util.Toolbox.noNull(o.getMetadata().get("description"));
                    String type="<"+de.gulden.util.Toolbox.unqualify(o.getType().getName()).toLowerCase()+">";
                    String defaultValue=o.getValue(o.STATE_DEFAULT).getString();
                    if (defaultValue!=null) {
                        description+=" (default: "+defaultValue+")";
                    }
                    String[] row={"-"+o.getId(),type,description};
                    table.addRow(row);
                }
                sb.append(table.toString());
                return getGenericApplicationEnvironment().createDefaultMessage("Usage",sb.toString(),0,null);

    }


    // ------------------------------------------------------------------------
    // --- static methods                                                   ---
    // ------------------------------------------------------------------------
    /**
     * Returns the y e s.
     *  
     * @return  The y e s.
     */
    public static int getYES() {
        return YES;

    }

    /**
     * Sets the y e s.
     *  
     * @param _YES The y e s.
     */
    public static void setYES(int _YES) {
        YES = _YES;

    }

    /**
     * Returns the n o.
     *  
     * @return  The n o.
     */
    public static int getNO() {
        return NO;

    }

    /**
     * Sets the n o.
     *  
     * @param _NO The n o.
     */
    public static void setNO(int _NO) {
        NO = _NO;

    }

    /**
     * Returns the c a n c e l.
     *  
     * @return  The c a n c e l.
     */
    public static int getCANCEL() {
        return CANCEL;

    }

    /**
     * Sets the c a n c e l.
     *  
     * @param _CANCEL The c a n c e l.
     */
    public static void setCANCEL(int _CANCEL) {
        CANCEL = _CANCEL;

    }

} // end GenericApplication
