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
public class PvwaveLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = ";";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "true";
        PROPERTY2.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = ";";
        EOL_SPAN1.TYPE = "COMMENT1";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "(";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ")";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "=";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "+";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "-";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "/";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "*";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "#";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ">";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "<";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "^";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "}";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "{";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ".";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = ",";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "]";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "[";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = ":";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "$";
        SEQ19.TYPE = "LABEL";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "&";
        SEQ20.TYPE = "LABEL";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "@";
        SEQ21.TYPE = "LABEL";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "!";
        SEQ22.TYPE = "LABEL";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"abs", "acos", "add_exec_on_select", "addsysvar", "addvar", "affine", "alog", "alog10", "asarr", "asin", "askeys", "assoc", "atan", "avg", "axis", "bar", "bar2d", "bar3d", "beseli", "beselj", "besely", "bilinear", "bindgen", "blob", "blobcount", "boundary", "build_table", "buildresourcefilename", "bytarr", "byte", "byteorder", "bytscl", "c_edit", "call_unix", "cd", "center_view", "chebyshev", "check_math", "checkfile", "cindgen", "close", "color_convert", "color_edit", "color_palette", "complex", "complexarr", "cone", "congrid", "conj", "contour", "contour2", "contourfill", "conv_from_rect", "conv_to_rect", "convert_coord", "convol", "correlate", "cos", "cosh", "cosines", "cprod", "create_holidays", "create_weekdends", "crossp", "cursor", "curvatures", "curvefit", "cylinder", "day_name", "day_of_week", "day_of_year", "dblarr", "dc_error_msg", "dc_options", "dc_read_24_bit", "dc_read_8_bit", "dc_read_container", "dc_read_dib", "dc_read_fixed", "dc_read_free", "dc_read_tiff", "dc_scan_container", "dc_write_24_bit", "dc_write_8_bit", "dc_write_dib", "dc_write_fixed", "dc_write_free", "dc_write_tiff", "dcindgen", "dcomplex", "dcomplexarr", "declare func", "declare function", "define_key", "defroi", "defsysv", "del_file", "delfunc", "dellog", "delproc", "delstruct", "delvar", "demo", "deriv", "derivn", "determ", "device", "diag", "dicm_tag_info", "digital_filter", "dilate", "dindgen", "dist", "dminit", "doc_lib_unix", "doc_library", "double", "drop_exec_on_select", "dt_add", "dt_addly", "dt_compress", "dt_duration", "dt_print", "dt_subly", "dt_subtract", "dt_to_sec", "dt_to_str", "dt_to_var", "dtegn", "empty", "environment", "eof", "erase", "erode", "errorf", "errplot", "euclidean", "exec_on_select", "execute", "exp", "expand", "expon", "extrema", "factor", "fast_grid2", "fast_grid3", "fast_grid4", "fft", "filepath", "findfile", "findgen", "finite", "fix", "float", "fltarr", "flush", "free_lun", "fstat", "funct", "gamma", "gaussfit", "gaussint", "gcd", "get_kbrd", "get_lun", "getenv", "get_named_color", "getncerr", "getncopts", "getparam", "great_int", "grid", "grid_2d", "grid_3d", "grid_4d", "grid_sphere", "gridn", "group_by", "hak", "hanning", "hdf_test", "hdfgetsds", "help", "hilbert", "hist_equal", "hist_equal_ct", "histn", "histogram", "hls", "hsv", "hsv_to_rgd", "image_check", "image_color_quant", "image_cont", "image_create", "image_display", "image_filetypes", "image_query_file", "image_read", "image_write", "imaginary", "img_true8", "index_and", "index_conv", "index_or", "indgen", "intarr", "interpol", "interpolate", "intrp", "invert", "isaskey", "ishft", "jacobian", "jul_to_dt", "keyword_set", "lcm", "leefilt", "legend", "lindgen", "linknload", "list", "listarr", "load_holidays", "load_option", "load_weekends", "loadct", "loadct_custom", "loadresources", "loadstrings", "lonarr", "long", "lubksb", "ludcmp", "make_array", "map", "map_axes", "map_contour", "map_grid", "map_plots", "map_polyfill", "map_proj", "map_reverse", "map_velovect", "map_version", "map_xyouts", "max", "median", "mesh", "message", "min", "modifyct", "molec", "moment", "month_name", "movie", "mprove", "msword_cgm_setup", "n_elements", "n_params", "n_tags", "nint", "normals", "null_processor", "openr", "openu", "openw", "oplot", "oploterr", "option_is_loaded", "order_by", "padit", "packimage", "packtable", "palette", "param_present", "parsefilename", "pie", "pie_chart", "plot", "plot_field", "plot_histogram", "plot_io", "plot_oi", "plot_oo", "plot_windrose", "ploterr", "plots", "pm", "pmf", "point_lun", "poly", "poly_2d", "poly_area", "poly_c_conv", "poly_count", "poly_dev", "poly_fit", "poly_merge", "poly_norm", "poly_plot", "poly_sphere", "poly_surf", "poly_trans", "polyfill", "polyfillv", "polyfitw", "polyshade", "polywarp", "popd", "prime", "print", "printd", "printf", "profile", "profiles", "prompt", "pseudo", "pushd", "query_table", "randomn", "randomu", "rdpix", "read", "read_airs", "read_xbm", "readf", "readu", "rebin", "reform", "regress", "rename", "render", "render24", "replicate", "replv", "resamp", "reverse", "rgb_to_hsv", "rm", "rmf", "roberts", "rot", "rot_int", "rotate", "same", "scale3d", "sec_to_dt", "select_read_lun", "set_plot", "set_screen", "set_shading", "set_symbol", "set_view3d", "set_viewport", "set_xy", "setdemo", "setenv", "setimagesize", "setlog", "setncopts", "setup_keys", "sgn", "shade_surf", "shade_surf_irr", "shade_volume", "shif", "shift", "show_options", "show3", "sigma", "sin", "sindgen", "sinh", "size", "skipf", "slice", "slice_vol", "small_int", "smooth", "sobel", "socket_accept", "socket_close", "socket_connect", "socket_getport", "socket_init", "socket_read", "socket_write", "sort", "sortn", "spawn", "sphere", "spline", "sqrt", "stdev", "str_to_dt", "strarr", "strcompress", "stretch", "string", "strjoin", "strlen", "strlookup", "strlowcase", "strmatch", "strmessage", "strmid", "strpos", "strput", "strsplit", "strsubst", "strtrim", "structref", "strupcase", "sum", "surface", "surface_fit", "surfr", "svbksb", "svd", "svdfit", "systime", "t3d", "tag_names", "tan", "tanh", "tek_color", "tensor_add", "tensor_div", "tensor_eq", "tensor_exp", "tensor_ge", "tensor_gt", "tensor_le", "tensor_lt", "tensor_max", "tensor_min", "tensor_mod", "tensor_mul", "tensor_ne", "tensor_sub", "threed", "today", "total", "tqli", "transpose", "tred2", "tridag", "tv", "tvcrs", "tvlct", "tvrd", "tvscl", "tvsize", "uniqn", "unique", "unix_listen", "unix_reply", "unload_option", "upvar", "usersym", "usgs_names", "value_length", "var_match", "var_to_dt", "vector_field3", "vel", "velovect", "viewer", "vol_marker", "vol_pad", "vol_red", "vol_trans", "volume", "vtkaddattribute", "vtkaxes", "vtkcamera", "vtkclose", "vtkcolorbar", "vtkcolornames", "vtkcommand", "vtkerase", "vtkformat", "vtkgrid", "vtkhedgehog", "vtkinit", "vtklight", "vtkplots", "vtkpolydata", "vtkpolyformat", "vtkpolyshade", "vtkppmread", "vtkppmwrite", "vtkreadvtk", "vtkrectilineargrid", "vtkrenderwindow", "vtkscatter", "vtkslicevol", "vtkstructuredpoints", "vtkstructuredgrid", "vtksurface", "vtksurfgen", "vtktext", "vtktvrd", "vtkunstructuredgrid", "vtkwdelete", "vtkwindow", "vtkwritevrml", "vtkwset", "wait", "wavedatamanager", "waveserver", "wcopy", "wdelete", "where", "wherein", "window", "wmenu", "wpaste", "wprint", "wread_dib", "wread_meta", "write_xbm", "writeu", "wset", "whow", "wwrite_dib", "wwrite_meta", "xyouts", "zoom", "zroots", });
        KEYWORDS1.add("KEYWORD2", new String[]{"begin", "breakpoint", "case", "common", "compile", "declare", "do", "else", "end", "endcase", "endelse", "endfor", "endif", "endrepeat", "endwhile", "exit", "for", "func", "function", "goto", "help", "if", "info", "journal", "locals", "of", "on_error", "on_error_goto", "on_ioerror", "pro", "quit", "repeat", "restore", "retall", "return", "save", "stop", "then", "while", });
        KEYWORDS1.add("KEYWORD3", new String[]{"and", "not", "or", "xor", "eq", "ne", "gt", "lt", "ge", "le", "mod", "WgAnimateTool", "WgCbarTool", "WgCtTool", "WgIsoSurfTool", "WgMovieTool", "WgSimageTool", "WgSliceTool", "WgSurfaceTool", "WgTextTool", "WoAddButtons", "WoAddMessage", "WoAddStatus", "WoButtonBar", "WoCheckFile", "WoColorButton", "WoColorConvert", "WoColorGrid", "WoColorWheel", "WoConfirmClose", "WoDialogStatus", "WoFontOptionMenu", "WoGenericDialog", "WoLabeledText", "WoMenuBar", "WoMessage", "WoSaveAsPixmap", "WoSetCursor", "WoSetWindowTitle", "WoStatus", "WoVariableOptionMenu", "WtAddCallback", "WtAddHandler", "WtCursor", "WtGet", "WtPointer", "WtSet", "WtTimer", "WwAlert", "WwAlertPopdown", "WwButtonBox", "WwCallback", "WwControlsBox", "WwDialog", "WwDrawing", "WwFileSelection", "WwGenericDialog", "WwGetButton", "WwGetKey", "WwGetPosition", "WwGetValue", "WwHandler", "WwInit", "WwLayout", "WwList", "WwListUtils", "WwLoop", "WwMainWindow", "WwMenuBar", "WwMenuItem", "WwMessage", "WwMultiClickHandler", "WwOptionMenu", "WwPickFile", "WwPopupMenu", "WwPreview", "WwPreviewUtils", "WwRadioBox", "WwResource", "WwSeparator", "WwSetCursor", "WwSetValue", "WwTable", "WwTableUtils", "WwText", "WwTimer", "WwToolBox", "WzAnimate", "WzColorEdit", "WzContour", "WzExport", "WzHistogram", "WzImage", "WzImport", "WzMultiView", "WzPlot", "WzPreview", "WzSurface", "WzTable", "WzVariable", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, };

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
