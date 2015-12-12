/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DataBaseManager.DataBaseController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Player;

/**
 *
 * @author Florent Plomb <plombf at gmail.com>
 */
public class ScoreView extends JFrame {

    public ScoreView() {
        super();

        setTitle("Score View");
        JPanel container = new JPanel();
        JScrollPane scrPane = new JScrollPane(container);
        add(scrPane);

        this.setVisible(true);

        ArrayList<Player> players = new ArrayList<Player>();
        players = DataBaseController.getPlayerBD();
        Object[][] donnees = new Object[players.size()][4];
        int i = 0;
        for (Player p : players) {
            int j = 0;
            donnees[i][j] = p.getName();
            donnees[i][j + 1] = p.getPoint();
            donnees[i][j + 2] = p.getMove();
            donnees[i][j + 3] = i + 1;
            i++;
        }

        String[] entetes = {"Player", "Points", "Move", "Rank"};

        JTable table = new JTable(donnees, entetes);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(table, BorderLayout.CENTER);

        pack();
    }
}