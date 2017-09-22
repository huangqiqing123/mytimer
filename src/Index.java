import java.awt.SplashScreen;

public class Index {

	 public static void main(String args[]) {
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {  
	            	
	            	SysFontAndFace.setSysFontAndFace();
	            	MyTimer.getInstance().setVisible(true);
	            	
	            	// 关闭欢迎信息
	            	SplashScreen ss = SplashScreen.getSplashScreen();
	            	if (ss != null) {
	            		ss.close();
	            	}
	            }
	        });
	    }
}
