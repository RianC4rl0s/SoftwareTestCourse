package test1.main;

public class Rotate {
    public static String rotate(final String str, final int shift) {
        //Caso null
        if (str == null) {

            return null;

        }



        final int strLen = str.length();

        //Caso valores sejam 0
        if (shift == 0 || strLen == 0 || shift % strLen == 0) {

            return str;

        }



        final StringBuilder builder = new StringBuilder(strLen);

        final int offset = (shift % strLen);

        if (offset > 0) {
            builder.append(str.substring(strLen - offset));
            builder.append(str.substring(0, strLen - offset));
        } else {
            builder.append(str.substring(-offset));
            builder.append(str.substring(0, strLen + offset +1));
        }
        return builder.toString();

    }
}
