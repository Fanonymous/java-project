import java.awt.*;
import java.awt.event.*;
import javax.swing.*;//Timer;
public class MyTimer
{ public static void main(String args[])
   { TimeWin Win=new TimeWin();
   }
} 
class TimeWin extends JFrame 
implements ActionListener
{  JTextField text;
   JButton bStart,bStop,bContinue;
   Timer time;
   int n=0,start=1;
   TimeWin()
   {time=new Timer(1000,this);//TimeWin对象做计时器的监视器。
    text=new JTextField(20); 
    bStart=new JButton("开始计时");
    bStop=new JButton("暂停计时");
    bContinue=new JButton("继续计时");
    bStart.addActionListener(this);
    bStop.addActionListener(this);
    bContinue.addActionListener(this);
    setLayout(new FlowLayout());
    add(bStart);
    add(bStop);
    add(bContinue);
    add(text);
    setSize(500,500);
    validate();
    setVisible(true);
  /*  addWindowListener(new WindowAdapter()
                      { public void windowClosing(WindowEvent e)
                         {  System.exit(0);
                         }
                      } );*/
   }
   public void actionPerformed(ActionEvent e) 
   { if(e.getSource()==time)
      { java.util.Date date=new java.util.Date();
        String str=date.toString().substring(11,19);
        text.setText("时间："+str);
        /*int x=text.getBounds().x;
        int y=text.getBounds().y;  
        y=y+2;
        text.setLocation(x,y);*/
      } 
      else if(e.getSource()==bStart)
      {  time.start();    
      }
      else if(e.getSource()==bStop)
      {  time.stop();    
      }
      else if(e.getSource()==bContinue)
      {  time.restart();    
      }  
   }
}
