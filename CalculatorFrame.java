import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    private JTextField display;

    private double firstNumber = 0;
    private String operator = "";
    private boolean startNew = true;

    public CalculatorFrame() {

        setTitle("Calculator");
        setSize(360, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBackground(Color.BLACK);
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(root);

        // ================= DISPLAY =================
        display = new JTextField("0");
        display.setFont(new Font("Segoe UI", Font.BOLD, 40));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        root.add(display, BorderLayout.NORTH);

        // ================= BUTTON GRID =================
        JPanel grid = new JPanel(new GridLayout(5, 4, 10, 10));
        grid.setBackground(Color.BLACK);
        root.add(grid, BorderLayout.CENTER);

        // Row 1
        JButton ac = light("AC");
        JButton percent = light("%");
        JButton back = light("←");
        JButton divide = operator("÷");

        // Row 2
        JButton b7 = dark("7");
        JButton b8 = dark("8");
        JButton b9 = dark("9");
        JButton multiply = operator("×");

        // Row 3
        JButton b4 = dark("4");
        JButton b5 = dark("5");
        JButton b6 = dark("6");
        JButton minus = operator("-");

        // Row 4
        JButton b1 = dark("1");
        JButton b2 = dark("2");
        JButton b3 = dark("3");
        JButton plus = operator("+");

        // Row 5
        JButton b00 = dark("00");
        JButton b0 = dark("0");
        JButton dot = dark(".");
        JButton equals = equals("=");

        // Add to grid
        grid.add(ac); grid.add(percent); grid.add(back); grid.add(divide);
        grid.add(b7); grid.add(b8); grid.add(b9); grid.add(multiply);
        grid.add(b4); grid.add(b5); grid.add(b6); grid.add(minus);
        grid.add(b1); grid.add(b2); grid.add(b3); grid.add(plus);
        grid.add(b00); grid.add(b0); grid.add(dot); grid.add(equals);

        // ================= ACTIONS =================
        JButton[] numbers = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b00};
        for (JButton b : numbers) {
            b.addActionListener(e -> appendNumber(b.getText()));
        }

        dot.addActionListener(e -> {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
                startNew = false;
            }
        });

        plus.addActionListener(e -> setOperator("+"));
        minus.addActionListener(e -> setOperator("-"));
        multiply.addActionListener(e -> setOperator("×"));
        divide.addActionListener(e -> setOperator("÷"));

        equals.addActionListener(e -> calculate());

        ac.addActionListener(e -> clear());

        percent.addActionListener(e -> {
            double val = Double.parseDouble(display.getText());
            display.setText(format(val / 100));
        });

        back.addActionListener(e -> {
            if (!startNew && display.getText().length() > 1) {
                display.setText(display.getText()
                        .substring(0, display.getText().length() - 1));
            } else {
                display.setText("0");
                startNew = true;
            }
        });

        setVisible(true);
    }

    // ================= LOGIC =================

    private void appendNumber(String n) {
        if (startNew) {
            display.setText(n.equals("00") ? "0" : n);
            startNew = false;
        } else {
            display.setText(display.getText() + n);
        }
    }

    private void setOperator(String op) {
        firstNumber = Double.parseDouble(display.getText());
        operator = op;
        startNew = true;
    }

    private void calculate() {
        double second = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator) {
            case "+": result = firstNumber + second; break;
            case "-": result = firstNumber - second; break;
            case "×": result = firstNumber * second; break;
            case "÷":
                if (second == 0) {
                    display.setText("Error");
                    startNew = true;
                    return;
                }
                result = firstNumber / second;
                break;
            default: return;
        }

        display.setText(format(result));
        startNew = true;
    }

    private void clear() {
        display.setText("0");
        firstNumber = 0;
        operator = "";
        startNew = true;
    }

    private String format(double v) {
        if (v == (long) v)
            return String.valueOf((long) v);
        return String.valueOf(v);
    }

    // ================= STYLES =================

    private JButton dark(String t) {
        JButton b = base(t);
        b.setBackground(new Color(45, 45, 45));
        return b;
    }

    private JButton light(String t) {
        JButton b = base(t);
        b.setBackground(new Color(90, 90, 90));
        return b;
    }

    private JButton operator(String t) {
        JButton b = base(t);
        b.setBackground(new Color(255, 149, 0));
        return b;
    }

    private JButton equals(String t) {
        JButton b = operator(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 28));
        return b;
    }

    private JButton base(String t) {
        JButton b = new JButton(t);
        b.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        return b;
    }

    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
