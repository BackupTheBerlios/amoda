/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.generic.core.GenericApplicationEnvironmentFactory
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
import de.gulden.framework.amoda.model.core.ApplicationEnvironment;
import de.gulden.framework.amoda.model.core.ApplicationEnvironmentFactory;
import de.gulden.util.xml.XMLSerializer;
import de.gulden.util.xml.XMLToolbox;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

/**
 * Class GenericApplicationEnvironmentFactory.
 */
public abstract class GenericApplicationEnvironmentFactory implements ApplicationEnvironmentFactory {

    // ------------------------------------------------------------------------
    // --- static fields                                                    ---
    // ------------------------------------------------------------------------
    /**
     * The d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     */
    public static String DEFAULT_CONFIGURATION_RESOURCE="application.xml";

    /**
     * The d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e_ p r o p e r t y.
     */
    public static String DEFAULT_CONFIGURATION_RESOURCE_PROPERTY="amoda.application.config";


    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The args array.
     */
    protected String[] args;

    /**
     * The configuration document.
     */
    protected Document configurationDocument;

    /**
     * The x m l serializer.
     */
    protected XMLSerializer xMLSerializer;

    /**
     * The document builder.
     */
    protected DocumentBuilder documentBuilder;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of GenericApplicationEnvironmentFactory.
     *  
     * @param args The args.
     */
    public GenericApplicationEnvironmentFactory(String[] args) {
        super();
        setArgs(args);
        try {
            //factory.setExpandEntityReferences(false); // avoid conflict with DTD reference when reading input from stream (conflict with resolving the reference occurs even if validating==false)
            setDocumentBuilder(XMLToolbox.createDefaultDocumentBuilder(false,false,true,true,false,true));
        } catch (Exception e) {
            fatalError("cannot create DocumentBuilder",e);
        }
        setXMLSerializer(createXMLSerializer());

    }

    /**
     * Creates a new instance of GenericApplicationEnvironmentFactory.
     *  
     * @param args The args.
     * @param configurationResource The configuration resource.
     */
    public GenericApplicationEnvironmentFactory(String[] args, URL configurationResource) {
        this(args);
        setConfiguration(configurationResource);

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
     * Returns the configuration document.
     *  
     * @return  The configuration document.
     */
    public Document getConfigurationDocument() {
        return configurationDocument;

    }

    /**
     * Sets the configuration document.
     *  
     * @param _configurationDocument The configuration document.
     */
    public void setConfigurationDocument(Document _configurationDocument) {
        configurationDocument = _configurationDocument;

    }

    /**
     * Returns the x m l serializer.
     *  
     * @return  The x m l serializer.
     */
    public XMLSerializer getXMLSerializer() {
        return xMLSerializer;

    }

    /**
     * Sets the x m l serializer.
     *  
     * @param _xMLSerializer The x m l serializer.
     */
    public void setXMLSerializer(XMLSerializer _xMLSerializer) {
        xMLSerializer = _xMLSerializer;

    }

    /**
     * Returns the document builder.
     *  
     * @return  The document builder.
     */
    public DocumentBuilder getDocumentBuilder() {
        return documentBuilder;

    }

    /**
     * Sets the document builder.
     *  
     * @param _documentBuilder The document builder.
     */
    public void setDocumentBuilder(DocumentBuilder _documentBuilder) {
        documentBuilder = _documentBuilder;

    }

    /**
     * Creates the application environment.
     *  
     * @return  The application environment.
     */
    public ApplicationEnvironment createApplicationEnvironment() {
        org.w3c.dom.Element applicationTag=getConfiguration().getDocumentElement();
        try {
            GenericApplicationEnvironment env=(GenericApplicationEnvironment)getXMLSerializer().deserialize(applicationTag);
            env.setFactory(this);
            return env;
        } catch (de.gulden.util.xml.XMLException e) {
            fatalError("can't parse application XML",e);
            return null;
        }

    }

    /**
     * Sets the configuration.
     *  
     * @param inputStream The configuration.
     */
    public void setConfiguration(InputStream inputStream) {
        try {
            Document d=getDocumentBuilder().parse(inputStream);
            setConfiguration(d);
        } catch (Exception e) {
            fatalError("could not initialize application XML configuration",e);
        }

    }

    /**
     * Sets the configuration.
     *  
     * @param url The configuration.
     */
    public void setConfiguration(URL url) {
        try {
                    String u=url.toExternalForm();
                    Document d=getDocumentBuilder().parse(u);
                    setConfiguration(d);
                } catch (Exception e) {
                    fatalError("could not initialize application XML configuration",e);
                }
        /*        
                try {
                    InputStream in=url.openStream();
                    setConfiguration(in);
                    in.close();
                } catch (java.io.IOException e) {
                    fatalError("could not get application XML configuration",e);
                }
        */

    }

    /**
     * Sets the configuration.
     *  
     * @param resourceName The configuration.
     */
    public void setConfiguration(String resourceName) {
        setConfiguration(this.getClass().getClassLoader().getResource(resourceName));

    }

    /**
     * Sets the configuration.
     *  
     * @param document The configuration.
     */
    public void setConfiguration(Document document) {
        this.configurationDocument=document;

    }

    /**
     * Returns the configuration.
     *  
     * @return  The configuration.
     */
    public Document getConfiguration() {
        if (configurationDocument==null) { // has not been initialized by calling setConfiguration(..)
            // use default resource path to get XML
            String res=System.getProperties().getProperty(DEFAULT_CONFIGURATION_RESOURCE_PROPERTY,DEFAULT_CONFIGURATION_RESOURCE);
            setConfiguration(res);
        }
        return configurationDocument;

    }

    /**
     * Creates the x m l serializer.
     *  
     * @return  The x m l serializer.
     */
    protected abstract XMLSerializer createXMLSerializer();

    /**
     *  
     * @param msg The msg.
     * @param t The t.
     */
    void fatalError(String msg, Throwable t) {
        System.out.println(msg);
        System.out.println(t.getMessage());
        t.printStackTrace(System.out);

    }


    // ------------------------------------------------------------------------
    // --- static methods                                                   ---
    // ------------------------------------------------------------------------
    /**
     * Returns the d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     *  
     * @return  The d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     */
    public static String getDEFAULT_CONFIGURATION_RESOURCE() {
        return DEFAULT_CONFIGURATION_RESOURCE;

    }

    /**
     * Sets the d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     *  
     * @param _DEFAULT_CONFIGURATION_RESOURCE The d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e.
     */
    public static void setDEFAULT_CONFIGURATION_RESOURCE(String _DEFAULT_CONFIGURATION_RESOURCE) {
        DEFAULT_CONFIGURATION_RESOURCE = _DEFAULT_CONFIGURATION_RESOURCE;

    }

    /**
     * Returns the d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e_ p r o p e r t y.
     *  
     * @return  The d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e_ p r o p e r t y.
     */
    public static String getDEFAULT_CONFIGURATION_RESOURCE_PROPERTY() {
        return DEFAULT_CONFIGURATION_RESOURCE_PROPERTY;

    }

    /**
     * Sets the d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e_ p r o p e r t y.
     *  
     * @param _DEFAULT_CONFIGURATION_RESOURCE_PROPERTY The d e f a u l t_ c o n f i g u r a t i o n_ r e s o u r c e_ p r o p e r t y.
     */
    public static void setDEFAULT_CONFIGURATION_RESOURCE_PROPERTY(String _DEFAULT_CONFIGURATION_RESOURCE_PROPERTY) {
        DEFAULT_CONFIGURATION_RESOURCE_PROPERTY = _DEFAULT_CONFIGURATION_RESOURCE_PROPERTY;

    }

} // end GenericApplicationEnvironmentFactory
