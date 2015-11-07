import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aaron Fernandes(300773526) on November 2015.
 */
public class DiceGui extends JFrame{

	private JPanel _contentPane;
	private JButton _diceBtn;

	DiceGui(){
		super("Dice Gui");
		setContentPane(this._contentPane);
		pack();
		setSize(300,300);setLocation(500,300);

		setDefaultLookAndFeelDecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		_diceBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				ArrayList<Integer> intArray = new ArrayList<>();
				String messg="";


				Die die1 = new Die();
				Die die2 = new Die();

				for (int i = 0; i < 36000; i++) {
					die1._rollDie();
					die2._rollDie();
					intArray.add(die1.get_dieValue()+die2.get_dieValue());
				}

				for (int i =2; i<13; i++){
					messg+= String.format("Frequency of %d is %d\n", i, Collections.frequency(intArray, i));
				}
				JOptionPane.showMessageDialog(null,messg);
			}
		});
	}

}
