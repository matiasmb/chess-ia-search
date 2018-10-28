/*
 * ChesseHorseView.java
 */

package chess_horse;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.util.*;


/**
 * The application's main frame.
 */

public class ChesseHorseView extends FrameView {
    static long timeStart;
    static int count = 0;
    public static int eroor, posBlack, posResult = 0;
    public static ArrayList <Integer> result = new  ArrayList();
    public static ArrayList <Integer> whiteHorses = new ArrayList ();
    static Timer timer;
    public ChesseHorseView(SingleFrameApplication app) {
        super(app);


       initComponents();
      
       jLabel17.setVisible(true);
    
       jLabel0023.setVisible(false);
       jLabel0014.setVisible(false);
       jLabel0048.setVisible(false);
       jLabel5.setVisible(false);
       jLabel6.setVisible(false);
       jLabel000.setVisible(false);
       jLabel002.setVisible(false);
       jLabel002.setVisible(false);
       jLabel004.setVisible(false);
       jLabel005.setVisible(false);
       jLabel006.setVisible(false);
       jLabel007.setVisible(false);
       jLabel008.setVisible(false);
       jLabel009.setVisible(false);
       jLabel0010.setVisible(false);
       jLabel0011.setVisible(false);
       jLabel0012.setVisible(false);
      

       // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    
    mainPanel.setComponentZOrder(Tablero,8);
     mainPanel.setComponentZOrder(jLabel11, 0);
     mainPanel.setComponentZOrder(jLabel19, 0);
    }
    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = ChessHorseApp.getApplication().getMainFrame();
            aboutBox = new ChesseHorseAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        ChessHorseApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Tablero = new javax.swing.JLabel();
        jLabel0023 = new javax.swing.JLabel();
        jLabel0048 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel0014 = new javax.swing.JLabel();
        jLabel000 = new javax.swing.JLabel();
        jLabel002 = new javax.swing.JLabel();
        jLabel004 = new javax.swing.JLabel();
        jLabel001 = new javax.swing.JLabel();
        jLabel003 = new javax.swing.JLabel();
        jLabel005 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel006 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel007 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel008 = new javax.swing.JLabel();
        jLabel0010 = new javax.swing.JLabel();
        jLabel0039 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel009 = new javax.swing.JLabel();
        jLabel0011 = new javax.swing.JLabel();
        jLabel0013 = new javax.swing.JLabel();
        jLabel0015 = new javax.swing.JLabel();
        jLabel0022 = new javax.swing.JLabel();
        jLabel0020 = new javax.swing.JLabel();
        jLabel0018 = new javax.swing.JLabel();
        jLabel0016 = new javax.swing.JLabel();
        jLabel0025 = new javax.swing.JLabel();
        jLabel0027 = new javax.swing.JLabel();
        jLabel0012 = new javax.swing.JLabel();
        jLabel0017 = new javax.swing.JLabel();
        jLabel0019 = new javax.swing.JLabel();
        jLabel0021 = new javax.swing.JLabel();
        jLabel0028 = new javax.swing.JLabel();
        jLabel0030 = new javax.swing.JLabel();
        jLabel0026 = new javax.swing.JLabel();
        jLabel0024 = new javax.swing.JLabel();
        jLabel0062 = new javax.swing.JLabel();
        jLabel0035 = new javax.swing.JLabel();
        jLabel0037 = new javax.swing.JLabel();
        jLabel0029 = new javax.swing.JLabel();
        jLabel0031 = new javax.swing.JLabel();
        jLabel0032 = new javax.swing.JLabel();
        jLabel0034 = new javax.swing.JLabel();
        jLabel0036 = new javax.swing.JLabel();
        jLabel0038 = new javax.swing.JLabel();
        jLabel0041 = new javax.swing.JLabel();
        jLabel0045 = new javax.swing.JLabel();
        jLabel0043 = new javax.swing.JLabel();
        jLabel0047 = new javax.swing.JLabel();
        jLabel0063 = new javax.swing.JLabel();
        jLabel0052 = new javax.swing.JLabel();
        jLabel0054 = new javax.swing.JLabel();
        jLabel0033 = new javax.swing.JLabel();
        jLabel0040 = new javax.swing.JLabel();
        jLabel0042 = new javax.swing.JLabel();
        jLabel0044 = new javax.swing.JLabel();
        jLabel0046 = new javax.swing.JLabel();
        jLabel0055 = new javax.swing.JLabel();
        jLabel0053 = new javax.swing.JLabel();
        jLabel0051 = new javax.swing.JLabel();
        jLabel0049 = new javax.swing.JLabel();
        jLabel0056 = new javax.swing.JLabel();
        jLabel0058 = new javax.swing.JLabel();
        jLabel0060 = new javax.swing.JLabel();
        jLabel0050 = new javax.swing.JLabel();
        jLabel0057 = new javax.swing.JLabel();
        jLabel0059 = new javax.swing.JLabel();
        jLabel0061 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem resetOption = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        buttonGroup1 = new javax.swing.ButtonGroup();

        mainPanel.setAlignmentX(0.0F);
        mainPanel.setAlignmentY(0.0F);
        mainPanel.setMaximumSize(new java.awt.Dimension(32000, 32000));
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(450, 300));
        mainPanel.setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(chess_horse.ChessHorseApp.class).getContext().getResourceMap(ChesseHorseView.class);
        jLabel11.setIcon(resourceMap.getIcon("jLabel11.icon")); // NOI18N
        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N
        mainPanel.add(jLabel11);
        jLabel11.setBounds(40, 0, 410, 50);

        jLabel19.setIcon(resourceMap.getIcon("jLabel19.icon")); // NOI18N
        jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N
        mainPanel.add(jLabel19);
        jLabel19.setBounds(10, 40, 40, 390);

        Tablero.setIcon(resourceMap.getIcon("Tablero.icon")); // NOI18N
        Tablero.setText(resourceMap.getString("Tablero.text")); // NOI18N
        Tablero.setName("Tablero"); // NOI18N
        Tablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TableroMouseEntered(evt);
            }
        });
        mainPanel.add(Tablero);
        Tablero.setBounds(10, 10, 450, 450);

        jLabel0023.setIcon(resourceMap.getIcon("jLabel0023.icon")); // NOI18N
        jLabel0023.setText(resourceMap.getString("jLabel0023.text")); // NOI18N
        jLabel0023.setName("jLabel0023"); // NOI18N
        jLabel0023.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0023);
        jLabel0023.setBounds(379, 142, 44, 44);

        jLabel0048.setIcon(resourceMap.getIcon("jLabel0048.icon")); // NOI18N
        jLabel0048.setText(resourceMap.getString("jLabel0048.text")); // NOI18N
        jLabel0048.setName("jLabel0048"); // NOI18N
        jLabel0048.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0048);
        jLabel0048.setBounds(50, 330, 40, 50);

        jLabel5.setIcon(resourceMap.getIcon("jLabel5.icon")); // NOI18N
        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setToolTipText(resourceMap.getString("jLabel5.toolTipText")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        mainPanel.add(jLabel5);
        jLabel5.setBounds(370, 220, 33, 30);

        jLabel6.setIcon(resourceMap.getIcon("jLabel6.icon")); // NOI18N
        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        mainPanel.add(jLabel6);
        jLabel6.setBounds(350, 270, 33, 32);

        jLabel0014.setIcon(resourceMap.getIcon("icon")); // NOI18N
        jLabel0014.setText(resourceMap.getString("text")); // NOI18N
        jLabel0014.setName(""); // NOI18N
        mainPanel.add(jLabel0014);
        jLabel0014.setBounds(340, 100, 40, 40);

        jLabel000.setIcon(resourceMap.getIcon("jLabel000.icon")); // NOI18N
        jLabel000.setName("jLabel000"); // NOI18N
        jLabel000.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel000);
        jLabel000.setBounds(50, 50, 40, 37);

        jLabel002.setIcon(resourceMap.getIcon("jLabel002.icon")); // NOI18N
        jLabel002.setName("jLabel002"); // NOI18N
        jLabel002.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel002);
        jLabel002.setBounds(150, 50, 40, 37);

        jLabel004.setIcon(resourceMap.getIcon("jLabel004.icon")); // NOI18N
        jLabel004.setName("jLabel004"); // NOI18N
        jLabel004.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel004);
        jLabel004.setBounds(240, 50, 40, 37);

        jLabel001.setIcon(resourceMap.getIcon("jLabel001.icon")); // NOI18N
        jLabel001.setName("jLabel001"); // NOI18N
        mainPanel.add(jLabel001);
        jLabel001.setBounds(100, 50, 40, 40);

        jLabel003.setIcon(resourceMap.getIcon("jLabel003.icon")); // NOI18N
        jLabel003.setName("jLabel003"); // NOI18N
        mainPanel.add(jLabel003);
        jLabel003.setBounds(196, 50, 47, 40);

        jLabel005.setIcon(resourceMap.getIcon("jLabel005.icon")); // NOI18N
        jLabel005.setName("jLabel005"); // NOI18N
        mainPanel.add(jLabel005);
        jLabel005.setBounds(290, 50, 40, 40);

        label1.setFont(resourceMap.getFont("Colocar piezas.font")); // NOI18N
        label1.setName("Colocar piezas"); // NOI18N
        label1.setText(resourceMap.getString("Colocar piezas.text")); // NOI18N
        mainPanel.add(label1);
        label1.setBounds(580, 10, 120, 21);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel1.border.titleFont"), resourceMap.getColor("jPanel1.border.titleColor"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jRadioButton3.setText(resourceMap.getString("jRadioButton3.text")); // NOI18N
        jRadioButton3.setName("jRadioButton3"); // NOI18N
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });

        jRadioButton4.setText(resourceMap.getString("jRadioButton4.text")); // NOI18N
        jRadioButton4.setName("jRadioButton4"); // NOI18N
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButton2)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel1);
        jPanel1.setBounds(480, 40, 300, 157);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel2.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel2.border.titleFont"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jRadioButton1.setText(resourceMap.getString("jRadioButton1.text")); // NOI18N
        jRadioButton1.setName("jRadioButton1"); // NOI18N
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        jRadioButton2.setText(resourceMap.getString("jRadioButton2.text")); // NOI18N
        jRadioButton2.setName("jRadioButton2"); // NOI18N
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton3)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jRadioButton1)
                            .addGap(9, 9, 9)))
                    .addComponent(jRadioButton2))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addGap(24, 24, 24)
                .addComponent(jButton3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel2);
        jPanel2.setBounds(480, 200, 142, 159);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel3.border.titleFont"))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(null);

        jRadioButton5.setText(resourceMap.getString("jRadioButton5.text")); // NOI18N
        jRadioButton5.setName("jRadioButton5"); // NOI18N
        jRadioButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton5MouseClicked(evt);
            }
        });
        jPanel3.add(jRadioButton5);
        jRadioButton5.setBounds(22, 58, 88, 23);

        jRadioButton6.setText(resourceMap.getString("jRadioButton6.text")); // NOI18N
        jRadioButton6.setName("jRadioButton6"); // NOI18N
        jRadioButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButton6MousePressed(evt);
            }
        });
        jRadioButton6.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jRadioButton6AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.add(jRadioButton6);
        jRadioButton6.setBounds(23, 91, 47, 23);

        jRadioButton7.setText(resourceMap.getString("jRadioButton7.text")); // NOI18N
        jRadioButton7.setName("jRadioButton7"); // NOI18N
        jRadioButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton7MouseClicked(evt);
            }
        });
        jPanel3.add(jRadioButton7);
        jRadioButton7.setBounds(22, 26, 133, 23);

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(140, 170, 119, 29);

        jTextField2.setText(resourceMap.getString("jTextField2.text")); // NOI18N
        jTextField2.setName("jTextField2"); // NOI18N
        jPanel3.add(jTextField2);
        jTextField2.setBounds(270, 20, 51, 26);

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        jPanel3.add(jLabel8);
        jLabel8.setBounds(155, 29, 100, 17);

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N
        jPanel3.add(jLabel15);
        jLabel15.setBounds(334, 58, 69, 20);

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setToolTipText(resourceMap.getString("jLabel17.toolTipText")); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel17.setName("jLabel17"); // NOI18N
        jPanel3.add(jLabel17);
        jLabel17.setBounds(10, 120, 370, 40);

        mainPanel.add(jPanel3);
        jPanel3.setBounds(480, 370, 390, 210);

        jLabel006.setIcon(resourceMap.getIcon("jLabel006.icon")); // NOI18N
        jLabel006.setName("jLabel006"); // NOI18N
        jLabel006.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel006);
        jLabel006.setBounds(340, 50, 40, 37);

        jLabel9.setIcon(resourceMap.getIcon("jLabel9.icon")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        jLabel9.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel9);
        jLabel9.setBounds(240, 50, 40, 37);

        jLabel10.setIcon(resourceMap.getIcon("jLabel10.icon")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel10);
        jLabel10.setBounds(150, 50, 40, 37);

        jLabel007.setIcon(resourceMap.getIcon("jLabel007.icon")); // NOI18N
        jLabel007.setName("jLabel007"); // NOI18N
        mainPanel.add(jLabel007);
        jLabel007.setBounds(380, 50, 40, 40);

        jLabel12.setIcon(resourceMap.getIcon("jLabel12.icon")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N
        mainPanel.add(jLabel12);
        jLabel12.setBounds(290, 50, 40, 40);

        jLabel13.setIcon(resourceMap.getIcon("jLabel13.icon")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N
        mainPanel.add(jLabel13);
        jLabel13.setBounds(200, 50, 40, 40);

        jLabel14.setIcon(resourceMap.getIcon("jLabel14.icon")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N
        mainPanel.add(jLabel14);
        jLabel14.setBounds(100, 50, 40, 40);

        jLabel008.setIcon(resourceMap.getIcon("jLabel008.icon")); // NOI18N
        jLabel008.setName("jLabel008"); // NOI18N
        mainPanel.add(jLabel008);
        jLabel008.setBounds(50, 100, 40, 40);

        jLabel0010.setIcon(resourceMap.getIcon("jLabel0010.icon")); // NOI18N
        jLabel0010.setName("jLabel0010"); // NOI18N
        mainPanel.add(jLabel0010);
        jLabel0010.setBounds(150, 100, 40, 40);

        jLabel0039.setIcon(resourceMap.getIcon("jLabel0039.icon")); // NOI18N
        jLabel0039.setName("jLabel0039"); // NOI18N
        mainPanel.add(jLabel0039);
        jLabel0039.setBounds(380, 240, 40, 40);

        jLabel18.setIcon(resourceMap.getIcon("jLabel18.icon")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N
        jLabel18.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel18);
        jLabel18.setBounds(50, 50, 40, 37);

        jLabel009.setIcon(resourceMap.getIcon("jLabel009.icon")); // NOI18N
        jLabel009.setName("jLabel009"); // NOI18N
        jLabel009.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel009);
        jLabel009.setBounds(100, 100, 40, 37);

        jLabel0011.setIcon(resourceMap.getIcon("jLabel0011.icon")); // NOI18N
        jLabel0011.setName("jLabel0011"); // NOI18N
        jLabel0011.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0011);
        jLabel0011.setBounds(200, 100, 40, 37);

        jLabel0013.setIcon(resourceMap.getIcon("jLabel0013.icon")); // NOI18N
        jLabel0013.setName("jLabel0013"); // NOI18N
        jLabel0013.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0013);
        jLabel0013.setBounds(290, 100, 40, 37);

        jLabel0015.setIcon(resourceMap.getIcon("jLabel0015.icon")); // NOI18N
        jLabel0015.setName("jLabel0015"); // NOI18N
        jLabel0015.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0015);
        jLabel0015.setBounds(380, 100, 40, 37);

        jLabel0022.setIcon(resourceMap.getIcon("jLabel0022.icon")); // NOI18N
        jLabel0022.setName("jLabel0022"); // NOI18N
        jLabel0022.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0022);
        jLabel0022.setBounds(340, 147, 40, 40);

        jLabel0020.setIcon(resourceMap.getIcon("jLabel0020.icon")); // NOI18N
        jLabel0020.setName("jLabel0020"); // NOI18N
        jLabel0020.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0020);
        jLabel0020.setBounds(240, 147, 40, 40);

        jLabel0018.setIcon(resourceMap.getIcon("jLabel0018.icon")); // NOI18N
        jLabel0018.setName("jLabel0018"); // NOI18N
        jLabel0018.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0018);
        jLabel0018.setBounds(150, 147, 40, 40);

        jLabel0016.setIcon(resourceMap.getIcon("jLabel0016.icon")); // NOI18N
        jLabel0016.setName("jLabel0016"); // NOI18N
        jLabel0016.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0016);
        jLabel0016.setBounds(50, 147, 40, 40);

        jLabel0025.setIcon(resourceMap.getIcon("jLabel0025.icon")); // NOI18N
        jLabel0025.setName("jLabel0025"); // NOI18N
        jLabel0025.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0025);
        jLabel0025.setBounds(100, 190, 40, 40);

        jLabel0027.setIcon(resourceMap.getIcon("jLabel0027.icon")); // NOI18N
        jLabel0027.setName("jLabel0027"); // NOI18N
        jLabel0027.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0027);
        jLabel0027.setBounds(200, 187, 40, 50);

        jLabel0012.setIcon(resourceMap.getIcon("jLabel0012.icon")); // NOI18N
        jLabel0012.setName("jLabel0012"); // NOI18N
        mainPanel.add(jLabel0012);
        jLabel0012.setBounds(240, 100, 40, 40);

        jLabel0017.setIcon(resourceMap.getIcon("jLabel0017.icon")); // NOI18N
        jLabel0017.setName("jLabel0017"); // NOI18N
        mainPanel.add(jLabel0017);
        jLabel0017.setBounds(100, 140, 40, 50);

        jLabel0019.setIcon(resourceMap.getIcon("jLabel0019.icon")); // NOI18N
        jLabel0019.setName("jLabel0019"); // NOI18N
        mainPanel.add(jLabel0019);
        jLabel0019.setBounds(200, 140, 40, 50);

        jLabel0021.setIcon(resourceMap.getIcon("jLabel0021.icon")); // NOI18N
        jLabel0021.setName("jLabel0021"); // NOI18N
        mainPanel.add(jLabel0021);
        jLabel0021.setBounds(290, 140, 40, 50);

        jLabel0028.setIcon(resourceMap.getIcon("jLabel0028.icon")); // NOI18N
        jLabel0028.setName("jLabel0028"); // NOI18N
        mainPanel.add(jLabel0028);
        jLabel0028.setBounds(240, 190, 40, 50);

        jLabel0030.setIcon(resourceMap.getIcon("jLabel0030.icon")); // NOI18N
        jLabel0030.setName("jLabel0030"); // NOI18N
        mainPanel.add(jLabel0030);
        jLabel0030.setBounds(340, 190, 40, 50);

        jLabel0026.setIcon(resourceMap.getIcon("jLabel0026.icon")); // NOI18N
        jLabel0026.setName("jLabel0026"); // NOI18N
        mainPanel.add(jLabel0026);
        jLabel0026.setBounds(150, 190, 40, 40);

        jLabel0024.setIcon(resourceMap.getIcon("jLabel0024.icon")); // NOI18N
        jLabel0024.setName("jLabel0024"); // NOI18N
        mainPanel.add(jLabel0024);
        jLabel0024.setBounds(50, 190, 40, 40);

        jLabel0062.setIcon(resourceMap.getIcon("jLabel0062.icon")); // NOI18N
        jLabel0062.setName("jLabel0062"); // NOI18N
        mainPanel.add(jLabel0062);
        jLabel0062.setBounds(330, 380, 50, 50);

        jLabel0035.setIcon(resourceMap.getIcon("jLabel0035.icon")); // NOI18N
        jLabel0035.setName("jLabel0035"); // NOI18N
        mainPanel.add(jLabel0035);
        jLabel0035.setBounds(200, 240, 40, 40);

        jLabel0037.setIcon(resourceMap.getIcon("jLabel0037.icon")); // NOI18N
        jLabel0037.setName("jLabel0037"); // NOI18N
        mainPanel.add(jLabel0037);
        jLabel0037.setBounds(290, 240, 40, 40);

        jLabel0029.setIcon(resourceMap.getIcon("jLabel0029.icon")); // NOI18N
        jLabel0029.setName("jLabel0029"); // NOI18N
        jLabel0029.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0029);
        jLabel0029.setBounds(290, 193, 40, 44);

        jLabel0031.setIcon(resourceMap.getIcon("jLabel0031.icon")); // NOI18N
        jLabel0031.setName("jLabel0031"); // NOI18N
        jLabel0031.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0031);
        jLabel0031.setBounds(380, 187, 40, 50);

        jLabel0032.setIcon(resourceMap.getIcon("jLabel0032.icon")); // NOI18N
        jLabel0032.setName("jLabel0032"); // NOI18N
        jLabel0032.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0032);
        jLabel0032.setBounds(50, 240, 40, 37);

        jLabel0034.setIcon(resourceMap.getIcon("jLabel0034.icon")); // NOI18N
        jLabel0034.setName("jLabel0034"); // NOI18N
        jLabel0034.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0034);
        jLabel0034.setBounds(150, 240, 40, 37);

        jLabel0036.setIcon(resourceMap.getIcon("jLabel0036.icon")); // NOI18N
        jLabel0036.setName("jLabel0036"); // NOI18N
        jLabel0036.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0036);
        jLabel0036.setBounds(240, 240, 40, 37);

        jLabel0038.setIcon(resourceMap.getIcon("jLabel0038.icon")); // NOI18N
        jLabel0038.setName("jLabel0038"); // NOI18N
        jLabel0038.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0038);
        jLabel0038.setBounds(340, 240, 40, 37);

        jLabel0041.setIcon(resourceMap.getIcon("jLabel0041.icon")); // NOI18N
        jLabel0041.setName("jLabel0041"); // NOI18N
        jLabel0041.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0041);
        jLabel0041.setBounds(100, 290, 40, 37);

        jLabel0045.setIcon(resourceMap.getIcon("jLabel0045.icon")); // NOI18N
        jLabel0045.setName("jLabel0045"); // NOI18N
        jLabel0045.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0045);
        jLabel0045.setBounds(290, 290, 40, 37);

        jLabel0043.setIcon(resourceMap.getIcon("jLabel0043.icon")); // NOI18N
        jLabel0043.setName("jLabel0043"); // NOI18N
        jLabel0043.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0043);
        jLabel0043.setBounds(194, 290, 40, 37);

        jLabel0047.setIcon(resourceMap.getIcon("jLabel0047.icon")); // NOI18N
        jLabel0047.setName("jLabel0047"); // NOI18N
        jLabel0047.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0047);
        jLabel0047.setBounds(380, 290, 40, 37);

        jLabel0063.setIcon(resourceMap.getIcon("jLabel0063.icon")); // NOI18N
        jLabel0063.setName("jLabel0063"); // NOI18N
        jLabel0063.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0063);
        jLabel0063.setBounds(380, 374, 40, 50);

        jLabel0052.setIcon(resourceMap.getIcon("jLabel0052.icon")); // NOI18N
        jLabel0052.setName("jLabel0052"); // NOI18N
        jLabel0052.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0052);
        jLabel0052.setBounds(240, 330, 40, 44);

        jLabel0054.setIcon(resourceMap.getIcon("jLabel0054.icon")); // NOI18N
        jLabel0054.setName("jLabel0054"); // NOI18N
        jLabel0054.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0054);
        jLabel0054.setBounds(330, 330, 50, 50);

        jLabel0033.setIcon(resourceMap.getIcon("jLabel0033.icon")); // NOI18N
        jLabel0033.setName("jLabel0033"); // NOI18N
        mainPanel.add(jLabel0033);
        jLabel0033.setBounds(100, 240, 40, 40);

        jLabel0040.setIcon(resourceMap.getIcon("jLabel0040.icon")); // NOI18N
        jLabel0040.setName("jLabel0040"); // NOI18N
        mainPanel.add(jLabel0040);
        jLabel0040.setBounds(50, 280, 40, 50);

        jLabel0042.setIcon(resourceMap.getIcon("jLabel0042.icon")); // NOI18N
        jLabel0042.setName("jLabel0042"); // NOI18N
        mainPanel.add(jLabel0042);
        jLabel0042.setBounds(140, 280, 50, 50);

        jLabel0044.setIcon(resourceMap.getIcon("jLabel0044.icon")); // NOI18N
        jLabel0044.setName("jLabel0044"); // NOI18N
        mainPanel.add(jLabel0044);
        jLabel0044.setBounds(240, 285, 40, 45);

        jLabel0046.setIcon(resourceMap.getIcon("jLabel0046.icon")); // NOI18N
        jLabel0046.setName("jLabel0046"); // NOI18N
        mainPanel.add(jLabel0046);
        jLabel0046.setBounds(330, 285, 50, 45);

        jLabel0055.setIcon(resourceMap.getIcon("jLabel0055.icon")); // NOI18N
        jLabel0055.setName("jLabel0055"); // NOI18N
        mainPanel.add(jLabel0055);
        jLabel0055.setBounds(380, 330, 40, 50);

        jLabel0053.setIcon(resourceMap.getIcon("jLabel0053.icon")); // NOI18N
        jLabel0053.setName("jLabel0053"); // NOI18N
        mainPanel.add(jLabel0053);
        jLabel0053.setBounds(290, 330, 40, 50);

        jLabel0051.setIcon(resourceMap.getIcon("jLabel0051.icon")); // NOI18N
        jLabel0051.setName("jLabel0051"); // NOI18N
        mainPanel.add(jLabel0051);
        jLabel0051.setBounds(192, 330, 40, 50);

        jLabel0049.setIcon(resourceMap.getIcon("jLabel0049.icon")); // NOI18N
        jLabel0049.setName("jLabel0049"); // NOI18N
        mainPanel.add(jLabel0049);
        jLabel0049.setBounds(93, 330, 47, 50);

        jLabel0056.setIcon(resourceMap.getIcon("jLabel0056.icon")); // NOI18N
        jLabel0056.setName("jLabel0056"); // NOI18N
        mainPanel.add(jLabel0056);
        jLabel0056.setBounds(50, 380, 40, 50);

        jLabel0058.setIcon(resourceMap.getIcon("jLabel0058.icon")); // NOI18N
        jLabel0058.setName("jLabel0058"); // NOI18N
        mainPanel.add(jLabel0058);
        jLabel0058.setBounds(143, 380, 47, 50);

        jLabel0060.setIcon(resourceMap.getIcon("jLabel0060.icon")); // NOI18N
        jLabel0060.setName("jLabel0060"); // NOI18N
        mainPanel.add(jLabel0060);
        jLabel0060.setBounds(240, 380, 40, 50);

        jLabel0050.setIcon(resourceMap.getIcon("jLabel0050.icon")); // NOI18N
        jLabel0050.setName("jLabel0050"); // NOI18N
        jLabel0050.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0050);
        jLabel0050.setBounds(150, 330, 40, 50);

        jLabel0057.setIcon(resourceMap.getIcon("jLabel0057.icon")); // NOI18N
        jLabel0057.setName("jLabel0057"); // NOI18N
        jLabel0057.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0057);
        jLabel0057.setBounds(100, 380, 40, 44);

        jLabel0059.setIcon(resourceMap.getIcon("jLabel0059.icon")); // NOI18N
        jLabel0059.setName("jLabel0059"); // NOI18N
        jLabel0059.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0059);
        jLabel0059.setBounds(190, 380, 44, 50);

        jLabel0061.setIcon(resourceMap.getIcon("jLabel0061.icon")); // NOI18N
        jLabel0061.setName("jLabel0061"); // NOI18N
        jLabel0061.setPreferredSize(new java.awt.Dimension(44, 44));
        mainPanel.add(jLabel0061);
        jLabel0061.setBounds(286, 380, 44, 44);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        mainPanel.add(jLabel2);
        jLabel2.setBounds(50, 470, 400, 30);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        mainPanel.add(jLabel4);
        jLabel4.setBounds(50, 510, 410, 20);

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        mainPanel.add(jLabel7);
        jLabel7.setBounds(50, 550, 410, 20);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(5);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        mainPanel.add(jScrollPane1);
        jScrollPane1.setBounds(880, 380, 100, 170);

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(chess_horse.ChessHorseApp.class).getContext().getActionMap(ChesseHorseView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        resetOption.setText(resourceMap.getString("resetOption.text")); // NOI18N
        resetOption.setToolTipText(resourceMap.getString("resetOption.toolTipText")); // NOI18N
        resetOption.setName("resetOption"); // NOI18N
        resetOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetOptionActionPerformed(evt);
            }
        });
        fileMenu.add(resetOption);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 861, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents
private void drawBlack(int x,int y, int u, int p){
x=(((x-37)/47)*47)+37+15;   //todo esto es para situar correctamente la pieza, independientemente de donde se cliquee dentro de un cuadrado, la ubicacion de la pieza debe encajar correctamente
    y=(((y-37)/47)*47)+57;   //coordenadas del centro de la pieza a situar
    if ((u+p)%2==0 )  //colocar caballo negro en casillero marron claro o "par"
    { mainPanel.setComponentZOrder(jLabel6,0) ; jLabel6.setLocation(x,y)  ; jLabel6.setVisible(true);jLabel5.setVisible(false);}
    else {  mainPanel.setComponentZOrder(jLabel5,0) ; jLabel5.setLocation(x,y)  ; jLabel5.setVisible(true); jLabel6.setVisible(false); }
   posBlack= (p*8)+u;
   System.out.println(posBlack);


mainPanel.repaint();
}
private void pintarblancos(int u, int p){{if(p==0){
    if(u==0 ) {if (jLabel000.isVisible()){jLabel000.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==0)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel000,0);jLabel000.setVisible(true);whiteHorses.add(0);} } else
   if(u==1 ) {if (jLabel001.isVisible()){jLabel001.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==1)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel001,0);jLabel001.setVisible(true);whiteHorses.add(1);} } else
   if(u==2 ) {if (jLabel002.isVisible()){jLabel002.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==2)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel002,0);jLabel002.setVisible(true);whiteHorses.add(2);} } else
   if(u==3 ) {if (jLabel003.isVisible()){jLabel003.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==3)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel003,0);jLabel003.setVisible(true);whiteHorses.add(3);} } else
  if(u==4 ) {if (jLabel004.isVisible()){jLabel004.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==4)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel004,0);jLabel004.setVisible(true);whiteHorses.add(4);} } else
   if(u==5 ) {if (jLabel005.isVisible()){jLabel005.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==5)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel005,0);jLabel005.setVisible(true);whiteHorses.add(5);} } else
   if(u==6 ) {if (jLabel006.isVisible()){jLabel006.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==6)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel006,0);jLabel006.setVisible(true);whiteHorses.add(6);} } else
   if(u==7 ) {if (jLabel007.isVisible()){jLabel007.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==7)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel007,0);jLabel007.setVisible(true);whiteHorses.add(7);} }
     } else
    if(p==1){
    if(u==0 ) {if (jLabel008.isVisible()){jLabel008.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==8)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel008,0);jLabel008.setVisible(true);whiteHorses.add(8);} } else
   if(u==1 ) {if (jLabel009.isVisible()){jLabel009.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==9)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel009,0);jLabel009.setVisible(true);whiteHorses.add(9);} } else
   if(u==2 ) {if (jLabel0010.isVisible()){jLabel0010.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==10)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0010,0);jLabel0010.setVisible(true);whiteHorses.add(10);} } else
   if(u==3) {if (jLabel0011.isVisible()){jLabel0011.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==11)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0011,0);jLabel0011.setVisible(true);whiteHorses.add(11);} } else
if(u==4 ){if (jLabel0012.isVisible()){jLabel0012.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==12)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0012,0);jLabel0012.setVisible(true);whiteHorses.add(12);} } else
   if(u==5 ){if (jLabel0013.isVisible()){jLabel0013.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==13)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0013,0);jLabel0013.setVisible(true);whiteHorses.add(13);} } else
   if(u==6 ) {if (jLabel0014.isVisible()){jLabel0014.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==14)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0014,0);jLabel0014.setVisible(true);whiteHorses.add(14);} } else
   if(u==7 ) {if (jLabel0015.isVisible()){jLabel0015.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==15)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0015,0);jLabel0015.setVisible(true);whiteHorses.add(15);} }
    }else
    if(p==2){
    if(u==0 ) {if (jLabel0016.isVisible()){jLabel0016.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==16)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0016,0);jLabel0016.setVisible(true);whiteHorses.add(16);} } else
   if(u==1 ) {if (jLabel0017.isVisible()){jLabel0017.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==17)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0017,0);jLabel0017.setVisible(true);whiteHorses.add(17);} } else
   if(u==2 ) {if (jLabel0018.isVisible()){jLabel0018.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==18)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0018,0);jLabel0018.setVisible(true);whiteHorses.add(18);} } else
   if(u==3 ) {if (jLabel0019.isVisible()){jLabel0019.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==19)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0019,0);jLabel0019.setVisible(true);whiteHorses.add(19);} } else
 if(u==4 ) {if (jLabel0020.isVisible()){jLabel0020.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==20)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0020,0);jLabel0020.setVisible(true);whiteHorses.add(20);} } else
   if(u==5) {if (jLabel0021.isVisible()){jLabel0021.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==21)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0021,0);jLabel0021.setVisible(true);whiteHorses.add(21);} } else
   if(u==6 ) {if (jLabel0022.isVisible()){jLabel0022.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==22)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0022,0);jLabel0022.setVisible(true);whiteHorses.add(22);} } else
 if(u==7 ) {if (jLabel0023.isVisible()){jLabel0023.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==23)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0023,0);jLabel0023.setVisible(true);whiteHorses.add(23);} }
    }else
    if(p==3){
    if(u==0 ) {if (jLabel0024.isVisible()){jLabel0024.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==24)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0024,0);jLabel0024.setVisible(true);whiteHorses.add(24);} } else
   if(u==1 ) {if (jLabel0025.isVisible()){jLabel0025.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==25)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0025,0);jLabel0025.setVisible(true);whiteHorses.add(25);} } else
 if(u==2 ) {if (jLabel0026.isVisible()){jLabel0026.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==26)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0026,0);jLabel0026.setVisible(true);whiteHorses.add(26);} } else
   if(u==3 ) {if (jLabel0027.isVisible()){jLabel0027.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==27)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0027,0);jLabel0027.setVisible(true);whiteHorses.add(27);} } else
   if(u==4 ) {if (jLabel0028.isVisible()){jLabel0028.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==280)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0028,0);jLabel0028.setVisible(true);whiteHorses.add(28);} } else
 if(u==5 ) {if (jLabel0029.isVisible()){jLabel0029.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==29)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0029,0);jLabel0029.setVisible(true);whiteHorses.add(29);} } else
   if(u==6 ){if (jLabel0030.isVisible()){jLabel0030.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==30)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0030,0);jLabel0030.setVisible(true);whiteHorses.add(30);} } else
   if(u==7) {if (jLabel0031.isVisible()){jLabel0031.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==31)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0031,0);jLabel0031.setVisible(true);whiteHorses.add(31);} }
    }else
     if(p==4){
    if(u==0 ) {if (jLabel0032.isVisible()){jLabel0032.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==32)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0032,0);jLabel0032.setVisible(true);whiteHorses.add(32);} } else
   if(u==1 ) {if (jLabel0033.isVisible()){jLabel0033.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==33)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0033,0);jLabel0033.setVisible(true);whiteHorses.add(33);} } else
   if(u==2){if (jLabel0034.isVisible()){jLabel0034.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==34)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0034,0);jLabel0034.setVisible(true);whiteHorses.add(34);} } else
    if(u==3) {if (jLabel0035.isVisible()){jLabel0035.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==35)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0035,0);jLabel0035.setVisible(true);whiteHorses.add(35);} } else



   if(u==4 ) {if (jLabel0036.isVisible()){jLabel0036.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==36)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0036,0);jLabel0036.setVisible(true);whiteHorses.add(36);} } else
   if(u==5) {if (jLabel0037.isVisible()){jLabel0037.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==37)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0037,0);jLabel0037.setVisible(true);whiteHorses.add(37);} } else
    if(u==6 ) {if (jLabel0038.isVisible()){jLabel0038.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==38)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0038,0);jLabel0038.setVisible(true);whiteHorses.add(38);} } else
   if(u==7){if (jLabel0039.isVisible()){jLabel0039.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==39)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0039,0);jLabel0039.setVisible(true);whiteHorses.add(39);} }
     }else
       if (p==5){
    if(u==0 ) {if (jLabel0040.isVisible()){jLabel0040.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==40)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0040,0);jLabel0040.setVisible(true);whiteHorses.add(40);} } else
    if(u==1 ) {if (jLabel0041.isVisible()){jLabel0041.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==41)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0041,0);jLabel0041.setVisible(true);whiteHorses.add(41);} } else
   if(u==2 ) {if (jLabel0042.isVisible()){jLabel0042.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==42)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0042,0);jLabel0042.setVisible(true);whiteHorses.add(42);} } else
   if(u==3) {if (jLabel0043.isVisible()){jLabel0043.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==43)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0043,0);jLabel0043.setVisible(true);whiteHorses.add(43);} } else
    if(u==4 ) {if (jLabel0044.isVisible()){jLabel0044.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==44)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0044,0);jLabel0044.setVisible(true);whiteHorses.add(44);} } else
   if(u==5  ){if (jLabel0045.isVisible()){jLabel0045.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==45)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0045,0);jLabel0045.setVisible(true);whiteHorses.add(45);} } else
   if(u==6 ) {if (jLabel0046.isVisible()){jLabel0046.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==46)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0046,0);jLabel0046.setVisible(true);whiteHorses.add(46);} } else
    if(u==7 ) {if (jLabel0047.isVisible()){jLabel0047.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==47)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0047,0);jLabel0047.setVisible(true);whiteHorses.add(47);} }
       }else
    if (p==6){
    if(u==0 ) {if (jLabel0048.isVisible()){jLabel0048.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==48)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0048,0);jLabel0048.setVisible(true);whiteHorses.add(48);} } else
   if(u==1 ) {if (jLabel0049.isVisible()){jLabel0049.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==49)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0049,0);jLabel0049.setVisible(true);whiteHorses.add(49);} } else

    if(u==2 ) {if (jLabel0050.isVisible()){jLabel0050.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==50)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0050,0);jLabel0050.setVisible(true);whiteHorses.add(50);} } else
   if(u==3 ){if (jLabel0051.isVisible()){jLabel0051.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==51)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0051,0);jLabel0051.setVisible(true);whiteHorses.add(51);} } else
   if(u==4 ) {if (jLabel0052.isVisible()){jLabel0052.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==52)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0052,0);jLabel0052.setVisible(true);whiteHorses.add(52);} } else
    if(u==5 ) {if (jLabel0053.isVisible()){jLabel0053.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==53)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0053,0);jLabel0053.setVisible(true);whiteHorses.add(53);} } else
   if(u==6 ) {if (jLabel0054.isVisible()){jLabel0054.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==54)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0054,0);jLabel0054.setVisible(true);whiteHorses.add(54);} } else
   if(u==7 ) {if (jLabel0055.isVisible()){jLabel0055.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==55)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0055,0);jLabel0055.setVisible(true);whiteHorses.add(55);} }
    }else
      if(p==7){
    if(u==0 ) {if (jLabel0056.isVisible()){jLabel0056.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==56)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0056,0);jLabel0056.setVisible(true);whiteHorses.add(56);} } else
   if(u==1 ) {if (jLabel0057.isVisible()){jLabel0057.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==57)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0057,0);jLabel0057.setVisible(true);whiteHorses.add(57);} } else
   if(u==2 ) {if (jLabel0058.isVisible()){jLabel0058.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==58)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0058,0);jLabel0058.setVisible(true);whiteHorses.add(58);} } else
if(u==3 ) {if (jLabel0059.isVisible()){jLabel0059.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==59)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0059,0);jLabel0059.setVisible(true);whiteHorses.add(59);} } else
   if(u==4 ) {if (jLabel0060.isVisible()){jLabel0060.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==60)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0060,0);jLabel0060.setVisible(true);whiteHorses.add(60);} } else
   if(u==5 ) {if (jLabel0061.isVisible()){jLabel0061.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==61)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0061,0);jLabel0061.setVisible(true);whiteHorses.add(61);} } else
if(u==6 ) {if (jLabel0062.isVisible()){jLabel0062.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==62)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0062,0);jLabel0062.setVisible(true);whiteHorses.add(62);} } else
   if(u==7 ) {if (jLabel0063.isVisible()){jLabel0063.setVisible(false);for (int m=0;m<whiteHorses.size();m++){if (whiteHorses.get(m)==63)whiteHorses.remove(m); }}else {mainPanel.setComponentZOrder(jLabel0063,0);jLabel0063.setVisible(true);whiteHorses.add(63);} }
      }


}
mainPanel.repaint();




}


    private void TableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableroMouseClicked

  int x=evt.getX();
  int y=evt.getY();
  int u=(x-37)/47;    //se empieza a enumerar desde la posicion 0
  int p=(y-37)/47;
  int posi=(p*8)+u;
  if (jRadioButton1.isSelected() & !jRadioButton3.isSelected() & u!=8 & p!=8 & !whiteHorses.contains(posi)) drawBlack(x,y,u,p);
if (jRadioButton3.isSelected() & !jRadioButton1.isSelected())
{ pintarblancos(u,p);
}
    }//GEN-LAST:event_TableroMouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked

        jRadioButton2.setSelected(false);
      jRadioButton1.setSelected(false);
      jRadioButton4.setSelected(false);

        if (jRadioButton4.isSelected())jRadioButton4.setSelected(false);
     eroor = 1;//poner caballos blancos
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
jRadioButton2.setSelected(false);
      jRadioButton3.setSelected(false);
      jRadioButton1.setSelected(false); 
        if (jRadioButton3.isSelected()) jRadioButton3.setSelected(false);
   eroor = 0;//poner caballos negros
    }//GEN-LAST:event_jRadioButton4MouseClicked


    void marcarlahora(){
 timeStart=System.currentTimeMillis();
     timer = new Timer (100, new ActionListener ()
{
    public void actionPerformed(ActionEvent e)
    {
      long g=System.currentTimeMillis()-timeStart; // Aquí el código que queramos ejecutar.
      jLabel2.setText(String.valueOf(g));
    }
        });
    timer.start();}
 
 



    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
     
      jRadioButton2.setSelected(false);
      jRadioButton3.setSelected(false);
      jRadioButton4.setSelected(false);
     // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
     jRadioButton1.setSelected(false);
      jRadioButton3.setSelected(false);
      jRadioButton4.setSelected(false);   // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

      if (posResult<result.size()){
    
      int i=(result.get(posResult)-((result.get(posResult)/8)*8))*47+52;   //coordenadas del vertice de la pieza a situar
      int j=((result.get(posResult)/8)*47)+52;
      System.out.println(i);
      System.out.println(j);
     //coordenadas del centro de la pieza a situar
      {if (((result.get(posResult)-((result.get(posResult)/8)*8))+(result.get(posResult)/8)) %2 ==0 )  //colocar caballo negro en casillero marron claro o "par"
    {jLabel6.setLocation(i,j); jLabel6.setVisible(true)  ;jLabel5.setVisible(false);}
    else {   jLabel5.setLocation(i,j)  ; jLabel6.setVisible(false);jLabel5.setVisible(true) ;}}
   if (count==0){
    String posicioninicial="";

    {if ((posBlack-(posBlack/8)*8)==0) posicioninicial="a"; else
 if ((posBlack-(posBlack/8)*8)==1) posicioninicial="b"; else
 if ((posBlack-(posBlack/8)*8)==2) posicioninicial="c"; else
 if ((posBlack-(posBlack/8)*8)==3) posicioninicial="d"; else
 if ((posBlack-(posBlack/8)*8)==4) posicioninicial="e"; else
      if ((posBlack-(posBlack/8)*8)==5) posicioninicial="f"; else
      if ((posBlack-(posBlack/8)*8)==6) posicioninicial="g"; else
    if ((posBlack-(posBlack/8)*8)==7) posicioninicial="h";

    if ((posBlack/8)==0) posicioninicial=posicioninicial+"8";else{
      if ((posBlack/8)==1) posicioninicial=posicioninicial+"7";else
      if ((posBlack/8)==2) posicioninicial=posicioninicial+"6";else
      if ((posBlack/8)==3) posicioninicial=posicioninicial+"5";else
      if ((posBlack/8)==4) posicioninicial=posicioninicial+"4";else
         if ((posBlack/8)==5) posicioninicial=posicioninicial+"3";else
         if ((posBlack/8)==6) posicioninicial=posicioninicial+"2";else
           if ((posBlack/8)==7) posicioninicial=posicioninicial+"1";}

    jTextArea1.setText(posicioninicial+" -");}}
   //a continuacion  borramos los blancos que matamos
  count++;
    if (result.get(posResult)==0) {jLabel000.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"a8 -");}
      
      if (result.get(posResult)==1) {jLabel001.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"b8 -");}
      
            if (result.get(posResult)==2) {jLabel002.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"c8 -");}
     
      if (result.get(posResult)==3) {jLabel003.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"d8 -");}
if (result.get(posResult)==4) {jLabel004.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"e8 -");}
if (result.get(posResult)==5) {jLabel005.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"f8 -");}
       if (result.get(posResult)==6) {jLabel006.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"g8 -");}
if (result.get(posResult)==7) {jLabel007.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"h8 -");}
if (result.get(posResult)==8) {jLabel008.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"a7 -");}
 if (result.get(posResult)==9) {jLabel009.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"b7 -");}
if (result.get(posResult)==10) {jLabel0010.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"c7 -");}
if (result.get(posResult)==11) {jLabel0011.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"d7 -");}
      if (result.get(posResult)==12) {jLabel0012.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"e7 -");}
      if (result.get(posResult)==13) {jLabel0013.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"f7 -");}
if (result.get(posResult)==14) {jLabel0014.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"g7 -");}
       if (result.get(posResult)==15) {jLabel0015.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"h7 -");}
if (result.get(posResult)==16) {jLabel0016.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"a6 -");}
if (result.get(posResult)==17) {jLabel0017.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"b6 -");}
 if (result.get(posResult)==18){ jLabel0018.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"c6 -");}
if (result.get(posResult)==19) {jLabel0019.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"d6 -");}
if (result.get(posResult)==20) {jLabel0020.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"e6 -");}
      if (result.get(posResult)==21) {jLabel0021.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"f6 -");}
if (result.get(posResult)==22) {jLabel0022.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"g6 -");}
if (result.get(posResult)==23) {jLabel0023.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"h6 -");}
       if (result.get(posResult)==24) {jLabel0024.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"a5 -");}
if (result.get(posResult)==25) {jLabel0025.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"b5 -");}
if (result.get(posResult)==26) {jLabel0026.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"c5 -");}
 if (result.get(posResult)==27) {jLabel0027.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"d5 -");}
if (result.get(posResult)==28) {jLabel0028.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"e5 -");}
if (result.get(posResult)==29) {jLabel0029.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"f5 -");}
      if (result.get(posResult)==30){ jLabel0030.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"g5 -");}
if (result.get(posResult)==31) {jLabel0031.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"h5 -");}
if (result.get(posResult)==32) {jLabel0032.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"a4 -");}
       if (result.get(posResult)==33){ jLabel0033.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"b4 -");}
if (result.get(posResult)==34) {jLabel0034.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"c4 -");}
if (result.get(posResult)==35) {jLabel0035.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"d4 -");}
      if (result.get(posResult)==36){ jLabel0036.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"e4 -");}
if (result.get(posResult)==37) {jLabel0037.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"f4 -");}
if (result.get(posResult)==38) {jLabel0038.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"g4 -");}
      if (result.get(posResult)==39){ jLabel0039.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"h4 -");}
if (result.get(posResult)==40) {jLabel0040.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"a3 -");}
if (result.get(posResult)==41) {jLabel0041.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"b3 -");}
       if (result.get(posResult)==42) {jLabel0042.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"c3 -");}
if (result.get(posResult)==43) {jLabel0043.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"d3 -");}
if (result.get(posResult)==44) {jLabel0044.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"e3 -");}
       if (result.get(posResult)==45){ jLabel0045.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"f3 -");}
if (result.get(posResult)==46) {jLabel0046.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"g3 -");}
if (result.get(posResult)==47) {jLabel0047.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"h3 -");}
      if (result.get(posResult)==48){ jLabel0048.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"a2 -");}
if (result.get(posResult)==49) {jLabel0049.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"b2 -");}
if (result.get(posResult)==50) {jLabel0050.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"c2 -");}
       if (result.get(posResult)==51){ jLabel0051.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"d2 -");}
if (result.get(posResult)==52) {jLabel0052.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"e2 -");}
if (result.get(posResult)==53) {jLabel0053.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"f2 -");}
       if (result.get(posResult)==54){ jLabel0054.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"g2 -");}
if (result.get(posResult)==55) {jLabel0055.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"h2 -");}
if (result.get(posResult)==56) {jLabel0056.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"a1 -");}
      if (result.get(posResult)==57){ jLabel0057.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"b1 -");}
if (result.get(posResult)==58) {jLabel0058.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"c1 -");}
if (result.get(posResult)==59) {jLabel0059.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"d1 -");}
       if (result.get(posResult)==60){ jLabel0060.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"e1 -");}
if (result.get(posResult)==61) {jLabel0061.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"f1 -");}
if (result.get(posResult)==62) {jLabel0062.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"g1 -");}
       if (result.get(posResult)==63){ jLabel0063.setVisible(false);jTextArea1.setText(jTextArea1.getText()+"\n"+"h1 -");}

     posResult++; mainPanel.repaint();
      }
      jRadioButton5.setSelected(false);
      jRadioButton6.setSelected(false);jRadioButton7.setSelected(false);
      // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked


    private void jRadioButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton7MouseClicked
    
   jLabel17.setText("Aguarde por favor. Se le avisará cuando el proceso termine"); 
    
   jRadioButton5.setSelected(false);jRadioButton6.setSelected(false);
   timeStart=System.nanoTime(); Programa.cargacorte(Integer.parseInt(jTextField2.getText()));
   //marcarlahora();
    Programa.main();
    Programa.cargarpiezasamatar(whiteHorses);
    int g= whiteHorses.size();
    result=Programa.profundidad(posBlack);
    if (result != null)
        jLabel17.setText("El proceso ha finalizado exitosamente");
    else
        jLabel17.setText("No se pudo encontrar una solución");
   result.remove(0);
   timeStart=(System.nanoTime()-timeStart)/(1000000);
 
   jLabel2.setText("Tiempo       " +String.valueOf(timeStart)+" milisegundos");// setLastTime();
   jLabel4.setText("Solucion en  "+String.valueOf(result.size())+" movimientos" );
  float h= (float)g / (float)result.size();
   jLabel7.setText( "Piezas a matar " + String.valueOf(g) +  "  eficiencia = "+ h );

    }//GEN-LAST:event_jRadioButton7MouseClicked

    void setLastTime(){
    String g=jLabel2.getText();
    jLabel2.setText(g);
    timer.stop();
    }
    
    private void jRadioButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton5MouseClicked
                                              
   jLabel17.setText("Aguarde por favor. Se le avisará cuando el proceso termine");     
        
   jRadioButton6.setSelected(false);
   jRadioButton7.setSelected(false);
   timeStart=System.nanoTime();
   Programa.main(); 
   Programa.cargarpiezasamatar(whiteHorses);
  
   result.clear();
   
   int whiteHoresesLength= whiteHorses.size();
   
   result=Programa.amplitud(posBlack);
   jLabel17.setText("El proceso ha finalizado exitosamente");
   result.remove(0);
   timeStart=(System.nanoTime()-timeStart)/(1000000);


   jLabel2.setText("Tiempo       " +String.valueOf(timeStart)+" milisegundos");// setLastTime();
   jLabel4.setText("Solucion en  "+String.valueOf(result.size())+" movimientos" );
   float efficiency= (float)whiteHoresesLength / (float)result.size();
   jLabel7.setText( "Piezas a matar " + String.valueOf(whiteHoresesLength) +  "  eficiencia = "+ efficiency );
    }//GEN-LAST:event_jRadioButton5MouseClicked


    private void jRadioButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton6MouseClicked

    jLabel17.setText("Aguarde por favor. Se le avisará cuando el proceso termine");   
    
    jRadioButton5.setSelected(false);
    jRadioButton7.setSelected(false);
    
    timeStart=System.nanoTime(); 
    Programa.cargacorte(Integer.parseInt(jTextField2.getText()));
    
    Programa.main();
    Programa.cargarpiezasamatar(whiteHorses);
    int g= whiteHorses.size();  
    
    
    ArrayList <Integer> p= Programa.aestrella(posBlack);
    jLabel17.setText("El proceso ha finalizado exitosamente");
    result=p;
    result.remove(0);
    
    timeStart=(System.nanoTime()-timeStart)/(1000000);
  

   jLabel2.setText("Tiempo       " +String.valueOf(timeStart)+" milisegundos");// setLastTime();
   jLabel4.setText("Solucion en  "+String.valueOf(result.size())+" movimientos" );
   float h= (float)g / (float)result.size();
   jLabel7.setText( "Piezas a matar " + String.valueOf(g) +  "  eficiencia = "+ h );
    }//GEN-LAST:event_jRadioButton6MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
  if(jRadioButton2.isSelected() & !jRadioButton1.isSelected()){
  
      boolean t=true;
      while (t){
  double h=Math.random();
  h=h*64;
  int valor=(int)h;
  int u=valor-(valor/8)*8;    //se empieza a enumerar desde la posicion 0
  int p=valor/8;
  int x=(u*47)+47;
  int y=(p*47)+47;
  if ((!whiteHorses.isEmpty() & !whiteHorses.contains(valor)) | whiteHorses.isEmpty())
  { drawBlack(x,y,u,p); t=false;}}
   //(result.get(posResult)-((result.get(posResult)/8)*8))+(result.get(posResult)/8))

 // int u=(x-37)/47;    //se empieza a enumerar desde la posicion 0
  //int p=(y-37)/47;
  }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
   //ak empieza el show
       
        Programa.resetear();
        jLabel6.setVisible(false);jLabel5.setVisible(false);posResult=0;posBlack=999;
  jLabel000.setVisible(false);
  jLabel001.setVisible(false);
  jLabel002.setVisible(false);
  jLabel003.setVisible(false);
  jLabel004.setVisible(false);
  jLabel005.setVisible(false);
  jLabel006.setVisible(false);
  jLabel007.setVisible(false);
  jLabel008.setVisible(false);
  jLabel009.setVisible(false);
  jLabel0010.setVisible(false);
  jLabel0011.setVisible(false);
  jLabel0012.setVisible(false);
  jLabel0013.setVisible(false);
  jLabel0014.setVisible(false);
  jLabel0015.setVisible(false);
  jLabel0016.setVisible(false);
  jLabel0017.setVisible(false);
  jLabel0018.setVisible(false);
  jLabel0019.setVisible(false);
  jLabel0020.setVisible(false);
  jLabel0021.setVisible(false);
  jLabel0022.setVisible(false);
  jLabel0023.setVisible(false);
  jLabel0024.setVisible(false);
  jLabel0025.setVisible(false);
  jLabel0026.setVisible(false);
  jLabel0027.setVisible(false);
  jLabel0028.setVisible(false);
  jLabel0029.setVisible(false);
  jLabel0030.setVisible(false);
  jLabel0031.setVisible(false);
  jLabel0032.setVisible(false);
  jLabel0033.setVisible(false);
  jLabel0034.setVisible(false);
  jLabel0035.setVisible(false);
  jLabel0036.setVisible(false);
  jLabel0037.setVisible(false);
  jLabel0038.setVisible(false);
  jLabel0039.setVisible(false);
  jLabel0040.setVisible(false);
  jLabel0041.setVisible(false);
  jLabel0042.setVisible(false);
  jLabel0043.setVisible(false);
  jLabel0044.setVisible(false);
  jLabel0045.setVisible(false);
  jLabel0046.setVisible(false);
  jLabel0047.setVisible(false);
  jLabel0048.setVisible(false);
  jLabel0049.setVisible(false);
  jLabel0050.setVisible(false);
  jLabel0051.setVisible(false);
  jLabel0052.setVisible(false);
  jLabel0053.setVisible(false);
  jLabel0054.setVisible(false);
  jLabel0055.setVisible(false);
  jLabel0056.setVisible(false);
  jLabel0057.setVisible(false);
  jLabel0058.setVisible(false);
  jLabel0059.setVisible(false);
  jLabel0060.setVisible(false);
  jLabel0061.setVisible(false);
  jLabel0062.setVisible(false);
  jLabel0063.setVisible(false);
  whiteHorses.clear();
  result.clear();
//termina 
   
        ArrayList <Integer> posicionesagenerar= new ArrayList();
        int valor=Integer.parseInt(jTextField1.getText());
        if (jRadioButton4.isSelected() & valor>0){
        for (int y=0;y<valor;y++){
          boolean a=true;
             while (a){
             double aleatorio=Math.random();

  aleatorio=aleatorio*64;
  int posicionaleatoria=(int)aleatorio;
   if (posicionaleatoria != posBlack & !posicionesagenerar.contains(posicionaleatoria)){
       posicionesagenerar.add(posicionaleatoria); a=false;
   }

             }


        }

        }
        for (int h=0;h<posicionesagenerar.size();h++){
          
            int u,p;
          u=(posicionesagenerar.get(h)- 8*(posicionesagenerar.get(h)/8));   //fila
          p=(posicionesagenerar.get(h)/8);   //columna
          pintarblancos(u,p);
          System.out.println("numero");
            System.out.println(posicionesagenerar.get(h));
          System.out.println(u);
            System.out.println(p);
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jRadioButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton6MousePressed
      // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6MousePressed

    private void TableroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableroMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TableroMouseEntered

    private void jRadioButton6AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jRadioButton6AncestorAdded
       // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6AncestorAdded

    private void resetOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetOptionActionPerformed
        Programa.resetear();
    }//GEN-LAST:event_resetOptionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tablero;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel000;
    private javax.swing.JLabel jLabel001;
    private javax.swing.JLabel jLabel0010;
    private javax.swing.JLabel jLabel0011;
    private javax.swing.JLabel jLabel0012;
    private javax.swing.JLabel jLabel0013;
    private javax.swing.JLabel jLabel0014;
    private javax.swing.JLabel jLabel0015;
    private javax.swing.JLabel jLabel0016;
    private javax.swing.JLabel jLabel0017;
    private javax.swing.JLabel jLabel0018;
    private javax.swing.JLabel jLabel0019;
    private javax.swing.JLabel jLabel002;
    private javax.swing.JLabel jLabel0020;
    private javax.swing.JLabel jLabel0021;
    private javax.swing.JLabel jLabel0022;
    private javax.swing.JLabel jLabel0023;
    private javax.swing.JLabel jLabel0024;
    private javax.swing.JLabel jLabel0025;
    private javax.swing.JLabel jLabel0026;
    private javax.swing.JLabel jLabel0027;
    private javax.swing.JLabel jLabel0028;
    private javax.swing.JLabel jLabel0029;
    private javax.swing.JLabel jLabel003;
    private javax.swing.JLabel jLabel0030;
    private javax.swing.JLabel jLabel0031;
    private javax.swing.JLabel jLabel0032;
    private javax.swing.JLabel jLabel0033;
    private javax.swing.JLabel jLabel0034;
    private javax.swing.JLabel jLabel0035;
    private javax.swing.JLabel jLabel0036;
    private javax.swing.JLabel jLabel0037;
    private javax.swing.JLabel jLabel0038;
    private javax.swing.JLabel jLabel0039;
    private javax.swing.JLabel jLabel004;
    private javax.swing.JLabel jLabel0040;
    private javax.swing.JLabel jLabel0041;
    private javax.swing.JLabel jLabel0042;
    private javax.swing.JLabel jLabel0043;
    private javax.swing.JLabel jLabel0044;
    private javax.swing.JLabel jLabel0045;
    private javax.swing.JLabel jLabel0046;
    private javax.swing.JLabel jLabel0047;
    private javax.swing.JLabel jLabel0048;
    private javax.swing.JLabel jLabel0049;
    private javax.swing.JLabel jLabel005;
    private javax.swing.JLabel jLabel0050;
    private javax.swing.JLabel jLabel0051;
    private javax.swing.JLabel jLabel0052;
    private javax.swing.JLabel jLabel0053;
    private javax.swing.JLabel jLabel0054;
    private javax.swing.JLabel jLabel0055;
    private javax.swing.JLabel jLabel0056;
    private javax.swing.JLabel jLabel0057;
    private javax.swing.JLabel jLabel0058;
    private javax.swing.JLabel jLabel0059;
    private javax.swing.JLabel jLabel006;
    private javax.swing.JLabel jLabel0060;
    private javax.swing.JLabel jLabel0061;
    private javax.swing.JLabel jLabel0062;
    private javax.swing.JLabel jLabel0063;
    private javax.swing.JLabel jLabel007;
    private javax.swing.JLabel jLabel008;
    private javax.swing.JLabel jLabel009;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private java.awt.Label label1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
