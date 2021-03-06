/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lop.frame;

import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.lop.core.CallExecutor;
import org.lop.modules.bean.CallOptionBean;
import org.lop.modules.constant.Constant;

/**
 * 主界面.
 * 
 * @author 潘瑞峥
 * @date 2013-5-13
 */
public class CallFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -8035652076494176725L;

	/**
	 * Creates new form MyFrame
	 */
	public CallFrame() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT
	 * modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel = new javax.swing.JPanel();
		jTabbedPanel = new javax.swing.JTabbedPane();
		mainPanel = new javax.swing.JPanel();
		settingPanel = new javax.swing.JPanel();
		callMobileLabel = new javax.swing.JLabel();
		callMobilePrefix = new javax.swing.JTextField();
		callMobileValue = new javax.swing.JTextField();
		callMobileValidate = new javax.swing.JLabel();
		callOptionLabel = new javax.swing.JLabel();
		callOptionComboBox = new javax.swing.JComboBox<CallOptionBean>();
		callAcountLabel = new javax.swing.JLabel();
		callAcountSlider = new javax.swing.JSlider();
		callAcountValue = new javax.swing.JTextField();
		callMaxLabel = new javax.swing.JLabel();
		callMaxSlider = new javax.swing.JSlider();
		callMaxValue = new javax.swing.JTextField();
		connTimeLabel = new javax.swing.JLabel();
		connTimeSlider = new javax.swing.JSlider();
		connTimeValue = new javax.swing.JTextField();
		callRateLabel = new javax.swing.JLabel();
		callRateSlider = new javax.swing.JSlider();
		callRateValue = new javax.swing.JTextField();
		beginEndButton = new javax.swing.JToggleButton();
		callProgressBar = new javax.swing.JProgressBar();
		optionDetailPanel = new javax.swing.JPanel();
		optionDetailScrollPane = new javax.swing.JScrollPane();
		optionDetailText = new javax.swing.JTextPane();
		logPanel = new javax.swing.JPanel();
		logScrollPane = new javax.swing.JScrollPane();
		logText = new javax.swing.JTextPane();
		queryPanel = new javax.swing.JPanel();
		aboutPanel = new javax.swing.JPanel();
		aboutLabel = new javax.swing.JLabel();

		setDefaultCloseOperation( javax.swing.WindowConstants.EXIT_ON_CLOSE );
		setTitle( "自动拨号 v1.0.0.0   版权所有(c) dingdang_j" );
		setCursor( new java.awt.Cursor( java.awt.Cursor.DEFAULT_CURSOR ) );
		setName( "mainFrame" ); // NOI18N
		setResizable( false );

		jTabbedPanel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N

		mainPanel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N

		settingPanel.setBorder( javax.swing.BorderFactory.createTitledBorder( javax.swing.BorderFactory.createTitledBorder( "" ), "主选项",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font(
						"微软雅黑", 0, 11 ) ) ); // NOI18N

		callMobileLabel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callMobileLabel.setHorizontalAlignment( javax.swing.SwingConstants.RIGHT );
		callMobileLabel.setText( "呼叫号码" );

		callMobilePrefix.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N

		callMobileValue.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N

		callMobileValidate.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callMobileValidate.setForeground( new java.awt.Color( 204, 0, 0 ) );
		callMobileValidate.setHorizontalAlignment( javax.swing.SwingConstants.LEFT );

		callOptionLabel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callOptionLabel.setHorizontalAlignment( javax.swing.SwingConstants.RIGHT );
		callOptionLabel.setText( "呼叫程序" );

		callOptionComboBox.setModel( Constant.comboBoxModel );

		callAcountLabel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callAcountLabel.setHorizontalAlignment( javax.swing.SwingConstants.RIGHT );
		callAcountLabel.setText( "呼叫次数" );

		callAcountSlider.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callAcountSlider.setMajorTickSpacing( 20 );
		callAcountSlider.setMinimum( 1 );
		callAcountSlider.setPaintLabels( true );
		callAcountSlider.setValue( 5 );
		callAcountSlider.setValueIsAdjusting( true );
		callAcountSlider.addChangeListener( new javax.swing.event.ChangeListener() {
			public void stateChanged( javax.swing.event.ChangeEvent evt ) {
				callAcountSliderStateChanged( evt );
			}
		} );

		callAcountValue.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callAcountValue.setText( "" + callAcountSlider.getValue() );
		callAcountValue.setEnabled( false );

		callMaxLabel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callMaxLabel.setHorizontalAlignment( javax.swing.SwingConstants.RIGHT );
		callMaxLabel.setText( "呼叫限制" );

		callMaxSlider.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callMaxSlider.setMajorTickSpacing( 20 );
		callMaxSlider.setMinimum( 1 );
		callMaxSlider.setPaintLabels( true );
		callMaxSlider.setValue( 15 );
		callMaxSlider.setValueIsAdjusting( true );
		callMaxSlider.addChangeListener( new javax.swing.event.ChangeListener() {
			public void stateChanged( javax.swing.event.ChangeEvent evt ) {
				callMaxSliderStateChanged( evt );
			}
		} );

		callMaxValue.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callMaxValue.setText( "" + callMaxSlider.getValue() );
		callMaxValue.setEnabled( false );

		connTimeLabel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		connTimeLabel.setHorizontalAlignment( javax.swing.SwingConstants.RIGHT );
		connTimeLabel.setText( "呼叫时间" );

		connTimeSlider.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		connTimeSlider.setMajorTickSpacing( 5 );
		connTimeSlider.setMaximum( 20 );
		connTimeSlider.setMinimum( 1 );
		connTimeSlider.setPaintLabels( true );
		connTimeSlider.setValue( 8 );
		connTimeSlider.setValueIsAdjusting( true );
		connTimeSlider.addChangeListener( new javax.swing.event.ChangeListener() {
			public void stateChanged( javax.swing.event.ChangeEvent evt ) {
				connTimeSliderStateChanged( evt );
			}
		} );

		connTimeValue.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		connTimeValue.setText( "" + connTimeSlider.getValue() );
		connTimeValue.setEnabled( false );

		callRateLabel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callRateLabel.setHorizontalAlignment( javax.swing.SwingConstants.RIGHT );
		callRateLabel.setText( "呼叫频率" );

		callRateSlider.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callRateSlider.setMajorTickSpacing( 200 );
		callRateSlider.setMaximum( 600 );
		callRateSlider.setPaintLabels( true );
		callRateSlider.setValue( 5 );
		callRateSlider.setValueIsAdjusting( true );
		callRateSlider.addChangeListener( new javax.swing.event.ChangeListener() {
			public void stateChanged( javax.swing.event.ChangeEvent evt ) {
				callRateSliderStateChanged( evt );
			}
		} );

		callRateValue.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callRateValue.setText( "" + callRateSlider.getValue() );
		callRateValue.setEnabled( false );

		beginEndButton.setFont( new java.awt.Font( "微软雅黑", 1, 12 ) ); // NOI18N
		beginEndButton.setText( "√" );
		beginEndButton.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed( java.awt.event.ActionEvent evt ) {
				beginEndButtonActionPerformed( evt );
			}
		} );

		callProgressBar.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		callProgressBar.setStringPainted( true );

		javax.swing.GroupLayout settingPanelLayout = new javax.swing.GroupLayout( settingPanel );
		settingPanel.setLayout( settingPanelLayout );
		settingPanelLayout
				.setHorizontalGroup( settingPanelLayout
						.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
						.addGroup(
								settingPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												settingPanelLayout
														.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
														.addGroup(
																settingPanelLayout
																		.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING,
																				false )
																		.addGroup(
																				settingPanelLayout
																						.createSequentialGroup()
																						.addComponent( callMobileLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								120, javax.swing.GroupLayout.PREFERRED_SIZE )
																						.addGap( 18, 18, 18 )
																						.addComponent( callMobilePrefix,
																								javax.swing.GroupLayout.PREFERRED_SIZE, 40,
																								javax.swing.GroupLayout.PREFERRED_SIZE )
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED )
																						.addComponent( callMobileValue ) )
																		.addGroup(
																				settingPanelLayout
																						.createSequentialGroup()
																						.addComponent( callOptionLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								120, javax.swing.GroupLayout.PREFERRED_SIZE )
																						.addGap( 18, 18, 18 )
																						.addComponent( callOptionComboBox,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								201, javax.swing.GroupLayout.PREFERRED_SIZE ) ) )
														.addComponent( callAcountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
																javax.swing.GroupLayout.PREFERRED_SIZE )
														.addGroup(
																settingPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				settingPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false )
																						.addComponent( callRateLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								120, javax.swing.GroupLayout.PREFERRED_SIZE )
																						.addComponent( connTimeLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								120, javax.swing.GroupLayout.PREFERRED_SIZE )
																						.addComponent( callMaxLabel,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								120, javax.swing.GroupLayout.PREFERRED_SIZE ) )
																		.addGap( 18, 18, 18 )
																		.addGroup(
																				settingPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING )
																						.addGroup(
																								settingPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												callAcountValue,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												40,
																												javax.swing.GroupLayout.PREFERRED_SIZE )
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED )
																										.addComponent(
																												callAcountSlider,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												155,
																												javax.swing.GroupLayout.PREFERRED_SIZE ) )
																						.addGroup(
																								settingPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												callMaxValue,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												40,
																												javax.swing.GroupLayout.PREFERRED_SIZE )
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED )
																										.addComponent(
																												callMaxSlider,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												155,
																												javax.swing.GroupLayout.PREFERRED_SIZE ) )
																						.addGroup(
																								settingPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												connTimeValue,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												40,
																												javax.swing.GroupLayout.PREFERRED_SIZE )
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED )
																										.addComponent(
																												connTimeSlider,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												155,
																												javax.swing.GroupLayout.PREFERRED_SIZE ) )
																						.addGroup(
																								settingPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												callRateValue,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												40,
																												javax.swing.GroupLayout.PREFERRED_SIZE )
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED )
																										.addComponent(
																												callRateSlider,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												155,
																												javax.swing.GroupLayout.PREFERRED_SIZE ) ) ) )
														.addGroup(
																settingPanelLayout
																		.createSequentialGroup()
																		.addGap( 118, 118, 118 )
																		.addComponent( beginEndButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE, 60,
																				javax.swing.GroupLayout.PREFERRED_SIZE )
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED )
																		.addComponent( callProgressBar,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) )
										.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
										.addComponent( callMobileValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
												javax.swing.GroupLayout.PREFERRED_SIZE )
										.addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );
		settingPanelLayout.setVerticalGroup( settingPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup(
				settingPanelLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								settingPanelLayout
										.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
										.addComponent( callMobileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE )
										.addComponent( callMobileValue, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
										.addComponent( callMobilePrefix, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
										.addComponent( callMobileValidate, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE ) )
						.addGap( 16, 16, 16 )
						.addGroup(
								settingPanelLayout
										.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
										.addComponent( callOptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
												javax.swing.GroupLayout.PREFERRED_SIZE )
										.addComponent( callOptionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
												javax.swing.GroupLayout.PREFERRED_SIZE ) )
						.addGap( 14, 14, 14 )
						.addGroup(
								settingPanelLayout
										.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
										.addComponent( callAcountSlider, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
										.addGroup(
												settingPanelLayout
														.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
														.addComponent( callAcountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE )
														.addComponent( callAcountValue, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE ) ) )
						.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
						.addGroup(
								settingPanelLayout
										.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
										.addGroup(
												settingPanelLayout
														.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
														.addComponent( callMaxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE )
														.addComponent( callMaxValue, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE ) )
										.addComponent( callMaxSlider, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) )
						.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
						.addGroup(
								settingPanelLayout
										.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
										.addGroup(
												settingPanelLayout
														.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
														.addComponent( connTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE )
														.addComponent( connTimeValue, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE ) )
										.addComponent( connTimeSlider, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) )
						.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
						.addGroup(
								settingPanelLayout
										.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
										.addGroup(
												settingPanelLayout
														.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
														.addComponent( callRateValue, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE )
														.addComponent( callRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
																javax.swing.GroupLayout.PREFERRED_SIZE ) )
										.addComponent( callRateSlider, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) )
						.addGap( 20, 20, 20 )
						.addGroup(
								settingPanelLayout
										.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
										.addComponent( beginEndButton )
										.addComponent( callProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
												javax.swing.GroupLayout.PREFERRED_SIZE ) ) ) );

		optionDetailPanel.setBorder( javax.swing.BorderFactory.createTitledBorder(
				javax.swing.BorderFactory.createEmptyBorder( 1, 1, 1, 1 ), "呼叫程序描述", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font( "微软雅黑", 0, 11 ) ) ); // NOI18N

		optionDetailText.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		optionDetailScrollPane.setViewportView( optionDetailText );

		javax.swing.GroupLayout optionDetailPanelLayout = new javax.swing.GroupLayout( optionDetailPanel );
		optionDetailPanel.setLayout( optionDetailPanelLayout );
		optionDetailPanelLayout.setHorizontalGroup( optionDetailPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
				.addComponent( optionDetailScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE ) );
		optionDetailPanelLayout.setVerticalGroup( optionDetailPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
				.addGroup( optionDetailPanelLayout.createSequentialGroup().addComponent( optionDetailScrollPane ).addContainerGap() ) );

		logPanel.setBorder( javax.swing.BorderFactory.createTitledBorder( javax.swing.BorderFactory.createEmptyBorder( 1, 1, 1, 1 ), "日志",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font(
						"微软雅黑", 0, 11 ) ) ); // NOI18N

		logText.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		logText.addCaretListener( new javax.swing.event.CaretListener() {
			public void caretUpdate( javax.swing.event.CaretEvent evt ) {
				logTextCaretUpdate( evt );
			}
		} );
		logScrollPane.setViewportView( logText );

		javax.swing.GroupLayout logPanelLayout = new javax.swing.GroupLayout( logPanel );
		logPanel.setLayout( logPanelLayout );
		logPanelLayout.setHorizontalGroup( logPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent(
				logScrollPane, javax.swing.GroupLayout.Alignment.TRAILING ) );
		logPanelLayout.setVerticalGroup( logPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup(
				logPanelLayout.createSequentialGroup()
						.addComponent( logScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE ).addContainerGap() ) );

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout( mainPanel );
		mainPanel.setLayout( mainPanelLayout );
		mainPanelLayout.setHorizontalGroup( mainPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				mainPanelLayout
						.createSequentialGroup()
						.addGap( 5, 5, 5 )
						.addGroup(
								mainPanelLayout
										.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false )
										.addGroup(
												mainPanelLayout
														.createSequentialGroup()
														.addComponent( optionDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE )
														.addGap( 0, 0, 0 )
														.addComponent( logPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) )
										.addComponent( settingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 466,
												javax.swing.GroupLayout.PREFERRED_SIZE ) ).addGap( 5, 5, 5 ) ) );
		mainPanelLayout.setVerticalGroup( mainPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				mainPanelLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent( settingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE )
						.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
						.addGroup(
								mainPanelLayout
										.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING, false )
										.addComponent( optionDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
										.addComponent( logPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE ) )
						.addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) ) );

		settingPanel.getAccessibleContext().setAccessibleName( "主界面" );

		jTabbedPanel.addTab( "主界面", mainPanel );

		queryPanel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N

		javax.swing.GroupLayout queryPanelLayout = new javax.swing.GroupLayout( queryPanel );
		queryPanel.setLayout( queryPanelLayout );
		queryPanelLayout.setHorizontalGroup( queryPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0,
				476, Short.MAX_VALUE ) );
		queryPanelLayout.setVerticalGroup( queryPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGap( 0,
				519, Short.MAX_VALUE ) );

		jTabbedPanel.addTab( "查询", queryPanel );

		aboutPanel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N

		aboutLabel.setFont( new java.awt.Font( "微软雅黑", 0, 12 ) ); // NOI18N
		aboutLabel.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		aboutLabel
				.setText( "<html>\n<h3>自动拨号 1.0.0.0</h3>\n<p>版本号：1000</p>\n<p>版本日期：2013-06-01</p>\n<p/>\n\n<p>版权所有(c) dingdang_j</p>\n<p/>\n\n<p>欢迎使用本程序，如有问题敬请与我联系！</p>\n<p>QQ：376544447</p>\n<p>EMAIL：<a href=\"#\">dingdang_j@qq.com</a></p>\n</html>" );
		aboutLabel.setBorder( javax.swing.BorderFactory.createTitledBorder( null, "",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font(
						"微软雅黑", 0, 11 ) ) ); // NOI18N

		javax.swing.GroupLayout aboutPanelLayout = new javax.swing.GroupLayout( aboutPanel );
		aboutPanel.setLayout( aboutPanelLayout );
		aboutPanelLayout.setHorizontalGroup( aboutPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				aboutPanelLayout.createSequentialGroup().addContainerGap( 72, Short.MAX_VALUE )
						.addComponent( aboutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE )
						.addGap( 97, 97, 97 ) ) );
		aboutPanelLayout.setVerticalGroup( aboutPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addGroup(
				aboutPanelLayout.createSequentialGroup().addGap( 30, 30, 30 )
						.addComponent( aboutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE )
						.addContainerGap( 228, Short.MAX_VALUE ) ) );

		jTabbedPanel.addTab( "关于", aboutPanel );

		javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout( jPanel );
		jPanel.setLayout( jPanelLayout );
		jPanelLayout.setHorizontalGroup( jPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent(
				jTabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE ) );
		jPanelLayout.setVerticalGroup( jPanelLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent(
				jTabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE ) );

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane() );
		getContentPane().setLayout( layout );
		layout.setHorizontalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jPanel,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) );
		layout.setVerticalGroup( layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING ).addComponent( jPanel,
				javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE ) );

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void connTimeSliderStateChanged( javax.swing.event.ChangeEvent evt ) {// GEN-FIRST:event_connTimeSliderStateChanged
		// TODO add your handling code here:
		connTimeValue.setText( "" + connTimeSlider.getValue() );
	}// GEN-LAST:event_connTimeSliderStateChanged

	private void callAcountSliderStateChanged( javax.swing.event.ChangeEvent evt ) {// GEN-FIRST:event_callAcountSliderStateChanged
		// TODO add your handling code here:
		callAcountValue.setText( "" + callAcountSlider.getValue() );
	}// GEN-LAST:event_callAcountSliderStateChanged

	private void callMaxSliderStateChanged( javax.swing.event.ChangeEvent evt ) {// GEN-FIRST:event_callMaxSliderStateChanged
		// TODO add your handling code here:
		callMaxValue.setText( "" + callMaxSlider.getValue() );
	}// GEN-LAST:event_callMaxSliderStateChanged

	private void callRateSliderStateChanged( javax.swing.event.ChangeEvent evt ) {// GEN-FIRST:event_callRateSliderStateChanged
		// TODO add your handling code here:
		callRateValue.setText( "" + callRateSlider.getValue() );
	}// GEN-LAST:event_callRateSliderStateChanged

	private void beginEndButtonActionPerformed( java.awt.event.ActionEvent evt ) {// GEN-FIRST:event_beginEndButtonActionPerformed
		// TODO add your handling code here:
		if ( beginEndButton.isSelected() ) {
			open();
		} else {
			close();
		}
	}// GEN-LAST:event_beginEndButtonActionPerformed

	private void logTextCaretUpdate( javax.swing.event.CaretEvent evt ) {// GEN-FIRST:event_logTextCaretUpdate
		// TODO add your handling code here:
	}// GEN-LAST:event_logTextCaretUpdate

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel aboutLabel;
	private javax.swing.JPanel aboutPanel;
	private static javax.swing.JToggleButton beginEndButton;
	private javax.swing.JLabel callAcountLabel;
	public static javax.swing.JSlider callAcountSlider;
	private javax.swing.JTextField callAcountValue;
	private javax.swing.JLabel callMaxLabel;
	public static javax.swing.JSlider callMaxSlider;
	private javax.swing.JTextField callMaxValue;
	private javax.swing.JLabel callMobileLabel;
	public static javax.swing.JTextField callMobilePrefix;
	private static javax.swing.JLabel callMobileValidate;
	public static javax.swing.JTextField callMobileValue;
	private static javax.swing.JComboBox<CallOptionBean> callOptionComboBox;
	private javax.swing.JLabel callOptionLabel;
	public static javax.swing.JProgressBar callProgressBar;
	private javax.swing.JLabel callRateLabel;
	public static javax.swing.JSlider callRateSlider;
	private javax.swing.JTextField callRateValue;
	private javax.swing.JLabel connTimeLabel;
	public static javax.swing.JSlider connTimeSlider;
	private javax.swing.JTextField connTimeValue;
	private javax.swing.JPanel jPanel;
	private javax.swing.JTabbedPane jTabbedPanel;
	private javax.swing.JPanel logPanel;
	private javax.swing.JScrollPane logScrollPane;
	private javax.swing.JTextPane logText;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JPanel optionDetailPanel;
	private javax.swing.JScrollPane optionDetailScrollPane;
	private javax.swing.JTextPane optionDetailText;
	private javax.swing.JPanel queryPanel;
	private javax.swing.JPanel settingPanel;

	// End of variables declaration//GEN-END:variables

	private static CallExecutor callExecutor = null;

	public static void open() {
		String input = callMobileValue.getText();
		if ( StringUtils.isBlank( input ) ) {
			beginEndButton.setSelected( false );
			callMobileValidate.setText( "不能为空" );
		} else {
			callMobileValidate.setText( "" );
			beginEndButton.setText( "Ⅹ" );
			callExecutor = new CallExecutor( ( CallOptionBean ) callOptionComboBox.getSelectedItem() );
			callExecutor.mark = true;
			callExecutor.executor = Executors.newSingleThreadScheduledExecutor();
			callExecutor.executor.submit( callExecutor );
		}
	}

	public static void close() {
		beginEndButton.setSelected( false );
		beginEndButton.setText( "√" );
		callExecutor.mark = false;
	}

	public static void init() {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and
		 * feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
				if ( "Nimbus".equals( info.getName() ) ) {
					javax.swing.UIManager.setLookAndFeel( info.getClassName() );
					break;
				}
			}
		} catch ( ClassNotFoundException ex ) {
			java.util.logging.Logger.getLogger( CallFrame.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
		} catch ( InstantiationException ex ) {
			java.util.logging.Logger.getLogger( CallFrame.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
		} catch ( IllegalAccessException ex ) {
			java.util.logging.Logger.getLogger( CallFrame.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
		} catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
			java.util.logging.Logger.getLogger( CallFrame.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater( new Runnable() {
			public void run() {
				new CallFrame().setVisible( true );
			}
		} );
	}

}