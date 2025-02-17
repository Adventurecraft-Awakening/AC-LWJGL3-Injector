package org.lwjgl.opengl;

import org.lwjgl.system.NativeType;

public final class ARBVertexBufferObject extends ARBBufferObject {
    /**
     * Accepted by the {@code target} parameters of BindBufferARB, BufferDataARB, BufferSubDataARB, MapBufferARB, UnmapBufferARB, GetBufferSubDataARB,
     * GetBufferParameterivARB, and GetBufferPointervARB.
     */
    public static final int
        GL_ARRAY_BUFFER_ARB         = 0x8892,
        GL_ELEMENT_ARRAY_BUFFER_ARB = 0x8893;

    /** Accepted by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and GetDoublev. */
    public static final int
        GL_ARRAY_BUFFER_BINDING_ARB                 = 0x8894,
        GL_ELEMENT_ARRAY_BUFFER_BINDING_ARB         = 0x8895,
        GL_VERTEX_ARRAY_BUFFER_BINDING_ARB          = 0x8896,
        GL_NORMAL_ARRAY_BUFFER_BINDING_ARB          = 0x8897,
        GL_COLOR_ARRAY_BUFFER_BINDING_ARB           = 0x8898,
        GL_INDEX_ARRAY_BUFFER_BINDING_ARB           = 0x8899,
        GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING_ARB   = 0x889A,
        GL_EDGE_FLAG_ARRAY_BUFFER_BINDING_ARB       = 0x889B,
        GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING_ARB = 0x889C,
        GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING_ARB  = 0x889D,
        GL_WEIGHT_ARRAY_BUFFER_BINDING_ARB          = 0x889E;

    /** Accepted by the {@code pname} parameter of GetVertexAttribivARB. */
    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING_ARB = 0x889F;

    public static native void glBindBufferARB(@NativeType("GLenum") int target, @NativeType("GLuint") int buffer);

    public static native void nglDeleteBuffersARB(int n, long buffers);

    public static native void nglGenBuffersARB(int n, long buffers);

    @NativeType("GLboolean")
    public static native boolean glIsBufferARB(@NativeType("GLuint") int buffer);

    public static native void nglBufferDataARB(int target, long size, long data, int usage);

    public static native void nglBufferSubDataARB(int target, long offset, long size, long data);

    public static native void nglGetBufferSubDataARB(int target, long offset, long size, long data);

    public static native long nglMapBufferARB(int target, int access);

    @NativeType("GLboolean")
    public static native boolean glUnmapBufferARB(@NativeType("GLenum") int target);

    public static native void nglGetBufferParameterivARB(int target, int pname, long params);

    public static native void nglGetBufferPointervARB(int target, int pname, long params);

}
