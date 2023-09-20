import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SortScape extends JPanel {
    private int[] arr;
    private int arraySize = 50;
    
    public SortScape() {
        arr = new int[arraySize];
        generateRandomArray();
    }
    
    private void generateRandomArray() {
        Random rand = new Random();
        for (int i = 0; i < arraySize; i++) {
            arr[i] = rand.nextInt(500) + 1;
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawArray(g, arr);
    }
    
    private void drawArray(Graphics g, int[] arr) {
        int barWidth = getWidth() / arraySize;
        for (int i = 0; i < arraySize; i++) {
            int height = arr[i];
            g.fillRect(i * barWidth, getHeight() - height, barWidth, height);
        }
    }
    
    public void bubbleSort() {
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                repaint();
                try { Thread.sleep(50); } catch (InterruptedException e) {}
            }
        }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("SortScape - Sorting Algorithm Visualizer");
        SortScape sortScape = new SortScape();
        frame.add(sortScape);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortScape.bubbleSort();
            }
        });
        
        frame.add(startButton, BorderLayout.NORTH);
    }
}
