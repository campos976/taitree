/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.thinkstream.examples;

import co.thinkstream.main.TaiLogicUnit;
import co.thinkstream.struct.TaiJButton;
import co.thinkstream.struct.TaiNode;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author test
 */
public class TaiTreeGUI implements ActionListener {

    private JTextField fileField;
    private List<TaiNode> taiTree;
    private JFrame frame;
    private JPanel contentPanel;

    public TaiTreeGUI() {

        frame = new JFrame("TaiTree App");

//2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpringLayout spring = new SpringLayout();
        JPanel ribbonPanel = new JPanel();
        JPanel containerPanel = new JPanel(spring);
        contentPanel = new JPanel();

//        ribbonPanel.setBackground(Color.pink);
        contentPanel.setBackground(Color.LIGHT_GRAY);

        containerPanel.add(ribbonPanel);
        containerPanel.add(contentPanel);

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));

        spring.putConstraint(SpringLayout.NORTH, ribbonPanel, 0, SpringLayout.NORTH, containerPanel);
        spring.putConstraint(SpringLayout.EAST, ribbonPanel, 0, SpringLayout.EAST, containerPanel);
        spring.putConstraint(SpringLayout.WEST, ribbonPanel, 0, SpringLayout.WEST, containerPanel);
        spring.putConstraint(SpringLayout.SOUTH, ribbonPanel, 50, SpringLayout.NORTH, containerPanel);

        spring.putConstraint(SpringLayout.NORTH, contentPanel, 0, SpringLayout.SOUTH, ribbonPanel);
        spring.putConstraint(SpringLayout.EAST, contentPanel, 0, SpringLayout.EAST, containerPanel);
        spring.putConstraint(SpringLayout.WEST, contentPanel, 0, SpringLayout.WEST, containerPanel);
        spring.putConstraint(SpringLayout.SOUTH, contentPanel, 0, SpringLayout.SOUTH, containerPanel);
        setupRibbonPanel(ribbonPanel);

        frame.setContentPane(containerPanel);
        frame.setPreferredSize(new Dimension(600, 500));
//4. Size the frame.
        frame.pack();

//5. Show it.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new TaiTreeGUI();
    }

    private void setupRibbonPanel(JPanel ribbonPanel) {
        JLabel promp = new JLabel("TaiTree File (example:mood.tai)");
        fileField = new JTextField(15);
        JButton runFileBtn = new JButton("Run File");
        runFileBtn.addActionListener(this);
        fileField.addActionListener(this);
        fileField.setText("mood.tai");
        ribbonPanel.add(promp);
        ribbonPanel.add(fileField);
        ribbonPanel.add(runFileBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("node button clicked")) {
            System.out.println("got action");
            Object source = e.getSource();
            if (source instanceof TaiJButton) {
                TaiJButton btn = (TaiJButton) source;
                TaiNode node = btn.getNode();
                System.out.println("got the node");
                graphNode(node);
                // Go ahead and do what you like
            }
            return;
        } else {
            loadFile();
        }

    }

    private void graphNode(TaiNode node) {
        contentPanel.removeAll();
        if (!node.isIsEndNode()) {
            System.out.println("not end");
            JLabel label = new JLabel(node.getQuestion());
            contentPanel.add(label);
            TaiLogicUnit logic = new TaiLogicUnit();
            List<TaiNode> children = logic.getChildren(node, taiTree);//should make static
            for (int i = 0; i < children.size(); i++) {
                String answerString = children.get(i).getAnswer();
                TaiJButton answerBtn = new TaiJButton(children.get(i));
                answerBtn.setText(answerString);
                answerBtn.setActionCommand("node button clicked");
                answerBtn.addActionListener(this);
                contentPanel.add(answerBtn);
            }
        } else {
            System.out.println("it was end");
            JLabel label = new JLabel(node.getResult());
            contentPanel.add(label);
        }
        kickUi();
    }

    private void loadFile() {
        try {
            String fileName = fileField.getText();
            fileName = fileName.trim();
            if (fileName.isEmpty()) {
                return;
            }

            TaiLogicUnit logic = new TaiLogicUnit();
            taiTree = logic.jsonToJavaTree(new File(fileName));
            System.out.println("Total nodes loaded " + taiTree.size());
            if (taiTree.size() > 0) {
                TaiNode get = taiTree.get(0); //i am groot
                System.out.println("graphing root");
                graphNode(get);
            }
            return;
        } catch (IOException ex) {
            System.out.println("Problem loading file");
        }
        JOptionPane.showMessageDialog(frame, "Could not execute the file.");
    }

    private void kickUi() {
       frame.revalidate();
       frame.repaint();
    }

}
