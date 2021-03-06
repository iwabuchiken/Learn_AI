package ai.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import com.panayotis.gnuplot.JavaPlot;

import ai.classes.Gene;
import ai.classes.Generation;
import ai.classes.Pair;
import ai.utils.CONS;
import ai.utils.Methods;
import ai.utils.Ops;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		_D_3_V_1_0__Plot_Data();
//		_D_2_V_2_5__Get_10_Generation();
//		_D_2_V_2_4__GetGeneration_from_Generation();
//		_D_2_V_2_3__GetParis_from_Pairs();
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
	_D_3_V_1_0__Plot_Data() {
		// TODO Auto-generated method stub
		////////////////////////////////

		// vars

		////////////////////////////////
		List<Generation> gens = new ArrayList<Generation>();
		
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

		message = String.format("======= Gen: 1 =============");
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		message = null;

//		gens.add(gen_0);
		
		////////////////////////////////

		// get: pairs

		////////////////////////////////
		List<Pair> pairs_0 = Ops.get_Pairs_V_2_0(gen_0.getMembers(), CONS.Admin.NUM_OF_PAIRS);
//		Pair[] pairs_0 = Ops.get_Pairs_V_2_0(gen_0.getMembers(), CONS.Admin.NUM_OF_PAIRS);
		
		////////////////////////////////

		// get: new generation: 1

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
		
		gens.add(gen_1);
		
		////////////////////////////////

		// add gens: gen 2 to gen 10

		////////////////////////////////
		int numOfGens = 100;
		int startGen = 2;
		
		gens.addAll(Ops.get_Generations(gen_1, numOfGens, startGen));
		
		message = String.format("gens.size() => %d", gens.size());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		message = null;

		////////////////////////////////

		// plot

		////////////////////////////////
		double[][] data = new double[gens.size()][2];
		
		int count = 0;
		int start = 0;
		int limit = start + gens.size();
		
		for (int i = start; i < limit; i++) {
//			for (int i = 361000; i < 36110; i++) {
//			for (int i = 361000; i < buf_R.length; i++) {
			
			data[count][0] = count;
			data[count][1] = gens.get(i).getAvgAdapt();
//			data[count][1] = buf_L[i];
			
			count ++;
			
		}

		JavaPlot p = new JavaPlot();
//		p.addPlot("sin(x)");
//		p.plot();
//			JavaPlot p = new JavaPlot(true);
		
		String title = String.format(
//						"%s (gens = %d, last avgadapt = %f)", 
						"%s (gens = %d, last avgadapt = %.3f)", 
						Thread.currentThread().getStackTrace()[1].getFileName(), 
						gens.size(),
						gens.get(gens.size() - 1).getAvgAdapt());
		
		p.setTitle(
				Thread.currentThread().getStackTrace()[1].getFileName()
				+ "(" + title
				+ ")");
		
		p.addPlot(data);
//		p.addPlot("sin(x)*y");
//		for (int i = 0; i < 4; i++) {
//			
//			p.plot();
//			
//		}
		
		p.plot();

//		////////////////////////////////
//
//		// report
//
//		////////////////////////////////
//		message = "======= Show genes ==========";
//		String label = "["
//				+ Thread.currentThread().getStackTrace()[1].getFileName()
//				+ " : "
//				+ Thread.currentThread().getStackTrace()[1].getMethodName()
//				+ " : "
//				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
//				+ "]";
//		System.out.println(label + " " + message);
//		
//		Ops.show_Generation(gens.get(gens.size() -1));
		
	}//_D_3_V_1_0__Plot_Data
	
	private static void
	_D_2_V_2_5__Get_10_Generation() {
		// TODO Auto-generated method stub
		////////////////////////////////
		
		// vars
		
		////////////////////////////////
		List<Generation> gens = new ArrayList<Generation>();
		
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
		
		message = String.format("======= Gen: 1 =============");
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		message = null;
		
//		gens.add(gen_0);
		
		////////////////////////////////
		
		// get: pairs
		
		////////////////////////////////
		List<Pair> pairs_0 = Ops.get_Pairs_V_2_0(gen_0.getMembers(), CONS.Admin.NUM_OF_PAIRS);
//		Pair[] pairs_0 = Ops.get_Pairs_V_2_0(gen_0.getMembers(), CONS.Admin.NUM_OF_PAIRS);
		
		////////////////////////////////
		
		// get: new generation: 1
		
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
		
//		message = String.format("gen_1.getAvgAdapt() => %f", gen_1.getAvgAdapt());
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//				.getLineNumber());
//
//		message = null;
		
		gens.add(gen_1);
		
		////////////////////////////////
		
		// add gens: gen 2 to gen 10
		
		////////////////////////////////
		int numOfGens = 100;
		int startGen = 2;
		
		gens.addAll(Ops.get_Generations(gen_1, numOfGens, startGen));
		
//		Generation gen_Fore = gen_1;
//		
//		for (int i = startGen; i < startGen + numOfGens; i++) {
//			
//			message = String.format("======= Gen: %d =============", i);
//			Methods.message(message, Thread.currentThread().getStackTrace()[1]
//					.getFileName(), Thread.currentThread().getStackTrace()[1]
//					.getLineNumber());
//
//			message = null;
//
//			Generation gen_Off = Ops.get_Generation_from_Generation(gen_Fore);
//
//			message = String.format(
//							"gen %d: getAvgAdapt() => %f", 
//							i, gen_Off.getAvgAdapt());
//			
//			Methods.message(message, Thread.currentThread().getStackTrace()[1]
//					.getFileName(), Thread.currentThread().getStackTrace()[1]
//					.getLineNumber());
//
//			message = null;
//			
//			gens.add(gen_Off);
//			
//			gen_Fore = gen_Off;
//
//		}
		
		message = String.format("gens.size() => %d", gens.size());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		message = null;
		
		////////////////////////////////
		
		// report
		
		////////////////////////////////
		message = "======= Show genes ==========";
		String label = "["
				+ Thread.currentThread().getStackTrace()[1].getFileName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getMethodName()
				+ " : "
				+ Thread.currentThread().getStackTrace()[1].getLineNumber()
				+ "]";
		System.out.println(label + " " + message);
		
		Ops.show_Generation(gens.get(gens.size() -1));
		
//		Ops.show_Gene(gens.get(gens.size() -1).getMembers().get(0));
//		Ops.show_Gene(gens.get(gens.size() -1).getMembers().get(1));
//		Ops.show_Gene(gens.get(gens.size() -1).getMembers().get(2));
//		Ops.show_Gene(gens.get(gens.size() -1).getMembers().get(3));
		
		////////////////////////////////
		
		// get: new generation: 2
		
		////////////////////////////////
//		message = String.format("======= Gen: 2 =============");
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//				.getLineNumber());
//
//		message = null;
//
//		Generation gen_2 = Ops.get_Generation_from_Generation(gen_1);
//
//		message = String.format("gen_2.getAvgAdapt() => %f", gen_2.getAvgAdapt());
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//				.getLineNumber());
//
//		message = null;
		
//		////////////////////////////////
//		
//		// get: new generation: 3
//		
//		////////////////////////////////
//		message = String.format("======= Gen: 3 =============");
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//						.getLineNumber());
//		
//		message = null;
//		
//		Generation gen_3 = Ops.get_Generation_from_Generation(gen_2);
//		
//		message = String.format("gen_3.getAvgAdapt() => %f", gen_3.getAvgAdapt());
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//						.getLineNumber());
//		
//		message = null;
		
	}//_D_2_V_2_5__Get_10_Generation
	
	private static void
	_D_2_V_2_4__GetGeneration_from_Generation() {
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
		
		message = String.format("======= Gen: 1 =============");
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		message = null;
		
		
		
		////////////////////////////////
		
		// get: pairs
		
		////////////////////////////////
		List<Pair> pairs_0 = Ops.get_Pairs_V_2_0(gen_0.getMembers(), CONS.Admin.NUM_OF_PAIRS);
//		Pair[] pairs_0 = Ops.get_Pairs_V_2_0(gen_0.getMembers(), CONS.Admin.NUM_OF_PAIRS);
		
		////////////////////////////////
		
		// get: new generation: 1
		
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
		
		////////////////////////////////
		
		// get: new generation: 2
		
		////////////////////////////////
		message = String.format("======= Gen: 2 =============");
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		message = null;
		
		Generation gen_2 = Ops.get_Generation_from_Generation(gen_1);
		
		message = String.format("gen_2.getAvgAdapt() => %f", gen_2.getAvgAdapt());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		message = null;
		
		////////////////////////////////
		
		// get: new generation: 3
		
		////////////////////////////////
		message = String.format("======= Gen: 3 =============");
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		message = null;
		
		Generation gen_3 = Ops.get_Generation_from_Generation(gen_2);
		
		message = String.format("gen_3.getAvgAdapt() => %f", gen_3.getAvgAdapt());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		message = null;
		
	}//_D_2_V_2_4__GetGeneration_from_Generation()
	
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
		
		List<Pair> pairs_0 = Ops.get_Pairs_V_2_0(gen_0.getMembers(), CONS.Admin.NUM_OF_PAIRS);
		
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
		List<Pair> pairs = Ops.get_Pairs_V_2_0(genes_0, CONS.Admin.NUM_OF_PAIRS);
		
		////////////////////////////////

		// pair: source

		////////////////////////////////
		Pair pair = pairs.get(0);
//		Pair pair = pairs[0];
		
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
