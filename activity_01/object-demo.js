import { Employee } from "./employee.js";
import fs from "fs";


let employee1 = new Employee(1245, "Alexaa", 46200);
let employee2 = new Employee(12456, "jackaa", 412200);
let employee3 = new Employee(456, "komkaa", 41);


employee1.display();


const filePath = 'file.json';


let existingData = [];

try {
   
    if (fs.existsSync(filePath)) {
        
        const jsonText = fs.readFileSync(filePath, 'utf8');
        
        
        existingData = JSON.parse(jsonText);

   
        console.log('Existing data:', existingData);

        
        if (!Array.isArray(existingData)) {
            console.error('Error: Existing data is not an array, resetting to empty array.');
            existingData = [];
        }
    }
} catch (error) {
    
    console.error('Error reading file:', error.message);
    existingData = [];
}

existingData.push(employee3);


fs.writeFile(filePath, JSON.stringify(existingData, null, 2), (error) => {
    if (error) throw error;
    console.log('File has been updated!');
});


try {
    const updatedJsonText = fs.readFileSync(filePath, 'utf8');
    const updatedJsonData = JSON.parse(updatedJsonText);
    console.log('Updated data:', updatedJsonData);
} catch (error) {
    console.error('Error reading updated file:', error.message);
}
