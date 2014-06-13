package ai.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.math3.util.CombinatoricsUtils;

import ai.classes.Gene;
import ai.classes.Generation;
import ai.classes.Pair;

public class Ops {

	public static List<Gene>
//			public static Gene[]
	gen_Initial_Generation
	(int initialNum) {
		// TODO Auto-generated method stub
//		Gene[] genes_0 = new Gene[initialNum];
		List<Gene> genes_0 = new ArrayList<Gene>();
		
		////////////////////////////////

		// Initialize

		////////////////////////////////
		Random rn = new Random();
		
		
		int len = initialNum;
//		int len = genes_0.length;
		
		for (int i = 0; i < len; i++) {
			
//			/******************************
//				Initialize
//			 ******************************/
//			//REF array of class http://stackoverflow.com/questions/5364278/creating-an-array-of-objects-in-java answered Mar 19 '11 at 19:19
//			genes_0[i] = new Gene();
//
//			/******************************
//				Set: id
//			 ******************************/
//			genes_0[i].setId(i);
////			genes_0[i].setId(i + 1);
			
			/******************************
				Get: bits
			 ******************************/
			int[] bits = new int[CONS.Admin.NUM_OF_BITS];
			
			int len2 = CONS.Admin.NUM_OF_BITS;
//			int len2 = genes_0[i].getNum_of_bits();
			
			for (int j = 0; j < len2; j++) {
				
//				int[] bits = new int[]{1,0,0,1,1,1};
				
				bits[j] = rn.nextInt(2);
				
//				genes_0[i].setBits(bits);
				
			}
			
			// 6 fields
//			genes_0[i] = new Gene.Builder()
			Gene g = new Gene.Builder()
						.setBits(bits)
//						.setAdaptability(Ops.get_Adapt_Value(genes_0[i].getBits()))
						.setAdaptability(Ops.get_Adapt_Value(bits))
						.setGen(0)
						.setPrevId(new int[]{-1, -1})
						.setNum_of_bits(CONS.Admin.NUM_OF_BITS)
						.setId(i)
						.build();
			
			genes_0.add(g);
			
//			genes_0[i].setAdaptability(Ops.get_Adapt_Value(genes_0[i].getBits()));
			
//			genes_0[i].setBits(bits);
//			
//			/******************************
//				Adaptability
//			 ******************************/
//			genes_0[i].setAdaptability(Ops.get_Adapt_Value(genes_0[i].getBits()));
//			
//			/******************************
//				generation number
//			 ******************************/
//			genes_0[i].setGen(0);
//			
//			/******************************
//				message
//			 ******************************/
//			genes_0[i].setPrevId(new int[]{-1, -1});
			
		}
		
		return genes_0;
		
	}//gen_Initial_Generation

	public static int
	get_Adapt_Value(int[] bits)
	{
		int len = bits.length;
		
		int sum = 0;
		
		for (int i = 0; i < len; i++) {
			
			sum += (i + 1) * bits[i];
			
		}
		
		return sum;
		
	}

	public static int[] get_Pick_Array(List<Gene> list) {
		// TODO Auto-generated method stub
		
		////////////////////////////////

		// vars

		////////////////////////////////
		int sum = 0;
		
		for (Gene gene : list) {
			
			sum += gene.getAdaptability();
			
		}
		
//		for (int i = 0; i < list.length; i++) {
//			
//			sum += list[i].getAdaptability();
//			
//		}
		
		String message = "sum = " + sum;
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());
		
		
		int[] pick_Array = new int[sum];
		
		int i = 0;		// counter for for-loop
		int k;		// value for pick array
		int count;	// counter for trans-for-loop
		
		/******************************
			Initialize: pick_Array
		 ******************************/
		for (int j = 0; j < pick_Array.length; j++) {
			
			pick_Array[j] = -1;
			
		}
		
		////////////////////////////////

		// operation

		////////////////////////////////
		k = 0;
		count = 0;
		
		for (int j = 0; j < list.size(); j++) {
			
			for (; i < count + list.get(j).getAdaptability(); i++) {
//				for (int j = 0; j < list.length; j++) {
//					
//					for (; i < count + list[j].getAdaptability(); i++) {
				
				pick_Array[i] = k;
				
			}
			
			k ++;
			count = i;
			
		}
		
		return pick_Array;
	}

	
	public static Pair
	get_Pairs(List<Gene> genes) {
//		public static Pair get_Pairs(Gene[] genes) {
		// TODO Auto-generated method stub
		int[] pickArray = Ops.get_Pick_Array(genes);
		
		Random rn = new Random();
		
		int size = genes.size();
		
		int id_A = pickArray[rn.nextInt(pickArray.length)];
		int id_B = pickArray[rn.nextInt(pickArray.length)];
		
		String message = String.format("id_A = %d / id_B = %d", id_A, id_B);
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());
		
		////////////////////////////////

		// Get: sets

		////////////////////////////////
		TreeSet<Integer> s1 = new TreeSet<Integer>();
		TreeSet<Integer> s2 = new TreeSet<Integer>();
		
		s1.add(6);
		s1.add(2);
		s1.add(6);
		
		s2.add(2);
		s2.add(6);
		
		boolean res = s1.equals(s2);
		
		message = "s1.equals(s2) => " + res;
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());
		
		StringBuilder sb = new StringBuilder();
		
		for (Integer num : s1) {
			
			sb.append(num);
			sb.append(", ");
			
		}
		
		message = String.format("s1 => %s", sb.toString());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		// s2
		sb.delete(0, sb.length());
		
		for (Integer num : s2) {
			
			sb.append(num);
			sb.append(", ");
			
		}
		
		message = String.format("s2 => %s", sb.toString());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		return null;
		
	}//get_Pairs(List<Gene> genes)
	
	/******************************
		if the parameter numOfPairs is bigger than<br>
		the number of genes in the param genes, then<br>
		the number of pairs generated will be modified to<br>
		the maximum number derived from the number of the genes
	 ******************************/
	public static List<Pair>
//			public static Pair[]
	get_Pairs_V_2_0
	(List<Gene> list, int numOfPairs) {
		
		/******************************
			validate
		 ******************************/
		double res = CombinatoricsUtils.binomialCoefficientDouble(list.size(), 2);
//		double res = CombinatoricsUtils.binomialCoefficientDouble(list.length, 2);
		
		if ((int) res < numOfPairs) {
			
			numOfPairs = (int) res;
			
		}
		
		String message = String.format("res = %f", res);
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		message = null;

		
		
		List<TreeSet> pairId_set = Ops.get_PairIds_V_1_2_1(list, numOfPairs);
		
		////////////////////////////////
		
		// Pairs
		
		////////////////////////////////
		return Ops.build_Pairs_From_PairIds_V_1_3_0(list, pairId_set);
		
	}//get_Pairs_V_2_0
	
	public static void show_Pairs(Pair[] pairs) {
		// TODO Auto-generated method stub
		int len = pairs.length;
		
		for (int i = 0; i < len; i++) {
//			for (int i = 0; i < pairs.length; i++) {
			
			Pair p = pairs[i];
			Gene gA = p.getA();
			Gene gB = p.getB();

			StringBuilder sbA = new StringBuilder(100);
			StringBuilder sbB = new StringBuilder(100);
			
			int j = 0;
			for ( ; j < CONS.Admin.NUM_OF_BITS - 1; j++) {
				
				sbA.append(gA.getBits()[j]);
				sbA.append(",");
				
				sbB.append(gB.getBits()[j]);
				sbB.append(",");
				
			}

			sbA.append(gA.getBits()[j]);
			sbB.append(gB.getBits()[j]);
			
			sbA.append(" : " + gA.getAdaptability());
			sbB.append(" : " + gB.getAdaptability());
			
			
			String message = String.format(
					"pairs[%d]: Gene.A.id = %d (%s) / Gene.B.id = %d (%s)", 
					i, gA.getId(), sbA.toString(), gB.getId(), sbB.toString());
			
			Methods.message(message,
			Thread.currentThread().getStackTrace()[1].getFileName(),
			Thread.currentThread().getStackTrace()[1].getLineNumber());
	
		}
		
//		Pair p = pairs[0];
//		Gene g = p.getA();
//		
//		Pair p2 = pairs[2];
//		Gene g2 = p2.getA();
//		
//		message = String.format(
//						"pairs[0].getA().getId() => %d", 
//						g.getId());
//		Methods.message(message,
//				Thread.currentThread().getStackTrace()[1].getFileName(),
//				Thread.currentThread().getStackTrace()[1].getLineNumber());
//		
//		message = String.format(
//				"pairs[2].getA().getId() => %d", 
//				g2.getId());
//		Methods.message(message,
//				Thread.currentThread().getStackTrace()[1].getFileName(),
//				Thread.currentThread().getStackTrace()[1].getLineNumber());
		
	}
	
	public static void show_Pair(Pair pair) {
		// TODO Auto-generated method stub
		Gene gA = pair.getA();
		Gene gB = pair.getB();
		
		StringBuilder sbA = new StringBuilder(100);
		StringBuilder sbB = new StringBuilder(100);
		
		int j = 0;
		for ( ; j < CONS.Admin.NUM_OF_BITS - 1; j++) {
			
			sbA.append(gA.getBits()[j]);
			sbA.append(",");
			
			sbB.append(gB.getBits()[j]);
			sbB.append(",");
			
		}
		
		sbA.append(gA.getBits()[j]);
		sbB.append(gB.getBits()[j]);
		
		sbA.append(" : " + gA.getAdaptability());
		sbB.append(" : " + gB.getAdaptability());
		
		
		String message = String.format(
				"pair: Gene.A.id = %d [prev: gen=%d,id=%d] (%s) / Gene.B.id = %d [prev: gen=%d,id=%d] (%s)", 
				gA.getId(), gA.getPrevId()[0], gA.getPrevId()[1], sbA.toString(), 
				gB.getId(), gB.getPrevId()[0], gB.getPrevId()[1], sbB.toString());
		
		Methods.message(message,
				Thread.currentThread().getStackTrace()[1].getFileName(),
				Thread.currentThread().getStackTrace()[1].getLineNumber());
			
//		Pair p = pairs[0];
//		Gene g = p.getA();
//		
//		Pair p2 = pairs[2];
//		Gene g2 = p2.getA();
//		
//		message = String.format(
//						"pairs[0].getA().getId() => %d", 
//						g.getId());
//		Methods.message(message,
//				Thread.currentThread().getStackTrace()[1].getFileName(),
//				Thread.currentThread().getStackTrace()[1].getLineNumber());
//		
//		message = String.format(
//				"pairs[2].getA().getId() => %d", 
//				g2.getId());
//		Methods.message(message,
//				Thread.currentThread().getStackTrace()[1].getFileName(),
//				Thread.currentThread().getStackTrace()[1].getLineNumber());
		
	}
	
	public static void show_Gene(Gene gene) {
		// TODO Auto-generated method stub
		
		int bitLen = gene.getNum_of_bits();
		
		int i = 0;
		int[] bits = gene.getBits();
		
		StringBuilder sb = new StringBuilder(20);
		
		for (; i < bitLen - 1; i++) {
//			for (int i = 0; i < pairs.length; i++) {

			sb.append(bits[i]);
			sb.append(",");
			
		}

		sb.append(bits[i]);
		
		////////////////////////////////

		// build: whole text

		////////////////////////////////
		String text = String.format(
						"Gene (gen=%d:id=%d) [%s]", 
						gene.getGen(), gene.getId(), sb.toString());
		
		sb.delete(0, sb.length());
		
		////////////////////////////////

		// show

		////////////////////////////////
		Methods.message(text, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());

		text = null;

		
		
//		Pair p = pairs[0];
//		Gene g = p.getA();
//		
//		Pair p2 = pairs[2];
//		Gene g2 = p2.getA();
//		
//		message = String.format(
//						"pairs[0].getA().getId() => %d", 
//						g.getId());
//		Methods.message(message,
//				Thread.currentThread().getStackTrace()[1].getFileName(),
//				Thread.currentThread().getStackTrace()[1].getLineNumber());
//		
//		message = String.format(
//				"pairs[2].getA().getId() => %d", 
//				g2.getId());
//		Methods.message(message,
//				Thread.currentThread().getStackTrace()[1].getFileName(),
//				Thread.currentThread().getStackTrace()[1].getLineNumber());
		
	}
	
	public static void show_Bits(int[] bits) {
		// TODO Auto-generated method stub
		
		int bitLen = bits.length;
		
		int i = 0;
		
		StringBuilder sb = new StringBuilder(20);
		
		for (; i < bitLen - 1; i++) {
//			for (int i = 0; i < pairs.length; i++) {
			
			sb.append(bits[i]);
			sb.append(",");
			
		}
		
		sb.append(bits[i]);
		
		////////////////////////////////
		
		// build: whole text
		
		////////////////////////////////
		String text = String.format(
				"bits => [%s]", sb.toString());
		
		sb.delete(0, sb.length());
		
		////////////////////////////////
		
		// show
		
		////////////////////////////////
		Methods.message(text, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		text = null;
		
	}

	public static List<TreeSet>
//	public static List<TreeSet>
	get_PairIds_V_1_2_1
	(List<Gene> gene_list, int num_of_pairs) {
		// TODO Auto-generated method stub
		////////////////////////////////
		
		// vars
		
		////////////////////////////////
		int[] pickArray = Ops.get_Pick_Array(gene_list);
		
		Random rn = new Random();
		
//		List<TreeSet> tSet = new ArrayList<TreeSet>();
		List<TreeSet> id_list = new ArrayList<TreeSet>(num_of_pairs);
		
		int counter = 0;
		
		while(id_list.size() < num_of_pairs) {
			
			TreeSet<Integer> s = new TreeSet<Integer>();
			
			while(s.size() < 2) {
				
				s.add(pickArray[rn.nextInt(pickArray.length)]);
				
			}
			
			if (!id_list.contains(s)) {
				
				id_list.add(s);
				
			}
			
			counter ++;
			
		}
		
		String message = String.format("while iteration => %d", counter);
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		return id_list;
		
	}//get_PairIds(Gene[] genes)

	public static List<Pair>
	build_Pairs_From_PairIds_V_1_3_0
	(List<Gene> list, List<TreeSet> pairId_set) {
		
		List<Pair> pairs = new ArrayList<Pair>();
//		Pair[] pairs = new Pair[pairId_set.size()];
//		Pair[] pairs = new Pair[pairId_set.size()];
		
		int size = pairId_set.size();
		
		for (int i = 0; i < size; i++) {
			
			TreeSet<Integer> s = pairId_set.get(i);
			
			Object[] id_Ary = s.toArray();
			
			Gene gA = list.get((int) id_Ary[0]);
			Gene gB = list.get((int) id_Ary[1]);
//			Gene gA = list[(int) id_Ary[0]];
//			Gene gB = list[(int) id_Ary[1]];
			
			Pair pair = new Pair();
//			pairs[i] = new Pair();
			
			pair.setA(gA);
			pair.setB(gB);
			
//			pairs[i].setA(gA);
//			pairs[i].setB(gB);
			
			pairs.add(pair);
			
		}
		
		return pairs;
		
	}//build_Pairs_From_PairIds_V_1_3_0
	
	public static float
	get_Generation_Adaptability(List<Gene> list) {
	
		int sumOfAdaptability = 0;
		
		for (Gene gene : list) {
			
			sumOfAdaptability += gene.getAdaptability();
			
		}
		
//		int len = list.length;
		
//		for (int i = 0; i < len; i++) {
//			
//			sumOfAdaptability += list[i].getAdaptability();
//			
//		}
		
		return (float)sumOfAdaptability / list.size();
		
//		return len > 0 ? ((float)sumOfAdaptability / len) : -1;
		
	}

	public static Object[]
//	public static List<Integer[]>
	crossOver
	(int[] bitsA, int[] bitsB, int point) {
		
//		List<Integer[]> list = new ArrayList<Integer[]>();
		Object[] bitsList = new Object[2];
		
//		//log
//		String message = String.format("<Before CO>");
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//				.getLineNumber());
//
//		message = null;
//
//		
//		Ops.show_Bits(bitsA);
//		Ops.show_Bits(bitsB);
		
		/******************************
			validate
		 ******************************/
		if (point > bitsA.length - 2) {
			
			String message = String.format("Crossing point => beyond the size");
			Methods.message(message,
					Thread.currentThread().getStackTrace()[1].getFileName(),
					Thread.currentThread().getStackTrace()[1].getLineNumber());

			message = null;

			bitsList[0] = bitsA;
			bitsList[1] = bitsA;
			
			return bitsList;
			
//			list.add(bitsA);
		}
		
		
		
		////////////////////////////////

		// crossover

		////////////////////////////////
		int[] bitsA_new = new int[bitsA.length];
		int[] bitsB_new = new int[bitsB.length];
		
		System.arraycopy(bitsA, 0, bitsA_new, 0, point);
		System.arraycopy(
//					bitsB, point + 1, 
					bitsB, point, 
					bitsA_new, point, 
//					bitsA_new, point + 1, 
					(bitsA.length) - point);
		
		System.arraycopy(bitsB, 0, bitsB_new, 0, point);
		System.arraycopy(
//					bitsA, point + 1, 
					bitsA, point, 
					bitsB_new, point, 
					(bitsB.length) - point);
//		bitsB.length - 1);
		
		bitsList[0] = bitsA_new;
		bitsList[1] = bitsB_new;
		
//		//log
//		message = String.format("<After CO>");
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//				.getLineNumber());
//
//		message = null;
//
//
//		Ops.show_Bits(bitsA_new);
//		Ops.show_Bits(bitsB_new);
//		
		return bitsList;
		
	}//crossOver

	public static Pair 
	get_NewGenes_from_Pair(Pair pair) {
		
		////////////////////////////////

		// prep: vars

		////////////////////////////////
		Gene gA = pair.getA();
		Gene gB = pair.getB();
		
		int[] bitsA = gA.getBits();
		int[] bitsB = gB.getBits();
		
		Object[] new_Bits = Ops.crossOver(bitsA, bitsB, 3);

		////////////////////////////////

		// ops

		////////////////////////////////
		Gene newA = new Gene.Builder()
					.setAdaptability(Ops.get_Adapt_Value((int[]) new_Bits[0]))
					.setBits((int[]) new_Bits[0])
					.setGen(gA.getGen() + 1)
					.setNum_of_bits(CONS.Admin.NUM_OF_BITS)
					.setPrevId(new int[]{gA.getGen(), gA.getId()})
					.build();
		
		Gene newB = new Gene.Builder()
		.setAdaptability(Ops.get_Adapt_Value((int[]) new_Bits[1]))
		.setBits((int[]) new_Bits[1])
		.setGen(gB.getGen() + 1)
		.setNum_of_bits(CONS.Admin.NUM_OF_BITS)
		.setPrevId(new int[]{gB.getGen(), gB.getId()})
		.build();
		
		Pair p_new = new Pair();
		p_new.setA(newA);
		p_new.setB(newB);
		
		return p_new;
		
	}

	public static Generation
	get_Generation_from_Generation
	(Generation gen_fore) {
		// TODO Auto-generated method stub
		
		Generation gen_off = new Generation.Builder()
							.setGenId(gen_fore.getGenId() + 1)
							.build();
		
		List<Pair> pairs_fore = Ops.get_Pairs_V_2_0(
						gen_fore.getMembers(), CONS.Admin.NUM_OF_PAIRS);
		
		List<Gene> genes_off = new ArrayList<Gene>();
		
		for (Pair pair_fore : pairs_fore) {
			
			Pair pair_off = Ops.get_NewGenes_from_Pair(pair_fore);
			
			genes_off.add(pair_off.getA());
			genes_off.add(pair_off.getB());
			
		}

		gen_off.setMembers(genes_off);
		gen_off.setNum_of_members(genes_off.size());
		gen_off.setAvgAdapt(Ops.get_Generation_Adaptability(gen_off.getMembers()));

		return gen_off;
		
	}//get_Generation_from_Generation

	public static void
	show_Generation(Generation generation) {
		// TODO Auto-generated method stub

		List<Gene> genes = generation.getMembers();
		
		for (Gene gene : genes) {
			
			Ops.show_Gene(gene);
			
		}
		
	}
	
}//public class Ops
