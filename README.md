# Welcome to basic math calculator!

## Setup
- Run mvn package on the main directory
- Starting the server: java -cp target\day08-workshop-calculator-1.0-SNAPSHOT.jar calculator.Server \<portNo\> 
- Running the client: java -cp target\day08-workshop-calculator-1.0-SNAPSHOT.jar calculator.Client \<hostname\>:\<portNo\>

## Usage
Available commands:
- "add \<integer array\>"           Adds the numbers in the integer array.
- "subtract \<integer array\>"      Subtracts the numbers in the integer array from the integer in the first element of the array.
- "multiply \<integer array\>"      Multiplies the numbers in the integer array.
- "divide \<integer array\>"        Divides the numbers in the integer array from the integer in the first element of the array.
- "help"                            Displays the list of available commands.
- "quit"                            Ends the connection with the server.

### Note on \<integer array\>
- Integer array input should be delimited by spaces, e.g. "add 1 2 3 4"
