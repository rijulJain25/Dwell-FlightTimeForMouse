# Dwell-FlightTimeForMouse

# Abstract
This report presents the development of a Java program that calculates the dwell time and flight time of mouse clicks. The program utilizes the OpenCSV library for data handling, Swing and AWT for creating the graphical user interface, and incorporates CSV file generation and data storage. The report outlines the program's architecture, implementation details, and the functionality of the dwell time and flight time calculator.

# Introduction
The aim of this project was to develop a Java program capable of calculating the dwell time and flight time associated with mouse clicks. The program was built using OpenCSV, Swing, and AWT libraries to ensure efficient data handling and provide a user-friendly interface. The program allows users to capture mouse click events, calculate dwell time and flight time, and store the results in a CSV file.

# Frontend Design
The frontend of the program was implemented using the JFrame inheritance and the GridBagLayout manager. This choice of layout facilitated a flexible and organized arrangement of components in the user interface.

# CSV File Generation and Data Appending
To store the calculated results, the program generated a CSV file. If the file already existed, the program would append new values to it. The OpenCSV library was utilized to handle the reading and writing of data in CSV format. This approach ensured efficient data storage and easy retrieval for further analysis.

# Mouse Activity Class
The program included a separate class responsible for capturing mouse activity and calculating the dwell time and flight time. This class implemented the MouseListener interface and utilized the mousePressed and mouseReleased functions to track mouse events. On mouse release, the class calculated the dwell time and on mouse press, the flight time based on the time difference between mouse press and release events.

# Data Storage and Display
The Mouse Activity class also included a display method, which was called within the mouseReleased function. This method stored the calculated dwell time, flight time, and information about the mouse button clicked into the previously generated CSV file.
      
# Conclusion:
The developed Java program effectively calculates the dwell time and flight time of mouse clicks. Through the use of OpenCSV, Swing, and AWT libraries, the program provides a user-friendly interface for capturing and analyzing mouse activity. The integration of CSV file generation ensures data persistence and enables further analysis of user interaction patterns.
