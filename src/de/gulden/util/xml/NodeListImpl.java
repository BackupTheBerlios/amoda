/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.util.xml.NodeListImpl
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

package de.gulden.util.xml;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * Class NodeListImpl.
 */
public class NodeListImpl implements NodeList {

    // ------------------------------------------------------------------------
    // --- field                                                            ---
    // ------------------------------------------------------------------------
    /**
     * The list.
     */
    protected Vector list;


    // ------------------------------------------------------------------------
    // --- constructor                                                      ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of NodeListImpl.
     */
    public NodeListImpl() {
        list=new Vector();

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the list.
     *  
     * @return  The list.
     */
    public Vector getList() {
        return list;

    }

    /**
     * Sets the list.
     *  
     * @param vector The list.
     */
    public void setList(Vector vector) {
        this.list = vector;

    }

    /**
     *  
     * @param index The index.
     * @return  The node.
     */
    public Node item(int index) {
        return (Node)list.elementAt(index);

    }

    /**
     * Returns the length.
     *  
     * @return  The length.
     */
    public int getLength() {
        return list.size();

    }

    /**
     *  
     * @param node The node.
     */
    public void add(Node node) {
        list.addElement(node);

    }

    /**
     *  
     * @param node The node.
     */
    public void remove(Node node) {
        list.removeElement(node);

    }

} // end NodeListImpl
