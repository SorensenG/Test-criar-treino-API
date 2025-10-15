package com.gymhub.utilshelpers;

import java.text.Normalizer;

public final class NormalizerUtil {
    private NormalizerUtil() {}



    public static String norm(String s) {
        if (s == null) return "";
        String n = Normalizer.normalize(s.trim().toLowerCase(), Normalizer.Form.NFD);
        return n.replaceAll("\\p{M}+", ""); // remove acentos
    }
}
