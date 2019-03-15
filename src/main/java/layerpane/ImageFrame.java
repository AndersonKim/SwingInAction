package layerpane;

import javax.swing.*;
import java.awt.*;

public class ImageFrame extends JFrame {
    JLabel imageLable;
    JPanel bgPanel;
    JButton jButton;
    ImageIcon image=new ImageIcon("D:\\Util\\游民壁纸\\698371.jpg");

    public ImageFrame() throws HeadlessException {
        setComponent();
        pack();
        setVisible(true);
        setSize(image.getIconWidth(), image.getIconHeight());

    }

    private void setComponent() {
        //通过设置layerPanel设置背景
        imageLable=new JLabel();
        imageLable.setIcon(image);
        imageLable.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        this.getLayeredPane().setLayout(null);
        this.getLayeredPane().add(imageLable,new Integer(Integer.MIN_VALUE));
        //通过contentPanel设置组件，注意设置layout防止填满布局
        jButton=new JButton("Button");
        bgPanel= (JPanel) this.getContentPane();
        bgPanel.setOpaque(false);
        bgPanel.setLayout(new FlowLayout());
        bgPanel.add(jButton);

    }

    public static void main(String[] args){
        ImageFrame a=new ImageFrame();
    }
}
