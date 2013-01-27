/*******************************************************************************
 * Copyright 2012 One Platform Foundation
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package org.onepf.appdf.parser.util;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil {

	private XmlUtil() { 
	}
	
	public static List<Node> extractChildElements(Node parent){
		List<Node> result = new ArrayList<Node>();
		NodeList childNodes = parent.getChildNodes();
		for ( int i = 0 ; i < childNodes.getLength() ; i++ ){
			Node child = childNodes.item(i);
			if ( child.getNodeType() == Node.ELEMENT_NODE){
				result.add(child);
			}
		}
		return result;
	}
	
	

	
	public static String getOptionalAttributeValue(NamedNodeMap attrs,String name) {
	
	    Node namedItem = attrs.getNamedItem(name);
        if (namedItem == null) {
            return "";
        }else{
            return namedItem.getTextContent();
        }
	}

    public static String tagNameToFieldName(String tagName) {
        int minusIndex = tagName.indexOf('-');
        while ( minusIndex != -1){
            char nextChar = tagName.charAt(minusIndex + 1);
            char upper = Character.toUpperCase(nextChar);
            StringBuilder sb = new StringBuilder(tagName);
            sb.replace(minusIndex + 1, minusIndex + 2, new String(new char[]{upper}));
            sb.replace(minusIndex, minusIndex + 1, "");
            tagName = sb.toString();
            minusIndex = tagName.indexOf('-');
        }
        return tagName;
    }
}
