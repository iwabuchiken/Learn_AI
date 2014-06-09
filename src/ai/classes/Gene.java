package ai.classes;

import ai.utils.CONS;

public class Gene {

	int[]	bits;		// 6 elements(bits)
	
	int		gen;		// Xth generation
						// Initial generation => 0
	
	int		num_of_bits = CONS.Admin.NUM_OF_BITS;

	float	adaptability;
	
	public int[] getBits() {
		return bits;
	}

	public int getGen() {
		return gen;
	}

	public void setBits(int[] bits) {
		this.bits = bits;
	}

	public void setGen(int gen) {
		this.gen = gen;
	}

	public int getNum_of_bits() {
		return num_of_bits;
	}

	public void setNum_of_bits(int num_of_bits) {
		this.num_of_bits = num_of_bits;
	}

	public float getAdaptability() {
		return adaptability;
	}

	public void setAdaptability(float adaptability) {
		this.adaptability = adaptability;
	}
	
	
	
}
