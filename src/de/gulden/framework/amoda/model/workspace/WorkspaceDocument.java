/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.framework.amoda.model.workspace.WorkspaceDocument
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

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * Class WorkspaceDocument.
 */
public interface WorkspaceDocument extends WorkspaceDocumentCompositePart {

    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the selection.
     *  
     * @return  The selection.
     */
    public WorkspaceDocumentSelection getSelection();

    /**
     * Returns the active part.
     *  
     * @return  The active part.
     */
    public WorkspaceDocumentPart getActivePart();

    /**
     *  
     * @param in The in.
     */
    public void load(InputStream in);

    /**
     *  
     * @param out The out.
     */
    public void save(OutputStream out);

} // end WorkspaceDocument
