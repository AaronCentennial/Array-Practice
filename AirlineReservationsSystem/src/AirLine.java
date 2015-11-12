import java.util.ArrayList;

/*
 * Created by Aaron Fernandes(300773526) on November 2015.
 */
public class AirLine {
	private ArrayList<Boolean> _seats;
	AirLine(){
		// true=First Class, false=Economy
		this._seats = new ArrayList<>();
		this._genPlaneList();
	}

	private void _genPlaneList() {
		for (int i=0;i<10;i++){
			if (i<5){this._seats.add(true);}
			else{this._seats.add(false);}

		}
	}

	public int getNumFirstClassSeats(){
		int rValue=0;

		for(Boolean i : this._seats){
			if (i){rValue++;}
		}

		return rValue;
	}

	public int getNumEconomyClassSeats(){
		int rValue=0;

		for(Boolean i : this._seats){
			if (!i){rValue++;}
		}

		return rValue;
	}

	public boolean removeFirstClass(){return this._seats.remove(true);}
	public boolean removeEconomyClass(){return this._seats.remove(false);}

}
