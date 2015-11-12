import javax.swing.*;

/*
 * Created by Aaron Fernandes(300773526) on November 2015.
 */
public class Program {
	public static void main(String[] args){
		nativeUI(); //get the native look and feel for each OS
		new DiceGui(); //starts the GUI

	}

	public static void nativeUI(){
		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			System.out.print(info.toString()+"\n");
			if ("GTK+".equals(info.getName()) || "Windows".equals(info.getName()) || "substance".equals(info.getName()) || "Aqua".equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}
}
