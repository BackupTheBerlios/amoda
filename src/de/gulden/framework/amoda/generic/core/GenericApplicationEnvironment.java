/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment
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
import de.gulden.framework.amoda.generic.option.GenericOptions;
import de.gulden.framework.amoda.model.behaviour.Command;
import de.gulden.framework.amoda.model.core.Application;
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.core.ApplicationMember;
import de.gulden.framework.amoda.model.data.Value;
import de.gulden.framework.amoda.model.interaction.Dialog;
import de.gulden.framework.amoda.model.interaction.ErrorMessage;
import de.gulden.framework.amoda.model.interaction.LogMessage;
import de.gulden.framework.amoda.model.interaction.LogMessagePerformer;
import de.gulden.framework.amoda.model.interaction.Message;
import de.gulden.framework.amoda.model.interaction.Question;
import de.gulden.framework.amoda.model.interaction.Wizard;
import de.gulden.framework.amoda.model.metadata.Metadata;
import de.gulden.framework.amoda.model.option.Option;
import de.gulden.framework.amoda.model.option.OptionChoice;
import de.gulden.framework.amoda.model.option.OptionEntry;
import de.gulden.framework.amoda.model.option.Options;
import de.gulden.util.xml.XMLException;
import de.gulden.util.xml.XMLHandler;
import de.gulden.util.xml.XMLSerializable;
import de.gulden.util.xml.XMLSerializer;
import de.gulden.util.xml.XMLToolbox;
import java.util.*;
import java.util.Collection;
import java.util.Hashtable;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Element;

/**
 * Class GenericApplicationEnvironment.
 */
public abstract class GenericApplicationEnvironment implements ApplicationEnvironment, XMLSerializable {

    // ------------------------------------------------------------------------
    // --- static fields                                                    ---
    // ------------------------------------------------------------------------
    /**
     * Constant VERSION.
     */
    public static final String VERSION="0.1";

    /**
     * The d e f a u l t_ l o g f i l e.
     */
    public static String DEFAULT_LOGFILE="./application.log";

    /**
     * The d e f a u l t_ p r o p e r t i e s.
     */
    public static String DEFAULT_PROPERTIES="./application.properties";

    /**
     * The n l.
     */
    public static String NL=System.getProperty("line.separator");

    /**
     * The c o n f i g u r a t i o n_ p e r s i s t e n t_ o p t i o n s.
     */
    public static String CONFIGURATION_PERSISTENT_OPTIONS="persistent-options";

    /**
     * The c o n f i g u r a t i o n_ b a t c h_ m o d e.
     */
    public static String CONFIGURATION_BATCH_MODE="batch-mode";

    /**
     * The c o n f i g u r a t i o n_ i n t e r a c t i o n_ m o d e.
     */
    public static String CONFIGURATION_INTERACTION_MODE="interaction-mode";


    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The factory.
     */
    public GenericApplicationEnvironmentFactory factory;

    /**
     * The generic application.
     */
    public GenericApplication genericApplication;

    /**
     * The application options.
     */
    public GenericOptions applicationOptions;

    /**
     * The log file.
     */
    public LogFile logFile;

    /**
     * The metadata.
     */
    protected Metadata metadata;

    /**
     * The options.
     */
    protected Options options;

    /**
     * The application members data.
     */
    protected Hashtable applicationMembersData;

    /**
     * The configuration.
     */
    protected GenericOptions configuration;

    /**
     * The args parser.
     */
    protected ArgsParser argsParser;

    /**
     * The batch commands.
     */
    protected Collection batchCommands;

    /**
     * The input values array.
     */
    protected Value[] inputValues;

    /**
     * The x m l handler.
     */
    protected XMLHandler xMLHandler;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericApplicationEnvironment.
     */
    public GenericApplicationEnvironment() {
        super();
        applicationMembersData=new Hashtable();
        setXMLHandler(createXMLHandler());

    }

    /**
     * Creates a new instance of GenericApplicationEnvironment.
     *  
     * @param factory The factory.
     */
    public GenericApplicationEnvironment(GenericApplicationEnvironmentFactory factory) {
        super();
        applicationMembersData=new Hashtable();
        setFactory(factory);
        setXMLHandler(createXMLHandler());

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the metadata.
     *  
     * @return  The metadata.
     */
    public Metadata getMetadata() {
        return metadata;

    }

    /**
     * Sets the metadata.
     *  
     * @param _metadata The metadata.
     */
    public void setMetadata(Metadata _metadata) {
        metadata = _metadata;

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

    /**
     * Returns the application members data.
     *  
     * @return  The application members data.
     */
    public Hashtable getApplicationMembersData() {
        return applicationMembersData;

    }

    /**
     * Sets the application members data.
     *  
     * @param _applicationMembersData The application members data.
     */
    public void setApplicationMembersData(Hashtable _applicationMembersData) {
        applicationMembersData = _applicationMembersData;

    }

    /**
     * Returns the configuration.
     *  
     * @return  The configuration.
     */
    public GenericOptions getConfiguration() {
        return configuration;

    }

    /**
     * Sets the configuration.
     *  
     * @param _configuration The configuration.
     */
    public void setConfiguration(GenericOptions _configuration) {
        configuration = _configuration;

    }

    /**
     * Returns the args parser.
     *  
     * @return  The args parser.
     */
    public ArgsParser getArgsParser() {
        return argsParser;

    }

    /**
     * Sets the args parser.
     *  
     * @param _argsParser The args parser.
     */
    public void setArgsParser(ArgsParser _argsParser) {
        argsParser = _argsParser;

    }

    /**
     * Returns the batch commands.
     *  
     * @return  The batch commands.
     */
    public Collection getBatchCommands() {
        return batchCommands;

    }

    /**
     * Sets the batch commands.
     *  
     * @param _batchCommands The batch commands.
     */
    public void setBatchCommands(Collection _batchCommands) {
        batchCommands = _batchCommands;

    }

    /**
     * Returns the input values.
     *  
     * @return  The input values array.
     */
    public Value[] getInputValues() {
        return inputValues;

    }

    /**
     * Sets the input values.
     *  
     * @param _inputValues The input values array.
     */
    public void setInputValues(Value[] _inputValues) {
        inputValues = _inputValues;

    }

    /**
     * Returns the factory.
     *  
     * @return  The factory.
     */
    public GenericApplicationEnvironmentFactory getFactory() {
        return factory;

    }

    /**
     * Sets the factory.
     *  
     * @param genericApplicationEnvironmentFactory The factory.
     */
    public void setFactory(GenericApplicationEnvironmentFactory genericApplicationEnvironmentFactory) {
        this.factory = genericApplicationEnvironmentFactory;

    }

    /**
     * Returns the generic application.
     *  
     * @return  The generic application.
     */
    public GenericApplication getGenericApplication() {
        return genericApplication;

    }

    /**
     * Sets the generic application.
     *  
     * @param genericApplication The generic application.
     */
    public void setGenericApplication(GenericApplication genericApplication) {
        if (this.genericApplication != genericApplication) {
            this.genericApplication = genericApplication;
            if (genericApplication != null) genericApplication.setGenericApplicationEnvironment(this);
        }

    }

    /**
     * Returns the application options.
     *  
     * @return  The application options.
     */
    public GenericOptions getApplicationOptions() {
        return applicationOptions;

    }

    /**
     * Sets the application options.
     *  
     * @param genericOptions The application options.
     */
    public void setApplicationOptions(GenericOptions genericOptions) {
        this.applicationOptions = genericOptions;

    }

    /**
     * Returns the x m l handler.
     *  
     * @return  The x m l handler.
     */
    public XMLHandler getXMLHandler() {
        return xMLHandler;

    }

    /**
     * Sets the x m l handler.
     *  
     * @param xMLHandler The x m l handler.
     */
    public void setXMLHandler(XMLHandler xMLHandler) {
        this.xMLHandler = xMLHandler;

    }

    /**
     * Returns the log file.
     *  
     * @return  The log file.
     */
    public LogFile getLogFile() {
        return logFile;

    }

    /**
     * Sets the log file.
     *  
     * @param logFile The log file.
     */
    public void setLogFile(LogFile logFile) {
        this.logFile = logFile;

    }

    /**
     *  
     * @param application The application.
     */
    public void launch(Application application) {
        GenericApplication genericApplication=(GenericApplication)application; // application must be of type GenericApplication
        setGenericApplication(genericApplication);
        try {
            setArgsParser(createArgsParser());
            genericApplication.prepare(this);
            initApplicationOptions(getApplicationOptions());
            genericApplication.setDebug(getApplicationOptions().getBoolean("debug"));
            genericApplication.setVerbose(getApplicationOptions().getBoolean("verbose"));
            genericApplication.setQuiet(getApplicationOptions().getBoolean("quiet"));
            genericApplication.setMetadata(this.getMetadata());
            if (!genericApplication.isQuiet()) {
                genericApplication.welcome();
            }
            if (!getApplicationOptions().getBoolean("help")) {
                setLogFile(createLogFile());
                application.init(this);
                application.start();
                // wait until application returns
                application.destroy();
            } else {
                genericApplication.usage();
            }
        } catch (Throwable t) {
            getGenericApplication().error(t,true);
        }

    }

    /**
     * Creates the default message.
     *  
     * @param title The title.
     * @param text The text.
     * @param type The type.
     * @param metadata The metadata.
     * @return  The message.
     */
    public Message createDefaultMessage(String title, String text, int type, Metadata metadata) {
        de.gulden.framework.amoda.generic.interaction.GenericMessage m=new de.gulden.framework.amoda.generic.interaction.GenericMessage(this);
        m.setTitle(title);
        m.setText(text);
        m.setType(type);
        return m;

    }

    /**
     * Creates the default error message.
     *  
     * @param text The text.
     * @param throwable The throwable.
     * @param exitApplication The exit application.
     * @param metadata The metadata.
     * @return  The error message.
     */
    public ErrorMessage createDefaultErrorMessage(String text, Throwable throwable, boolean exitApplication, Metadata metadata) {
        de.gulden.framework.amoda.generic.interaction.GenericErrorMessage m=new de.gulden.framework.amoda.generic.interaction.GenericErrorMessage(this);
        m.setText(text);
        m.setCause(throwable);
        m.setExit(exitApplication);
        return m;

    }

    /**
     * Creates the default question.
     *  
     * @param title The title.
     * @param text The text.
     * @param answerOption The answer option.
     * @param metadata The metadata.
     * @return  The question.
     */
    public Question createDefaultQuestion(String title, String text, Option answerOption, Metadata metadata) {
        de.gulden.framework.amoda.generic.interaction.GenericQuestion m=new de.gulden.framework.amoda.generic.interaction.GenericQuestion(this);
        m.setTitle(title);
        m.setText(text);
        m.setAnswer(answerOption);
        return m;

    }

    /**
     * Creates the default dialog.
     *  
     * @param title The title.
     * @param text The text.
     * @param options The options.
     * @param metadata The metadata.
     * @return  The dialog.
     */
    public Dialog createDefaultDialog(String title, String text, Options options, Metadata metadata) {
        de.gulden.framework.amoda.generic.interaction.GenericDialog m=new de.gulden.framework.amoda.generic.interaction.GenericDialog(this);
        m.setTitle(title);
        m.setText(text);
        m.setOptions(options);
        return m;

    }

    /**
     * Creates the default wizard.
     *  
     * @param title The title.
     * @param dialogs The dialogs.
     * @param metadata The metadata.
     * @return  The wizard.
     */
    public Wizard createDefaultWizard(String title, Collection dialogs, Metadata metadata) {
        de.gulden.framework.amoda.generic.interaction.GenericWizard m=new de.gulden.framework.amoda.generic.interaction.GenericWizard(this);
        m.setTitle(title);
        m.setDialogs(dialogs);
        return m;

    }

    /**
     * Creates the default log message.
     *  
     * @param text The text.
     * @param cause The cause.
     * @param type The type.
     * @param metadata The metadata.
     * @return  The log message.
     */
    public LogMessage createDefaultLogMessage(String text, Object cause, int type, Metadata metadata) {
        de.gulden.framework.amoda.generic.interaction.GenericLogMessage m=new de.gulden.framework.amoda.generic.interaction.GenericLogMessage(this);
        m.setText(text);
        m.setCause(cause);
        m.setType(type);
        return m;

    }

    /**
     *  
     * @param message The message.
     */
    public abstract void doMessage(Message message);

    /**
     *  
     * @param logMessage The log message.
     */
    public void doLogMessage(LogMessage logMessage) {
        LogMessagePerformer log=getLogMessagePerformer();
        if (log!=null) {
            log.doLogMessage(logMessage);
        } else {
            System.out.println("[log] "+logMessage.getText());
        }

    }

    /**
     *  
     * @param errorMessage The error message.
     */
    public abstract void doErrorMessage(ErrorMessage errorMessage);

    /**
     *  
     * @param question The question.
     */
    public abstract void doQuestion(Question question);

    /**
     *  
     * @param dialog The dialog.
     */
    public abstract void doDialog(Dialog dialog);

    /**
     *  
     * @param wizard The wizard.
     */
    public abstract void doWizard(Wizard wizard);

    /**
     * Creates the default option.
     *  
     * @param id The id.
     * @param initialValue The initial value.
     * @param metadata The metadata.
     * @return  The option entry.
     */
    public OptionEntry createDefaultOption(String id, Object initialValue, Metadata metadata) {
        de.gulden.framework.amoda.generic.option.GenericOptionEntry o=new de.gulden.framework.amoda.generic.option.GenericOptionEntry(this);
        o.setId(id);
        Class initialType;
        if (initialValue!=null) {
            initialType=initialValue.getClass();
        } else {
            initialType=String.class;
        }
        o.setType(initialType);
        ((de.gulden.framework.amoda.generic.data.GenericValue)o.getValue(OptionEntry.STATE_DEFAULT)).setObject(initialValue);
        o.setMetadata(metadata);
        return o;

    }

    /**
     * Creates the default options choice.
     *  
     * @param id The id.
     * @param options The options.
     * @param metadata The metadata.
     * @return  The option choice.
     */
    public OptionChoice createDefaultOptionsChoice(String id, Option[] options, Metadata metadata) {
        de.gulden.framework.amoda.generic.option.GenericOptionChoice o=new de.gulden.framework.amoda.generic.option.GenericOptionChoice(this);
        o.setId(id);
        o.getEntries().addAll(Arrays.asList(options));
        o.setMetadata(metadata);
        return o;

    }

    /**
     * Creates the default options.
     *  
     * @return  The options.
     */
    public Options createDefaultOptions() {
        de.gulden.framework.amoda.generic.option.GenericOptions o=new de.gulden.framework.amoda.generic.option.GenericOptions(this);
        return o;

    }

    /**
     * Creates the default metadata.
     *  
     * @param name The name.
     * @param title The title.
     * @param description The description.
     * @param author The author.
     * @param copyright The copyright.
     * @param email The email.
     * @param web The web.
     * @return  The metadata.
     */
    public Metadata createDefaultMetadata(String name, String title, String description, String author, String copyright, String email, String web) {
        de.gulden.framework.amoda.generic.metadata.GenericMetadata m=new de.gulden.framework.amoda.generic.metadata.GenericMetadata();
        m.addEntry("name",name);
        m.addEntry("longname",name);
        m.addEntry("title",title);
        m.addEntry("description",description);
        m.addEntry("author",author);
        m.addEntry("copyright",copyright);
        m.addEntry("email",email);
        m.addEntry("web",web);
        return m;

    }

    /**
     * Creates the default metadata.
     *  
     * @param name The name.
     * @param title The title.
     * @param description The description.
     * @return  The metadata.
     */
    public Metadata createDefaultMetadata(String name, String title, String description) {
        return createDefaultMetadata(name,title,description,null,null,null,null);

    }

    /**
     * Creates the default metadata.
     *  
     * @param title The title.
     * @param description The description.
     * @return  The metadata.
     */
    public Metadata createDefaultMetadata(String title, String description) {
        return createDefaultMetadata(null,title,description);

    }

    /**
     * Creates the default metadata.
     *  
     * @param description The description.
     * @return  The metadata.
     */
    public Metadata createDefaultMetadata(String description) {
        return createDefaultMetadata(null,description);

    }

    /**
     * Returns the message.
     *  
     * @param id The id.
     * @return  The message.
     */
    public Message getMessage(String id) {
        return (Message)getApplicationMember(id);

    }

    /**
     * Returns the log message.
     *  
     * @param id The id.
     * @return  The log message.
     */
    public LogMessage getLogMessage(String id) {
        return (LogMessage)getApplicationMember(id);

    }

    /**
     * Returns the error message.
     *  
     * @param id The id.
     * @return  The error message.
     */
    public ErrorMessage getErrorMessage(String id) {
        return (ErrorMessage)getApplicationMember(id);

    }

    /**
     * Returns the question.
     *  
     * @param id The id.
     * @return  The question.
     */
    public Question getQuestion(String id) {
        return (Question)(getApplicationMember(id));

    }

    /**
     * Returns the dialog.
     *  
     * @param id The id.
     * @return  The dialog.
     */
    public Dialog getDialog(String id) {
        return (Dialog)getApplicationMember(id);

    }

    /**
     * Returns the wizard.
     *  
     * @param id The id.
     * @return  The wizard.
     */
    public Wizard getWizard(String id) {
        return (Wizard)getApplicationMember(id);

    }

    /**
     * Returns the application member.
     *  
     * @param id The id.
     * @return  The application member.
     */
    public ApplicationMember getApplicationMember(String id) {
        return (ApplicationMember)applicationMembersData.get(id);

    }

    /**
     * Returns the default document builder.
     *  
     * @return  The default document builder.
     */
    public DocumentBuilder getDefaultDocumentBuilder() {
        return ((GenericApplicationEnvironmentFactory)getFactory()).getDocumentBuilder();

    }

    /**
     * Parses the x m l options.
     *  
     * @param element The element.
     * @param serializer The serializer.
     * @return  The options.
     */
    public Options parseXMLOptions(Element element, XMLSerializer serializer) throws XMLException {
        Element optionsTag=de.gulden.util.xml.XMLToolbox.getChild(element,"options");
        if (optionsTag!=null) {
            de.gulden.framework.amoda.generic.option.GenericOptions options=new de.gulden.framework.amoda.generic.option.GenericOptions();
            options.setEnvironment(this);
            options.getXMLHandler().parseXML(optionsTag,serializer);
            return options;
        } else {
            return null;
        }

    }

    /**
     * Returns the log message performer.
     *  
     * @return  The log message performer.
     */
    public LogMessagePerformer getLogMessagePerformer() {
        return getLogFile();

    }

    /**
     * Inits the system options.
     *  
     * @param options The options.
     */
    public void initSystemOptions(GenericOptions options) {
        options.addOption(createDefaultOption("debug",Boolean.FALSE,createDefaultMetadata("debug mode, all messages")));
        options.addOption(createDefaultOption("verbose",Boolean.FALSE,createDefaultMetadata("verbose mode, more message")));
        options.addOption(createDefaultOption("quiet",Boolean.FALSE,createDefaultMetadata("quiet mode, no messages")));
        options.addOption(createDefaultOption("logfile",getDefaultLogFilename(),createDefaultMetadata("the application-wide log file")));
        options.addOption(createDefaultOption("properties",getDefaultPropertiesFilename(),createDefaultMetadata("the application-wide properties file, storing all option values")));
        options.addOption(createDefaultOption("help",Boolean.FALSE,createDefaultMetadata("show help")));

    }

    /**
     * Returns the command.
     *  
     * @param id The id.
     * @return  The command.
     */
    public Command getCommand(String id) {
        return (Command)getApplicationMember(id);

    }

    /**
     * Returns the application members.
     *  
     * @return  The application members.
     */
    public Collection getApplicationMembers() {
        return java.util.Collections.list(applicationMembersData.elements());

    }

    /**
     * Returns the application members of type.
     *  
     * @param type The type.
     * @return  The application members of type.
     */
    public Collection getApplicationMembersOfType(Class type) {
        ArrayList list=new ArrayList();
        for (Enumeration e=applicationMembersData.elements();e.hasMoreElements();) {
            Object member=e.nextElement();
            if (type.isAssignableFrom(member.getClass())) {
                list.add(member);
            }
        }
        return list;

    }

    /**
     * Creates the args parser.
     *  
     * @return  The args parser.
     */
    public abstract ArgsParser createArgsParser();

    /**
     * Creates the x m l handler.
     *  
     * @return  The x m l handler.
     */
    protected XMLHandler createXMLHandler() {
        return new XMLHandler() {
                    public void parseXML(org.w3c.dom.Element element,de.gulden.util.xml.XMLSerializer serializer) throws de.gulden.util.xml.XMLException {
                        // element is root element "application-environment"
                        de.gulden.util.xml.XMLToolbox.requireTagName(element,"application");
                        // test version first to allow name change of root in later versions
                        String version=de.gulden.util.xml.XMLToolbox.getAttributeRequired(element,"format-version");
                        if (version.compareTo(VERSION)>0) {
                            throw new de.gulden.util.xml.XMLException("Version "+version+" not supported, this implementation supports up to version "+VERSION+".");
                        }
                        
                        de.gulden.framework.amoda.generic.option.GenericOptions configurationOptions=new de.gulden.framework.amoda.generic.option.GenericOptions();
                        configurationOptions.setEnvironment(GenericApplicationEnvironment.this);
                        
                        handleConfigurationOption(CONFIGURATION_PERSISTENT_OPTIONS,Boolean.TRUE,element,configurationOptions);
                        handleConfigurationOption(CONFIGURATION_BATCH_MODE,Boolean.TRUE,element,configurationOptions);
                        handleConfigurationOption(CONFIGURATION_INTERACTION_MODE,Boolean.TRUE,element,configurationOptions);
                        
        //                        //entry.setType(String.class); // as generic type, queries as boolean, int etc. remain possible
                        setConfiguration(configurationOptions);
                        
                        // --- metadata ----------------------------------------------------
                        
                        setMetadata(parseXMLMetadata(element,serializer)); // metadata will be passed to Application later
                        
                        // --- options ----------------------------------------------------
                        
                        de.gulden.framework.amoda.generic.option.GenericOptions options=new de.gulden.framework.amoda.generic.option.GenericOptions();
                        options.setEnvironment(GenericApplicationEnvironment.this);
                        initSystemOptions(options);
                        de.gulden.framework.amoda.generic.option.GenericOptions xmlOptions=(de.gulden.framework.amoda.generic.option.GenericOptions)parseXMLOptions(element,serializer);
                        xmlOptions.addAll(options);
                        setApplicationOptions(xmlOptions);
                        
                        // --- interaction members -----------------------------------------
                        
                        org.w3c.dom.NodeList nl;
                        
                        // commands
                        nl=element.getElementsByTagName("command");
                        for (int i=0;i<nl.getLength();i++) {
                            // class must be explicitly given via class=".." attribute
                            Element ee=(Element)nl.item(i);
                            //XMLToolbox.getAttributeRequired(ee,"class"); // test here, serializer will read class and instantiate
                            de.gulden.framework.amoda.generic.core.GenericApplicationMemberAbstract m=(de.gulden.framework.amoda.generic.core.GenericApplicationMemberAbstract)serializer.deserialize(ee);
                            m.setEnvironment(GenericApplicationEnvironment.this);
                            registerMember(m);
                        }
                        
                        // messages
                        nl=element.getElementsByTagName("message");
                        for (int i=0;i<nl.getLength();i++) {
                            de.gulden.framework.amoda.generic.interaction.GenericMessage m=(de.gulden.framework.amoda.generic.interaction.GenericMessage)serializer.deserialize((Element)nl.item(i));
                            m.setEnvironment(GenericApplicationEnvironment.this);
                            registerMember(m);
                        }
                        
                        // log-messages
                        nl=element.getElementsByTagName("log-message");
                        for (int i=0;i<nl.getLength();i++) {
                            de.gulden.framework.amoda.generic.interaction.GenericLogMessage m=(de.gulden.framework.amoda.generic.interaction.GenericLogMessage)serializer.deserialize((Element)nl.item(i));
                            m.setEnvironment(GenericApplicationEnvironment.this);
                            registerMember(m);
                        }
                        
                        // questions
                        nl=element.getElementsByTagName("question");
                        for (int i=0;i<nl.getLength();i++) {
                            de.gulden.framework.amoda.generic.interaction.GenericQuestion m=(de.gulden.framework.amoda.generic.interaction.GenericQuestion)serializer.deserialize((Element)nl.item(i));
                            m.setEnvironment(GenericApplicationEnvironment.this);
                            registerMember(m);
                        }
                        
                        // dialog
                        nl=element.getElementsByTagName("dialog");
                        for (int i=0;i<nl.getLength();i++) {
                            de.gulden.framework.amoda.generic.interaction.GenericDialog m=(de.gulden.framework.amoda.generic.interaction.GenericDialog)serializer.deserialize((Element)nl.item(i));
                            m.setEnvironment(GenericApplicationEnvironment.this);
                            registerMember(m);
                        }
                        
                        // wizard
                        nl=element.getElementsByTagName("wizard");
                        for (int i=0;i<nl.getLength();i++) {
                            de.gulden.framework.amoda.generic.interaction.GenericWizard m=(de.gulden.framework.amoda.generic.interaction.GenericWizard)serializer.deserialize((Element)nl.item(i));
                            m.setEnvironment(GenericApplicationEnvironment.this);
                            registerMember(m);
                        }
                        
                        // --- behaviour members -----------------------------------------
                        
                        // wizard
                        nl=element.getElementsByTagName("wizard");
                        for (int i=0;i<nl.getLength();i++) {
                            de.gulden.framework.amoda.generic.interaction.GenericWizard m=(de.gulden.framework.amoda.generic.interaction.GenericWizard)serializer.deserialize((Element)nl.item(i));
                            m.setEnvironment(GenericApplicationEnvironment.this);
                            registerMember(m);
                        }
                    }
                    
                    private void handleConfigurationOption(String id,Object defaultValue,org.w3c.dom.Element element,de.gulden.framework.amoda.generic.option.GenericOptions configurationOptions) {  
                        de.gulden.framework.amoda.model.option.OptionEntry o;
                        String s;
                        o=createDefaultOption(CONFIGURATION_PERSISTENT_OPTIONS,Boolean.TRUE,null);
                        s=element.getAttribute(CONFIGURATION_PERSISTENT_OPTIONS);
                        if ((s!=null)&&(!s.equals(""))) {
                            ((de.gulden.framework.amoda.generic.data.GenericValue)o.getValue()).parseString(s);
                        }
                        configurationOptions.addOption(o);
                    }
                        
                    public void toXML(org.w3c.dom.Element element,de.gulden.util.xml.XMLSerializer serializer) {
                    }
                    
                    public org.w3c.dom.Element getSchemaFragment(org.w3c.dom.Document document) {
                        return null;
                    }
                    
                    public String getDTDFragment() {
                        String dtd;
                        dtd="<!ELEMENT application (metadata?,options?,members?)>\n"
                           +"<!ATTLIST application\n"
                           +"          version ID #REQUIRED>\n"
                           +"<!ENTITY interaction-member message|log-message|question|dialog|wizard>\n"
                           +"<!ENTITY behaviour-member command|condition|rule|state>\n"
                           +"<!ELEMENT members (%interaction-member;|%behaviour-member;)*>\n"
                           +(new de.gulden.framework.amoda.generic.option.GenericOptions()).getXMLHandler().getDTDFragment()
                           +(new de.gulden.framework.amoda.generic.metadata.GenericMetadata()).getXMLHandler().getDTDFragment()
                           +(new de.gulden.framework.amoda.generic.interaction.GenericMessage()).getXMLHandler().getDTDFragment()
                           +(new de.gulden.framework.amoda.generic.interaction.GenericLogMessage()).getXMLHandler().getDTDFragment()
                           +(new de.gulden.framework.amoda.generic.interaction.GenericErrorMessage()).getXMLHandler().getDTDFragment()
                           +(new de.gulden.framework.amoda.generic.interaction.GenericQuestion()).getXMLHandler().getDTDFragment()
                           +(new de.gulden.framework.amoda.generic.interaction.GenericDialog()).getXMLHandler().getDTDFragment()
                           +(new de.gulden.framework.amoda.generic.interaction.GenericWizard()).getXMLHandler().getDTDFragment();
                        return dtd;
                    }
                };

    }

    /**
     * Creates the message.
     *  
     * @param element The element.
     * @return  The message.
     */
    protected Message createMessage(Element element) throws XMLException {
        // DEPRECATED
                de.gulden.framework.amoda.generic.interaction.GenericMessage m=new de.gulden.framework.amoda.generic.interaction.GenericMessage(this);
                m.getXMLHandler().parseXML(element,null);
                return m;

    }

    /**
     * Creates the log message.
     *  
     * @param element The element.
     * @return  The log message.
     */
    protected LogMessage createLogMessage(Element element) throws XMLException {
        // DEPRECATED
                de.gulden.framework.amoda.generic.interaction.GenericLogMessage m=new de.gulden.framework.amoda.generic.interaction.GenericLogMessage(this);
                m.getXMLHandler().parseXML(element,null);
                return m;

    }

    /**
     * Creates the error message.
     *  
     * @param element The element.
     * @return  The error message.
     */
    protected ErrorMessage createErrorMessage(Element element) throws XMLException {
        // DEPRECATED
                de.gulden.framework.amoda.generic.interaction.GenericErrorMessage m=new de.gulden.framework.amoda.generic.interaction.GenericErrorMessage(this);
                m.getXMLHandler().parseXML(element,null);
                return m;

    }

    /**
     * Creates the question.
     *  
     * @param element The element.
     * @return  The question.
     */
    protected Question createQuestion(Element element) throws XMLException {
        // DEPRECATED
                de.gulden.framework.amoda.generic.interaction.GenericQuestion q=new de.gulden.framework.amoda.generic.interaction.GenericQuestion(this);
                q.getXMLHandler().parseXML(element,null);
                return q;

    }

    /**
     * Creates the dialog.
     *  
     * @param element The element.
     * @return  The dialog.
     */
    protected Dialog createDialog(Element element) throws XMLException {
        // DEPRECATED
                de.gulden.framework.amoda.generic.interaction.GenericDialog d=new de.gulden.framework.amoda.generic.interaction.GenericDialog(this);
                d.getXMLHandler().parseXML(element,null);
                return d;

    }

    /**
     * Creates the wizard.
     *  
     * @param element The element.
     * @return  The wizard.
     */
    protected Wizard createWizard(Element element) throws XMLException {
        // DEPRECATED
                de.gulden.framework.amoda.generic.interaction.GenericWizard w=new de.gulden.framework.amoda.generic.interaction.GenericWizard(this);
                w.getXMLHandler().parseXML(element,null);
                return w;

    }

    /**
     * Creates the log file.
     *  
     * @return  The log file.
     */
    protected LogFile createLogFile() {
        java.io.File f=new java.io.File(getLogFilename());
        LogFile logFile=new LogFile();
        logFile.setFile(f);
        logFile.open();
        return logFile;

    }

    /**
     * Returns the log filename.
     *  
     * @return  The log filename.
     */
    protected String getLogFilename() {
        String n=null;
        n=getApplicationOptions().getString("logfile");
        if (n==null) {
            n=getDefaultLogFilename();
        }
        return n;

    }

    /**
     * Returns the default log filename.
     *  
     * @return  The default log filename.
     */
    protected String getDefaultLogFilename() {
        String n=System.getProperties().getProperty("amoda.default.logfile",DEFAULT_LOGFILE);
        return n;

    }

    /**
     * Inits the application options.
     *  
     * @param options The options.
     */
    protected void initApplicationOptions(GenericOptions options) {
        if (getConfiguration().getBoolean(CONFIGURATION_PERSISTENT_OPTIONS)) {
            String propertiesFilename=getPropertiesFilename();
            options.loadFromProperties(propertiesFilename);
        }
        ArgsParser argsParser=getArgsParser();
        if (argsParser!=null) {
            argsParser.parseOptions(options);
            setBatchCommands(argsParser.parseBatchCommands(getApplicationMembersOfType(de.gulden.framework.amoda.model.behaviour.Command.class)));
            setInputValues(argsParser.parseInputValues());
        }

    }

    /**
     * Returns the properties filename.
     *  
     * @return  The properties filename.
     */
    protected String getPropertiesFilename() {
        String n=null;
        n=getApplicationOptions().getString("properties"); // ***** ??? already loaded ?!?
        if (n==null) {
            n=getDefaultPropertiesFilename();
        }
        return n;

    }

    /**
     * Returns the default properties filename.
     *  
     * @return  The default properties filename.
     */
    protected String getDefaultPropertiesFilename() {
        String n=System.getProperties().getProperty("amoda.properties",DEFAULT_PROPERTIES);
        return n;

    }

    /**
     *  
     * @param member The member.
     */
    void registerMember(GenericApplicationMemberInterface member) {
        applicationMembersData.put(member.getId(),member);

    }

    /**
     * Creates the metadata.
     *  
     * @param element The element.
     * @return  The metadata.
     */
    Metadata createMetadata(Element element) {
        // your code here
        return null;

    }

    /**
     * Creates the options.
     *  
     * @param element The element.
     * @return  The options.
     */
    Options createOptions(Element element) {
        // your code here
        return null;

    }

    /**
     * Creates the option.
     *  
     * @param element The element.
     * @return  The option.
     */
    Option createOption(Element element) {
        // your code here
        return null;

    }

    /**
     * Creates the options choice.
     *  
     * @param element The element.
     * @return  The option choice.
     */
    OptionChoice createOptionsChoice(Element element) {
        // your code here
        return null;

    }


    // ------------------------------------------------------------------------
    // --- static methods                                                   ---
    // ------------------------------------------------------------------------
    /**
     * Returns the v e r s i o n.
     *  
     * @return  The v e r s i o n.
     */
    public static String getVERSION() {
        return VERSION;

    }

    /**
     * Returns the d e f a u l t_ l o g f i l e.
     *  
     * @return  The d e f a u l t_ l o g f i l e.
     */
    public static String getDEFAULT_LOGFILE() {
        return DEFAULT_LOGFILE;

    }

    /**
     * Sets the d e f a u l t_ l o g f i l e.
     *  
     * @param _DEFAULT_LOGFILE The d e f a u l t_ l o g f i l e.
     */
    public static void setDEFAULT_LOGFILE(String _DEFAULT_LOGFILE) {
        DEFAULT_LOGFILE = _DEFAULT_LOGFILE;

    }

    /**
     * Returns the d e f a u l t_ p r o p e r t i e s.
     *  
     * @return  The d e f a u l t_ p r o p e r t i e s.
     */
    public static String getDEFAULT_PROPERTIES() {
        return DEFAULT_PROPERTIES;

    }

    /**
     * Sets the d e f a u l t_ p r o p e r t i e s.
     *  
     * @param _DEFAULT_PROPERTIES The d e f a u l t_ p r o p e r t i e s.
     */
    public static void setDEFAULT_PROPERTIES(String _DEFAULT_PROPERTIES) {
        DEFAULT_PROPERTIES = _DEFAULT_PROPERTIES;

    }

    /**
     * Returns the n l.
     *  
     * @return  The n l.
     */
    public static String getNL() {
        return NL;

    }

    /**
     * Sets the n l.
     *  
     * @param _NL The n l.
     */
    public static void setNL(String _NL) {
        NL = _NL;

    }

    /**
     * Returns the c o n f i g u r a t i o n_ p e r s i s t e n t_ o p t i o n s.
     *  
     * @return  The c o n f i g u r a t i o n_ p e r s i s t e n t_ o p t i o n s.
     */
    public static String getCONFIGURATION_PERSISTENT_OPTIONS() {
        return CONFIGURATION_PERSISTENT_OPTIONS;

    }

    /**
     * Sets the c o n f i g u r a t i o n_ p e r s i s t e n t_ o p t i o n s.
     *  
     * @param _CONFIGURATION_PERSISTENT_OPTIONS The c o n f i g u r a t i o n_ p e r s i s t e n t_ o p t i o n s.
     */
    public static void setCONFIGURATION_PERSISTENT_OPTIONS(String _CONFIGURATION_PERSISTENT_OPTIONS) {
        CONFIGURATION_PERSISTENT_OPTIONS = _CONFIGURATION_PERSISTENT_OPTIONS;

    }

    /**
     * Returns the c o n f i g u r a t i o n_ b a t c h_ m o d e.
     *  
     * @return  The c o n f i g u r a t i o n_ b a t c h_ m o d e.
     */
    public static String getCONFIGURATION_BATCH_MODE() {
        return CONFIGURATION_BATCH_MODE;

    }

    /**
     * Sets the c o n f i g u r a t i o n_ b a t c h_ m o d e.
     *  
     * @param _CONFIGURATION_BATCH_MODE The c o n f i g u r a t i o n_ b a t c h_ m o d e.
     */
    public static void setCONFIGURATION_BATCH_MODE(String _CONFIGURATION_BATCH_MODE) {
        CONFIGURATION_BATCH_MODE = _CONFIGURATION_BATCH_MODE;

    }

    /**
     * Returns the c o n f i g u r a t i o n_ i n t e r a c t i o n_ m o d e.
     *  
     * @return  The c o n f i g u r a t i o n_ i n t e r a c t i o n_ m o d e.
     */
    public static String getCONFIGURATION_INTERACTION_MODE() {
        return CONFIGURATION_INTERACTION_MODE;

    }

    /**
     * Sets the c o n f i g u r a t i o n_ i n t e r a c t i o n_ m o d e.
     *  
     * @param _CONFIGURATION_INTERACTION_MODE The c o n f i g u r a t i o n_ i n t e r a c t i o n_ m o d e.
     */
    public static void setCONFIGURATION_INTERACTION_MODE(String _CONFIGURATION_INTERACTION_MODE) {
        CONFIGURATION_INTERACTION_MODE = _CONFIGURATION_INTERACTION_MODE;

    }

    /**
     * Parses the x m l metadata.
     *  
     * @param element The element.
     * @param serializer The serializer.
     * @return  The metadata.
     */
    public static Metadata parseXMLMetadata(Element element, XMLSerializer serializer) throws XMLException {
        Element metadataTag=de.gulden.util.xml.XMLToolbox.getChild(element,"metadata");
        if (metadataTag!=null) {
            de.gulden.framework.amoda.generic.metadata.GenericMetadata metadata=new de.gulden.framework.amoda.generic.metadata.GenericMetadata();
            metadata.getXMLHandler().parseXML(metadataTag,serializer);
            return metadata;
        } else {
            return new de.gulden.framework.amoda.generic.metadata.GenericMetadata(); // dummy rather than null
        }

    }

} // end GenericApplicationEnvironment
