import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * swing全局字体设置类
 */
public class SysFontAndFace {

	public static Font font = new Font("宋体", Font.PLAIN, 14);
	
	/*
	 * 自定义全局字体
	 */
	public static void setSysFontAndFace() {
		try {
			UIManager.put("ToolTip.font", font);
			UIManager.put("Table.font", font);
			UIManager.put("TableHeader.font", font);
			UIManager.put("TextField.font", font);
			UIManager.put("ComboBox.font", font);
			UIManager.put("TextField.font", font);
			UIManager.put("PasswordField.font", font);
			UIManager.put("TextPane.font", font);
			UIManager.put("EditorPane.font", font);
			UIManager.put("FormattedTextField.font", font);
			UIManager.put("Button.font", font);
			UIManager.put("RadioButton.font", font);
			UIManager.put("ToggleButton.font", font);
			UIManager.put("ProgressBar.font", font);
			UIManager.put("DesktopIcon.font", font);
			UIManager.put("TitledBorder.font", font);
			UIManager.put("Label.font", font);
			UIManager.put("List.font", font);
			UIManager.put("TabbedPane.font", font);
			UIManager.put("PopupMenu.font", font);
			UIManager.put("CheckBoxMenuItem.font", font);
			UIManager.put("RadioButtonMenuItem.font", font);
			UIManager.put("Spinner.font", font);
			UIManager.put("Tree.font", font);
			UIManager.put("ToolBar.font", font);
			UIManager.put("OptionPane.messageFont", font);
			UIManager.put("OptionPane.buttonFont", font); 

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
