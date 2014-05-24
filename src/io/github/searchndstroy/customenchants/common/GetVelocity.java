
package io.github.searchndstroy.customenchants.common;


public class GetVelocity {
	
	public static int getVelocity(int velocitytoworkwith, String type, int tierlevel) {
		
		int velocity = velocitytoworkwith;
		
		if (type.equalsIgnoreCase("add")) {
			
			velocity = tierlevel * velocitytoworkwith;
			return velocity;
		} else if (type.equalsIgnoreCase("multiply")) {
			
			velocity = tierlevel * tierlevel * velocitytoworkwith;
			return velocity;
		} else if (type.equalsIgnoreCase("none")) {
			
			
			return velocity;
		} else {
			
			
			return velocity;
		}
	}

}
