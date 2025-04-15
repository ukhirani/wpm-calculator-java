//thefinalcode
import java.util.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



import java.util.Random;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



class WPM_CALCULATOR {
    static long starttime;
    static int start = 0,starthello = 0;
    String WordListArray[] = {"the","be","to","of","and","a","in","that","have","I","it","for","not","on","with","he","as","you","do","at","this","but","his","by","from","they","we","say","her","she","or","an","will","my","one","all","would","there","their","what","so","up","out","if","about","who","get","which","go","me","when","make","can","like","time","no","just","him","know","take","people","into","year","your","good","some","could","them","see","other","than","then","now","look","only","come","its","over","think","also","back","after","use","two","how","our","work","first","well","way","even","new","want","because","any","these","give","day","most","us"};
    String currentword ;
    String wordtyped ,prevword,nextword,nextnextword;
    int wpm = 0;
    float accuracy;
    int wordstyped = -1;
    int timeleft;
    static long xyz;
    static Font font = new Font("Helvetica", Font.BOLD, 12);  // Replace "Arial" with the desired font and 12 with the desired font size
    static Font font2 = new Font("Helvetica", Font.BOLD, 20);  // Replace "Arial" with the desired font and 12 with the desired font size


    
    public static void main(String[] args) {

        WPM_CALCULATOR wpmtester = new WPM_CALCULATOR();
        Random ran = new Random();




        JFrame newFrame = new JFrame();
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(100, 100);
        // newFrame.setLayout(null);
        newFrame.setVisible(false);
        JLabel timenewLabel = new JLabel();
        timenewLabel.setBounds(10, 10, 120, 25);
        // newFrame.getContentPane().setBackground(Color.);


       
        
    //initializing the frame
        JFrame frame = new JFrame("WPM CALCULATOR by umang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.PINK);
        


    //creating the label that will display initially
        JLabel promptLabel = new JLabel("Press ENTER to go ! ");
        JLabel newLabel = new JLabel();
        newLabel.setBounds(10, 10, 120, 25);

        
        JLabel timeLabel = new JLabel();
         
        



        promptLabel.setBounds(10, 10, 120, 25);
        promptLabel.setFont(font);

        frame.add(promptLabel); 
        frame.add(timeLabel);  
        
        
    //creating the texfield
        JTextField inputField = new JTextField();
        inputField.setBounds(140, 10, 100, 25);
        inputField.requestFocus();
        inputField.setFont(font);

        frame.add(inputField);
    
    //creating the doomsday prompt
        JFrame doomsday = new JFrame("RESULTS");
        doomsday.setSize(600, 100);
        doomsday.setLayout(null);
        JLabel wpmLabel = new JLabel();
        JLabel accuracyLabel = new JLabel();
        doomsday.add(wpmLabel);
        doomsday.add(accuracyLabel);





        // Timer timer = new Timer(1000, new ActionListener() {
        //     int countdown = 60;

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         countdown--;
        //         timeLabel.setText(Integer.toString(countdown));

        //     }
        // });

        

        








        // Add a KeyListener to the inputField
        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

             @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_ENTER)) {

                    if(WPM_CALCULATOR.start == 0){

                        WPM_CALCULATOR.starttime = System.currentTimeMillis();
                        WPM_CALCULATOR.start++;

                    }
                    if(System.currentTimeMillis() <= WPM_CALCULATOR.starttime + 60000){

                        // xyz = WPM_CALCULATOR.starttime + 60000 - System.currentTimeMillis();
                        // timeLabel.setText(Long.toString(xyz/1000));
                        // timeLabel.setBounds(300,0,50,50);
                        wpmtester.prevword = wpmtester.currentword;
                        
                        
                        if(WPM_CALCULATOR.starthello == 0){
                            wpmtester.currentword = wpmtester.WordListArray[ran.nextInt(99)];
                            starthello++;

    
                        }
                        else{
                            wpmtester.currentword = wpmtester.nextword;
                        }
                        wpmtester.nextword = wpmtester.WordListArray[ran.nextInt(99)];

                        promptLabel.setText(wpmtester.currentword + " " + wpmtester.nextword);
                        
                        promptLabel.setFont(font2);

                        // promptLabel.setText(wpmtester.currentword );
                
                        // newLabel.setText(wpmtester.nextword);

                        
                    
                        String inputText = inputField.getText();
                        // System.out.println(inputText + wpmtester.prevword);
                        
    
                        if(inputText.equals(wpmtester.prevword)){
                            wpmtester.wpm++;
                            // System.out.println("hello");
                        }
                        wpmtester.wordstyped++;
                        // System.out.println(wpmtester.wordstyped);
                        inputField.setText("");

                        if(System.currentTimeMillis() >= WPM_CALCULATOR.starttime + 30000){
                            frame.getContentPane().setBackground(Color.ORANGE);
                            if(System.currentTimeMillis() >= WPM_CALCULATOR.starttime + 50000){
                                frame.getContentPane().setBackground(Color.RED);

                            }


                        }

                    }
                    else{
                        if(wpmtester.wordstyped==0){
                            wpmtester.wordstyped = 1;
                        }
                        wpmtester.accuracy = wpmtester.wpm*100/wpmtester.wordstyped;
                        // frame.setVisible(false);
                        promptLabel.setText("WPM : "+wpmtester.wpm +" with " + wpmtester.accuracy + " % accuracy");
                        promptLabel.setFont(font);

                        frame.setTitle("RESULTS");

                        inputField.setVisible(false);
                        promptLabel.setBounds(100, 10, 300, 25);



                        wpmLabel.setText("WPM :" + wpmtester.wpm);
                        accuracyLabel.setText("ACCURACY :" + wpmtester.accuracy);
                        frame.getContentPane().setBackground(Color.GREEN);
                  

                        // doomsday.setVisible(true);

                    }
                }
            }
            
        });
    }

}

    ///timer
    //color
    //set size