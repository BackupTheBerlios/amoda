/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.workspace.Workspace
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

package de.gulden.framework.amoda.model.workspace;

import java.util.*;
import java.util.Collection;

/**
 * Class Workspace.
 */
public interface Workspace {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the documents.
     *  
     * @return  The documents.
     */
    public Collection getDocuments();

    /**
     * Returns the active document.
     *  
     * @return  The active document.
     */
    public WorkspaceDocument getActiveDocument();

} // end Workspace
