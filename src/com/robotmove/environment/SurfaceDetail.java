/**
 * 
 */
package com.robotmove.environment;

/**
 * Surface details, and related methods.
 * @author niranjan
 */
public class SurfaceDetail {
	
	private int[][] surface= null;
	
	public SurfaceDetail(int length, int width){
		
		if(length < 0 || width < 0){
			throw new IllegalArgumentException("Invalid Surface dimensions");
		}
		
		surface = new int[length][width];
	}
	
	/**
	 * Check if position is available on the surface
	 */
	public boolean isValidPosition(int xPosition, int yPosition){
		
		try{
			@SuppressWarnings("unused")
			int position = surface[xPosition][yPosition];
		}catch(ArrayIndexOutOfBoundsException arrayException){
			return false;
		}
		
		return true;
	}
}
