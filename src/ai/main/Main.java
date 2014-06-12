package ai.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

		_D_2_V_2_3__GetParis_from_Pairs();
//		_D_2_V_2_0__CrossOver();
//		_D_2_v_1__Test_Sets();
		
//		_D_1_v_1_Initial_Operations();
		
		String message = "done";
		Methods.message(
					message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());
		
	}

	private static void
	_D_2_V_2_3__GetParis_from_Pairs() {
		// TODO Auto-generated method stub
		////////////////////////////////

		// Get: initial generation

		////////////////////////////////
		Generation gen_0 = new Generation.Builder()
					.setGenId(0)
					.setMembers(Ops.gen_Initial_Generation(CONS.Admin.INITIAL_GENE_NUM))
					.setNum_of_members(CONS.Admin.INITIAL_GENE_NUM)
					.build();
		
		gen_0.setAvgAdapt(Ops.get_Generation_Adaptability(gen_0.getMembers()));
		
		String message = String.format("gen_0.getAvgAdapt() => %f", gen_0.getAvgAdapt());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		message = null;

		
		
		////////////////////////////////

		// get: pairs

		////////////////////////////////
		
		Pair[] pairs_0 = Ops.get_Pairs_V_2_0(gen_0.getMembers(), CONS.Admin.NUM_OF_PAIRS);
		
		////////////////////////////////

		// get: new generation

		////////////////////////////////
		Generation gen_1 = new Generation.Builder()
					.setGenId(1)
					.build();

		List<Gene> genes_1 = new ArrayList<Gene>();
		
		for (Pair pair_fore : pairs_0) {
			
			Pair pair_off = Ops.get_NewGenes_from_Pair(pair_fore);
			
			genes_1.add(pair_off.getA());
			genes_1.add(pair_off.getB());
			
		}

		gen_1.setMembers(genes_1);
		gen_1.setNum_of_members(genes_1.size());
		gen_1.setAvgAdapt(Ops.get_Generation_Adaptability(gen_1.getMembers()));
		
		message = String.format("gen_1.getAvgAdapt() => %f", gen_1.getAvgAdapt());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		message = null;

		
	}//_D_2_V_2_3__GetParis_from_Pairs

	private static void _D_2_V_2_0__CrossOver() {
		// TODO Auto-generated method stub
		////////////////////////////////

		// Generation: first

		////////////////////////////////
//		Gene[] genes_0 = new Gene[CONS.Admin.INITIAL_NUM];
//		Gene[] genes_0 = Ops.gen_Initial_Generation(CONS.Admin.INITIAL_GENE_NUM);
		List<Gene> genes_0 = Ops.gen_Initial_Generation(CONS.Admin.INITIAL_GENE_NUM);

		////////////////////////////////

		// Gen: generation

		////////////////////////////////
		Generation gen_0 = new Generation.Builder()
						.setGenId(0)
						.setMembers(genes_0)
						.setNum_of_members(CONS.Admin.INITIAL_GENE_NUM)
						.build();
		
		gen_0.setAvgAdapt(Ops.get_Generation_Adaptability(gen_0.getMembers()));
		
		String message = String.format(
						"generation adaptability => %f", 
						gen_0.getAvgAdapt());
//		Ops.get_Generation_Adaptability(genes_0));
		
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		message = null;

		
		
		////////////////////////////////

		// Get: paris from the genes

		////////////////////////////////
		Pair[] pairs = Ops.get_Pairs_V_2_0(genes_0, CONS.Admin.NUM_OF_PAIRS);
		
		////////////////////////////////

		// pair: source

		////////////////////////////////
		Pair pair = pairs[0];
		
		//log
		message = String.format("<pairs[0] : Before>");
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		message = null;

		Ops.show_Pair(pair);

		////////////////////////////////

		// new pairs

		////////////////////////////////
		Pair pair_new = Ops.get_NewGenes_from_Pair(pair);
		
		//log
		message = String.format("<pairs[0] : Before>");
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		message = null;

		Ops.show_Pair(pair_new);
		
	}//private static void _D_2_V_2_0__CrossOver()

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
