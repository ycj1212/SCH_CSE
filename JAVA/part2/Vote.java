import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Vote extends JFrame implements ActionListener {
	ArrayList<MyPanel> list = new ArrayList<MyPanel>();
	ArrayList<Integer> count = new ArrayList<Integer>();
	JPanel panel = new JPanel();
	MyPanel p1, p2;
	JButton add_button = new JButton("추가하기");
	JButton remove_button = new JButton("삭제하기");
	JButton vote_button = new JButton("투표하기");
	JButton result_button = new JButton("결과보기");
	JLabel label = new JLabel("투표 목록이 없습니다.");
	ButtonGroup group = new ButtonGroup();
	
    class MyPanel extends JPanel {
		JRadioButton radiobutton;
		JLabel label;
		JLabel image;
		ImageIcon ii;
		
		public MyPanel() {
			super();
		}

        public MyPanel(int top, int left, int bottom, int right) {
            setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
		}

		public MyPanel(String name, String imagePath) {
            setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			label = new JLabel(name);
			radiobutton = new JRadioButton();
			ii = new ImageIcon(imagePath);
			image = new JLabel(ii);

			label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			radiobutton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			image.setAlignmentX(JComponent.CENTER_ALIGNMENT);
			
			add(image);
			add(label);
			add(radiobutton);
		}

		public JRadioButton getRadioButton() {
			return radiobutton;
		}
		
		public String getName() {
			return label.getText();
		}
	}

    public Vote() {
		setTitle("제목입니당");
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
        label.setFont(new Font("돋움", Font.PLAIN, 50));
		label.setHorizontalAlignment(JLabel.CENTER);
		
        add_button.setPreferredSize(new Dimension(200, 50));
        add_button.setFont(new Font("돋움", Font.PLAIN, 30));
		add_button.addActionListener(this);

        vote_button.setPreferredSize(new Dimension(200, 50));
        vote_button.setFont(new Font("돋움", Font.PLAIN, 30));
		vote_button.addActionListener(this);
		vote_button.setEnabled(false);

        remove_button.setPreferredSize(new Dimension(200, 50));
        remove_button.setFont(new Font("돋움", Font.PLAIN, 30));
		remove_button.addActionListener(this);
		remove_button.setEnabled(false);

        result_button.setPreferredSize(new Dimension(200, 50));
        result_button.setFont(new Font("돋움", Font.PLAIN, 30));
		result_button.addActionListener(this);
		result_button.setEnabled(false);

		p1 = new MyPanel(100, 0, 50, 0);
		p1.add(label);

		p2 = new MyPanel(0, 0, 0, 0);
		p2.setLayout(new GridLayout(2, 2, 10, 10));
		p2.add(add_button);
		p2.add(remove_button);
		p2.add(vote_button);
		p2.add(result_button);
		p2.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        panel.setLayout(new BorderLayout());
		panel.add(p1, BorderLayout.CENTER);
        panel.add(p2, BorderLayout.SOUTH);
        
        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll, BorderLayout.CENTER);
        setVisible(true);
	}
 
	public void addContent() {
		JFrame frame = new JFrame();
		frame.setTitle("목록 추가");
		frame.setSize(600, 300);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		
		JLabel label1 = new JLabel("추가할 목록을 입력하세요");
		JLabel label2 = new JLabel("내용");
		JLabel label3 = new JLabel("이미지(선택)");
		JTextField textField1 = new JTextField(30);
		JTextField textField2 = new JTextField(30);
		JButton button = new JButton("추가");

		label1.setFont(new Font("돋움", Font.PLAIN, 40));
		button.addActionListener(l -> {
			if (textField1.getText().equals("")) {}
			else {
				list.add(new MyPanel(textField1.getText(), textField2.getText()));
				count.add(0);
				update();
			}
			frame.dispose();
		});
		
		p1.add(label1);
		p2.add(label2);
		p2.add(textField1);
		p3.add(label3);
		p3.add(textField2);
		p4.add(button);
		
		p2.setPreferredSize(new Dimension(500, 50));
		p2.setMaximumSize(p2.getPreferredSize());
		p2.setMinimumSize(p2.getPreferredSize());
		p2.setBorder(BorderFactory.createEmptyBorder(0, 48, 0, 0));

		p3.setPreferredSize(new Dimension(500, 50));
		p3.setMaximumSize(p3.getPreferredSize());
		p3.setMinimumSize(p3.getPreferredSize());
		
		p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
		p5.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		p5.setPreferredSize(new Dimension(500, 100));
		p5.setMaximumSize(p5.getPreferredSize());
		p5.setMinimumSize(p5.getPreferredSize());
		p5.add(p2);
		p5.add(p3);
		
		panel.setLayout(new BorderLayout());
		panel.add(p1, BorderLayout.NORTH);
		panel.add(p5, BorderLayout.CENTER);
		panel.add(p4, BorderLayout.SOUTH);

        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll, BorderLayout.CENTER);
	}
	
	public void removeContent() {
		JFrame frame = new JFrame();
		frame.setTitle("목록 제거");
		frame.setSize(600, 300);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JLabel label = new JLabel("제거할 목록을 선택하세요");
		label.setFont(new Font("돋움", Font.PLAIN, 40));
		
		ArrayList<JCheckBox> checkBox = new ArrayList<>();
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		for (int i=0; i<list.size(); i++) {
			checkBox.add(new JCheckBox(list.get(i).getName()));
			checkBox.get(i).setAlignmentX(JComponent.CENTER_ALIGNMENT);
			p2.add(checkBox.get(i));
		}
		
		JButton button = new JButton("제거");
		button.addActionListener(l -> {
			for (int i=0; i<checkBox.size(); i++) {
				if (checkBox.get(i).isSelected()) {
					checkBox.remove(i);
					list.remove(i);
					count.remove(i);
					update();
				}
			}
			frame.dispose();
		});
		
		p1.add(label);
		p3.add(button);
		
		panel.setLayout(new BorderLayout());
		panel.add(p1, BorderLayout.NORTH);
		panel.add(p2, BorderLayout.CENTER);
		panel.add(p3, BorderLayout.SOUTH);

        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll, BorderLayout.CENTER);
	}
	
	public void printResult() {
		JFrame frame = new JFrame();
		frame.setTitle("결과 출력");
		frame.setSize(600, 300);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JLabel label = new JLabel("결과");
		label.setFont(new Font("돋움", Font.PLAIN, 40));
		
		JLabel[] labels = new JLabel[list.size()];
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		for (int i=0; i<list.size(); i++) {
			labels[i] = new JLabel(list.get(i).getName() + ": " + count.get(i).toString());
			labels[i].setAlignmentX(JComponent.CENTER_ALIGNMENT);
			p2.add(labels[i]);
		}
		// 내림차순으로 바꿔보자
		
		p1.add(label);

		panel.setLayout(new BorderLayout());
		panel.add(p1, BorderLayout.NORTH);
		panel.add(p2, BorderLayout.CENTER);
		panel.add(p3, BorderLayout.SOUTH);

        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll, BorderLayout.CENTER);
	}

	public void doVote() {
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getRadioButton().isSelected()) {
				count.set(i, count.get(i)+1);
				break;
			}
		}
	}
	
	public void update() {
		getContentPane().removeAll();
		panel.removeAll();
		group.clearSelection();
		JPanel p = new JPanel();

		for (int i=0; i<list.size(); i++) {
			p.add(list.get(i));
			group.add(list.get(i).getRadioButton());
		}
		
		if (list.size() != 0) {
			panel.add(p, BorderLayout.CENTER);
		} else {
			panel.add(p1, BorderLayout.CENTER);
		}
		panel.add(p2, BorderLayout.SOUTH);
		
        JScrollPane scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroll, BorderLayout.CENTER);
		
		vote_button.setEnabled(true);
		remove_button.setEnabled(true);
		result_button.setEnabled(true);
		
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("추가하기")) {
			addContent();
		}
		else if (e.getActionCommand().equals("삭제하기")) {
			removeContent();
		}
		else if (e.getActionCommand().equals("투표하기")) {
			doVote();
			JOptionPane.showMessageDialog(this, "투표 완료!");
		}
		else if (e.getActionCommand().equals("결과보기")) {
			printResult();
		}
	}
	
	public static void main(String[] args) {
		Vote v = new Vote();
	}
}