package ai.main;

import java.util.HashSet;
import java.util.TreeSet;

import ai.classes.Gene;
import ai.classes.Generation;
import ai.classes.Pair;
import ai.utils.CONS;
import ai.utils.Methods;
import ai.utils.Ops;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_D_2_v_1__Test_Sets();
		
//		_D_1_v_1_Initial_Operations();
		
		String message = "done";
		Methods.message(
					message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
		
		Methods.write_Log(message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
		
//		//test
//		Object[] o = new Object[3];
//		HashSet<Object> h = new HashSet<Object>();
//		
//		TreeSet<Integer> s1 = new TreeSet<Integer>();
//		TreeSet<Integer> s2 = new TreeSet<Integer>();
//		
//		s1.add(6);
//		s2.add(6);
//		s2.add(2);
//		
//		h.add(s1);
//		boolean res = h.contains(s2);
//		
//		message = "res => " + res;
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//				.getLineNumber());
		
		
	}

	private static void _D_2_v_1__Test_Sets() {
		// TODO Auto-generated method stub
		////////////////////////////////

		// vars

		////////////////////////////////
//		int initial_Num = 10;
		int initial_Num = CONS.Admin.INITIAL_NUM;
		
		////////////////////////////////

		// Generate: Genes

		////////////////////////////////
//		Gene[] genes_0 = new Gene[CONS.Admin.INITIAL_NUM];
		Gene[] genes_0 = Ops.gen_Initial_Generation(initial_Num);
		
		Generation gen_0 = new Generation();
		
		gen_0.setMembers(genes_0);
		
		gen_0.setNum_of_members(initial_Num);
		
		//=========================================== 2
		////////////////////////////////

		// get_Pairs(Gene[] genes_0)

		////////////////////////////////
		Pair[] pairs = Ops.get_Pairs_v4(genes_0, CONS.Admin.INITIAL_NUM);
//		Pair pair = Ops.get_Pairs_v3(genes_0);
//		Pair pair = Ops.get_Pairs(genes_0);

				
		
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
		
		////////////////////////////////

		// Generate: Genes

		////////////////////////////////
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

		// Get: adaptability values

		////////////////////////////////
//		for (int i = 0; i < genes_0.length; i++) {
//			
//			genes_0[i].setAdaptability(Ops.get_Adapt_Value(genes_0[i].getBits()));
//			
//		}
		
		////////////////////////////////

		// report

		////////////////////////////////
		_report(genes_0);
		
		//=========================================== 2
		////////////////////////////////

		// Get: int array for random pair picking

		////////////////////////////////
		int[] pickArray = Ops.get_Pick_Array(genes_0);
		
		_report_Pick_Array(pickArray);
		
		////////////////////////////////

		// get_Pairs(Gene[] genes_0)

		////////////////////////////////
		Pair pair = Ops.get_Pairs(genes_0);

		
		
	}

	private static void _report_Pick_Array(int[] pickArray) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		
		int i;
		
		for (i = 0; i < pickArray.length - 1; i++) {
			
			sb.append(pickArray[i]);
			
			sb.append(",");
			
		}
		
		sb.append(pickArray[i]);
		
		String message = "pickArray = " + sb.toString();
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());
		
		
	}

	private static void _report(Gene[] genes_0) {
		// TODO Auto-generated method stub
		for (int i = 0; i < genes_0.length; i++) {
			
			String message = String.format(
						"genes[%d]: Generation = %d (id = %d)", 
						i, genes_0[i].getGen(), genes_0[i].getId());
			
			Methods.message(message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			////////////////////////////////

			// Show: bits

			////////////////////////////////
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
			
			////////////////////////////////

			// Show: adaptability value

			////////////////////////////////
			message = "getAdaptability() = "
							+ genes_0[i].getAdaptability();
			Methods.message(message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
			
			
			
		}//for (int i = 0; i < genes_0.length; i++)
		
	}//private static void _report(Gene[] genes_0)

}
