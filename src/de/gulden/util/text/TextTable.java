/*
 * Project: AMODA - Abstract Modeled Application
 * Class:   de.gulden.util.text.TextTable
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

package de.gulden.util.text;

import de.gulden.util.Toolbox;
import java.util.*;
import java.util.Collection;

/**
 * Class TextTable.
 */
public class TextTable {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------
    /**
     * The column count.
     */
    protected int columnCount;

    /**
     * The rows.
     */
    protected Collection rows;

    /**
     * The column weight array.
     */
    protected double[] columnWeight;

    /**
     * The border.
     */
    protected boolean border;

    /**
     * The borderchar.
     */
    protected char borderchar;

    /**
     * The max width.
     */
    protected int maxWidth;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------
    /**
     * Creates a new instance of TextTable.
     *  
     * @param columnCount The column count.
     * @param width The width.
     */
    public TextTable(int columnCount, int width) {
        this(columnCount,width,initArray(columnCount),'+');

    }

    /**
     * Creates a new instance of TextTable.
     *  
     * @param columnCount The column count.
     * @param maxWidth The max width.
     * @param columnWeights The column weights.
     * @param borderchar The borderchar.
     */
    public TextTable(int columnCount, int maxWidth, double[] columnWeights, char borderchar) {
        this.columnCount=columnCount;
        this.maxWidth=maxWidth;
        this.columnWeight=columnWeights;
        this.borderchar=borderchar;
        rows=new ArrayList();

    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------
    /**
     * Returns the column count.
     *  
     * @return  The column count.
     */
    public int getColumnCount() {
        return columnCount;

    }

    /**
     * Sets the column count.
     *  
     * @param _columnCount The column count.
     */
    public void setColumnCount(int _columnCount) {
        columnCount = _columnCount;

    }

    /**
     * Returns the rows.
     *  
     * @return  The rows.
     */
    public Collection getRows() {
        return rows;

    }

    /**
     * Sets the rows.
     *  
     * @param _rows The rows.
     */
    public void setRows(Collection _rows) {
        rows = _rows;

    }

    /**
     * Returns the column weight.
     *  
     * @return  The column weight array.
     */
    public double[] getColumnWeight() {
        return columnWeight;

    }

    /**
     * Sets the column weight.
     *  
     * @param _columnWeight The column weight array.
     */
    public void setColumnWeight(double[] _columnWeight) {
        columnWeight = _columnWeight;

    }

    /**
     *  
     * @return  The boolean.
     */
    public boolean isBorder() {
        return border;

    }

    /**
     * Sets the border.
     *  
     * @param _border The border.
     */
    public void setBorder(boolean _border) {
        border = _border;

    }

    /**
     * Returns the borderchar.
     *  
     * @return  The borderchar.
     */
    public char getBorderchar() {
        return borderchar;

    }

    /**
     * Sets the borderchar.
     *  
     * @param _borderchar The borderchar.
     */
    public void setBorderchar(char _borderchar) {
        borderchar = _borderchar;

    }

    /**
     * Returns the max width.
     *  
     * @return  The max width.
     */
    public int getMaxWidth() {
        return maxWidth;

    }

    /**
     * Sets the max width.
     *  
     * @param _maxWidth The max width.
     */
    public void setMaxWidth(int _maxWidth) {
        maxWidth = _maxWidth;

    }

    /**
     * Adds a row.
     *  
     * @param row The row.
     */
    public void addRow(String[] row) {
        rows.add(row);

    }

    /**
     *  
     * @return  The string.
     */
    public String toString() {
        // get all individual words
        String[][][] tableWords=new String[rows.size()][columnCount][];
        int row=0;
        for (Iterator it=rows.iterator();it.hasNext();) {
            String[] cols=(String[])it.next();
            for (int col=0;col<columnCount;col++) {
                String text=cols[col];
                String[] words=splitWords(text);
                tableWords[row][col]=words;
            }
            row++;
        }
        // get widths
        int[] width=new int[columnCount];
        int minW=0;
        for (int col=0;col<columnCount;col++) {
            width[col]=minimumWidth(tableWords,col);
            minW+=width[col];
        }
        minW+=(columnCount+1); // one space between each col
        // can't help if minW>maxWidth, but if minW<maxWidth..:
        int totalWidth;
        if (minW<maxWidth) {
            int rest=maxWidth-minW;
            normalizeWeights();
            totalWidth=0;
            for (int i=0;i<columnCount;i++) {
                width[i]+=Math.round(((double)rest)*columnWeight[i]);
                totalWidth+=width[i];
            }
            totalWidth+=(columnCount+1);
        } else {
            totalWidth=minW;
        }
        
        // width[] now ok, create text boxes
        String[][][] text=new String[rows.size()][columnCount][];
        row=0;
        for (Iterator it=rows.iterator();it.hasNext();) {
            String[] r=(String[])it.next();
            for (int col=0;col<columnCount;col++) {
                String s=r[col];
                text[row][col]=textBox(tableWords[row][col],width[col]);
            }
            row++;
        }
        // output
        StringBuffer out=new StringBuffer();
        for (row=0;row<text.length;row++) {
            out.append(Toolbox.repeat(borderchar,totalWidth)+Toolbox.NL); // horizontal border
            int maxHeight=0;
            for (int col=0;col<columnCount;col++) {
                if (text[row][col].length>maxHeight) {
                    maxHeight=text[row][col].length;
                }
            }
            for (int i=0;i<maxHeight;i++) {
                out.append(borderchar); // first vertical border
                for (int col=0;col<columnCount;col++) {
                    String t;
                    if (i<text[row][col].length) {
                        t=text[row][col][i];
                    } else {
                        t=Toolbox.repeat(" ",width[col]);
                    }
                    out.append(t+borderchar); // incl. vertical border
                }
                out.append(Toolbox.NL);
            }
        }
        out.append(Toolbox.repeat(borderchar,totalWidth)+Toolbox.NL); // last horizontal border
        return out.toString();

    }

    private void normalizeWeights() {
        double sum=0.0;
        for (int i=0;i<columnCount;i++) {
            sum+=columnWeight[i];
        }
        if (sum!=0.0) {
            for (int i=0;i<columnCount;i++) {
                columnWeight[i]/=sum;
            }
        }
        // else special case: all weights 0 (means: keep table on minimum width possible)

    }


    // ------------------------------------------------------------------------
    // --- static methods                                                   ---
    // ------------------------------------------------------------------------
    /**
     * Inits the array.
     *  
     * @param size The size.
     * @return  The double array.
     */
    private static double[] initArray(int size) {
        double[] d=new double[size];
        for (int i=0;i<size;i++) {
            d[i]=1.0;
        }
        return d;

    }

    /**
     *  
     * @param words The words.
     * @param column The column.
     * @return  The int.
     */
    private static int minimumWidth(String[][][] words, int column) {
        int min=0;
        for (int row=0;row<words.length;row++) {
            String[] w=words[row][column];
            for (int i=0;i<w.length;i++) {
                String s=w[i];
                if (s.length()>min) {
                    min=s.length();
                }
            }
        }
        return min;

    }

    /**
     *  
     * @param text The text.
     * @return  The string array.
     */
    private static String[] splitWords(String text) {
        Collection words=new ArrayList();
                StringTokenizer st=new StringTokenizer(text," ");
                while (st.hasMoreTokens()) {
                    String tok=st.nextToken();
                    words.add(tok);
                }
                String[] r=new String[words.size()];
                return (String[])words.toArray(r);

    }

    /**
     *  
     * @param words The words.
     * @param width The width.
     * @return  The string array.
     */
    private static String[] textBox(String[] words, int width) {
        Collection c=new ArrayList();
        String line="";
        int i=0;
        while (i<words.length) {
            String word=words[i];
            // truncate if too long so that it would fit into a yet blank line
            if (word.length()>width) {
                word=word.substring(0,width);
            }
            boolean addSpace=(!line.equals(""))&&(!line.endsWith("-"));
            if (addSpace) {
                word=" "+word;
            }
            if ((line.length()+word.length())<=width) {
                line+=word;
                i++;
            } else {
                line=Toolbox.padRight(line," ",width);
                c.add(line); // add code here to support center-aligned cells etc.
                line="";
            }
        }
        if (!line.equals("")) {
            line=Toolbox.padRight(line," ",width);
            c.add(line);
        }
        String[] s=new String[c.size()];
        return (String[])c.toArray(s);

    }

} // end TextTable
