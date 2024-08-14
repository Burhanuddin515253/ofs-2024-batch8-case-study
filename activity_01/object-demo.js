import { Employee } from "./employee.js";
import fs from "fs";

// Create a new Employee instance
let employee1 = new Employee(1245, "Alexaa", 46200);
let employee2 = new Employee(12456, "jackaa", 412200);

// Display employee details
employee1.display();

// Define the path to the file
const filePath = 'file.json';

// Initialize existing data as an empty array
let existingData = [];

try {
    // Check if the file exists
    if (fs.existsSync(filePath)) {
        // Read the file content
        const jsonText = fs.readFileSync(filePath, 'utf8');
        
        // Parse the file content
        existingData = JSON.parse(jsonText);

        // Debugging: Log the existing data
        console.log('Existing data:', existingData);

        // Ensure that existingData is an array
        if (!Array.isArray(existingData)) {
            console.error('Error: Existing data is not an array, resetting to empty array.');
            existingData = [];
        }
    }
} catch (error) {
    // If there is an error reading or parsing the file, log the error and use an empty array
    console.error('Error reading file:', error.message);
    existingData = []; // Ensure that existingData is an array even if there was an error
}

// Append the new employee to the existing data
existingData.push(employee2);

// Write the updated data back to the file
fs.writeFile(filePath, JSON.stringify(existingData, null, 2), (error) => {
    if (error) throw error;
    console.log('File has been updated!');
});

// Display the updated content for verification
try {
    const updatedJsonText = fs.readFileSync(filePath, 'utf8');
    const updatedJsonData = JSON.parse(updatedJsonText);
    console.log('Updated data:', updatedJsonData);
} catch (error) {
    console.error('Error reading updated file:', error.message);
}
