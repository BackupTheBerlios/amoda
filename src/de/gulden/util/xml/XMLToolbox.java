/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.util.xml.XMLToolbox
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

import de.gulden.util.xml.NodeListImpl;
import java.io.*;
import java.util.*;
import java.util.Collection;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * Class XMLToolbox.
 */
public class XMLToolbox {

    // ------------------------------------------------------------------------
    // --- static methods                                                   ---
    // ------------------------------------------------------------------------
    /**
     * Creates the default document builder.
     *  
     * @return  The document builder.
     */
    public static DocumentBuilder createDefaultDocumentBuilder() {
        try {
            javax.xml.parsers.DocumentBuilderFactory factory=javax.xml.parsers.DocumentBuilderFactory.newInstance();
            return factory.newDocumentBuilder();
        } catch (Exception e) {
            System.err.println("fatal error: cannot create default DocumentBuilder");
            System.err.println(e.getClass().getName()+" - "+e.getMessage());
            e.printStackTrace(System.err);
            System.exit(2);
            return null;
        }

    }

    /**
     * Creates the default document builder.
     *  
     * @param validating The validating.
     * @param namespaceAware The namespace aware.
     * @param ignoringElementContentWhitespace The ignoring element content whitespace.
     * @param ignoringComments The ignoring comments.
     * @param expandEntityReferences The expand entity references.
     * @param coalescing The coalescing.
     * @return  The document builder.
     */
    public static DocumentBuilder createDefaultDocumentBuilder(boolean validating, boolean namespaceAware, boolean ignoringElementContentWhitespace, boolean ignoringComments, boolean expandEntityReferences, boolean coalescing) {
        try {
            javax.xml.parsers.DocumentBuilderFactory factory=javax.xml.parsers.DocumentBuilderFactory.newInstance();
            factory.setValidating(validating);
            factory.setNamespaceAware(namespaceAware);
            factory.setIgnoringElementContentWhitespace(ignoringElementContentWhitespace);
            factory.setIgnoringComments(ignoringComments);
            factory.setExpandEntityReferences(expandEntityReferences);
            factory.setCoalescing(coalescing);
            return factory.newDocumentBuilder();
        } catch (Exception e) {
            System.err.println("fatal error: cannot create default DocumentBuilder");
            System.err.println(e.getClass().getName()+" - "+e.getMessage());
            e.printStackTrace(System.err);
            System.exit(2);
            return null;
        }

    }

    /**
     * Returns the child.
     *  
     * @param e The e.
     * @param tagname The tagname.
     * @return  The child.
     */
    public static Element getChild(Element e, String tagname) {
        Node n=e.getFirstChild();
        while (n!=null)
        {
          if (n instanceof Element)
          {
            Element c=(Element)n;
            if (c.getTagName().equals(tagname))
            {
              return c;
            }
          }
          n=n.getNextSibling();
        }
        return null;

    }

    /**
     * Returns the child required.
     *  
     * @param e The e.
     * @param tagname The tagname.
     * @return  The child required.
     */
    public static Element getChildRequired(Element e, String tagname) throws XMLException {
        Element c=getChild(e,tagname);
        if (c==null)
        {
          throw new XMLException("child tag '<"+tagname+"'> required",e);
        }
        return c;

    }

    /**
     * Returns the attribute required.
     *  
     * @param e The e.
     * @param att The att.
     * @return  The attribute required.
     */
    public static String getAttributeRequired(Element e, String att) throws XMLException {
        String a=e.getAttribute(att);
        if ((a==null)||(a.length()==0))
        {
          throw new XMLException("attribute '"+att+"' required",e);
        }
        return a;

    }

    /**
     * Returns the children.
     *  
     * @param e The e.
     * @param tagname The tagname.
     * @return  The children.
     */
    public static NodeList getChildren(Element e, String tagname) {
        NodeListImpl nl=new NodeListImpl();
        Node n=e.getFirstChild();
        while (n!=null)
        {
          if (n instanceof Element)
          {
            Element c=(Element)n;
            if (c.getTagName().equals(tagname))
            {
              nl.add(c);
            }
          }
          n=n.getNextSibling();
        }
        return nl;

    }

    /**
     *  
     * @param e The e.
     * @param attr The attr.
     * @return  The boolean.
     */
    public static boolean isYesAttribute(Element e, String attr) {
        String a=e.getAttribute(attr);
        return (a!=null)&&(a.equals("yes"));

    }

    /**
     * Returns the text.
     *  
     * @param e The e.
     * @return  The text.
     */
    public static String getText(Element e) {
        Node n=e.getFirstChild();
        if ((n!=null)&&(n instanceof CharacterData))
        {
          String t=((CharacterData)n).getData();
          return t;
        }
        else
        {
          return null;
        }

    }

    /**
     * Returns the child text.
     *  
     * @param e The e.
     * @param tagname The tagname.
     * @return  The child text.
     */
    public static String getChildText(Element e, String tagname) {
        Element child=getChild(e,tagname);
        if (child!=null)
        {
          return getText(child);
        }
        else
        {
          return null;
        }

    }

    /**
     *  
     * @param element The element.
     * @param name The name.
     */
    public static void requireTagName(Element element, String name) throws XMLException {
        if (!element.getTagName().equals(name)) {
            throw new XMLException("illegal XML tag - expected <"+name+">",element);
        }

    }

    /**
     * Returns the first child.
     *  
     * @param e The e.
     * @return  The first child.
     */
    public static Element getFirstChild(Element e) {
        return getSelfOrFollowingElement(e.getFirstChild());

    }

    /**
     * Returns the children.
     *  
     * @param e The e.
     * @return  The children.
     */
    public static Collection getChildren(Element e) {
        Collection c=new ArrayList();
        Element ee=getFirstChild(e);
        while (ee!=null) {
            c.add(ee);
            ee=getFollowingElement(ee);
        }
        return c;

    }

    /**
     * Returns the self or following element.
     *  
     * @param n The n.
     * @return  The self or following element.
     */
    public static Element getSelfOrFollowingElement(Node n) {
        while ((n!=null)&&(!(n instanceof Element))) {
            n=n.getNextSibling();
        }
        return (Element)n;

    }

    /**
     * Returns the following element.
     *  
     * @param n The n.
     * @return  The following element.
     */
    public static Element getFollowingElement(Node n) {
        return getSelfOrFollowingElement(n.getNextSibling());

    }

    /**
     * Returns the langstring.
     *  
     * @param element The element.
     * @param countryCode The country code.
     * @return  The langstring.
     */
    public static String getLangstring(Element element, String countryCode) {
        if (element!=null) { // make null-safe to allow easier calling from nested functions
            org.w3c.dom.NodeList nl=getChildren(element,"langstring");
            if (nl.getLength()>0) {
                org.w3c.dom.Element defaultElement=null;
                for (int i=0;i<nl.getLength();i++) {
                    Element e=(Element)nl.item(i);
                    String c=e.getAttribute("lang");
                    if ((c.equals(""))&&(defaultElement==null)) {
                        defaultElement=e;
                        if (countryCode==null) {
                            return getText(e); // default found
                        }
                    } else if ((countryCode!=null)&&(countryCode.equalsIgnoreCase(c))) { // explicit lang wanted
                        return getText(e); // language found
                    }
                }
                // not explicitly found, use default
                if (defaultElement!=null) {
                    // (countryCode!=null) here, otherwise already returned
                    return getText(defaultElement); // return default if there was a <langstring> without explicit lang attribute, although AN EXPLICIT LANGUAGE HAD BEEN REQUESTED HERE
                } else {
                    // last chance: if no default <langstring> without lang attribute
                    if (countryCode==null) { // but also no lang was explicitly requested
                        return getText((Element)nl.item(0)); // use first entry as default
                    } else {
                        return null; // not found
                    }
                }
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    /**
     * Returns the langstring.
     *  
     * @param element The element.
     * @return  The langstring.
     */
    public static String getLangstring(Element element) {
        return getLangstring(element,null); // default language

    }

} // end XMLToolbox
