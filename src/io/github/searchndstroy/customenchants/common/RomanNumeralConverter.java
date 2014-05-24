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

public class RomanNumeralConverter {

	public static String IntegerToRomanNumeral(int level) {
		if (level <= 0)
			return "";
		String s = "";
		while (level >= 1000) {
			s += "M";
			level -= 1000;
		}
		while (level >= 900) {
			s += "CM";
			level -= 900;
		}
		while (level >= 500) {
			s += "D";
			level -= 500;
		}
		while (level >= 400) {
			s += "CD";
			level -= 400;
		}
		while (level >= 100) {
			s += "C";
			level -= 100;
		}
		while (level >= 90) {
			s += "XC";
			level -= 90;
		}
		while (level >= 50) {
			s += "L";
			level -= 50;
		}
		while (level >= 40) {
			s += "XL";
			level -= 40;
		}
		while (level >= 10) {
			s += "X";
			level -= 10;
		}
		while (level >= 9) {
			s += "IX";
			level -= 9;
		}
		while (level >= 5) {
			s += "V";
			level -= 5;
		}
		while (level >= 4) {
			s += "IV";
			level -= 4;
		}
		while (level >= 1) {
			s += "I";
			level -= 1;
		}
		return s;
	}

}
