package ai.classes;

public class Generation {

	int		num_of_members;		// number of members in a generation
	
	Gene[]	members;

	public int getNum_of_members() {
		return num_of_members;
	}

	public Gene[] getMembers() {
		return members;
	}

	public void setNum_of_members(int num_of_members) {
		this.num_of_members = num_of_members;
	}

	public void setMembers(Gene[] members) {
		this.members = members;
	}
	
	
	
}
