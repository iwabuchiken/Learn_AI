package ai.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import ai.classes.Gene;
import ai.classes.Pair;

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
			
			/******************************
				Initialize
			 ******************************/
			//REF array of class http://stackoverflow.com/questions/5364278/creating-an-array-of-objects-in-java answered Mar 19 '11 at 19:19
			genes_0[i] = new Gene();

			/******************************
				Set: id
			 ******************************/
			genes_0[i].setId(i);
//			genes_0[i].setId(i + 1);
			
			/******************************
				Get: bits
			 ******************************/
			int[] bits = new int[CONS.Admin.NUM_OF_BITS];
			
			for (int j = 0; j < genes_0[i].getNum_of_bits(); j++) {
				
//				int[] bits = new int[]{1,0,0,1,1,1};
				
				bits[j] = rn.nextInt(2);
				
//				genes_0[i].setBits(bits);
				
			}
			
			genes_0[i].setBits(bits);
			
			/******************************
				Adaptability
			 ******************************/
			genes_0[i].setAdaptability(Ops.get_Adapt_Value(genes_0[i].getBits()));
			
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

	public static int[] get_Pick_Array(Gene[] genes) {
		// TODO Auto-generated method stub
		
		////////////////////////////////

		// vars

		////////////////////////////////
		int sum = 0;
		
		for (int i = 0; i < genes.length; i++) {
			
			sum += genes[i].getAdaptability();
			
		}
		
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
		
		for (int j = 0; j < genes.length; j++) {
			
			for (; i < count + genes[j].getAdaptability(); i++) {
				
				pick_Array[i] = k;
				
			}
			
			k ++;
			count = i;
			
		}
		
		return pick_Array;
	}

	
	public static Pair get_Pairs(Gene[] genes) {
		// TODO Auto-generated method stub
		int[] pickArray = Ops.get_Pick_Array(genes);
		
		Random rn = new Random();
		
		int size = genes.length;
		
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
		
		
//		Set<TreeSet> container = new TreeSet<TreeSet>();
//		Set<TreeSet<Integer>> container = new TreeSet<TreeSet<Integer>>();
		
//		container.addAll(s1);
////		container.add(s1);
//		
//		message = "container.contains(s2) => " + container.contains(s2);
//		Methods.message(message, Thread.currentThread().getStackTrace()[1]
//				.getFileName(), Thread.currentThread().getStackTrace()[1]
//				.getLineNumber());
		
		
		
		return null;
	}
	
	public static Pair get_Pairs_v3(Gene[] genes) {
		// TODO Auto-generated method stub
//		int[] pickArray = Ops.get_Pick_Array(genes);
		
		Object[] pair_Ids = Ops.get_PairIds(genes);
		
		////////////////////////////////

		// Get: sets

		////////////////////////////////
		Set<Integer> s1 = (Set<Integer>) pair_Ids[0];
		Set<Integer> s2 = (Set<Integer>) pair_Ids[1];
		
		Object[] ids_A = s1.toArray();
		Object[] ids_B = s2.toArray();

		////////////////////////////////

		// Get: genes

		////////////////////////////////
		Gene gA_A = genes[(int) ids_A[0]];
		Gene gA_B = genes[(int) ids_A[1]];
		
		Gene gB_A = genes[(int) ids_B[0]];
		Gene gB_B = genes[(int) ids_B[1]];
		
		////////////////////////////////

		// Set: pair

		////////////////////////////////
		Pair pA = new Pair();
		
		pA.setA(gA_A);
		pA.setB(gA_B);
		
		Pair pB = new Pair();
		
		pB.setA(gB_A);
		pB.setB(gB_B);
		
		return null;
	}
	
	public static Pair[] get_Pairs_v4
	(Gene[] genes, int num_of_pairs) {
		// TODO Auto-generated method stub
//		int[] pickArray = Ops.get_Pick_Array(genes);
		
		Pair[] pairs = new Pair[num_of_pairs];
		
		HashSet<TreeSet> pairId_set = Ops.get_PairIds_v2(genes, num_of_pairs);
//		List<TreeSet> pairId_set = Ops.get_PairIds_v2(genes, num_of_pairs);
		
		String message = String.format("pairId_set.size() => %d", pairId_set.size());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());
		
//		////////////////////////////////
//
//		// Show: ids
//
//		////////////////////////////////
//		int counter = 1;
//		
//		for (TreeSet tSet : pairId_set) {
//			
//			Object[] tSet_Array = tSet.toArray();
//			
//			message = String.format("pairId_set:%d => %d, %d", 
//					counter, (int) tSet_Array[0], (int) tSet_Array[1]);
//			
//			Methods.message(message, Thread.currentThread().getStackTrace()[1]
//					.getFileName(), Thread.currentThread().getStackTrace()[1]
//							.getLineNumber());
//			
//			counter ++;
//			
//		}

//		////////////////////////////////
//		
//		// Show: ids
//		
//		////////////////////////////////
//		for (int i = 0; i < pairId_set.size(); i++) {
//			
//			TreeSet<Integer> s = pairId_set.get(i);
//			
//			Object[] s_Array = s.toArray();
//			
//			message = String.format("pairId_set.get(%d) => %d, %d", 
//					i, (int) s_Array[0], (int) s_Array[1]);
//			
//			Methods.message(message, Thread.currentThread().getStackTrace()[1]
//					.getFileName(), Thread.currentThread().getStackTrace()[1]
//							.getLineNumber());
//			
//		}//for (int i = 0; i < pairId_set.size(); i++)
//		
		
		////////////////////////////////
		
		// Get: sets
		
		////////////////////////////////
//		Set<Integer> s1 = (Set<Integer>) pair_Ids[0];
//		Set<Integer> s2 = (Set<Integer>) pair_Ids[1];
//		
//		Object[] ids_A = s1.toArray();
//		Object[] ids_B = s2.toArray();
//		
//		////////////////////////////////
//		
//		// Get: genes
//		
//		////////////////////////////////
//		Gene gA_A = genes[(int) ids_A[0]];
//		Gene gA_B = genes[(int) ids_A[1]];
//		
//		Gene gB_A = genes[(int) ids_B[0]];
//		Gene gB_B = genes[(int) ids_B[1]];
//		
//		////////////////////////////////
//		
//		// Set: pair
//		
//		////////////////////////////////
//		Pair pA = new Pair();
//		
//		pA.setA(gA_A);
//		pA.setB(gA_B);
//		
//		Pair pB = new Pair();
//		
//		pB.setA(gB_A);
//		pB.setB(gB_B);
		
		return null;
	}
	
	public static Pair get_Pairs_v2(Gene[] genes) {
		// TODO Auto-generated method stub
		int[] pickArray = Ops.get_Pick_Array(genes);
		
		Random rn = new Random();
		
		int size = genes.length;
		
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
		
		int counter = 0;
		
		do {
			
			s1.clear(); s2.clear();
			
			do {
				
				s1.add(pickArray[rn.nextInt(pickArray.length)]);
//				s1.add(pickArray[rn.nextInt(genes.length)]);
//				s1.add(rn.nextInt(genes.length));
				
			} while (s1.size() < 2);
			
			do {
				
				s2.add(pickArray[rn.nextInt(pickArray.length)]);
//				s2.add(pickArray[rn.nextInt(genes.length)]);
//				s2.add(rn.nextInt(genes.length));
				
			} while (s2.size() < 2);
			
			counter ++;
		
		} while (s1.equals(s2));
		
		message = String.format("Matching => %d rounds done", counter);
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());
		
			
		StringBuilder sb = new StringBuilder();
		
		// show: s1
		for (Integer num : s1) {
			
			sb.append(num);
			sb.append(", ");
			
		}
		
		message = String.format("s1 => %s", sb.toString());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());

		// show: s2
		sb.delete(0, sb.length());
		
		for (Integer num : s2) {
			
			sb.append(num);
			sb.append(", ");
			
		}
		
		message = String.format("s2 => %s", sb.toString());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		TreeSet[] pair_Ids = new TreeSet[2];
		
		pair_Ids[0] = s1;
		pair_Ids[1] = s2;
		
		Object[] pairs = new Object[2];
		
		pairs[0] = s1;
		pairs[1] = s1;
		
		
		return null;
	}
	
	public static Object[]
	get_PairIds(Gene[] genes) {
		// TODO Auto-generated method stub
		int[] pickArray = Ops.get_Pick_Array(genes);
		
		Random rn = new Random();
		
		////////////////////////////////
		
		// Get: sets
		
		////////////////////////////////
		TreeSet<Integer> s1 = new TreeSet<Integer>();
		TreeSet<Integer> s2 = new TreeSet<Integer>();
		
		int counter = 0;
		
		do {
			
			s1.clear(); s2.clear();
			
			do {
				
				s1.add(pickArray[rn.nextInt(pickArray.length)]);
//				s1.add(pickArray[rn.nextInt(genes.length)]);
//				s1.add(rn.nextInt(genes.length));
				
			} while (s1.size() < 2);
			
			do {
				
				s2.add(pickArray[rn.nextInt(pickArray.length)]);
//				s2.add(pickArray[rn.nextInt(genes.length)]);
//				s2.add(rn.nextInt(genes.length));
				
			} while (s2.size() < 2);
			
			counter ++;
			
		} while (s1.equals(s2));
		
		String message = String.format("Matching => %d rounds done", counter);
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		
		StringBuilder sb = new StringBuilder();
		
		// show: s1
		for (Integer num : s1) {
			
			sb.append(num);
			sb.append(", ");
			
		}
		
		message = String.format("s1 => %s", sb.toString());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		// show: s2
		sb.delete(0, sb.length());
		
		for (Integer num : s2) {
			
			sb.append(num);
			sb.append(", ");
			
		}
		
		message = String.format("s2 => %s", sb.toString());
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
						.getLineNumber());
		
		Object[] pairs = new Object[2];
		
		pairs[0] = s1;
		pairs[1] = s1;
		
		
		return pairs;
		
	}//get_PairIds(Gene[] genes)
	
	public static HashSet<TreeSet>
//	public static List<TreeSet>
	get_PairIds_v2(Gene[] genes, int num_of_pairs) {
		// TODO Auto-generated method stub
		////////////////////////////////

		// vars

		////////////////////////////////
		int[] pickArray = Ops.get_Pick_Array(genes);
		
		Random rn = new Random();
		
//		List<TreeSet> tSet = new ArrayList<TreeSet>();
		HashSet<TreeSet> hSet = new HashSet<TreeSet>();
		
		int counter = 0;
		
		while(hSet.size() < num_of_pairs) {
			
			TreeSet<Integer> s = new TreeSet<Integer>();
			
			while(s.size() < 2) {
				
				s.add(pickArray[rn.nextInt(pickArray.length)]);
				
			}
			
			hSet.add(s);
			
			counter ++;
			
		}

		String message = String.format("while iteration => %d", counter);
		Methods.message(message, Thread.currentThread().getStackTrace()[1]
				.getFileName(), Thread.currentThread().getStackTrace()[1]
				.getLineNumber());
		
		
		return hSet;
		
//		while(tSet.size() < num_of_pairs) {
//			
//			TreeSet<Integer> s = new TreeSet<Integer>();
//			
//			while(s.size() < 2) {
//				
//				s.add(pickArray[rn.nextInt(pickArray.length)]);
//				
//			}
//			
//			tSet.add(s);
//			
//		}
//		
//		return tSet;
		
	}//get_PairIds(Gene[] genes)
	
}//public class Ops
