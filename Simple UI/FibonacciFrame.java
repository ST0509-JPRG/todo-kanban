import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FibonacciFrame extends JFrame {
    private JTextField inputField;
    private JButton generateButton;
    private JTextArea displayArea;

    public FibonacciFrame() {
        // Set up the frame
        setTitle("Fibonacci Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for input field and button
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputField = new JTextField(10); // Set the column width for the input field
        generateButton = new JButton("Generate");

        inputPanel.add(inputField);
        inputPanel.add(generateButton);

        add(inputPanel, BorderLayout.NORTH);

        // Create text area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        // Use a JScrollPane to ensure the text area can scroll if needed
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

        // Add button action listener
        generateButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    generateFibonacci();
                }
            }
        );
    }

    private void generateFibonacci() {
        try {
            int n = Integer.parseInt(inputField.getText());
            if (n <= 0) {
                displayArea.setText("Please enter a positive integer.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            int a = 0, b = 1;
            sb.append(a).append("\n");

            for (int i = 1; i < n; i++) {
                sb.append(b).append("\n");
                int temp = b;
                b = a + b;
                a = temp;
            }

            displayArea.setText(sb.toString());
        } catch (NumberFormatException ex) {
            displayArea.setText("Invalid input. Please enter a valid integer.");
        }
    }

    public static void main(String[] args) {
        // Run the GUI code on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FibonacciFrame().setVisible(true);
            }
        });
    }
}
