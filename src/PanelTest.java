import javax.swing.*;
import java.awt.*;

/**
 * 定义一个继承自JPanel的类，重写它的paint方法 *
 */


public class PanelTest
{
    public static void main(String[] args)
    {
        JFrame  jf = new JFrame();
        jf.setLayout(null);
        MyPanel jp = new MyPanel();
        BorderLayout bb=new BorderLayout(); //边界布局，设置控件垂直居中

        jp.setLayout(bb);
        jp.setBounds(300, 300, 100, 100);
        jp.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
        jf.setBounds(200, 200, 500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(jp);
        jf.setVisible(true);

        while(true)
        {
            //不停的重绘JPanel,实现动画的效果
            jp.display();

            try
            {
                Thread.sleep(300);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}