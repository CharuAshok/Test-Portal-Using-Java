import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class TestPortal extends JFrame implements ActionListener
 {
	JLabel l;
	JRadioButton rb[] = new JRadioButton[5];
	JButton Previous,Next, Bookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	TestPortal(String s) 
                {
		super(s);
		l = new JLabel();
		add(l);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) 
                {
			rb[i] = new JRadioButton();
			add(rb[i]);
			bg.add(rb[i]);
		}
                Previous=new JButton("Previous");
		Next = new JButton("Next");
		Bookmark = new JButton("Bookmark");
                Previous.addActionListener(this);
		Next.addActionListener(this);
		Bookmark.addActionListener(this);
		add(Next);
                add(Previous);
		add(Bookmark);
		set();
		l.setBounds(30, 40, 450, 20);
		rb[0].setBounds(50, 80, 450, 20);
                rb[1].setBounds(50, 110, 200, 20);
		rb[2].setBounds(50, 140, 200, 20);
		rb[3].setBounds(50, 170, 200, 20);
                Previous.setBounds(50, 240, 100, 30);
		Next.setBounds(200, 240, 100, 30);
		Bookmark.setBounds(350, 240, 130, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 400);
	}

	// Action Events
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Next) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) 
                        {
				Next.setEnabled(false);
				Bookmark.setText("View My Score");
			}
		}
                if (e.getSource() == Previous) {
			if (check())
				count = count - 1;
			current--;
			set();
			if (current == 1) 
                        {
				Previous.setEnabled(false);
				Bookmark.setText("View My Score");
			}
		}

		if (e.getActionCommand().equals("Bookmark")) {
			JButton b = new JButton("Bookmark" + x);
			b.setBounds(480, 20 + 30 * x, 100, 30);
			add(b);
			b.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				Bookmark.setText("View My Score");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y+1];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("View My Score")) {
			if (check())
				count = count + 1;
			current++;
                        JOptionPane.showMessageDialog(this, "Congrats! You have Scored  " + count);
			System.exit(0);
		}
	}

	// Declaring Questions
	void set() {
		rb[4].setSelected(true);
		if (current == 0) {
			l.setText("Question 1:  Today it is Thursday.After 132 days,it will be?");
			rb[0].setText("Monday");
			rb[1].setText("Sunday");
			rb[2].setText("Wednesday");
			rb[3].setText("Thursday");
		}
		if (current == 1) {
			l.setText("Question 2: A train 120 meters long is running with a speed of 60 km/hr. In what time will it pass a boy who is running at 6 km/hr in the direction opposite to that in which the train is going?");
			rb[0].setText("6.54 sec");
			rb[1].setText("44.32 sec");
			rb[2].setText("55 sec");
			rb[3].setText("30.2 sec");
		}
		if (current == 2) {
			l.setText("Question 3: Devesh can cover a certain distance in 1 hour 24 minutes by covering two-third of the distance at 6 km/hour and the rest at 7 km/hr. Calculate total distance?");
			rb[0].setText("8 km");
			rb[1].setText("9 km");
			rb[2].setText("6 km");
			rb[3].setText("7/5 km");
		}
		if (current == 3) {
			l.setText("Question  4: Find the H.C.F, if the numbers are in the ratio of 4 : 5 : 6 and their L.C.M. is 2400?");
			rb[0].setText("35");
			rb[1].setText("20");
			rb[2].setText("40");
			rb[3].setText("67");
		}
		if (current == 4) {
			l.setText("Question 5: What is the value of c , If 8 is 4% of a, and 4 is 8% of b. c equals b/a?");
			rb[0].setText("12");
			rb[1].setText("1/4");
			rb[2].setText("0.155");
			rb[3].setText("None of these");
		}
		if (current == 5) {
			l.setText("Question 6: P and Q take part in 100 m race. P runs at 6kmph. P gives Q a start of 8 m and still beats him by 8 seconds. The speed of Q is?");
			rb[0].setText("6.14 kmph");
			rb[1].setText("15.2 kmph");
			rb[2].setText("5 kmph");
			rb[3].setText("4.86 kmph");
		}
		if (current == 6) {
			l.setText("Question 7:  Find the speed of the boat in still water, if a boat covers a certain distance upstream in 2 hours, while it comes back in 1`1/2` hours. If the speed of the stream be 3 kmph?");
			rb[0].setText("12 kmph");
			rb[1].setText("18 kmph");
			rb[2].setText("21 kmph");
			rb[3].setText("24 kmph");
		}
		if (current == 7) {
			l.setText("Question 8:  In covering a distance of 40 km, Kamlesh takes 2 hours more than Pankaj. If Kamlesh doubles his speed, then he would take 1 hour less than Pankaj. Then what is Kamlesh's speed?");
			rb[0].setText("11 kmph");
			rb[1].setText("5 kmph");
			rb[2].setText("9 kmph");
			rb[3].setText("6 kmph");
		}
		if (current == 8) {
			l.setText("Question 9: Find the speed of the train, if a train 142 m long passes a pole in 6 seconds?");
			rb[0].setText("77.2 km/hr");
			rb[1].setText("79.6 km/hr");
			rb[2].setText("84.9 km/hr");
			rb[3].setText("79.2 km/hr");
		}
		if (current == 9) {
			l.setText("Question 10: The rate at which a sum becomes four times of itself in 25 years at S.I.,will be?");
			rb[0].setText("30%");
			rb[1].setText("25%");
			rb[2].setText("12%");
			rb[3].setText("49%");
		}
		l.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			rb[j].setBounds(50, 80 + i, 200, 20);
	}

	// Declaring Answers for those questions
	boolean check() {
		if (current == 0)
			return (rb[2].isSelected());
		if (current == 1)
			return (rb[0].isSelected());
		if (current == 2)
			return (rb[2].isSelected());
		if (current == 3)
			return (rb[1].isSelected());
		if (current == 4)
			return (rb[1].isSelected());
		if (current == 5)
			return (rb[3].isSelected());
		if (current == 6)
			return (rb[2].isSelected());
		if (current == 7)
			return (rb[1].isSelected());
		if (current == 8)
			return (rb[2].isSelected());
		if (current == 9)
			return (rb[3].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new TestPortal("TestPortal");
	}

}