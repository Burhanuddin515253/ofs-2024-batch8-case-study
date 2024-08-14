import { Employee } from "./employee.js";
import fs from "fs";
import readline from "readline-sync";

let employee1 = new Employee(12345,"Alex",45200)
employee1.display();
fs.writeFile('file.json',JSON.stringify(employee1),(error) => {
    if (error) throw error;
  });
try {
    const jsonText = fs.readFileSync('file.json','utf8');
    const jsonData = JSON.parse(jsonText);
    console.log(jsonData);
} catch (error) {
    console.error('Error:', error.message);
}

