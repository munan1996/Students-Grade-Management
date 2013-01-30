package main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.org.apache.bcel.internal.generic.NEW;

import score.InputScoreDialog;
import score.QueryScoreDialog;
import user.LoginDialog;

public class MainFrame extends JFrame implements ActionListener{
	JMenuBar  menubar = new JMenuBar();
	
	JMenu   userMenu = new JMenu("�û�����");
	//JMenuItem  teacherMenuItem = new JMenuItem("��ʦ�û�����");
	JMenuItem  passMenuItem = new JMenuItem("�޸�����");
	JMenuItem  exitMenuItem = new JMenuItem("�˳�ϵͳ");

	JMenu   gradeMenu = new JMenu("�ɼ�����");
	JMenuItem inputMenuItem = new JMenuItem("�ɼ�¼��");
	JMenuItem queryMenuItem = new JMenuItem("�ɼ���ѯ");

	JMenu   courseMenu = new JMenu("�γ̹���");
	JMenuItem courseCatalogMenuItem = new JMenuItem("����Ŀ¼����");
	JMenuItem studentListMenuItem = new JMenuItem("�γ���������");
	
	JMenu   studentMenu = new JMenu("ѧ������");
	JMenuItem addStudentMenuItem = new JMenuItem("���ѧ��");
	JMenuItem updateStudentMenuItem = new JMenuItem("�޸�ѧ��");
	JMenuItem queryStudentMenuItem = new JMenuItem("ѧ����ѯ");
	
	JMenu teacherMenu = new JMenu("��ʦ����");
	JMenuItem addTeacherMenuItem = new JMenuItem("��ӽ�ʦ");
	JMenuItem updateTeacherMenuItem = new JMenuItem("�޸Ľ�ʦ");
	JMenuItem queryTeacherMenuItem = new JMenuItem("��ʦ��ѯ");	 
	
	
	JLabel  welcomeLabel = new JLabel("��ӭʹ��ѧ���ɼ�����ϵͳ");
	
	LoginDialog  loginDialog ;
	InputScoreDialog inputScoreDialog;
	QueryScoreDialog queryScoreDialog;
	public MainFrame(){
		setMainFrame();
		
	}
	private void setMainFrame(){
		this.setTitle("ѧ���ɼ�����ϵͳ");
		//�������˵�
		this.setJMenuBar(menubar);
		menubar.add(userMenu);
		menubar.add(gradeMenu);
		menubar.add(courseMenu);
		menubar.add(studentMenu);
		menubar.add(teacherMenu);
		//�����û�����˵�
		//userMenu.add(teacherMenuItem);
		userMenu.add(passMenuItem);
		userMenu.add(exitMenuItem);
		//����ɼ�����˵�
		gradeMenu.add(inputMenuItem);
		gradeMenu.add(queryMenuItem);
		//����γ̹���˵�
		courseMenu.add(courseCatalogMenuItem);
		courseMenu.add(studentListMenuItem);
		//����ѧ������˵�
		studentMenu.add(addStudentMenuItem);
		studentMenu.add(updateStudentMenuItem);
		studentMenu.add(queryStudentMenuItem);
		//�����ʦ����˵�
		teacherMenu.add(addTeacherMenuItem);
		teacherMenu.add(updateTeacherMenuItem);
		teacherMenu.add(queryTeacherMenuItem);
		//���컶ӭҳ��
		welcomeLabel.setFont(new java.awt.Font("DialogInput", 1, 44));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(Color.red);
		this.getContentPane().add(welcomeLabel);

		//Ϊ���˵�ע�������
		exitMenuItem.addActionListener(this);
		passMenuItem.addActionListener(this);
		inputMenuItem.addActionListener(this);
		queryMenuItem.addActionListener(this);

		//��ʾϵͳ������
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		

		//������������¼�Ի���
		loginDialog = new LoginDialog(this);	
		
	}
	public void actionPerformed(ActionEvent e) {
		//���˵�����
		if(e.getSource()==exitMenuItem){//�˳�ϵͳ
			if(JOptionPane.showConfirmDialog(this, "ȷ��Ҫ�˳�ϵͳ��","�˳�",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				System.exit(0);
			}			
		}else if(e.getSource()==inputMenuItem){//¼��ɼ�
			//�����ɼ�¼�����
			if(inputScoreDialog==null){
				inputScoreDialog = new InputScoreDialog(this);
			}
			inputScoreDialog.setVisible(true);
		}else if(e.getSource()==queryMenuItem){//��ѯ�ɼ�
			//�����ɼ���ѯ���
			if(queryScoreDialog==null){
				queryScoreDialog = new QueryScoreDialog(this);
			}
			queryScoreDialog.setVisible(true);
		}
		
	}
}
