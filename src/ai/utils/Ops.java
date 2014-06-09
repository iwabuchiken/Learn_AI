package ai.utils;

import java.util.Random;

import ai.classes.Gene;

public class Ops {

	public static Gene[]
	gen_Initial_Generation(int initialNum) {
		// TODO Auto-generated method stub
		Gene[] genes_0 = new Gene[initialNum];
		
		////////////////////////////////

		// Initialize

		////////////////////////////////
		Random rn = new Random();
		
		for (int i = 0; i < genes_0.length; i++) {
			
			genes_0[i] = new Gene();
			
			int[] bits = new int[CONS.Admin.NUM_OF_BITS];
			
			for (int j = 0; j < genes_0[i].getNum_of_bits(); j++) {
				
//				int[] bits = new int[]{1,0,0,1,1,1};
				
				bits[j] = rn.nextInt(2);
				
//				genes_0[i].setBits(bits);
				
			}
			
			genes_0[i].setBits(bits);
			
		}
		
//		String message = "genes_0.length = " + genes_0.length;
//		Methods.message(message,
//				Thread.currentThread().getStackTrace()[1].getFileName(), Thread
//						.currentThread().getStackTrace()[1].getLineNumber());
//		
//		message = "gen_0[0] = " + genes_0[0];
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//				.getLineNumber());
		
		for (int i = 0; i < genes_0.length; i++) {
			
			genes_0[i].setGen(0);
			
		}
		
		return genes_0;
	}

	
}
