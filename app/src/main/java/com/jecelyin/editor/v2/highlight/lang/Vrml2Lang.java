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
public class Vrml2Lang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#";
        PROPERTY1.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.IGNORE_CASE = "TRUE";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "javascript::MAIN";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"false", });
        KEYWORDS1.add("KEYWORD1", new String[]{"appearance", "children", "proxy", "addChildren", "removeChildren", "collideTime", "geometry", "material", "texture", "textureTransform", "ambientIntensity", "diffuseColor", "emissiveColor", "shininess", "specularColor", "transparency", "size", "bottomRadius", "height", "side", "bottom", "radius", "top", "bboxCenter", "bboxSize", "string", "length", "maxExtent", "fontStyle", "family", "style", "spacing", "justify", "horizontal", "leftToRight", "topToBottom", "language", "translation", "position", "rotation", "scale", "scaleOrientation", "center", "key", "keyValue", "set_fraction", "value_changed", "enabled", "isActive", "isOver", "touchTime", "hitPoint_changed", "hitNormal_changed", "hitTexcoord_changed", "orientation_changed", "position_changed", "autoOffset", "offset", "maxPosition", "minPosition", "translation_changed", "trackPoint_changed", "rotation_changeds", "diskAngle", "maxAngle", "minAngle", "choice", "whichChoice", "axisOfRotation", "point", "coord", "color", "coordIndex", "colorIndex", "colorPerVertex", "set_coordIndex", "set_colorIndex", "texCoord", "texCoordIndex", "normalIndex", "normalPerVertex", "ccw", "convex", "solid", "creaseAngle", "set_texCoordIndex", "set_normalIndex", "xDimension", "xSpacing", "zDimension", "zSpacing", "crossSection", "spine", "beginCap", "endCap", "set_spine", "set_crossSection", "set_scale", "set_orientation", "url", "repeatS", "repeatT", "image", "loop", "speed", "startTime", "stopTime", "duration_changed", "vector", "on", "location", "intensity", "attenuation", "direction", "beamWidth", "cutOffAngle", "skyColor", "skyAngle", "groundColor", "groundAngle", "backUrl", "bottomurl", "fronturl", "leftUrl", "rightUrl", "topUrl", "set_bind", "bind_changed", "visibilityRange", "fogType", "duration", "pitch", "priority", "spatialize", "maxFront", "maxBack", "minFront", "minBack", "level", "range", "fieldOfView", "description", "jump", "isBound", "bindTime", "type", "avatarSize", "headLight", "visibilityLimit", "enterTime", "exitTime", "collide", "parameter", "title", "info", "mustEvaluate", "directOutput", "cycleInterval", "cycleTime", });
        KEYWORDS1.add("INVALID", new String[]{"goto", });
        KEYWORDS1.add("KEYWORD2", new String[]{"META", "Shape", "Appearance", "Material", "Box", "Cone", "Cylinder", "Sphere", "Group", "Text", "FontStyle", "Transform", "TimeSensor", "PositionInterpolator", "OrientationInterpolator", "TouchSensor", "PlaneSensor", "SphereSensor", "CylinderSensor", "ColorInterpolater", "ScalarInterpolator", "Switch", "Transform", "Billboard", "Inline", "Coordinate", "CoordinateInterpolator", "PointSet", "IndexedLineSet", "IndexedFaceSet", "ElevationGrid", "Extrusion", "Color", "PointSet", "ImageTexture", "PixelTexture", "MovieTexture", "TextureCoordinate", "TextureTransform", "Normal", "NormalInterpolator", "PointLight", "DirectionalLight", "SpotLight", "Background", "Fog", "AudioClip", "Sound", "LOD", "Viewpoint", "NavigationInfo", "VisibilitySensor", "ProximitySensor", "Collision", "Anchor", "WorldInfo", "Script", });
        KEYWORDS1.add("FUNCTION", new String[]{"assert", });
        KEYWORDS1.add("KEYWORD3", new String[]{"DEF", "FALSE", "NULL", "ROUTE", "PROTO", "EXTERNPROTO", "IS", "TO", "TRUE", "USE", "eventIn", "eventOut", "exposedField", "field", });
        KEYWORDS1.add("KEYWORD4", new String[]{"SFBool", "SFColor", "MFColor", "SFFloat", "MFFloat", "SFImage", "SFInt32", "MFInt32", "SFNode", "MFnode", "SFRotation", "MFRotation", "SFString", "MFString", "SFTime", "SFVec2f", "MFVec2f", "SFVec3f", "MFVec3f", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
