/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanoJavaLauncher;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.metal.MetalIconFactory;
import sano.Node;
import sano.RSML;
import sano.TextFile;

/**
 *
 * @author HowariS
 */
public class launcher extends javax.swing.JDialog {

    /**
     * Creates new form launcher
     */
    Dimension screenSize = null;
    Dimension mySize = null;
    boolean keep = false;
    int delay = 1000; //milliseconds
    ActionListener taskPerformer = (ActionEvent evt) -> {
        realign();
    };

    Timer t = new Timer(delay, taskPerformer);

    Map<Object, Icon> icons = null;

    public launcher() {
        this.setUndecorated(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        //this.setLocationRelativeTo(null);
        // getContentPane().setBackground(new Color(-16776961));
        // setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setOpacity((float) 1);
        setFocusable(true);
        //setFocusableWindowState(false);
        jList1.setCellRenderer(new MyListRenderer());
        ((MyListRenderer) jList1.getCellRenderer()).types = types;
        ((MyListRenderer) jList1.getCellRenderer()).links = links;

        icons = new HashMap<Object, Icon>();
        Image img = null;
        int sz = 30;
        try {
            img = ImageIO.read(ClassLoader.getSystemResource("sanoJavaLauncher/res/application.jpg"));
            icons.put("application", toIcon(img, 35, 40));
            img = ImageIO.read(ClassLoader.getSystemResource("sanoJavaLauncher/res/folder.jpg"));
            icons.put("folder", toIcon(img, 50, 40));
            img = ImageIO.read(ClassLoader.getSystemResource("sanoJavaLauncher/res/web-page.png"));
            icons.put("webpage", toIcon(img, 50, 40));
        } catch (IOException ex) {
            Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        }

        ((MyListRenderer) jList1.getCellRenderer()).icons = icons;
        realign();
        t.start();
    }

    void realign() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mySize = new Dimension();
        mySize.height = screenSize.height;
        mySize.width = (int) (screenSize.width / 5) + 10;
        this.setSize(mySize);
        this.setLocation(screenSize.width - mySize.width, 0);
        this.setAlwaysOnTop(true);
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.setState(java.awt.Frame.ICONIFIED);
/*
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        // this.setState(java.awt.Frame.NORMAL);
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        // shower();
        //hider();*/
    }

    ImageIcon toIcon(Image img, int w, int h) {
        Image resImg = resizeImage(img, w, h);
        ImageIcon ic = new ImageIcon(resImg);
        return ic;
    }

    void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        setAlwaysOnTop(true);
        setModalExclusionType(null);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jList1.setSelectionBackground(new java.awt.Color(51, 255, 0));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jList1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jList1MouseExited(evt);
            }
        });
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadList();
    }//GEN-LAST:event_formWindowOpened

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged

    }//GEN-LAST:event_jList1ValueChanged

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getClickCount() == 2) {
            runIt();
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        hiding(evt);
    }//GEN-LAST:event_formKeyPressed

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        hiding(evt);
    }//GEN-LAST:event_jList1KeyPressed
    int activeSpotSize = 50;
    private void jList1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseEntered

        if (evt.getXOnScreen() > screenSize.width - activeSpotSize && evt.getYOnScreen() < activeSpotSize) {
            shower();
        }
    }//GEN-LAST:event_jList1MouseEntered

    private void jList1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseExited
        if (evt.getXOnScreen() < screenSize.width - 2 && evt.getYOnScreen() > 2) {
            hider();
        }
    }//GEN-LAST:event_jList1MouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
//        realign();
    }//GEN-LAST:event_formWindowActivated

    void shower() {
        realign();
        this.setSize(mySize);
        this.setLocation(screenSize.width - mySize.width, 0);
        this.setOpacity(((float) (1)));
    }

    void hider() {
        if (keep) {
            return;
        }
        //wait(300);
        realign();
        this.setSize(activeSpotSize, activeSpotSize);
        this.setLocation(screenSize.width - 10, 0);
        this.setOpacity(((float) (0.01)));
    }

    void hiding(java.awt.event.KeyEvent evt) {
        char c = (char) evt.getKeyChar();
        if ('x' == c || 'X' == c) {
            this.dispose();
        } else if ('r' == c || 'R' == c) {
            loadList();
        } else if ('s' == c || 'S' == c) {
            shower();
        } else if ('h' == c || 'H' == c) {
            hider();
        } else if ('k' == c || 'K' == c) {
            keep = !keep;
        } else if ((int) evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            hider();
        }
    }

    void runIt() {
        String path = links.get(jList1.getSelectedIndex());
        String type = types.get(jList1.getSelectedIndex());
        switch (type) {

            case "a":
                try {

                    Runtime.getRuntime().exec(path);
                } catch (IOException ex) {
                }
                break;
            case "f":
                try {
                    Runtime.getRuntime().exec("explorer.exe " + path);
                } catch (IOException ex) {
                }
                break;
            case "w":
                try {
                    Desktop.getDesktop().browse(new URL(path).toURI());
                } catch (Exception e) {
                    //e.printStackTrace();
                }

                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new launcher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
List<String> l = null;
    List<String> textx = new ArrayList<String>();
    List<String> types = new ArrayList<String>();
    List<String> links = new ArrayList<String>();
    String desktopPath = System.getProperty("user.home");
//System.out.print(desktopPath.replace("\\", "/"));

    void loadList() {
        //   System.out.println("started");
        TextFile t = null;
        textx = new ArrayList<String>();
        //  types = new ArrayList<String>();
        // links = new ArrayList<String>();

        try {
            RSML rsml = new RSML();
            rsml.read(desktopPath + "\\links.rsml");
            Node n = null;
            for (int i = 0; i < rsml.root.children.size(); i++) {
                n = rsml.root.children.get(i);
                types.add(n.getAttributeByName(n, "type").toString());
                links.add(n.getAttributeByName(n, "path").toString());
                textx.add(n.getAttributeByName(n, "text").toString());
            }
            /*   // t = new TextFile(desktopPath + "\\links.rsml", TextFile.Type.READ);
            l = t.readAllLines();
            for (int i = 0; i < l.size(); i++) {
                String s = l.get(i);
                System.out.println(s);
                String[] d = s.split(";");
                //    System.out.println(d[0] + "&&&&" + d[1]);

                if (d.length >= 3) {
                    textx.add(d[1]);

                    types.add(d[0]);
                    links.add(d[2]);
                    //   System.out.println(links.get(i));
                } 

            }*/
            String[] text = new String[textx.size()];
            text = textx.toArray(text);
            jList1.setListData(text);

        } catch (IOException ex) {
            //Logger.getLogger(launcher.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Image resizeImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

}

class MyListRenderer extends DefaultListCellRenderer {
    // private HashMap theChosen = new HashMap();

    public List<String> types = null;
    public List<String> links = null;

    public Map<Object, Icon> icons = null;

    public Component getListCellRendererComponent(JList list,
            Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        JLabel label
                = (JLabel) super.getListCellRendererComponent(list,
                        value, index, isSelected, cellHasFocus);
        Icon icon = null;
        String s = links.get(index);
        File file = new File(s);
        // sun.awt.shell.ShellFolder sf;
        switch (types.get(index)) {
            case "t":
                setBackground(Color.gray);
                setForeground(Color.white);

                break;
            case "f":
                setForeground(Color.black);
                icon = icons.get("folder");
                break;
            case "w":
                setForeground(Color.blue);
                icon = icons.get("webpage");

                break;
            case "a":
                setForeground(Color.black);
                 {
                    //  icon = icons.get("application");
                    // icon = FileSystemView.getFileSystemView().getSystemIcon(file);
                    // if (icon == null) {
                    icon = icons.get("application");
                    //F }
                }

                /*  try {
                    sf = sun.awt.shell.ShellFolder.getShellFolder(file);
                    icon = new ImageIcon(sf.getIcon(true));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyListRenderer.class.getName()).log(Level.SEVERE, null, ex);
                }*/
//final javax.swing.JFileChooser fc = new javax.swing.JFileChooser(); 
//icon = fc.getUI().getFileView(fc).getIcon(file);
                break;
            default:
                setForeground(Color.gray);
                break;

        }

        label.setIcon(icon);

        return (this);
    }

    /*   static ImageIcon getImage(File file) {
        try {
            ImageIcon systemIcon = (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(file);
            java.awt.Image image = systemIcon.getImage();
            ImageIcon ic = new ImageIcon(image);
            return ic;
        } catch (Exception e) {
        }
        return null;
    }

    private BufferedImage getImage2(final File pFile)
            throws FileNotFoundException {
        Image icon = ShellFolder.getShellFolder(pFile).getIcon(true);
        BufferedImage im = new BufferedImage(icon.getWidth(null),
                icon.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = im.createGraphics();
        g.drawImage(icon, 0, 0, null);
        g.dispose();
        int width = im.getWidth();
        int height = im.getHeight();
        System.out.println(width);
        System.out.println(height);
        final int maxHeigh = 79;
        double scaleValue = 0;
        if (height > width) {
            scaleValue = maxHeigh / height;
        } else {
            scaleValue = maxHeigh / width;
        }
        final int scaledWidth = (int) (im.getWidth() * scaleValue);
        final int scaledHeigh = (int) (im.getHeight() * scaleValue);
        BufferedImage resized = new BufferedImage(scaledWidth, scaledHeigh,
                im.getType());
        g = resized.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(im, 0, 0, scaledWidth, scaledHeigh, 0, 0, im.getWidth(),
                im.getHeight(), null);
        g.dispose();
        return resized;
    }
     */
}
