import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.*;

class Menu implements ActionListener// implementation of action listener
{
    JMenuItem m1,m2,m3,m4;
    JMenuBar mbar;
    JTextField box;
    JMenu menu;
    JFrame frame;
//implementation of frames

    public Menu()//start of menu for the frames bars text field and all items
    {
        frame =new JFrame();
        frame.setLayout(null);

        mbar =new JMenuBar();
        box=new JTextField();
        menu=new JMenu("options");

        m1=new JMenuItem("Date & Time");
        m2=new JMenuItem("Write_Into_File");
        m3=new JMenuItem("ChangeFrameColor");
        m4=new JMenuItem("Exit");


        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        menu.add(m4);

        mbar.add(menu);
        frame.setJMenuBar(mbar);


        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);

        box.setBounds(150,50,150,30);
        frame.add(box);
        frame.setVisible(true);
        frame.setSize(500,350);
        //setup of all the menu items,boundaries, and text
    }

    public void actionPerformed(ActionEvent ae)//action performed for all date
    {
        if(ae.getSource()==m1)
        {
            DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");//format for dates
            LocalDateTime current=LocalDateTime.now();
            box.setText(dt.format(current)+"");
        }

        if(ae.getSource()==m2)
        {
            String s1=box.getText();//get text from user
            try
            {
                FileWriter fw=new FileWriter("Log.txt");
                fw.write(s1);
                fw.close();
            }
            catch(Exception e1)
            {
                box.setText("Exception is "+e1);
            }
        }

        if(ae.getSource()==m3)
        {
            frame.getContentPane().setBackground(Color.green);//set for customization
        }

        if(ae.getSource()==m4)
        {
            frame.setVisible(false);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //returns and get statements
    public static void main(String args[])
    {
        Menu md=new Menu();
    }
}

