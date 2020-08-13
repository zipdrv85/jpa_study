package com.inzent.selenium.util;


import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Clob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 

public class StringUtil {

    /**
     * Capitalize first letter.
     * 
     * @param original
     *            the original
     * @return the string
     */
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0)
            return original;

        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    /**
     * Alpha num only.
     * 
     * @param s
     *            the s
     * @return the string
     */
    public static String alphaNumOnly(String s) {
        int i = s.length();
        StringBuffer stringbuffer = new StringBuffer(i);
        for (int j = 0; j < i; j++) {
            char c = s.charAt(j);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '_' || c == '-')
                stringbuffer.append(c);
        }

        return stringbuffer.toString();

    }

    /**
     * Checks if is alpha num only with sp...
     * 
     * @param s
     *            the s
     * @return true, if is alpha num only with sp
     */
    public static boolean isAlphaNumOnlyWithSp(String s) {
        int i = s.length();
        for (int j = 0; j < i; j++) {
            char c = s.charAt(j);
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9') && c != '_' && c != '-')
                return false;
        }

        return true;
    }

    /**
     * Checks if is alpha num only.
     * 
     * @param s
     *            the s
     * @return true, if is alpha num only
     */
    public static boolean isAlphaNumOnly(String s) {
        int i = s.length();
        for (int j = 0; j < i; j++) {
            char c = s.charAt(j);
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9'))
                return false;
        }

        return true;
    }

    /**
     * Checks if is alpha only.
     * 
     * @param s
     *            the s
     * @return true, if is alpha only
     */
    public static boolean isAlphaOnly(String s) {
        int i = s.length();
        for (int j = 0; j < i; j++) {
            char c = s.charAt(j);
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
                return false;
        }

        return true;

    }

    /**
     * Checks if is alpha.
     * 
     * @param ch
     *            the ch
     * @return true, if is alpha
     */
    public static boolean isAlpha(char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
            return true;
        else
            return false;
    }

    /**
     * Checks if is num only.
     * 
     * @param s
     *            the s
     * @return true, if is num only
     */
    public static boolean isNumOnly(String s) {
        int i = s.length();
        for (int j = 0; j < i; j++) {
            char ch = s.charAt(j);
            if (ch < '0' || ch > '9')
                return false;
        }

        return true;
    }

    /**
     * Checks if is numeric.
     * 
     * @param ch
     *            the ch
     * @return true, if is numeric
     */
    public static boolean isNumeric(char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        else
            return false;
    }

    /**
     * Checks if is date only.
     * 
     * @param s
     *            the s
     * @return true, if is num only
     */
    public static boolean isDate(String yy, String mm, String dd) {
        String yymmdd = yy + mm + dd;
        SimpleDateFormat dtfmt = new SimpleDateFormat("yyyymmdd");
        try {
            Date dt = dtfmt.parse(yymmdd);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if is date only.
     * 
     * @param s
     *            the s
     * @return true, if is num only
     */
    public static boolean isDate(String yymmdd) {
        SimpleDateFormat dtfmt = new SimpleDateFormat("yyyymmdd");
        try {
            Date dt = dtfmt.parse(yymmdd);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Normalize whitespace.
     * 
     * @param s
     *            the s
     * @return the string
     */
    public static String normalizeWhitespace(String s) {
        StringBuffer stringbuffer = new StringBuffer();
        int i = s.length();
        boolean flag = false;
        for (int j = 0; j < i; j++) {
            char c = s.charAt(j);
            switch (c) {
                case 9: // '\t'
                case 10: // '\n'
                case 13: // '\r'
                case 32: // ' '
                    if (!flag) {
                        stringbuffer.append(' ');
                        flag = true;
                    }
                    break;

                default:
                    stringbuffer.append(c);
                    flag = false;
                    break;
            }
        }

        return stringbuffer.toString();
    }

    /**
     * Num occurrences.
     * 
     * @param s
     *            the s
     * @param c
     *            the c
     * @return the int
     */
    public static int numOccurrences(String s, char c) {
        int i = 0;
        int j = 0;
        int l;
        for (int k = s.length(); j < k; j = l + 1) {
            l = s.indexOf(c, j);
            if (l < 0)
                break;
            i++;
        }

        return i;
    }

    /**
     * Removes the characters.
     * 
     * @param s
     *            the s
     * @param s1
     *            the s1
     * @return the string
     */
    public static String removeCharacters(String s, String s1) {
        int i = s.length();
        StringBuffer stringbuffer = new StringBuffer(i);
        for (int j = 0; j < i; j++) {
            char c = s.charAt(j);
            if (s1.indexOf(c) == -1)
                stringbuffer.append(c);
        }

        return stringbuffer.toString();
    }

    /**
     * Removes the white space.
     * 
     * @param s
     *            the s
     * @return the string
     */
    public static String removeWhiteSpace(String s) {
        int i = s.length();
        StringBuffer stringbuffer = new StringBuffer(i);
        for (int j = 0; j < i; j++) {
            char c = s.charAt(j);
            if (!Character.isWhitespace(c))
                stringbuffer.append(c);
        }

        return stringbuffer.toString();
    }

    /**
     * Replace.
     * 
     * @param target
     *            the target
     * @param arguments
     *            the arguments
     * @param replacements
     *            the replacements
     * @return the string
     */
    public static String replace(String target, String[] arguments, String[] replacements) {
        if (target == null || arguments == null || replacements == null)
            return target;

        for (int index = 0; index < arguments.length; index++) {
            target = replace(target, arguments[index], replacements[index]);
        }

        return target;
    }

    /**
     * Replace.
     * 
     * @param target
     *            the target
     * @param argument
     *            the argument
     * @param replacement
     *            the replacement
     * @return the string
     */
    public static String replace(String target, String argument, String replacement) {
        if (target == null || argument == null || replacement == null)
            return target;

        int i = target.indexOf(argument);

        if (i == -1)
            return target;

        StringBuffer targetSB = new StringBuffer(target);
        while (i != -1) {
            targetSB.delete(i, i + argument.length());
            targetSB.insert(i, replacement);
            // check for any more
            i = targetSB.toString().indexOf(argument, i + replacement.length());
        }

        return targetSB.toString();
    }

    /**
     * Replace.
     * 
     * @param oTarget
     *            the o target
     * @param argument
     *            the argument
     * @param replacement
     *            the replacement
     * @return the string
     */
    public static String replace(Object oTarget, String argument, String replacement) {
        String target = "";
        if (oTarget instanceof String) {
            target = nchk(oTarget);
        } else {
            return "";
        }
        if (target == null || argument == null || replacement == null)
            return target;

        int i = target.indexOf(argument);

        if (i == -1)
            return target;

        StringBuffer targetSB = new StringBuffer(target);
        while (i != -1) {
            targetSB.delete(i, i + argument.length());
            targetSB.insert(i, replacement);
            // check for any more
            i = targetSB.toString().indexOf(argument, i + replacement.length());
        }

        return targetSB.toString();
    }

    /**
     * Split string at character.
     * 
     * @param s
     *            the s
     * @param c
     *            the c
     * @return the string[]
     */
    public static String[] splitStringAtCharacter(String s, char c) {
        String as[] = new String[numOccurrences(s, c) + 1];
        splitStringAtCharacter(s, c, as, 0);
        return as;
    }

    /**
     * Split string at character.
     * 
     * @param s
     *            the s
     * @param c
     *            the c
     * @param as
     *            the as
     * @param i
     *            the i
     * @return the int
     */
    protected static int splitStringAtCharacter(String s, char c, String as[], int i) {
        int j = 0;
        int k = i;
        int l = 0;
        int j1;
        for (int i1 = s.length(); l <= i1 && k < as.length; l = j1 + 1) {
            j1 = s.indexOf(c, l);
            if (j1 < 0)
                j1 = i1;
            as[k] = s.substring(l, j1);
            j++;
            k++;
        }

        return j;
    }

    /**
     * String2 boolean.
     * 
     * @param data
     *            the data
     * @return true, if successful
     */
    public static boolean string2Boolean(String data) {
        if (data == null)
            return false;
        if (data.equalsIgnoreCase("true"))
            return true;
        if (data.equalsIgnoreCase("yes"))
            return true;
        if (data.equalsIgnoreCase("ok"))
            return true;
        if (data.equalsIgnoreCase("okay"))
            return true;
        if (data.equalsIgnoreCase("on"))
            return true;
        if (data.equalsIgnoreCase("1"))
            return true;
        if (data.equalsIgnoreCase("y"))
            return true;

        return false;
    }

    /**
     * String2 int.
     * 
     * @param data
     *            the data
     * @return the int
     */
    public static int string2Int(String data) {
        try {
            return Integer.parseInt(data);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    /**
     * String2 array list.
     * 
     * @param strValue
     *            the str value
     * @return the list
     */
    public static List<String> string2ArrayList(String strValue) {

        List<String> arrResult = new ArrayList<String>();
        strValue = StringUtil.nchk(strValue);

        if (strValue == null || strValue.equals("")) {
            return arrResult;
        }

        String[] arrBuff = strValue.split(",");

        if (arrBuff == null) {
            return arrResult;
        }

        for (int i = 0; i < arrBuff.length; i++) {
            arrResult.add(arrBuff[i].trim());
        }

        return arrResult;
    }

    /**
     * String2 hashtable.
     * 
     * @param data
     *            the data
     * @return the map
     */
    public static Map<String, String> string2Hashtable(String data) {
        Map<String, String> commands = new HashMap<String, String>();

        data = normalizeWhitespace(data);
        String[] data_arr = splitStringAtCharacter(data, ' ');

        for (int i = 0; i < data_arr.length; i++) {
            int equ_pos = data_arr[i].indexOf('=');
            String key = data_arr[i].substring(0, equ_pos);
            String value = data_arr[i].substring(equ_pos + 1);

            commands.put(key, value);
        }

        return commands;
    }

    /**
     * Hashtable2 string.
     * 
     * @param commands
     *            the commands
     * @return the string
     */
    public static String hashtable2String(Map<String, Object> commands) {
        Iterator<String> it = commands.keySet().iterator();
        StringBuffer retcode = new StringBuffer();

        while (it.hasNext()) {
            String key = "";
            String value = "";

            try {
                key = (String)it.next();
                value = (String)commands.get(key);

                retcode.append(key);
                retcode.append("=");
                retcode.append(value);
                retcode.append(" ");
            } catch (ClassCastException ex) {
            }
        }

        return retcode.toString().trim();
    }

    /**
     * To lower case.
     * 
     * @param s
     *            the s
     * @return the string
     */
    public static String toLowerCase(String s) {
        int i;
        int j;
        char c;
        label0: {
            i = s.length();
            for (j = 0; j < i; j++) {
                char c1 = s.charAt(j);
                c = Character.toLowerCase(c1);
                if (c1 != c)
                    break label0;
            }

            return s;
        }
        char ac[] = new char[i];
        int k;
        for (k = 0; k < j; k++)
            ac[k] = s.charAt(k);

        ac[k++] = c;
        for (; k < i; k++)
            ac[k] = Character.toLowerCase(s.charAt(k));

        String s1 = new String(ac, 0, i);
        return s1;
    }

    /**
     * To upper case.
     * 
     * @param s
     *            the s
     * @return the string
     */
    public static String toUpperCase(String s) {
        int i;
        int j;
        char c;
        label0: {
            i = s.length();
            for (j = 0; j < i; j++) {
                char c1 = s.charAt(j);
                c = Character.toUpperCase(c1);
                if (c1 != c)
                    break label0;
            }

            return s;
        }
        char ac[] = new char[i];
        int k;
        for (k = 0; k < j; k++)
            ac[k] = s.charAt(k);

        ac[k++] = c;
        for (; k < i; k++)
            ac[k] = Character.toUpperCase(s.charAt(k));

        return new String(ac, 0, i);
    }

    /**
     * Tokenizer.
     * 
     * @param s
     *            the s
     * @param s1
     *            the s1
     * @return the vector
     */
    public static Vector tokenizer(String s, String s1) {
        if (s == null)
            return null;
        Vector vector = null;
        for (StringTokenizer stringtokenizer = new StringTokenizer(s, s1); stringtokenizer.hasMoreTokens(); vector.addElement(stringtokenizer
                .nextToken().trim()))
            if (vector == null)
                vector = new Vector();

        return vector;
    }

    /**
     * Escape html string.
     * 
     * @param s
     *            the s
     * @return the string
     */
    public static String escapeHtmlString(String s) {
        String s1 = s;
        if (s1 == null)
            return null;
        if (s1.indexOf(38, 0) != -1)
            s1 = replace(s1, "&", "&amp;");
        if (s1.indexOf(60, 0) != -1)
            s1 = replace(s1, "<", "&lt;");
        if (s1.indexOf(62, 0) != -1)
            s1 = replace(s1, ">", "&gt;");
        if (s1.indexOf(34, 0) != -1)
            s1 = replace(s1, "\"", "&quot;");
        if (s1.indexOf(13, 0) != -1)
            s1 = replace(s1, "\\n", "<br>");
        return s1;
    }

    /**
     * Re escape html string.
     * 
     * @param s
     *            the s
     * @return the string
     */
    public static String reEscapeHtmlString(String s) {
        String s1 = s;
        if (s1 == null)
            return null;
        String[] arguments = { "&amp;", "&lt;", "&gt;", "&quot;" };
        String[] replacements = { "&", "<", ">", "\"" };
        return replace(s1, arguments, replacements);
    }

    /**
     * Fill.
     * 
     * @param c
     *            the c
     * @param length
     *            the length
     * @return the string
     */
    public static String fill(char c, int length) {
        if (length <= 0)
            return "";

        char[] ca = new char[length];
        for (int index = 0; index < length; index++) {
            ca[index] = c;
        }

        return new String(ca);
    }

    /**
     * Fill.
     * 
     * @param c
     *            the c
     * @param length
     *            the length
     * @return the string
     */
    public static String fill(long c, int length) {
        if (length <= 0)
            return "";
        String str = c + "";

        int len = str.length();
        int loop = length - len;

        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            buff.append("0");
        }
        buff.append(str);

        return buff.toString();
    }

    /**
     * Pad right.
     * 
     * @param s
     *            the s
     * @param c
     *            the c
     * @param length
     *            the length
     * @return the string
     */
    public static String padRight(String s, char c, int length) {
        return s + fill(c, length - s.length());
    }

    /**
     * Pad left.
     * 
     * @param s
     *            the s
     * @param c
     *            the c
     * @param length
     *            the length
     * @return the string
     */
    public static String padLeft(String s, char c, int length) {
        return fill(c, length - s.length()) + s;
    }

    /**
     * Pad left zero.
     * 
     * @param s
     *            the s
     * @return the string
     */
    public static String padLeftZero(Object s) {
        String str = ((BigDecimal)s).toString();
        if (str.length() < 2) {
            str = "0" + str;
        }
        return str;
    }

    /**
     * Cut left zero.
     * 
     * @param s
     *            the s
     * @return the string
     */
    public static String cutLeftZero(String s) {
        String str = left(s, 1);
        if (str.equals("0")) {
            s = s.substring(1, s.length());
        }
        return s;
    }

    /**
     * To string.
     * 
     * @param args
     *            the args
     * @return the string
     */
    public static String toString(Object[] args) {
        return toString(args, ",");
    }

    /**
     * To string.
     * 
     * @param args
     *            the args
     * @param separator
     *            the separator
     * @return the string
     */
    public static String toString(Object[] args, String separator) {
        if (args == null)
            return null;

        StringBuffer buf = new StringBuffer();

        for (int index = 0; index < args.length; index++) {
            if (index > 0)
                buf.append(separator);

            if (args[index] == null)
                buf.append("");
            else
                buf.append(args[index].toString());
        }

        return buf.toString();
    }

    /**
     * To string.
     * 
     * @param list
     *            the list
     * @param separator
     *            the separator
     * @return the string
     */
    public static String toString(List list, String separator) {
        if (list == null)
            return "";

        StringBuffer buf = new StringBuffer();
        for (int index = 0; index < list.size(); index++) {
            if (index > 0)
                buf.append(separator);
            buf.append(list.get(index).toString());
        }
        return buf.toString();
    }

    /**
     * To string.
     * 
     * @param list
     *            the list
     * @param mapname
     *            the mapname
     * @param separator
     *            the separator
     * @return the string
     */
    public static String toString(List list, String mapname, String separator) {
        StringBuffer buf = new StringBuffer();
        for (int index = 0; index < list.size(); index++) {
            HashMap info = (HashMap)list.get(index);

            if (index > 0)
                buf.append(separator);
            buf.append(info.get(mapname).toString());
        }
        return buf.toString();
    }

    /**
     * To convert.
     * 
     * @param str
     *            the str
     * @param src_enc
     *            the src_enc
     * @param dest_enc
     *            the dest_enc
     * @return the string
     * @throws UnsupportedEncodingException
     *             the unsupported encoding exception
     */
    public static String toConvert(String str, String src_enc, String dest_enc) throws java.io.UnsupportedEncodingException {
        if (str == null)
            return "";
        else
            return new String(str.getBytes(src_enc), dest_enc);
    }

    /**
     * Nvl.
     * 
     * @param str
     *            the str
     * @return the string
     */
    static public String NVL(String str) {
        if (str == null)
            return "";
        else
            return str.trim();
    }

    // 臾몄옄�뿴�씠 null�씤寃쎌슦 replace_str�쓣 Return�븳�떎.
    // �궗�슜 �삁) �뀒�씠釉붿쓽 <td>str</td>�뿉�꽌 str�씠 null�씤 寃쎌슦
    // replate_str�씠 &nbsp;濡� 吏��젙�븳�떎.
    /**
     * Nvl.
     * 
     * @param str
     *            the str
     * @param replace_str
     *            the replace_str
     * @return the string
     */
    static public String NVL(String str, String replace_str) {
        if (str == null || str.length() <= 0)
            return replace_str;
        else
            return str;
    }

    /**
     * Gets the to comma int.
     * 
     * @param stText
     *            the st text
     * @return the to comma int
     */
    public static String getToCommaInt(String stText) {
        if (stText == null || stText.trim().equals(""))
            return "";
        String ch = "#,###,##0";
        java.text.DecimalFormat df = new java.text.DecimalFormat(ch);
        String stResult = df.format(Integer.parseInt(stText));
        return stResult;
    }

    /**
     * Gets the to comma int.
     * 
     * @param nValue
     *            the n value
     * @return the to comma int
     */
    public static String getToCommaInt(int nValue) {
        String stText = null;
        stText = String.valueOf(nValue);

        return getToCommaInt(stText);
    }

    /**
     * Gets the to comma int.
     * 
     * @param nValue
     *            the n value
     * @return the to comma int
     */
    public static String getToCommaInt(long nValue) {
        String stText = null;
        stText = String.valueOf(nValue);

        return getToCommaInt(stText);
    }

    /**
     * Clob to string.
     * 
     * @param clob
     *            the clob
     * @return the string
     */
    public static String clobToString(Clob clob) {
        String clobString = "";
        try {

            if (clob != null) {
                Reader reader = clob.getCharacterStream();

                BufferedReader clobReader = new BufferedReader(reader);

                StringWriter clobWriter = new StringWriter();
                char[] buffer = new char[1024];
                int size = 0;

                while ((size = clobReader.read(buffer, 0, 1024)) != -1)
                    clobWriter.write(buffer, 0, size);

                clobString = clobWriter.toString();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clobString;
    }

    /**
     * Cut string.
     * 
     * @param src
     *            the src
     * @param str_length
     *            the str_length
     * @param att_str
     *            the att_str
     * @return the string
     */
    static public String cutString(String src, int str_length, String att_str) {
        int ret_str_length = 0;

        String ret_str = new String("");

        if (src == null) {
            return ret_str;
        }

        String tempMulLanChar = new String("媛�");
        int lanCharLength = tempMulLanChar.length();

        int multiLanCharIndex = 0;

        for (int i = 0; i < src.length(); i++) {
            ret_str += src.charAt(i);

            if (src.charAt(i) > '~') {
                ret_str_length = ret_str_length + 2 / lanCharLength;
                multiLanCharIndex++;
            } else {
                ret_str_length = ret_str_length + 1;
            }
            if (ret_str_length >= str_length && (multiLanCharIndex % lanCharLength) == 0) {
                ret_str += nchk(att_str);
                break;
            }
        }

        return ret_str;
    }

    /**
     * Nchk.
     * 
     * @param str
     *            the str
     * @return the string
     */

    static public String nchk(String str) {
        if (str == null || str.equals(""))
            return "";
        else
            return str;
    }

    /**
     * Nchk.
     * 
     * @param obj
     *            the obj
     * @return the string
     */

    static public String nchk(Object obj) {
        if (obj == null)
            return "";
        else
            return obj.toString();
    }

    /**
     * Nchk.
     * 
     * @param str
     *            the str
     * @param dstr
     *            the dstr
     * @return the string
     */

    static public String nchk(String str, String dstr) {
        if (str == null || str.equals("")) {
            if (dstr == null || dstr.equals("")) {
                return "";
            } else {
                return dstr;
            }
        } else {
            return str;
        }
    }

    /**
     * Nchk.
     * 
     * @param obj
     *            the obj
     * @param dstr
     *            the dstr
     * @return the string
     */

    static public String nchk(Object obj, String dstr) {
        if (obj == null)
            if (dstr == null)
                return "";
            else
                return dstr;
        else
            return obj.toString();
    }

    /**
     * Right.
     * 
     * @param s
     *            the s
     * @param len
     *            the len
     * @return the string
     */
    public static String right(String s, int len) {
        if (s == null)
            return "";
        int L = s.length();
        if (L <= len)
            return s;
        return s.substring(L - len, L);
    }

    /**
     * Left.
     * 
     * @param s
     *            the s
     * @param len
     *            the len
     * @return the string
     */
    public static String left(String s, int len) {
        if (s == null)
            return "";
        if (s.length() <= len)
            return s;
        return s.substring(0, len);
    }

    /**
     * Cut left.
     * 
     * @param s
     *            the s
     * @param len
     *            the len
     * @param replace_str
     *            the replace_str
     * @return the string
     */
    static public String cutLeft(String s, int len, String replace_str) {
        if (s == null) {
            return "";
        } else if (s.length() <= len) {
            return s;
        } else {
            return s.substring(0, len) + replace_str;
        }
    }

    /**
     * Checks if is alpha hangul num only.
     * 
     * @param s
     *            the s
     * @return true, if is alpha hangul num only
     */
    public static boolean isAlphaHangulNumOnly(String s) {

        Pattern pattern = Pattern.compile("^[a-zA-Z�꽦-�옡0-9]+");
        Matcher match = pattern.matcher(s);

        if (match.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if is hangul only.
     * 
     * @param s
     *            the s
     * @return true, if is hangul only
     */
    public static boolean isHangulOnly(String s) {

        Pattern pattern = Pattern.compile("^[�꽦-�옡]+");
        Matcher match = pattern.matcher(s);

        if (match.find()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Checks if is email.
     * 
     * @param s
     *            the s
     * @return true, if is email
     */
    public static boolean isEmail(String s) {

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher match = pattern.matcher(s);
        return match.matches();
    }

    /**
     * Checks if is accepted alpha.
     * 
     * @param s
     *            the s
     * @return true, if is accepted alpha
     */
    public static boolean isAcceptedAlpha(String s) {

        Pattern pattern = Pattern.compile("[^媛�-�옡\\s]");
        Matcher match = pattern.matcher(s);

        if (match.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if is geo tag.
     * 
     * @param s
     *            the s
     * @return true, if is geo tag
     */
    public static boolean isGeoTag(String s) {

        Pattern pattern = Pattern.compile("^(-?[0-9]+(.[0-9]+)?)$");
        Matcher match = pattern.matcher(s);

        if (match.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if is ip address.
     * 
     * @param s
     *            the s
     * @return true, if is ip address
     */
    public static boolean isIpAddress(String s) {

        Pattern pattern = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher match = pattern.matcher(s);

        if (match.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if is cell phone.
     * 
     * @param s
     *            the s
     * @return true, if is cell phone
     */
    public static boolean isCellPhone(String s) {

        Pattern pattern = Pattern.compile("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$");
        Matcher match = pattern.matcher(s);

        if (match.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if is 010 cell phone.
     * 
     * @param s
     *            the s
     * @return true, if is 010 cell phone
     */
    public static boolean is010CellPhone(String s) {

        Pattern pattern = Pattern.compile("^010(?:\\d{3}|\\d{4})\\d{4}$");
        Matcher match = pattern.matcher(s);

        if (match.find()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if is contain.
     * 
     * @param s1
     *            the s1
     * @param s2
     *            the s2
     * @return true, if is contain
     */
    public static boolean isContain(String s1, String s2) {
        if (s1.indexOf(s2) > -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the string l padding zero.
     * 
     * @param length
     *            the length
     * @param value
     *            the value
     * @return the string l padding zero
     */
    public static String getStringLPaddingZero(int length, String value) {
        StringBuffer buffer = new StringBuffer();
        if (value.length() < length) {
            for (int tempValueLength = value.length(); tempValueLength < length; tempValueLength++) {
                buffer.append("0");
            }
        }
        buffer.append(value);
        // Log.log("info","[SMSKEY:"+buffer+"]");
        return buffer.toString();
    }

    /**
     * Gets the random key.
     * 
     * @return the random key
     */
    public static String getRandomKey() {
        return getRandomKey(6);
    }

    /**
     * Gets the random key.
     * 
     * @param square
     *            the square
     * @return the random key
     */
    public static String getRandomKey(int square) {
        return getStringLPaddingZero(square, String.valueOf(getRandom(square)));
    }

    /**
     * Gets the random.
     * 
     * @param square
     *            the square
     * @return the random
     */
    public static int getRandom(int square) {
        int ran = (int)(Math.random() * (Math.pow(10, square)));
        return ran;
    }

    /**
     * Url encode.
     * 
     * @param str
     *            the str
     * @return the string
     */
    public static String UrlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Url decode.
     * 
     * @param str
     *            the str
     * @return the string
     */
    public static String UrlDecode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Show line text.
     * 
     * @param str
     *            the str
     * @return the string
     */
    public static String showLineText(String str) {
        if (str == null)
            return "";
        return str.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r", "").replaceAll("\n", " ");
    }

    /**
     * Show html.
     * 
     * @param str
     *            the str
     * @return the string
     */
    public static String showHtml(String str) {
        if (str == null)
            return "";
        // return rplc(rplc(rplc(str, "<", "&lt;"), ">", "&gt;"), System.getProperty("line.separator"), "<br />");
        return str.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r", "").replaceAll("\n", "<br />").replaceAll(" ", "&nbsp;");
    }

    /**
     * Show html not replace blank.
     * 
     * @param str
     *            the str
     * @return the string
     */
    public static String showHtmlNotReplaceBlank(String str) {
        if (str == null)
            return "";
        // return rplc(rplc(rplc(str, "<", "&lt;"), ">", "&gt;"), System.getProperty("line.separator"), "<br />");
        return str.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\r", "").replaceAll("\n", "<br />");
    }

    /**
     * Show html with tag.
     * 
     * @param str
     *            the str
     * @return the string
     */
    public static String showHtmlWithTag(String str) {
        if (str == null)
            return "";
        // return rplc(str, System.getProperty("line.separator"), "<br />");
        return str.replaceAll("\r", "").replaceAll("\n", "<br />");
    }

    /**
     * Make phone number.
     * 
     * @param phoneNumber
     *            the phone number
     * @return the string
     */
    public static String makePhoneNumber(String phoneNumber) {
        String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";

        if (!Pattern.matches(regEx, phoneNumber))
            return null;

        return phoneNumber.replaceAll(regEx, "$1-$2-$3");

    }

    /**
     * To camel case.
     * 
     * @param value
     *            the value
     * @return the string
     */
    public static String toCamelCase(String value) {
        if (value == null)
            return null;

        if (value.indexOf('_') < 0)
            return value;

        value = value.toLowerCase();
        StringTokenizer st = new StringTokenizer(value, "_");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; st.hasMoreTokens(); i++) {
            String token = st.nextToken();
            if (i > 0) {
                sb.append(token.substring(0, 1).toUpperCase());
                sb.append(token.substring(1));
            } else {
                sb.append(token);
            }
        }

        return sb.toString();
    }


    public static String lpad(String str, String f_char, int size) {
        if (str.length() >= size)
            return str;
        else
            return getFillChar("", f_char, size - str.length()) + str;
    }

    public static String getFillChar(String str, String f_char, int size) {
        String fillChar = "";

        if (str.length() >= size)
            return str;

        for (int index = 0; index < (size - str.length()); ++index) {
            fillChar += f_char;
        }

        return str + fillChar;
    }

    public static String[] split(String src, String delimeter) {
        if (src == null) {
            return null;
        }

        if (delimeter == null) {
            return new String[] { src };
        }

        int maxparts = (src.length() / delimeter.length()) + 2;
        int[] positions = new int[maxparts];
        int dellen = delimeter.length();

        int i = 0, j = 0, count = 0;

        positions[0] = -dellen;
        while ((i = src.indexOf(delimeter, j)) != -1) {
            count++;
            positions[count] = i;
            j = i + dellen;
        }

        count++;
        positions[count] = src.length();

        String[] result = new String[count];

        for (i = 0; i < count; i++) {
            result[i] = src.substring(positions[i] + dellen, positions[i + 1]);
        }

        return result;
    }
}
