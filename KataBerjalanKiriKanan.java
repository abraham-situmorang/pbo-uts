import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KataBerjalanKiriKanan extends JFrame implements ActionListener {

  int no;
  Timer timer;
  JLabel lbPesan = new JLabel();
  String Kata[] = {"SAYA", "KAMU", "ANDA"};
  int x=300;
  int warna = 0;
  String direction = "LEFT";
  
  public KataBerjalanKiriKanan() {
     //membebaskan penempatan posisi komponen
     setLayout(null);

     //Membuat object Timer dengan selang waktu 2000ms=2 detik 
     timer = new Timer(10, this);//10ms
     timer.start();//timer diaktifkan

     lbPesan.setFont(new Font("Tahoma", 1, 64));
     lbPesan.setForeground(Color.MAGENTA);
     lbPesan.setBounds(x, 20, 240, 100);
     lbPesan.setText(Kata[no]);
     add(lbPesan);
 
     //inisialisasi frame window
     setTitle("Kata Berjalan");
     setSize(350, 200);
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
    new KataBerjalanKiriKanan();
  }

    private void DirectionToRight() {
        direction = "RIGHT";
        
        if (x < 160) {
           x = x+2;
         } else {
             
             DirectionToLeft();
             SetStringAndColor();
         }
         lbPesan.setBounds(x, 20, 240, 100);
    }

    private void DirectionToLeft() {
        direction = "LEFT";
        
        
        if (x > 0) {
           x = x-2;
         } else {
             
            DirectionToRight();
            SetStringAndColor();
         }
         lbPesan.setBounds(x, 20, 240, 100);
    }

    private void SetStringAndColor() {
           if (no < Kata.length-1){
               no++;
           } else {
               no = 0;
           }
           if (warna == 0) {
               warna = 1;
               lbPesan.setForeground(Color.RED);
           } else {
               warna = 0;
               lbPesan.setForeground(Color.MAGENTA);
           }
           lbPesan.setText(Kata[no]);
    }
}
