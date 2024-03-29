/*
 *  Java HTML Tidy - JTidy
 *  HTML parser and pretty printer
 *
 *  Copyright (c) 1998-2000 World Wide Web Consortium (Massachusetts
 *  Institute of Technology, Institut National de Recherche en
 *  Informatique et en Automatique, Keio University). All Rights
 *  Reserved.
 *
 *  Contributing Author(s):
 *
 *     Dave Raggett <dsr@w3.org>
 *     Andy Quick <ac.quick@sympatico.ca> (translation to Java)
 *     Gary L Peskin <garyp@firstech.com> (Java development)
 *     Sami Lempinen <sami@lempinen.net> (release management)
 *     Fabrizio Giustina <fgiust at users.sourceforge.net>
 *
 *  The contributing author(s) would like to thank all those who
 *  helped with testing, bug fixes, and patience.  This wouldn't
 *  have been possible without all of you.
 *
 *  COPYRIGHT NOTICE:
 * 
 *  This software and documentation is provided "as is," and
 *  the copyright holders and contributing author(s) make no
 *  representations or warranties, express or implied, including
 *  but not limited to, warranties of merchantability or fitness
 *  for any particular purpose or that the use of the software or
 *  documentation will not infringe any third party patents,
 *  copyrights, trademarks or other rights. 
 *
 *  The copyright holders and contributing author(s) will not be
 *  liable for any direct, indirect, special or consequential damages
 *  arising out of any use of the software or documentation, even if
 *  advised of the possibility of such damage.
 *
 *  Permission is hereby granted to use, copy, modify, and distribute
 *  this source code, or portions hereof, documentation and executables,
 *  for any purpose, without fee, subject to the following restrictions:
 *
 *  1. The origin of this source code must not be misrepresented.
 *  2. Altered versions must be plainly marked as such and must
 *     not be misrepresented as being the original source.
 *  3. This Copyright notice may not be removed or altered from any
 *     source or altered source distribution.
 * 
 *  The copyright holders and contributing author(s) specifically
 *  permit, without fee, and encourage the use of this source code
 *  as a component for supporting the Hypertext Markup Language in
 *  commercial products. If you use this source code in a product,
 *  acknowledgment is not required but would be appreciated.
 *
 */

package org.w3c.tidy;

/**
 * DOMNodeListByTagNameImpl. The items in the <code>NodeList</code> are accessible via an integral index, starting
 * from 0.
 * @author Dave Raggett <a href="mailto:dsr@w3.org">dsr@w3.org </a>
 * @author Andy Quick <a href="mailto:ac.quick@sympatico.ca">ac.quick@sympatico.ca </a> (translation to Java)
 * @author Fabrizio Giustina
 * @version $Revision: 633 $ ($Author: fgiust $)
 */
public class DOMNodeListByTagNameImpl implements org.w3c.dom.NodeList
{

    /**
     * First node.
     */
    private Node first;

    /**
     * Tag name.
     */
    private String tagName;

    /**
     * Current index.
     */
    private int currIndex;

    /**
     * Max index (number of nodes).
     */
    private int maxIndex;

    /**
     * Current node.
     */
    private Node currNode;

    /**
     * Instantiates a new DOMNodeListByTagName.
     * @param first first node.
     * @param tagName tag name
     */
    protected DOMNodeListByTagNameImpl(Node first, String tagName)
    {
        this.first = first;
        this.tagName = tagName;
    }

    /**
     * @see org.w3c.dom.NodeList#item
     */
    public org.w3c.dom.Node item(int index)
    {
        currIndex = 0;
        maxIndex = index;
        preTraverse(first);

        if (currIndex > maxIndex && currNode != null)
        {
            return currNode.getAdapter();
        }

        return null;
    }

    /**
     * @see org.w3c.dom.NodeList#getLength
     */
    public int getLength()
    {
        currIndex = 0;
        maxIndex = Integer.MAX_VALUE;
        preTraverse(first);
        return currIndex;
    }

    /**
     * Traverse the node list.
     * @param node Node
     */
    protected void preTraverse(Node node)
    {
        if (node == null)
        {
            return;
        }

        if (node.type == Node.START_TAG || node.type == Node.START_END_TAG)
        {
            if (currIndex <= maxIndex && (tagName.equals("*") || tagName.equals(node.element)))
            {
                currIndex += 1;
                currNode = node;
            }
        }
        if (currIndex > maxIndex)
        {
            return;
        }

        node = node.content;
        while (node != null)
        {
            preTraverse(node);
            node = node.next;
        }
    }

}