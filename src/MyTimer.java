import java.awt.Color;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class MyTimer extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private static MyTimer instance = null;
	
	public static MyTimer getInstance(){
		if(instance == null){
			instance = new MyTimer();
        	int location[] = Util.getCenterLocation(instance);
        	instance.setLocation(location[0], location[1]);
        	instance.setResizable(false);
        	instance.setTitle("Mini定时器  (版权所有，浪潮软件评测实验室)");
        	ImageIcon ico_png = new ImageIcon(MyTimer.class.getResource("ico16.png"));
        	instance.setIconImage(ico_png.getImage());
		}
		return instance;
	}
	
    public MyTimer() {
        initComponents();
        
        //初始化提示信息标签
        jLabel_result.setForeground(Color.blue);
        jLabel_result.setText("<html><body>定时器当前状态：<b><font color ='red'>未启动</font></b></body></html>");
       
        //各时间文本框默认显示当前日期
        Calendar cc = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        jTextField_year.setText(cc.get(Calendar.YEAR)+"");
        jTextField_month.setText(cc.get(Calendar.MONTH)+1+"");
        jTextField_day.setText(cc.get(Calendar.DAY_OF_MONTH)+"");//24小时制
        jTextField_hour.setText(cc.get(Calendar.HOUR_OF_DAY)+"");
        jTextField_minute.setText(cc.get(Calendar.MINUTE)+"");
        jTextField_second.setText(cc.get(Calendar.SECOND)+"");
        jTextField_HaoMiao.setText("86400");//24*60*60
         
        //打开选择对话框
        jButton_choose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				openFileDialog();
			}    	
        });
      
        jButton_start.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String exePath = jTextField_exeFilePath.getText();
				if(exePath==null || exePath.trim().equals("")){
					return;
				}
				
				//构建首次执行时间
				int year = Integer.parseInt(jTextField_year.getText());;
				int month = Integer.parseInt(jTextField_month.getText())-1;//月 是从 0 开始（0表示1月，1表示2月）
				int day = Integer.parseInt(jTextField_day.getText());;
				int hrs = Integer.parseInt(jTextField_hour.getText());;
				int min = Integer.parseInt(jTextField_minute.getText());;
				int sec = Integer.parseInt(jTextField_second.getText());;		
				
				//根据文本框中的数据 构建日历对象
				Calendar c  = Calendar.getInstance();
				c.set(year,month,day,hrs,min,sec);
				Date firstTime = c.getTime();
				
				//构建执行周期，即每多少毫秒执行一次
				long period  = Long.parseLong(jTextField_HaoMiao.getText())*1000;//界面输入的单位是秒，此处转换成毫秒
				
				final File file = new File(jTextField_exeFilePath.getText());
				
				//创建定时器
				Timer timer = new Timer();
				timer.schedule(new TimerTask(){

					@Override
					public void run() {
						Desktop desk = Desktop.getDesktop(); 
						try {
							desk.open(file);
						} catch (IOException e) {
							JOptionPane.showMessageDialog(getInstance(), e.getMessage());
							
							//出现异常，则重新设置启动定时器按钮 可用
							jButton_start.setEnabled(true);
						}
					}
					
				}, firstTime, period);
				
				//成功启动定时器后，设置启动定时器按钮不可用
				jLabel_result.setText("<html><body>定时器当前状态：<b><font color ='green'>已启动</font></b></body></html>");
				jButton_start.setEnabled(false);
			}  	
        });
        jButton_cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}  	
        });
    }
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_choose;
    private javax.swing.JButton jButton_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jLabel_result;
    private javax.swing.JTextField jTextField_HaoMiao;
    private javax.swing.JTextField jTextField_day;
    private javax.swing.JTextField jTextField_exeFilePath;
    private javax.swing.JTextField jTextField_hour;
    private javax.swing.JTextField jTextField_minute;
    private javax.swing.JTextField jTextField_month;
    private javax.swing.JTextField jTextField_second;
    private javax.swing.JTextField jTextField_year;
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel_result = new javax.swing.JLabel();
        jTextField_year = new javax.swing.JTextField();
        jTextField_month = new javax.swing.JTextField();
        jTextField_day = new javax.swing.JTextField();
        jTextField_hour = new javax.swing.JTextField();
        jTextField_minute = new javax.swing.JTextField();
        jTextField_second = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_HaoMiao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextField_exeFilePath = new javax.swing.JTextField();
        jButton_choose = new javax.swing.JButton();
        jButton_start = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("首次执行时间"));

        jLabel1.setText("年");

        jLabel2.setText("月");

        jLabel3.setText("日");

        jLabel4.setText("时");

        jLabel5.setText("分");

        jLabel6.setText("秒");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(30, 30, 30)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jLabel4)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jTextField_hour, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jLabel3)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jTextField_day, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jLabel5)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jTextField_minute, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jLabel2)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jTextField_month, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jLabel1)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jTextField_year, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextField_second, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField_year, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField_month, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .add(11, 11, 11)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField_day, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField_hour, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField_minute, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField_second, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("执行频率"));

        jLabel7.setText("每");

        jLabel8.setText("秒");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jTextField_HaoMiao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel8))
                    .add(jLabel_result, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(jLabel8)
                    .add(jTextField_HaoMiao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 80, Short.MAX_VALUE)
                .add(jLabel_result, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );


        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("可执行文件"));

        jButton_choose.setText("选择");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jTextField_exeFilePath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 339, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton_choose)
                .addContainerGap(1, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton_choose)
                    .add(jTextField_exeFilePath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_start.setText("启动定时器");

        jButton_cancel.setText("关闭定时器");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel3, 0, 433, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(128, 128, 128)
                        .add(jButton_start)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jButton_cancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton_cancel)
                    .add(jButton_start))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    
    protected void openFileDialog() {
    	FileDialog saveDialog = new FileDialog(this, "请选择要执行的文件",FileDialog.LOAD);
		saveDialog.setVisible(true);
		String path = null;
		if (saveDialog.getDirectory() != null) {
			path = saveDialog.getDirectory() + saveDialog.getFile();
			jTextField_exeFilePath.setText(path);
		}
	}
}
