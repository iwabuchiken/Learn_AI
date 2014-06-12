package ai.classes;

import java.util.List;

public class Generation {

	int		num_of_members;		// number of members in a generation
	
	List<Gene>	members;
//	Gene[]	members;

	float	avgAdapt;
	
	int		genId;

	////////////////////////////////

	// const

	////////////////////////////////
	public Generation(Builder builder) {
		
		this.num_of_members	= builder.num_of_members;		// number of members in a generation
		
		this.members	= builder.members;

		this.avgAdapt	= builder.avgAdapt;
		
		this.genId	= builder.genId;
		
	}

	public Generation() {
		// TODO Auto-generated constructor stub
	}
	
	////////////////////////////////

	// methods

	////////////////////////////////
	public int getNum_of_members() {
		return num_of_members;
	}

	public void setNum_of_members(int num_of_members) {
		this.num_of_members = num_of_members;
	}

	public List<Gene> getMembers() {
		return members;
	}
	
	public void setMembers(List<Gene> members) {
		this.members = members;
	}

	public float getAvgAdapt() {
		return avgAdapt;
	}

	public void setAvgAdapt(float avgAdapt) {
		this.avgAdapt = avgAdapt;
	}

	public int getGenId() {
		return genId;
	}

	public void setGenId(int genId) {
		this.genId = genId;
	}

	
	
	////////////////////////////////

	// builder

	////////////////////////////////
	public static class Builder {

		int		num_of_members;		// number of members in a generation
		
		List<Gene>	members;

		float	avgAdapt;
		
		int		genId;

		////////////////////////////////

		// const

		////////////////////////////////
		public Generation build() {
			
			return new Generation(this);
			
		}
		
		////////////////////////////////

		// methods

		////////////////////////////////
		public int getNum_of_members() {
			return num_of_members;
		}

		public List<Gene> getMembers() {
			return members;
		}

		public float getAvgAdapt() {
			return avgAdapt;
		}

		public int getGenId() {
			return genId;
		}

		public Builder setNum_of_members(int num_of_members) {
			this.num_of_members = num_of_members; return this;
		}

		public Builder setMembers(List<Gene> members) {
			this.members = members; return this;
		}

		public Builder setAvgAdapt(float avgAdapt) {
			this.avgAdapt = avgAdapt; return this;
		}

		public Builder setGenId(int genId) {
			this.genId = genId; return this;
		}

	}//public static class Builder

}
