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
public class PovrayLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "{";
        PROPERTY1.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "}";
        PROPERTY2.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "/*";
        PROPERTY3.NAME = "commentStart";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "*/";
        PROPERTY4.NAME = "commentEnd";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "//";
        PROPERTY5.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT2";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "=";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "!";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ">=";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "<=";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "+";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "-";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "/";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "*";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ">";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "<";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "%";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "&";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "|";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "^";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "~";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "}";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "{";
        SEQ17.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = ":";
        MARK_PREVIOUS1.TYPE = "LABEL";
        MARK_PREVIOUS1.AT_LINE_START = "TRUE";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = "(";
        MARK_PREVIOUS2.TYPE = "FUNCTION";
        MARK_PREVIOUS2.MATCH_TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = ")";
        SEQ18.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL1", new String[]{"blue", "clock", "clock_delta", "clock_on", "false", "final_clock", "final_frame", "frame_number", "gray", "green", "image_height", "image_width", "initial_clock", "initial_frame", "no", "off", "on", "pi", "red", "t", "true", "u", "v", "x", "y", "yes", "z", });
        KEYWORDS1.add("KEYWORD1", new String[]{"background", "bicubic_patch", "blob", "bounded_by", "box", "#break", "bump_map", "camera", "#case", "clipped_by", "cone", "contained_by", "cube", "cubic", "cylinder", "#debug", "#declare", "#default", "density_map", "difference", "disc", "#else", "#end", "#error", "face_indices", "#fclose", "finish", "fog", "#fopen", "function", "global_settings", "height_field", "#if", "#ifdef", "#ifndef", "image_map", "#include", "interior", "interior_texture", "intersection", "ior", "irid", "isosurface", "julia_fractal", "lathe", "light_group", "light_source", "#local", "looks_like", "#macro", "material", "material_map", "media", "merge", "mesh", "mesh2", "normal", "normal_indices", "normal_map", "normal_vectors", "object", "pattern", "photons", "pigment", "pigment_map", "pigment_pattern", "plane", "png", "poly", "polygon", "prism", "radiosity", "rainbow", "#range", "#read", "reflection", "#render", "sky_sphere", "slope", "slope_map", "smooth_triangle", "solid", "sor", "sphere", "sphere_sweep", "spline", "#statistics", "superellipsoid", "#switch", "text", "texture", "texture_list", "texture_map", "torus", "triangle", "#undef", "union", "uv_indices", "uv_mapping", "uv_vectors", "#version", "vertex_vectors", "#warning", "warp", "#while", "#write", });
        KEYWORDS1.add("KEYWORD2", new String[]{"aa_level", "aa_threshold", "absorption", "accuracy", "adaptive", "adc_bailout", "agate", "agate_turb", "all", "all_intersections", "alpha", "altitude", "always_sample", "ambient", "ambient_light", "angle", "aperture", "append", "arc_angle", "area_light", "array", "ascii", "assumed_gamma", "autostop", "average", "b_spline", "bezier_spline", "black_hole", "blur_samples", "boxed", "bozo", "brick", "brick_size", "brightness", "brilliance", "bump_size", "bumps", "caustics", "cells", "charset", "checker", "circular", "collect", "color", "color_map", "colour", "colour_map", "component", "composite", "confidence", "conic_sweep", "conserve_energy", "control0", "control1", "coords", "count", "crackle", "crand", "cubic_spline", "cubic_wave", "cutaway_textures", "cylindrical", "density", "density_file", "dents", "df3", "diffuse", "direction", "dispersion", "dispersion_samples", "dist_exp", "distance", "double_illuminate", "eccentricity", "emission", "error_bound", "evaluate", "expand_thresholds", "exponent", "exterior", "extinction", "facets", "fade_color", "fade_colour", "fade_distance", "fade_power", "falloff", "falloff_angle", "filter", "fisheye", "flatness", "flip", "focal_point", "fog_alt", "fog_offset", "fog_type", "form", "frequency", "fresnel", "gather", "gif", "global_lights", "gradient", "granite", "gray_threshold", "h_angle", "hexagon", "hf_gray_16", "hierarchy", "hollow", "hypercomplex", "iff", "image_pattern", "interpolate", "intervals", "inverse", "irid_wavelength", "jitter", "jpeg", "julia", "lambda", "leopard", "linear_spline", "linear_sweep", "load_file", "location", "look_at", "low_error_factor", "magnet", "major_radius", "mandel", "map_type", "marble", "matrix", "max_extent", "max_gradient", "max_intersections", "max_iteration", "max_sample", "max_trace", "max_trace_level", "media_attenuation", "media_interaction", "metallic", "method", "metric", "min_extent", "minimum_reuse", "mortar", "natural_spline", "nearest_count", "no_bump_scale", "no_image", "no_reflection", "no_shadow", "noise_generator", "number_of_waves", "octaves", "offset", "omega", "omnimax", "once", "onion", "open", "orient", "orientation", "orthographic", "panoramic", "parallel", "parametric", "pass_through", "perspective", "pgm", "phase", "phong", "phong_size", "planar", "point_at", "poly_wave", "pot", "ppm", "precision", "precompute", "pretrace_end", "pretrace_start", "projected_through", "pwr", "quadratic_spline", "quadric", "quartic", "quaternion", "quick_color", "quick_colour", "quilted", "radial", "radius", "ramp_wave", "range_divider", "ratio", "reciprocal", "recursion_limit", "reflection_exponent", "refraction", "repeat", "rgb", "rgbf", "rgbft", "rgbt", "right", "ripples", "rotate", "roughness", "samples", "save_file", "scale", "scallop_wave", "scattering", "select", "shadowless", "sine_wave", "size", "sky", "slice", "smooth", "spacing", "specular", "spherical", "spiral1", "spiral2", "split_union", "spotlight", "spotted", "sqr", "strength", "sturm", "sys", "target", "tga", "thickness", "threshold", "tiff", "tightness", "tile2", "tiles", "tolerance", "toroidal", "transform", "translate", "transmit", "triangle_wave", "ttf", "turb_depth", "turbulence", "type", "u_steps", "ultra_wide_angle", "up", "use_alpha", "use_color", "use_colour", "use_index", "utf8", "v_angle", "v_steps", "variance", "water_level", "waves", "width", "wood", "wrinkles", });
        KEYWORDS1.add("FUNCTION", new String[]{"abs", "acos", "acosh", "asc", "asin", "asinh", "atan", "atan2", "atanh", "ceil", "chr", "concat", "cos", "cosh", "defined", "degrees", "dimension_size", "dimensions", "div", "exp", "file_exists", "floor", "inside", "int", "internal", "ln", "log", "max", "min", "mod", "pow", "radians", "rand", "seed", "sin", "sinh", "sqrt", "str", "strcmp", "strlen", "strlwr", "strupr", "substr", "tan", "tanh", "trace", "val", "vaxis_rotate", "vcross", "vdot", "vlength", "vnormalize", "vrotate", "vstr", "vturbulence", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, };

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
