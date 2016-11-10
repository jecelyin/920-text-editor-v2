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
public class GcbasicLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "'";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "TRUE";
        PROPERTY2.NAME = "ignoreWhitespace";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "^(SUB\\s.*|FUNCTION\\s.*|MACRO\\s.*|\\s+DO\\s+.*|\\s+DO$|DO\\s+.*|DO$|\\s*FOR\\s.*|FOR\\s.*|REPEAT\\s.*|CASE\\s.*|\\s+IF\\s+.*\\s+THEN$|IF\\s+.*\\s+THEN$|\\s+#ifdef\\s+.*$|#ifdef\\s+.*$)";
        PROPERTY3.NAME = "indentNextLines";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "^(\\s+END\\s+SUB.*|END\\s+SUB.*|\\s+END\\s+FUNCTION.*|END\\s+FUNCTION.*|\\s+END\\s+MACRO.*|END\\s+MACRO.*|\\s+LOOP.*|LOOP.*|\\s+NEXT.*|NEXT.*|\\s+END\\s+IF.*|END\\s+IF.*|\\s+#endif.*|#endif.*|\\s+#endif|#endif)";
        PROPERTY4.NAME = "unindentThisLine";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "^(\\s+END\\s+SUB|END\\s+SUB|\\s+END\\s+SUB\\s+|END\\s+SUB\\s+|\\s+END\\s+FUNCTION|END\\s+FUNCTION|\\s+END\\s+FUNCTION\\s+|END\\s+FUNCTION\\s+|\\s+END\\s+MACRO|END\\s+MACRO|\\s+END\\s+MACRO\\s+|END\\s+MACRO\\s+|\\s+LOOP|LOOP|\\s+LOOP\\s+|LOOP\\s+|\\s+NEXT|NEXT|\\s+NEXT\\s+|NEXT\\s+|\\s+END\\s+IF|END\\s+IF|\\s+END\\s+IF\\s+|END\\s+IF\\s+|\\s+#endif|#endif|\\s+#endif\\s+|#endif\\s+)";
        PROPERTY5.NAME = "unindentNextLines";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.ESCAPE = "\\";
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

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "'";
        EOL_SPAN1.TYPE = "COMMENT4";
        EOL_SPAN EOL_SPAN2 = new EOL_SPAN();
        EOL_SPAN2.text = "rem";
        EOL_SPAN2.TYPE = "COMMENT4";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "*";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "/";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "+";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "-";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "+=";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "-=";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "&";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "|";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "!";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "=";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "<>";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = ">";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "<";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ">=";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "<=";
        SEQ15.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("OPERATOR", new String[]{"and", "or", "not", "xor", });
        KEYWORDS1.add("LITERAL2", new String[]{"us", "10us", "ms", "10ms", "s", "sec", "m", "h", "bit", "byte", "word", "float", "ChipMHz", "ChipName", "ChipFamily", "OSC", "Var", "NoVar", "Bit", "NoBit", "AllOf", "OneOf", });
        KEYWORDS1.add("KEYWORD1", new String[]{"if", "then", "end", "goto", "gosub", "return", "for", "to", "step", "next", "do", "while", "until", "loop", "repeat", "select", "case", "call", "every", "exit", "end", "function", "sub", "macro", "let", "dim", "as", "rotate", "left", "right", "simple", "set", "rem", "InitSer", "SerSend", "SerReceive", "SerPrint", "ReadAD", "ADFormat", "ADOff", "SPIMode", "SPITransfer", "EPRead", "EPWrite", "ProgramWrite", "ProgramRead", "ProgramErase", "PWMOn", "PWMOff", "HPWM", "USDistance", "Tone", "PRINT", "LOCATE", "PUT", "CLS", "LCDInt", "LCDHex", "LCDWord", "DisplayValue", "DisplayChar", "KeypadRaw", "KeypadData", "LEN", "MID$", "InitTimer0", "InitTimer1", "InitTimer2", "ClearTimer", "StartTimer", "StopTimer", "WAIT", "SLEEP", "DIR", "PORT", "PULSEOUT", "POT", "PWMOut", "PEEK", "POKE", "Random", "Swap", "Swap4", "Table", "ReadTable", });
        KEYWORDS1.add("KEYWORD2", new String[]{"PORTA", "PORTB", "PORTC", "PORTD", "PORTE", "PORTF", "PORTG", "PORTH", "PORTI", "PORTJ", "Prog", "EEPROM", "RAM", "I/O", "ADC", "MaxMHz", "IntOsc", "Pins", "Family", "ConfigWords", "PSP", "MaxAddress", "ADCReady", "CCP1", "CCP2", "Comp1Change", "Comp2Change", "EEPROMReady", "ExtInt0", "LPWU", "OscillatorFail", "PORTBChange", "SSP1Collision", "SSP1Ready", "Timer0Overflow", "Timer1Overflow", "Timer2Overflow", "UsartRX1Ready", "UsartTX1Ready", "INDF", "TMR0", "PCL", "STATUS", "FSR", "PCLATH", "INTCON", "PIR1", "PIR2", "TMR1L", "TMR1H", "T1CON", "TMR2", "T2CON", "SSPBUF", "SSPCON", "CCPR1L", "CCPR1H", "CCP1CON", "RCSTA", "TXREG", "RCREG", "CCPR2L", "CCPR2H", "CCP2CON", "ADRESH", "ADCON0", "OPTION_REG", "TRISA", "TRISB", "TRISC", "TRISD", "TRISE", "PIE1", "PIE2", "PCON", "OSCCON", "OSCTUNE", "SSPCON2", "PR2", "SSPADD", "SSPMSK", "MSK", "SSPSTAT", "WPUB", "IOCB", "VRCON", "TXSTA", "SPBRG", "SPBRGH", "PWM1CON", "ECCPAS", "PSTRCON", "ADRESL", "ADCON1", "WDTCON", "CM1CON0", "CM2CON0", "CM2CON1", "EEDATA", "EEDAT", "EEADR", "EEDATH", "EEADRH", "SRCON", "BAUDCTL", "ANSEL", "ANSELH", "EECON1", "EECON2", "IRP", "RP1", "RP0", "NOT_TO", "NOT_PD", "Z", "DC", "C", "GIE", "PEIE", "T0IE", "TMR0IE", "INTE", "RBIE", "T0IF", "TMR0IF", "INTF", "RBIF", "ADIF", "RCIF", "TXIF", "SSPIF", "CCP1IF", "TMR2IF", "TMR1IF", "OSFIF", "C2IF", "C1IF", "EEIF", "BCLIF", "ULPWUIF", "CCP2IF", "T1GIV", "TMR1GE", "T1CKPS1", "T1CKPS0", "T1OSCEN", "NOT_T1SYNC", "T1INSYNC", "T1SYNC", "TMR1CS", "TMR1ON", "TOUTPS3", "TOUTPS2", "TOUTPS1", "TOUTPS0", "TMR2ON", "T2CKPS1", "T2CKPS0", "WCOL", "SSPOV", "SSPEN", "CKP", "SSPM3", "SSPM2", "SSPM1", "SSPM0", "P1M1", "P1M0", "DC1B1", "CCP1X", "DC1B0", "CCP1Y", "CCP1M3", "CCP1M2", "CCP1M1", "CCP1M0", "SPEN", "RX9", "RC9", "NOT_RC8", "RC8_9", "SREN", "CREN", "ADDEN", "FERR", "OERR", "RX9D", "RCD8", "CCP2X", "DC2B1", "CCP2Y", "DC2B0", "CCP2M3", "CCP2M2", "CCP2M1", "CCP2M0", "ADCS1", "ADCS0", "CHS3", "CHS2", "CHS1", "CHS0", "GO", "NOT_DONE", "GO_DONE", "ADON", "NOT_RBPU", "INTEDG", "T0CS", "T0SE", "PSA", "PS2", "PS1", "PS0", "ADIE", "RCIE", "TXIE", "SSPIE", "CCP1IE", "TMR2IE", "TMR1IE", "OSFIE", "C2IE", "C1IE", "EEIE", "BCLIE", "ULPWUIE", "CCP2IE", "ULPWUE", "SBOREN", "NOT_POR", "NOT_BO", "NOT_BOR", "IRCF2", "IRCF1", "IRCF0", "OSTS", "HTS", "LTS", "SCS", "TUN4", "TUN3", "TUN2", "TUN1", "TUN0", "GCEN", "ACKSTAT", "ACKDT", "ACKEN", "RCEN", "PEN", "RSEN", "SEN", "SMP", "CKE", "D", "I2C_DATA", "NOT_A", "NOT_ADDRESS", "D_A", "DATA_ADDRESS", "P", "I2C_STOP", "S", "I2C_START", "R", "I2C_READ", "NOT_W", "NOT_WRITE", "R_W", "READ_WRITE", "UA", "BF", "WPUB7", "WPUB6", "WPUB5", "WPUB4", "WPUB3", "WPUB2", "WPUB1", "WPUB0", "IOCB7", "IOCB6", "IOCB5", "IOCB4", "IOCB3", "IOCB2", "IOCB1", "IOCB0", "VREN", "VROE", "VRR", "VRSS", "VR3", "VR2", "VR1", "VR0", "CSRC", "TX9", "NOT_TX8", "TX8_9", "TXEN", "SYNC", "SENDB", "BRGH", "TRMT", "TX9D", "TXD8", "BRG7", "BRG6", "BRG5", "BRG4", "BRG3", "BRG2", "BRG1", "BRG0", "BRG15", "BRG14", "BRG13", "BRG12", "BRG11", "BRG10", "BRG9", "BRG8", "PRSEN", "PDC6", "PDC5", "PDC4", "PDC3", "PDC2", "PDC1", "PDC0", "ECCPASE", "ECCPAS2", "ECCPAS1", "ECCPAS0", "PSSAC1", "PSSAC0", "PSSBD1", "PSSBD0", "STRSYNC", "STRD", "STRC", "STRB", "STRA", "ADFM", "VCFG1", "VCFG0", "WDTPS3", "WDTPS2", "WDTPS1", "WDTPS0", "SWDTEN", "C1ON", "C1OUT", "C1OE", "C1POL", "C1R", "C1CH1", "C1CH0", "C2ON", "C2OUT", "C2OE", "C2POL", "C2R", "C2CH1", "C2CH0", "MC1OUT", "MC2OUT", "C1RSEL", "C2RSEL", "T1GSS", "C2SYNC", "SR0", "SR1", "C1SEN", "C2REN", "PULSS", "PULSR", "FVREN", "ABDOVF", "RCIDL", "SCKP", "BRG16", "WUE", "ABDEN", "ANS0", "ANS1", "ANS2", "ANS3", "ANS4", "ANS5", "ANS6", "ANS7", "ANS8", "ANS9", "ANS10", "ANS11", "ANS12", "ANS13", "EEPGD", "WRERR", "WREN", "WR", "RD", "RA0", "RA1", "RA2", "RA3", "RA4", "RA5", "RA6", "RA7", "RB0", "RB1", "RB2", "RB3", "RB4", "RB5", "RB6", "RB7", "RC0", "RC1", "RC2", "RC3", "RC4", "RC5", "RC6", "RC7", "RD0", "RD1", "RD2", "RD3", "RD4", "RD5", "RD6", "RD7", "RE0", "RE1", "RE2", "RE3", "RE4", "RE5", "RE6", "RE7", "RF0", "RF1", "RF2", "RF3", "RF4", "RF5", "RF6", "RF7", "RG0", "RG1", "RG2", "RG3", "RG4", "RG5", "RG6", "RG7", "RH0", "RH1", "RH2", "RH3", "RH4", "RH5", "RH6", "RH7", "RI0", "RI1", "RI2", "RI3", "RI4", "RI5", "RI6", "RI7", "RJ0", "RJ1", "RJ2", "RJ3", "RJ4", "RJ5", "RJ6", "RJ7", "AN0", "AN1", "AN2", "AN3", "AN4", "AN5", "AN6", "AN7", "AN8", "AN9", "AN0", "AN11", "AN12", "AN13", "AN14", "AN15", "AN16", "AN17", "AN18", "AN19", "MCLR", "C1INP", "C2INP", "T1G", "T1CKI", "T0CKI", "C1OUT", "C2OUT", "OSC1", "OSC2", "U1TX", "U1RX", "CCP1", "CCP2", "ECCPA", "ECCPB", "ECCPC", "ECCPD", "Vss", "Vdd", "Vss", "Vdd", "DEBUG", "LVP", "FCMEN", "IESO", "BOR", "CPD", "CP", "MCLRE", "PWRTE", "WDT", "OSC", "WRT", "BORV", "DEBUG_ON", "DEBUG_OFF", "LVP_ON", "LVP_OFF", "FCMEN_ON", "FCMEN_OFF", "IESO_ON", "IESO_OFF", "BOR_ON", "BOR_NSLEEP", "BOR_SBODEN", "BOR_OFF", "CPD_ON", "CPD_OFF", "CP_ON", "CP_OFF", "MCLRE_ON", "MCLRE_OFF", "PWRTE_ON", "PWRTE_OFF", "WDT_ON", "WDT_OFF", "LP_OSC", "XT_OSC", "HS_OSC", "EC_OSC", "INTRC_OSC_NOCLKOUT", "INTRC_OSC_CLKOUT", "EXTRC_OSC_NOCLKOUT", "EXTRC_OSC_CLKOUT", "INTOSCIO", "INTOSC", "EXTRCIO", "EXTRC", "WRT_OFF", "WRT_256", "WRT_1FOURTH", "WRT_HALF", "BOR21V", "BOR40V", });
        KEYWORDS1.add("KEYWORD3", new String[]{"#include", "#define", "#chip", "#osc", "#config", "#IFDEF", "#ENDIF", "#SCRIPT", "#ENDSCRIPT", "#int", "#startup", "#RAM", "#mem", "IN", "OUT", "false", "true", "on", "off", });
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "b'";
        END END2 = new END();
        END2.text = "'";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, EOL_SPAN2, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, };

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
