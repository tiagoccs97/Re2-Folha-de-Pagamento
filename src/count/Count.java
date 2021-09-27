package count;

public class Count{
	int id;
	int id_synd;
	
	public Count(int id, int id_s) {
		this.id = id;
		this.id = id_s;
	}
	
	public int get_id(){
		return this.id;
	}
	public int get_id_synd(){
		return id_synd;
	}
	public void add_id() {
		this.id += 1;
	}
	public void add_id_synd(){
		this.id_synd += 1;
	}
	public void set_id(int id) {
		this.id = id;
	}
	public void set_id_synd(int id_s) {
		this.id_synd =  id_s;
	}
}