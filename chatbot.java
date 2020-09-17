import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.lang.Math;

public class chatbot extends JFrame implements KeyListener{

	JPanel p1=new JPanel();
	JTextArea dialog=new JTextArea(20,80);
	JTextArea input=new JTextArea(2,80);
	JScrollPane scroll=new JScrollPane(
		dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);
	
	String[][] chatBot={
		//standard greetings
			{"hi bot","hello bot","hi","hello"},
			{"welcome to IPL-2020 SEASON 13 ---->\n\t How can i help you?\n\t Please enter your favourite team name."},
			
			{"my favourite team is mi","mumbai indians","mi"},
			{"Congratulations! MI fan, your team has already won 4 ipl trophies in the year 2013,2015,2017,2019 respectively.\n\tALL THE BEST FOR THIS SEASON"},
			
			{"my favourite team is csk","csk","chennai super kings"},
			{"Congratulations! CSK fan, your team has already won 3 ipl trophies in the year 2010,2011,2018 respectively.\n\tALL THE BEST FOR THIS SEASON"},
			
			{"my favourite team is srh","srh","sunrisers hyderabad"},
			{"Congratulations! SRH fan, your team has already won 1 ipl trophy in the year 2016.\n\tALL THE BEST FOR THIS SEASON"},
			
			{"my favourite team is kkr","kolkata knight riders","kkr"},
			{"Congratulations! KKR fan, your team has already won 2 ipl trophies in the year 2012,2014 respectively.\n\tALL THE BEST FOR THIS SEASON"},
			
			{"my favourite team is rr","rajesthan royals","RR"},
			{"Congratulations! RR fan, your team has already won 1 ipl trophY in the year 2008.\n\tALL THE BEST FOR THIS SEASON"},
			
			{"my favourite team is dc","delhi capitals","DC","my favourite team is kxip","kxip","king xi punjab","my favourite team is rcb","rcb","royal challengers bengaluru"},
			{"Oops your team really played well in all the season's.\n\tALL THE BEST FOR THIS SEASON"},
			
			{"ipl venues 2020","venue","venues"},
			{"ABU DHABI ,DUBAI, SHARJAH "},
			
			{"ipl schedule 2020","schedule"," ipl schedule"},
			{"go to this address-->  https://www.cricbuzz.com/cricket-series/3130/indian-premier-league-2020/matches"},
			
			{"number of teams","total teams"},
			{"8"},
			
			{"name of teams","team names"},
			{"csk mi rcb kkr srh rr kxip dc"},
			
		{"hi","hello","hola","ola","howdy"},
		{"hi","hello","hey"},
		//question greetings
		{"how are you","how r you","how r u","how are u"},
		{"good","doing well"},
		//yes
		{"yes"},
		{"no","NO","NO!!!!!!!"},
		{"narendra modi"},
		{"prime minister"},
		
		//default
		{"shut up","you're bad","noob","stop talking",
		"(IPL is unavailable, due to LOL)"}
	};
	
	public static void main(String[] args){
		new chatbot();
	}
	
	public chatbot(){
		super("IPL SEASON 13 Chat Bot");
		setSize(1000,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		dialog.setEditable(false);
		input.addKeyListener(this);
	
		p1.add(scroll);
		p1.add(input);
		p1.setBackground(new Color(100,200,0));
		add(p1);
		
		setVisible(true);
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
			//-----grab quote-----------
			String quote=input.getText();
			input.setText("");
			addText("-->You:\t"+quote);
			quote=quote.trim();
			while(
				quote.charAt(quote.length()-1)=='!' ||
				quote.charAt(quote.length()-1)=='.' ||
				quote.charAt(quote.length()-1)=='?'
			){
				quote=quote.substring(0,quote.length()-1);
			}
			quote=quote.trim();
			byte response=0;
			/*
			0:we're searching through chatBot[][] for matches
			1:we didn't find anything
			2:we did find something
			*/
			//-----check for matches----
			int j=0;//which group we're checking
			while(response==0){
				if(inArray(quote.toLowerCase(),chatBot[j*2])){
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
					addText("\n-->IPL BOT\t"+chatBot[(j*2)+1][r]);
				}
				j++;
				if(j*2==chatBot.length-1 && response==0){
					response=1;
				}
			}
			
			//-----default--------------
			if(response==1){
				int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
				addText("\n-->IPL BOT\t"+chatBot[chatBot.length-1][r]);
			}
			addText("\n");
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for(int i=0;i<str.length;i++){
			if(str[i].equals(in)){
				match=true;
			}
		}
		return match;
	}
}