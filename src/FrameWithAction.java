import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//布局：https://blog.csdn.net/weixin_45335305/article/details/99409549

public class FrameWithAction extends JFrame{
    JLabel maxTimeLabel;
    JLabel minTimeLabel;
    public FrameWithAction() throws InterruptedException {

        setBounds(100, 100, 600, 500);
        setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c=getContentPane();
        c.setLayout(new GridLayout(4, 1,10,10));

        MyPanel p1= new MyPanel();
        p1.setLastPos(new int[]{Stick.begin+30,Stick.begin+80,Stick.begin+110,Stick.begin+160,Stick.begin+250});
        JPanel p2= new JPanel(new GridLayout(1,2,10,10));

        JPanel p3= new JPanel(new GridLayout(1,3,10,10));

        JPanel p4= new JPanel(new FlowLayout());

        JLabel jLabel1= new JLabel("方向：");
        JButton button1 = new JButton("点击开始");
        button1.setSize(100, 20);
        button1.setHorizontalAlignment(SwingConstants.CENTER);

        button1.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PlayRoom playRoom = new PlayRoom(0.5,0,10000000);
                try {
                    playRoom.start();
                    minTimeLabel.setText("最大时间："+playRoom.getMax());
                    maxTimeLabel.setText("最小时间："+playRoom.getMin());
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        maxTimeLabel = new JLabel("最大时间："+"未知");
        minTimeLabel = new JLabel("最小时间："+"未知");
        p2.add(jLabel1);
        p2.add(new JLabel("速度：5cm/s"));
        p3.add(new JLabel("本轮时间："));
        p3.add(maxTimeLabel);
        p3.add(minTimeLabel);
        p4.add(button1);


        c.add(p2);
        c.add(p3);
        c.add(p4);
        c.add(p1);

        setVisible(true);

    }
    public static void main(String[] args) throws InterruptedException {
        JFrame jf = new FrameWithoutAction();
    }
}

