package ai.classes;

import ai.utils.CONS;

public class Gene {

	int[]	bits;		// 6 elements(bits)
	
	int		genId;		// Xth generation
						// Initial generation => 0
	
	int		id;			// in-generation serial number
	
	int		num_of_bits = CONS.Admin.NUM_OF_BITS;

	int		adaptability;
	
	int[]	prevId;		// gene ids of the previous generation
	
	public Gene(Builder builder) {
		// TODO Auto-generated constructor stub
		this.bits	= builder.bits;		// 6 elements(bits)
		
		this.genId	= builder.gen;		// Xth generation
							// Initial generation => 0
		
		this.id	= builder.id;			// in-generation serial number
		
		this.num_of_bits	= builder.num_of_bits;

		this.adaptability	= builder.adaptability;
		
		this.prevId	= builder.prevId;		// gene ids of the previous generation
		
	}
	
	public Gene() {
		// TODO Auto-generated constructor stub
	}
	
	////////////////////////////////

	// Methods

	////////////////////////////////
	public int[] getBits() {
		return bits;
	}

	public int getGen() {
		return genId;
	}

	public void setBits(int[] bits) {
		this.bits = bits;
	}

	public void setGen(int gen) {
		this.genId = gen;
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

	public int[] getPrevId() {
		return prevId;
	}

	public void setPrevId(int[] prevId) {
		this.prevId = prevId;
	}

	////////////////////////////////

	// Builder

	////////////////////////////////
	public static class Builder {
		
		int[]	bits;		// 6 elements(bits)
		
		int		gen;		// Xth generation
							// Initial generation => 0
		
		int		id;			// in-generation serial number
		
		int		num_of_bits = CONS.Admin.NUM_OF_BITS;

		int		adaptability;
		
		int[]	prevId;		// gene ids of the previous generation

		////////////////////////////////

		// const

		////////////////////////////////
		public Gene build() {
			
			return new Gene(this);
			
		}

		
		////////////////////////////////

		// methods

		////////////////////////////////
		public int[] getBits() {
			return bits;
		}

		public int getGen() {
			return gen;
		}

		public int getId() {
			return id;
		}

		public int getNum_of_bits() {
			return num_of_bits;
		}

		public int getAdaptability() {
			return adaptability;
		}

		public int[] getPrevId() {
			return prevId;
		}

		public Builder setBits(int[] bits) {
			this.bits = bits; return this;
		}

		public Builder setGen(int gen) {
			this.gen = gen; return this;
		}

		public Builder setId(int id) {
			this.id = id; return this;
		}

		public Builder setNum_of_bits(int num_of_bits) {
			this.num_of_bits = num_of_bits; return this;
		}

		public Builder setAdaptability(int adaptability) {
			this.adaptability = adaptability; return this;
		}

		public Builder setPrevId(int[] prevId) {
			this.prevId = prevId; return this;
		}

		
		
	}
	
	
}
