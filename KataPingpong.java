import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KataPingpong extends JFrame implements ActionListener {

  int no;
  Timer timer;
  JLabel lbPesan = new JLabel();
  String Kata[] = {"SAYA", "KAMU", "ANDA"};
  int x=0;
  int y=0;
  int warna = 0;
  String direction = "LEFT";
  String upDownStatus = "UP";
  
  public KataPingpong() {
     //membebaskan penempatan posisi komponen
     setLayout(null);

     //Membuat object Timer dengan selang waktu 2000ms=2 detik 
     timer = new Timer(1, this);//10ms
     timer.start();//timer diaktifkan

     lbPesan.setFont(new Font("Tahoma", 1, 64));
     lbPesan.setForeground(Color.MAGENTA);
     lbPesan.setBounds(x, 0, 240, 100);
     lbPesan.setText(Kata[no]);
     add(lbPesan);
 
     //inisialisasi frame window
     setTitle("Kata Pingpong");
     setSize(700, 400);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
     setLocationRelativeTo(null);//ditengah layar
  }

  public void actionPerformed(ActionEvent ae) {

       //Mendeteksi aktivasi object Timer
       if ( ae.getSource() == timer ) {
           if (direction == "LEFT")
           {
               DirectionToLeft();
           }
           else
           {
               DirectionToRight();
           }
       }
  }
 
  public static void main(String[] args){
    new KataPingpong();
  }

    private void DirectionToRight() {
        direction = "RIGHT";
        
        if (x < 500) {
           x = x+2;
           
           ChangeDirectionUpDown();
           
         } else {
             
             DirectionToLeft();
             SetStringAndColor();
         }
         lbPesan.setBounds(x, y, 240, 100);
    }

    private void DirectionToLeft() {
        direction = "LEFT";
        
        
        if (x > 0) {
           x = x-2;
           
           ChangeDirectionUpDown();
           
         } else {
             
            DirectionToRight();
            SetStringAndColor();
         }
         lbPesan.setBounds(x, y, 240, 100);
    }

    private void SetStringAndColor() {
           if (no < Kata.length-1){
               no++;
           } else {
               no = 0;
           }
      switch (warna) {
          case 0:
              warna = 1;
              lbPesan.setForeground(Color.RED);
              break;
          case 1:
              warna = 2;
              lbPesan.setForeground(Color.MAGENTA);
              break;
          case 2:
              warna = 3;
              lbPesan.setForeground(Color.BLACK);
              break;
          case 3:
              warna = 0;
              lbPesan.setForeground(Color.YELLOW);
              break;
          default:
              break;
      }
           lbPesan.setText(Kata[no]);
    }

    private void ChangeDirectionUpDown() {
           if (upDownStatus == "UP")
           {
               y = y-2;
           }
           else
           {
               y = y+2;
           }
           
           if (upDownStatus == "UP" && y < 0)
           {
               upDownStatus = "DOWN";
           }
           
           if (upDownStatus == "DOWN" && y > 280)
           {
               upDownStatus = "UP";
           }
    }
}
