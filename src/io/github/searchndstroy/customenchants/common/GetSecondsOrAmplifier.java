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

public class GetSecondsOrAmplifier {
	
	public static int getSeconds(String type, int defaultseconds,int secondstoworkwith, int tierlevel) {
		
		int seconds;
		
		if (defaultseconds < 0)
			return 0;
		
		if (type.equalsIgnoreCase("multiply")) {
			
			seconds = tierlevel * tierlevel * secondstoworkwith * 20;
			return seconds;
		} else if (type.equalsIgnoreCase("add")) {
			
			seconds = tierlevel * secondstoworkwith * 20;
			return seconds;
		} else if (type.equalsIgnoreCase("none")) {
			
			seconds = defaultseconds * 20;
			return seconds;
		} else {
			
			seconds = 0;
			return seconds;
		}
	}

	public static int getAmplifier(String type, int defaultamplifier, int amplifiertoworkwith, int tierlevel) {
		
		int amplifier;
		
		if (defaultamplifier < 0)
			return 0;
		
		if (type.equalsIgnoreCase("multiply")) {
			
			amplifier = tierlevel * tierlevel * amplifiertoworkwith - 1;
			return amplifier;
		} else if (type.equalsIgnoreCase("add")) {
			
			amplifier = tierlevel * amplifiertoworkwith - 1;
			return amplifier;
		} else if (type.equalsIgnoreCase("none")) {
			
			amplifier = defaultamplifier - 1;
			return amplifier;
		} else {
			
			amplifier = 0;
			return amplifier;
		}
	}

}
