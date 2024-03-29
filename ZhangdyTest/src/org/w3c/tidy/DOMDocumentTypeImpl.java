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
 * DOMDocumentTypeImpl.
 * @author Dave Raggett <a href="mailto:dsr@w3.org">dsr@w3.org </a>
 * @author Andy Quick <a href="mailto:ac.quick@sympatico.ca">ac.quick@sympatico.ca </a> (translation to Java)
 * @author Fabrizio Giustina
 * @version $Revision: 738 $ ($Author: fgiust $)
 */
public class DOMDocumentTypeImpl extends DOMNodeImpl implements org.w3c.dom.DocumentType
{

    /**
     * Instantiates a new DOM document type.
     * @param adaptee Tidy Node
     */
    protected DOMDocumentTypeImpl(Node adaptee)
    {
        super(adaptee);
    }

    /**
     * @see org.w3c.dom.Node#getNodeType
     */
    public short getNodeType()
    {
        return org.w3c.dom.Node.DOCUMENT_TYPE_NODE;
    }

    /**
     * @see org.w3c.dom.Node#getNodeName
     */
    public String getNodeName()
    {
        return getName();
    }

    /**
     * @see org.w3c.dom.DocumentType#getName
     */
    public String getName()
    {
        String value = null;
        if (adaptee.type == Node.DOCTYPE_TAG)
        {

            if (adaptee.textarray != null && adaptee.start < adaptee.end)
            {
                value = TidyUtils.getString(adaptee.textarray, adaptee.start, adaptee.end - adaptee.start);
            }
        }
        return value;
    }

    /**
     * @todo DOM level 2 getEntities() Not implemented. Returns null.
     * @see org.w3c.dom.DocumentType#getEntities()
     */
    public org.w3c.dom.NamedNodeMap getEntities()
    {
        return null;
    }

    /**
     * @todo DOM level 2 getNotations() Not implemented. Returns null.
     * @see org.w3c.dom.DocumentType#getNotations()
     */
    public org.w3c.dom.NamedNodeMap getNotations()
    {
        return null;
    }

    /**
     * @todo DOM level 2 getPublicId() Not implemented. Returns null.
     * @see org.w3c.dom.DocumentType#getPublicId()
     */
    public String getPublicId()
    {
        return null;
    }

    /**
     * @todo DOM level 2 getSystemId() Not implemented. Returns null.
     * @see org.w3c.dom.DocumentType#getSystemId()
     */
    public String getSystemId()
    {
        return null;
    }

    /**
     * @todo DOM level 2 getInternalSubset() Not implemented. Returns null.
     * @see org.w3c.dom.DocumentType#getInternalSubset()
     */
    public String getInternalSubset()
    {
        return null;
    }

}