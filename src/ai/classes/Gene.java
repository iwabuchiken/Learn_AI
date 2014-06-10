package ai.classes;

import ai.utils.CONS;

public class Gene {

	int[]	bits;		// 6 elements(bits)
	
	int		gen;		// Xth generation
						// Initial generation => 0
	
	int		id;			// in-generation serial number
	
	int		num_of_bits = CONS.Admin.NUM_OF_BITS;

	int	adaptability;
	
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

	public int getAdaptability() {
		return adaptability;
	}

	public void setAdaptability(int adaptability) {
		this.adaptability = adaptability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
