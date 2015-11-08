import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aaron Fernandes(300773526) on November 2015.
 */
public class AirLineGui extends JFrame implements ActionListener {
	private JPanel _contentPane;
	private JButton _fclassbtn;
	private JButton _eclassbtn;
	private JButton _exitbtn;
	private JLabel _fLabel;
	private JLabel _eLabel;
	private JLabel _total;
	private AirLine _airLine;

	AirLineGui(AirLine airLine){
		super("Air Line Program");
		this._airLine=airLine;
		this._initFrame();
		this._addActionListeners();
		this._updateTexts();
	}

	private void _addActionListeners() {
		this._exitbtn.addActionListener(this);
		this._fclassbtn.addActionListener(this);
		this._eclassbtn.addActionListener(this);
	}

	//	initialize frame
	private void _initFrame() {
		setContentPane(this._contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500,200);
		setSize(600,100);
		setVisible(true);
		setIconImage(new ImageIcon(getClass().getResource("/images/black401.png")).getImage());
	}


	private void _updateTexts(){
		int firstClass=this._airLine.getNumFirstClassSeats();
		int economyClass=this._airLine.getNumEconomyClassSeats();
		this._fLabel.setText("1st Class Seats left: " + firstClass);
		this._eLabel.setText("Economy Seats left: " + economyClass);
		this._total.setText("Total Seats Available: "+(firstClass+economyClass));
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource()==this._exitbtn){
			int choice=JOptionPane.showOptionDialog(null, "Are you sure you want to exit", "Do you?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

			if (choice==JOptionPane.YES_OPTION){System.exit(0);}
		}
		else if(actionEvent.getSource()==this._fclassbtn){
			this._removeFirstClass();
		}
		else if (actionEvent.getSource()==this._eclassbtn){
			this._removeEconomyClass();
		}

	}

	private void _removeFirstClass() {
		boolean fistClassAvailable=_airLine.removeFirstClass();
		if (!fistClassAvailable){
			JOptionPane.showMessageDialog(null, "No first class seats left");
		}
		this._updateTexts();
	}

	private void _removeEconomyClass() {
		boolean fistClassAvailable=_airLine.removeEconomyClass();
		if (!fistClassAvailable){
			int choice=JOptionPane.showOptionDialog(null, "No economy class seats left\nDo You want a first class seat?", "Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (choice==JOptionPane.YES_OPTION){
				this._removeFirstClass();
			}
			else if (choice==JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null,"Next flight leaves in 3 hours.");
			}
		}
		this._updateTexts();
	}
}
