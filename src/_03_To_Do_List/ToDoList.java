package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */

	public static void main (String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton add = new JButton();
		JButton view = new JButton();
		JButton remove = new JButton();
		JButton save = new JButton();
		JButton load = new JButton();
		ArrayList<String> tasks = new ArrayList<>();

		frame.setVisible(true);
		frame.add(panel);

		add.setText("Add Task");
		view.setText("View Tasks");
		remove.setText("Remove Task");
		save.setText("Save as List");
		load.setText("Load List");

		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		frame.setTitle("ToDoList");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

		add.addActionListener((e) -> {
			String tas = JOptionPane.showInputDialog(null, "What task would you like to add?");
			tasks.add(tas);
		});
		view.addActionListener((e) -> {
			if (tasks.isEmpty()) {

				try {
					BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/todolist.txt"));

					String line = br.readLine();

					while(line != null){
						if (line.isEmpty()) {
						} else {
							tasks.add(line);
						}

						line = br.readLine();
					}

					br.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				}

			}
			JOptionPane.showMessageDialog(null, tasks.toString());
		});
		remove.addActionListener((e) -> {
			String r = JOptionPane.showInputDialog(null, "Enter the number of the task you want to remove.");
			tasks.remove(Integer.parseInt(r));
		});
		save.addActionListener((e) -> {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/todolist.txt");

				String file = "";

				for (int i = 0; i < tasks.size(); i++) {
					file = file + "\n" + tasks.get(i);
				}

				fw.write(file);
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		load.addActionListener((e) -> {
			String file = JOptionPane.showInputDialog(null, "Enter the name of the file you want to load.");

			tasks.clear();

			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/" + file));

				String line = br.readLine();

				while(line != null){
					if (line.isEmpty()) {
					} else {
						tasks.add(line);
					}

					line = br.readLine();
				}

				br.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}

		});
	}}
