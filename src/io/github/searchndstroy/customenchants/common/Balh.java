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

public class Balh {
	
	public static int getSeconds(String secondstypepath, String defaultsecondspath, String secondstoworkwithpath, int tierlevel) {
		
		int seconds;
		
		String type = CustomEnchants.config.getString(secondstypepath);
		int sdefault = CustomEnchants.config.getInt(defaultsecondspath);
		int secondstoworkwith = CustomEnchants.config.getInt(secondstoworkwithpath);
		
		if (sdefault < 0)
			return 0;
		
		if (type == "multiply") {
			
			int x = 0;
			int y = 0;
			
			while (!(x == tierlevel)) {
				
				x++;
				
				y = x * tierlevel * secondstoworkwith;
				
			}
			
			seconds = y;
			return seconds;
		} else if (type == "add") {
			
			seconds = tierlevel * secondstoworkwith;
			return seconds;
		} else if (type == "none") {
			
			seconds = sdefault;
			return seconds;
		} else {
			
			seconds = 0;
			return seconds;
		}
	}

	public static int getAmplifier(String amplifiertypepath, String defaultamplifierpath, int tierlevel) {
		
		int amplifier = 0;
		return amplifier;
	}

}
