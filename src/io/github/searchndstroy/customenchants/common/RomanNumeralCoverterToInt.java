/*
 *     This file is part of CustomEnchants.

    CustomEnchants is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    CustomEnchants is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with CustomEnchants.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.searchndstroy.customenchants.common;

public class RomanNumeralCoverterToInt {
public static int romanToDecimal(String number) {
    int decimal = 0;
    int lastNumber = 0;
    String romanNumeral = number.toUpperCase();
         /* operation to be performed on upper cases even if user enters roman values in lower case chars */
    for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
        char convertToDecimal = romanNumeral.charAt(x);

        switch (convertToDecimal) {
            case 'M':
                decimal = processDecimal(1000, lastNumber, decimal);
                lastNumber = 1000;
                break;

            case 'D':
                decimal = processDecimal(500, lastNumber, decimal);
                lastNumber = 500;
                break;

            case 'C':
                decimal = processDecimal(100, lastNumber, decimal);
                lastNumber = 100;
                break;

            case 'L':
                decimal = processDecimal(50, lastNumber, decimal);
                lastNumber = 50;
                break;

            case 'X':
                decimal = processDecimal(10, lastNumber, decimal);
                lastNumber = 10;
                break;

            case 'V':
                decimal = processDecimal(5, lastNumber, decimal);
                lastNumber = 5;
                break;

            case 'I':
                decimal = processDecimal(1, lastNumber, decimal);
                lastNumber = 1;
                break;
        }
    }
    return decimal;
}

public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
    if (lastNumber > decimal) {
        return lastDecimal - decimal;
    } else {
        return lastDecimal + decimal;
    }
}

public static void main(java.lang.String args[]) {
    romanToDecimal("XIV");
}
 }