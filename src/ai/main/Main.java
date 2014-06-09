package ai.main;

import ai.classes.Gene;
import ai.classes.Generation;
import ai.utils.CONS;
import ai.utils.Methods;
import ai.utils.Ops;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_D_1_v_1_Initial_Operations();
		
		String message = "done";
		Methods.message(
					message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
		
		Methods.write_Log(message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
		
		
	}

	private static void _D_1_v_1_Initial_Operations() {
		// TODO Auto-generated method stub
		
		////////////////////////////////

		// vars

		////////////////////////////////
//		int initial_Num = 10;
		int initial_Num = CONS.Admin.INITIAL_NUM;
		
		String message = "initial_Num = " + initial_Num;
		Methods.message(message,
				Thread.currentThread().getStackTrace()[1].getFileName(), Thread
						.currentThread().getStackTrace()[1].getLineNumber());
		
		
//		Gene[] genes_0 = new Gene[CONS.Admin.INITIAL_NUM];
		Gene[] genes_0 = Ops.gen_Initial_Generation(initial_Num);
		
		Generation gen_0 = new Generation();
		
		gen_0.setMembers(genes_0);
		
		gen_0.setNum_of_members(initial_Num);
		
		message = "gen_0[0] = " + genes_0[0];
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());
		
		
		////////////////////////////////

		// report

		////////////////////////////////
		for (int i = 0; i < genes_0.length; i++) {
			
			message = String.format(
						"genes[%d]: Gen = %d", 
						i, genes_0[i].getGen());
			
			Methods.message(message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			StringBuilder sb = new StringBuilder();
			
			int[] bits = genes_0[i].getBits();
			
			int j;
			
			for (j = 0; j < genes_0[i].getNum_of_bits() - 1; j++) {
				
				sb.append(bits[j]);
				sb.append(",");
				
			}
			
			sb.append(bits[j]);
			
			message = "bits = " + sb.toString();
			Methods.message(message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			
		}
		
	}

}
