/*
 * $Id: SpaceProperty.java,v 1.5 2003/03/05 21:48:01 jeremias Exp $
 * ============================================================================
 *                    The Apache Software License, Version 1.1
 * ============================================================================
 *
 * Copyright (C) 1999-2003 The Apache Software Foundation. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modifica-
 * tion, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. The end-user documentation included with the redistribution, if any, must
 *    include the following acknowledgment: "This product includes software
 *    developed by the Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself, if
 *    and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "FOP" and "Apache Software Foundation" must not be used to
 *    endorse or promote products derived from this software without prior
 *    written permission. For written permission, please contact
 *    apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache", nor may
 *    "Apache" appear in their name, without prior written permission of the
 *    Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * APACHE SOFTWARE FOUNDATION OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLU-
 * DING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ============================================================================
 *
 * This software consists of voluntary contributions made by many individuals
 * on behalf of the Apache Software Foundation and was originally created by
 * James Tauber <jtauber@jtauber.com>. For more information on the Apache
 * Software Foundation, please see <http://www.apache.org/>.
 */
package org.apache.fop.fo;

import org.apache.fop.apps.FOPException;
import org.apache.fop.datatypes.LengthRange;
import org.apache.fop.datatypes.Space;

/**
 * Base class used for handling properties of the fo:space-before and
 * fo:space-after variety. It is extended by org.apache.fop.fo.properties.GenericSpace,
 * which is extended by many other properties.
 */
public class SpaceProperty extends Property {

    /**
     * Inner class used to create new instances of SpaceProperty
     */
    public static class Maker extends CompoundPropertyMaker {

        /**
         * @param name name of the property whose Maker is to be created
         */
        protected Maker(int propId) {
            super(propId);
        }

        /**
         * Create a new empty instance of SpaceProperty.
         * @return the new instance. 
         */
        public Property makeNewProperty() {
            return new SpaceProperty(new Space());
        }

        /**
         * @see CompoundPropertyMaker#convertProperty
         */
        public Property convertProperty(Property p,
                                        PropertyList propertyList,
                                        FObj fo) throws FOPException {
            if (p instanceof SpaceProperty) {
                return p;
            }
            return super.convertProperty(p, propertyList, fo);
        }
    }

    private Space space;

    /**
     * @param space the Space object (datatype) to be stored here
     */
    public SpaceProperty(Space space) {
        this.space = space;
    }

    /**
     * @return the Space (datatype) object contained here
     */
    public Space getSpace() {
        return this.space;
    }

    /**
     * Space extends LengthRange.
     * @return the Space (datatype) object contained here
     */
    public LengthRange getLengthRange() {
        return this.space;
    }

    /**
     * @return the Space (datatype) object contained here
     */
    public Object getObject() {
        return this.space;
    }

}
