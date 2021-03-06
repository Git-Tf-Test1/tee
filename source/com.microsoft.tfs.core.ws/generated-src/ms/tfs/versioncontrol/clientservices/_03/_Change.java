// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See License.txt in the repository root.

 /*
 * This file was automatically generated by com.microsoft.tfs.core.ws.generator.Generator
 * from the /complexType.vm template.
 */
package ms.tfs.versioncontrol.clientservices._03;

import com.microsoft.tfs.core.ws.runtime.*;
import com.microsoft.tfs.core.ws.runtime.serialization.*;
import com.microsoft.tfs.core.ws.runtime.types.*;
import com.microsoft.tfs.core.ws.runtime.util.*;
import com.microsoft.tfs.core.ws.runtime.xml.*;

import ms.tfs.versioncontrol.clientservices._03._Change;
import ms.tfs.versioncontrol.clientservices._03._ChangeType;
import ms.tfs.versioncontrol.clientservices._03._Item;
import ms.tfs.versioncontrol.clientservices._03._ItemType;
import ms.tfs.versioncontrol.clientservices._03._MergeSource;
import ms.tfs.versioncontrol.clientservices._03._PropertyValue;

import java.lang.Object;
import java.lang.String;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * Automatically generated complex type class.
 */
public class _Change
    implements ElementSerializable, ElementDeserializable
{
    // Attributes
    protected _ChangeType type;
    protected int typeEx;

    // Elements
    protected _Item item;
    protected _MergeSource[] mergeSources;

    public _Change()
    {
        super();
    }

    public _Change(
        final _ChangeType type,
        final int typeEx,
        final _Item item,
        final _MergeSource[] mergeSources)
    {
        // TODO : Call super() instead of setting all fields directly?
        setType(type);
        setTypeEx(typeEx);
        setItem(item);
        setMergeSources(mergeSources);
    }

    public _ChangeType getType()
    {
        return this.type;
    }

    public void setType(final _ChangeType value)
    {
        if (value == null)
        {
            throw new IllegalArgumentException("'type' is a required attribute, its value cannot be null");
        }

        this.type = value;
    }

    public int getTypeEx()
    {
        return this.typeEx;
    }

    public void setTypeEx(final int value)
    {
        this.typeEx = value;
    }

    public _Item getItem()
    {
        return this.item;
    }

    public void setItem(_Item value)
    {
        this.item = value;
    }

    public _MergeSource[] getMergeSources()
    {
        return this.mergeSources;
    }

    public void setMergeSources(_MergeSource[] value)
    {
        this.mergeSources = value;
    }

    public void writeAsElement(
        final XMLStreamWriter writer,
        final String name)
        throws XMLStreamException
    {
        writer.writeStartElement(name);

        // Attributes
        this.type.writeAsAttribute(
            writer,
            "type");
        XMLStreamWriterHelper.writeAttribute(
            writer,
            "typeEx",
            this.typeEx);

        // Elements
        if (this.item != null)
        {
            this.item.writeAsElement(
                writer,
                "Item");
        }

        if (this.mergeSources != null)
        {
            /*
             * The element type is an array.
             */
            writer.writeStartElement("MergeSources");

            for (int iterator0 = 0; iterator0 < this.mergeSources.length; iterator0++)
            {
                this.mergeSources[iterator0].writeAsElement(
                    writer,
                    "MergeSource");
            }

            writer.writeEndElement();
        }

        writer.writeEndElement();
    }

    public void readFromElement(final XMLStreamReader reader)
        throws XMLStreamException
    {
        String localName;

        // Attributes
        final int attributeCount = reader.getAttributeCount();
        String attributeValue;

        for (int i = 0; i < attributeCount; i++)
        {
            localName = reader.getAttributeLocalName(i);
            attributeValue = reader.getAttributeValue(i);

            if (localName.equalsIgnoreCase("type"))
            {
                this.type = new _ChangeType();
                this.type.readFromAttribute(attributeValue);
            }
            else if (localName.equalsIgnoreCase("typeEx"))
            {
                this.typeEx = XMLConvert.toInt(attributeValue);
            }

            // Ignore unknown attributes.
        }

        // Elements
        int event;

        do
        {
            event = reader.next();

            if (event == XMLStreamConstants.START_ELEMENT)
            {
                localName = reader.getLocalName();

                if (localName.equalsIgnoreCase("Item"))
                {
                    this.item = new _Item();
                    this.item.readFromElement(reader);
                }
                else if (localName.equalsIgnoreCase("MergeSources"))
                {
                    /*
                     * The element type is an array.
                     */
                    int event0;
                    final List list0 = new ArrayList();

                    do
                    {
                        event0 = reader.nextTag();

                        if (event0 == XMLStreamConstants.START_ELEMENT)
                        {
                            _MergeSource complexObject0 = new _MergeSource();
                            complexObject0.readFromElement(reader);
                            list0.add(complexObject0);
                        }
                    }
                    while (event0 != XMLStreamConstants.END_ELEMENT);

                    this.mergeSources = (_MergeSource[]) list0.toArray(new _MergeSource[list0.size()]);
                }
                else
                {
                    // Read the unknown child element until its end
                    XMLStreamReaderHelper.readUntilElementEnd(reader);
                }
            }
        }
        while (event != XMLStreamConstants.END_ELEMENT);
    }
}
