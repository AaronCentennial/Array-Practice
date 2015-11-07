import java.security.SecureRandom;

/**
 * Created by Aaron Fernandes(300773526) on November 2015.
 */
public class Die {
	private SecureRandom _random;
	private int _dieValue;

	Die(){
		this._random=new SecureRandom();
		_rollDie();
	}

	public void _rollDie() {
		this._dieValue=this._random.nextInt(5)+1;
	}

	public int get_dieValue() {
		return _dieValue;
	}
}
