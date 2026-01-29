# 🧮 Java Swing Calculator (OnePlus Style)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)
![Platform](https://img.shields.io/badge/Platform-Desktop-lightgrey?style=for-the-badge)

A clean, professional **Calculator Desktop Application** built using **pure Java (Swing)**.  
This project is inspired by the **OnePlus Nord Calculator UI** and focuses on **clean design, solid logic, and interview-ready code**.

---

## 🚀 Features

- Modern dark UI inspired by OnePlus Calculator
- Basic arithmetic operations:
  - Addition (+)
  - Subtraction (−)
  - Multiplication (×)
  - Division (÷)
- Extra calculator features:
  - AC (All Clear)
  - Backspace
  - Percentage (%)
  - Plus/Minus toggle (+/−)
  - Double Zero (00)
- Handles edge cases:
  - Division by zero
  - Clean integer / decimal output
- Keyboard-free, button-driven UI
- Fully event-driven using Java Swing

---

## 🛠️ Tech Stack

- **Language:** Java  
- **GUI Framework:** Java Swing  
- **IDE:** IntelliJ IDEA  
- **Architecture:** Single-class (simplified for learning & interviews)

---

## 📸 UI Preview

> Inspired by OnePlus Nord Calculator  
> Dark theme with orange operator buttons for clarity and usability

---

## 🧠 Project Logic Overview

- Uses **event-driven programming** with `ActionListener`
- Maintains calculator state using:
  - `firstNumber`
  - `operator`
  - `startNewNumber`
- Clean separation of responsibilities using helper methods:
  - `appendNumber()`
  - `setOperator()`
  - `calculate()`
  - `clearAll()`
  - `toggleSign()`

----------------------------

## 🧪 Edge Cases Handled

- Prevents multiple decimal points
- Shows `Error` on division by zero
- Automatically removes `.0` from whole number results
- Resets calculator state correctly after each calculation

------------------------------------------------------------------------------

## ▶️ How to Run

1. Clone the repository
   ```bash
   git clone https://github.com/your-username/java-swing-calculator.git
2.Open the project in IntelliJ IDEA

3.Run CalculatorFrame.java

4.Enjoy 🚀

--------------------------

👨‍💻 Author

Abhishek Karande
B.Tech IT | Java Developer | Swing GUI Projects

This project was built to strengthen core Java concepts and demonstrate clean desktop application development.

-----------------------------------------

⭐ If you like this project

Give it a ⭐ on GitHub — it really helps!
