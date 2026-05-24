package org.dsa.practice.strings;

import java.util.HashMap;

public class CountVowels {
    static void main() {
        String testString = "How are you ";

        char[] charArray = testString.toCharArray();

        HashMap<Character, Integer> countOfOwels = new HashMap<Character, Integer>();

      for(char c : charArray) {
          System.out.printf("%c \n",c);

          if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
              if(countOfOwels.get(c)!=null){
                  countOfOwels.compute(c, (k, count) -> count + 1);
              }else{
                  countOfOwels.put(c, 1);
              }

          }
      }

        System.out.println(countOfOwels);

    }
}
