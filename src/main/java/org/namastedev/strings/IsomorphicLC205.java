package org.namastedev.strings;

import java.util.HashMap;

public class IsomorphicLC205 {
    static void main() {

        String s = "egg";
        String t = "ard";

        HashMap<Character, Character> sToTMap = new HashMap<>();
        HashMap<Character, Character> tToSMap = new HashMap<>();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int i = 0;
        boolean isoMorphic = true;
        while (i < sArray.length) {

            if (sToTMap.containsKey(sArray[i])) {
                if (sToTMap.get(sArray[i]) != tArray[i]){
                    isoMorphic = false;
                }
            } else {
                sToTMap.put(sArray[i], tArray[i]);
            }

            if (tToSMap.containsKey(tArray[i])) {
                if (tToSMap.get(tArray[i]) != sArray[i]) {
                    isoMorphic = false;
                }
            } else {
                tToSMap.put(tArray[i], sArray[i]);
            }

            i++;
        }

        System.out.println(isoMorphic);

    }
}
