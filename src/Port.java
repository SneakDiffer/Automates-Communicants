import java.util.HashSet;

public abstract class Port {
	private String name;
	private Object value;

	//-------------------------GET------------------------
	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}	
	
	//-------------------------SET------------------------
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

}
