/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.environment.commandline.CommandLineCommand
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

import de.gulden.framework.amoda.generic.core.GenericApplicationMemberAbstract;
import de.gulden.framework.amoda.model.behaviour.Command;
import de.gulden.util.xml.XMLHandler;
import java.util.*;

/**
 * Class CommandLineCommand.
 */
public class CommandLineCommand extends GenericApplicationMemberAbstract implements Command {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The code.
     */
    protected String code;


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the code.
     *  
     * @return  The code.
     */
    public String getCode() {
        return code;

    }

    /**
     * Sets the code.
     *  
     * @param _code The code.
     */
    public void setCode(String _code) {
        code = _code;

    }

    /**
     *  
     * @return  The boolean.
     */
    public boolean execute() {
        // pass to main application by default
        ((de.gulden.framework.amoda.environment.commandline.CommandLineApplication)(((de.gulden.framework.amoda.generic.core.GenericApplicationEnvironment)getEnvironment()).getGenericApplication())).executeCommand(this.getCode());
        return true;

    }

    /**
     * Creates the x m l handler.
     *  
     * @return  The x m l handler.
     */
    protected XMLHandler createXMLHandler() {
        return new XMLHandler() {
            public void parseXML(org.w3c.dom.Element element,de.gulden.util.xml.XMLSerializer serializer) throws de.gulden.util.xml.XMLException {
                setId(de.gulden.util.xml.XMLToolbox.getAttributeRequired(element,"id"));
                setCode(de.gulden.util.xml.XMLToolbox.getAttributeRequired(element,"code"));
            }
            
            public void toXML(org.w3c.dom.Element element,de.gulden.util.xml.XMLSerializer serializer) {
            }
            
            public org.w3c.dom.Element getSchemaFragment(org.w3c.dom.Document document) {
                return null;
            }
            
            public String getDTDFragment() {
                return null;
            }
        };

    }

} // end CommandLineCommand
