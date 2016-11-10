/*
 * Copyright (C) 2016 Jecelyin Peng <jecelyin@gmail.com>
 *
 * This file is part of 920 Text Editor.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jecelyin.editor.v2.highlight.lang;

import com.jecelyin.editor.v2.highlight.LangDefine;
import com.jecelyin.editor.v2.highlight.syntax.*;
/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class RibLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "Begin|WorldBegin|FrameBegin|TransformBegin|AttributeBegin|SolidBegin|ObjectBegin|MotionBegin";
        PROPERTY2.NAME = "indentNextLines";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "false";
        PROPERTY3.NAME = "doubleBracketIndent";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "true";
        PROPERTY4.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "([\\p{Digit}]+(e[\\p{Digit}]*)?)";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.AT_WHITESPACE_END = "TRUE";
        EOL_SPAN1.TYPE = "COMMENT1";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "#";
        EOL_SPAN2.TYPE = "COMMENT2";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "-";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "+";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "[";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "]";
        SEQ4.TYPE = "OPERATOR";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.DELEGATE = "LITERALS";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"float", "string", "color", "point", "vector", "normal", "matrix", "void", "varying", "uniform", "output", "extern", });
        KEYWORDS1.add("KEYWORD2", new String[]{"Begin", "End", "Declare", "RtContextHandle", "ContextHandle", "Context", "FrameBegin", "FrameEnd", "WorldBegin", "WorldEnd", "SolidBegin", "SolidEnd", "MotionBegin", "MotionEnd", "ObjectBegin", "ObjectEnd", "Format", "FrameAspectRatio", "ScreenWindow", "CropWindow", "Projection", "Clipping", "ClippingPlane", "DepthOfField", "Shutter", "PixelVariance", "PixelSamples", "PixelFilter", "Exposure", "Imager", "Quantize", "Display", "Hider", "ColorSamples", "RelativeDetail", "Option", "AttributeBegin", "AttributeEnd", "Color", "Opacity", "TextureCoordinates", "RtLightHandle", "LightSource", "AreaLightSource", "Illuminate", "Surface", "Displacement", "Atmosphere", "Interior", "Exterior", "ShadingRate", "ShadingInterpolation", "Matte", "Bound", "Detail", "DetailRange", "GeometricApproximation", "Orientation", "ReverseOrientation", "Sides", "Identity", "Transform", "ConcatTransform", "Perspective", "Translate", "Rotate", "Scale", "Skew", "CoordinateSystem", "CoordSysTransform", "TransformPoints", "TransformBegin", "TransformEnd", "Attribute", });
        KEYWORDS1.add("KEYWORD3", new String[]{"Polygon", "GeneralPolygon", "PointsPolygons", "PointsGeneralPolygons", "Basis", "Patch", "PatchMesh", "NuPatch", "TrimCurve", "SubdivisionMesh", "Sphere", "Cone", "Cylinder", "Hyperboloid", "Paraboloid", "Disk", "Torus", "Points", "Curves", "Blobby", "Procedural", "DelayedReadArchive", "RunProgram", "DynamicLoad", "Geometry", "SolidBegin", "SolidEnd", "RtObjectHandle", "ObjectBegin", "ObjectEnd", "ObjectInstance", });
        KEYWORDS1.add("KEYWORD4", new String[]{"MakeTexture", "MakeLatLongEnvironment", "MakeCubeFaceEnvironment", "MakeShadow", "ErrorHandler", "ArchiveRecord", "ReadArchive", "Deformation", "MakeBump", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "LITERALS";
        RULES1.DEFAULT = "LITERAL1";
        RULES1.ESCAPE = "\\";
        RULES1.IGNORE_CASE = "FALSE";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"P", "Pw", "Pz", "N", "Cs", "Os", "RI_NULL", "RI_INFINITY", "orthographic", "perspective", "bezier", "catmull-rom", "b-spline", "hermite", "power", "catmull-clark", "hole", "crease", "corner", "interpolateboundary", "object", "world", "camera", "screen", "raster", "NDC", "box", "triangle", "sinc", "gaussian", "constant", "smooth", "outside", "inside", "lh", "rh", "bicubic", "bilinear", "periodic", "nonperiodic", "hidden", "null", });
        KEYWORDS1.add("KEYWORD1", new String[]{"float", "string", "color", "point", "vector", "normal", "matrix", "void", "varying", "uniform", "output", "extern", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
