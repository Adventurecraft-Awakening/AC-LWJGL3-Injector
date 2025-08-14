/*
 * Copyright (c) 2002-2008 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

/**
 *
 * Base class for vectors.
 *
 * @author cix_foo <cix_foo@users.sourceforge.net>
 * @version $Revision$
 * $Id$
 */
public sealed abstract class Vector<T extends Vector<T>>
    implements Serializable, ReadableVector
    permits Vector2f, Vector3f, Vector4f
{
    /**
     * Constructor for Vector.
     */
    protected Vector() {
        super();
    }

    protected abstract T create();

    /**
     * @return the length of the vector
     */
    public final float length() {
        return (float) Math.sqrt(lengthSquared());
    }


    /**
     * @return the length squared of the vector
     */
    public abstract float lengthSquared();

    /**
     * Load this vector from a FloatBuffer
     * @param buf The buffer to load it from, at the current position
     * @return this
     */
    public abstract T load(FloatBuffer buf);

    /**
     * Negate this vector
     * @param dest The destination vector or null if a new vector is to be created
     * @return dest
     */
    public abstract T negate(T dest);


    /**
     * Negate this vector
     * @return this
     */
    public T negate() {
        //noinspection unchecked
        return negate((T) this);
    }


    /**
     * Normalise this vector and place the result in another vector.
     * @param dest The destination vector, or null if a new vector is to be created
     * @return dest
     */
    public T normalise(T dest) {
        if (dest == null) {
            dest = create();
        }
        float len = length();
        return divide(len, dest);
    }


    /**
     * Normalise this vector
     * @return this
     */
    public T normalise() {
        //noinspection unchecked
        return normalise((T) this);
    }


    /**
     * Store this vector in a FloatBuffer
     * @param buf The buffer to store it in, at the current position
     * @return this
     */
    public abstract T store(FloatBuffer buf);


    /**
     * Scale this vector
     * @param scale The scale factor
     * @param dest The destination vector
     * @return dest
     */
    public abstract T scale(float scale, T dest);

    public T scale(float scale) {
        //noinspection unchecked
        return scale(scale, (T) this);
    }

    /**
     * Divide this vector
     * @param scale The divisor
     * @param dest The destination vector
     * @return dest
     */
    public abstract T divide(float scale, T dest);

    /**
     * Divide this vector
     * @param scale The divisor
     * @return this
     */
    public T divide(float scale) {
        //noinspection unchecked
        return divide(scale, (T) this);
    }
}