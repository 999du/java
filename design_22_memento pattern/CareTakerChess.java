package design_22;

import java.util.ArrayList;

public class CareTakerChess {

	private ArrayList<MementoChess> memlist=new <MementoChess>ArrayList();
	public void AddMem(MementoChess mem) {
		memlist.add(mem);
	}
	public MementoChess getMem(int i) {
		return memlist.get(i);
	}
}
